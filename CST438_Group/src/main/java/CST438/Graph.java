package CST438;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class Graph{
	
	/*public static void main()
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
		
		System.out.println("Trying for catSet");
		DefaultCategoryDataset catSet = new DefaultCategoryDataset();
		
		System.out.println("Made Cat set");
		
		for(String key: mainMap.keySet())
		{
			System.out.println("Into key loop: " + key + "\n");
			Map<Integer, Integer[]> innerMapping = mainMap.get(key);
			
			for(Integer innerKey : innerMapping.keySet())
			{
				System.out.println("Inner loop: " + innerKey + "\n");
				//get array from map value
				Integer[] marray = (Integer[]) innerMapping.get(innerKey);
				
				catSet.addValue((double)marray[0], innerKey, key);
			}
			
		}	
		
		System.out.println("Ran to completion");	
		/*JFreeChart chart = ChartFactory.createMultiplePieChart3D("Multiple Pie Chart Demo 4", catSet, TableOrder.BY_COLUMN, false, true, false);
		MultiplePiePlot plot = (MultiplePiePlot) chart.getPlot();
        JFreeChart subchart = plot.getPieChart();
        PiePlot p = (PiePlot) subchart.getPlot();
        p.setIgnoreNullValues(true);
        p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        p.setMaximumLabelWidth(0.20);
        
        ChartFrame chart2 = new ChartFrame("ACK", chart);
        chart2.pack();
        chart2.setVisible(true);
         
	}
	*/
}