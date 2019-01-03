package Basic;

import java.util.*;

public class DisjointSets {

	Map<Integer , Node> map = new HashMap<>();
	class Node
	{
		int value;
		Node parent;
		int rank;
	}
		public void createNewNode(int v)
		{
			Node node = new Node();
			node.value = v;
			node.rank = 0;
			node.parent = node;
			map.put(v, node);
		}
		public boolean union(int src , int dest)
		{
			Node x = map.get(src);
			Node y = map.get(dest);
			Node p1 = findParent(x);
			Node p2 = findParent(y);
			
			if(p1.value == p2.value)           //Their Parent is same
				return false;
			else
			{
				if(p1.rank > p2.rank)
					p2.parent = p1;
				else if(p2.rank > p1.rank)
					p1.parent = p2;
				else
				{
					p2.parent = p1;
					p1.rank += 1;        /* * If Rank of both is same then increment rank
				}                           *  and make any one of the two other's parent      */
			}
			return true;
			}
		}
		
		public int findParent(int p)
		{
			return findParent(map.get(p)).value;
		}
		
		private Node findParent(Node n)
		{
			
			Node parent = n.parent;
			if(parent == n)
			{
				return parent;
			}
			n.parent = findParent(n.parent);          //Path Compression
			
			return n.parent;
		}
		
		public static void main(String args[]) {
	        DisjointSets obj = new DisjointSets();
	        obj.createNewNode(1);
	        obj.createNewNode(2);
	        obj.createNewNode(3);
	        obj.createNewNode(4);
	        obj.createNewNode(5);
	        obj.createNewNode(6);
	        obj.createNewNode(7);

	        System.out.println(obj.union(1, 2));
	        System.out.println(obj.union(1, 2));     
	        obj.union(2, 3);
	        obj.union(4, 5);
	        obj.union(6, 7);
	        obj.union(5, 6);
	        obj.union(3, 7);

	        System.out.println(obj.findParent(1));
	        System.out.println(obj.findParent(2));
	        System.out.println(obj.findParent(3));
	        System.out.println(obj.findParent(4));
	        System.out.println(obj.findParent(5));
	        System.out.println(obj.findParent(6));
	        System.out.println(obj.findParent(7));
	}
}

	

