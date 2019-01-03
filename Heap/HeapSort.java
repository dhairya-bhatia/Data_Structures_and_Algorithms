
public class HeapSort 
{ 
	private static void printArray(int[] arr) {
		int n = arr.length;
		for(int i = 0; i  < n; i++)
			System.out.print(arr[i]+" ");
			}
	
   	private void sort(int[] arr) 
   	{
	   	int n = arr.length;
		for(int i = n / 2 - 1; i >= 0; i--)
		{
			heapify(arr, n, i);
		}
		for(int i = n - 1; i >= 0; i--)
		{
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			
			heapify(arr, i, 0);
		}
	}
	
		private void heapify(int[] arr, int n, int i) 
		{			
			int big = i;
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if(left < n && arr[left] > arr[big])
				big = left;
			if(right < n && arr[right] > arr[big])
				big = right;
			if(big != i)
			{
				int temp = arr[big];
				arr[big] = arr[i];
				arr[i] = temp;
				
				heapify(arr, n, big);
			}
			
		}
		
		public static void main(String args[]) 
		{ 
			int arr[] = {3, 6, 12, 5, 1, 9}; 
			
			HeapSort ob = new HeapSort(); 
			ob.sort(arr); 

			System.out.println("Sorted array is"); 
			printArray(arr); 
		}
	} 
