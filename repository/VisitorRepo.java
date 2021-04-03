package repository;

import java.lang.*;

import entity.*;
import interfaces.*;
import java.util.ArrayList;

public class VisitorRepo implements IVisitorRepo
{
	DatabaseConnection dbc;
	
	public VisitorRepo()
	{
		dbc = new DatabaseConnection();
	}

	public void insertVisitor(Visitor v)
	{
		String query = "INSERT INTO visitor VALUES ("+v.getserial()+","+v.getprisonerId()+",'"+v.getvname()+"','"+v.getrelationship()+"','"+v.getdate()+"','"+v.gettime()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}



	Visitor v;

	public String[][] getAllVisitor()
	{
		ArrayList<Visitor> ar = new ArrayList<Visitor>();
		String query = "SELECT * FROM visitor;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String vname = dbc.result.getString("Visitor Name");
				String relationship = dbc.result.getString("Relation");
				String serial = dbc.result.getString("Serial");
				String time = dbc.result.getString("Time");
				String date = dbc.result.getString("Date");
				String prisonerId = dbc.result.getString("prisonerId");
				
				Visitor v = new Visitor(serial, prisonerId, vname, relationship, date, time);
				ar.add(v);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][6];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Visitor)obj[i]).getserial();
			data[i][1] = ((Visitor)obj[i]).getprisonerId();
			data[i][2] = ((Visitor)obj[i]).getvname();
			data[i][3] = ((Visitor)obj[i]).getrelationship();
			data[i][4] = ((Visitor)obj[i]).getdate();
			data[i][5] = ((Visitor)obj[i]).gettime();
			
			
			
		}
		return data;
	}
}