import java.util.ArrayList;
//Afti einai h klasi Tmhma. Perilambanei ola ta apaitoumena stoixeia tou tmhmatos
public class Department {
	private String depName; //Onoma
	private String depDescription; //Perigrafi
	private DepartmentDirector departmentDirector; //Dieuthintis tmhmatos
	private ArrayList<Employee> allDepartmentsEmployees = new ArrayList<>(); //Ypallhloi tmhmatos
	
	public Department(String depName, String depDescription) { //Constructor tis klasis me orismata to onoma kai tin perigrafi.
		this.depName = depName;
		this.depDescription = depDescription;
	}
	
	//Getters kai setters gia oles tis metablites
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDepDescription() {
		return depDescription;
	}
	public void setDepDescription(String depDescription) {
		this.depDescription = depDescription;
	}

	public ArrayList<Employee> getAllDepartmentsEmployees() {
		return allDepartmentsEmployees;
	}
	
	public void setEmployeeToDepartment(Employee newEmployee) {
		this.allDepartmentsEmployees.add(newEmployee);
	}

	public DepartmentDirector getDepartmentDirector() {
		return departmentDirector;
	}

	public void setDepartmentDirector(DepartmentDirector departmentDirector) {
		this.departmentDirector = departmentDirector;
	}
	
	public void moveToOtherDepartment(Employee employee, Department department) { //Methodos metaforas enos upallilou apo ena tmhma se ena allo
		this.allDepartmentsEmployees.remove(employee);
		department.allDepartmentsEmployees.add(employee);
	}
	
	public int calculateDepartmentsYearSalaries() { //Sunartisi mupologismou tis misthodosias olwn twn upallilwn toy tmhmatos
		int yearSalariesCost = 0;
		for(Employee e : allDepartmentsEmployees) {
			yearSalariesCost += e.calculateYearSalary(); 
		}
		
		return yearSalariesCost;
	}
	
}
