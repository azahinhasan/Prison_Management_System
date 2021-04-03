package entity;

import java.lang.*;

public class Visitor
{
	private String vname;
	private String relationship;
	private String serial;

	private String time;
	private String date;
	private String prisonerId;

	
	public Visitor(){}
	public Visitor(String serial, String prisonerId, String vname, String relationship, String date, String time)
	{
		this.vname = vname;
		this.relationship = relationship;
		this.serial = serial;
		this.time=time;
		this.date=date;
		this.prisonerId=prisonerId;
		
	}
	
	public void setvname(String vname)
	{
		this.vname = vname;
    }
	public void setrelationship(String relationship)
	{
		this.relationship = relationship;
	}
	public void setserial(String serial)
	{
		this.serial = serial;
	}

	public void settime(String time)
	{
		this.time = time;
	}
	public void setdate(String date)
	{
		this.date = date;
	}
	public void setprisonerId(String prisonerId)
	{
		this.prisonerId = prisonerId;
	}
	
	
	public String getvname()
	{
		return vname;
	}
	public String getrelationship()
	{
		return relationship;
	}
	public String getserial()
	{
		return serial;
	}
	public String gettime()
	{
		return time;
	}
	public String getdate()
	{
		return date;
	}
	public String getprisonerId()
	{
		return prisonerId;
	}
	
}