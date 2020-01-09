package ShellSort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
		
		for(int gap = intArray.length / 2; gap > 0; gap /=2)
		{
			for(int i = gap; i < intArray.length; i++)
			{
				//assign the element
				int newElement = intArray[i];
				//use j to traverse and don't want to change i
				int j = i;
				//if j < gap, hit front of array
				while(j >= gap && intArray[j - gap] > newElement)
				{
					//shift element at intArray[j - gap] up gap positions
					intArray[j] = intArray[j - gap];
					//subtract gap from j since we want to compare
					//newElement to whatever comes three positions over
					j -= gap;
				}
				
				intArray[j] = newElement;
			}
		}
		
		for(int i = 0; i < intArray.length; i++)
		{
			System.out.println(intArray[i]);
		}
	}

}
