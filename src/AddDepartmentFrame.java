import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class AddDepartmentFrame implements ActionListener{
	JFrame frame;
	JLabel depNameLabel, depDescriptionLabel;
	JTextField depNameText;
	JTextArea depDescriptionText;
	JButton confirmButton;
	JPanel depPanel;
	JComboBox<Employee> directorMenu;
	public AddDepartmentFrame() {
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		Border bor = BorderFactory.createEmptyBorder(20, 10, 10, 10);
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
		
		createDirectorMenu();
		
		depPanel.add(depNameLabel);
		depPanel.add(depNameText);
		depPanel.add(depDescriptionLabel);
		depPanel.add(depDescriptionText);
		depPanel.add(confirmButton);
		
		depPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	    depPanel.setMaximumSize(new Dimension(300, 500));
				
		frame.getContentPane().add(depPanel);
		frame.setSize(300, 500);
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
			}
		}
	}
	
	public void createDirectorMenu() {
		directorMenu = new JComboBox<>();
		
	}
	
	
}