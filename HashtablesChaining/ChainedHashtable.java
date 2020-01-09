package HashtablesChaining;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
	
	//hashtable
	//linked list of stored employee, want an array of linked lists
	private LinkedList<StoredEmployee>[] hashtable;
	//constructor
	public ChainedHashtable()
	{
		hashtable = new LinkedList[10];
		//initialize each array position with an empty linked list
		for(int i = 0; i < hashtable.length; i++)
		{
			//create an instance of linkedlist of stored employees at every position
			//alternatively could create an object array and store either a stored employee if only one item
			//or once we get a collision, we change it to a linked list
			hashtable[i] = new LinkedList<StoredEmployee>();
		}
	}
	
	//put method
	public void put(String key, Employee employee)
	{
		int hashedKey = hashKey(key);
		//add the employee to the linked list thats at the position hashedKey
		hashtable[hashedKey].add(new StoredEmployee(key, employee));
	}
	
	//get method
	public Employee get(String key)
	{
		int hashedKey = hashKey(key);
		//search linked list at position hashedKey for stored employee that matches this key
		//can use list iterator
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		//now use to find the employee that has the key
		//set to null
		StoredEmployee employee = null;
		while(iterator.hasNext())
		{
			//set employee to the iterator.next 
			employee = iterator.next();
			//if key equals the key we are looking for
			if(employee.key.equals(key))
			{
				//then we have found our employee
				//local field is actually a stored employee
				return employee.employee;
			}
		}
		
		//if we drop out of loop without having found stored employee instance that matches the key so just return null
		return null;
	}
	
	//remove method
	public Employee remove(String key)
	{
		int hashedKey = hashKey(key);
		//search linked list at position hashedKey for stored employee that matches this key
		//can use list iterator
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		//now use to find the employee that has the key
		//set to null
		StoredEmployee employee = null;
		//since first starts at position 0
		int index = -1;
		while(iterator.hasNext())
		{
			//set employee to the iterator.next 
			employee = iterator.next();
			index++;
			//if key equals the key we are looking for
			if(employee.key.equals(key))
			{
				//then we have found our employee
				break;
			}
		}

		//if we drop out of loop, there's two possibilities:
		//we have completely traversed list and haven't found stored employee instance that matches OR
		//the stored employee field now containes the employee we're interested in
		//so if employee is null OR the key of the employee is not the same
		//it means traversed list and didn't find employee we're looking for 
		if(employee == null || !employee.key.equals(key))
		{
			return null;
		}
		//otherwise we found the employee and want to remove it
		else
		{
			hashtable[hashedKey].remove(index);
			//local field is actually a stored employee
			return employee.employee;
		}
	}
	
	//print hashtable method
	public void printHashtable()
	{
		for(int i = 0; i < hashtable.length; i++)
		{
			//don't want to traverse an empty linked list
			if(hashtable[i].isEmpty())
			{
				System.out.println("Position " + i + ": empty");
			}
			else
			{
				System.out.print("Position " + i + ": ");
				//use a list iterator 
				ListIterator<StoredEmployee> iterator = hashtable[i].listIterator();
				//while next
				while(iterator.hasNext())
				{
					//print employee field in stored employee
					System.out.print(iterator.next().employee);
					System.out.print("=>");
				}
				System.out.println("null");
			}
		}
	}
	//hashing function (the same as before)
	//still has to produce an array index
	private int hashKey(String key)
	{
		//return key.length() % hashtable.length;
		//let's use the hashCode method now
		//hashcode can produce negative numbers
		//always mod by hashtable length because you have to make sure values returned are valid array indices
		return Math.abs(key.hashCode() % hashtable.length);
	}
}

