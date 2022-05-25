package Locations_Management;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import Tags.AddTags;

import home.DashBoard;
import net.proteanit.sql.DbUtils;
import javax.swing.BorderFactory;

public class ManageLocations {

	private JFrame frame;
	

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private JTable table;
	private JTable table_1;

	private JComboBox comboBoxRoomType;
	private JTextField textField_3;

	/**
	 * sLaunch  the application.sss
	 * 
	 * 
	 */
	
	PreparedStatement pst=null;
	ResultSet rs = null;
	private JTextField textField_4;
	private JTextField txtManageLocations;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocations window = new ManageLocations();
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
	public ManageLocations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashBoard welcome=new DashBoard();
				welcome.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1= new JButton("Lecturers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lecturerManagement.AddingLecturers addinglectures=new lecturerManagement.AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 65, 213, 38);
		panel_1.add(btnNewButton_1); 
		
		JButton btnNewButton_2 = new JButton("Students");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(10, 124, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3= new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(10, 181, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(10, 235, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(10, 289, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLocations addlocations=new AddLocations();
				addlocations.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(10, 344, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTags addtags=new AddTags();
				addtags.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(10, 400, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(10, 448, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(10, 512, 213, 38);
		panel_1.add(btnNewButton_9);
	
		
		JButton btnNewButton_10 = new JButton("Statistics");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(10, 567, 213, 38);
		panel_1.add(btnNewButton_10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(65, 105, 225));
		panel_3.setLayout(null);
		panel_3.setBounds(253, 177, 973, 526);
		frame.getContentPane().add(panel_3);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////
				
				try {
					if(textField_4.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||comboBoxRoomType.getSelectedItem().equals("")||textField_3.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form and check the details");
					}else {
					Connection con = connection.DBConnection.connect();
					
					String query="Update Locations set RoomName='"+textField_2.getText()+"',BuildingName='"+textField_1.getText()+"' ,RoomType='"+comboBoxRoomType.getSelectedItem().toString()+"',Capacity='"+textField_3.getText()+"'  where LID='"+textField_4.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
				//////////////////
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_13.setBackground(new Color(0, 0, 128));
		btnNewButton_13.setBounds(820, 13, 143, 50);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_4.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				comboBoxRoomType.setSelectedItem(null);
				textField_3.setText(null);
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_14.setBackground(new Color(0, 0, 128));
		btnNewButton_14.setBounds(820, 106, 143, 50);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Delete");
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				try {
					if(textField_4.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A Building Name");
					}else {
					
						Connection con = connection.DBConnection.connect();
						
					
					String query="Delete from Locations where LID='"+textField_4.getText()+"'";
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
		btnNewButton_15.setBackground(new Color(0, 0, 128));
		btnNewButton_15.setBounds(820, 193, 143, 50);
		panel_3.add(btnNewButton_15);
		
		JLabel lblNewLabel_1 = new JLabel("Building Name");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 304, 444, 29);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(182, 301, 348, 29);
		panel_3.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Name ");
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 343, 487, 29);
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(182, 343, 348, 29);
		panel_3.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("Room Type");
		lblNewLabel_6.setForeground(new Color(240, 248, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_6.setBounds(540, 301, 386, 32);
		panel_3.add(lblNewLabel_6);
		
		comboBoxRoomType = new JComboBox();
		comboBoxRoomType.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		comboBoxRoomType.setBackground(Color.WHITE);
		comboBoxRoomType.setBounds(712, 303, 235, 30);
		panel_3.add(comboBoxRoomType);
		
		JLabel lblNewLabel_7 = new JLabel("Capacity");
		lblNewLabel_7.setForeground(new Color(240, 248, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_7.setBounds(540, 343, 396, 33);
		panel_3.add(lblNewLabel_7);
		
		textField_3= new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(712, 345, 235, 31);
		panel_3.add(textField_3);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 800, 249);
		panel_3.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(Color.WHITE);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=table_1.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                
                textField_4.setText(table_1.getValueAt(selectedRow, 0).toString());
                textField_1.setText(table_1.getValueAt(selectedRow,1).toString());
                textField_2.setText(table_1.getValueAt(selectedRow,2).toString());
                
                
                String RoomType=table_1.getValueAt(selectedRow, 3).toString();
                	String getRoomType=(String) comboBoxRoomType.getSelectedItem();
                	comboBoxRoomType.setSelectedItem(RoomType);
                	
                    textField_3.setText(table_1.getValueAt(selectedRow,4).toString());
                    
                 	
                	
                
                	
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				
			},
			new String[] {
				"LID", "Building", "Room", "RoomType","Capacity"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(10, 263, 1, -1);
		panel_3.add(textField_4);
		
		JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
		TimetableBtn.setForeground(Color.BLACK);
		TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TimetableBtn.setBackground(new Color(255, 122, 72));
		TimetableBtn.setBounds(10, 10, 233, 72);
		frame.getContentPane().add(TimetableBtn);
		
			
				JButton btnNewButton_11 = new JButton("Add Locations");
				btnNewButton_11.setBounds(271, 111, 190, 56);
				frame.getContentPane().add(btnNewButton_11);
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddLocations addlocations=new AddLocations();
						addlocations.main(null);
						frame.setVisible(false);
					}
				});
				btnNewButton_11.setForeground(new Color(255, 255, 255));
				btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
				btnNewButton_11.setBackground(new Color(0, 0, 128));
				
						JButton btnNewButton_12 = new JButton("Refresh");
						btnNewButton_12.setForeground(new Color(255, 255, 255));
						btnNewButton_12.setBounds(1018, 111, 190, 56);
						frame.getContentPane().add(btnNewButton_12);
						btnNewButton_12.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								
								
								Connection conn = connection.DBConnection.connect();
								
								
	            try {
	            	String sql="Select * from Locations ";
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
						btnNewButton_12.setBackground(new Color(75, 0, 130));
						
						txtManageLocations = new JTextField();
						txtManageLocations.setText("MANAGE LOCATIONS");
						txtManageLocations.setHorizontalAlignment(SwingConstants.CENTER);
						txtManageLocations.setForeground(Color.WHITE);
						txtManageLocations.setFont(new Font("Tahoma", Font.BOLD, 65));
						txtManageLocations.setColumns(10);
						txtManageLocations.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
						txtManageLocations.setBackground(new Color(70, 96, 189));
						txtManageLocations.setBounds(333, 29, 725, 72);
						frame.getContentPane().add(txtManageLocations);
		
		
	}
}
