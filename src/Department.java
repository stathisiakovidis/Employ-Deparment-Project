import java.util.ArrayList;

public class Department {
	private String depName;
	private String depDescription;
	private DepartmentDirector departmentDirector;
	private ArrayList<Employee> allDepartmentsEmployees = new ArrayList<>();
	
	
	public Department(String depName, String depDescription) {
		super();
		this.depName = depName;
		this.depDescription = depDescription;
	}

	public Department() {
		
	}
	
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
	
	public void moveToOtherDepartment(Employee employee, Department department) {
		this.allDepartmentsEmployees.remove(employee);
		department.allDepartmentsEmployees.add(employee);
	}
	
	public int calculateDepartmentsYearSalaries() {
		int yearSalariesCost = 0;
		for(Employee e : allDepartmentsEmployees) {
			yearSalariesCost += e.calculateYearSalary(); 
		}
		
		return yearSalariesCost;
	}
	
}
