package QueuesCircular;

import java.util.NoSuchElementException;

public class ArrayQueue {
	//need 3 fields for the Queue
	//one for the array, one that tracks front of the queue, one that tracks the back of the queue
	//front and back initially 0
	private Employee[] queue;
	private int front;
	private int back;

	//constructor
	public ArrayQueue(int capacity)
	{
		queue = new Employee[capacity];
	}
	//add method
	public void add(Employee employee)
	{
		//check whether full -> if back = length of array won't work so queue.length - 1 equals size
		if(size() == queue.length - 1)
		{
			//we hit the breakpoint!! means it tried to resize
			//need to wrap the back of the queue to the front of the queue
			//that way we make use of the empty space
			//breakpoint should not be hit now
			int numItems = size();
			Employee[] newArray = new Employee[2*queue.length];
			//if we can't increment back because front is at the next position -> resets queue to the front
			System.arraycopy(queue, front, newArray, 0, queue.length - front);
			//copy the rest of the items behind
			//this is an unnecessary copy to see if queue is wrapped, but better to leave it here as it is
			System.arraycopy(queue, 0, newArray, queue.length - front, back);
			
			queue = newArray;
			//front is now 0
			//back is the number of items since it is no longer valid
			front = 0;
			back = numItems;
		}
		
		/*
		  Going from this:
		  0 - jane
		  1 - john
		  2 -      - back
		  3 - mike - front
		  4 - bill
		  
		  To this:
		  0 - mike
		  1 - bill
		  2 - jane 
		  3 - john
		  4 -      - back
		*/

		//assign employee to the back
		queue[back] = employee;
		//don't necessarily want to just increment back if we want to wrap back to the front
		if(back < queue.length - 1)
		{
			back++;
		}
		else
		{
			back = 0;
		}
	}
	//remove method
	public Employee remove()
	{
		//need to check if empty
		//but back and front are BOTH always changing 
		//but we can get the size by subtracting front from back
		if(size() == 0)
		{
			throw new NoSuchElementException();
		}
		//set the employee to the front because FIFO
		Employee employee = queue[front];
		//null it out 
		queue[front] = null;
		//increment front 
		front++;
		//we can check whether the size is 0 at this point (kind of an optimization)
		if(size() == 0)
		{
			//then we can reset front and back to beginning of the array
			front = 0;
			back = 0;
		}
		//but if it's length of queue, then wrap front back to 0
		else if(front == queue.length)
		{
			front = 0;
		}

		return employee;
	}
	//peek method
	public Employee peek()
	{
		if(size() == 0)
		{
			throw new NoSuchElementException();
		}
		return queue[front];
	}
	//size
	public int size()
	{	
		//test whether the queue has wrapped
		if(front <= back)
		{
			//then we know it hasn't wrapped
			return back - front;
		}
		else
		{
			//if queue has wrapped
			//can adjust negative number this way
			return back - front + queue.length;
		}
	}
	//print method
	public void printQueue()
	{
		//back could be less than front!! 
		if(front <= back)
		{
			//queue hasn't wrapped
			for(int i = front; i < back; i++)
			{
				System.out.println(queue[i]);
			}
		}
		else
		{
			//if queue has wrapped
			//will print what's at the front to the end of the array
			for(int i = front; i < queue.length; i++)
			{
				System.out.println(queue[i]);
			}
			//will print up until where back is 
			for(int i = 0; i < back; i++)
			{
				System.out.println(queue[i]);
			}
		}
		
	}
}
