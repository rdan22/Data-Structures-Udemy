package MaxHeap;

public class Heap {

	//need two fields: array and next available position to insert a new value
	private int[] heap;
	private int size;
	
	//in constructor we just need to create and initialize array
	public Heap(int capacity)
	{
		heap = new int[capacity];
	}
	
	//isFull method
	public boolean isFull()
	{
		//if number of items in heap = size of array, the heap is full
		//we could either throw an exception or resize the array
		return size == heap.length;
	}
	
	//utility function that gets parent in the array
	public int getParent(int index)
	{
		return (index - 1)/2;
	}
	
	//insert method; always at the end of the array, hence why tracking size
	public void insert(int value)
	{
		//throw an exception if heap is full
		if(isFull())
		{
			//we want to add a node into array, but no room, can't add anymore items
			throw new IndexOutOfBoundsException("Heap is full.");
		}
		
		//else put new item in first available spot
		//suffix operator to use current size
		heap[size] = value;
		//now potentially heapify
		//this is a max heap, so need to check whether > parent or not
		//calls fixHeapAbove
		fixHeapAbove(size);
		//increment size
		size++;
		
	}
	
	//fix the heap ABOVE
	//travelling up the tree to heapify
	private void fixHeapAbove(int index)
	{
		//this is the value we just inserted
		int newValue = heap[index];
		//if index = 0; we've hit the root
		//if we haven't hit root, compare new value against value of parent 
		while(index > 0 && newValue > heap[getParent(index)])
		{
			//then we swap the two values
			//this is assigning the parent to where the newValue currently lives
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		//didn't assign the newValue to where parent lives earlier because we were
		//comparing the value against its parent and if >, assign the parent down, didn't actually assign the value to the parent
		//since might need to compare to parent of parent
		//only assigned when we have found correct position, shifting parents down, and bubbling up
		//which happens when we have dropped out of the while loop
		heap[index] = newValue;

	}
	
	//isEmpty method
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	//method for getting the children of an element in the array
	public int getChild(int index, boolean left)
	{
		//return result of expressions from slides
		//2*index + 1 for left, 2*index + 2 for right
		//so if left is true, then we go with 2*index + 1, otherwise 2*index + 2
		return 2 * index + (left ? 1 : 2);
	}
	
	//delete method
	//taking index not value, because we don't want to search heap for the index if given the value
	//can't sort the array either, so index is easier
	public int delete(int index)
	{
		//check whether heap is empty
		if(isEmpty())
		{
			//throw an exception like before
			throw new IndexOutOfBoundsException("Heap is empty.");
		}
		//parent of deleted item
		int parent = getParent(index);
		//save the deletedValue off since returning at the end of the method
		int deletedValue = heap[index];
		
		//replace heap[index] with value at the rightmost position in the array at index size - 1
		//this does the replacement step
		heap[index] = heap[size - 1];
		//if node deleted is the root or heap[index] < heap[parent] then we need to look below to heapify
		if(index == 0 || heap[index] < heap[parent])
		{
			fixHeapBelow(index, size - 1);
		}
		else
		{
			fixHeapAbove(index);
		}
		//decrement the size
		size--;
		//return the deleted value
		return deletedValue;
	}
	
	//fix heap BELOW
	private void fixHeapBelow(int index, int lastHeapIndex)
	{
		int childToSwap;
		//if the value at heap[index] less than either of its children, swap with child with greatest value
		//so start at index and go to the end of the heap
		while(index <= lastHeapIndex)
		{
			//get left and right child of the node at heap[index]
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);
			//need to check if valid
			if(leftChild <= lastHeapIndex)
			{
				//then this node has a left child
				if(rightChild > lastHeapIndex)
				{
					//then it doesn't have a right child
					//in that case the child we want to swap is the left child
					childToSwap = leftChild;
				}
				//otherwise there is a right child as well
				//need to swap it with the child that has the largest value
				else
				{
					//if heap[leftChild] > heap[rightChild], childToSwap = leftChild
					//otherwise childToSwap = rightChild
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}
				//need to compare the child at heap[index] with the childToSwap value
				//if the value at heap[index] > childToSwap, we're done, parent > child
				//need to swap if < childToSwap
				if(heap[index] < heap[childToSwap])
				{
					//swap
					int tmp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = tmp;
				}
				else
				{
					break;
				}
				
				index = childToSwap;
			}
			else
			{
				break;
			}
		}
	}
	
	//heap sort method (also is in-place, doesn't require extra memory)
	//once sorted, the heap is no longer a heap; so make sure you don't want it to continue to be a heap before sorting
	//worst case is O(n*log(n)) because worst case is we swap n elements, and on each iteration, we also have to heapify, which is log(n)
	public void sort()
	{
		//when we start
		int lastHeapIndex = size - 1;
		for(int i = 0; i < lastHeapIndex; i++)
		{
			//swap root with last item in the heap; which is being reduced by 1 on each iteration
			int tmp = heap[0];
			//location of last item in the heap, every single time we exchange the root
			heap[0] = heap[lastHeapIndex - i];
			heap[lastHeapIndex - i] = tmp;
			//need to fix heap below
			//subtract by 1 because want to exclude where we put the root
			fixHeapBelow(0, lastHeapIndex - i - 1);
		}
	}
	
	//print the heap
	public void printHeap()
	{
		for(int i = 0; i < size; i++)
		{
			System.out.print(heap[i]);
			System.out.print(", ");
		}
		System.out.println();
	}
	
	//peek method
	public int peek()
	{
		if(isEmpty())
		{
			//throw an exception like before
			throw new IndexOutOfBoundsException("Heap is empty.");
		}
		//otherwise return what's at the root, which is always at heap[0]
		return heap[0];
	}
}
