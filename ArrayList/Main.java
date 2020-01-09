package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//By using List, if we decided to use a different type of list later, it is easier to change
		//backing array of length 10 is created, but we have only 4 employees
		//backing array doesn't need to be resized
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee("Jane", "Jones", 123));
		employeeList.add(new Employee("John", "Doe", 4567));
		employeeList.add(new Employee("Mary", "Smith", 22));
		employeeList.add(new Employee("Mike", "Wilson", 3245));
		
		for(int i = 0; i < employeeList.size(); i++)
		{
			System.out.print(employeeList.get(i) + " ");
			System.out.println(" ");
		}
		
		//should be john doe
		System.out.println(employeeList.get(1));
		
		//will be false
		System.out.println(employeeList.isEmpty());
		
		//replaces the element at index 1 with a new employee
			//employeeList.set(1, new Employee("John", "Adams", 4568));
		
		//will print size, which is 4
		System.out.println(employeeList.size());
		
		//to add an employee at a specific position (worst case is O(n))
			//employeeList.add(3, new Employee("John", "Adams", 4568));
		
		//to get the backing array holding the employees (it would be an object array)
		//if we want an employee array we need to tell the compiler which we want so we pass the array type
		Employee [] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
		for(Employee employee : employeeArray)
		{
			System.out.println(employee);
		}

		//want to check if the list contains an employee
		//without implementing equals method in object will get false since not the exact same instance
		System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22)));
		
		//want to look up an employee
		System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));
		
		//want to remove an employee
			//employeeList.remove(2);
	}

}
