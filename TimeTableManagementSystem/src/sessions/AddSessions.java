package sessions;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import connection.DBConnection;
import lecturerManagement.AddingLecturers;



public class AddSessions {

	private JFrame frame;
	private JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	JSpinner spinner_1,spinner_1_1,spinner_2;
	JComboBox comboBox_1_1_1,comboBox_1_1_1_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSessions window = new AddSessions();
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
	public void viewTags() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Tag";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("TagName");
				comboBox_2.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void viewgroupID() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from StudentGroups";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubGroupID");
				comboBox_3.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	public void fillcombobox() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void fillcombobox2() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBox_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void fillcombobox3() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBox_1_1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void calculateDuration() {
		//int sTime=(int) spinner_1.getValue();
		//int endTime=(int) spinner_1_1.getValue();
		/**
		 * String starttime=spinner_1.getValue().toString();
		String endtime=spinner_1_1.getValue().toString();
		
		String duration=""+endtime+"-"+starttime+"";
		textField_1.setText(duration);
		 */
		
		int st=(int) spinner_1.getValue();
		int et=(int)spinner_1_1.getValue();
		
		int duration=et-st;
		String du = String.valueOf(duration);
		textField_2.setText(du);
		
	}
	
	public void checksubjectcode() {
		
		String subname=comboBox_1_1_1.getSelectedItem().toString();

		Connection conn = DBConnection.connect();
		try{
			String query="select SubjectCode from SUbjects where SubjectName='"+subname+"'";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				//String name=rs.getString("SubjectName");
				String scode=rs.getString("SubjectCode");
				textField_1.setText(scode);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	
	}
	
	public AddSessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setBounds(253, 174, 1043, 529);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 36, 160, 36);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2(Optional)");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 97, 232, 36);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(603, 97, 160, 36);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(10, 159, 160, 36);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(10, 220, 160, 43);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Duration(Hours)");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(603, 33, 160, 43);
		panel_3.add(lblNewLabel_8);
		
		JButton btnNewButton_13 = new JButton("Submit");
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				calculateDuration();
				
				
				
				String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBox_1_1_1.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=spinner_2.getValue().toString();
				String duration=textField_2.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
				
				
				
				
				try {
					
					
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_1_1_1.getSelectedItem().equals("")||spinner_1.getValue().equals("")||spinner_2.getValue().equals("")||textField_2.getText().equals("")||spinner_1_1.getValue().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
						 
							
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())){
						JOptionPane.showMessageDialog(null, "Select a different lecturer for lecturer 2");
					
					}else if(spinner_1.getValue().equals(spinner_1_1.getValue())){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(11)&& spinner_1_1.getValue().equals(10)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(12)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(12)&& spinner_1_1.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(13)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(14)&& spinner_1_1.getValue().equals(13)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(13)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_1.getValue().equals(15)&& spinner_1_1.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(!(sessionID.equals(textField.getText().toString()))){
						JOptionPane.showMessageDialog(null, "Invalid Session ID! please press generate button again");
					}else {
						
					
						
						Connection connec = DBConnection.connect();
						
						/*String checkID= "select Emp_ID from Lecturers";
						PreparedStatement pstID = conn.prepareStatement(checkID);
						rs=pstID.executeQuery();
						while(rs.next()) {
							String id = rs.getString("Emp_ID");
						if(LecturerID.getText().equals(id)) {
							System.out.println("The Lecturer id has already exist! Please choose a different id.");
							JOptionPane.showMessageDialog(null, "The Lecturer id has already exist! Please choose a different id.");
						}*/
					
					//String sq="SELECT Emp_ID from Lecturers";
					//java.sql.Statement state = connec.createStatement();
	                //int x = state.executeUpdate(sq);
	                //if (x == 0) {
	                 //   JOptionPane.showMessageDialog(null, "This is alredy exist");
	                //}
					//else {
							calculateDuration();
							
							String Lecturer1=comboBoxLec1.getSelectedItem().toString();
							String Lecturer2=comboBox_1.getSelectedItem().toString();
							String Tag=comboBox_2.getSelectedItem().toString();
							String Group=comboBox_3.getSelectedItem().toString();
							//String subjectcode=comboBox_1_1.getSelectedItem().toString();
							String subjectname=comboBox_1_1_1.getSelectedItem().toString();
							String numberofstudents=spinner_2.getValue().toString();
							//String duration=spinner.getValue().toString();
							String tduration=textField_2.getText().toString();
							String starttime=spinner_1.getValue().toString();
							String endtime=spinner_1_1.getValue().toString();
							//String date=comboBox_2_1.getSelectedItem().toString();
							String sessionid=textField.getText();
				               //String spinner=spinner;
				               //String value =spinner.getValue().toString();
							String sCode=textField_1.getText();
							String msg = "" + subjectname;
			                msg += "";
			                
			             //System.out.println(value);
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Sessions values(null,'" + Lecturer1 + "','" + Lecturer2 + "','" + Tag + "','" +
		                    		Group + "','" + numberofstudents + "','" + starttime + "','"+ endtime +"','"+ tduration +"','"+ subjectname +"','"+ sCode +"','"+ sessionid +"')";

		                    java.sql.Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                    /*if (xx == 0) {
		                        JOptionPane.showMessageDialog(null, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(null,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    }
		                    String checkID= "select Emp_ID from Lecturers";
							PreparedStatement pstID = conn.prepareStatement(checkID);
							rs=pstID.executeQuery();
							while(rs.next()) {
								String id = rs.getString("Emp_ID");
								if(LecturerID.getText().equals(id))
								JOptionPane.showMessageDialog(null, "This is alredy exist");
								
							}*/
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Subject, " + msg + " is sucessfully added");
		                    
		                    con.close();
		                    comboBoxLec1.setSelectedItem(null);
		    				comboBox_1.setSelectedItem(null);
		    				comboBox_2.setSelectedItem(null);
		    				comboBox_3.setSelectedItem(null);
		    				//comboBox_1_1.setSelectedItem(null);
		    				comboBox_1_1_1.setSelectedItem(null);
		    				textField.setText(null);
		    				textField_2.setText(null);
		    				textField_1.setText(null);
		                    
		                   
		                
							
							
							
							
							
							
						
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
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.decode("#103778"));
		btnNewButton_13.setBounds(370, 448, 160, 54);
		panel_3.add(btnNewButton_13);
		
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
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBoxLec1.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				//comboBox_1_1.setSelectedItem(null);
				comboBox_1_1_1.setSelectedItem(null);
				textField.setText(null);
				textField_2.setText(null);
				textField_1.setText(null);
				//textField.setText(null);comboBox_2
			
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.decode("#0593A2"));
		btnNewButton_14.setBounds(569, 448, 176, 54);
		panel_3.add(btnNewButton_14);
		
	    comboBoxLec1 = new JComboBox();
	    comboBoxLec1.setModel(new DefaultComboBoxModel(new String[] {"----------Select Lecturer-----------"}));
	    comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    comboBoxLec1.setBackground(new Color(255, 255, 255));
		comboBoxLec1.setBounds(289, 36, 268, 36);
		panel_3.add(comboBoxLec1);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"----------Select Lecturer-----------"}));
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(289, 97, 268, 36);
		panel_3.add(comboBox_1);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"----Select Tag----"}));
		 comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(790, 97, 225, 36);
		panel_3.add(comboBox_2);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"----Select Student Group----"}));
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(289, 159, 268, 36);
		panel_3.add(comboBox_3);
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(10, 292, 142, 35);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(10, 355, 130, 53);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(603, 163, 142, 29);
		panel_3.add(lblNewLabel_11);
		
		 spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		spinner_1.setBounds(289, 288, 225, 43);
		spinner_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1);
		
		 spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(10, 10, 17, 1));
		spinner_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_1_1.setBounds(289, 360, 225, 43);
		spinner_1_1.setBackground(new Color(255, 255, 255));
		panel_3.add(spinner_1_1);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 250, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_2.setBackground(new Color(255, 255, 255));
		spinner_2.setBounds(289, 220, 225, 43);
		panel_3.add(spinner_2);
		
		 comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox_1_1_1.setBackground(Color.WHITE);
		comboBox_1_1_1.setBounds(790, 159, 225, 36);
		panel_3.add(comboBox_1_1_1);
		
		
		JLabel lblNewLabel_11_1 = new JLabel("Session ID");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(603, 295, 142, 29);
		panel_3.add(lblNewLabel_11_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textField.setEditable(false);
		textField.setBounds(769, 294, 251, 34);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_13_1 = new JButton("Generate Session ID");
		btnNewButton_13_1.setForeground(Color.WHITE);
		btnNewButton_13_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				

				

				
				
				
				String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBox_1_1_1.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=spinner_2.getValue().toString();
				String duration=textField_2.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
				
			
			
				
			
				
				
			}
		});
		btnNewButton_13_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13_1.setBackground(Color.BLACK);
		btnNewButton_13_1.setBounds(767, 354, 218, 54);
		panel_3.add(btnNewButton_13_1);
		
		JLabel lblNewLabel_11_2 = new JLabel("Subject Code");
		lblNewLabel_11_2.setForeground(Color.WHITE);
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_2.setBounds(603, 227, 142, 29);
		panel_3.add(lblNewLabel_11_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(790, 224, 225, 36);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_2.setEditable(false);
		textField_2.setBounds(790, 33, 225, 43);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(253, 24, 953, 67);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.decode("#4660BD"));
		
		JLabel lblNewLabel_1 = new JLabel("ADD SESSIONS");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel_1.setBackground(Color.decode("#4660BD"));
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
		lblNewLabel_1.setBounds(265, 10, 548, 47);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(253, 101, 973, 76);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#4660BD"));
		
		JButton btnNewButton_12 = new JButton("Manage Sessions");
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManageSessions manageSess = new ManageSessions();
				manageSess.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBounds(697, 9, 266, 58);
		btnNewButton_12.setBackground(Color.decode("#554B82"));
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_11 = new JButton("Add Sessions");
		btnNewButton_11.setBounds(23, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSessions addsessions=new AddSessions();
				addsessions.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.decode("#103778"));
		
		
		comboBox_1_1_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		try {
						String subject = comboBox_1_1_1.getSelectedItem().toString();
						Connection con = DBConnection.connect();
						String query = "select SubjectCode from SUbjects where SubjectName = '" + subject + "'";
						PreparedStatement pst = con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						//select SubjectCode from SUbjects where SubjectName='"+subname+"'
						while (rs.next()) {

							String name = rs.getString("SubjectCode");
							textField_1.setText(name);
							
						}
						con.close();
					} catch (Exception e) {
						
					}
			 	}
			 });
		
		
		
		
		
		fillcombobox();
		fillcombobox2();
		fillcombobox3();
		viewgroupID();
		viewTags();
		calculateDuration();
		checksubjectcode();
		//fillcombobox4();
		
	}

}
