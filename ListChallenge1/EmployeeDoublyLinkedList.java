package ListChallenge1;

public class EmployeeDoublyLinkedList {
	
	//the head node AND the tail node
	private EmployeeNode head;
	private EmployeeNode tail;
	//if we want to keep a running count of nodes for size
	private int size;

	//don't have to handle a previous field here
	//but will have to change the previous field of the node currently at the head of the list
	//because the head of the list will become the second node
	public void addToFront(Employee employee)
	{
		//just have to pass employee
		EmployeeNode node = new EmployeeNode(employee);
		//need to consider if we start with an empty list (head and tail would be null)
		if(isEmpty())
		{
			tail = node;
		}
		//current head node's previous field points to new node
		else
		{
			head.setPrevious(node);
			//new node next field is going to point at whatever head is pointing at
			//because when we add a new node to the front, the current head is going to become the second node
			//so next points at head
			node.setNext(head);
		}
		//and head is new node
		head = node;
		//need to increment size when we add employee
		size++;

	}
	
	//for this one we have to set previous field to point to node that is currently at the end of the list
	public void addToEnd(Employee employee)
	{
		//pass employee
		EmployeeNode node = new EmployeeNode(employee);
		//need to consider if we start with an empty list (head and tail would be null)
		if(tail == null)
		{
			head = node;
		}
		//else we want to set current tail's next field to the node we are adding
		//and previous field of node we are adding to what used to be the tail
		else
		{
			tail.setNext(node);
			node.setPrevious(tail);
			
		}
		//set tail to the new node now
		tail = node;
		//increment size
		size++;
	}

	//going to return the node to be removed
	//don't have to pass anything because will always remove from front
	//also possible we would be removing the only node in the list
	//if two people in list, "new" head's previous field will point to whatever the previous field of the old head points to
	public EmployeeNode removeFromFront()
	{
		//first test if it is empty
		if(isEmpty())
		{
			return null;
		}
		//otherwise removedNode becomes head and 
		EmployeeNode removedNode = head;
		//only have one node in the list
		if(head.getNext() == null)
		{
			tail = null;
		}
		//have to handle the new node previous field, set it to null
		else
		{
			head.getNext().setPrevious(null);
		}
		//the head moves to the next
		head = head.getNext();
		size--;
		//completely remove the employee from the list (it would be an isolated node)
		//this isn't necessary though but it cleans all the references 
		removedNode.setNext(null);
		return removedNode;

	}
	
	//don't have to pass anything because always removing from end
	//consider when only one node again
	//will have to worry about changing the tail
	public EmployeeNode removeFromEnd()
	{
		if(isEmpty())
		{
			return null;
		}
		//here we remove the tail
		EmployeeNode removedNode = tail;
		//if only one node in the list
		if(tail.getPrevious() == null)
		{
			head = null;
		}
		//have to set the next field of the node that becomes the new tail to null
		//previous node becomes new tail
		else
		{
			tail.getPrevious().setNext(null);
		}
		//the tail moves to the previous
		tail = tail.getPrevious();
		size--;
		removedNode.setPrevious(null);
		return removedNode;
	}
	//to add a new employee before an existing employee
	//return true if able to successfully add employee
	//into list before existing employee
	//return false if existing employee not in list
	public boolean addBefore(Employee newEmployee, Employee existingEmployee)
	{
		//if empty
		if(head == null)
		{
			return false;
		}
		//find the existing employee
		EmployeeNode current = head;
		//while current isnt null and doesn't equal existing employee, we move on
		while(current != null && !current.getEmployee().equals(existingEmployee))
		{
			current = current.getNext();
		}
		//if current is null
		//if existing is in the list, can't do anything
		if(current == null)
		{
			return false;
		}
		//at this point, have found existing employee, so want to put new employee in front 
		//4 things to change: will have to set previous and next field of new employee, current node's previous field
		//will point to the new employee, and then employee currently in front of current will be in front of the new employee
		//so its next field will have to be changed
		EmployeeNode newNode = new EmployeeNode(newEmployee);
		//setting new node's previous and next fields
		newNode.setPrevious(current.getPrevious());
		newNode.setNext(current);
		//current field's previous
		current.setPrevious(newNode);
		//for the employee at front of current
		//if current is at the head of the list, set head to the new node
		//else change the next field of the node in front of the new node
		if(head == current)
		{
			head = newNode;
		}
		else
		{
			newNode.getPrevious().setNext(newNode);
		}
		
		//increment size
		size++;
		//will have successfully put new in front of existing at this point
		return true;
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
			System.out.print(" <=> ");
			//and then we move to the next node
			current = current.getNext();
		}
		System.out.println("NULL");

	}
}
