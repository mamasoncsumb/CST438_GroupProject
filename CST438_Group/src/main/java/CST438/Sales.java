package CST438;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sales {
	
	@Id
	private int id;
	
	private int productid;
	private int empid;
	private int qtysold;
	private String datesold;
	
	
	public Sales(){};
	
	public Sales(int empid, int productId, int qtySold, String dateSold)
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
	
	public void setDateSold(String dateSold)
	{
		this.datesold = dateSold;
	}
	
	public int getqtySold()
	{
		return qtysold;
	}
	
	public String getDateSold()
	{
		return datesold;
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
