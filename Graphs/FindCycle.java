package Basic;
import java.util.*;
public class FindCycle 
{
	enum color
	{
		WHITE,
		GREY,
		BLACK
	};
	
	static class Graph 
	{
		int vertices;
		int edges;
		color[] id;
		List<List<Integer>> list = new LinkedList<>();
		public Graph(int v , int e)
		{
			vertices = v;
			edges = e;
			id = new color[v];
			for(int i = 0; i < v; i++)
			{
				list.add(new LinkedList<Integer>());
				id[i] = color.WHITE;
			}
		}
		void addEdge(int x , int y)
		{
			list.get(x).add(y);
			list.get(y).add(x);                       // For Undirected Graph
		}
		
		void dfsFunc(int source)
		{
			id[source] = color.GREY;
			Iterator<Integer> it = list.get(source).iterator();
			while(it.hasNext())
			{
				int x = it.next();
				if(id[x] == color.WHITE)
					dfsFunc(x);
			}
			
			id[source] = color.BLACK;
			
		}
	
		boolean findCycle(int source , int parent)
		{
			id[source] = color.GREY;
			Iterator<Integer> it = list.get(source).iterator();
			while(it.hasNext())
			{
				int x = it.next();
				if(id[x] == color.WHITE)
					if(findCycle(x, source))
						return true;
				else
				{
					if(x != parent) {
						return true;     // It means there is and edge from grey to grey which means CYCLE exists
					}
				}
			}
			
			
			id[source] = color.BLACK;
			return false;
			
		}
	}
	
	
	public static void main(String[] args)
	{
		Graph g = new Graph(5 , 14);
		g.addEdge(0, 3);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
	
		boolean val = g.findCycle(0, -1);
		if(val == true)
			System.out.println("Cycle exists");
		else
			System.out.println("Cycle does not exist");
		
		
		
	}
}
