package BST;

import java.util.Scanner;
class Student implements Comparable<Student>
{
	int roll_no;
	String name;
	double cgpa;
	
	public Student()
	{
		roll_no = 0;
		name = "";
		cgpa = 0.0f;
	}
	
	public Student(int r , String n , double grade)
	{
		roll_no = r;
		name = n;
		cgpa = grade;
	}
	public String toString()
	{
		return roll_no + " " + name + " " + cgpa;
	}

	@Override
	public int compareTo(Student s1) {
		
		Integer i = this.roll_no;
		Integer j = s1.roll_no;
		return i.compareTo(j);
	}
}

public class BST_Student {

	private class node
	{
		Student obj;
		node left;
		node right;
		
		public node(Student o)
		{
			obj = o;
			left = null;
			right = null;
		}
	}
	
		node root;
		
		
		public BST_Student()
		{
			root = null;
		}
		
		void insert_data(Student o)
		{
			root = insert(root, o);
		}
		
		void inorder_fun()
		{
			inorder(root);
		}
		node insert(node curr , Student o)
		{
			if(curr == null)
			{
				return new node(o);
			
			}
			int val = o.compareTo(curr.obj);
			
			if(val >= 1)
			{
				curr.right = insert(curr.right, o);
			}
			else
			{
				curr.left = insert(curr.left, o);
			}
			return curr;
		}
		
		void inorder(node root)
		{
			if(root != null)
			{
				inorder(root.left);
				System.out.println(root.obj.toString());
				inorder(root.right);
			}
		}
		
					
		public static void main(String[] args) {
		BST_Student tm = new BST_Student();
		//Student s = new Student();
		tm.insert_data(new Student(12, "Dhairya",3.8));
		tm.insert_data(new Student(10, "Aman",9.3));
		tm.insert_data(new Student(9, "harry",8.5));
		tm.insert_data(new Student(16, "Ankit",7.9));
		tm.inorder_fun();
		
		

	}

}
