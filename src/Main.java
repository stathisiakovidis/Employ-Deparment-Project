import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
		//Scanner input = new Scanner(System.in);
		
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
		
		/*String employName;
		String employLastName;
		Date employBirtdayDate = null;
		String employFamilyCondition;
		int employChildrenNum;
		int employRecruitementYear;
		String employSpecialization;
		String employDegree;
		
		System.out.println("Παρακαλώ εισάγεται το όνομα σας: ");
		employName = input.next();
		
		System.out.println("Παρακαλώ εισάγεται το επίθετο σας: ");
		employLastName = input.next();
		
		System.out.println("Παρακαλώ εισάγεται την ημερομηνία γέννησης σας: ");
		String date = input.next();
		try {
			employBirtdayDate = formatter2.parse(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Παρακαλώ εισάγεται την οικογενειακή σας κατάσταση: ");
		employFamilyCondition = input.next();
		
		System.out.println("Παρακαλώ εισάγεται τον αριθμό των παδιών σας: ");
		employChildrenNum = input.nextInt();
		
		System.out.println("Παρακαλώ εισάγεται το έτος πρόσληψης σας: ");
		employRecruitementYear = input.nextInt();
				
		System.out.println("Παρακαλώ εισάγεται την ειδικότητα σας: ");
		employSpecialization = input.next();
		
		System.out.println("Παρακαλώ εισάγεται τον τίτλο του πτυχίου σας: ");
		employDegree = input.next();

		Employee e = new Employee(employName, employLastName, employBirtdayDate, 
				employFamilyCondition, employChildrenNum, employRecruitementYear, employSpecialization, employDegree);*/
		
		/*System.out.println(employName + employLastName + formatter2.format(employBirtdayDate) + 
				employFamilyCondition + employChildrenNum + employRecruitementYear + employSpecialization + employDegree);*/
		//dep.setDepartmentDirector((DepartmentDirector) e);
	}

}
