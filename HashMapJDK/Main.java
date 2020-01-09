package HashMapJDK;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		//creating the hash map
		Map<String, Employee> hashMap = new HashMap<String, Employee>();
		hashMap.put("Jones", janeJones);
		hashMap.put("Doe", johnDoe);
		hashMap.put("Smith", marySmith);
		hashMap.put("Wilson", mikeWilson);
		
		//determine if map contains a key or value
		//both will return true
		//always better to have the key 
		System.out.println(hashMap.containsKey("Doe"));
		System.out.println(hashMap.containsValue(janeJones));
		
		//putifabsent method; only insert someone if key has not been used; also requires java 8 
		//hashMap.putIfAbsent("Doe", mikeWilson);
		
		//getordefault method that let's u specify a default value; also requires java 8 
		//System.out.println(hashMap.getOrDefault("someone", mikeWilson));
		
		//remove employees
		hashMap.remove("Jones");
		
		//to print out we use iterator
		//won't be in the order we added them because depends on hashed key
		Iterator<Employee> iterator = hashMap.values().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		//alternatively (only for java 8)
		//hashMap.forEach((k, v) -> System.out.println("Key = " + k + "Employee = " + v));
		
	}

}
