package algorithms;

public class KmpStringSearching {

	static int[] computeLPS(char[] substr)
	{
		int[] lps = new int[substr.length];
		int i = 1;
		int j = 0;
		lps[0] = 0;
		while(i < lps.length)
		{
			if(substr[j] == substr[i])
			{
				j++;
				lps[i] = j;
				i++;
			}
			else
			{
				if(j == 0)
				{
					lps[i] = 0;
					i++;
				}
				else
				{
					j = lps[j - 1];
				}
					
			}
		}
		return lps;
	}
	
	private static int KMP(char[] str, char[] substring)
	{
		int[] lps = computeLPS(substring);
		int j = 0;
		int i = 0;
		
		while(i < str.length)
		{
			if(j == substring.length)
				break;
			
			else if(str[i] == substring[j])
			{
				i++;
				j++;
			}
			
			else
			{
				if(j == 0)
				{
					i++;
				}
				else
				{
					j = lps[j - 1];
				}
			}
			
		}
		if(j == substring.length)
			return (i - substring.length);
		else
			return -1;
	}
	
	public static void main(String[] args)
	{
		String str = "ABABDABACDABABCABAB";
		String subString = "ABABCABAB";
		int index = KMP(str.toCharArray(), subString.toCharArray());
		if(index != -1)
			System.out.println("Substring found at index "+index);
		else
			System.out.println("Substring not Found");
	}
}
