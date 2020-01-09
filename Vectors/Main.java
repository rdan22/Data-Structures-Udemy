package Vectors;

import java.util.List;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//vector also implements list!
		//will also use backing array
		List<Employee> employeeList = new Vector<>();
		
		employeeList.add(new Employee("Jane", "Jones", 123));
		employeeList.add(new Employee("John", "Doe", 4567));
		employeeList.add(new Employee("Mary", "Smith", 22));
		employeeList.add(new Employee("Mike", "Wilson", 3245));
		
		for(int i = 0; i < employeeList.size(); i++)
		{
			System.out.print(employeeList.get(i) + " ");
			System.out.println(" ");
		}
	}

}
