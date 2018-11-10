package ds;

public class Stack {
	private int[] arr;
	int size;
	int top;
	
	public Stack()
	{
		size = 1;
		arr = new int[size];
		top = -1;
	}
	public void push(int item)
	{
		if(top == size - 1)
		{
			if(size == 0)
				resize(1);
			else
			{
				resize(size * 2);
				arr[++top] = item;
			}
		}
		else
		    arr[++top] = item;
			
		
			
	}
	public void pop()
	{
		if(top == -1)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			top--;
			
			if(top <= size / 2 && size > 1)
			{
				int x = (3*size) / 4;
				resize(x);
				
			}
		}
	}
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
	}
	public int peek()
	{
		return arr[top];
	}
	
	public int size()
	{
		return top + 1;
	}
	void resize(int newSize)
	{
		int arr2[] = new int[newSize];
		for(int i = 0; i <= top; i++)
		{
			arr2[i] = arr[i];
		}
		size = newSize;
		arr = arr2;
	}
	
}
