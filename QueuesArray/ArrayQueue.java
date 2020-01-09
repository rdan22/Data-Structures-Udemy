package QueuesArray;

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
		//check whether full -> if back = length of array
		if(back == queue.length)
		{
			Employee[] newArray = new Employee[2*queue.length];
			System.arraycopy(queue, 0, newArray, 0, queue.length);
			queue = newArray;
		}
		//assign employee to the back
		queue[back] = employee;
		//increment back
		back++;
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
		return back - front;
	}
	//print method
	public void printQueue()
	{
		//if printing front to back, front may not be 0
		//remember i has to be one less than back
		for(int i = front; i < back; i++)
		{
			System.out.println(queue[i]);
		}
	}
}




