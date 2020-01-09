package HashChallenge1;
//simple program 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[10];
		int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
		for(int i = 0; i < numsToAdd.length; i++)
		{
			nums[hash(numsToAdd[i])] = numsToAdd[i];
		}
		for(int i = 0; i < nums.length; i++)
		{
			System.out.println(nums[i]);
		}
	}
	//hash function
	//want to hash values to array indices, so mod by length of the array
	public static int hash(int value)
	{
		//need abs because we have a negative number
		//placed based on their ones position
		return Math.abs(value % 10);
	}

}
