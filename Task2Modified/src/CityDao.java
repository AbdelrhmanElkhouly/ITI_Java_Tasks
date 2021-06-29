import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CityDao {
	
	
	public City createCity(String[] fields) 
	{
		
		int code = Integer.parseInt(fields[0].trim());
		String name = fields[1].trim();
		String continent = fields[2].trim();
		double population = Double.parseDouble(fields[3].trim());
		double surfaceArea = Double.parseDouble(fields[4].trim());
		int country_code = Integer.parseInt(fields[5].trim());
		
		City c = new City(code, name, continent, population, surfaceArea,country_code);
		return c ;
		
	}
	
	public List<City> readCity(String fileName)
	{
		List<City> city_List = new ArrayList<>(); 
		File cities = new File(fileName);
		List<String> lines = new ArrayList<>();
		try 
		{
		lines = Files.readAllLines(cities.toPath());	
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			System.out.println("an error occure");
		}
	
		for(int linInd = 1 ; linInd < lines.size() ; linInd++) 
		{
		String line = lines.get(linInd);
		
		String[] fields = line.split(",");
		
		 City city = createCity(fields);
		 city_List.add(city);
		}
		return city_List;
		
		
	}
	

}
