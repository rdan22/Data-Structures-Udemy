package StacksLinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListStack {

	//stack backed by Linked List
	private LinkedList<Employee> stack;
	
	//Constructor
	public LinkedListStack()
	{
		//going to create our linked list now
		//actually a doubly linked list
		//but don't need it for a stack since always working with the top
		stack = new LinkedList<Employee>();
	}
	
	//defer to linked list
	//as they already have push, pop, peek, etc methods
	public void push(Employee employee)
	{
		stack.push(employee);
	}
	public Employee pop()
	{
		return stack.pop();
	}
	public Employee peek()
	{
		return stack.peek();
	}
	public boolean isEmpty()
	{
		return stack.isEmpty();
	}
	//printing the stack
	public void printStack()
	{
		//use list iterator
		//traverses from head to tail (top down)
		ListIterator<Employee> iterator = stack.listIterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
