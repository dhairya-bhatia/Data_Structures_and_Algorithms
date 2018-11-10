package reccursion;
public class binary_search {
	
public static void find(int []arr,int num)
{
	if(arr.length==1)
		return;
	int mid=arr.length/2;
	if(mid==num)
	{
		System.out.println("Number found at"+mid);
	}
	int lower=arr[0];
	int upper=arr[arr.length-1];
	find()
	
}


	
	public static void main(String[] args)
	{
		int arr[]= {4,3,7,1,8,9};
		find(arr,8);
	}
}
