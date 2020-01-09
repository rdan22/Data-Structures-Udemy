package StacksArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack stack = new ArrayStack(10);
		
		stack.push(new Employee("Jane", "Jones", 123));
		stack.push(new Employee("John", "Doe", 4567));
		stack.push(new Employee("Mary", "Smith", 22));
		stack.push(new Employee("Mike", "Wilson", 3245));
		stack.push(new Employee("Bill", "End", 78));
		
		//top down so Bill to Jane
		stack.printStack();

		//should give us Bill since he is at the top
		System.out.println(stack.peek());
		//won't change anything, will still be on the stack
		stack.printStack();

		//will pop Bill
		System.out.println("Popped: " + stack.pop());
		//should get Mike
		System.out.println(stack.peek());

	}

}
