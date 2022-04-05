package lecturerManagement;

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
import java.util.Random;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import connection.DBConnection;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;



public class AddingLecturers {

private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	static int no;
	static int noid;
	
	Connection conn;
	String lecname;
	private JTextField LecturerName;
	private JTextField LecturerID;
	private JTextField Rank;
	/**
	 * Launch the application.
	 */
	
	JCheckBox chckbxNewCheckBox,chckbxTuesday,chckbxWednesday,chckbxThursday,chckbxFriday,chckbxSaturday,chckbxSunday;
	JSpinner spinner,spinner_2,spinner_1,spinner_1_3,spinner_1_1,spinner_1_1_1,spinner_1_2,spinner_1_2_1,spinner_3,spinner_2_1,spinner_1_4,spinner_1_3_1,spinner_1_1_2,spinner_1_1_1_1;
	private JTable table;
	private JTextField txtTimetableGenerator;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingLecturers window = new AddingLecturers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */

	public AddingLecturers() {
		initialize();
		
	}
	
	public String generateID() {
		ArrayList<String> arrayList = new ArrayList<String>();
		String name = "Lec000";
		int rand = (int) (Math.random()*10);
		String id=name+ rand;
		
		return id;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void getlecIDS() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("Emp_ID");
				//comboBox_2.addItem(name);
				
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

	
	public void checklecturers() {
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
	}
	
	
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
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setBounds(253, 174, 1045, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		
		lblNewLabel_1.setBounds(10, 83, 148, 41);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lecturer ID");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 10, 148, 41);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(563, 10, 148, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(563, 83, 148, 41);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Center");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(10, 165, 129, 33);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Building");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(563, 161, 148, 41);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Level");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(10, 246, 129, 41);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Rank");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(563, 246, 129, 41);
		panel_3.add(lblNewLabel_8);
		
		LecturerName = new JTextField();
		LecturerName.setBackground(new Color(255, 255, 255));
		LecturerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LecturerName.setBounds(149, 83, 299, 41);
		panel_3.add(LecturerName);
		LecturerName.setColumns(10);
		
		LecturerID = new JTextField();
		LecturerID.setEditable(false);
		LecturerID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		LecturerID.setColumns(10);
		LecturerID.setBackground(new Color(255, 255, 255));
		LecturerID.setBounds(149, 10, 299, 41);
		panel_3.add(LecturerID);
		
		JComboBox Faculty = new JComboBox();
		Faculty.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering"}));
		Faculty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Faculty.setBackground(new Color(255, 255, 255));
		Faculty.setBounds(710, 10, 291, 41);
		panel_3.add(Faculty);
		
		JComboBox Deprtment = new JComboBox();
		Deprtment.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		Deprtment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Deprtment.setBackground(new Color(255, 255, 255));
		Deprtment.setBounds(710, 83, 295, 41);
		panel_3.add(Deprtment);
		
		JComboBox Center = new JComboBox();
		Center.setModel(new DefaultComboBoxModel(new String[] {"Kandy", "Malabe", "Jaffna", "Matara"}));
		Center.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Center.setBackground(new Color(255, 255, 255));
		Center.setBounds(710, 161, 299, 41);
		panel_3.add(Center);
		
		JComboBox Building = new JComboBox();
		Building.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		Building.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Building.setBackground(new Color(255, 255, 255));
		Building.setBounds(149, 161, 295, 41);
		panel_3.add(Building);
		
		JComboBox Level = new JComboBox();
		Level.setModel(new DefaultComboBoxModel(new String[] {"Professor               ", "AssistantProfessor  ", "Senior Lecturer(HG)", "Senior Lecturer   ", "Lecturer", "Assistant Lecturer"}));
		Level.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Level.setBackground(new Color(255, 255, 255));
		Level.setBounds(145, 246, 299, 41);
		panel_3.add(Level);
		
		Rank = new JTextField();
		Rank.setEditable(false);
		Rank.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Rank.setColumns(10);
		Rank.setBackground(new Color(255, 255, 255));
		Rank.setBounds(710, 246, 202, 41);
		panel_3.add(Rank);
		
		JButton btnNewButton_13 = new JButton("GENERATE ID AND RANK");
		btnNewButton_13.setForeground(new Color(240, 248, 255));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				String autofill;
				String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
				String getID=LecturerID.getText();
				String getRank=(String) Level.getSelectedItem();
			
				/*if(comboBoxLevel.getSelectedItem().toString().matches(p)) {
					getRank=1;
				}*/
				String i= "000";
				if(getRank.contains(p)) {
					i = "001";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
				 
				}
				if(getRank.contains(A)) {
					i = "002";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
					
				}
				if(getRank.contains(S)) {
					i = "003";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
				}
				if(getRank.contains(Se)) {
					i = "004";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
				}
				if(getRank.contains(Lec)) {
					i = "005";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
				}
				if(getRank.contains(AL)) {
					i = "006";
					//String combination=getRank.substring(0,3);
					
					String combination=getRank.substring(0,4);
					Rank.setText(combination+i);
				}
			
				
				LecturerID.setText(generateID());
				
				
			
			}
		});
		
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.decode("#151F30"));
		btnNewButton_13.setBounds(710, 320, 314, 41);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("CLEAR");
		btnNewButton_14.setForeground(new Color(240, 248, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LecturerName.setText(null);
				LecturerID.setText(null);
				Faculty.setSelectedItem(null);
				Deprtment.setSelectedItem(null);
				Center.setSelectedItem(null);
				Building.setSelectedItem(null);
				Level.setSelectedItem(null);
				Rank.setText(null);
				
				
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
					
					
					if(LecturerName.getText().equals("")||LecturerID.getText().equals("") ||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(LecturerName.getText().trim().matches("^[A-Za-z]+"))){
						JOptionPane.showMessageDialog(null, "Invalid Lecturer name","Warning",JOptionPane.WARNING_MESSAGE);
						
					}
					else if(!(LecturerID.getText().trim().matches("^[A-Za-z0-9]+"))){
						JOptionPane.showMessageDialog(null, "Lecturer Id Should Contain the following format (Lec00x)","Warning",JOptionPane.WARNING_MESSAGE);
					
					}else if(Faculty.getSelectedItem().toString().equals("Computing") && Deprtment.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&&Deprtment.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(Faculty.getSelectedItem().toString().equals("Computing")&& Deprtment.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}else if(Faculty.getSelectedItem().toString().equals("Engineering") && Deprtment.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch","Warning",JOptionPane.WARNING_MESSAGE);
					}
				else {
						Connection connec = DBConnection.connect();
					
						
							
							
							String Name=LecturerName.getText();
							String ID=LecturerID.getText();
							String faculty=Faculty.getSelectedItem().toString();
							String Department=Deprtment.getSelectedItem().toString();
							String center=Center.getSelectedItem().toString();
							String building=Building.getSelectedItem().toString();
							String level=Level.getSelectedItem().toString();
							String rank=Rank.getText();
							
				               

							String msg = "" + Name;
			                
			                
			             
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Lecturers values('" + ID + "','" + Name + "','" + faculty + "','" +
		                    		center + "','" + Department + "','" + building + "','"+ level +"','"+ rank +"',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null)";


		                    Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                    
		                    if (xx == 0) {
		                    	JOptionPane.showMessageDialog(btnNewButton, "This record already exist","Warning",JOptionPane.WARNING_MESSAGE);
							} else {
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,msg+" Lecturer's Record of Lecturer is sucessfully created and added to the system, "
		                    		+ "please add active hours and days","Info",JOptionPane.INFORMATION_MESSAGE);
		                    Addactivedayshoursforlecturers activedays=new Addactivedayshoursforlecturers();
		    				activedays.main(null);
		    				//frame.setVisible(false);
		                    
		                    con.close();
		                      LecturerName.setText(null);
							  LecturerID.setText(null);
							  Faculty.setSelectedItem(null);
							  Deprtment.setSelectedItem(null);
							  Center.setSelectedItem(null);
							  Building.setSelectedItem(null);
							  Level.setSelectedItem(null);
							  Rank.setText(null);
		                    
		                   
		                
							}
							
							
							
							
							
						
					}
					}
					
					
				catch(Exception w){
					JOptionPane.showMessageDialog(null, "Lecturer ID Already exits","Error",JOptionPane.ERROR_MESSAGE );
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
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.decode("#103778"));
		btnNewButton_15.setBounds(344, 409, 157, 41);
		panel_3.add(btnNewButton_15);
		
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
		txtTimetableGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimetableGenerator.setForeground(new Color(255, 255, 255));
		txtTimetableGenerator.setBackground(Color.decode("#4660BD"));
		txtTimetableGenerator.setFont(new Font("Calibri", Font.BOLD, 38));
		txtTimetableGenerator.setText("ADD LECTURERS");
		txtTimetableGenerator.setBounds(358, 55, 464, 72);
		frame.getContentPane().add(txtTimetableGenerator);
		txtTimetableGenerator.setColumns(10);
		
		
		
		JButton btnNewButton_13_1 = new JButton("Manage Lecturers");
		btnNewButton_13_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLecturers managelecturers=new ManageLecturers();
				managelecturers.main(null);
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
