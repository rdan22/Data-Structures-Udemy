package SortChallenge1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		mergeSort(intArray, 0, intArray.length);
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
	}
	public static void mergeSort(int[] input, int start, int end){
		
		//meaning we have a one-element array so just return
		if(end - start < 2)
		{
			return;
		}
		
		int mid = (start + end) / 2;
		//left partition
		//this entire left side {20, 35, -15} will be dealt with
		mergeSort(input, start, mid);
		//right partition
		//this entire right side {7, 55, 1, -22} will be dealt with too
		mergeSort(input, mid, end);
		//the final step would be to merge the left and right partitions at this point
		merge(input, start, mid, end);
		
	}

	public static void merge(int[] input, int start, int mid, int end){
		
		/*
		always merging sorted arrays
		the left partition and right partition are sorted already
		mid is first element in the right array and it is one greater than the last element in the left array
		if the last element in left is <= first element in the right 
		then ALL elements are already sorted! 
		*/
		if(input[mid - 1] >= input[mid])
		{
			return;
		}
		
		int i = start;
		int j = mid;
		//keeps track of where we are when doing the copy
		int tempIndex = 0;
		//create temp array
		int[] temp = new int[end - start];
		//step through and compare whatever is at index i in left to whatever is at index j in right
		
		while(i < mid && j < end)
		{
			//write whatever is at i into temp array since it is the smaller of the two
			//otherwise assign whatever is at j into temp array 
			//stable, hence the "="
			temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++]; 
		}
		
		/*
		handle the remaining elements in the array we haven't traversed
		destination position is start plus the tempIndex
		starting and ending are the same: input array
		mid - i is the number of elements from the left partition that we didn't copy over
		if we completely traversed, mid - i = length would be 0 so no copy 
		right array isn't an issue since sorted, it would end up being overwritten anyway
		*/
		System.arraycopy(input, i, input, start + tempIndex, mid - i);
		//start to end so start at "start"
		//length is tempIndex, no need to copy entire temp array
		System.arraycopy(temp, 0, input, start, tempIndex);
	}
}


