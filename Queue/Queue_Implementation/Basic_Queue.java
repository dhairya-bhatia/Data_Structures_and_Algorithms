
public class Basic_Queue implements Queue_Functions {

	private int[] arr;
	private int head = -1;
	private int tail = -1;
	private int qsize;
	
	public Basic_Queue(int size)
	{
		qsize = size;
		arr = new int[size];
	}
	public Basic_Queue()
	{
		this(5);
	}
	@Override
	public void enqueue(int element)
	{
		if(isFull() == 1)
		{
			System.out.println("Queue Is Full");
		}
		else if(tail == -1)
		{
			head = 0;
			arr[++tail] = element;
		}
		else
		{
			tail++;
			arr[tail] = element;
		}	
		
	}
	
	@Override
	public int dequeue()
	{
		if(isEmpty() == 1) {
			System.out.println("Empty Queue!! Nothing to delete..");
			return -99;
		}
			else
		{
			int temp = peek();
			head++;
			return temp;
		}
	}
	
	@Override
	public int size()
	{
		return (tail == -1 && head == -1) ? 0 : (tail - head) 
				+ 1;
	}
	
	@Override
	public int isFull()
	{
		if(qsize - 1 == tail)
	        return 1;
		else
			return 0;
	}
	
	@Override
	public int isEmpty()
	{
		if(size() == 0)
			return 1;
		else
			return 0;
	}
	
	@Override
	public int peek()
	{
		return arr[head];
	}
	
		
	
}
