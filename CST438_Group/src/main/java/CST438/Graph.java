package CST438;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class Graph{
	public static void productSalesByYear(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				//get array from map value
				Integer[] marray = (Integer[]) innerMapping.get(innerKey);
				
				catSet.addValue((double)marray[0], key, innerKey);
			}
			
		}	
		
		JFreeChart chart = ChartFactory.createMultiplePieChart3D("Years", catSet, TableOrder.BY_COLUMN, false, true, false);
		MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        PiePlot p = (PiePlot) subchart.getPlot();
        p.setIgnoreNullValues(true);
        p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        p.setMaximumLabelWidth(0.20);
        
        //ChartFrame chart2 = new ChartFrame("Product Sales by Year", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productSalesByYear.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void employeeSalesByYear(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				//get array from map value
				Integer[] marray = (Integer[]) innerMapping.get(innerKey);
				
				catSet.addValue((double)marray[0], key, innerKey);
			}
			
		}	
		
		JFreeChart chart = ChartFactory.createMultiplePieChart3D("Years", catSet, TableOrder.BY_COLUMN, false, true, false);
		MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        PiePlot p = (PiePlot) subchart.getPlot();
        p.setIgnoreNullValues(true);
        p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        p.setMaximumLabelWidth(0.20);
        
        //ChartFrame chart2 = new ChartFrame("Employee Sales by Year", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeSalesByYear.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void productRevenueByYear(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				//get array from map value
				Float[] marray = (Float[]) innerMapping.get(innerKey);
				
				catSet.addValue((double)marray[0], key, innerKey);
			}
			
		}	
		
		JFreeChart chart = ChartFactory.createMultiplePieChart3D("Years", catSet, TableOrder.BY_COLUMN, false, true, false);
		MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        PiePlot p = (PiePlot) subchart.getPlot();
        p.setIgnoreNullValues(true);
        p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        p.setMaximumLabelWidth(0.20);
        
        //ChartFrame chart2 = new ChartFrame("Product Revenue by Year", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productRevenueByYear.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void employeeRevenueByYear(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				//get array from map value
				Float[] marray = (Float[]) innerMapping.get(innerKey);
				
				catSet.addValue((double)marray[0], key, innerKey);
			}
			
		}	
		
		JFreeChart chart = ChartFactory.createMultiplePieChart3D("Years", catSet, TableOrder.BY_COLUMN, false, true, false);
		MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        PiePlot p = (PiePlot) subchart.getPlot();
        p.setIgnoreNullValues(true);
        p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        p.setMaximumLabelWidth(0.20);
        
        //ChartFrame chart2 = new ChartFrame("Employee Revenue by Year", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeRevenueByYear.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void productSalesByQtr(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"-1st", "-2nd", "-3rd", "-4th"};
				for (int i=0; i<4; i++)
				{
					Integer[] marray = (Integer[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Product Sales by Qtr", "Fiscal Quarter", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
       
        
        //ChartFrame chart2 = new ChartFrame("Product Sales by Qtr", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productSalesByQtr.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void employeeSalesByQtr(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"-1st", "-2nd", "-3rd", "-4th"};
				for (int i=0; i<4; i++)
				{
					Integer[] marray = (Integer[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Employee Sales by Qtr", "Fiscal Quarter", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
       
        
        //ChartFrame chart2 = new ChartFrame("Employee Sales by Qtr", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeSalesByQtr.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void employeeRevenueByQtr(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"-1st", "-2nd", "-3rd", "-4th"};
				for (int i=0; i<4; i++)
				{
					Float[] marray = (Float[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Employee Revenue by Qtr", "Fiscal Quarter", "Dollars", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
       
        
        //ChartFrame chart2 = new ChartFrame("Employee Revenue by Qtr", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeRevenueByQtr.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void productRevenueByQtr(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"-1st", "-2nd", "-3rd", "-4th"};
				for (int i=0; i<4; i++)
				{
					Float[] marray = (Float[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Product Revenue by Qtr", "Fiscal Quarter", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
       
        
        //ChartFrame chart2 = new ChartFrame("Product Revenue by Qtr", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productRevenueByQtr.png");
        
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void productSalesByMonth(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				for (int i=0; i<12; i++)
				{
					Integer[] marray = (Integer[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Product Sales by Month", "Month", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		//ChartFrame chart2 = new ChartFrame("Product Sales by Month", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productSalesByMonth.png");
       
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	
	//productRevenueByMonth(prmMap);
	public static void productRevenueByMonth(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				for (int i=0; i<12; i++)
				{
					Float[] marray = (Float[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Product Revenue by Month", "Month", "Dollars", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		//ChartFrame chart2 = new ChartFrame("Product Revenue by Month", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "productRevenueByMonth.png");
       
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void employeeSalesByMonth(Map<String, Map<Integer, Integer[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				for (int i=0; i<12; i++)
				{
					Integer[] marray = (Integer[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Employee Sales by Month", "Month", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		//ChartFrame chart2 = new ChartFrame("Employee Sales by Month", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeSalesByMonth.png");
       
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//employeeRevenueByMonth(ermMap);
	public static void employeeRevenueByMonth(Map<String, Map<Integer, Float[]>> mainMap)
	{	
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		for(String key: mainMap.keySet())
		{
			Map<Integer, Float[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				String[] seasons = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
				for (int i=0; i<12; i++)
				{
					Float[] marray = (Float[]) innerMapping.get(innerKey);
					catSet.addValue((double)marray[i], key, innerKey + seasons[i]);
				}
			}
			
		}
		
		JFreeChart chart = ChartFactory.createLineChart("Employee Revenue by Month", "Month", "Dollars", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		//ChartFrame chart2 = new ChartFrame("Employee Revenue by Month", chart);
        //chart2.pack();
        //chart2.setVisible(true);
        
        File file = new File("C:\\\\images\\" + "employeeRevenueByMonth.png");
       
        try {
			ChartUtilities.saveChartAsPNG(file, chart, 538, 538);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}