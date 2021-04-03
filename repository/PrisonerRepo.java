package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PrisonerRepo implements IPrisonerRepo
{
	DatabaseConnection dbc;

	public PrisonerRepo()
	{
		dbc = new DatabaseConnection();
	}

	public void insertPrisoner(Prisoner p) 
	{
		String query = "INSERT INTO prisoner VALUES ("+p.getPrisonerID()+",'"+p.getPrisonerName()+"','"+p.getCrime()+"','"+p.getEntryDate()+"','"+p.getReleasedDate()+"',"+p.getCellNo()+",'"+p.getNID()+"');";
	try
	{
		dbc.openConnection();
		dbc.st.execute(query);
		dbc.closeConnection();
	}
	catch(Exception ex){System.out.println(ex.getMessage());}
	}

	Prisoner p;

	public String[][] getAllPrisoner()
	{
		ArrayList<Prisoner> ar = new ArrayList<Prisoner>();
		String query = "SELECT * from prisoner;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String PrisonerId = dbc.result.getString("PrisonerId");
				String 	PrisonerName = dbc.result.getString("PrisonerName");
				String Crime = dbc.result.getString("Crime");
				String EntryDate = dbc.result.getString("EntryDate");
				String ReleasedDate = dbc.result.getString("ReleasedDate");
				int CellNo = dbc.result.getInt("CellNo");
				String NID = dbc.result.getString("NID");
				
				
				Prisoner p = new Prisoner(PrisonerId, PrisonerName, Crime, EntryDate, ReleasedDate, CellNo, NID);
				ar.add(p);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			
			data[i][0] = ((Prisoner)obj[i]).getPrisonerID();
			data[i][1] = ((Prisoner)obj[i]).getPrisonerName();
			data[i][2] = ((Prisoner)obj[i]).getCrime();
			data[i][3] = ((Prisoner)obj[i]).getEntryDate();
			data[i][4] = ((Prisoner)obj[i]).getReleasedDate();
			data[i][5] = ((Prisoner)obj[i]).getCellNo()+"";
			data[i][6] = ((Prisoner)obj[i]).getNID();
		}
		return data;
	}

	//--------------------------------------------------------Zahin---------------------------------------------------------------------------------

	public void insertReleased_prisoner(Prisoner p)
	{
		String query = "INSERT INTO released_prisoner VALUES ('"+p.getNID()+"','"+p.getPrisonerName()+"','"+p.getEntryDate()+"','"+p.getReleasedDate()+"','"+p.getCrime()+"');";
	try
	{
		dbc.openConnection();
		dbc.st.execute(query);
		dbc.closeConnection();
	}
	catch(Exception ex){System.out.println(ex.getMessage());}
	}

	Released_prisoner released_prisoner;


	public String[][] getAllReleased_prisoner()
	{
		ArrayList<Released_prisoner> ar = new ArrayList<Released_prisoner>();
		String query = "SELECT * FROM released_prisoner;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String NID = dbc.result.getString("NID");
				String 	PrisonerName = dbc.result.getString("PrisonerName");
				String EntryDate = dbc.result.getString("EntryDate");
				String ReleasedDate = dbc.result.getString("ReleasedDate");
				String Crime = dbc.result.getString("Crime");
				
				Released_prisoner e = new Released_prisoner(NID,PrisonerName,EntryDate,ReleasedDate,Crime);
				ar.add(e);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Released_prisoner)obj[i]).getNID()+"";
			data[i][1] = ((Released_prisoner)obj[i]).getPrisonerName();
			data[i][2] = ((Released_prisoner)obj[i]).getEntryDate();
			data[i][3] = (((Released_prisoner)obj[i]).getReleasedDate());
			data[i][4] = (((Released_prisoner)obj[i]).getCrime());
		}
		return data;
	}

	///////////////////search//////
	public Prisoner searchPrisoner(String PrisonerId)
	{
		Prisoner p = null;
		String query = "SELECT `PrisonerName`, `Crime`, `EntryDate`, `ReleasedDate`, `CellNo`, `NID` FROM `prisoner` WHERE `PrisonerId`="+PrisonerId+";";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String 	PrisonerName = dbc.result.getString("PrisonerName");
				String Crime = dbc.result.getString("Crime");
				String EntryDate = dbc.result.getString("EntryDate");
				String ReleasedDate = dbc.result.getString("ReleasedDate");
				int CellNo = dbc.result.getInt("CellNo");
				String NID = dbc.result.getString("NID");
				
				p = new Prisoner();
				p.setPrisonerID(PrisonerId);
				p.setPrisonerName(PrisonerName);
				p.setCrime(Crime);
				p.setEntryDate(EntryDate);
				p.setReleasedDate(ReleasedDate);
				p.setCellNo(CellNo);
				p.setNID(NID);

			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return p;
	}

	//////////////release//////
	


	////////////
	public void releasePrisoner(String PrisonerId){
		String query1 = "INSERT INTO released_prisoner ( NID,PrisonerName,EntryDate,ReleasedDate,Crime )  SELECT NID,PrisonerName,EntryDate,ReleasedDate,Crime FROM prisoner WHERE PrisonerId="+PrisonerId+";";

		try
		{
			dbc.openConnection();
			dbc.st.execute(query1);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}


		String query = "DELETE from prisoner WHERE PrisonerId="+PrisonerId+";";

		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}

	}


	
}