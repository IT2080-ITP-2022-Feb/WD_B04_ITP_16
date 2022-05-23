package Student;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;

//import java.sql.*;
//import javax.swing.*;

import subjectManagement.AddSubjects;
import connection.DBConnection;
import home.DashBoard;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ScrollPaneConstants;


public class ManageStudentGroups {

	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	static int no;
	static int noid;
	private JTextField GroupId;
	private JTextField textField_1;
	private JComboBox Programme;
	private JSpinner GroupNo;
	private JSpinner SubGroupNo;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentGroups window = new ManageStudentGroups();
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
	public ManageStudentGroups() {
		initialize();
		Refresh();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
/*public void setID() {
		
        try{
            String sql = "select no from StudentGroups";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                 no = rs.getInt("no");
                 
                
                noid = no+1;
               
            }else{
            	noid = 0;
            }
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                pst.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
		
	}*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1550, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.setTitle("Time Table Management System");
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setBounds(253, 177, 1205, 526);
		frame.getContentPane().add(panel_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				try {
					if(GroupId.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A STUDENT");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from StudentGroups where GroupID='"+GroupId.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					Refresh();
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
				
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnDelete.setBackground(new Color(51, 51, 153));
		btnDelete.setBounds(949, 358, 235, 40);
		panel_3.add(btnDelete);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 1117, 230);
		panel_3.add(scrollPane);
		
		table_1= new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
               // textField.setText(table_1.getValueAt(selectedRow, 0).toString());
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField_2.setText(table_1.getValueAt(selectedRow, 1).toString());
                //textField_1.setText(StudentTable.getValueAt(selectedRow,0).toString());
                
                String Progra=table_1.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) Programme.getSelectedItem();
                	Programme.setSelectedItem(Progra);
               
                	
                	SubGroupNo.setValue((Integer)table_1.getValueAt(selectedRow, 4));
                	GroupNo.setValue((Integer)table_1.getValueAt(selectedRow, 3));
                	GroupId.setText(table_1.getValueAt(selectedRow, 5).toString());
                	textField_1.setText(table_1.getValueAt(selectedRow, 6).toString());
         
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Academic Year Semester", "Program", "Group No", "Sub Group No", "Group ID", "Sub Group ID"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		/*
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			private JLabel GroupID;
			private JLabel SubGroupID;

			public void actionPerformed(ActionEvent e) {
				
				if(AcademicYearSem.getSelectedItem().hashCode() ==0 || Programme.getSelectedItem().hashCode() == 0 || GroupNo.getValue().hashCode() == 0 || SubGroupNo.getValue().hashCode() ==0    ) {
					
					
					JLabel label = new JLabel("Please fill all fileds!");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					
				}	
			
				else{	
					
						GroupID.setText(AcademicYearSem.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString());
				
						SubGroupID.setText(AcademicYearSem.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
					
				}		
				/*
				try {
					if(AcademicYearSem.getSelectedItem().equals("")||Programme.getSelectedItem().equals("")||GroupNo.getText().equals("")||SubGroupNo.getSelectedItem().equals("")||subgroup.getSelectedItem().equals("")||groupid.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form");
					}else if(faculty.getSelectedItem().toString().equals("Computing") && programme.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					}else if(faculty.getSelectedItem().toString().equals("Computing")&&programme.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					}else if(faculty.getSelectedItem().toString().equals("Computing")&& programme.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					}else if(faculty.getSelectedItem().toString().equals("Engineering") && programme.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					}else if(faculty.getSelectedItem().toString().equals("Engineering") && programme.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					}else if(faculty.getSelectedItem().toString().equals("Engineering") && programme.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and programme are mismatch");
					
					
					
					
				}
					else {
					Connection con = DBConnection.connect();
					
					String query="',faculty1='"+faculty.getSelectedItem().toString()+"',programme1='"+programme.getSelectedItem().toString()+"',acayear='"+acayear.getText().toString()+"',group1='"+group.getSelectedItem().toString()+"',subgroup1='"+subgroup.getSelectedItem().toString()+"',groupid1='"+groupid.getText()+"' where Stud_ID='"+studentid.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					Refresh();
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnUpdate.setBackground(new Color(51, 51, 153));
		btnUpdate.setBounds(949, 294, 235, 40);
		panel_3.add(btnUpdate);*/
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(949, 429, 235, 40);
		panel_3.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentGroups addstudent=new AddStudentGroups();
				addstudent.main(null);
				frame.setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(new Color(51, 51, 153));
		
		JLabel lblNewLabel_1 = new JLabel("Academic Year Semester");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(24, 265, 230, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Programme");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(24, 325, 230, 41);
		panel_3.add(lblNewLabel_2);
		
		Programme = new JComboBox();
		Programme.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "CSNE", "IM", "ISE"}));
		Programme.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Programme.setBackground(Color.WHITE);
		Programme.setBounds(243, 325, 220, 41);
		panel_3.add(Programme);
		
		JLabel lblNewLabel_3 = new JLabel("Group No");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(24, 389, 230, 41);
		panel_3.add(lblNewLabel_3);
		
		GroupNo = new JSpinner();
		GroupNo.setModel(new SpinnerNumberModel(1, 1, 15, 1));
		GroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupNo.setBounds(243, 390, 220, 38);
		panel_3.add(GroupNo);
		
		JLabel lblNewLabel_4 = new JLabel("Sub Group No");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(24, 443, 230, 41);
		panel_3.add(lblNewLabel_4);
		
		SubGroupNo = new JSpinner();
		SubGroupNo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		SubGroupNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SubGroupNo.setBounds(243, 454, 220, 38);
		panel_3.add(SubGroupNo);
		
		JLabel lblNewLabel_5 = new JLabel("Group ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(506, 294, 230, 33);
		panel_3.add(lblNewLabel_5);
		
		GroupId = new JTextField();
		GroupId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupId.setColumns(10);
		GroupId.setBackground(Color.WHITE);
		GroupId.setBounds(676, 289, 220, 41);
		panel_3.add(GroupId);
		
		JLabel lblNewLabel_6 = new JLabel("Sub Group ID");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(506, 358, 230, 41);
		panel_3.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(676, 357, 220, 41);
		panel_3.add(textField_1);
		
		/*JButton btnNewButton_13 = new JButton("Generate");
		btnNewButton_13.addActionListener(new ActionListener() {
			private JLabel GroupID;
			private JLabel SubGroupID;

			public void actionPerformed(ActionEvent e) {
				
				
				if(textField_1.getSelectedItem().hashCode() ==0 || Programme.getSelectedItem().hashCode() == 0 || GroupNo.getValue().hashCode() == 0 || SubGroupNo.getValue().hashCode() ==0    ) {
					
					
					JLabel label = new JLabel("Please fill all fileds!");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					
				}	
			
				else{	
					
						GroupID.setText(textField_1.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString());
				
						SubGroupID.setText(textField_1.getSelectedItem().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
					
				}
			}
		});
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_13.setBackground(Color.DARK_GRAY);
		btnNewButton_13.setBounds(716, 443, 148, 41);
		panel_3.add(btnNewButton_13);*/
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(243, 265, 220, 41);
		panel_3.add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String generate;
			
				
				String a=textField_2.getText().toString();
				String b=Programme.getSelectedItem().toString();
				String c=GroupId.getText().toString();
				String d=textField_1.getText().toString();
				String o=GroupNo.getValue().toString();
				String f=SubGroupNo.getValue().toString();
				
				generate=""+a+"."+b+"."+o+"."+f;
				
				try {
					
					
					if(textField_2.getText().equals("") ||Programme.getSelectedItem().equals("")||GroupNo.getValue().equals("")||SubGroupNo.getValue().equals("")||GroupId.getText().equals("")||textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate group Id and subgroup Id ");
						
						 
							
						
					}else if(!(generate.equals(textField_1.getText().toString()))) {
						
						
						
						JOptionPane.showMessageDialog(null, "Data mismatch");
					
					
					
					
				}else{
						Connection connec = DBConnection.connect();
					
							
							
							String subID=textField_1.getText();
							String AcademicYearSe=textField_2.getText().toString();
							String programme=Programme.getSelectedItem().toString();
							
							String ggroupID=GroupId.getText();
							String groupID=GroupNo.getValue().toString();
							String subgroupID=SubGroupNo.getValue().toString();
				               

							String msg = "" + ggroupID;
			                msg += "";
			                
			             
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO StudentGroups values(null,'" + AcademicYearSe + "','" + programme + "','" + groupID + "','" +
		                    		subgroupID + "','" + ggroupID + "','" + subID + "')";

		                    java.sql.Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                 
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "" + msg + "' is sucessfully added to the system ");
		                 
		                    
		                    con.close();
		                    textField_1.setText(null);
		                    textField_2.setText(null);
		    				Programme.setSelectedItem(null);
		    				
		    				GroupId.setText(null);
		    				GroupNo.setValue(null);
		    				SubGroupNo.setValue(null);
		    				
					}
					}
					
					
				catch(Exception w){
			
				
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
				
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnUpdate.setBackground(new Color(51, 51, 153));
		btnUpdate.setBounds(949, 282, 235, 40);
		panel_3.add(btnUpdate);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setForeground(Color.WHITE);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		if(textField_2.getText().hashCode() ==0 || Programme.getSelectedItem().hashCode() == 0 || GroupNo.getValue().hashCode() == 0 || SubGroupNo.getValue().hashCode() ==0    ) {
			
			
			JLabel label = new JLabel("Please fill all fileds!");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			JOptionPane.showMessageDialog(null, label);
			
		}	
	
		else{	
			
				GroupId.setText(textField_2.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString());
		
				textField_1.setText(textField_2.getText().toString()+"."+Programme.getSelectedItem().toString()+"."+ GroupNo.getValue().toString()+"."+SubGroupNo.getValue().toString());
			
		}		
				
		}

		});
		
		
		btnGenerate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnGenerate.setBackground(new Color(51, 51, 153));
		btnGenerate.setBounds(692, 429, 193, 40);
		panel_3.add(btnGenerate);
		
		
		JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
		TimetableBtn.setForeground(Color.BLACK);
		TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TimetableBtn.setBackground(new Color(255, 122, 72));
		TimetableBtn.setBounds(10, 10, 233, 72);
		frame.getContentPane().add(TimetableBtn);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(1192, 109, 266, 58);
		frame.getContentPane().add(btnClear);
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GroupId.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				Programme.setSelectedItem(null);
				GroupNo.setValue(null);
				SubGroupNo.setValue(null);
				
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnClear.setBackground(new Color(0, 204, 204));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(259, 109, 211, 58);
		frame.getContentPane().add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Refresh();
				
				/*
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from Student ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
			*/	
			}
		});
		btnRefresh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRefresh.setBackground(new Color(0, 204, 204));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 254, 254));
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 254, 254));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(255, 254, 254));
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(new Color(255, 254, 254));
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(new Color(255, 254, 254));
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(new Color(255, 254, 254));
		btnNewButton_5.setBounds(10, 250, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(new Color(255, 254, 254));
		btnNewButton_6.setBounds(10, 298, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(new Color(255, 254, 254));
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(new Color(255, 254, 254));
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(new Color(255, 254, 254));
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(new Color(255, 254, 254));
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(new Color(255, 254, 254));
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
	}
	
	public void Refresh() {
		
		Connection conn = DBConnection.connect();
		
		
        try {
        	String sql="Select * from StudentGroups ";
			pst=conn.prepareStatement(sql);
			
			rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

