package Basic;

import java.util.*;

public class DFSTraversal {

	static int visit[] = new int[20];
	
	static void dfs(int x , List<Integer>[] list)
	{
		visit[x] = 1;
		System.out.println(x+" ");
		for(int i = 0; i < list[x].size(); i++)
		{
			int c = list[x].get(i);
			if(visit[c] != 0)
			{
			continue;
			}
			dfs(c , list);
		}
		visit[x] = 2;
	}
	
	static void insert(int x , int y, List<Integer>[] list)
	{
		list[x].add(y);
	}
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = sc.nextInt();
		
		List<Integer> list[] = new LinkedList[n];
		
		for(int i = 0; i < n; i++)
		{
			list[i] = new LinkedList<Integer>();
		}
		insert(0 , 1 , list);
		insert(0 , 2 , list);
		insert(1 , 2 , list);
		insert(2 , 0 , list);
		insert(2 , 3 , list);
		insert(3 , 3 , list);
		
		dfs(2 , list);
		
		sc.close();
	}
}
