package BubbleSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };	
		//index will go from 6 to 0 -> once 0 we can stop
		//this is just the outerloop though 
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
		{
			//bubble larger values to the end
			//growing sorted partition from right to left
			//number of steps grow as the number of items grow in a quadratic way 
			//this is slightly more optimized since we don't loop through the sorted partition
			for(int i = 0; i < lastUnsortedIndex; i++)
			{
				if(intArray[i] > intArray[i + 1])
				{
					swap(intArray, i, i+1);
				}
			}
		}
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
	}
	//swap function
	public static void swap(int[] array, int i, int j)
	{
		//check whether i = j, because if so, nothing left to do
		if(i == j)
		{
			return;
		}
		int temp = array[i];
		//overwritten the value at i, but we saved it in temp
		array[i] = array[j];
		//assign temp to j
		array[j] = temp;
		//complete swap
		
	}
}


