
public class Pyramid {
	private String pharaoh;
	private String modern_name ;
	private String site ;
	private double height ;

	public Pyramid(String pharaoh ,String modern_name , String site ,double height)
	{
		// TODO Auto-generated constructor stub
		this.height = height;
		this.modern_name = modern_name;
		this.pharaoh = pharaoh;
		this.site=site;
	}

	public String getPharaoh() {
		return pharaoh;
	}

	public void setPharaoh(String pharaoh) {
		this.pharaoh = pharaoh;
	}

	public String getModern_name() {
		return modern_name;
	}

	public void setModern_name(String modern_name) {
		this.modern_name = modern_name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Pyramid [pharaoh=" + pharaoh + ", modern_name=" + modern_name + ", site=" + site + ", height=" + height
				+ "]";
	}
	
	
	
}
