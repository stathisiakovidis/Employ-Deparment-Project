import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {

	static final ArrayList<Department> allDeparments = new ArrayList<>();
	static final ArrayList<Employee> allEmployees = new ArrayList<>();
	static final ArrayList<Project> allProjects = new ArrayList<>();
	static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public static void main(String[] args) throws ParseException {
		new GUI();
		
	}

}
