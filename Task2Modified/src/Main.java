import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sun.jvm.hotspot.ci.ciType;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CityDao cdao = new CityDao();
		List<City> cities_list = cdao.readCity("D:\\iti\\java\\cities.csv") ;
		int i = 0 ;
		for(City c : cities_list) 
		{
			System.out.println("i :" + (i++) + c);
	}
		CountryDao countdao = new CountryDao();
		List<Country> countries_list = countdao.readCountry("D:\\iti\\java\\countries.csv");
		int j = 0;
		for(Country c : countries_list) 
		{
			System.out.println("j"+(j++) + c);
		}
		
		List<City> new_city ;
		Map<Country ,List<City>> map = new HashMap<>();
		for(Country c : countries_list) 
		{
			new_city=new ArrayList();
			for(City c1 : cities_list) 
			{
				if (c.getCode()==c1.getCountry_code()) {
					new_city.add(c1);
					
				}
			}
			map.put(c, new_city);
		}
		map.forEach((k,v)-> System.out.println("country"+k+"    "+"city Object"+v));
		
		//map.forEach((k,v)->System.out.println(k+ " " +Collections.sort(v) ));
		
		//map.forEach((k, v) ->{ List<Double> pop=v.stream().map(City::getPopulation).sorted().collect(Collectors.toList());
			//for(double p : pop) {
				//System.out.println(p);
				
			//}});
		
	System.out.println(cities_list.stream().map((n)->n.getPopulation()).sorted().collect(Collectors.toList()));
		


//map.forEach((k,v)->v.stream().map((n)->n.getPopulation()).sorted().collect(Collectors.toList()));
//System.out.println("in mapppppppp"+ map);

 	map.forEach((k,v)->
 	{
 	List<City> sortedList = v.stream().sorted(Comparator.comparing(City::getPopulation)).collect(Collectors.toList());	
 	map.put(k, sortedList);});
 	map.forEach((k,v)->System.out.println("key"+k+"sorted city list"+v));

		//Collections.sort();

		// Map<List<Country>,List<City> map = new HashMap<>();
		//map.forEach((countries_list.get(code),cities)->System.out.println());
 	
 	//exercise 3
 	
 	map.forEach((k,v) ->
    System.out.println( v.stream().map(City::getPopulation).max(Double::compare)));

 	map.forEach((k,v) ->
    System.out.println( v.stream().map(City::getContinent).max(String::compareTo)));
 	
 	Map<String, List<City>> highPop = cities_list
            .stream()
            .collect(Collectors.groupingBy(City::getContinent));

 	
 	

 	
 		

 	
 	
 	
 

		
	}

}
