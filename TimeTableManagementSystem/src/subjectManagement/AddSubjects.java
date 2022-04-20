package subjectManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


import connection.DBConnection;
import home.DashBoard;
import lecturerManagement.Addactivedayshoursforlecturers;
import lecturerManagement.AddingLecturers;
import lecturerManagement.ManageLecturers;



public class AddSubjects {

	private JFrame frame;
	JTextField textField;
	 JTextField textField_1;
	JComboBox comboBox_1_2;
	JSpinner spinner;
	private JSpinner spinner_1,spinner_1_1,spinner_1_2,spinner_1_3;
	/**
	 * Launch the application.
	 */
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField txtAddSubjects;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubjects window = new AddSubjects();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddSubjects() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.setBounds(30, 30, 1270, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Time Table Management System");
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setForeground(Color.WHITE);
		panel_1.setLayout(null);
		
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.decode("#FFFEFE"));
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
		TimetableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TimetableBtn.setForeground(Color.BLACK);
		//TimetableBtn.setEnabled(false);
		TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TimetableBtn.setBackground(Color.decode("#FF7A48"));
		TimetableBtn.setBounds(10, 10, 233, 72);
		frame.getContentPane().add(TimetableBtn);
		
		
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddingLecturers addinglectures=new AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_2.setBounds(10, 106, 213, 38);//coom
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			;
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_5.setBounds(10, 250, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_6.setBounds(10, 298, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		

			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#4660BD"));
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Subjects");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSubjects addsubjects=new AddSubjects();
				addsubjects.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.decode("#103778"));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Subjects");
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSubject manage = new ManageSubject();
				manage.main(null);
				frame.setVisible(false);
			
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.decode("#554B82"));
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBox.setBounds(211, 49, 215, 33);
		panel_3.add(comboBox);
		
		 textField = new JTextField();
			textField.setBackground(new Color(255, 255, 255));
			textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textField.setBounds(211, 132, 217, 38);
			panel_3.add(textField);
			textField.setColumns(10);
			
			 textField_1 = new JTextField();
			textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textField_1.setBackground(new Color(255, 255, 255));
			textField_1.setBounds(711, 132, 217, 38);
			panel_3.add(textField_1);
			textField_1.setColumns(10);
		
	
		
		

		JButton btnNewButton_14 = new JButton("ADD");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setBackground(Color.decode("#103778"));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			try {
				
				
				if(textField_1.getText().equals("")||comboBox.getSelectedItem().equals("") ||comboBox_1_2.getSelectedItem().equals("")||spinner_1_3.getValue().equals("")||spinner_1_2.getValue().equals("")||spinner_1_1.getValue().equals("")||spinner_1.getValue().equals("")||textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the form");
					
					 
						
					
				}else if(!(textField.getText().trim().matches("^[A-Za-z]+"))){
					JOptionPane.showMessageDialog(null, "Invalid subject name");
				
				}
				
				else if(!(textField_1.getText().trim().matches("^[A-Z]{2}+[0-9]{4}+"))){
					JOptionPane.showMessageDialog(null, "Subject code should contain two upper case letters and three numbers");
				
				}else{
					
					Connection connec = DBConnection.connect();
					
					
						
						String offeredyear=comboBox.getSelectedItem().toString();
						String offeredsem=comboBox_1_2.getSelectedItem().toString();
						String subjectname=textField.getText();
						String subjectcode=textField_1.getText();
						String lecturehours=spinner_1_3.getValue().toString();
						String tutorialhours=spinner_1_2.getValue().toString();
						String labhours=spinner_1_1.getValue().toString();
						String evaluationhour=spinner_1.getValue().toString();
						
			               //String spinner=spinner;
			               //String value =spinner.getValue().toString();
			               
						String msg = "" + subjectname;
		                msg += "";
		                
		             //System.out.println(value);
						
						

	                	Connection con = DBConnection.connect();

	                    String query = "INSERT INTO SUbjects values('" + subjectcode + "','" + subjectname + "','" + offeredyear + "','" +
	                    		offeredsem + "','" + lecturehours + "','" + tutorialhours + "','"+ labhours +"','"+ evaluationhour +"')";

	                    java.sql.Statement sta = con.createStatement();
	                    int xx = sta.executeUpdate(query);
	                  
						
	                    
	                    
	                    
	                    JOptionPane.showMessageDialog(null,
	                            "Subject, " + msg + " is sucessfully added");
	                    
	                    con.close();
	                    textField.setText(null);
	    				textField_1.setText(null);
	                    comboBox.setSelectedItem(null);
	                    comboBox_1_2.setSelectedItem(null);
	                  
	                    
	                    
	                   
	                
						
						
						
						
						
						
					
				}
				}
				
				
			catch(Exception w){
				
				System.out.println(w);
			}
			
			finally{
                try{
                     pst.close();
                            rs.close();
                }catch(Exception r){
                    
                }
            }
				
				
			}
		});
		
		JButton btnNewButton_14_1 = new JButton("Clear");
		btnNewButton_14_1.setForeground(Color.WHITE);
		btnNewButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedItem(null);
				comboBox_1_2.setSelectedItem(null);
				textField.setText(null);
				textField_1.setText(null);
				
				
				//spinner.setValue(null);
				
			}
		});
		
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.decode("#103778"));
		btnNewButton_14.setBounds(355, 411, 168, 46);
		panel_3.add(btnNewButton_14);
		btnNewButton_14_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14_1.setBackground(Color.decode("#0593A2"));
		btnNewButton_14_1.setBounds(579, 411, 168, 46);
		panel_3.add(btnNewButton_14_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Offered Year");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 47, 131, 33);
		panel_3.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Offered Semester");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(481, 56, 156, 33);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 132, 156, 38);
		panel_3.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Subject Code");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBounds(481, 132, 156, 38);
		panel_3.add(lblNewLabel_4);
		
	
		
		JLabel lblNewLabel_5 = new JLabel("No.of.Lecturer Hours");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 211, 189, 38);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("No.of.Tutorial Hours");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1.setBounds(481, 211, 189, 38);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("No.of.Lab Hours");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1_1.setBounds(10, 296, 189, 38);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("No.of.Evaluation Hours");
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5_1_1_1.setBounds(481, 296, 213, 38);
		panel_3.add(lblNewLabel_5_1_1_1);
		
		 comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"First Semester", "Second Semester"}));
		comboBox_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_1_2.setBackground(new Color(255, 255, 255));
		comboBox_1_2.setBounds(711, 49, 217, 38);
		panel_3.add(comboBox_1_2);
		
		 spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1.setBounds(711, 296, 217, 38);
		spinner_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1);
		
		spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_1.setBounds(211, 296, 217, 38);
		spinner_1_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_1);
		
		 spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_2.setBounds(711, 211, 217, 38);
		spinner_1_2.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_2);
		
		 spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		spinner_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_3.setBounds(211, 211, 217, 38);
		spinner_1_3.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_3);
		
		txtAddSubjects = new JTextField();
		txtAddSubjects.setFont(new Font("Tahoma", Font.BOLD, 65));
		txtAddSubjects.setForeground(Color.WHITE);
		txtAddSubjects.setBackground(Color.decode("#4660BD"));
		txtAddSubjects.setText("ADD SUBJECTS");
		txtAddSubjects.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
		txtAddSubjects.setBounds(492, 17, 507, 65);
		frame.getContentPane().add(txtAddSubjects);
		txtAddSubjects.setColumns(10);
		
	}
}
