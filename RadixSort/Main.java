package RadixSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };
		
		radixSort(radixArray, 10, 4);
		
		for(int i = 0; i < radixArray.length; i++)
		{
			System.out.println(radixArray[i]);
		}
	}
	
	public static void radixSort(int[] input, int radix, int width)
	{
		
		for(int i = 0; i < width; i++)
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
	public static void radixSingleSort(int[] input, int position, int radix)
	{
		
		//number of items we will be storing
		int numItems = input.length;
		
		int[] countArray = new int[radix];
		
		//for every value in input
		for(int value : input)
		{
			//count how many values have a certain digit in whatever position
			//increment by 1
			countArray[getDigit(position, value, radix)]++;
		}	
		//for the stable aspect (adjusts the count array)
		//first index doesn't matter because the number of values that have 0 or less in the one's position will be the ones with 0 
		for(int j = 1; j < radix; j++)
		{
			countArray[j] += countArray[j - 1];
		}
		//creating the temp array
		int[] temp = new int[numItems];
		//starting at the end and decrementing
		for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
		{
			//tempIndex = k in the slides (which is 5)
			//now copied values into sorted order in temp array
			temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
		}
		
		//now copy back to original array
		for(int tempIndex = 0; tempIndex < numItems; tempIndex++)
		{
			input[tempIndex] = temp[tempIndex];
		}
		
	}
	//getDigit method
	//figures out the value at each position
	public static int getDigit(int position, int value, int radix)
	{
		//don't want float to be return
		//for ex, always return what is in the one's position if position = 0
		return value / (int) Math.pow(radix, position) % radix;
		
	}
}
