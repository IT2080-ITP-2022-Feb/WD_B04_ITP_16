package consecutiveSession;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import connection.DBConnection;
import home.DashBoard;
import lecturerManagement.AddingLecturers;
import net.proteanit.sql.DbUtils;

public class AddConsecutiveSession {

private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection con;
	private JTable table;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField gensession;
	
	//fill  session 1
	  public void fillsesions1() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Sessions AS sessionSign";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("SID");
					 comboBox.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	  //fill session 2 
	  public void fillsesions2() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Sessions As sessionSignature";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("SID");
					 comboBox_1.addItem(name);
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
				
				String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(6);
				columnModel.getColumn(1).setPreferredWidth(900);
				
				
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
	  

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConsecutiveSession window = new AddConsecutiveSession();
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
	public AddConsecutiveSession() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.setBounds(30, 30, 1270, 750);
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.decode("#4660BD"));
		panel_2.setBounds(253, 88, 973, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_2_1 = new JButton("Consecutive Sessions");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConsecutiveSession addsessioncategory=new AddConsecutiveSession();
				addsessioncategory.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(10, 11, 230, 55);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1_1.setBounds(357, 11, 230, 55);
		panel_2.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_3 = new JButton("Not Available Times");
		btnNewButton_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_2_1_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2_1_3.setBounds(733, 11, 230, 55);
		panel_2.add(btnNewButton_2_1_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 587);
		panel_3.setBackground(Color.decode("#4660BD"));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Session 01");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(137, 41, 127, 35);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBackground(new Color(250, 235, 215));
		panel_3.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(274, 41, 483, 35);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"          ----------Select A Lecture Session----------"}));
		panel_3.add(comboBox);
		
		fillsesions1();
		
		JLabel lblNewLabel_2 = new JLabel("Session 02");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(137, 112, 110, 25);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBackground(new Color(250, 235, 215));
		panel_3.add(lblNewLabel_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(274, 109, 483, 35);
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"         ----------Select A Tutorial Session----------"}));
		panel_3.add(comboBox_1);
		
		fillsesions2();
		
		gensession = new JTextField();
		gensession.setBackground(UIManager.getColor("Button.light"));
		gensession.setEnabled(false);
		gensession.setBounds(10, 294, 953, 5);
		panel_3.add(gensession);
		gensession.setColumns(10);
		
		
		//add consecutive sessions
		JButton btnNewButton_14 = new JButton("Add Session");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gensession.setText(comboBox.getSelectedItem().toString()+"_"+comboBox_1.getSelectedItem().toString());
				
				String session1=comboBox.getSelectedItem().toString();
				String session2=comboBox_1.getSelectedItem().toString();
				String session = gensession.getText();
				
			
				
				 try {
					 
					 Connection con = DBConnection.connect();
					 
					  

	                    String query = "INSERT INTO consecutiveSession values(null, '" + session1 + "', '" + session2+ "', '"  + session + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                    	JOptionPane.showMessageDialog(null, "       This is alredy exist","Alert",JOptionPane.WARNING_MESSAGE);
		                      
	                    } else {
	                    	
	                    	
	                    	JLabel label = new JLabel("Consective Sessions added Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
	    					refreshTable();
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                	
	                	System.out.println(exception);
	                	
	                }
				
				
				
			}
		});
		
		
		
		btnNewButton_14.setBounds(346, 201, 157, 54);
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(Color.decode("#103778"));
		panel_3.add(btnNewButton_14);
		
		
		
		//clear input feilds
		JButton btnNewButton_15 = new JButton("CLEAR");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
			
				
				
			
			}
		});
		
		
		
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(Color.decode("#0593A2"));
		btnNewButton_15.setBounds(569, 202, 155, 53);
		panel_3.add(btnNewButton_15);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 953, 170);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(6);
			columnModel.getColumn(1).setPreferredWidth(900);
			
			
			
			
			
			//refreshTable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
