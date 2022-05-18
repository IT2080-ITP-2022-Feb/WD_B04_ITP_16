/**
 * 
 */
package DaysNHours;

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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import connection.DBConnection;

import javax.swing.JCheckBox;
import java.awt.SystemColor;




public class AddWorkingDays {

	/**
	 * rifak
	 */
	
	private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	
	static int no;
	static int noid;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkingDays window = new AddWorkingDays();
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
	public AddWorkingDays() {
		initialize();
		setID();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public void setID() {
		
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
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(51,0,0));
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 88, 233, 615);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 10, 213, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lecturers");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddWorkingDays AddWorkingDays=new AddWorkingDays();
			AddWorkingDays.main(null);
				frame.setVisible(false);

			}
		});

		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(10, 250, 213, 38);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Locations");
		btnNewButton_6.setForeground(new Color(0, 0, 0));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(10, 298, 213, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Tags");
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.setForeground(new Color(0, 0, 0));
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(new Color(255, 255, 255));
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.setForeground(new Color(0, 0, 0));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.setForeground(new Color(0, 0, 0));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(new Color(255, 255, 255));
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.setForeground(new Color(0, 0, 0));
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(new Color(255, 255, 255));
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(10, 10, 1216, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(430, 0, 329, 68);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(51, 51, 102));
		panel_2.setBounds(241, 88, 985, 76);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_11 = new JButton("Refresh");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkingDays AddWorkingDays=new AddWorkingDays();
				AddWorkingDays.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(Color.BLUE);
		btnNewButton_11.setBounds(10, 10, 266, 56);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Manage Working Days");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageWorkingDays manageWorkingDays=new ManageWorkingDays();
				manageWorkingDays.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_12.setBackground(Color.BLACK);
		btnNewButton_12.setBounds(697, 9, 266, 58);
		panel_2.add(btnNewButton_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBounds(241, 164, 985, 539);
		frame.getContentPane().add(panel_3);
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("No of Working Days");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_1.setBackground(new Color(148, 0, 211));
		lblNewLabel_1.setBounds(10, 24, 230, 50);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Working Days");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2.setBounds(10, 90, 230, 41);
		panel_3.add(lblNewLabel_2);

		
		JSpinner noDays = new JSpinner();
		noDays.setModel(new SpinnerNumberModel(0, 0, 7, 1));
		noDays.setFont(new Font("Times New Roman", Font.BOLD, 20));
		noDays.setBounds(225, 30, 220, 38);
		panel_3.add(noDays);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBackground(new Color(255, 165, 0));
		chckbxMonday.setForeground(new Color(255, 255, 255));
		chckbxMonday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxMonday.setBounds(225, 102, 105, 29);
		panel_3.add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBackground(new Color(255, 165, 0));
		chckbxTuesday.setForeground(new Color(255, 255, 255));
		chckbxTuesday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxTuesday.setBounds(225, 142, 105, 29);
		panel_3.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBackground(new Color(255, 165, 0));
		chckbxWednesday.setForeground(new Color(255, 255, 255));
		chckbxWednesday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxWednesday.setBounds(225, 182, 105, 29);
		panel_3.add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBackground(new Color(255, 165, 0));
		chckbxThursday.setForeground(new Color(255, 255, 255));
		chckbxThursday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxThursday.setBounds(225, 222, 105, 29);
		panel_3.add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBackground(new Color(255, 165, 0));
		chckbxFriday.setForeground(new Color(255, 255, 255));
		chckbxFriday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxFriday.setBounds(225, 264, 105, 29);
		panel_3.add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBackground(new Color(255, 165, 0));
		chckbxSaturday.setForeground(new Color(255, 255, 255));
		chckbxSaturday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxSaturday.setBounds(375, 102, 105, 29);
		panel_3.add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBackground(new Color(255, 165, 0));
		chckbxSunday.setForeground(new Color(255, 255, 255));
		chckbxSunday.setFont(new Font("Times New Roman", Font.BOLD, 15));
		chckbxSunday.setBounds(375, 142, 105, 29);
		panel_3.add(chckbxSunday);
		
		JLabel lblNewLabel_2_1 = new JLabel("Working Time Per Day");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(10, 316, 230, 41);
		panel_3.add(lblNewLabel_2_1);
		
		JSpinner hours_1 = new JSpinner();
		hours_1.setModel(new SpinnerNumberModel(0, 0, 8, 1));
		hours_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		hours_1.setBounds(225, 317, 105, 38);
		panel_3.add(hours_1);
		
		JSpinner minutes_1 = new JSpinner();
		minutes_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		minutes_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		minutes_1.setBounds(427, 317, 111, 38);
		panel_3.add(minutes_1);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setForeground(new Color(255, 255, 255));
		lblHours.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblHours.setBounds(340, 321, 85, 34);
		panel_3.add(lblHours);
		
		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setForeground(new Color(255, 255, 255));
		lblMinute.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblMinute.setBounds(546, 321, 85, 34);
		panel_3.add(lblMinute);
		
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				noDays.setValue(0);
				hours_1.setValue(0);
				minutes_1.setValue(0);
				chckbxMonday.setSelected(false);
				chckbxTuesday.setSelected(false);
				chckbxWednesday.setSelected(false);
				chckbxThursday.setSelected(false);
				chckbxFriday.setSelected(false);
				chckbxSaturday.setSelected(false);
				chckbxSunday.setSelected(false);
				
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_14.setBackground(new Color(105, 105, 105));
		btnNewButton_14.setBounds(205, 426, 157, 41);
		panel_3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Save");
		btnNewButton_15.setForeground(new Color(255, 255, 255));
		btnNewButton_15.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String NoOfWorkingDays= noDays.getValue().toString();
				
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				String hours= hours_1.getValue().toString();
				String minutes=minutes_1.getValue().toString();
				
				
				if(chckbxMonday .isSelected()) 
				{
					monday="Monday";
				}
				if( chckbxTuesday.isSelected())
				{
					tuesday="Tuesday";
				}
				if(chckbxWednesday.isSelected()) 
				{
					wednesday="Wednesday";
				}
				if( chckbxThursday.isSelected())
				{
					thursday="Thursday";
				}
				if(chckbxFriday.isSelected()) 
				{
					friday="Friday";
				}
				if(chckbxSaturday.isSelected()) 
				{
					saturday="Saturday";
				}
				if(chckbxSunday.isSelected())
				{
					sunday="Sunday";
				}
				 if(noDays.getValue().equals(0)&& hours_1.getValue().equals(0)&& minutes_1.getValue().equals(0)) {
						JOptionPane.showMessageDialog(null, "Please Select Number of working Hours and Days!!!");
					}
					 else if(noDays.getValue().equals(0)) {
							JOptionPane.showMessageDialog(null, "Please Select Number of working days!!!");
						}
					 
					 else if(hours_1.getValue().equals(0)&& minutes_1.getValue().equals(0)) {
							JOptionPane.showMessageDialog(null, "Please Select Number of working hours and minutes!!!");
						}
				
				else {
					try {
					 Connection con = DBConnection.connect();

	                    String query = "INSERT INTO WorkingDays values(null, '" + NoOfWorkingDays + "','" + monday + "','" + tuesday + "','" +
	                    		wednesday + "','" + thursday + "','" + friday + "','"+ saturday +"','"+ sunday +"','"+ hours +"','"+ minutes +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) 
	                    {
	                    	JLabel label = new JLabel("This is alredy exist");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	                    } 
	                    else
	                    {
	                    	JLabel label = new JLabel("Working Days Details Inserted Successfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	                    } 
	                    con.close();
	                }
					catch (Exception exception) 
					{
	                	 System.out.println("Error!!");
	                }
				}
			}
		
					
			
			
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_15.setBackground(new Color(0, 250, 154));
		btnNewButton_15.setBounds(594, 426, 157, 41);
		panel_3.add(btnNewButton_15);
		
		
		
		

				

	}
}
