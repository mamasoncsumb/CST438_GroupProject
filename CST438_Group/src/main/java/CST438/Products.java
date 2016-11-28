package CST438;

import javax.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Products {
	
	@Id
	private int productid;
	
	private String productname;
	private float productprice;

	
	public Products()
	{}
	
	public Products(int id, String productname, float productprice)
	{
		this.productid = id;
		this.productname = productname;
		this.productprice = productprice;
	}
	
	public void setProductid(int id)
	{
		this.productid = id;
	}
	
	public void setproductName(String productname)
	{
		this.productname = productname;
	}
	

	public int getProductid()
	{
		return this.productid;
	}
	
	public String getproductName()
	{
		return this.productname;
	}
	
	public void setProductPrice(float productPrice)
	{
		this.productprice = productPrice;
	}
	
	public float getProductPrice()
	{
		return this.productprice;
	}

}

