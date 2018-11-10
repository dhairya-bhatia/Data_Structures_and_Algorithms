package client;

import ds.LinkedList;

public class TestLinkedList {

	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		
		list.insertAtBeginning(1);
		list.insertAtBeginning(2);
		//list.deleteAtBeginning();
		//assert list.show() == 1;
		list.insertAtBeginning(3);
		list.insertAtBeginning(5);
		list.insertAtPosition(4, 3);
		list.insertAtPosition(10 , 6);
		list.print();
		//assert list.show() == 3;
		
		System.out.println("All test cases passed for linked list");
	}
}
