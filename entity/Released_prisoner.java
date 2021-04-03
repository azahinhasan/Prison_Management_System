package entity;

import java.lang.*;
import java.util.Date;

public class Released_prisoner
{
	private String PrisonerName;
	
	private String  EntryDate;
	private String  ReleasedDate;
	private String  NID;
	private String Crime;

	
	public Released_prisoner(){}
	public Released_prisoner(String NID, String PrisonerName,String EntryDate,String ReleasedDate,String Crime)
	{
		this.PrisonerName=PrisonerName;
		this.EntryDate=EntryDate;
		this.ReleasedDate=ReleasedDate;	
		this.Crime=Crime;
		this.NID=NID;
	}
	
	public void setPrisonerName(String PrisonerName){
		this.PrisonerName=PrisonerName;
	}
	public void setEntryDate(String EntryDate){
		this.EntryDate=EntryDate;
	}
	public void setReleasedDate(String ReleasedDate){
		this.ReleasedDate=ReleasedDate;
	}
	public void setNID(String NID){
		this.NID=NID;
	}
	public void setCrime(String Crime){
		this.Crime=Crime;
	}
	

	public String getPrisonerName(){ return PrisonerName;}
	
	public String getEntryDate(){ return EntryDate;}
	public String getReleasedDate(){ return ReleasedDate;}
	public String getCrime(){ return Crime;}
	public String getNID(){ return NID;}
}
