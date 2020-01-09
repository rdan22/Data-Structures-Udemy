package StacksLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		Employee billEnd = new Employee("Bill", "End", 78);
		
		//create stack
		LinkedListStack stack = new LinkedListStack();
		
		//push employees
		stack.push(janeJones);
		stack.push(johnDoe);
		stack.push(marySmith);
		stack.push(mikeWilson);
		stack.push(billEnd);
	
		//will print Bill at top 
		stack.printStack();
		
		//will print out Bill
		System.out.println(stack.peek());
		//nothing changed
		stack.printStack();

		//Will pop Bill
		System.out.println("Popped: " + stack.pop());
		//now Mike is at top
		System.out.println(stack.peek());

	}

}
