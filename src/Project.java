import java.util.ArrayList;
import java.util.Date;

public class Project {
	private String projName;
	private String projDescription;
	private int earnings;
	private int spendings;
	private Employee projectManager;
	private ArrayList<Employee> employeesOnProject = new ArrayList<Employee>();
	private Date start, end;
	
	public Project(String projName, String projDescription, int earnings, Date start, Date end) {
		this.projName = projName;
		this.projDescription = projDescription;
		this.earnings = earnings;
		this.start = start;
		this.end = end;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(Employee projectManager) {
		this.projectManager = projectManager;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjDescription() {
		return projDescription;
	}

	public void setProjDescription(String projDescription) {
		this.projDescription = projDescription;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public int getSpendings() {
		return spendings;
	}

	public void setSpendings(int spendings) {
		this.spendings = spendings;
	}

	public ArrayList<Employee> getEmployeesOnProject() {
		return employeesOnProject;
	}

	public void addEmployOnProject(Employee e) {
		this.employeesOnProject.add(e);
	}
	
	public int calculateProjectsSalaries() {
		int projectSalaries = 0;
		for(Employee e : employeesOnProject) {
			projectSalaries += e.getSalary(); 
		}
		
		return projectSalaries;
	}
	
	public int calculateProjectEarnings() {
		this.earnings = earnings - spendings - calculateProjectsSalaries();
		return this.earnings;
	}
	
}
