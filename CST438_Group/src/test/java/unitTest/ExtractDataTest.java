package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CST438.Employee;
import CST438.ExtractData;
import CST438.Products;
import CST438.Sales;

public class ExtractDataTest {

	public static List<Products> productList;
	public static List<Sales> salesList;
	public static List<Employee> employeeList;
	
	
	public static String empName[] = new String[]{"Joe", "Bob", "Billy", "Susian"};
	public static String prodName[] = new String[]{"ball", "gum", "sand", "mud"};
	public static float prices[] = new float[]{(float) 2.00, (float) 3.00, (float) 4.00, (float) 5.00};
	public static Date hireDate[];
	public static Date salesDate[] = new Date[576];
	public static int qtySales[] = new int[576];

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
    
	/**
	 * test for begin a new game.
	 * there is no cookie in the header.
	 * @throws Exception
	 */
	
	
	static public void setLists() throws ParseException{
	
		productList = new ArrayList<Products>();
		salesList = new ArrayList<Sales>();
		employeeList = new ArrayList<Employee>();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		hireDate = new Date[]{(Date) formatter.parse("2014/1/1"),(Date) formatter.parse("2013/1/1"), (Date) formatter.parse("2012/1/1"), (Date) formatter.parse("2011/1/1")};
				
		for(int i = 0; i < 576 ; i++)
		{
			qtySales[i] = i;
			salesDate[i] = (Date) formatter.parse("201" + Integer.toString(i%3)+ "/"+ Integer.toString(12 -(i)%12) + "/2");
			//System.out.println((Date) formatter.parse("201" + Integer.toString(i%3)+ "/"+ Integer.toString(12 - i%12) + "/2"));
			
		}
		
		for(int j = 0; j < 4; j++)
		{
			employeeList.add(new Employee(1000+j, empName[j], empName[j], hireDate[j]));
			productList.add(new Products(10000+j, prodName[j], prices[j]));
			//System.out.println(productList.get(j).getproductName());
		}

		int sales = 0;
		for (int x = 0; x < 3; x++)
		{	
			for (int y = 0; y < 4; y++)
			{
				for(int z = 0; z < 4; z++)
				{
					for(int a = 1; a <= 12; a++)
					{	
						salesDate[sales] = (Date) formatter.parse("201" + Integer.toString(x)+ "/"+ Integer.toString(a) + "/2");
						//System.out.println((Date) formatter.parse("201" + Integer.toString(x)+ "/"+ Integer.toString(a) + "/2"));
						qtySales[sales] = sales;
						Sales sale = new Sales(1000 + y, 10000 + z, qtySales[sales], salesDate[sales]);
						salesList.add(sale);
						//System.out.println(sale.getEmpId()+ " prod: " + sale.getProductId() + " year: " + sale.getYearSold() + " Month: " + sale.getMonthSold() + " iter: " + sales);
						sales++;
					}
				}
			}
		}
	}
	
	@Test
	//check return of ExtractData.productsalesMMYY()
	public void test1() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Integer[]>> map = ExtractData.productSalesMMYY(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			
			for (int year = 0; year < 3; year++)
			{
				for(int month = 0; month < 12; month++)
				{
					int sales = 0;
					for (int emp = 0; emp < 4; emp++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) + month); 
					}
					//System.out.println(map.get(prodName[prod]).get(10+year)[month] + " " + sales);
					if (map.get(prodName[prod]).get(10+year)[month] != sales)
				{
						passed = false;
			}
				}
			}
		}
		
		assertEquals("product sales per month bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeSalesMMYY()
	public void test2() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Integer[]>> map = ExtractData.EmployeeSalesMMYY(employeeList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				for(int month = 0; month < 12; month++)
				{
					int sales = 0;
					for (int prod = 0; prod < 4; prod++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) +  month); 
					}
					//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[month] + " " + sales);
					if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[month] != sales)
				{
						passed = false;
			}
				}
			}
		}
		
		assertEquals("employee sales per month bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.productRevenueMMYY()
	public void test3() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Float[]>> map = ExtractData.productRevenueMMYY(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			
			for (int year = 0; year < 3; year++)
			{
				for(int month = 0; month < 12; month++)
				{
					float sales = 0;
					for (int emp = 0; emp < 4; emp++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) + month) * prices[prod] ; 
					}
					//System.out.println(map.get(prodName[prod]).get(10+year)[month] + " " + sales);
					if (map.get(prodName[prod]).get(10+year)[month] != sales)
				{
						passed = false;
			}
				}
			}
		}
		
		assertEquals("product revenue per month bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeRevenueMMYY()
	public void test4() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Float[]>> map = ExtractData.EmployeeRevenueMMYY(employeeList, productList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				for(int month = 0; month < 12; month++)
				{
					float sales = 0;
					for (int prod = 0; prod < 4; prod++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) +  month) * prices[prod]; 
					}
					//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[month] + " " + sales);
					if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[month] != sales)
				{
						passed = false;
			}
				}
			}
		}
		
		assertEquals("employee revenue per month bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.productsalesQtrly()
	public void test5() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Integer[]>> map = ExtractData.productSalesQtrly(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			for (int year = 0; year < 3; year++)
			{
				for(int qtr = 0; qtr < 4; qtr++)
				{
					int sales = 0;
					for(int month = 0; month < 3; month++)
					{
						for (int emp = 0; emp < 4; emp++)
						{
							
							sales += ((year*192) + (emp*48) + (prod*12) + (qtr*3 + month)); 
						}
					}
					//System.out.println(map.get(prodName[prod]).get(10+year)[qtr] + " " + sales);
					if (map.get(prodName[prod]).get(10+year)[qtr] != sales)
					{
					passed = false;
					}
				}
			}
		}
		
		assertEquals("product sales per qtr bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeSalesQtrly()
	public void test6() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Integer[]>> map = ExtractData.EmployeeSalesQtrly(employeeList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				for(int qtr = 0; qtr < 4; qtr++)
				{
					float sales = 0;
					for(int month = 0; month < 3; month++)
					{
						
						for (int prod = 0; prod < 4; prod++)
						{
							sales += ((year*192) + (emp*48) + (prod*12) +  (qtr*3 + month)); 
						}
					}
					//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[qtr] + " " + sales);
					if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[qtr] != sales)
					{
					passed = false;
					}
				}
			}
		}
		
		assertEquals("employee sales per qtr bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.productRevenueQtrly()
	public void test7() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Float[]>> map = ExtractData.productRevenueQtrly(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			for (int year = 0; year < 3; year++)
			{
				for(int qtr = 0; qtr < 4; qtr++)
				{
					int sales = 0;
					for(int month = 0; month < 3; month++)
					{
						for (int emp = 0; emp < 4; emp++)
						{
							
							sales += ((year*192) + (emp*48) + (prod*12) + (qtr*3 + month)) * prices[prod]; 
						}
					}
					//System.out.println(map.get(prodName[prod]).get(10+year)[qtr] + " " + sales);
					if (map.get(prodName[prod]).get(10+year)[qtr] != sales)
					{
					passed = false;
					}
				}
			}
		}
		
		assertEquals("product revenue per qtr bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeRevenueQtrly()
	public void test8() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Float[]>> map = ExtractData.EmployeeRevenueQtrly(employeeList, productList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				for(int qtr = 0; qtr < 4; qtr++)
				{
					float sales = 0;
					for(int month = 0; month < 3; month++)
					{
						
						for (int prod = 0; prod < 4; prod++)
						{
							sales += ((year*192) + (emp*48) + (prod*12) +  (qtr*3 + month)) * prices[prod]; 
						}
					}
					//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[qtr] + " " + sales);
					if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[qtr] != sales)
					{
					passed = false;
					}
				}
			}
		}
		assertEquals("employee revenue per qtr bad", true, passed);
	}
	
	@Test
	//check return of ExtractData.productsalesMMYY()
	public void test9() throws Exception{
		this.setLists();

		Map<String, Map<Integer,Integer[]>> map = ExtractData.productSalesAnnual(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			for (int year = 0; year < 3; year++)
			{
				int sales = 0;
				for(int month = 0; month < 12; month++)
				{
					for (int emp = 0; emp < 4; emp++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) + month); 
					}
				}
				//System.out.println(map.get(prodName[prod]).get(10+year)[0] + " " + sales);
				if (map.get(prodName[prod]).get(10+year)[0] != sales)
				{
					passed = false;
				}
			}
		}
		
		assertEquals("product sales per year bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeSalesMMYY()
	public void test10() throws Exception{
		this.setLists();

		Map<String, Map<Integer,Integer[]>> map = ExtractData.EmployeeSalesAnnual(employeeList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				int sales = 0;
				for(int month = 0; month < 12; month++)
				{
					for (int prod = 0; prod < 4; prod++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) +  month); 
					}
				}
				//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[0] + " " + sales);
				if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[0] != sales)
				{
					passed = false;
				}
			}
		}
		
		assertEquals("employee sales per year bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.productRevenueMMYY()
	public void test11() throws Exception{
		this.setLists();
		
		Map<String, Map<Integer,Float[]>> map = ExtractData.productRevenueAnnual(productList, salesList);
		boolean passed = true;
		
		for(int prod = 0; prod < 4; prod++)
		{
			for (int year = 0; year < 3; year++)
			{
				float sales = 0;
				for(int month = 0; month < 12; month++)
				{
					for (int emp = 0; emp < 4; emp++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) + month) * prices[prod] ; 
					}
				}
				//System.out.println(map.get(prodName[prod]).get(10+year)[0] + " " + sales);
				if (map.get(prodName[prod]).get(10+year)[0] != sales)
				{
					passed = false;
				}
			}
		}
		
		assertEquals("product revenue per year bad", true, passed);
		
	}
	
	@Test
	//check return of ExtractData.employeeRevenueMMYY()
	public void test12() throws Exception{
		this.setLists();

		Map<String, Map<Integer,Float[]>> map = ExtractData.EmployeeRevenueAnnual(employeeList, productList, salesList);
		boolean passed = true;
		
		for(int emp = 0; emp < 4; emp++)
		{	
			for (int year = 0; year < 3; year++)
			{
				float sales = 0;
				for(int month = 0; month < 12; month++)
				{
					for (int prod = 0; prod < 4; prod++)
					{
						sales += ((year*192) + (emp*48) + (prod*12) +  month) * prices[prod]; 
					}
				}
				//System.out.println(map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[0] + " " + sales);
				if (map.get(empName[emp].charAt(0) + "." + empName[emp]).get(10+year)[0] != sales)
				{
					passed = false;
				}
			}
		}
		
		assertEquals("employee revenue per year bad", true, passed);
		
	}
	
}
