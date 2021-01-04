import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class AddDepartmentFrame implements ActionListener{
	private JFrame frame;
	private JLabel depNameLabel, depDescriptionLabel;
	private JTextField depNameText;
	private JTextArea depDescriptionText;
	private JButton confirmButton;
	private JPanel depPanel;
	private JComboBox<String> directorMenu;
	private JLabel depDirectorLabel;
	
	public AddDepartmentFrame() {
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		Border bor = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		frame = new JFrame("Add Department");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		depPanel = new JPanel();
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		depNameLabel = new JLabel("Όνομα Τμήματος");
		depNameText = new JTextField(20);
		depNameLabel.setFont(font);
		depNameLabel.setBorder(bor);
		
		depDescriptionLabel = new JLabel("Περιγραφή Τμήματος");
		depDescriptionText = new JTextArea(10,20);
		depDescriptionLabel.setFont(font);
		depDescriptionLabel.setBorder(bor);
		
		depDirectorLabel = new JLabel("Διευθυντής Τμήματος");
		depDirectorLabel.setFont(font);
		depDirectorLabel.setBorder(bor);
		createDirectorMenu();
		
		depPanel.add(depNameLabel);
		depPanel.add(depNameText);
		depPanel.add(depDescriptionLabel);
		depPanel.add(depDescriptionText);
		depPanel.add(depDirectorLabel);
		depPanel.add(directorMenu);
		depPanel.add(confirmButton);
		
	    depPanel.setMaximumSize(new Dimension(300, 500));
				
		frame.getContentPane().add(depPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirmButton) {
			if(depNameText.getText().equals("") || depDescriptionText.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "Παρακαλώ εισάγετε όλα τα πεδία");
			}else {
				Department d = new Department(depNameText.getText(),depDescriptionText.getText());
				Main.allDeparments.add(d);
				JOptionPane.showMessageDialog(frame, "Το τμήμα <<" + depNameText.getText() + ">> καταχωρήθηκε με επιτυχία!");
				frame.dispose();
			}
		}
	}
	
	public void createDirectorMenu() {
		ArrayList<String> names = new ArrayList<String>();		
		String[] choices = {"Επιλογή..."};
		for(Employee e : Main.allEmployees) {
			names.add(e.getFirstName() +" "+ e.getLastName());	
		}
		
		if(names.isEmpty() == false) {
			choices =  names.stream().toArray(String[]::new);
		}
		
		directorMenu = new JComboBox<>(choices);
		
	}
	
	
}
