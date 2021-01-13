import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//Afti einai h kuria klasi Main, h arxh tou programmatos
public class Main {
	
	static final ArrayList<Department> allDeparments = new ArrayList<>(); //Pinakas twn tmhmatwn tou programmatos
	static final ArrayList<Employee> allEmployees = new ArrayList<>(); //Pinakas twn upallhlwn tou programmatos
	static final ArrayList<Project> allProjects = new ArrayList<>(); //Pinakas twn project tou programmatos
	static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //Format tis hmeromhnias gia geniki xrisi
	
	public static void main(String[] args) {
		new GUI(); //Anoigma tis klasis tou grafikou perivallontos
		
	}

}
