package QuickSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };	
		
		quickSort(intArray, 0, intArray.length);
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
		
	}
	
	public static void quickSort(int[] input, int start, int end){
		
		if(end - start < 2)
		{
			return;
		}
		
		int pivotIndex = partition(input, start, end);
		//repositioned the elements such that everything to the left of the pivot is < pivot
		//and everything to the right of the pivot is > pivot
		//and we want do the quickSort on left subarray and right subarray
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex + 1, end);
	
	}

	public static int partition(int[] input, int start, int end){
		//this uses the first element as the pivot
		int pivot = input[start];
		int i = start;
		int j = end;
		
		//if i >=j, they crossed, we stop
		//note: will be alternating from right to left and from left to right 
		while(i < j)
		{
			//empty loop 
			//right to left
			//this is all we want to do here
			//have to make sure we keep decrementing j until we either find an element less than the pivot
			//or j crosses i
			//THEN we use the result as the index (otherwise we get index out of bounds error)
			while(i < j && input[--j] >= pivot);
			if(i < j)
			{
				input[i] = input[j];
			}
			//empty loop 
			//left to right
			//looking for value greater than pivot to move to the right of the pivot
			//have to make sure we keep incrementing i until we either find an element greater than the pivot
			//or i crosses j
			//THEN we use the result as the index (otherwise we get index out of bounds error)
			while(i < j && input[++i] <= pivot);
			if(i < j)
			{
				input[j] = input[i];
			}
		}
		
		input[j] = pivot;
		return j;
		
	}
	
}
