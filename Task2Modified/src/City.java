
public class City {
	int code;
	String name ;
	String continent ;
	double population ;
	double surfaceArea;
	int country_code;
	public City(int code, String name, String continent, double population, double surfaceArea,int country_code) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.surfaceArea = surfaceArea;
		this.country_code = country_code;
		
	
	}

	public int getCountry_code() {
		return country_code;
	}

	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	@Override
	public String toString() {
		return "City [code=" + code + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", surfaceArea=" + surfaceArea + "]";
	}
	
	
	

}
