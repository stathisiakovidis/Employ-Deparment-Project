import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

	static final ArrayList<Department> allDeparments = new ArrayList<>();
	static final ArrayList<Employee> allEmployees = new ArrayList<>();
	static final ArrayList<Project> allProjects = new ArrayList<>();

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
		
		new GUI();
		
	}
	

	
	
	
	
	/*Date start = formatter.parse("06-12-2020");
	Date end = formatter.parse("12-12-2020");
	ArrayList<Project> allProjects = new ArrayList<Project>();
	Project project1 = new Project("Project1", "A demo project", 
			10000, 300, start,end);
	
	allProjects.add(project1);	
	findBestProject(allProjects);
	
	Department dep = new Department();
	Employee e1 = null;
	
	try {
		e1 = new Employee("stathis", "iakovidis", formatter.parse("03-11-1998"), 
				"agamos", 0, 2003, "Programmer", "PhD");
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	dep.setEmployeeToDepartment(e1);
	System.out.println("e1 sal:" + e1.getSalary());
	DepartmentDirector dir1 = new DepartmentDirector(e1);
	System.out.println("dir1 sal:" + dir1.getSalary());
	dep.setDepartmentDirector(dir1);
	
	System.out.println(dir1.getFirstName());
	System.out.println(formatter1.format(dir1.getDirRecruitementDate()));
	
}

public static void findBestProject(ArrayList<Project> allProjects) {
	int max = 0;
	Project maxProject;
	for (Project p : allProjects) {
		if(max<p.calculateProjectEarnings()) {
			max = p.calculateProjectEarnings();
			maxProject = p;
		}
	}*/
}
