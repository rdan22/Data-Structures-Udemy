package SinglyLinkedLists;

public class EmployeeLinkedList {

	//only needs one field 
	//the head node
	private EmployeeNode head;
	//if we want to keep a running count of nodes for size
	private int size;
	
	//if we want to add item to linked list, we add to the beginning
	public void addToFront(Employee employee)
	{
		//just have to pass employee
		EmployeeNode node = new EmployeeNode(employee);
		//new node next field is going to point at whatever head is pointing at
		//because when we add a new node to the front, the current head is going to become the second node
		//so next points at head
		node.setNext(head);
		//and head is new node
		head = node;
		//need to increment size when we add employee
		size++;
		
	}
	
	//to remove an employee
	//going to return the node to be removed
	//don't need to pass anything because we're always going to remove the node that's at the front
	public EmployeeNode removeFromFront()
	{
		//first test if it is empty
		if(isEmpty())
		{
			return null;
		}
		//otherwise removedNode becomes head and 
		EmployeeNode removedNode = head;
		//the head moves to the next
		head = head.getNext();
		size--;
		//completely remove the employee from the list (it would be an isolated node)
		//this isn't necessary though but it cleans all the references 
		removedNode.setNext(null);
		return removedNode;
		
	}
	
	//nice to have a get for the size
	public int getSize()
	{
		return size;
	}
	
	//3 ways to check if it's empty: isEmpty function, getSize method, OR check if head = null
	public boolean isEmpty()
	{
		return head == null;
	}
	
	//print list method
	//need to overwrite in employeenode class otherwise will print a bunch of object references
	public void printList()
	{
		EmployeeNode current = head;
		System.out.print("HEAD -> ");
		//traverse list until current hits null (which is the end)
		while(current != null)
		{
			System.out.print(current);
			System.out.print(" -> ");
			//and then we move to the next node
			current = current.getNext();
		}
		System.out.println("NULL");
		
	}

}
