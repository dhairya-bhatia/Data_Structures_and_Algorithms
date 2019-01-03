package Basic;

import java.util.*;

public class TopologicalSort {

	static class Graph 
	{
		int vertices;
		int edges;
		List<List<Integer>> list;
		Queue<Integer> qu = new LinkedList<>();
		int[] indegree;
		
		public Graph(int v , int e)
		{
			vertices = v;
			edges = e;
			indegree = new int[v];
			list = new LinkedList<>();
			for(int i = 0; i < v; i++)
			{
				list.add(new LinkedList<Integer>());
			}
		}
		
	
		void addEdge(int x , int y)
		{
			list.get(x).add(y);                //For Directed Graph
		}
		void calculateIndegree()
		{
			for(int i = 0; i < list.size(); i++)
			{
				for(int j = 0; j < list.get(i).size(); j++)
				{
					int t = list.get(i).get(j);
					indegree[t]++;
				}
			}
		}
		
		List<Integer> topologicalSort()
		{
			calculateIndegree();
			
			List<Integer> result = new ArrayList<>();
			
			for(int i = 0; i < vertices; i++)
			{
				if(indegree[i] == 0)
					qu.add(i);
			}
			
			while(!qu.isEmpty())
			{
				int x = qu.poll();
				result.add(x);
				
				for(int i = 0; i < list.get(x).size(); i++)
				{
					int temp = list.get(x).get(i);
					indegree[temp]--;
					if(indegree[temp] == 0)
						qu.add(temp);
				}
			}
			return result;
		}
	}
	
	public static void main(String[] args)
	{
		Graph g = new Graph(5, 6);
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(2, 3); 
	    g.addEdge(2, 4);
	    
	    List<Integer> result = new ArrayList<>();
	    
	    result = g.topologicalSort();
	    
	    for(int i = 0; i < result.size(); i++)
	    	System.out.println(result.get(i));
	}
}
