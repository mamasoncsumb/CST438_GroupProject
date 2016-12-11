package CST438;

import java.io.File;

public class UserInterface {
	
	public static String welcomeMat()
	{
		return "<html><body>"
				+ "<h2>Welcome to the sales app</h2>"
				+ "please select the data to view<br>"
				+ selectionList()
				+ "</body></html>";
	}
	
	
	public static String selectionList()
	{
		return  "<div style=\"float:left;width:50%\">"
				+ "<H3>Data Filter</H3>"
				+ "<form name=\"listboxnav\"> "
				+ " <select name=\"link\" size=\"8\" multiple=\"/multiple/\" onChange=\"location=document.listboxnav.link.options "
				+ "[document.listboxnav.link.selectedIndex].value;\" value=\"GO\">	"
				+ "<option value=\"/CST438_Group/sales/annualProductSales\">Annual Product Sales</option>"
				+ "<option value=\"/CST438_Group/sales/annualEmployeeSales\">Annual Employee Sales</option>"
				+ "<option value=\"/CST438_Group/sales/QtrlyProductSales\">Qtrly Product Sales</option> "
				+ "<option value=\"/CST438_Group/sales/QtrlyEmployeeSales\">Qtrly Employee Sales</option>"
				+ "<option value=\"/CST438_Group/sales/MonthlyProductSales\">Monthly Product Sales</option>"
				+ "<option value=\"/CST438_Group/sales/MonthlyEmployeeSales\">Monthly Employee Sales</option> "
				+ "<option value=\"/CST438_Group/sales/annualProductRevenue\">Annual Product Revenue</option>"
				+ "<option value=\"/CST438_Group/sales/annualEmployeeRevenue\">Annual Employee Revenue</option>"
				+ "<option value=\"/CST438_Group/sales/QtrlyProductRevenue\">Qtrly Product Revenue</option> "
				+ "<option value=\"/CST438_Group/sales/QtrlyEmployeeRevenue\">Qtrly Employee Revenue</option>"
				+ "<option value=\"/CST438_Group/sales/MonthlyProductRevenue\">Monthly Product Revenue</option>"
				+ "<option value=\"/CST438_Group/sales/MonthlyEmployeeRevenue\">Monthly Employee Revenue</option> "
				+"</select></form></div>";
	}

	public static String graphVeiw(String graphName, String pageName, float min, float max, float avg)
	{
		return  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"
				+"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Sales App</title></head><body>"
				+ "<h2>" + pageName + "</h2>"
				+ "<div>"
				+ "<div style=\"float:left;width:50%\">"
				+ "<img src=\"" + graphName + "\" style=\"width:75%;height:75%;\">"
				+ "</div>"
				+ selectionList()
				+ "<h3> Statistics <h3>"
				+ "Min: $" + min + " Max: $" + max + " Avg: $" + avg
				+ "</div></body></html>";
	}
	
	public static File getImage(String graphName)
	{
	    File repositoryFile = new File("c:/temp/myfile.png");
	    return repositoryFile;
	}

}
