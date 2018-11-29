package Basic;

import java.util.*;

public class CutVertex {

	enum color
	{
		WHITE,
		GREY,
		BLACK
	};
	static class Graph
	{
		private int vertices;
		private int edges;
		private color[] id;
		private int[] fup;
		private int[] depth;
		private int[] outdegree;
		private int[] parent;
		private List<List<Integer>> list = new LinkedList<>();
		public Graph(int v , int e)
		{
			this.vertices = v;
			this.edges = e;
			id = new color[v];
			fup = new int[v];
			depth = new int[v];
			outdegree = new int[v];
			parent = new int[v];
			for(int i = 0; i < v; i++)
			{
				list.add(new LinkedList<Integer>());
				id[i] = color.WHITE;
			}
		}
		void addEdge(int x , int y)
		{
			list.get(x).add(y);
			list.get(y).add(x);
		}
		void calculateFUP(int source , int p , int dep)
		{
			parent[source] = p;
			id[source] = color.GREY;
			fup[source] = dep;
			depth[source] = dep;
			Iterator<Integer> it = list.get(source).iterator();
			while(it.hasNext())
			{
				int temp = it.next();
				if(id[temp] == color.WHITE)
				{
					outdegree[source]++;
					calculateFUP(temp , source , dep + 1);
					fup[source] = Math.min(fup[source], fup[temp]);
				}
				else
				{
					if(temp != p)
					{
						fup[source] = Math.min(fup[source], depth[temp]);
					}
				}
			}
		}
		boolean cutVertexNot(int x)
		{
			if(parent[x] == -1)
			{
				if(outdegree[x] >= 1)
					return true;
				else
					return false;
			}
			else
			{
				Iterator<Integer> it = list.get(x).iterator();
				
				while(it.hasNext())
				{
					int temp = it.next();
					if(depth[x] <= fup[temp])
						return true;
				}
				return false;
			}
		}
}
	
	public static void main(String[] args)
	{
		Graph g = new Graph(7 , 7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.calculateFUP(0, -1 , 0);
		boolean val = g.cutVertexNot(3);
		if(val == true)
			System.out.println("It is a cut vertex");
		else
			System.out.println("It is NOT a cut vertex");
	}
}
