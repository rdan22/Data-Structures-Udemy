package SortChallenge2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		insertionSort(intArray, intArray.length);
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
	}
	
	public static void insertionSort(int[] input, int numItems){
		
		//one item is sorted by definition
		if(numItems < 2)
		{
			return;
		}
		//insertion sort with one less items 
		//before we sort the items, we sort numItems - 1
		insertionSort(input, numItems - 1);
		
		//will be overwritten
		int newElement = input[numItems - 1];
		
		int i;
		//as long as we haven't hit the front of the array and will keep going as long the 
		//element we're looking at in the sorted partition is greater than the one we will insert
		//otherwise we still haven't found the correct insertion position
		//decrement i since moving from right to left
		for(i = numItems - 1; i > 0 && input[i-1] > newElement; i--)
		{
			//shifting from left to right and will keep doing so until we reach front of the array
			input[i] = input[i-1];
		}
		
		input[i] = newElement;
	
	}

}
