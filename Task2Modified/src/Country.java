
public class Country {

	private int code ;
	private String cpital ;
	
	public Country(int code, String cpital) {
		super();
		this.code = code;
		this.cpital = cpital;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCpital() {
		return cpital;
	}

	public void setCpital(String cpital) {
		this.cpital = cpital;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", cpital=" + cpital + "]";
	}
	
	
	
}
