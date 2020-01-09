package SelectionSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		//similar to bubble sort
		//outer loop increases sorted partition by 1
		for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--)
		{
			int largest = 0;
			//inner loop looks for the largest element
			//once it is found, swap largest with the last element in the unsorted partition
			//grown the sorted index by 1, so subtract 1 from the lastUnsortedIndex
			for(int i = 1; i <= lastUnsortedIndex; i++)
			{
				if(intArray[i] > intArray[largest])
				{
					largest = i;
				}
			}
			
			swap(intArray, largest, lastUnsortedIndex);
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
