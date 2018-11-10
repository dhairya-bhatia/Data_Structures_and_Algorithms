package client;

import ds.Stack;

public class TestStack {

	public static void main(String[] args) {
	
			Stack st = new Stack();
			st.push('a');
			st.push('b');
			st.push('c');
			assert st.peek() == 'c';
			assert st.size() == 3;
			assert st.isEmpty() == false;
			st.pop();
			assert st.peek() == 'b';
			System.out.println("All test cases passed for stack");
			
			
	}
	
	 
}
