package JDKLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		Employee billEnd = new Employee("Bill", "End", 78);
		
		LinkedList<Employee> list = new LinkedList<>();
		
		//note Mike Wilson will be at the front
		list.addFirst(janeJones);
		list.addFirst(johnDoe);
		list.addFirst(marySmith);
		list.addFirst(mikeWilson);
		
		//linked list class does have an iterator so we use that to print
		Iterator<Employee> iter = list.iterator();
		System.out.print("HEAD -> ");
		while(iter.hasNext())
		{
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("NULL");
		
		//bill will be at the end
		//or you can just use add()
		list.addLast(billEnd);
		iter = list.iterator();
		System.out.print("HEAD -> ");
		while(iter.hasNext())
		{
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("NULL");
		
		//will remove Mike Wilson
		list.removeFirst();
		iter = list.iterator();
		System.out.print("HEAD -> ");
		while(iter.hasNext())
		{
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("NULL");
		
		//will remove Bill End
		list.removeLast();
		iter = list.iterator();
		System.out.print("HEAD -> ");
		while(iter.hasNext())
		{
			System.out.print(iter.next());
			System.out.print("<=>");
		}
		System.out.println("NULL");
		
		//can also use a for loop
		/*
		for(Employee employee : list)
		{
			System.out.println(employee);
		}
		*/
	}

}
