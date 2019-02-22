package Model;

public class ProfileSmoke {
	private String name;
	private String misstion;
	private String gender;
	private String brith;
	private String email;
	private String smokeStart;
	private String noSmokeStart;
	private String avgSmoke;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMisstion() {
		return misstion;
	}
	public void setMisstion(String misstion) {
		this.misstion = misstion;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBrith() {
		return brith;
	}
	public void setBrith(String brith) {
		this.brith = brith;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSmokeStart() {
		return smokeStart;
	}
	public void setSmokeStart(String smokeStart) {
		this.smokeStart = smokeStart;
	}
	public String getNoSmokeStart() {
		return noSmokeStart;
	}
	public void setNoSmokeStart(String noSmokeStart) {
		this.noSmokeStart = noSmokeStart;
	}
	public String getAvgSmoke() {
		return avgSmoke;
	}
	public void setAvgSmoke(String avgSmoke) {
		this.avgSmoke = avgSmoke;
	}
	public ProfileSmoke(String name, String misstion, String gender, String brith, String email, String smokeStart,
			String noSmokeStart, String avgSmoke) {
		super();
		this.name = name;
		this.misstion = misstion;
		this.gender = gender;
		this.brith = brith;
		this.email = email;
		this.smokeStart = smokeStart;
		this.noSmokeStart = noSmokeStart;
		this.avgSmoke = avgSmoke;
	}
	
	
	
}
