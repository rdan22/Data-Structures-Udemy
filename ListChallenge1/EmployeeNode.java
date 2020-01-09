package ListChallenge1;

public class EmployeeNode {
	//3 variables, employee and references: previous AND next
	private Employee employee;
	private EmployeeNode previous;
	private EmployeeNode next;

	//for constructor we just need the employee
	//only takes employees because when we construct an instance we don't know yet what the next node will be
	public EmployeeNode(Employee employee)
	{
		this.employee = employee;
	}

	//setters and getters
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}

	public EmployeeNode getPrevious() {
		return previous;
	}

	public void setPrevious(EmployeeNode previous) {
		this.previous = previous;
	}

	//call employee toString method
	//when we print a node, it will print a result of this toString method
	public String toString()
	{
		return employee.toString();
	}

}
