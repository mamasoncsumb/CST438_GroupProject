package CST438;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;


@Path("/sales")
public class SalesApp {
	
	public static List<Products> productList;
	public static List<Sales> salesList;
	public static List<Employee> employeeList;
	
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
	@Path("/employee")
	@Produces ({MediaType.APPLICATION_JSON})
	public List<Employee> getEmployees()
	{
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select e from Employee e");

		List<Employee> result = (List<Employee>)q.getResultList();
		
		this.employeeList = result;
		
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
		
		System.out.println("Year " + result.get(0).getYearSold());
		
		testLists();
		testExtractData();
		return result;
	}
	
	@GET
	@Path("/get/{imgName}")
	@Produces("image/*")
	public Response getFile(@PathParam("imgName") String imgName) {

	    File file = new File("C:\\\\images\\" + imgName);

	    javax.ws.rs.core.Response.ResponseBuilder response = Response.ok((Object) file);
	    response.header("Content-Disposition",
	        "attachment; filename=image_from_server.png");
	    return response.build();
	}
	
	@GET
	@Produces({MediaType.TEXT_HTML})
	public String welcomePage()
	{
		getProducts();
		getEmployees();
		getSales();
		First.productSalesByMonth();
		return UserInterface.welcomeMat();
		
	}
	
	@GET
	@Path("/annualProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String annualProductSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Annual Product Sales", min, max, avg);	
	}
	
	@GET
	@Path("/annualEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String annualEmployeeSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Annual Employee Sales", min, max, avg);		
	}
	
	@GET
	@Path("/QtrlyProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyProductSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Qtrly Product Sales", min, max, avg);		
	}
	
	@GET
	@Path("/QtrlyEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyEmployeeSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Qtrly Employee Sales", min, max, avg);		
	}
	
	@GET
	@Path("/MonthlyProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyProductSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Monthly Product Sales", min, max, avg);		
	}
	
	@GET
	@Path("/MonthlyEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyEmployeeSales()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Monthly Employee Sales", min, max, avg);		
	}
	
	@GET
	@Path("/annualProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String annualProductRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Annual Product Revenue", min, max, avg);		
	}
	
	@GET
	@Path("/annualEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String annualEmployeeRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Annual Employee Revenue", min, max, avg);		
	}
	
	@GET
	@Path("/QtrlyProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyProductRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Qtrly Product Revenue", min, max, avg);		
	}
	
	@GET
	@Path("/QtrlyEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyEmployeeRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Qtrly Employee Revenue", min, max, avg);		
	}
	
	@GET
	@Path("/MonthlyProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyProductRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Monthly Product Revenue", min, max, avg);		
	}
	
	@GET
	@Path("/MonthlyEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyEmployeeRevenue()
	{
		float min = 100, max=5000, avg = 2500;
		
		return UserInterface.graphVeiw("/CST438_Group/sales/get/234.png", "Monthly Employee Revenue", min, max, avg);		
	}
	
	public void testLists()
	{
		for(Products product:this.productList)
		{
			for (Sales sale: this.salesList)
			{
				if(product.getProductid() == sale.getProductId())
				{
					System.out.println(product.getproductName() + " " + sale.getqtySold() + " " + sale.getMonthSold());
				}
			}
		}
	}
	
	public void testExtractData()
	{
		//initialize map to store return
		Map<String, Map<Integer, Integer[]>> employeeMMYY = ExtractData.EmployeeSalesQtrly(SalesApp.employeeList, SalesApp.salesList);
				
		//loop through keys in main map
		for(String key: employeeMMYY.keySet())
		{
			Map<Integer, Integer[]> innerMap = employeeMMYY.get(key);
					
			for(Integer innerKey : innerMap.keySet())
			{
				//get array from map value
				Integer[] marray = (Integer[]) innerMap.get(innerKey);
				
				//loop through array and print values
				for(int i = 0; i < marray.length; i++)
				{
					System.out.println("Employee " + key + " Q " + (i + 1) + " " + innerKey + " Sales: " + marray[i]);	
				}
			}			
		}
	}
}
