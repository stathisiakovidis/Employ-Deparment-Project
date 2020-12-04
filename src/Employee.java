import java.util.Calendar;
import java.util.Date;

public class Employee {
	private String firstName;
	private String lastName;
	private Date birtdayDate;
	private String familyCondition;
	private int childrenNum;
	private int recruitementYear;
	private String specialization;
	private String degree;
	private int salary;
	private boolean isProjectManager;
	
	public Employee(String firstName, String lastName, Date birtdayDate, String familyCondition, int childrenNum,
			int recruitementYear, String specialization, String degree) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birtdayDate = birtdayDate;
		this.familyCondition = familyCondition;
		this.childrenNum = childrenNum;
		this.recruitementYear = recruitementYear;
		this.specialization = specialization;
		this.degree = degree;
		this.isProjectManager = false;
		setSalary();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Date getBirtdayDate() {
		return birtdayDate;
	}
	
	public String getFamilyCondition() {
		return familyCondition;
	}
	
	public void setFamilyCondition(String familyCondition) {
		this.familyCondition = familyCondition;
	}
	
	public int getChildrenNum() {
		return childrenNum;
	}
	
	public void setChildrenNum(int childrenNum) {
		this.childrenNum = childrenNum;
	}
	
	public int getRecruitementYear() {
		return recruitementYear;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getSalary() {
		return salary;
	}
	
	public boolean isProjectManager() {
		return isProjectManager;
	}

	public void setProjectManager(boolean isProjectManager) {
		this.isProjectManager = isProjectManager;
		this.salary += 100;
	}

	public void setSalary() {
		this.salary = 750;
		if(childrenNum <= 3) {
			this.salary += childrenNum * 60;
		}else if(childrenNum > 3){
			this.salary += 180;
		}
		
		if(degree.equals("BSc")) {
			this.salary += 80;
		}
		
		if(degree.equals("MSc")) {
			this.salary += 160;
		}
		
		if(degree.equals("PhD")) {
			this.salary += 240;
		}
		
		int difYear = Calendar.getInstance().get(Calendar.YEAR) - recruitementYear;
		this.salary += (difYear/3) * 40;
		
		if(this instanceof DepartmentDirector) {
			this.salary += 400;
		}
		
	}
	
	public int calculateYearSalary() {
		int yearSalary = 12 * this.salary;
		return yearSalary;
	}

}
