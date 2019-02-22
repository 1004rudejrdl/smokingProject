package Model;

public class Smoking {
	//private String t1no;
	private String t1smoke;
	private String t1exercise;
	private String t1drinking;
	private String t1memo;
	private String t1datePicker;
	private String t1ExpenseAmount;
	private String t1IncomeAmount ;
	/*public String getT1no() {
		return t1no;
	}
	public void setT1no(String t1no) {
		this.t1no = t1no;
	}*/
	public String getT1smoke() {
		return t1smoke;
	}
	public void setT1smoke(String t1smoke) {
		this.t1smoke = t1smoke;
	}
	public String getT1exercise() {
		return t1exercise;
	}
	public void setT1exercise(String t1exercise) {
		this.t1exercise = t1exercise;
	}
	public String getT1drinking() {
		return t1drinking;
	}
	public void setT1drinking(String t1drinking) {
		this.t1drinking = t1drinking;
	}
	public String getT1memo() {
		return t1memo;
	}
	public void setT1memo(String t1memo) {
		this.t1memo = t1memo;
	}
	public String getT1datePicker() {
		return t1datePicker;
	}
	public void setT1datePicker(String t1datePicker) {
		this.t1datePicker = t1datePicker;
	}
	public String getT1ExpenseAmount() {
		return t1ExpenseAmount;
	}
	public void setT1ExpenseAmount(String t1ExpenseAmount) {
		this.t1ExpenseAmount = t1ExpenseAmount;
	}
	public String getT1IncomeAmount() {
		return t1IncomeAmount;
	}
	public void setT1IncomeAmount(String t1IncomeAmount) {
		this.t1IncomeAmount = t1IncomeAmount;
	}
	/*public Smoking(String t1no, String t1smoke, String t1exercise, String t1drinking, String t1memo,
			String t1datePicker, String t1ExpenseAmount, String t1IncomeAmount) {
		super();
		this.t1no = t1no;
		this.t1smoke = t1smoke;
		this.t1exercise = t1exercise;
		this.t1drinking = t1drinking;
		this.t1memo = t1memo;
		this.t1datePicker = t1datePicker;
		this.t1ExpenseAmount = t1ExpenseAmount;
		this.t1IncomeAmount = t1IncomeAmount;
	}*/
	public Smoking(String t1smoke, String t1exercise, String t1drinking, String t1memo,
			String t1datePicker, String t1ExpenseAmount, String t1IncomeAmount) {
		super();
		
		this.t1smoke = t1smoke;
		this.t1exercise = t1exercise;
		this.t1drinking = t1drinking;
		this.t1memo = t1memo;
		this.t1datePicker = t1datePicker;
		this.t1ExpenseAmount = t1ExpenseAmount;
		this.t1IncomeAmount = t1IncomeAmount;
	}
	
	
}
