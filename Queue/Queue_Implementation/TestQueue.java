//import static org.junit.Assert.*;
public class TestQueue {

	public static void main(String[] args) {
		 testQueueFunctions(new Basic_Queue());
	    testQueueFunctions(new Circular_Queue());
	    // testQueueFunctions(new LinkedListQueue());

	}

	 public static void testQueueFunctions(Queue_Functions q){
		  assert q.size() == 0;
	      assert q.isEmpty() == 1;
	      q.enqueue(1);
	      q.enqueue(2);
	      q.enqueue(3);
	      q.enqueue(4);
		  assert q.peek() == 1;
		  //System.out.println(q.size());
		  assert q.size() == 4;
	      assert q.dequeue() == 1;
	      assert q.size() == 3;
	      assert q.dequeue() == 2;
	      assert q.size() == 2;
	      assert q.dequeue() == 3;
	      assert q.size() == 1;
	      assert q.dequeue() == 4;
		 // System.out.println(q.size());
	      assert q.size() == 0;
	      
	      assert q.isEmpty() == 1;
	      System.out.println("All test cases passed for " + q.getClass().getName());
	   }
	}
