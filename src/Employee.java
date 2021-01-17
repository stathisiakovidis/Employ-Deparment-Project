/* 
 * Onom/numo: Laskakis Spiridon - Karamouza Konstantina
 * AM: 3212019109 - 3212016057
 */ 

import java.util.Calendar;
import java.util.Date;
//Afti einai h klash Ypallhllos. Perilambanei ola ta apaitoumena stoixeia tou upallilou
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
	
	//Constructor ths klasis me orismata to onoma, to eponumo, thn oikogeneiakh katastasi, thn hmeromhnia gennisi
	//ton arithmo twn paidiwn, to etos proslipsis, thn eidikotita kai to epipedo morfwsis tou upallilou
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
	
	//Getters kai setters gia oles tis metablites
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
	
	public boolean isProjectManager() { //Sunartisi elegxou gia to ean o upallilos einai project manager se kapoio ergo
		return isProjectManager;
	}

	public void setProjectManager(boolean isProjectManager) { //Methodos gia ton orismo upallilou ws project manager kai auxisi toy misthou toy
		this.isProjectManager = isProjectManager;
		this.salary += 100;
	}
	
	public void setSalary() { //Methodos upologismou tou misthou tou upallilou opws orizei h ekfwnisi
		this.salary = 750;
		if(childrenNum <= 3) {
			this.salary += childrenNum * 60;
		}else if(childrenNum > 3){
			this.salary += 180;
		}
		
		if(degree.equals("Πανεπιστημιακή Εκπαίδευση")) {
			this.salary += 80;
		}
		
		if(degree.equals("Μεταπτυχιακό Δίπλωμα")) {
			this.salary += 160;
		}
		
		if(degree.equals("Διδακτορικό Δίπλωμα")) {
			this.salary += 240;
		}
		
		int difYear = Calendar.getInstance().get(Calendar.YEAR) - recruitementYear;
		this.salary += (difYear/3) * 40;
		
		//Ean o upallilos einai deuthintis tmhmatos o misthos auxanetai
		if(this instanceof DepartmentDirector) {
			this.salary += 400;
		}
		
	}
	
	public int calculateYearSalary() { //Sunartisi upologismou tou ethsiou misthou tou upallilou
		int yearSalary = 12 * this.salary;
		return yearSalary;
	}

}
