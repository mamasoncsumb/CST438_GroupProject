package CST438;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Employee {
	
	@Id
	private int empid;
	private String firstname;
	private String lastname;
	private Date hiredate;
	
	public Employee(){}
	
	public Employee(int empid, String fname, String lname, Date date)
	{
		this.empid = empid;
		this.firstname = fname;
		this.lastname = lname;
		this.hiredate = date;
	}

	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	
	public void setFirstname(String fname)
	{
		this.firstname = fname;
	}
	
	public void setLastname(String lname)
	{
		this.lastname = lname;
	}
	
	public void sethiredate(Date date)
	{
		this.hiredate = date;
	}
	
	public int getEmpid()
	{
		return this.empid;
	}
	
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public String getLastname()
	{
		return this.lastname;
	}
	
	public Date gethiredate()
	{
		return this.hiredate;
	}
}
