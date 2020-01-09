package BucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//since each bucket will be an arraylist
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };
		
		bucketSort(intArray);
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
		
	}
	
	//bucket sort alg
	public static void bucketSort(int[] input)
	{
		//create the array that will  hold the array list
		List<Integer>[] buckets = new List[10];
		//and now create the array list
		for(int i = 0; i < buckets.length; i++)
		{
			buckets[i] = new ArrayList<Integer>();
		}
		//need to scatter the values
		//traverse the intArray, hash each value, and put it into the appropriate bucket
		for(int i = 0; i < input.length; i++)
		{
			//the index that we want of the bucket that we're gonna put the value into will be at the hashed value 
			//so we add that value there
			buckets[hash(input[i])].add(input[i]);
		}
	
		//now we need to sort each bucket
		for(List bucket: buckets)
		{
			Collections.sort(bucket);
		}
		//merge part now
		int j = 0;
		//traversing the buckets array
		for(int i = 0; i < buckets.length; i++)
		{
			//traversing the array list at the buckets[i]
			for(int value: buckets[i])
			{
				//copy the values into the input array
				input[j++] = value;
			}
		}
		
	}
	
	//hashing function; more specific of the method we use in radix sort to return digit that corresponded to specific position
	//will use the tens digit
	private static int hash(int value)
	{
		return value/ (int) 10;
	}

}
