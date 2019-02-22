package Model;

public class SmokingInformation {
	
	private String t4TextName;
	private String t4TextMisstion;
	private String t4ComboBox;
	private String t4TextBirth;
	private String t4TextEmail;
	private String t4DatePickerSmoke;
	private String t4DatePickerNoSmoke;
	private String t4CmbAvgSmoke;
	
	public String getT4TextName() {
		return t4TextName;
	}
	public void setT4TextName(String t4TextName) {
		this.t4TextName = t4TextName;
	}
	public String getT4TextMisstion() {
		return t4TextMisstion;
	}
	public void setT4TextMisstion(String t4TextMisstion) {
		this.t4TextMisstion = t4TextMisstion;
	}
	public String getT4ComboBox() {
		return t4ComboBox;
	}
	public void setT4ComboBox(String t4ComboBox) {
		this.t4ComboBox = t4ComboBox;
	}
	public String getT4TextBirth() {
		return t4TextBirth;
	}
	public void setT4TextBirth(String t4TextBirth) {
		this.t4TextBirth = t4TextBirth;
	}
	public String getT4TextEmail() {
		return t4TextEmail;
	}
	public void setT4TextEmail(String t4TextEmail) {
		this.t4TextEmail = t4TextEmail;
	}
	public String getT4DatePickerSmoke() {
		return t4DatePickerSmoke;
	}
	public void setT4DatePickerSmoke(String t4DatePickerSmoke) {
		this.t4DatePickerSmoke = t4DatePickerSmoke;
	}
	public String getT4DatePickerNoSmoke() {
		return t4DatePickerNoSmoke;
	}
	public void setT4DatePickerNoSmoke(String t4DatePickerNoSmoke) {
		this.t4DatePickerNoSmoke = t4DatePickerNoSmoke;
	}
	public String getT4CmbAvgSmoke() {
		return t4CmbAvgSmoke;
	}
	public void setT4CmbAvgSmoke(String t4CmbAvgSmoke) {
		this.t4CmbAvgSmoke = t4CmbAvgSmoke;
	}
	public SmokingInformation(String t4TextName, String t4TextMisstion, String t4ComboBox,
			String t4TextBirth, String t4TextEmail, String t4DatePickerSmoke, String t4DatePickerNoSmoke,
			String t4CmbAvgSmoke) {
		super();
		
		this.t4TextName = t4TextName;
		this.t4TextMisstion = t4TextMisstion;
		this.t4ComboBox = t4ComboBox;
		this.t4TextBirth = t4TextBirth;
		this.t4TextEmail = t4TextEmail;
		this.t4DatePickerSmoke = t4DatePickerSmoke;
		this.t4DatePickerNoSmoke = t4DatePickerNoSmoke;
		this.t4CmbAvgSmoke = t4CmbAvgSmoke;
	}
	
}
