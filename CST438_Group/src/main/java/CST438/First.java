package CST438;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;
import org.jfree.chart.plot.CategoryPlot;

public class First{
	
	public static void productSalesByYear()
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();

		innerMap.put((Integer)2014, new Integer[]{(Integer)9428});
		mainMap.put("thing-a-magig", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("thing-a-magig").put((Integer)2015, new Integer[]{(Integer)19308});
		mainMap.get("thing-a-magig").put((Integer)2016, new Integer[]{(Integer)25000});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)27240});
		mainMap.put("doohickey", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doohickey").put((Integer)2015, new Integer[]{(Integer)24072});
		mainMap.get("doohickey").put((Integer)2016, new Integer[]{(Integer)20912});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)24008});
		mainMap.put("doodad", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doodad").put((Integer)2015, new Integer[]{(Integer)28584});
		mainMap.get("doodad").put((Integer)2016, new Integer[]{(Integer)44000});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)14052});
		mainMap.put("whatcha-ma-call-it", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("whatcha-ma-call-it").put((Integer)2015, new Integer[]{(Integer)7600});
		mainMap.get("whatcha-ma-call-it").put((Integer)2016, new Integer[]{(Integer)32988});
		innerMap.clear();
		
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
        
        ChartFrame chart2 = new ChartFrame("Product Sales by Year", chart);
        chart2.pack();
        chart2.setVisible(true);
	}
	
	public static void employeeSalesByYear()
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();

		innerMap.put((Integer)2014, new Integer[]{(Integer)5399});
		mainMap.put("Chakarian", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Chakarian").put((Integer)2015, new Integer[]{(Integer)4859});
		mainMap.get("Chakarian").put((Integer)2016, new Integer[]{(Integer)7638});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)3804});
		mainMap.put("Hansen", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Hansen").put((Integer)2015, new Integer[]{(Integer)5299});
		mainMap.get("Hansen").put((Integer)2016, new Integer[]{(Integer)6796});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)6761});
		mainMap.put("Mason", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Mason").put((Integer)2015, new Integer[]{(Integer)5039});
		mainMap.get("Mason").put((Integer)2016, new Integer[]{(Integer)7646});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)2718});
		mainMap.put("Ramos", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Ramos").put((Integer)2015, new Integer[]{(Integer)4694});
		mainMap.get("Ramos").put((Integer)2016, new Integer[]{(Integer)8745});
		innerMap.clear();
		
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
        
        ChartFrame chart2 = new ChartFrame("Product Sales by Year", chart);
        chart2.pack();
        chart2.setVisible(true);
	}
	
	public static void productRevenueByYear()
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();

		innerMap.put((Integer)2014, new Float[]{(Float)942705.70f});
		mainMap.put("thing-a-magig", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("thing-a-magig").put((Integer)2015, new Float[]{(Float)1930606.88f});
		mainMap.get("thing-a-magig").put((Integer)2016, new Float[]{(Float)2499749.95f});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Float[]{(Float)1847961.50f});
		mainMap.put("doohickey", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("doohickey").put((Integer)2015, new Float[]{(Float)1633044.39f});
		mainMap.get("doohickey").put((Integer)2016, new Float[]{(Float)1418670f});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Float[]{(Float)1104127.96f});
		mainMap.put("doodad", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("doodad").put((Integer)2015, new Float[]{(Float)1314578.21f});
		mainMap.get("doodad").put((Integer)2016, new Float[]{(Float)2041956.07f});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Float[]{(Float)2810259.56f});
		mainMap.put("whatcha-ma-call-it", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("whatcha-ma-call-it").put((Integer)2015, new Float[]{(Float)1519924.04f});
		mainMap.get("whatcha-ma-call-it").put((Integer)2016, new Float[]{(Float)6597270.30f});
		innerMap.clear();
		
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
        
        ChartFrame chart2 = new ChartFrame("Product Revenue by Year", chart);
        chart2.pack();
        chart2.setVisible(true);
	}
	
	public static void employeeRevenueByYear()
	{
		Map<String, Map<Integer, Float[]>> mainMap = new HashMap<String, Map<Integer, Float[]>>();
		Map<Integer, Float[]> innerMap = new HashMap<Integer, Float[]>();

		innerMap.put((Integer)2014, new Float[]{(Float)539846.00f});
		mainMap.put("Chakarian", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("Chakarian").put((Integer)2015, new Float[]{(Float)485851.40f});
		mainMap.get("Chakarian").put((Integer)2016, new Float[]{(Float)763723.60f});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Float[]{(Float)380361.95f});
		mainMap.put("Hansen", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("Hansen").put((Integer)2015, new Float[]{(Float)529847f});
		mainMap.get("Hansen").put((Integer)2016, new Float[]{(Float)679532.03f});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Float[]{(Float)676032.38f});
		mainMap.put("Mason", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("Mason").put((Integer)2015, new Float[]{(Float)503849.60f});
		mainMap.get("Mason").put((Integer)2016, new Float[]{(Float)764523.52f});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Float[]{(Float)271772.81f});
		mainMap.put("Ramos", new HashMap<Integer, Float[]>(innerMap));
		mainMap.get("Ramos").put((Integer)2015, new Float[]{(Float)469353.05f});
		mainMap.get("Ramos").put((Integer)2016, new Float[]{(Float)874412.53f});
		innerMap.clear();
		
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
        
        ChartFrame chart2 = new ChartFrame("Product Revenue by Year", chart);
        chart2.pack();
        chart2.setVisible(true);
	}
	
	public static void productSalesByQtr()
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
		
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)512, (Integer)1728, (Integer)4204, (Integer)2984});
		mainMap.put("thing-a-magig", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("thing-a-magig").put((Integer)2015, new Integer[]{(Integer)1752, (Integer)5688, (Integer)11544, (Integer)324});
		mainMap.get("thing-a-magig").put((Integer)2016, new Integer[]{(Integer)2416, (Integer)3416, (Integer)5572, (Integer)13596});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)10684, (Integer)4632, (Integer)7344, (Integer)4580});
		mainMap.put("doohickey", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doohickey").put((Integer)2015, new Integer[]{(Integer)2224, (Integer)4484, (Integer)6468, (Integer)10896});
		mainMap.get("doohickey").put((Integer)2016, new Integer[]{(Integer)2248, (Integer)1084, (Integer)5772, (Integer)11808});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)5252, (Integer)6880, (Integer)5900, (Integer)5976});
		mainMap.put("doodad", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doodad").put((Integer)2015, new Integer[]{(Integer)7584, (Integer)7528, (Integer)8808, (Integer)4664});
		mainMap.get("doodad").put((Integer)2016, new Integer[]{(Integer)4856, (Integer)11156, (Integer)9860, (Integer)18528});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)1260, (Integer)5208, (Integer)4832, (Integer)2752});
		mainMap.put("whatcha-ma-call-it", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("whatcha-ma-call-it").put((Integer)2015, new Integer[]{(Integer)4216, (Integer)552, (Integer)1128, (Integer)1704});
		mainMap.get("whatcha-ma-call-it").put((Integer)2016, new Integer[]{(Integer)13056, (Integer)11076, (Integer)6088, (Integer)2768});
		innerMap.clear();
		
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
       
        
        ChartFrame chart2 = new ChartFrame("Employee Sales by Qtr", chart);
        chart2.pack();
        chart2.setVisible(true);	
	}	
	
	public static void employeeSalesByQtr()
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
		
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)1356, (Integer)1259, (Integer)1734, (Integer)1050});
		mainMap.put("Chakarian", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Chakarian").put((Integer)2015, new Integer[]{(Integer)1057, (Integer)1266, (Integer)1803, (Integer)733});
		mainMap.get("Chakarian").put((Integer)2016, new Integer[]{(Integer)1449, (Integer)2192, (Integer)1005, (Integer)2992});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)910, (Integer)1504, (Integer)753, (Integer)637});
		mainMap.put("Hansen", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Hansen").put((Integer)2015, new Integer[]{(Integer)1249, (Integer)1217, (Integer)1303, (Integer)1530});
		mainMap.get("Hansen").put((Integer)2016, new Integer[]{(Integer)666, (Integer)1461, (Integer)2422, (Integer)2247});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)2161, (Integer)1389, (Integer)2158, (Integer)1053});
		mainMap.put("Mason", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Mason").put((Integer)2015, new Integer[]{(Integer)1014, (Integer)1002, (Integer)2003, (Integer)1020});
		mainMap.get("Mason").put((Integer)2016, new Integer[]{(Integer)1659, (Integer)1028, (Integer)1887, (Integer)3072});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Integer[]{(Integer)0, (Integer)460, (Integer)925, (Integer)1333});
		mainMap.put("Ramos", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("Ramos").put((Integer)2015, new Integer[]{(Integer)624, (Integer)1078, (Integer)1878, (Integer)1114});
		mainMap.get("Ramos").put((Integer)2016, new Integer[]{(Integer)1870, (Integer)2002, (Integer)1509, (Integer)3364});
		innerMap.clear();
		
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
       
        
        ChartFrame chart2 = new ChartFrame("Employee Sales by Qtr", chart);
        chart2.pack();
        chart2.setVisible(true);	
	}
	
	public static void productSalesByMonth()
	{
		Map<String, Map<Integer, Integer[]>> mainMap = new HashMap<String, Map<Integer, Integer[]>>();
		Map<Integer, Integer[]> innerMap = new HashMap<Integer, Integer[]>();
		
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		innerMap.put((Integer)2014, new Integer[]{112,108,292,908,176,644,296,1492,2416,652,1172,1160});
		mainMap.put("thing-a-magig", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("thing-a-magig").put((Integer)2015, new Integer[]{816,308,628,1296,1856,2536,3236,3820,4488,48,84,192});
		mainMap.get("thing-a-magig").put((Integer)2016, new Integer[]{560,856,1000,1360,248,1808,3116,1188,1268,3812,6008,3776});
		innerMap.clear();
		
		innerMap.put((Integer)2014, new Integer[]{1964,4980,3740,2628,856,1148,1260,2924,3160,2584,600,1396});
		mainMap.put("doohickey", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doohickey").put((Integer)2015, new Integer[]{1248,368,608,1280,1344,1860,424,1484,4560,5704,1640,3552});
		mainMap.get("doohickey").put((Integer)2016, new Integer[]{1000,476,772,312,276,496,508,2884,2380,3504,4808,3496});
		innerMap.clear();		
		
		innerMap.put((Integer)2014, new Integer[]{1700,1888,1664,1932,3132,1816,436,2836,2628,1388,988,3600});
		mainMap.put("doodad", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("doodad").put((Integer)2015, new Integer[]{1056,2412,4116,2720,2664,2144,3192,3456,2160,2064,1448,1152});
		mainMap.get("doodad").put((Integer)2016, new Integer[]{1320,1256,2280,3040,3148,4968,4436,3124,2300,2224,9608,6696});
		innerMap.clear();			
		
		innerMap.put((Integer)2014, new Integer[]{420,428,412,228,1256,3724,688,2036,2108,1612,256,884});
		mainMap.put("whatcha-ma-call-it", new HashMap<Integer, Integer[]>(innerMap));
		mainMap.get("whatcha-ma-call-it").put((Integer)2015, new Integer[]{1096,3064,56,120,184,248,312,376,440,504,568,632});
		mainMap.get("whatcha-ma-call-it").put((Integer)2016, new Integer[]{400,4856,7800,3200,2868,5008,5116,512,460,464,808,1496});
		innerMap.clear();
		
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
		
		JFreeChart chart = ChartFactory.createLineChart("DerSet", "Month", "Units", catSet);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		ChartFrame chart2 = new ChartFrame("Employee Sales by Qtr", chart);
        chart2.pack();
        chart2.setVisible(true);
	}
	
	public static void main(String[] args) {   
		//MultiPieChart Style
		//productSalesByYear();
		//productRevenueByYear();
		//employeeSalesByYear();
		//employeeRevenueByYear();
        
		//BarChartStyle
		//employeeSalesByQtr();
		//productSalesByQtr();
		
		//LineStyleChart
		productSalesByMonth();
        
	}	
}
