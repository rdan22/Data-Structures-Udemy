package HashtablesChaining;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		//create the hashtable, don't have to pass capacity
		ChainedHashtable ht = new ChainedHashtable();
		
		ht.put("Jones", janeJones);
		ht.put("Doe", johnDoe);
		ht.put("Wilson", mikeWilson);
		ht.put("Smith", marySmith);
		
		ht.printHashtable();
		
		System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
		System.out.println("Retrieve key Smith: " + ht.get("Smith"));
		
		ht.remove("Doe");
		ht.remove("Jones");
		ht.printHashtable();
		System.out.println("Retrieve key Smith: " + ht.get("Smith"));

	}
}

