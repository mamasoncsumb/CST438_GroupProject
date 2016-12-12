package CST438;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ExtractData {
	
	ExtractData(){};
	
	//Returns map of product sales organized annually. Map<ProductName,<Year,Year[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> productSalesAnnual(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;;
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{		
						Integer[] myArray = new Integer[1];

						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products based on year sold
					mainMap.get(mainKey).get(innerKey)[0]+= s.getqtySold();
				}
			}
		}
		
		return mainMap;
	}

	//returns map of employee seles broken down annually. Map<EmployeeName,<Year,Year[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> EmployeeSalesAnnual(List<Employee> employee, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[1];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
					
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year sold
					mainMap.get(mainKey).get(innerKey)[0]+= s.getqtySold();
				}
			}
		}
		
		return mainMap;
	}
	
	//Returns Map of product sales organized by month and year. Map<ProductName,<Year,Month[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> productSalesMMYY(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[12];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
						
					}
					
					//adds sold qty of products based on year and month sold
					mainMap.get(mainKey).get(innerKey)[s.getMonthSold() ]= s.getqtySold();
				}
			}
		}
		
		return mainMap;
	}	
	
	//Returns map of employee sales broken down by month and year. Map<EmployeeName,<Year,Month[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> EmployeeSalesMMYY(List<Employee> employee, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[12];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year and month sold
					mainMap.get(mainKey).get(innerKey)[s.getMonthSold() ]= s.getqtySold();
				}
			}
		}
		
		return mainMap;
	}
	
	//Returns map of products sales organized by quarter and year. Map<ProductName,<Year,Quarter[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> productSalesQtrly(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;
					Integer month = s.getMonthSold();
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[4];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by product based on year and quarter
					mainMap.get(mainKey).get(innerKey)[0] += ((month == 0) || (month == 1) || (month == 2) ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[1] += (month == 3 || month == 4 || month == 5 ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[2] += (month == 6 || month == 7 || month == 8 ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[3] += (month == 9 || month == 10 || month == 11 ) ? s.getqtySold() : 0;
				}
			}
		}
		
		return mainMap;
	}	
	
	//returns map of employee sales broken down by quarter and year. Map<EmployeeName,<Year,Quarter[Sales]>>
	public static Map<String, Map<Integer, Integer[]>> EmployeeSalesQtrly(List<Employee> employee, List<Sales> sales)
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		int testcounter = 0;
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					Integer month = s.getMonthSold();
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[4];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year and quarter
					mainMap.get(mainKey).get(innerKey)[0] += ((month == 0) || (month == 1) || (month == 2) ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[1] += (month == 3 || month == 4 || month == 5 ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[2] += (month == 6 || month == 7 || month == 8 ) ? s.getqtySold() : 0;
					mainMap.get(mainKey).get(innerKey)[3] += (month == 9 || month == 10 || month == 11 ) ? s.getqtySold() : 0;
				}
			}
		}
		
		return mainMap;
	}
	
	//Returns map of product sales revenue organized annually. Map<ProductName,<Year,Year[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> productRevenueAnnual(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;
					float price = p.getProductPrice();
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Float[] myArray = new Float[1];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products based on year sold
					mainMap.get(mainKey).get(innerKey)[0]+= s.getqtySold() * price;
				}
			}
		}
		
		return mainMap;
	}
	
	//returns map of employee sales revenue broken down annually. Map<EmployeeName,<Year,Year[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> EmployeeRevenueAnnual(List<Employee> employee, List <Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					float price = 0;
					
					for(Products p: products)
					{
						if(p.getProductid() == s.getProductId())
						{
							price = p.getProductPrice();
						}
					}
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Float[] myArray = new Float[1];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year sold
					mainMap.get(mainKey).get(innerKey)[0]+= s.getqtySold() * price;
				}
			}
		}
		
		return mainMap;
	}
	
	//Returns Map of product sales revenue organized by month and year. Map<ProductName,<Year,Month[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> productRevenueMMYY(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;
					float price = p.getProductPrice();
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Float[] myArray = new Float[12];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products based on year and month sold
					mainMap.get(mainKey).get(innerKey)[s.getMonthSold() ]= s.getqtySold() * price ;
				}
			}
		}
		
		return mainMap;
	}	
	
	//Returns map of employee sales revenue broken down by month and year. Map<EmployeeName,<Year,Month[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> EmployeeRevenueMMYY(List<Employee> employee, List<Products> products,List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();

		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					float price = 0;
					
					for(Products p: products)
					{
						if(p.getProductid() == s.getProductId())
						{
							price = p.getProductPrice();
						}
					}
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Float[] myArray = new Float[12];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year anad month sold
					mainMap.get(mainKey).get(innerKey)[s.getMonthSold()]= s.getqtySold() * price;
				}
			}
		}
		
		return mainMap;
	}
	
	//Returns map of products sales revenue organized by quarter and year. Map<ProductName,<Year,Quarter[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> productRevenueQtrly(List<Products> products, List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		
		//loop through lists and set keys and associated values
		for(Products p: products)
		{
			for(Sales s: sales)
			{
				if(p.getProductid() == s.getProductId())
				{
					String mainKey = p.getproductName();

					Integer innerKey = s.getYearSold() - 100;
					Integer month = s.getMonthSold();
					float price = p.getProductPrice();
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						
						Float[] myArray = new Float[4];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by product based on year and quarter
					//adds sold qty of products by employee based on year and quarter
					mainMap.get(mainKey).get(innerKey)[0] += (month == 0 || month == 1 || month == 2 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[1] += (month == 3 || month == 4 || month == 5 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[2] += (month == 6 || month == 7 || month == 8 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[3] += (month == 9 || month == 10 || month == 11 ) ? (s.getqtySold() * price) : 0;
				}
			}
		}
		
		return mainMap;
	}	
	
	//returns map of employee sales revenue broken down by quarter and year. Map<EmployeeName,<Year,Quarter[Revenue]>>
	public static Map<String, Map<Integer, Float[]>> EmployeeRevenueQtrly(List<Employee> employee, List<Products> products,List<Sales> sales)
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
	
		
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId())
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();

					Integer innerKey = s.getYearSold() - 100;
					Integer month = s.getMonthSold();
					float price = 0;
					
					for(Products p: products)
					{
						if(p.getProductid() == s.getProductId())
						{
							price = p.getProductPrice();
						}
					}
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Float[] myArray = new Float[4];
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = (float) 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year and quarter
					mainMap.get(mainKey).get(innerKey)[0] += (month == 0 || month == 1 || month == 2 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[1] += (month == 3 || month == 4 || month == 5 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[2] += (month == 6 || month == 7 || month == 8 ) ? (s.getqtySold() * price) : 0;
					mainMap.get(mainKey).get(innerKey)[3] += (month == 9 || month == 10 || month == 11 ) ? (s.getqtySold() * price) : 0;
				}
			}
		}
		
		return mainMap;
	}
	
	//returns map of employee sales of a specified product in a given year. Map<EmployeeName,<Product,Month[Sales]>>
	//The values returned will only represent that of the provided year pramater
	public static Map<String, Map<String, Integer[]>> EmployeeProductSales(List<Employee> employee, List<Products> products, List<Sales> sales, int year, int productId)
	{
		Map<String, Map<String, Integer[]>> mainMap = new HashMap<String, Map<String, Integer[]>>();
		
		
		//loop through lists and set keys and associated values
		for(Employee e: employee)
		{
			for(Sales s: sales)
			{
				if(e.getEmpid() == s.getEmpId() && s.getProductId() == productId && s.getYearSold() == year)
				{
					String mainKey = e.getFirstname().charAt(0) + "." + e.getLastname();
					String innerKey = "";
					Integer month = s.getMonthSold();
					
					for(Products p: products)
					{
						if(p.getProductid() == s.getProductId())
						{
							innerKey = p.getproductName();
						}
					}
					
					//assign new key if it does not exist in main Map
					if(!mainMap.containsKey(mainKey))
					{
						Map<String, Integer[]> innerMap = new HashMap<String, Integer[]>();
						mainMap.put(mainKey, innerMap);
					}
					
					//assign new key if it does not exist in inner Map
					if(!mainMap.get(mainKey).containsKey(innerKey))
					{
						Integer[] myArray = new Integer[4];
						
						//initialize array values to 0
						for (int i = 0; i < myArray.length; i++)
						{
							myArray[i] = 0;
						}
						
						mainMap.get(mainKey).put(innerKey, myArray);
					}
					
					//adds sold qty of products by employee based on year and quarter
					mainMap.get(mainKey).get(innerKey)[month] = s.getqtySold();
				}
			}
		}
		
		return mainMap;
	}
	
}
