package entity;

import java.lang.*;

public class Employee
{
	private String empId;
	private String name;
	private String designation;
	private double salary;
	
	public Employee(){}
	public Employee(String empId, String name, String designation, double salary)
	{
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public void setEmpId(String empId){this.empId = empId;}
	public void setName(String name){this.name = name;}
	public void setDesignation(String designation){this.designation = designation;}
	public void setSalary(double salary){this.salary = salary;}
	
	public String getEmpId(){return empId;}
	public String getName(){return name;}
	public String getDesignation(){return designation;}
	public double getSalary(){return salary;}
}