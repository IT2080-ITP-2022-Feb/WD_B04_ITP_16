package StudentManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import connection.DBConnection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AddingStudent {

private JFrame frame;
	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	static int no;
	static int noid;
	
	Connection conn;
	private JTextField GroupID;
	

	/**
	 * Launch the application.
	 */
	JSpinner spinner,spinner_2,spinner_1,spinner_1_3,spinner_1_1,spinner_1_1_1,spinner_1_2,spinner_1_2_1,spinner_3,spinner_2_1,spinner_1_4,spinner_1_3_1,spinner_1_1_2,spinner_1_1_1_1;
	private JTable table;
	private JTextField txtTimetableGenerator;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingStudent window = new AddingStudent();
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
	public AddingStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void getstutIDS() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Student";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("Stud_ID");
				//comboBox_2.addItem(name);
				
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

	
	/*public void checkstudents() {
		Connection conn = DBConnection.connect();
		try{
			//String LecturerName=LecturerName.getText();Connection conn = DBConnection.connect();
			String query="select * from Lecturer";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				 lecname=rs.getString("LecturerName");
				//comboBoxLec1_3.addItem(name);
				
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}*/
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.setBounds(30, 30, 1320, 750);
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
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*AddingLecturers addinglectures=new AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);*/
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddingStudent addingstudent=new AddingStudent();
				addingstudent.main(null);
				frame.setVisible(false);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setBounds(253, 174, 1045, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		lblNewLabel_1.setBounds(10, 10, 148, 41);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(563, 10, 148, 41);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Programme");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 83, 148, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Academic year semester");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 154, 205, 41);
		panel_3.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(563, 83, 148, 41);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sub Group");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(563, 168, 148, 41);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Group ID");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		lblNewLabel_7.setBounds(10, 233, 148, 41);
		panel_3.add(lblNewLabel_7);
		
		JComboBox Faculty = new JComboBox();
		Faculty.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering"}));
		Faculty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Faculty.setBackground(new Color(255, 255, 255));
		Faculty.setBounds(710, 10, 291, 41);
		panel_3.add(Faculty);
		
		JComboBox Programme = new JComboBox();
		Programme.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		Programme.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Programme.setBackground(new Color(255, 255, 255));
		Programme.setBounds(149, 83, 295, 41);
		panel_3.add(Programme);
		
		JComboBox Group = new JComboBox();
		Group.setModel(new DefaultComboBoxModel(new String[] {"Weekday", "Weekend"}));
		Group.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Group.setBackground(new Color(255, 255, 255));
		Group.setBounds(710, 83, 295, 41);
		panel_3.add(Group);
		
		JComboBox SubGroup = new JComboBox();
		SubGroup.setModel(new DefaultComboBoxModel(new String[] {"G1", "G2", "G3"}));
		SubGroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroup.setBackground(new Color(255, 255, 255));
		SubGroup.setBounds(710, 83, 295, 41);
		panel_3.add(SubGroup);
		
		GroupID = new JTextField();
		GroupID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupID.setColumns(10);
		GroupID.setBackground(new Color(255, 255, 255));
		GroupID.setBounds(149, 233, 299, 41);
		panel_3.add(GroupID);
		
		
		JButton btnNewButton_14 = new JButton("CLEAR");
		btnNewButton_14.setForeground(new Color(240, 248, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentID.setText(null);
				Faculty.setSelectedItem(null);
				Programme.setSelectedItem(null);
				AcademicYearSemester.setText(null);
				Group.setSelectedItem(null);
				SubGroup.setSelectedItem(null);
				GroupID.setText(null);
				
				
				spinner.setValue(null);
				spinner_2.setValue(null);
				spinner_1.setValue(null);
				spinner_1_3.setValue(null);
				spinner_1_1.setValue(null);
				spinner_1_1_1.setValue(null);
				spinner_1_2.setValue(null);
				spinner_1_2_1.setValue(null);
				spinner_3.setValue(null);
				spinner_2_1.setValue(null);
				spinner_1_4.setValue(null);
				spinner_1_3_1.setValue(null);
				spinner_1_1_2.setValue(null);
				spinner_1_1_1_1.setValue(null);
        
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.decode("#0593A2"));
		btnNewButton_14.setBounds(543, 409, 157, 41);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("ADD");
		btnNewButton_15.setForeground(new Color(240, 248, 255));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!(StudentID.getText().trim().matches("^[a-z0-9]+"))){
						JOptionPane.showMessageDialog(null, "Student Id Should Contain Nine Integers");
						
					}else if(Faculty.getSelectedItem().toString().equals("Computing") && Programme.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&& Programme.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&& Programme.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Programme.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Programme.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Programme.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					
					}else {
						Connection connec = DBConnection.connect();
					
						
							
							String sid=StudentID.getText();
							String faculty=Faculty.getSelectedItem().toString();
							String programme=Programme.getSelectedItem().toString();
							String academic=AcademicYearSemester.getText();
							String group=Group.getSelectedItem().toString();
							String subgroup=SubGroup.getSelectedItem().toString();
							String gid=GroupID.getText();				
	
							Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Student values('" + sid + "','" + faculty + "','" + programme + "','" +
		                    		academic + "','" + group + "','" + subgroup +"','"+ gid +"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null)";

		                    Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                    
		                    if (xx == 0) {
		                    	JOptionPane.showMessageDialog(btnNewButton, "This record already exist");
							} else {
								
								/*JOptionPane.showMessageDialog(null,
			                            "" + msg + "' Record is sucessfully created and added to the system");
			                    Addactivedayshoursforlecturers activedays=new Addactivedayshoursforlecturers();
			    				activedays.main(null);
			    				//frame.setVisible(false);
			                    
			                    con.close();
								  LecturerID.setText(null);
								  Faculty.setSelectedItem(null);
								  Deprtment.setSelectedItem(null);
								  Center.setSelectedItem(null);
								  Building.setSelectedItem(null);
								  Level.setSelectedItem(null);
								  Rank.setText(null);*/
			                    
			                   
			                
								}
		                    
		                	
					}
					}
				catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
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
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.decode("#103778"));
		btnNewButton_15.setBounds(344, 409, 157, 41);
		panel_3.add(btnNewButton_15);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(145, 10, 299, 41);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(225, 154, 219, 41);
		panel_3.add(textField_1);
		
		JComboBox Programme_1 = new JComboBox();
		Programme_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Programme_1.setBackground(Color.WHITE);
		Programme_1.setBounds(710, 168, 295, 41);
		panel_3.add(Programme_1);
		
		table = new JTable();
		table.setBounds(358, 44, 1, 1);
		frame.getContentPane().add(table);
		
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
		
		txtTimetableGenerator = new JTextField();
		txtTimetableGenerator.setForeground(new Color(255, 255, 255));
		txtTimetableGenerator.setBackground(Color.decode("#4660BD"));
		txtTimetableGenerator.setFont(new Font("Calibri", Font.BOLD, 38));
		txtTimetableGenerator.setText("ADD STUDENTS");
		txtTimetableGenerator.setBounds(389, 57, 266, 72);
		frame.getContentPane().add(txtTimetableGenerator);
		txtTimetableGenerator.setColumns(10);
		
		
		
		JButton btnNewButton_13_1 = new JButton("Manage Students");
		btnNewButton_13_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudent managestudent=new ManageStudent();
				managestudent.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_13_1.setForeground(new Color(240, 248, 255));
		btnNewButton_13_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13_1.setBackground(Color.decode("#554B82"));
		btnNewButton_13_1.setBounds(964, 88, 258, 41);
		frame.getContentPane().add(btnNewButton_13_1);
		
		
	}
}
