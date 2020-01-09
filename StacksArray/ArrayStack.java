package StacksArray;

import java.util.EmptyStackException;

//implementation backed by an array
public class ArrayStack {

	//backing array
	//need to track index of top position in the stack
	private Employee[] stack;
	//initialized to 0 = empty
	private int top;
	
	//will allow caller to tell us how large they want the stack to be 
	//so need a constructor
	public ArrayStack(int capacity)
	{
		stack = new Employee[capacity];
	}
	
	//push function
	public void push(Employee employee)
	{
		//if is stack length, then array is full -> O(n)
		if(top == stack.length)
		{
			//need to resize backing array
			Employee[] newArray = new Employee[2*stack.length];
			//copy over all the elements
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			//assign new array to stack field
			stack = newArray;
		}
		//once stack top is not gonna give us array out of bounds exception
		//we assign employee to top and increment top
		//O(1)
		stack[top++] = employee;
	}
	
	//pop function
	//not worrying about resizing here (otherwise would be O(n))
	public Employee pop()
	{
		//want to check whether stack is empty, so there won't be anything to pop
		if(isEmpty())
		{
			//throw an exception
			throw new EmptyStackException();
		}
		//if not empty
		//use prefix operator to decrement top
		//use result as the index to stack 
		Employee employee = stack[--top];
		//now set that position to null 
		//because we have popped the employee at position top
		stack[top] = null;
		
		return employee;
	}
	//check whether empty
	public boolean isEmpty()
	{
		//if top = 0, then empty
		return top == 0;
	}
	
	//peek function
	//O(1)
	public Employee peek()
	{
		//want to check whether stack is empty, so there won't be anything to peek at
		if(isEmpty())
		{
			//throw an exception
			throw new EmptyStackException();
		}
		//top is located at top - 1 actually
		return stack[top - 1];
	}
	
	//size is just top
	public int size()
	{
		return top;
	}
	
	//printing stack from top to bottom
	public void printStack()
	{
		for(int i = top - 1; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}
	
	
}
