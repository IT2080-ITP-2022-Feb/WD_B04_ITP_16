package StudentManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
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

import connection.DBConnection;
import lecturerManagement.AddingLecturers;
import lecturerManagement.updateactivehours;


public class ManageStudent {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;

	private JComboBox comboBoxFacultyName,comboBoxProgrammeName,comboBoxGroupName,comboBoxSubGroupName;
	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudent window = new ManageStudent();
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
	public ManageStudent() {
		initialize();
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
		panel_1.setBackground(Color.white);
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
				AddingStudent addingstudent=new AddingStudent();
				addingstudent.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
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
		panel_3.setBounds(253, 177, 1277, 526);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(textField_2.getText().equals("")||textField.getText().equals("")||textField_1.getText().equals("")||comboBoxFacultyName.getSelectedItem().equals("")||comboBoxProgrammeName.getSelectedItem().equals("")||comboBoxGroupName.getSelectedItem().equals("")||comboBoxSubGroupName.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing") && comboBoxProgrammeName.getSelectedItem().toString().equals("Electrical")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing")&& comboBoxProgrammeName.getSelectedItem().toString().equals("Civil")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Computing")&& comboBoxProgrammeName.getSelectedItem().toString().equals("Mechanical")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxProgrammeName.getSelectedItem().toString().equals("SE")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxProgrammeName.getSelectedItem().toString().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}else if(comboBoxFacultyName.getSelectedItem().toString().equals("Engineering") && comboBoxProgrammeName.getSelectedItem().toString().equals("DS")){
						JOptionPane.showMessageDialog(null, "Faculty and department are mismatch");
					}
					else {
						Connection con = DBConnection.connect();
			
						String query="Update Students set Faculty='"+comboBoxFacultyName.getSelectedItem().toString()+"',Programme='"+comboBoxProgrammeName.getSelectedItem().toString()+"',Group='"+comboBoxGroupName.getSelectedItem().toString()+"',SubGroup='"+comboBoxSubGroupName.getSelectedItem().toString()+"'GroupID='"+textField_2.getText()+"' where Stud_ID='"+textField_1.getText()+"' ";;
						PreparedStatement pst=con.prepareStatement(query);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Updated");
						pst.close();
						}
						
					}
					catch(Exception q) {
						q.printStackTrace();
					}
		
		
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_13.setBackground(Color.decode("#3EB482"));
		btnNewButton_13.setBounds(885, 303, 235, 40);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				comboBoxFacultyName.setSelectedItem(null);
				comboBoxProgrammeName.setSelectedItem(null);
				textField_1.setText(null);
				comboBoxGroupName.setSelectedItem(null);
				comboBoxSubGroupName.setSelectedItem(null);
				textField_2.setText(null);
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_14.setBackground(Color.decode("#0593A2"));
		btnNewButton_14.setBounds(885, 353, 235, 40);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Delete");
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				try {
					if(textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A STUDENT");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Student where Stud_ID='"+textField_1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
			
				
				
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_15.setBackground(new Color(255, 0, 0));
		btnNewButton_15.setBounds(885, 403, 235, 40);
		panel_3.add(btnNewButton_15);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBounds(24, 349, 152, 29);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(153, 348, 228, 29);
		panel_3.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(24, 397, 117, 29);
		panel_3.add(lblNewLabel_2);
		
	    comboBoxFacultyName = new JComboBox();
	    comboBoxFacultyName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxFacultyName.setModel(new DefaultComboBoxModel(new String[] {"Engineering", "Computing"}));
		comboBoxFacultyName.setBackground(new Color(255, 255, 255));
		comboBoxFacultyName.setBounds(153, 401, 228, 29);
		panel_3.add(comboBoxFacultyName);
		
		JLabel lblNewLabel_3 = new JLabel("Programme");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(24, 460, 152, 31);
		panel_3.add(lblNewLabel_3);
		
		comboBoxProgrammeName = new JComboBox();
		comboBoxProgrammeName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxProgrammeName.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Electrical", "Civil", "Mechanical"}));
		comboBoxProgrammeName.setBackground(new Color(255, 255, 255));
		comboBoxProgrammeName.setBounds(153, 462, 228, 31);
		panel_3.add(comboBoxProgrammeName);
		
		JLabel lblNewLabel_4 = new JLabel("Academic year semester");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(24, 349, 152, 29);
		panel_3.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setBounds(153, 348, 228, 29);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_5.setBounds(486, 290, 86, 28);
		panel_3.add(lblNewLabel_5);
		
		comboBoxGroupName = new JComboBox();
		comboBoxGroupName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxGroupName.setModel(new DefaultComboBoxModel(new String[] {"Weekday", "Weekend"}));
		comboBoxGroupName.setBackground(new Color(255, 255, 255));
		comboBoxGroupName.setBounds(584, 289, 235, 28);
		panel_3.add(comboBoxGroupName);
		
		JLabel lblNewLabel_6 = new JLabel("SubGroup");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(486, 394, 86, 29);
		panel_3.add(lblNewLabel_6);
		
		comboBoxSubGroupName = new JComboBox();
		comboBoxSubGroupName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		comboBoxSubGroupName.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBoxSubGroupName.setBackground(new Color(255, 255, 255));
		comboBoxSubGroupName.setBounds(584, 400, 235, 30);
		panel_3.add(comboBoxSubGroupName);
		
		JLabel lblNewLabel_7 = new JLabel("GroupID");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(486, 345, 65, 29);
		panel_3.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(153, 348, 228, 29);
		panel_3.add(textField_2);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1257, 233);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField.setText(table_1.getValueAt(selectedRow, 1).toString());
                textField_1.setText(table_1.getValueAt(selectedRow,0).toString());
                
                String facultyvalue=table_1.getValueAt(selectedRow, 2).toString();
                	String getFaculty=(String) comboBoxFacultyName.getSelectedItem();
                	comboBoxFacultyName.setSelectedItem(facultyvalue);
                	
                String programmeName=table_1.getValueAt(selectedRow, 4).toString();
                	String getProgramme=(String)comboBoxProgrammeName.getSelectedItem();
                	comboBoxProgrammeName.setSelectedItem(programmeName);
                	
                String groupName=table_1.getValueAt(selectedRow, 5).toString();
                	String GetGroup=(String)comboBoxGroupName.getSelectedItem();
                	comboBoxGroupName.setSelectedItem(groupName);
                
                String subGroupName=table_1.getValueAt(selectedRow, 6).toString();
                	String GetSubGroup=(String)comboBoxSubGroupName.getSelectedItem();
                	comboBoxSubGroupName.setSelectedItem(subGroupName);
                	
                	
                
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
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		
		JButton btnNewButton_15_1 = new JButton("Edit");
		btnNewButton_15_1.setForeground(Color.WHITE);
		btnNewButton_15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*updateactivehours changeactivehours=new updateactivehours();
				changeactivehours.main(null);*/
				
			}
		});
		btnNewButton_15_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_15_1.setBackground(new Color(255, 255, 0));
		btnNewButton_15_1.setBounds(885, 453, 235, 40);
		panel_3.add(btnNewButton_15_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#4660BD"));
		panel_2.setBounds(253, 88, 1277, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Add Student");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingStudent addstudent=new AddingStudent();
				addstudent.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.decode("#103778"));
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
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
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.decode("#FF7A48"));
		btnNewButton_12.setBounds(1001, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
		TimetableBtn.setForeground(Color.BLACK);
		TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TimetableBtn.setBackground(new Color(255, 122, 72));
		TimetableBtn.setBounds(10, 10, 233, 72);
		frame.getContentPane().add(TimetableBtn);
	}
}

