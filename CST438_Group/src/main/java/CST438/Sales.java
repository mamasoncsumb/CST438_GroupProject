package CST438;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
public class Sales {
	
	@Id
	private int id;
	
	private int productid;
	private int empid;
	private int qtysold;
	private Date datesold;
	
	
	public Sales(){};
	
	public Sales(int empid, int productId, int qtySold, Date dateSold)
	{
		this.productid = productId;
		this.empid = empid;
		this.qtysold = qtySold;
		this.datesold = dateSold;
	}
	
	public void setqtySold(int qtySold)
	{
		this.qtysold = qtySold;
	}
	
	public void setDateSold(Date dateSold)
	{
		this.datesold = dateSold;
	}
	
	public int getqtySold()
	{
		return qtysold;
	}
	
	public Date getDateSold()
	{
		return datesold;
	}
	
	public int getMonthSold()
	{
		return datesold.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	public int getYearSold()
	{
		return datesold.getYear()+1900;
	}
	
	public void setProductId(int productId)
	{
		this.productid = productId;
	}
	
	public int getProductId()
	{
		return productid;
	}
	
	public void setEmpId(int productId)
	{
		this.empid = productId;
	}
	
	public int getEmpId()
	{
		return empid;
	}
	
	public void setId(int Id)
	{
		this.empid = Id;
	}
	
	public int getId()
	{
		return id;
	}
}
