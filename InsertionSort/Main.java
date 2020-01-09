package InsertionSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++)
		{
			//will be overwritten
			int newElement = intArray[firstUnsortedIndex];
			//save outside the next loop
			int i;
			//as long as we haven't hit the front of the array and will keep going as long the 
			//element we're looking at in the sorted partition is greater than the one we will insert
			//otherwise we still haven't found the correct insertion position
			//decrement i since moving from right to left
			for(i = firstUnsortedIndex; i > 0 && intArray[i-1] > newElement; i--)
			{
				//shifting from left to right and will keep doing so until we reach front of the array
				intArray[i] = intArray[i-1];
			}
			
			intArray[i] = newElement;
			
		}
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
	}
}
//lots of shifting; can we improve? yes, with shell sort!