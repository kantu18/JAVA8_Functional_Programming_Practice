package com.example.demo.practice;

public class Employee {

	private String name;
	private String address;
	private double salary;
	private String dept;
	private int  bonus;
	
	public Employee() {
		super();
		
	}

	public Employee(String name, String address, double salary, String dept, int bonus) {
		super();
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.dept = dept;
		this.bonus = bonus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + ", salary=" + salary + ", dept=" + dept + ", bonus="
				+ bonus + "]";
	}
	
}
