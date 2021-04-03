package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo
{
	DatabaseConnection dbc;
	
	public EmployeeRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Employee e)
	{
		String query = "INSERT INTO employees VALUES ('"+e.getEmpId()+"','"+e.getName()+"','"+e.getDesignation()+"',"+e.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String empId)
	{
		String query = "DELETE from employees WHERE empId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Employee e)
	{
		String query = "UPDATE employees SET employeeName='"+e.getName()+"', designation = '"+e.getDesignation()+"', salary = "+e.getSalary()+" WHERE empId='"+e.getEmpId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Employee searchEmployee(String empId)
	{
		Employee emp = null;
		String query = "SELECT `employeeName`, `designation`, `salary` FROM `employees` WHERE `empId`='"+empId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				emp = new Employee();
				emp.setEmpId(empId);
				emp.setName(name);
				emp.setDesignation(designation);
				emp.setSalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllEmployee()
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		String query = "SELECT * FROM employees;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String empId = dbc.result.getString("empId");
				String name = dbc.result.getString("employeeName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				Employee e = new Employee(empId,name,designation,salary);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEmpId();
			data[i][1] = ((Employee)obj[i]).getName();
			data[i][2] = ((Employee)obj[i]).getDesignation();
			data[i][3] = (((Employee)obj[i]).getSalary())+"";
		}
		return data;
	}
}












































