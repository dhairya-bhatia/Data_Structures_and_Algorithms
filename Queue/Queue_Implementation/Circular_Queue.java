
import java.util.*;
public class Circular_Queue implements Queue_Functions{

	private int[] arr;
	private int head = -1;
	private int tail = -1;
	private int qsize;
	
	public Circular_Queue(int size) {
		this.qsize = size;
		arr = new int[qsize];
	}

	public Circular_Queue() {
		this(5);
	}
	
	@Override
	public void enqueue(int element) {
		
		if (tail == -1) {
			head = 0;
			tail = (tail + 1) % qsize;
			arr[tail] = element;
		}
		else if(isFull() == 1)
	    	System.out.println("Queue is Full!!");
	    
		else {
			tail = (tail + 1) % qsize;
			arr[tail] = element;
		}
	    	
			
	}
	
	@Override
	public int dequeue() {
		
		if(isEmpty() == 1)
			System.out.println("Queue is empty !! Nothing to delete");
		int temp = peek();
		head = (head + 1) % (qsize);
		if (isEmpty() == 1) {
			head = -1;
			tail = -1;
		}
		return temp;
		
	}
	
	@Override
	public int size() {
//	if(head == -1)
//		return 0;
		//return((qsize - (head + tail)) % qsize);
//	if(head > tail)
//		return qsize - head + tail + 1;
//	else
//		return tail - head + 1;
		
		return head == -1 ? 0 : qsize * (tail / 5) + (tail + 1) % qsize - head;
	}
	
	@Override
	public int isFull() {
	
		if(size() == qsize)
			return 1;
		else
			return 0;
	}
	
	@Override
	public int isEmpty() {
		
	    if(size() == 0)
	    	return 1;
	    else
	    	return 0;
	}
	
	@Override
	public int peek() {
		
		if (isEmpty() == 1)
			throw new IllegalStateException("underflow");
		return arr[head];
	}
}
