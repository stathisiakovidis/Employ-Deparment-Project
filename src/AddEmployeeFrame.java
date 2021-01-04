import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class AddEmployeeFrame implements ActionListener{
	private JFrame frame;
	private JLabel firstNameLabel, lastNameLabel, birthdayDateLabel, familyLabel, 
					numOfChildrenLabel, yearOfRecruitmentLabel, specializationLabel,
					degreeLabel;
	private JPanel employeePane;
	private JTextField firstNameText, lastNameText, numOfChildrenText, yearOfRecruitmentText,
						specializationText;
	private JDatePickerImpl datePicker;
	private JComboBox<String> familyConditionMenu, degreeMenu;
	private JButton confirmButton;

	public AddEmployeeFrame() {
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		Border bor = BorderFactory.createEmptyBorder(0, 0, 0, 10);
		frame = new JFrame("Add Employee");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		employeePane = new JPanel();
		firstNameLabel = new JLabel("Όνομα");
		firstNameLabel.setFont(font);
		firstNameLabel.setBorder(bor);
		firstNameText = new JTextField(18);
		
		lastNameLabel = new JLabel("Επώνυμο");
		lastNameLabel.setFont(font);
		lastNameLabel.setBorder(bor);
		lastNameText = new JTextField(18);
		
		birthdayDateLabel = new JLabel("Ημερ/νία Γέννησης");
		birthdayDateLabel.setFont(font);
		birthdayDateLabel.setBorder(bor);
		createCalender();
		
		familyLabel = new JLabel("Οικ/νιακή Κατάσταση");
		familyLabel.setFont(font);
		familyLabel.setBorder(bor);
		createFamilyConditionMenu();
		
		numOfChildrenLabel = new JLabel("Αριθμός Παιδιών");
		numOfChildrenLabel.setFont(font);
		numOfChildrenLabel.setBorder(bor);
		numOfChildrenText = new JTextField(2);
		
		yearOfRecruitmentLabel = new JLabel("Έτος Πρόσληψης");
		yearOfRecruitmentLabel.setFont(font);
		yearOfRecruitmentLabel.setBorder(bor);
		yearOfRecruitmentText = new JTextField(4);
		
		specializationLabel = new JLabel("  Ειδικότητα");
		specializationLabel.setFont(font);
		specializationLabel.setBorder(bor);
		specializationText = new JTextField(15);
		
		degreeLabel = new JLabel("Επίπεδο Σπουδών");
		degreeLabel.setFont(font);
		degreeLabel.setBorder(bor);
		createDegreeMenu();
		
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		employeePane.add(firstNameLabel);
		employeePane.add(firstNameText);
		employeePane.add(lastNameLabel);
		employeePane.add(lastNameText);
		employeePane.add(birthdayDateLabel);
		employeePane.add(datePicker);
		employeePane.add(familyLabel);
		employeePane.add(familyConditionMenu);
		employeePane.add(numOfChildrenLabel);
		employeePane.add(numOfChildrenText);
		employeePane.add(yearOfRecruitmentLabel);
		employeePane.add(yearOfRecruitmentText);
		employeePane.add(specializationLabel);
		employeePane.add(specializationText);
		employeePane.add(degreeLabel);
		employeePane.add(degreeMenu);
		employeePane.add(confirmButton);
		
	    employeePane.setMaximumSize(new Dimension(300, 400));

		frame.getContentPane().add(employeePane);
		frame.setSize(500, 500);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}
	
	public void createCalender() {
		UtilDateModel model = new UtilDateModel();
		model.setDate(1990, 8, 24);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}
	
	public void createFamilyConditionMenu() {
		String[] choices = {"Επιλογή..", "Άγαμος", "Έγγαμος"};
		familyConditionMenu = new JComboBox<>(choices);
		
	}
	
	public void createDegreeMenu() {
		String[] choices = {"Επιλογή..","Δευτεροβάθμια Εκπαίδευση", "Πανεπιστημιακή Εκπαίδευση", "Μεταπτυχιακό Δίπλωμα", "Διδακτορικό Δίπλωμα"};
		degreeMenu = new JComboBox<>(choices);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmButton) {			
			try {
				String firstName = firstNameText.getText();
				String lastName = lastNameText.getText();
				Date birtdayDate = (Date) datePicker.getModel().getValue();
				String familyCondition = String.valueOf(familyConditionMenu.getSelectedItem());
				
				int numOfChildren  = Integer.valueOf(numOfChildrenText.getText());
				int yearOfRecruitment = Integer.valueOf(yearOfRecruitmentText.getText());
				String specialization = specializationText.getText();
				String degree = String.valueOf(degreeMenu.getSelectedItem());
				
				Main.allEmployees.add(new Employee(firstName, lastName, birtdayDate, familyCondition, numOfChildren,
						yearOfRecruitment, specialization, degree));
				JOptionPane.showMessageDialog(frame, "Τα στοχεία καταχωρήθηκαν με επιτυχία!");
				frame.dispose();
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(frame, "Παρακαλώ εισάγετε σωστό αριθμό παιδιών ή σωστό έτος πρόσληψης!");
			}
		}
	}

}
