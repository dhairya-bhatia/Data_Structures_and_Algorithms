package Basic;
import java.util.*;

public class CreateGraph {
	
		int V;
		boolean arr[][];
		public CreateGraph(int V)
		{
			this.V = V;
			arr = new boolean[V][V];
		}		
		void addEdge(int x , int y)
		{
			arr[x][y] = true;
		}
	
	public static void main(String[] args)
	{
		int V = 5;
		CreateGraph obj = new CreateGraph(V);
		obj.addEdge(1, 3);                                              /* Adjacency Matrix  */
		obj.addEdge(1, 4);
		obj.addEdge(2, 1);
		System.out.println(obj.arr[1][3]);
	
		
		List<List<Integer>> list = new LinkedList<>();
		for(int i = 0; i < V; i++)
		{
			list.add(new LinkedList<Integer>());                         /*   Adjacency List   */
		}
		
		
		
	}
}
