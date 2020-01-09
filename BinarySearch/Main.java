package BinarySearch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { -22, -15, 1, 7, 20, 35, -55 };
		
		//System.out.println(iterativeBinarySearch(intArray, -15));
		//System.out.println(iterativeBinarySearch(intArray, 35));
		//System.out.println(iterativeBinarySearch(intArray, 88));
		//System.out.println(iterativeBinarySearch(intArray, 1));
		
		System.out.println(recursiveBinarySearch(intArray, -15));
		System.out.println(recursiveBinarySearch(intArray, 35));
		System.out.println(recursiveBinarySearch(intArray, 88));
		System.out.println(recursiveBinarySearch(intArray, 1));

		
	}
	//iterative binary search method
	public static int iterativeBinarySearch(int[] input, int value)
	{
		//start and end
		//logical partitioning, not creating a new array each time
		int start = 0;
		int end = input.length;
		//if start < end, have not traversed the entire array yet
		while(start < end)
		{
			//midpoint = start + end / 2
			int midpoint = (start + end)/2;
			System.out.println("midpoint = " + midpoint);
			if(input[midpoint] == value)
			{
				//if it's equal, just return the midpoint
				return midpoint;
			}
			
			else if(input[midpoint] < value)
			{
				//search the right part of array
				start = midpoint + 1;
				
			}
			else
			{
				//search the left part of the array
				end = midpoint;
			}
		}
		
		//if we have not found the value
		return -1;
	}
	
	//recursive binary search method
	public static int recursiveBinarySearch(int[] input, int value)
	{
		//one accepts entire array
		//another method takes start and end point as well
		return recursiveBinarySearch(input, 0, input.length, value);
	}
	//actual recursive method
	public static int recursiveBinarySearch(int[] input, int start, int end, int value)
	{
		//breaking condition; down to partition of 0 elements, didn't find what we're looking for
		if(start >= end)
		{
			return -1;
		}
		//midpoint like above
		int midpoint = (start + end)/2;
		System.out.println("midpoint = " + midpoint);
		
		if(input[midpoint] == value)
		{
			return midpoint;
		}
		else if(input[midpoint] < value)
		{
			//will be looking at the right half so start =  midpoint + 1 now
			return recursiveBinarySearch(input, midpoint + 1, end, value);
		}
		else
		{
			//will be looking at left half so end = midpoint now
			return recursiveBinarySearch(input, start, midpoint, value);
		}
		
	}
}
