package ds;
import java.lang.*;
public class AVLTree {

	private class Node
	{
		private int data;
		private Node left;
		private Node right;
		private int height;
		
		public Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.height = 1;
		}
	}
	private static Node root = null;
	
	private int calculateHeight(Node n)
	{
		if (n == null)
			return 0;
		return 1 + Math.max(calculateHeight(n.left), calculateHeight(n.right));
	}
	
	private Node leftRotate(Node root)
	{
		Node temp = root.right;
		Node y = root.right.left;
		root.right.left = root;
		root.right = y;
		
		root.height = calculateHeight(root);
		temp.height = calculateHeight(temp);
		
		return temp;
	}
	private Node rightRotate(Node root)
	{
		Node temp = root.left;
		Node y = root.left.right;
		root.left.right = root;
		root.left = y;
		
		root.height = calculateHeight(root);
		temp.height = calculateHeight(temp);
		
		return temp;
	}
	public void insert(int data)
	{
		root = insert(root , data);
	}
	
	private Node insert(Node root, int data)
	{
		if(root == null)
			return new Node(data);
		else if(data > root.data)
			root.right = insert(root.right, data);
		else 
			root.left = insert(root.left, data);
		
		int balance = calculateHeight(root.left) - calculateHeight(root.right);
		if(balance > 1)
		{
			int bal2 = calculateHeight(root.left.left) - calculateHeight(root.left.right);
			if(bal2 >= 1)
				return rightRotate(root);
			else
			{
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		}
		if(balance < -1)
		{
			int bal2 = calculateHeight(root.right.left) - calculateHeight(root.right.right);
			if(bal2 <= -1)
				return leftRotate(root);
			else
			{
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}
		else
		{
			root.height = 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
		}
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
		AVLTree obj = new AVLTree();
		obj.insert(5);
		obj.insert(4);
		obj.insert(3);
		obj.insert(2);
		obj.insert(1);
		System.out.println("Preorder of given AVL tree is  --->");
		obj.preorder(root);

	}
}
