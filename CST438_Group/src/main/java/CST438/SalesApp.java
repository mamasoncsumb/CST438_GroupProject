package CST438;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.fasterxml.jackson.annotation.JsonFormat;
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
		
		//this.productList = result;
		
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
		
		//this.employeeList = result;
		
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
		
		//this.salesList = result;
		
		//System.out.println("Year " + result.get(0).getYearSold());
		
		//testLists();
		//testExtractData();
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
		//First.productSalesByMonth();
		return UserInterface.welcomeMat();
		
	}
	
	@GET
	@Path("/annualProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String annualProductSales()
	{

		Map<String, Map<Integer,Integer[]>> map= ExtractData.productSalesAnnual(getProducts(), getSales());
		Graph.productSalesByYear(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productSalesByYear.png", "Annual Product Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);	
	}
	
	@GET
	@Path("/annualEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String annualEmployeeSales()
	{
		Map<String, Map<Integer,Integer[]>> map= ExtractData.EmployeeSalesAnnual(getEmployees(), getSales());
		Graph.employeeSalesByYear(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeSalesByYear.png", "Annual Employee Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/QtrlyProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyProductSales()
	{
		Map<String, Map<Integer,Integer[]>> map= ExtractData.productSalesQtrly(getProducts(), getSales());
		Graph.productSalesByQtr(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productSalesByQtr.png", "Qtrly Product Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/QtrlyEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyEmployeeSales()
	{
		Map<String, Map<Integer,Integer[]>> map= ExtractData.EmployeeSalesQtrly(getEmployees(), getSales());
		Graph.employeeSalesByQtr(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeSalesByQtr.png", "Qtrly Employee Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/MonthlyProductSales")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyProductSales()
	{
		Map<String, Map<Integer,Integer[]>> map= ExtractData.productSalesMMYY(getProducts(), getSales());
		Graph.productSalesByMonth(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productSalesByMonth.png", "Monthly Product Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/MonthlyEmployeeSales")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyEmployeeSales()
	{
		Map<String, Map<Integer,Integer[]>> map= ExtractData.EmployeeSalesMMYY(getEmployees(), getSales());
		Graph.employeeSalesByMonth(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualSales((HashMap<String, Map<Integer, Integer[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeSalesByMonth.png", "Monthly Employee Sales", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/annualProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String annualProductRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.productRevenueAnnual(getProducts(), getSales());
		Graph.productRevenueByYear(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productRevenueByYear.png", "Annual Product Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/annualEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String annualEmployeeRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.EmployeeRevenueAnnual(getEmployees(),getProducts(), getSales());
		Graph.employeeRevenueByYear(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeRevenueByYear.png", "Annual Employee Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/QtrlyProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyProductRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.productRevenueQtrly(getProducts(), getSales());
		Graph.productRevenueByQtr(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productRevenueByQtr.png", "Qtrly Product Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/QtrlyEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String QtrlyEmployeeRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.EmployeeRevenueQtrly(getEmployees(),getProducts(), getSales());
		Graph.employeeRevenueByQtr(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeRevenueByQtr.png", "Qtrly Employee Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/MonthlyProductRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyProductRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.productRevenueMMYY(getProducts(), getSales());
		Graph.productRevenueByMonth(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/productRevenueByMonth.png", "Monthly Product Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
	}
	
	@GET
	@Path("/MonthlyEmployeeRevenue")
	@Produces({MediaType.TEXT_HTML})
	public String MonthlyEmployeeRevenue()
	{
		Map<String, Map<Integer,Float[]>> map= ExtractData.EmployeeRevenueMMYY(getEmployees(),getProducts(), getSales());
		Graph.employeeRevenueByMonth(map);
		Analysis myAnalysis = new Analysis();
		myAnalysis.processAnnualRevenue((HashMap<String, Map<Integer, Float[]>>) map);
		return UserInterface.graphVeiw("/CST438_Group/sales/get/employeeRevenueByMonth.png", "Monthly Employee Revenue", myAnalysis.min, myAnalysis.max, myAnalysis.avg);		
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
		
		Map<String, Map<Integer, Integer[]>> employeeAnnual = ExtractData.EmployeeSalesAnnual(SalesApp.employeeList, SalesApp.salesList);
		
		for(String key: employeeAnnual.keySet())
		{
			Map<Integer, Integer[]> innerMap = employeeAnnual.get(key);
					
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
