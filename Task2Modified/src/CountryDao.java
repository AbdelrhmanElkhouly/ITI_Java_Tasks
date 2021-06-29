import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

	public Country createCountry(String[] fields) 
	{
		int code = Integer.parseInt(fields[0].trim());
		String capital = fields[1].trim();
		Country c = new Country(code, capital);
		return c;
		
	}
	
	public List<Country> readCountry(String fileName)
	{
		List<Country> country_List = new ArrayList<>();
		File countries = new File(fileName);
		List<String> lines = new ArrayList<>();
		try 
		{
			lines = Files.readAllLines(countries.toPath());
		}
		catch (Exception e) 
		{
		// TODO: handle exception
			System.out.println("an error occured");
		}
		for(int linIdx = 1 ; linIdx < lines.size() ; linIdx ++) 
		{
			String line = lines.get(linIdx);
			String[] fields =line.split(",");
			Country country = createCountry(fields);
			country_List.add(country);
			
		}
		return country_List;
		
		
	}
	
	
}
