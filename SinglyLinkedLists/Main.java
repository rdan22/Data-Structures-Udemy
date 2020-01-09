package SinglyLinkedLists;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this time they have been assigned to employee variables
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);
		
		//should be false
		//if it was before we added anything to it, it would be true
		System.out.println(list.isEmpty());
		
		//should be 4
		System.out.println(list.getSize());

		//prints the list
		//mike is at front since he was added last
		list.printList();		
		
		//to remove from the front
		//mike is gone
		list.removeFromFront();
		//this is 3
		System.out.println(list.getSize());
		list.printList();		

		
	}

}
