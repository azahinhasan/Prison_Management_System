package entity;

import java.lang.*;
import java.util.Date;

public class Prisoner
{
	private String PrisonerName;
	private String PrisonerId;
	private String  EntryDate;
	private String  ReleasedDate;
	private int  CellNo;
	private String  NID;
	private String Crime;

	
	public Prisoner(){}
	public Prisoner(String PrisonerId,String PrisonerName, String Crime, String EntryDate, String ReleasedDate, int CellNo, String NID)
	{
		this.PrisonerName=PrisonerName;
		this.PrisonerId=PrisonerId;
		this.CellNo=CellNo;
		this.EntryDate=EntryDate;
		this.ReleasedDate=ReleasedDate;	
		this.Crime=Crime;
		this.NID=NID;
	}
	
	public void setPrisonerName(String PrisonerName){
		this.PrisonerName=PrisonerName;
	}
	public void setPrisonerID(String PrisonerId){
		this.PrisonerId=PrisonerId;
	}
	public void setCellNo(int CellNo){
		this.CellNo=CellNo;
	}

	public void setEntryDate(String EntryDate){
		this.EntryDate=EntryDate;
	}
	public void setReleasedDate(String ReleasedDate){
		this.ReleasedDate=ReleasedDate;
	}
	public void setCrime(String Crime){  
		this.Crime=Crime;
	}
	public void setNID(String NID){ 
		this.NID=NID;
	}

	

	public String getPrisonerName(){ return PrisonerName;}
	public String getPrisonerID(){ return PrisonerId;}
	public int getCellNo(){ return CellNo;}

	public String getEntryDate(){ return EntryDate;}
	public String getReleasedDate(){ return ReleasedDate;}
	public String getCrime(){ return Crime;}
	public String getNID(){ return NID;}
}
