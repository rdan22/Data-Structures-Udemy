package QueuesArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		Employee billEnd = new Employee("Bill", "End", 78);
		
		ArrayQueue queue = new ArrayQueue(10);
		
		queue.add(janeJones);
		queue.add(johnDoe);
		queue.add(marySmith);
		queue.add(mikeWilson);
		queue.add(billEnd);
		
		//will be printed in the order we added them -> Jane at the front of the queue
		queue.printQueue();
		
		//let's remove two employees -> Jane and John will be removed
		queue.remove();
		queue.remove();
		queue.printQueue();
		
		//let's peek -> Mary at front now
		System.out.println(queue.peek());
		
	}

}
