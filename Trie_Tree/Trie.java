package basic_operations;
import java.util.*;

public class Trie {

	private class Trie_Node
	{
	
		Map<Character , Trie_Node> m;
		boolean isEndOfWord;
		
		public Trie_Node()
		{
			m = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	static Trie_Node root;
	
	public Trie()
	{
		root = new Trie_Node();
	}
	
	void Insert(String str)
	{
		Trie_Node temp = root;
		int i;
		for(i = 0; i < str.length(); i ++)
		{
			char ch = str.charAt(i);
			Trie_Node n = temp.m.get(ch);
			if(n == null)
			{
				n = new Trie_Node();
				temp.m.put(ch, n);
			}
			temp = n;
		}
		temp.isEndOfWord = true;
	}
	
	boolean Search(String str)
	{
		Trie_Node temp = root;
		int i;
		for(i = 0; i < str.length(); i ++)
		{
			char ch = str.charAt(i);
			Trie_Node node = temp.m.get(ch);
			if(node == null)
			{
				return false;
			}
			temp = node;         // Same as node -> next
		}
		if(i == str.length() && temp.isEndOfWord == true)
			return true;
		else
			return false;
	}
	
	boolean Delete(Trie_Node temp , String str , int index)
	{
	//	Trie_Node temp = root;
		
		if(str.length() == index)
		{
			if(temp.isEndOfWord == false)
				return false;
			
			temp.isEndOfWord = false;
			
			if(temp.m.size() == 0)
				return true;
			else
				return false;
		}
		char ch = str.charAt(index);
		Trie_Node node = temp.m.get(ch);
		if(node == null)
			return false;
		
		boolean value = Delete(node, str, index + 1);
		
		if(value)
		{
			temp.m.remove(ch);
			
			if(temp.m.size() == 0)
				return true;
			else
				return false;
		}
		return false;
		
		
	}
	
	public static void main(String[] args)
	{
		Trie obj = new Trie();
		String[] s1 = {"hello" , "chitkara" , "world" , "hero" , "hell" , "chart"};
		int i;
		for(i = 0; i < s1.length; i ++)
		{
			obj.Insert(s1[i]);
		}
		if(obj.Search("hero") == true)
			System.out.println("\"hero\" is present in the trie tree");
		else
			System.out.println("\"hero\" is not present in the trie tree");
		
			obj.Delete(root, "hero", 0);
		
			boolean ans = obj.Search("hell");
			if(ans)
				System.out.println("Word found");
		
		else
			System.out.println("Word deleted");
	}
}
