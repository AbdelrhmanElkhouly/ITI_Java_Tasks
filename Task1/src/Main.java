import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids = pDAO.readPyramidFromCsv("D:\\iti\\java\\pyramids.csv");
		
		int i = 0;
		
		for(Pyramid p : pyramids) 
		{
			System.out.println("i" + (i++) + p);
		}
		List<Pyramid> new_list_withOut_zeros=new ArrayList<>();
		
		for(Pyramid p:pyramids) 
		{
			if( p.getHeight() == 0) {
			continue;
			
		}
		else 
		{
		new_list_withOut_zeros.add(p);	
		}
		}
		
	
			double median;
			double firstQuartile ;
			double thirdQuartile;
			List<Double> sorted_Height = new_list_withOut_zeros.stream().map(n->n.getHeight()).sorted().collect(Collectors.toList());
			 
			int size = sorted_Height.size();
			 
			 System.out.println("size of sorted height list is "+size);
			if(sorted_Height.size() % 2 != 0) 
			{
				median = sorted_Height.get(size/2);
				firstQuartile = sorted_Height.get(size/4);
				thirdQuartile = sorted_Height.get(size * 3/4);
				
			}
			else
			{
				median  =       (sorted_Height.get(size/2) + sorted_Height.get((size/2)+1))/2 ;
				firstQuartile = (sorted_Height.get(size/4)+ sorted_Height.get((size/4)+1))/ 2 ;
				thirdQuartile = (sorted_Height.get(size * 3/4 )+ sorted_Height.get((size * 3/4)+1))/ 2 ;
			}
	
			
		 	System.out.println("median and second or middle Quartile is "+ median);
		 	System.out.println("First Quartile is "+ firstQuartile);
		 	System.out.println("Third Quartile is "+ thirdQuartile);
		 	
}
}
