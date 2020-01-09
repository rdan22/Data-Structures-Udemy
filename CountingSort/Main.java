package CountingSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intArray = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };
		
		countingSort(intArray, 1, 10);
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
		
		
	}

	public static void countingSort(int[] input, int min, int max)
	{
		//max - min + 1 is the length since inclusive!
		int[] countArray = new int[(max - min) + 1];
		
		//traverse input array
		for(int i = 0; i < input.length; i++)
		{
			//this is to determine which element to increment in the countArray
			//translates the value we want to count into its index in the countArray
			countArray[input[i] - min]++;
		}
		
		//now we want to populate original array using countArray
		
		int j = 0;
		
		//j is the index we use to write to the input array
		//i is the index we use to traverse the count array
		//set i to min and max so that we can just write the value of i back to the input array
		for(int i = min; i <= max; i++)
		{
			//each element has a count (which can be greater than 1)
			while(countArray[i - min] > 0)
			{
				//write to input array
				input[j++] = i;
				//decrement count to see if any other of the same #
				countArray[i - min]--;
			}
			
		}
		
		
	}


}
