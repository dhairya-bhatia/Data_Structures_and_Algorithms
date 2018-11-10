package ds;

public class BST {
	class Node
	{
		int key , value;
		Node left , right;
		
		public Node()
		{
			key = 0;
			value = 0;
			left = null;
			right = null;
		}
		public Node(int k , int val)
		{
			key = k;
			value = val;
			left = null;
			right = null;
		}
	}
	Node root;
	public BST()
	{
		root = null;
	}
	public void put(int k , int val)
	{
		root = put(root , k , val);
	}
	private Node put(Node curr , int k , int val)
	{
		if(curr == null)
			return new Node(k , val);
		if(curr.key == k)
			curr.value = val;
		if(k > curr.key)
			curr.right = put(curr.right , k, val);
		else
			curr.left = put(curr.left , k , val);
		
		return curr;	
	}

	public int search(int k)
	{
		int ans = search(root , k);
		return ans;
	}
	private int search(Node root , int k)
	{
		int temp;
		if(root != null)
		{
			if(root.key == k)
				return root.value;
			if(k > root.key)
				 temp = search(root.right , k);
			else
				 temp = search(root.left , k);
		
			return temp;
		}
		else
			return 0;
	}
	public void inorder()
	{
		inorder(root);
	}
	public void preorder()
	{
		preorder(root);
	}
	public void postorder()
	{
		postorder(root);
	}
	
	private void inorder(Node root)
	{
		if(root != null) 
		{	
			inorder(root.left);
			System.out.println(root.key+"---- >"+root.value);
			inorder(root.right);
		}
	}
//	private int floor(int k)
//	{
//		
//	}
	private void preorder(Node root)
	{
		if(root != null)
		{
			System.out.println(root.key+"---- >"+root.value);
			preorder(root.left);
			preorder(root.right);
		}
	}
	private void postorder(Node root)
	{
		if(root != null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.println(root.key+"---- >"+root.value);
		}
	}
}
