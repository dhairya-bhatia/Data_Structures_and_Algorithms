package sorting;

public class mergeSort {
	
	static void merge(int[] left, int[] right, int[] arr)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length)
		{
			if(left[i] <= right[j])
			{
				arr[k++] = left[i++];
			}
			else
			{
				arr[k++] = right[j++];
			}
		}
		while(i < left.length)
		{
			arr[k++] = left[i++];
		}
		while(j < right.length)
		{
			arr[k++] = right[j++];
		}
		
	}
	static void helper(int[] arr)
	{
		if(arr.length > 1)
		{
			int mid = arr.length / 2;
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for(int i = 0; i < left.length; i++)
			{
				left[i] = arr[i];
			}
			for(int i = 0; i < right.length; i++)
			{
				right[i] = arr[i + mid];
			}
			
			helper(left);
			helper(right);
			merge(left, right, arr);
		}
	}
	public static void main(String[] args)
	{
		int [] arr = {3, 1, 5, 2, 8, 9, 11, 6};
		
		helper(arr);
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}

}
