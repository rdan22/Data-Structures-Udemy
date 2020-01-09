package ListChallenge2;

public class IntegerLinkedList {

	private IntegerNode head;
	private int size;

	public void addToFront(Integer value) {
		IntegerNode node = new IntegerNode(value);
		node.setNext(head);
		head = node;
		size++;
	}

	public IntegerNode removeFromFront() {
		if (isEmpty()) {
			return null;
		}

		IntegerNode removedNode = head;
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}

	public void insertSorted(Integer value) {

		//check if list is empty
		//assumption is that list is sorted
		//check if the first node in the list is greater than or equal to value we are inserting
		//because then we can insert the new node at the head of the list
		if (head == null || head.getValue() >= value) {
			addToFront(value);
			return;
		}
		//we need to find the insertion point
		//traverse the list to find first node with a value greater than or equal to new node
		//create new node and point that node's next field to the current node 
		//but previous node's next field points to current node
		//so we need to change its next field to point to new node
		//however, its a singly linked list, so if we only have a pointer to current we cant get to previous node in the list
		//so two fields: one for traversing the list, and one for position behind the current field 
		IntegerNode current = head.getNext();
		IntegerNode previous = head;
		//opposite of above if statement
		while (current != null && current.getValue() < value) {
			//previous moves forward, but still one behind current
			previous = current;
			//current moves to the next node
			current = current.getNext();
		}
		//create a node for the new value
		IntegerNode newNode = new IntegerNode(value);
		//set the new node's next field to be current
		newNode.setNext(current);
		//and the previous node's next field has to point to the new node
		previous.setNext(newNode);
		//increment the size
		size++;

	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void printList() {
		IntegerNode current = head;
		System.out.print("HEAD -> ");
		while (current != null) {
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		System.out.println("null");
	}
}
