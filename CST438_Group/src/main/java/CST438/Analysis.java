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
				
/*				if(!mapTotalSales.containsKey(tmpYear)){
					mapTotalSales.put(y.getKey(), (float) 0);
				}*/
				
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
					
	}
	
	


}
