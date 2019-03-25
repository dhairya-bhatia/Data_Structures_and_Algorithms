package Basic;
import java.util.*;

public class BFSTraversal {

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
		Queue<Integer> qu = new LinkedList<>();
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
			list.get(x).add(y);                //For Directed Graph
		}
		
		void bfsTraversal(int source)
		{
			qu.add(source);
			id[source] = color.GREY;
			while(!qu.isEmpty())
			{
				int x = qu.poll();
				System.out.println(x);
				Iterator<Integer> it = list.get(x).iterator();
				while(it.hasNext())
				{
					int temp = it.next();
					if(id[temp] == color.WHITE)
					{
						id[temp] = color.GREY;
						qu.add(temp);
					}
				}
				id[source] = color.BLACK;
			}
		}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(4 , 6);
			g.addEdge(0, 1); 
		    g.addEdge(0, 2); 
		    g.addEdge(1, 2); 
		    g.addEdge(2, 0); 
		    g.addEdge(2, 3); 
		    g.addEdge(3, 3); 
		    g.bfsTraversal(2);
	}
}