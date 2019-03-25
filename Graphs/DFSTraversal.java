package Basic;

import java.util.*;

public class DFSTraversal {

	static class Graph 
	{
		int vertices;
		int edges;
		LinkedList<Integer>[] list;
		boolean[] visited;
		Queue<Integer> qu = new LinkedList<>();
		public Graph(int v , int e)
		{
			vertices = v;
			edges = e;
			visited = new boolean[v];
			list = new LinkedList[vertices];
			
			for(int i = 0; i < v; i++)
			{
				list[i] = new LinkedList<>();
			}
		}
		void addEdge(int x , int y)
		{
			list[x].add(y);                //For Directed Graph
		}
		
	
		void dfsTraversal(int source)
		{
			visited[source] = true;
			System.out.println(source);
			Iterator<Integer> it = list[source].iterator();
			while(it.hasNext())
			{
				int x = it.next();
				if(visited[x] == false)
				{
					dfsTraversal(x);
				}
			}
			
		}
	}
	public static void main(String[] args)
	{		
		Graph g = new Graph(4, 6);
		g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 2); 
	    g.addEdge(2, 0); 
	    g.addEdge(2, 3); 
	    g.addEdge(3, 3); 
	    g.dfsTraversal(2);
	 }
}
