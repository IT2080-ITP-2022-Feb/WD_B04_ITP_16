package Locations_Management;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Tags.AddTags;
import home.DashBoard;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
public class AddLocations {

	private JFrame frame;

	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	
	private JTextField BuildingName;
	private JTextField RoomName;
	private JTextField Capacity;
	private JTextField txtAddLocations;
	/**
	 * Launch the afcpzaxplication.ss
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocations window = new AddLocations();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application fcfxfc.
	 */
	public AddLocations() {
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
				lecturerManagement.AddingLecturers addlecturers=new lecturerManagement.AddingLecturers();
				addlecturers.main(null);
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
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_8.setBounds(10, 456, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(10, 518, 213, 38);
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
		panel_3.setBounds(253, 174, 973, 529);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Building Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 10, 148, 41);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBackground(new Color(148, 0, 211));
		lblNewLabel_2.setBounds(10, 90, 148, 41);
		panel_3.add(lblNewLabel_2);
	
		JLabel lblNewLabel_3 = new JLabel("Room Type");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_3.setBounds(10, 168, 148, 41);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Capacity");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_4.setBounds(10, 248, 148, 41);
		panel_3.add(lblNewLabel_4);
		
		
		JTextField BuildingName = new JTextField();
		BuildingName.setBackground(Color.WHITE);
		BuildingName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		BuildingName.setBounds(145, 12, 730, 41);
		panel_3.add(BuildingName);
		BuildingName.setColumns(10);
		
		JTextField RoomName = new JTextField();
		RoomName.setBackground(Color.WHITE);
		RoomName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		RoomName.setBounds(145, 90, 730, 41);
		panel_3.add(RoomName);
		RoomName.setColumns(10);
	
		JComboBox RoomType = new JComboBox();
		RoomType.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		RoomType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		RoomType.setBackground(Color.WHITE);
		RoomType.setBounds(145, 168, 730, 41);
		panel_3.add(RoomType);
		
		JTextField Capacity = new JTextField();
		Capacity.setBackground(Color.WHITE);
		Capacity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Capacity.setBounds(145, 248, 730, 41);
		panel_3.add(Capacity);
		Capacity.setColumns(10);
		
		

		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BuildingName.setText(null);
				RoomName.setText(null);
				RoomType.setSelectedItem(null);
				Capacity.setText(null);
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(new Color(0, 0, 128));
		btnNewButton_14.setBounds(435, 452, 157, 41);
		panel_3.add(btnNewButton_14);
		
		
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
					
					
					
					
				
				try {
					
					
					if(BuildingName.getText().equals("") ||RoomName.getText().equals("")||RoomType.getSelectedItem().equals("")||Capacity.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and then save it");
						
						 
							
						
					}else if(!(Capacity.getText().trim().matches("^[0-9]{3}"))){
						JOptionPane.showMessageDialog(null, "Invalid capacity amount");
					
					}else{
						
						Connection connec = connection.DBConnection.connect();
						
			
							
							
							String BName=BuildingName.getText();
							String RName=RoomName.getText();
							String RType=RoomType.getSelectedItem().toString();
							String capacity=Capacity.getText();
							
				               

							String msg = "" + BName;
			                msg += " \n";
			                
			             
							
							

		                	Connection con = connection.DBConnection.connect();

		                    String query = "INSERT INTO Locations values(null,'" + BName + "','" + RName + "','" + RType + "','" +
		                    		capacity + "')";

		                    java.sql.Statement sta = con.createStatement();
		                    int xx = sta.executeUpdate(query);
		                  
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Your , " + msg + "has succesfully inserted");
		                    
		                    con.close();
		                    BuildingName.setText(null);
							  RoomName.setText(null);
							  RoomType.setSelectedItem(null);
							  Capacity.setText(null);
		                    
		                   
		                
							
							
							
							
							
							
						
					}
					}
					
					
				catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
				}
				
				finally{
                    try{
                         Connection pst = null;
						pst.close();
                                Connection rs = null;
								rs.close();
                    }catch(Exception r){
                        
                    }
                }
			
					}
	              
				
				
					
			
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(new Color(0, 0, 128));
		btnNewButton_15.setBounds(713, 452, 157, 41);
		panel_3.add(btnNewButton_15);
		
		JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
		TimetableBtn.setForeground(Color.BLACK);
		TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		TimetableBtn.setBackground(new Color(255, 122, 72));
		TimetableBtn.setBounds(10, 10, 233, 72);
		frame.getContentPane().add(TimetableBtn);
		
		txtAddLocations =  new JTextField();
		txtAddLocations.setText("ADD LOCATIONS");
		txtAddLocations.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddLocations.setForeground(Color.WHITE);
		txtAddLocations.setFont(new Font("Tahoma", Font.BOLD, 65));
		txtAddLocations.setColumns(10);
		txtAddLocations.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
		txtAddLocations.setBackground(new Color(70, 96, 189));
		txtAddLocations.setBounds(292, 59, 656, 72);
		frame.getContentPane().add(txtAddLocations);
		
		JButton btnNewButton_12 = new JButton("Manage Location");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBounds(969, 89, 222, 52);
		frame.getContentPane().add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageLocations managelocations=new ManageLocations();
				managelocations.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(new Color(128, 0, 128));
	}
}
