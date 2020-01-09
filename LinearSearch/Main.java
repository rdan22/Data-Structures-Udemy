package LinearSearch;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
			
		System.out.println(linearSearch(intArray, -15));
		System.out.println(linearSearch(intArray, 1));
		System.out.println(linearSearch(intArray, 88));
		System.out.println(linearSearch(intArray, -22));
	}
	//linear search method
	public static int linearSearch(int[] input, int value)
	{
		//iterate from beginning to end, either find item or go through whole array and it won't contain it
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] == value)
			{
				return i;
			}
		}
		//value not in array
		return -1;
	}
}

//time complexity is O(n) since worst case is we're looking for the last item in the list
