package StudentGroups;
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


public class ManageStudentGroups {

	private JFrame frame;
	private JTextField studentid;
	private JTextField groupid;
	private JTextField acayear;
	private JTable table;
	private JTable table_1;

	private JComboBox faculty,programme,group,subgroup;
	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	//DefaultTableModel model = new DefaultTableModel();
	
	/*Connection conn = null;
	
	public void updateTable(){
		conn = SqliteConnection.ConnectDb();
		if(conn !=null)
		{
			String sql="Select StudentID, Faculty, Programme, AcademicYearSemester, Group, SubGroup, GroupID";
			try
			{
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[7];
				
				while (rs.next()) {
					columnData[0] = rs.getString("StudentID");
					columnData[1] = rs.getString("Faculty");
					columnData[2] = rs.getString("Programme");
					columnData[3] = rs.getString("AcademicYearSemester");
					columnData[4] = rs.getString("StudentID");
					columnData[5] = rs.getString("StudentID");
					columnData[6] = rs.getString("StudentID");
					model.addRow(columnData);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}*/
	
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
		/*conn= SqliteConnection.ConnectDb();
		
		Object col[] = {"StudentID","Faculty","Programme","AcademicYearSemester","Group","SubGroup","GroupID"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
		
		updateTable();*/
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1550, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.setTitle("Time Table Management System");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.decode("#FFFEFE"));
		btnNewButton.setBounds(10, 47, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Working days/Hours");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*AddingLecturers addinglectures=new AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);*/

			}
		});
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_1.setBounds(10, 95, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Lecturers");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_2.setBounds(10, 143, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentGroups addingstudent=new AddStudentGroups();
				addingstudent.main(null);
				frame.setVisible(false);
				
			}
		});
		
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(10, 191, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Subjects");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_4.setBounds(10, 239, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Tags");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_5.setBounds(10, 287, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_6.setBounds(10, 335, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Session Types");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_7.setBounds(10, 383, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Rooms");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_8_1.setBounds(10, 431, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_9.setBounds(10, 479, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			

			}
		});
		
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_10_1.setBounds(10, 527, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.decode("#4660BD"));
		panel_3.setBounds(253, 177, 1277, 526);
		frame.getContentPane().add(panel_3);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				try {
					if(studentid.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A STUDENT");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from student where Stud_ID='"+studentid.getText()+"'";
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
		
		/*JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(Color.decode("#FA1B1B"));
		lblNewLabel_1.setBounds(24, 290, 132, 29);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(153, 292, 228, 29);
		panel_3.add(textField);*/
		
		JLabel lblStuID = new JLabel("Student ID");
		lblStuID.setForeground(new Color(255, 255, 255));
		lblStuID.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblStuID.setBounds(24, 276, 117, 29);
		panel_3.add(lblStuID);
		
		studentid = new JTextField();
		studentid.setEditable(false);
		studentid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		studentid.setColumns(10);
		studentid.setBackground(new Color(255, 255, 255));
		studentid.setBounds(153, 275, 228, 29);
		panel_3.add(studentid);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setForeground(new Color(255, 255, 255));
		lblFaculty.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFaculty.setBounds(24, 331, 117, 29);
		panel_3.add(lblFaculty);
		
	    faculty = new JComboBox();
	    faculty.setFont(new Font("Times New Roman", Font.BOLD, 20));
		faculty.setModel(new DefaultComboBoxModel(new String[] {"", "Engineering", "Computing"}));
		faculty.setBackground(new Color(255, 255, 255));
		faculty.setBounds(153, 331, 228, 29);
		panel_3.add(faculty);
		
		JLabel lblProgramme = new JLabel("Programme");
		lblProgramme.setForeground(new Color(255, 255, 255));
		lblProgramme.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblProgramme.setBounds(24, 382, 117, 31);
		panel_3.add(lblProgramme);
		
		programme = new JComboBox();
		programme.setFont(new Font("Times New Roman", Font.BOLD, 20));
		programme.setModel(new DefaultComboBoxModel(new String[] {"", "SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		programme.setBackground(new Color(255, 255, 255));
		programme.setBounds(153, 382, 228, 31);
		panel_3.add(programme);
		
		JLabel lblAcademic = new JLabel("Academic year semester");
		lblAcademic.setForeground(new Color(255, 255, 255));
		lblAcademic.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAcademic.setBounds(24, 438, 209, 29);
		panel_3.add(lblAcademic);
		
		groupid = new JTextField();
		groupid.setEditable(false);
		groupid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		groupid.setColumns(10);
		groupid.setBackground(new Color(255, 255, 255));
		groupid.setBounds(584, 382, 235, 29);
		panel_3.add(groupid);
		
		JLabel lblGroup = new JLabel("Group");
		lblGroup.setForeground(new Color(255, 255, 255));
		lblGroup.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblGroup.setBounds(488, 276, 86, 28);
		panel_3.add(lblGroup);
		
		group = new JComboBox();
		group.setFont(new Font("Times New Roman", Font.BOLD, 20));
		group.setModel(new DefaultComboBoxModel(new String[] {"", "Weekday", "Weekend"}));
		group.setBackground(new Color(255, 255, 255));
		group.setBounds(584, 276, 235, 28);
		panel_3.add(group);
		
		JLabel lblSubGroup = new JLabel("SubGroup");
		lblSubGroup.setForeground(new Color(255, 255, 255));
		lblSubGroup.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblSubGroup.setBounds(488, 331, 86, 29);
		panel_3.add(lblSubGroup);
		
		subgroup = new JComboBox();
		subgroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		subgroup.setModel(new DefaultComboBoxModel(new String[] {"", "G1", "G2", "G3"}));
		subgroup.setBackground(new Color(255, 255, 255));
		subgroup.setBounds(584, 330, 235, 30);
		panel_3.add(subgroup);
		
		JLabel lblGroupID = new JLabel("GroupID");
		lblGroupID.setForeground(new Color(255, 255, 255));
		lblGroupID.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblGroupID.setBounds(488, 383, 86, 29);
		panel_3.add(lblGroupID);
		
		acayear = new JTextField();
		acayear.setEditable(false);
		acayear.setFont(new Font("Times New Roman", Font.BOLD, 20));
		acayear.setColumns(10);
		acayear.setBackground(new Color(255, 255, 255));
		acayear.setBounds(243, 437, 138, 29);
		panel_3.add(acayear);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1257, 233);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                studentid.setText(table_1.getValueAt(selectedRow, 1).toString());
                groupid.setText(table_1.getValueAt(selectedRow,0).toString());
                acayear.setText(table_1.getValueAt(selectedRow,0).toString());
                
                String facultyvalue=table_1.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) faculty.getSelectedItem();
                	faculty.setSelectedItem(facultyvalue);
                	
                String programmeName=table_1.getValueAt(selectedRow, 4).toString();
                	String getProgramme=(String)programme.getSelectedItem();
                	programme.setSelectedItem(programmeName);
                	
                String groupName=table_1.getValueAt(selectedRow, 5).toString();
                	String GetGroup=(String)group.getSelectedItem();
                	group.setSelectedItem(groupName);
                
                String subGroupName=table_1.getValueAt(selectedRow, 6).toString();
                	String GetSubGroup=(String)subgroup.getSelectedItem();
                	subgroup.setSelectedItem(subGroupName);
                	
                	
                
                	//comboBoxCenterInput
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"StudentID", "Faculty", "Programme", "Academic Year  Semester ", "Group", "GroupID", "SubGroup"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(83);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(96);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(91);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(132);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(56);
		scrollPane.setViewportView(table_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*updateactivehours changeactivehours=new updateactivehours();
				changeactivehours.main(null);*/
				
				try {
					if(studentid.getText().equals("")||faculty.getSelectedItem().equals("")||programme.getSelectedItem().equals("")||acayear.getText().equals("")||group.getSelectedItem().equals("")||subgroup.getSelectedItem().equals("")||groupid.getText().equals("")){
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
					
					String query="Update studentid='"+studentid.getText()+"',faculty1='"+faculty.getSelectedItem().toString()+"',programme1='"+programme.getSelectedItem().toString()+"',acayear='"+acayear.getText().toString()+"',group1='"+group.getSelectedItem().toString()+"',subgroup1='"+subgroup.getSelectedItem().toString()+"',groupid1='"+groupid.getText()+"' where Stud_ID='"+studentid.getText()+"' ";
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
		btnUpdate.setBounds(949, 290, 235, 40);
		panel_3.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(949, 427, 235, 40);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#4660BD"));
		panel_2.setBounds(259, 10, 1277, 76);
		frame.getContentPane().add(panel_2);
		
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
				
				studentid.setText(null);
				faculty.setSelectedItem(null);
				programme.setSelectedItem(null);
				groupid.setText(null);
				group.setSelectedItem(null);
				subgroup.setSelectedItem(null);
				acayear.setText(null);
				
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
	}
	
	public void Refresh() {
		
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
	}
}

