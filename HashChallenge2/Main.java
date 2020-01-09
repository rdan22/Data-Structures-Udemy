package HashChallenge2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
        
        for(int i = 0; i < employees.size(); i++)
		{
			System.out.print(employees.get(i) + " ");
			System.out.println(" ");
		}

        //create the hashmap of ints and employees
        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        //need to traverse the list -> list iterator
        ListIterator<Employee> iterator = employees.listIterator();
        //need another list; as use list iterator, can't remove a duplicate when found because runtime will throw exception
        //bc list cannot change
        List<Employee> remove = new ArrayList<>();

        //iterate through list
        while (iterator.hasNext()) {
        	//get employee
            Employee employee = iterator.next();
            //check whether id is already in the hashtable
            if (employeeTable.containsKey(employee.getId())) {
            	//then remove the duplicate
                remove.add(employee);
            }
            else {
            	//otherwise add the employee and key (id) into the hashmap
                employeeTable.put(employee.getId(), employee);
            }
        }
        
        //actually remove the duplicates from the list
        //iterate the remove list 
        for (Employee employee: remove) {
            employees.remove(employee);
        }

        //print out the employees
        System.out.println("-------------------------");
        for(int i = 0; i < employees.size(); i++)
		{
			System.out.print(employees.get(i) + " ");
			System.out.println(" ");
		}
        
	}
	
	//hash function
	public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
