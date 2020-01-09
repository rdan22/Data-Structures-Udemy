package ListChallenge2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer one = 1;
		Integer two = 6;
		Integer three = 5;
		Integer four = 15;

		IntegerLinkedList list = new IntegerLinkedList();
		list.insertSorted(three);
		list.printList();
		list.insertSorted(two);
		list.printList();
		list.insertSorted(one);
		list.printList();
		list.insertSorted(four);
		list.printList();
	}

}
