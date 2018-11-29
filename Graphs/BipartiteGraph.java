package Basic;

import java.util.*;

public class BipartiteGraph {

	enum color
	{
		WHITE,
		RED,
		GREEN
	};
	
	static class Graph 
	{
		int vertices;
		color[] id;
		int[] visited;
		List<List<Integer>> list = new LinkedList<>();
		Queue<Integer> qu = new LinkedList<>();
		public Graph(int v)
		{
			vertices = v;
			id = new color[v];
			visited = new int[v];
			for(int i = 0; i < v; i++)
			{
				list.add(new LinkedList<Integer>());
				id[i] = color.WHITE;
			}
		}
		void addEdge(int x , int y)
		{
			list.get(x).add(y);                //For Directed Graph
		}
		
		boolean isBipartite(int source , int[][] arr)
		{
			qu.add(source);
			id[source] = color.RED;
			
			while(!qu.isEmpty())
			{
				int x = qu.poll();
				
				if(arr[x][x] == 1)                //For Self loop
					return false;              
				
				
				for(int i = 0; i < vertices; i++)
				{					
				    if(arr[x][i] == 1 && id[i] == color.WHITE)
					{
						if(id[x] == color.RED)
							id[i] = color.GREEN;
						else
							id[i] = color.RED;
						
						qu.add(i);
					}
					else if(arr[x][i] == 1 && id[i] == id[x])
						return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		int [][]arr = {	{0, 1, 0, 1}, 
						{1, 0, 1, 0}, 
						{0, 1, 0, 1}, 
						{1, 0, 1, 0} };
		
		boolean val = g.isBipartite(0, arr);
		if(val == true)
			System.out.println("Graph is Bartite");
		else
			System.out.println("Graph is NOT Bartite");
	}
}
