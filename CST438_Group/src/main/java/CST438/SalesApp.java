package CST438;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/sales")
public class SalesApp {
	
	public static List<Products> productList;
	public static List<Sales> salesList;
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myapp");
	
	@GET
	@Path("/product")
	@Produces ({MediaType.APPLICATION_JSON})
	public List<Products> getProducts()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select p from Products p");

		List<Products> result = (List<Products>)q.getResultList();
		
		this.productList = result;
		
		return result;
	}
	
	@GET
	@Path("/sales")
	@Produces ({MediaType.APPLICATION_JSON})
	public List<Sales> getSales()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select s from Sales s");

		List<Sales> result = (List<Sales>)q.getResultList();
		
		this.salesList = result;
		
		testLists();
		
		return result;
	}
	
	public void testLists()
	{
		for(Products product:this.productList)
		{
			for (Sales sale: this.salesList)
			{
				if(product.getProductid() == sale.getProductId())
				{
					System.out.println(product.getproductName() + " " + sale.getqtySold() + " " + sale.getDateSold());
				}
			}
		}
	}

}
