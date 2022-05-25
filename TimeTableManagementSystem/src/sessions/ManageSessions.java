package sessions;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import connection.DBConnection;
import consecutiveSession.NotAvailableTIme;
import home.DashBoard;
import lecturerManagement.AddingLecturers;
import net.proteanit.sql.DbUtils;

public class ManageSessions {

	public JFrame frame;
	private JTable table;
	//private JSpinner spinner_1,spinner_1_1;
	
	/**
	 * Launch the application.
	 */
	JSpinner spinner_2,spinner_3;
	PreparedStatement pst=null;
	ResultSet rs = null;
	JComboBox comboBox;
	JComboBox comboBoxLec1_1;
	private JTextField textField_1;
	//JSpinner spinner,spinner_1,spinner_1_1;
	JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3,comboBoxLec1_3;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSessions window = new ManageSessions();
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
	
	public void refresh() {
		
		Connection conn = DBConnection.connect();
		
		
        try {
        	//String tag=comboBox.getSelectedItem().toString();
        	//String lecname=comboBoxLec1_1.getSelectedItem().toString();
        	
        	String sql="select * from Sessions";
			pst=conn.prepareStatement(sql);
			
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	public void viewTag() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Tag";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("TagName");
				comboBox.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	
	public void fillsubjectName() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBoxLec1_3.addItem(name);
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
				comboBoxLec1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void fillcombobox1() {
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
	
	//calculate duration 
	public void calculateDuration() {
		
		int st=(int) spinner_2.getValue();
		int et=(int)spinner_3.getValue();
		
		int duration=et-st;
		String du = String.valueOf(duration);
		textField_3.setText(du);
		
	}
	public ManageSessions() {
		initialize();
		refresh();
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
				DashBoard hme = new DashBoard();
				hme.main(null);
				frame.setVisible(false);
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
				
				NotAvailableTIme not = new NotAvailableTIme();
				not.main(null);
				frame.setVisible(false);
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
		panel_3.setBounds(253, 174, 1008, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 10, 1017, 508);
		panel_5.setBackground(Color.decode("#4660BD"));
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_2.setBackground(Color.WHITE);
		spinner_2.setBounds(520, 383, 142, 32);
		panel_5.add(spinner_2);
		
		 spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(10, 10, 17, 1));
		spinner_3.setForeground(Color.BLACK);
		spinner_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		spinner_3.setBackground(Color.WHITE);
		spinner_3.setBounds(520, 439, 142, 32);
		panel_5.add(spinner_3);
		
		JButton btnNewButton_13 = new JButton("Search");
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				

				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	//String tag=comboBox.getSelectedItem().toString();
	            	//String lecname=comboBoxLec1_1.getSelectedItem().toString();
	            	
	            	String sql="Select * from Sessions where Tag='"+comboBox.getSelectedItem().toString()+"' AND Lecturer1='"+comboBoxLec1_1.getSelectedItem().toString()+"'";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			
				///////////
				
				//GEN-FIRST:event_jButton1ActionPerformed
				/*Connection conn = DBConnection.connect();
		        if(comboBox.getSelectedItem().equals("Tutorial")){
		           try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==1){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==2){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception t ){
		                   
		               }
		           }
		        
		        }*/
		       
				
			
				///////////
			}
		});
		btnNewButton_13.setBounds(661, 12, 127, 39);
		panel_5.add(btnNewButton_13);
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.decode("#103778"));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"----------Select Tag-------------"}));
		comboBox.setBounds(341, 12, 270, 39);
		panel_5.add(comboBox);
		comboBox.setBackground(Color.WHITE);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 796, 123);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				

                int selectedRow=table.getSelectedRow();
				
				
			
                textField_1.setText(table.getValueAt(selectedRow,5).toString());
                textField_4.setText(table.getValueAt(selectedRow,0).toString());
           
                	
                String lecturer1=table.getValueAt(selectedRow, 1).toString();
                	String getlecturername=(String)comboBoxLec1.getSelectedItem();
                	comboBoxLec1.setSelectedItem(lecturer1);
                	
               String lecturer2=table.getValueAt(selectedRow, 2).toString();
                	String getlecturer2=(String)comboBox_1.getSelectedItem();
                	comboBox_1.setSelectedItem(lecturer2);
                
                 String tagname=table.getValueAt(selectedRow, 3).toString();
                	String getTag=(String)comboBox_2.getSelectedItem();
                	comboBox_2.setSelectedItem(tagname);
                	
                String studentgroup=table.getValueAt(selectedRow, 4).toString();
                 	String getstudengroup=(String)comboBox_3.getSelectedItem();
                 	comboBox_3.setSelectedItem(studentgroup);
                 	
                String subjectName=table.getValueAt(selectedRow, 9).toString();
                 	String getsubjectname=(String)comboBoxLec1_3.getSelectedItem();
                 	comboBoxLec1_3.setSelectedItem(subjectName);
                 
                 String date=table.getValueAt(selectedRow, 10).toString();
                	String getdate=(String)textField_2.getText();
                	textField_2.setText(date);
                 	
                	
                	String duration=table.getValueAt(selectedRow, 8).toString();
                	String getduration=(String)textField_3.getText();
                	textField_3.setText(duration);
                 	//spinner_1.setValue(table.getValueAt(selectedRow, 6).toString());
                	//textField_3.setValue((Double)table.getValueAt(selectedRow, 8));	
                 	spinner_2.setValue((int)table.getValueAt(selectedRow, 6));
                 	spinner_3.setValue((int)table.getValueAt(selectedRow, 7));
                 	//spinner_3.setValue((Integer)table.getValueAt(selectedRow, 8));
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
                 	String SID=table.getValueAt(selectedRow, 11).toString();
                	String getSID=(String)textField.getText();
                	textField.setText(SID);
                 	
				
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
				{},
				{},
				{},
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_16 = new JButton("Update");
		btnNewButton_16.setForeground(Color.WHITE);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				calculateDuration();
				
				String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
				
				
				

				try {
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||textField_1.getText().equals("")||textField_3.getText().equals("")||spinner_2.getValue().equals("")||spinner_3.getValue().equals("")||comboBoxLec1_3.getSelectedItem().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())) {
						
						JOptionPane.showMessageDialog(null, "Please select a different lecturer for lecturer2(Optional)");
					}else if(spinner_2.getValue().equals(spinner_3.getValue())){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(11)&& spinner_3.getValue().equals(10)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(12)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(10)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(12)&& spinner_3.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(11)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(11)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(13)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(12)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(14)&& spinner_3.getValue().equals(13)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(13)) {
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(spinner_2.getValue().equals(15)&& spinner_3.getValue().equals(14)){
						JOptionPane.showMessageDialog(null, "Invalid Session Start Time And End Time");
					}else if(!(sessionID.equals(textField.getText().toString()))){
						JOptionPane.showMessageDialog(null, "Invalid Session ID! please press generate button again");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update Sessions set Lecturer1='"+comboBoxLec1.getSelectedItem()+"',Lecturer2='"+comboBox_1.getSelectedItem()+"',Tag='"+comboBox_2.getSelectedItem()+"',StudentGroup='"+comboBox_3.getSelectedItem()+"',NumberOfStudents='"+textField_1.getText()+"',Duration='"+textField_3.getText()+"',StartTime='"+spinner_2.getValue()+"' ,EndTime='"+spinner_3.getValue()+"' ,SubjectName='"+comboBoxLec1_3.getSelectedItem()+"',SubjectCode='"+textField_2.getText()+"',SID='"+textField.getText()+"' where SessionID='"+textField_4.getText()+"' ";//spinner_1
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
					
				}
				
			
				
				
				
				refresh();
				
			}
		});
		btnNewButton_16.setBackground(Color.decode("#103778"));
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_16.setBounds(816, 66, 127, 39);
		panel_5.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("Delete");
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
	
				
				try {
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A SESSION");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Sessions where SessionID='"+textField_4.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Session Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
				
			refresh();
				
				
			}
		});
		btnNewButton_17.setBackground(Color.decode("#103778"));
		btnNewButton_17.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_17.setBounds(816, 125, 127, 39);
		panel_5.add(btnNewButton_17);
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 272, 142, 36);
		panel_5.add(lblNewLabel_2);
		
		 comboBoxLec1 = new JComboBox();
		 comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1.setBackground(Color.WHITE);
		comboBoxLec1.setBounds(172, 272, 168, 36);
		panel_5.add(comboBoxLec1);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2\r\n");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 318, 142, 36);
		panel_5.add(lblNewLabel_3);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(172, 330, 168, 36);
		panel_5.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 381, 160, 36);
		panel_5.add(lblNewLabel_4);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(172, 383, 168, 36);
		panel_5.add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(10, 427, 160, 36);
		panel_5.add(lblNewLabel_5);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(172, 437, 168, 36);
		panel_5.add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(372, 269, 160, 43);
		panel_5.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(520, 272, 142, 36);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_8 = new JLabel("Duration(Hours)");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_8.setBounds(372, 327, 138, 43);
		panel_5.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBounds(372, 382, 142, 35);
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_9.setBounds(372, 436, 127, 39);
		panel_5.add(lblNewLabel_9);
		
		 
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(704, 276, 142, 29);
		panel_5.add(lblNewLabel_11);
		
		 comboBoxLec1_1 = new JComboBox();
		 comboBoxLec1_1.setModel(new DefaultComboBoxModel(new String[] {"----------Select Lecturer-------"}));
		 comboBoxLec1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1_1.setBackground(Color.WHITE);
		comboBoxLec1_1.setBounds(10, 10, 299, 39);
		panel_5.add(comboBoxLec1_1);
		
		 comboBoxLec1_3 = new JComboBox();
		 comboBoxLec1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		 comboBoxLec1_3.setBackground(Color.WHITE);
		comboBoxLec1_3.setBounds(839, 272, 168, 36);
		panel_5.add(comboBoxLec1_3);
		
		JLabel lblNewLabel_11_1 = new JLabel("SessionID");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(704, 385, 142, 29);
		panel_5.add(lblNewLabel_11_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(706, 428, 301, 36);
		panel_5.add(textField);
		
		JLabel lblNewLabel_11_2 = new JLabel("Subject Code");
		lblNewLabel_11_2.setForeground(Color.WHITE);
		lblNewLabel_11_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_2.setBounds(704, 337, 142, 29);
		panel_5.add(lblNewLabel_11_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(839, 331, 168, 36);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_3.setEditable(false);
		textField_3.setBounds(520, 333, 142, 32);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_17_1 = new JButton("Generate SessionID");
		btnNewButton_17_1.setForeground(Color.WHITE);
		btnNewButton_17_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		});
		btnNewButton_17_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_17_1.setBackground(Color.BLACK);
		btnNewButton_17_1.setBounds(758, 212, 218, 39);
		panel_5.add(btnNewButton_17_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("No");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(10, 213, 35, 36);
		panel_5.add(lblNewLabel_2_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(172, 213, 97, 36);
		panel_5.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("MANAGE SESSIONS");
		lblNewLabel_1.setBounds(491, 30, 589, 47);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel_1.setBackground(Color.decode("#4660BD"));
		
		JButton btnNewButton_11 = new JButton("Add Sessions");
		btnNewButton_11.setBounds(275, 105, 266, 56);
		frame.getContentPane().add(btnNewButton_11);
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
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.setBounds(941, 104, 266, 58);
		frame.getContentPane().add(btnNewButton_12);
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refresh();
	            
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.decode("#554B82"));
		
		comboBoxLec1_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		try {
					String subject = comboBoxLec1_3.getSelectedItem().toString();
					Connection con = DBConnection.connect();
					String query = "select SubjectCode from SUbjects where SubjectName = '" + subject + "'";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					//select SubjectCode from SUbjects where SubjectName='"+subname+"'
					while (rs.next()) {

						String name = rs.getString("SubjectCode");
						textField_2.setText(name);
						
					}
					con.close();
				} catch (Exception e) {
					
				}
		 	}
		 });
	
		
		comboBoxLec1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		comboBox_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		
		comboBoxLec1_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		comboBox_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
	
		comboBox_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {	
		 		
		 		String Lec1Name=(String)comboBoxLec1.getSelectedItem();
				//String SubCode=(String)comboBox_1_1_1.getSelectedItem();
				String SubName=(String)comboBoxLec1_3.getSelectedItem();
				String tag=(String)comboBox_2.getSelectedItem();
				String groupID=(String)comboBox_3.getSelectedItem();
				String studentCount=textField_1.getText().toString();
				String duration=textField_3.getText().toString();
				
				
				
			
				
				String sessionID=Lec1Name+"."+SubName+"."+tag+"."+groupID+"."+studentCount+"."+duration;
				textField.setText(sessionID);
				
			}
		 });
		
	
		
		
		
		fillcombobox();
		fillcombobox1();
		fillcombobox2();
		viewgroupID();
		viewTag();
		viewTags();
		fillsubjectName();
		
	}

}
