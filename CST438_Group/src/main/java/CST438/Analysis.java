/**
 * 
 */
package CST438;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
import java.util.Arrays;

/**
 * @author lilia
 *
 */
public class Analysis {
	public float min, max, avg;
	/**
	 * 
	 */
	public Analysis() {
		
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public void processAnnualSales(HashMap<String, Map<Integer, Integer[]>> extData) {
		//Map<Year, TotalSales>
		Map<Integer, Integer> mapTotalSales = new HashMap<Integer, Integer>();
		int tmpTotal = 0;
		int tmpYear = 0;
		float finalTotal = 0;
		float finalMin = 0;
		float finalMax = 0;
		int count = 1;
		
		for(Map.Entry<String, Map<Integer, Integer[]>> p: extData.entrySet()){
			
			for(Map.Entry<Integer, Integer[]> y:  p.getValue().entrySet()){
				//in the year

				for(Integer s:  y.getValue()){
				  //in the sales
					if (finalMin == 0){
						finalMin = s;					
					}
					if (finalMax == 0){
						finalMax = s;
					}
					
					if (s < finalMin){
						finalMin = s;
					}
					
					if (s > finalMax){
						finalMax = s;
					}
					finalTotal = finalTotal + s;
					count = count + 1;
				}
			}
			
			//calculate avg
			this.avg = finalTotal/count;
			this.min = finalMin;
			this.max = finalMax;
		}			
	}
	
	@SuppressWarnings("unchecked")
	public void processAnnualRevenue(HashMap<String, Map<Integer, Float[]>> map) {
		//Map<Year, TotalSales>
		Map<Integer, Float> mapTotalSales = new HashMap<Integer, Float>();
		int tmpTotal = 0;
		int tmpYear = 0;
		float finalTotal = 0;
		float finalMin = 0;
		float finalMax = 0;
		int count = 1;
		
		for(Map.Entry<String, Map<Integer, Float[]>> p: map.entrySet()){
			
			for(Map.Entry<Integer, Float[]> y:  p.getValue().entrySet()){
				//in the year
			
				for(Float s:  y.getValue()){
				  //in the sales
					if (finalMin == 0){
						finalMin = s;					
					}
					if (finalMax == 0){
						finalMax = s;
					}
					
					if (s < finalMin){
						finalMin = s;
					}
					
					if (s > finalMax){
						finalMax = s;
					}
					finalTotal = finalTotal + s;
					count = count + 1;
				}
			}
			
			//calculate avg
			this.avg = finalTotal/count;
			this.min = finalMin;
			this.max = finalMax;
		}
	}
	
	/*
	 * not needed yet
	@SuppressWarnings("unchecked")
	public void processAnnualSales(HashMap<String, Map<Integer, Float[]>> extData) {
		//Map<Year, TotalSales>
		Map<Integer, Float> mapTotalSales = new HashMap<Integer, Float>();
		float tmpTotal = 0;
		int tmpYear = 0;
		float finalTotal = 0;
		float finalMin = 0;
		float finalMax = 0;
		int count = 1;
		
		System.out.println("----####ANALYSIS#####-----");
		for(Map.Entry<String, Map<Integer, Float[]>> p: extData.entrySet()){
			
			System.out.println(p.getKey());
			for(Map.Entry<Integer, Float[]> y:  p.getValue().entrySet()){
				//in the year
				System.out.println("product is: " + p.getKey() + "year is: " + y.getKey());

				tmpYear = y.getKey();
				tmpTotal = 0;
				
				//if(!mapTotalSales.containsKey(tmpYear)){
				//	mapTotalSales.put(y.getKey(), (float) 0);
				
				
				for(Float s: y.getValue()){
				  //in the sales
					tmpTotal = tmpTotal + s;
					if(tmpYear != 0 && tmpTotal !=0){
						mapTotalSales.put(tmpYear, tmpTotal);
					}
				}
			}

			
			System.out.println("count of records:" + mapTotalSales.size());
			//calculate min, max, total, count of the above
			for(Map.Entry<Integer, Float> y: mapTotalSales.entrySet()){
			System.out.println("sale for the year:" + y.getKey() + " is: " + y.getValue());
			float tmpS = y.getValue();
				if (finalMin == 0){
					finalMin = tmpS;					
				}
				if (finalMax == 0){
					finalMax = tmpS;
				}
				
				if (y.getValue() < finalMin){
					finalMin = tmpS;
				}
				
				if (y.getValue()> finalMax){
					finalMax = tmpS;
				}
				finalTotal = finalTotal + tmpS;
				count = count + 1;
			}
			
			//calculate avg
			this.avg = finalTotal/count;
			this.min = finalMin;
			this.max = finalMax;

			System.out.println("this is local variables" + finalMin + " " + finalMax);
			System.out.println("this is object variables" + this.min + " " + this.max);
			System.out.println("*******This is analysis END*******");
			
		}
					
	}*/
}
