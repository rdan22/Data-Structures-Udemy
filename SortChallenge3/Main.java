package SortChallenge3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] radixArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };
		//as usual, will start at the right since least significant position is at the right
		//when sorting based on last position, needs to accept it and figure out the letter we
		//are looking at
		
		radixSort(radixArray, 26, 5);
		
		for(int i = 0; i < radixArray.length; i++)
		{
			System.out.println(radixArray[i]);
		}
	}
	public static void radixSort(String[] input, int radix, int width)
	{
		//this time we need to start at the rightmost position
		for(int i = width - 1; i >= 0; i--)
		{
			//call radix single sort for each position for the values
			//will start with the rightmost position and move left 
			//least significant to most significant
			radixSingleSort(input, i, radix);
		}
		
	}
	//at the end of the radix single sort loop, we have conventional count array
	//but also need to be stable
	//each position in the count array contains how many values have that digit or less
	//sum up all of the counts up to and including the digit we're working on
	public static void radixSingleSort(String[] input, int position, int radix)
	{
		
		//number of items we will be storing
		int numItems = input.length;
		
		int[] countArray = new int[radix];
		
		//for every value in input
		for(String value : input)
		{
			//count how many values have a certain digit in whatever position
			//increment by 1
			countArray[getIndex(position, value)]++;
		}	
		//for the stable aspect (adjusts the count array)
		//first index doesn't matter because the number of values that have 0 or less in the one's position will be the ones with 0 
		for(int j = 1; j < radix; j++)
		{
			countArray[j] += countArray[j - 1];
		}
		//creating the temp array
		String[] temp = new String[numItems];
		//starting at the end and decrementing
		for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
		{
			//tempIndex = k in the slides (which is 5)
			//now copied values into sorted order in temp array
			temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
		}
		
		//now copy back to original array
		for(int tempIndex = 0; tempIndex < numItems; tempIndex++)
		{
			input[tempIndex] = temp[tempIndex];
		}
		
	}
	
	public static int getIndex(int position, String value)
	{
		//note that 'a' is at position 0 - need to translate the numeric value from the character to 0-25
		//which is an index in the counting array
		return value.charAt(position) - 'a';
	}
	

}
