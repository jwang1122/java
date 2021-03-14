package com.huaxia.java1.homework;

public class ClassHW3 {

	public static void main(String[] args) {
		Employee e1 = new Employee(111,"John", "Martine", 8000);
		System.out.println(e1);

	}

}

class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int salary;

	public Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public void raiseSalary(int percent) {
		salary = (int) (salary * (1 + percent / 100.0));
	}

	public int getAnnualSalary() {
		return salary * 12;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + firstName + " " + lastName + ", salary=" + salary + "]";
	}

}