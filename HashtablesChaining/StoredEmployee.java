package HashtablesChaining;

//in order to store both ORIGINAL key and employee
//but this is all we need in our stored employee class, will have to update hashtable class
public class StoredEmployee {
	//raw key, not hashedKey
		public String key;
		public Employee employee;
		//constructor
		public StoredEmployee(String key, Employee employee) {
			super();
			this.key = key;
			this.employee = employee;
		}

}
