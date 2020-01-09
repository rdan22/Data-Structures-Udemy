package BinarySearchTrees;

public class Tree {

	//we only need one field, the root node
	private TreeNode root;
	//insertion method
	public void insert(int value)
	{
		//this is what the caller would actually call to insert a value into the tree
		//check if the root is null
		if(root == null)
		{
			root = new TreeNode(value);
		}
		else
		{
			//then we want it pretty much do what we did in TreeNode
			//call the insert method on root, would then be compared with the root 
			root.insert(value);
		}
	}
	//in order traversal
	public void traverseInOrder()
	{
		//as long as root exists, traverse it
		if(root != null)
		{
			root.traverseInOrder();
		}
	}
	//get method
	public TreeNode get(int value)
	{
		//if root exists
		if(root != null)
		{
			//call get on it
			return root.get(value);
		}
		//otherwise tree is empty so value would not be in the tree
		return null;
	}
	
	//delete method
	public void delete(int value)
	{
		//call a second method that will be recursive
		//passing the root of the subtree that we want to search for the value to be deleted
		//what will return is the root of the tree
		root = delete(root, value);
		
	}
	
	//actual delete method 
	//returns replacement node; if not being replaced get same node back
	private TreeNode delete(TreeNode subtreeRoot, int value)
	{
		//first check if null
		if(subtreeRoot == null)
		{
			return subtreeRoot;
		}
		//3 possibilities: either root of subtree is value we are looking for so that's the node to be deleted
		//or search left subtree or search right subtree
		if(value < subtreeRoot.getData())
		{
			//remember this value returns replacement node
			//search left subtree
			//this is saying: if the value is less than the root of the subtree we're searching, we move to the subtree's leftchild
			//and in the end we replace the subtree's left child with whatever the result of the delete is
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		}
		else if(value > subtreeRoot.getData())
		{
			//same thing as above but go to the right
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
		}
		//otherwise we have found the node to delete, the subtree root
		else
		{
			//Cases 1 and 2: either has no children or 1 child
			//first check if null
			if(subtreeRoot.getLeftChild() == null)
			{
				//either this is a leaf, so right child is also null or it has a right child
				//if it has 0 children, then lock off node; replacement node is null
				//otherwise replacement node is the right child
				return subtreeRoot.getRightChild();
			}
			//otherwise we do the same thing for the right child
			else if(subtreeRoot.getRightChild() == null)
			{
				//if no right or left child, then just lock me off
				//so return null
				return subtreeRoot.getLeftChild();
			}
			//Case 3: it has two children
			//we want to find the minimum value in the right subtree
			//can call the min method!
			//subtreeRoot is going to be deleted
			//want to replace value in the subtreeRoot node with the smallest value from the Right subtree
			subtreeRoot.setData(subtreeRoot.getRightChild().min());
			//delete the node that has the smallest value in the right subtree, our replacement node, using the delete method
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
		}
		//if we make it down here, the subtree root is not the node to be deleted so just return it
		return subtreeRoot;
		
	}
	
	//min method
	public int min()
	{
		//if root doesn't exist, then it can't contain a value
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		//otherwise return root.min()
		else
		{
			return root.min();
		}
	}
	
	//max method
	public int max()
	{
		//if root doesn't exist, then it can't contain a value
		if(root == null)
		{
			return Integer.MAX_VALUE;
		}
		//otherwise return root.max()
		else
		{
			return root.max();
		}
	}
}
