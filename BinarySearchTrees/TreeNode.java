//if tree is empty when we try to insert a node, then the node becomes a root
//if tree isn't empty, compare value with the root node, rinse and repeat
//at each step we compare to current node we're looking at and keep traversing until we hit an empty spot
//will not be allowing duplicate values 
package BinarySearchTrees;

public class TreeNode {

	//three fields
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	//constructor
	//when node is constructed, it will be a leaf node at first
	//don't have anything to assign to left and right child
	public TreeNode(int data)
	{
		this.data = data;
	}
	
	public void insert(int value)
	{
		//check first if value equals the node value
		if(value == data)
		{
			//if so, then don't do anything
			return;
		}
		
		if(value < data)
		{
			//go to the left
			//if there is no left child
			if(leftChild == null)
			{
				//we have found our insertion point
				leftChild = new TreeNode(value);
			}
			//but if node does have a left child
			//call insert method on the left child
			else
			{
				//compare the value against the left child
				//so call insert method ON the left child itself
				leftChild.insert(value);
			}
		}
		
		else
		{
			//we go to the right
			//if there is no right child
			if(rightChild == null)
			{
				//we have found our insertion spot
				rightChild = new TreeNode(value);
			}
			//but if node does have a right child
			//call insert method on the right child
			rightChild.insert(value);
		}
					
	}
	
	//traversal in order method
	//Every node's left subtree will be printed out first!!
	public void traverseInOrder()
	{
		//if there is a left child, traverse it first
		if(leftChild != null)
		{
			leftChild.traverseInOrder();
		}
		//then print out data
		System.out.print(data + ", ");
		//if there is a right child, traverse it next
		if(rightChild != null)
		{
			rightChild.traverseInOrder();
		}
		
	}
	
	//method to get node from tree
	public TreeNode get(int value)
	{
		//check the value against value of node
		//if equal, we found node we were looking for, else search left or right subtree depending on whether <, >
		if(value == data)
		{
			return this;
		}
		if(value < data)
		{
			//search left subtree as long as node has one
			if(leftChild != null)
			{
				//call this method recursively
				//then call get on leftChild
				return leftChild.get(value);
			}
		}
		else
		{
			//search right subtree as long as node has one
			if(rightChild != null)
			{
				//call this method recursively
				//then call get on rightChild
				return rightChild.get(value);
			}
		}
		//if we make it down here, couldn't find value in the tree, so will return null tree node
		return null;
	}
	
	//min method
	public int min()
	{
		//not returning tree node, since when we implement delete, we want int returned not TreeNode
		//if node doesn't have left child, then we found the min value
		if(leftChild == null)
		{
			return data;
		}
		//otherwise want to continue traversing left
		else
		{
			//and call min on the left child this time
			return leftChild.min();
		}
	}	
	
	//max method
	public int max()
	{
		//if node doesn't have a right child, then we found the max value
		if(rightChild == null)
		{
			return data;
		}
		//otherwise continue traversing the right 
		else
		{
			//call max on the right child this time
			return rightChild.max();
		}
	}
	
	//getters and setters
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	public String toString() 
	{
	    return "Data = " + data;
	}
	
}
