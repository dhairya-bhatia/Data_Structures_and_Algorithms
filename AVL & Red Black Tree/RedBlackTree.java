package ds;

public class RedBlackTree {

	private class Node
	{
		private int data;
		private Node left;
		private Node right;
		private boolean color;        /*      TRUE = RED   and   FALSE = BLACK        */
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.color = true;      //        every new node should be of RED color
		}
		
	}
	static Node root = null;
	
	private Node leftRotate(Node root)
	{
		Node temp = root.right;
		Node y = root.right.left;
		root.right.left = root;
		root.right = y;
		
		temp.color = root.color;
		root.color = true;
		
		return temp;
	}
	
	private Node rightRotate(Node root)
	{
		Node temp = root.left;
		Node y = root.left.right;
		root.left.right = root;
		root.left = y;
		
		temp.color = root.color;
		root.color = true;
		
		return temp;
	}
	
	private Node swapColors(Node root)
	{
		root.left.color = root.color;
		root.right.color = root.color;
		root.color = true;
		
		return root;
	}
	
	private boolean getColor(Node root) 
	{
		if (root == null)
			return false;
		
		return root.color;
	}
	
	public void insert(int data)
	{
		root = insert(root, data);
		root.color = false;        //Root's color is always black
	}
	
	private Node insert(Node root, int data)
	{
		if(root == null)
			return new Node(data);
		else if(data == root.data)
		{
			System.out.println("Data cannot have existing value ");
			return null;
		}
		else if(data < root.data)
			root.left = insert(root.left, data);
		else 
			root.right = insert(root.right, data);
		
		if(getColor(root.left) == false && getColor(root.right) == true) 
			root = leftRotate(root);
		if(getColor(root.left) == true && getColor(root.left.left) == true)
			root = rightRotate(root);
		if(getColor(root.left) == true && getColor(root.right) == true)
			root = swapColors(root);
	
		return root;
	}
	
	public void preorder(Node root)
	{
		if(root != null)
		{
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args)
	{
		RedBlackTree obj = new RedBlackTree();
		obj.insert(5);
		obj.insert(6);
		obj.insert(7);
		obj.insert(8);
		obj.insert(9);
		System.out.println("Preorder of given Red-Black tree is  --->");
		obj.preorder(root);
	}
	
}
