//   It is implemented without using Map Data structure and is efficient than other implementation

package basic_operations;

public class Trie_Improved {

	private class Node
	{
		Object value;
		Node[] next;
		
		public Node()
		{
			next = new Node[256];
		}
	}
	
	private Node root = new Node();
	
	public void insert(String str , Object value)
	{
		root = insert(str, value, root, 0);
	}
	private Node insert(String str , Object value , Node x , int len)
	{
		if(x == null)
			x = new Node();
		
		if(len == str.length())
		{
			x.value = value;
			return x;
		}
		
		char c = str.charAt(len);
		x.next[c] = insert(str, value, x.next[c], len + 1);
		
		return x;
	}
	
	public Object search(String str)
	{
		return search(str , root);
	}
	private Object search(String str , Node x)
	{
		int i;
		for(i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(x.next[c] == null)
				return -1;
			else
			{
				x = x.next[c];
			}
		}
		if(i == str.length())
			return x.value;
		else
			return -1;
	}
	
	public static void main(String[] args)
	{
		Trie_Improved tree = new Trie_Improved();
		tree.insert("Hello", "Hello dude");
		Object val = tree.search("Hello");
		System.out.println(val);
	}
}
