package client;

import ds.*;

public class TestTree {

	public static void main(String[] args)
	{
		BST obj = new BST();
		obj.put(5, 3);
		obj.put(2 , 8);
		obj.put(3, 11);
		obj.put(4, 12);
		obj.put(7, 10);
		obj.put(6, 150);
		
		assert obj.search(3) == 11;
		assert obj.search(6) == 150;
		obj.put(3, 100);
		assert obj.search(3) == 100;
		System.out.println("Inorder is ");
		obj.inorder();
		System.out.println("Preorder is ");
		obj.preorder();
		System.out.println("Postorder is ");
		obj.postorder();
		
		System.out.println("All test cases passed");
	}
	
	
}
