package timeTable;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.BorderFactory;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import connection.DBConnection;
import home.DashBoard;
import lecturerManagement.AddingLecturers;
import net.proteanit.sql.DbUtils;
import subjectManagement.AddSubjects;

public class LectureTimeTable {


	private JFrame frmAddStudentGroup;
	private JFrame frmAddStudentGroup_1;
	private JTextField txtLecturer;
	private JComboBox comboBox;	
	private JTable table;
	private JLabel dateTimes;
	private JTextField dateTime;
	
	public void currentDate() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		dateTime.setText(dtf.format(now));
	}
	
	  public void filllectureNames() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Lecturers";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("LecturerName");
					 comboBox.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	
	  
	  
	 
	  
	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select conSessionID AS SessionID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	  
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LectureTimeTable window = new LectureTimeTable();
					window.frmAddStudentGroup_1.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
 public LectureTimeTable() {
		
		// TODO Auto-generated constructor stub
	 initialize();
	 currentDate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddStudentGroup= new JFrame();
		frmAddStudentGroup.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from timeAlloLecture ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmAddStudentGroup_1 = new JFrame();
		frmAddStudentGroup_1.getContentPane().setBackground(Color.decode("#4660BD"));		
		frmAddStudentGroup_1.setBackground(Color.decode("#4660BD"));
		frmAddStudentGroup_1.setResizable(false);
		frmAddStudentGroup_1.setTitle("Time Table Management System");
		frmAddStudentGroup_1.setSize(1350, 728);
		frmAddStudentGroup_1.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frmAddStudentGroup_1.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup_1.setVisible(true);
		frmAddStudentGroup_1.getContentPane().setLayout(null);
			
		
				
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(255, 175, 1081, 487);
		panel_6.setLayout(null);
		panel_6.setBackground(Color.decode("#4660BD"));
		frmAddStudentGroup_1.getContentPane().add(panel_6);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 0, 1059, 499);
		panel_7.setBackground(Color.decode("#4660BD"));
		panel_6.add(panel_7);
		
	
		//generate button
		JButton btnNewButton_2 = new JButton("GENERATE");
		btnNewButton_2.setBounds(556, 10, 178, 43);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals(" ") || comboBox.getSelectedItem().toString().equals("-----------------Please Select Lecturer Name-----------------"))
				{
					
					JOptionPane.showMessageDialog(null, "   Please Select Lecturer Name","Failed",JOptionPane.WARNING_MESSAGE);
				}
				else {
				try {
					
					Connection con = DBConnection.connect();
					
					String query="select Date As Day,startTime || ' ' || start AS StartTime,endTime || ' ' || end AS EndTime,sessionSign from notavailableTime where selectLec='"+comboBox.getSelectedItem()+"' order by Date,StartTime,EndTime";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(5);
					columnModel.getColumn(1).setPreferredWidth(5);
					columnModel.getColumn(2).setPreferredWidth(5);
					columnModel.getColumn(3).setPreferredWidth(600);
					
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		});
		panel_7.setLayout(null);
		
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_2.setBackground(Color.decode("#0593A2"));
		panel_7.add(btnNewButton_2);
		
		
		
		//print button
		JButton btnNewButton_3 = new JButton("PRINT");
		btnNewButton_3.setBounds(748, 10, 157, 43);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header = new MessageFormat("Lecturer TimeTable - "+ comboBox.getSelectedItem().toString());
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");  
			    String strDate= formatter.format(date);  
				MessageFormat footer = new MessageFormat("Timetable generated on:" +strDate);
				
				try {
					
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
					
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "       Unable to print","Alert",JOptionPane.WARNING_MESSAGE);
					
				}
			
			}
		});
		
	
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_3.setBackground(Color.decode("#0593A2"));
		panel_7.add(btnNewButton_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-----------------Please Select Lecturer Name-----------------"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(144, 13, 378, 38);
		panel_7.add(comboBox);
		
		filllectureNames();
		
		JLabel lblNewLabel = new JLabel("Lecturer :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(12, 16, 150, 28);
		panel_7.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 1035, 368);
		//frmAddStudentGroup.getContentPane().add(scrollPane);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(90);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		panel_1.setBounds(10, 88, 233, 584);
		frmAddStudentGroup_1.getContentPane().add(panel_1);
		
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

				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_21 = new JButton("Student Groups");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_21.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_21.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_21.setBounds(10, 106, 213, 38);//coom
		panel_1.add(btnNewButton_21);
		
		JButton btnNewButton_31 = new JButton("Subjects");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			;
			}
		});
		btnNewButton_31.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_31.setBackground(Color.decode("#FFFEFE"));
		btnNewButton_31.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_31);
		
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
		panel_2.setBounds(255, 89, 1081, 76);
		frmAddStudentGroup_1.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Lecturer Time Table");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Location Time Table");
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBounds(793, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JButton btnNewButton_12_1 = new JButton("Student Time Table");
		btnNewButton_12_1.setBackground(Color.WHITE);
		btnNewButton_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_12_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12_1.setBounds(392, 9, 266, 58);
		panel_2.add(btnNewButton_12_1);
		
		JButton btnTimetableGenerator = new JButton("TIMETABLE GENERATOR");
		btnTimetableGenerator.setForeground(Color.BLACK);
		btnTimetableGenerator.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimetableGenerator.setBackground(Color.decode("#FF7A48"));
		btnTimetableGenerator.setBounds(10, 10, 233, 74);
		frmAddStudentGroup_1.getContentPane().add(btnTimetableGenerator);
		
		dateTime = new JTextField();
		dateTime.setForeground(Color.WHITE);
		dateTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		dateTime.setBounds(1114, 25, 197, 44);
		
		dateTime.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
		dateTime.setBackground(Color.decode("#4660BD"));
		frmAddStudentGroup_1.getContentPane().add(dateTime);
		dateTime.setColumns(10);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		

			
	}
}
