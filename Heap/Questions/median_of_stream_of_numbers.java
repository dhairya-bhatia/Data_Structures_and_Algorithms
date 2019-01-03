/*  A stream of Numbers is coming ... You have to tell median of the stream at any point of time asked */

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Median_Of_Stream_Of_Numbers {

	void AddNumber(PriorityQueue<Integer> min , PriorityQueue<Integer> max , int num)
	{
		if(max.size() == 0 || num < max.peek())
			max.add(num);
		else
			min.add(num);
	}
	void Maintain_Balance(PriorityQueue<Integer> min , PriorityQueue<Integer> max)
	{
		PriorityQueue<Integer> small = (min.size() < max.size()) ? min : max;  //small will contain address of either min heap or max heap 
		PriorityQueue<Integer> large = (min.size() > max.size()) ? min : max;  //large will contain address of either min heap or max heap
		
		if(large.size() - small.size() >= 2)
		   	small.add(large.poll());	
	}
	double Median(PriorityQueue<Integer> min , PriorityQueue<Integer> max)
	{
		if(min.size() > max.size())
			return min.peek();
		
		if(min.size() < max.size())
			return max.peek();
		
		else
		{
			     double a = min.peek();
			     double b = max.peek();
			     return(a + b)/2;
		}
	}
	
	
	public static void main(String[] args)
	{
		Median_Of_Stream_Of_Numbers obj = new Median_Of_Stream_Of_Numbers();
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
		System.out.println("Enter size of array of numbers");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		int arr[] = new int[n];
		System.out.println("Enter "+n +" numbers");
		
		for(i = 0; i < n; i ++)
		{
			arr[i] = sc.nextInt();
		}
		
		for(i = 0; i < n; i ++)
		{
			obj.AddNumber(min, max, arr[i]);
			obj.Maintain_Balance(min, max);
			System.out.println("Median at this point is ->  ");
			System.out.println(obj.Median(min, max));
		}
		sc.close();
	}           
}
