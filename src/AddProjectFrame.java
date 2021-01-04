import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class AddProjectFrame implements ActionListener{
	
	private JFrame frame;
	private JPanel projectPanel;
	private JButton confirmButton;
	private JLabel projectNameLabel, projectDescriptionLabel, projectEndDateLabel, projectEarningsLabel;
	private JTextArea projectDescriptionText;
	private JDatePickerImpl datePicker;
	private JTextField projectEarningsText, projectNameText;

	public AddProjectFrame() {
		Font font = new Font("Sans Serif", Font.BOLD, 16);
		Border bor = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		frame = new JFrame("Add Project");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		projectPanel = new JPanel();
		confirmButton = new JButton("Αποθήκευση");
		confirmButton.addActionListener(this);
		
		projectNameLabel = new JLabel("Όνομα Έργου");
		projectNameText = new JTextField(20);
		projectNameLabel.setFont(font);
		projectNameLabel.setBorder(bor);
		
		projectDescriptionLabel = new JLabel("Περιγραφή Έργου");
		projectDescriptionText = new JTextArea(10,20);
		projectDescriptionLabel.setFont(font);
		projectDescriptionLabel.setBorder(bor);
		
		projectEndDateLabel = new JLabel("Ημ/νια Περάτωσης");
		projectEndDateLabel.setFont(font);
		projectEndDateLabel.setBorder(bor);
		createCalender();
		
		projectEarningsLabel = new JLabel("Αρχικός Προϋπολογισμός");
		projectEarningsLabel.setFont(font);
		projectEarningsLabel.setBorder(bor);
		projectEarningsText = new JTextField(6);
				
		projectPanel.add(projectNameLabel);
		projectPanel.add(projectNameText);
		projectPanel.add(projectDescriptionLabel);
		projectPanel.add(projectDescriptionText);
		projectPanel.add(projectEndDateLabel);
		projectPanel.add(datePicker);
		projectPanel.add(projectEarningsLabel);
		projectPanel.add(projectEarningsText);
		projectPanel.add(confirmButton);
		
	    projectPanel.setMaximumSize(new Dimension(300, 500));
				
		frame.getContentPane().add(projectPanel);
		frame.setSize(400, 550);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
	}
	
	public void createCalender() {
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource() == confirmButton) {
			try {
				String projectName = projectNameText.getText();
				String projectDescription = projectDescriptionText.getText();
				Date currentDate = new Date(System.currentTimeMillis());
				Date endDate = (Date) datePicker.getModel().getValue();
				int projectEarnings = Integer.valueOf(projectEarningsText.getText());
				Main.allProjects.add(new Project(projectName, projectDescription, projectEarnings, currentDate, endDate));
				JOptionPane.showMessageDialog(null, "Τα στοιχεία καταχωρήθηκαν με επιτυχία!");
				frame.dispose();
			}catch(NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Παρακαλώ εισάγετε σωστό αριθμό προϋπολογισμού!");
			}
		}
	}
}
