package Basic;

import java.util.*;

public class MinimumSpanningTree {

	List<Edge> list = new LinkedList<>();

	class Edge implements Comparator<Edge>
	{		
		int src;
		int dest;
		int weight;
		
		void addEdge(int src , int dest , int weight)
		{
			Edge obj = new Edge();
			obj.src = src;
			obj.dest = dest;
			obj.weight = weight;
			list.add(obj);
			createNode(src);
			createNode(dest);
		}

		@Override
		public int compare(Edge e1, Edge e2) 
		{
			if(e1.weight <= e2.weight)
				return -1;
			else
				return 1;
		}
		
	}
	
	Map<Integer , Node> map = new HashMap<>();
	
	static class Node
	{
		int rank;
		Node parent;
		int value;
		
	}
		public void createNode(int v)
		{
			if(!map.containsKey(v))
			{
				Node node = new Node();
				node.value = v;
				node.rank = 0;
				node.parent = node;
				map.put(v , node);
			}
			
		}
		public boolean union(int src , int dest)
		{
			Node x = map.get(src);
			Node y = map.get(dest);
			Node parent1 = findParent(x);
			Node parent2 = findParent(y);
			
			if(parent1.value == parent2.value)
				return false;
			
			else
			{
				if(parent1.rank > parent2.rank)
					parent2.parent = parent1;
				else if(parent2.rank > parent1.rank)
					parent1.parent = parent2;
				else
				{
					parent1.rank++;
					parent2.parent = parent1;
				}
			}
			return true;
		}
		
//		public int findParent(int x)
//		{
//			return findParent(map.get(x)).value;
//		}
		
		private Node findParent(Node x)
		{
			Node parent = x.parent;
			if(parent != x)
			{
				parent = findParent(parent);
			}
			return parent;
		}
		
		public List<Edge> kruskalMST()
		{
			List<Edge> result = new LinkedList<>();
			Collections.sort(list , new Edge());
			for(int i = 0; i < list.size(); i++)
			{
				boolean ans = union(list.get(i).src, list.get(i).dest);
				if(ans == true)
					result.add(list.get(i));
					
			}
			return result;
			
		}
	
	
	public static void main(String[] args)
	{
		MinimumSpanningTree obj = new MinimumSpanningTree();
		Edge e = obj.new Edge();
		
		e.addEdge(0, 1, 10);
		e.addEdge(0, 2, 6);
		e.addEdge(0, 3, 5);
		e.addEdge(1, 3, 15);
		e.addEdge(2, 3, 4);
		
		List<Edge> result = new LinkedList<>();
		
		result = obj.kruskalMST();
		
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i).src+ " -----> " +result.get(i).dest + " == " + result.get(i).weight);
		
		
	}
}
