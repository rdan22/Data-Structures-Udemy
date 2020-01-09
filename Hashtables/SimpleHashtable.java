package Hashtables;

public class SimpleHashtable {

	//array backing hashtable
	private StoredEmployee[] hashtable;
	
	//constructor for array
	public SimpleHashtable()
	{
		hashtable = new StoredEmployee[10];
	}
	
	//need a hashing function
	//accepts a string, will use employee last name as key
	private int hashKey(String key)
	{
		//returns key length modded by hashtable length
		//takes a string and hashs to an int
		return key.length() % hashtable.length;
		//janejones: key length is 5, hashtable length is 10, so 5 % 10 is 5 -> will be used as index in backing array
		//modding by length of hashtable will ensure we have indices between 0 and 9, since length is 10
		//the id could also be used for the key -> but would still be hashed
		//alteratively, length of hashtable could be 26, could have the hashedKey be the first letter of the last name or something
		//but there would still be collisions
	}
	
	//add method, will require key and value
	public void put(String key, Employee employee)
	{
		//hash the key
		int hashedKey = hashKey(key);
		//need a simple hashtable, will not handle collisions yet
		//meaning there's already an employee at that position in the array
		//if occupied need to do linear probing 
		if(occupied(hashedKey))
		{
			//need to set a stop index (when we have looked through entire array
			//wrap when hit end of array 
			//index will equal hashedKey, we've checked that position and if we loop around and hit it again, we've checked the array
			int stopIndex = hashedKey;
			if(hashedKey == hashtable.length - 1)
			{
				//wrap and initial probe
				hashedKey = 0;
			}
			else
			{
				hashedKey++;
			}
			//if occupied and have not hit the end of array
			while(occupied(hashedKey) && hashedKey != stopIndex)
			{
				//keep incrementing the hashedKey
				//if we hit the last position (10), then that's not possible, so 10 % 10 = 0 and that wraps it to beginning
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		}
		//if still no space
		if(occupied(hashedKey))
		{
			System.out.println("Sorry, there's already an employee at position " + hashedKey);
		}
		else
		{
			//assign employee to the position in the hashtable 
			//need to store new instance of stored employee
			hashtable[hashedKey] = new StoredEmployee(key, employee);
		}
	}
	
	//retrieval method, will require key, will return employee
	//will utilize find key method to find employee with given key
	public Employee get(String key)
	{
		//hash the key 
		int hashedKey = findKey(key);
		//if hashedKey = -1, return null because that means no employee with key we're looking for 
		if(hashedKey == -1)
		{
			return null;
		}
		//otherwise return the employee; since we have stored employee instances in the hashtable now, add the .employee 
		return hashtable[hashedKey].employee;
	}
	
	//find key method, pass the raw key as the parameter
	private int findKey(String key)
	{
		//first thing is to hash it
		int hashedKey = hashKey(key);
		//want to know if employee that's stored at hashedKey was added with key we're interested in 
		//if value is not null and the hashedKey's original key is the raw key
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
		{
			//then we return the hashedKey
			return hashedKey;
		}
		//same as in the put method
		int stopIndex = hashedKey;
		if(hashedKey == hashtable.length - 1)
		{
			hashedKey = 0;
		}
		else
		{
			hashedKey++;
		}
		//while we haven't completely wrapped around, while the value exists, and the hashedKey doesn't equal original key
		while(hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key))
		{
			//then we haven't searched entire array 
			hashedKey = (hashedKey + 1) % hashtable.length;
		}
		//if not empty and hashedKey is original key then return hashedKey
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key))
		{
			return hashedKey;
		}
		//otherwise if null or whatever is there doesn't contain what we're looking for, when 
		//we've looped around and hit the stop index then 
		else
		{
			return -1;
		}
	}
	
	//remove method
	//will also use linear probing because we have to find the employee that we're going to remove
	public Employee remove(String key)
	{
		int hashedKey = findKey(key);
		//no employee with that key, so nothing to remove
		if(hashedKey == -1)
		{
			return null;
		}
		//otherwise
		Employee employee = hashtable[hashedKey].employee;
		//null out the position
		//but need to be able to find some positions, so can't just null it out
		hashtable[hashedKey] = null;
		//create new hashtable
		StoredEmployee[] oldHashtable = hashtable;
		hashtable = new StoredEmployee[oldHashtable.length];
		for(int i = 0; i < oldHashtable.length; i++)
		{
			//hash all the old items in the hashtable and put into the new one
			if(oldHashtable[i] != null)
			{
				//then we rehash, putting it into the new hashtable
				put(oldHashtable[i].key, oldHashtable[i].employee);
			}
		}
		return employee;
	}
	
	//check whether occupied
	private boolean occupied(int index)
	{
		//if not equal to null, return true; otherwise if equal to null (it's empty), return false
		return hashtable[index] != null;
	}
	
	//print method
	public void printHashtable()
	{
		for(int i = 0; i < hashtable.length; i++)
		{
			//have to consider nulls
			if(hashtable[i] == null)
			{
				System.out.println("Empty");
			}
			else
			{
				System.out.println("Position " + i + ": " + hashtable[i].employee);
			}
		}
	}
}
