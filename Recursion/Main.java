package Recursion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		System.out.println(iterativeFactorial(3));
		System.out.println(recursiveFactorial(3));
	}
	//for recursive, note:
	// 1! = 1 * 0!, 2! = 2 * 1!, 3! = 3 * 2!, ..., n! = n * (n-1)!
	public static int recursiveFactorial(int num){
		
		if(num == 0)
		{
			return 1;
		}
		/*
		recursive function just calls itself -> call waits for return value until num = 0
		lots of processing call stack has a certain amount of memory only
		if it keeps calling itself it will get a stack overflow error
		*/
		return num * recursiveFactorial(num - 1);
	}
	
	/*
	iterative implementation
	usually runs faster and doesn't use as much memory
	because there's overhead involved with pushing method calls onto the call stack 
	and each stack frame uses some memory
	but sometimes the iterative way may not be intuitive or may be much longer to write
	recursive is more elegant/easier to understand
	*/
	public static int iterativeFactorial(int num) {
		
		if(num == 0)
		{
			return 1;
		}
		
		int factorial = 1;
		
		for(int i = 1; i <= num; i++)
		{
			//set factorial to factorial * i
			factorial *= i;
		}
		
		return factorial;
	}
	
	
}
