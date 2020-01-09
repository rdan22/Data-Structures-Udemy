package ListChallenge1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//6 employee instances
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		Employee billEnd = new Employee("Bill", "End", 78);
		Employee janeDoe = new Employee("Jane", "Doe", 136);

		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

		//not Mike Wilson will be at the top
		list.addToFront(janeJones);
		list.addToFront(johnDoe);
		list.addToFront(marySmith);
		list.addToFront(mikeWilson);
		list.printList();
		System.out.println(list.getSize());

		
		list.addBefore(billEnd, johnDoe);
		list.printList();
		System.out.println(list.getSize());

		list.addBefore(janeDoe, mikeWilson);
		list.printList();
		System.out.println(list.getSize());
		

	}
}

