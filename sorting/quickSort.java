package sorting;

public class quickSort {

	static void helperFun(int[] arr, int start, int end)
	{
		if(start < end)
		{
			int pivot = findPivot(arr, start, end);
			
			helperFun(arr, start, pivot - 1);
			helperFun(arr, pivot + 1, end);
		}
	}
	static int findPivot(int[] arr, int start, int end)
	{
		int pivot = arr[end];     // We are taking last element as pivot
		int pindex = start;
		int i;
		for(i = start; i <= end - 1; i++)
		{
					if(arr[i] <= pivot)
					{
						if(arr[i] != arr[pindex])        // check if element itself should not be at pindex
						{
							int temp = arr[i];
							arr[i] = arr[pindex];
							arr[pindex] = temp;
						}
						
						pindex++;
					}
			
		}
		int temp = arr[end];
		arr[end] = arr[pindex];
		arr[pindex] = temp;
		
		return pindex;
	}
	public static void main(String[] args)
	{
		int[] arr = {3, 1, 5, 2, 8, 9, 11, 6};
		
		helperFun(arr, 0, arr.length - 1);
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]+" ");
		
	}
}
