/**
 * 
 */
package Tags;

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


import Locations_Management.AddLocations;
import connection.DBConnection;
import home.DashBoard;
import lecturerManagement.AddingLecturers;
import net.proteanit.sql.DbUtils;
import javax.swing.BorderFactory;



/**
 * @author uzman
 *
 */
public class ManageTags {

	/**
	 * @params args
	 */
private JFrame frame;

	
	PreparedStatement pstd=null;
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;
	Connection conn;
	private JTextField TagName;
	private JTextField TagCode;
	private JComboBox RelatedTag;
	private JTable tagTable;
	private JTextField txtManageTags;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTags window = new ManageTags();
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
	public ManageTags() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 1250, 750);
		frame.setBackground(new Color(51,0,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(65, 105, 225));
		frame.getContentPane().setLayout(null);
		frame.setTitle("Time Table Management System");
		
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
		btnNewButton.setBackground(new Color(255, 255, 255));
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
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 58, 213, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Groups");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(10, 106, 213, 38);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Subjects");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(10, 154, 213, 38);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Working days/Hours");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(10, 202, 213, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Sessions");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(10, 250, 213, 38);
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
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(10, 298, 213, 38);
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
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(10, 346, 213, 38);
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_8_1 = new JButton("Session Types");
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_8_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8_1.setBackground(new Color(255, 255, 255));
		btnNewButton_8_1.setBounds(10, 394, 213, 38);
		panel_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8 = new JButton("Session Rooms");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.setBounds(10, 442, 213, 38);
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Generate Timetables");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_9.setBackground(new Color(255, 255, 255));
		btnNewButton_9.setBounds(10, 490, 213, 38);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10_1 = new JButton("Statistics");
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

			}
		});
		btnNewButton_10_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_10_1.setBackground(new Color(255, 255, 255));
		btnNewButton_10_1.setBounds(10, 538, 213, 38);
		panel_1.add(btnNewButton_10_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(253, 174, 973, 529);
		panel_3.setBackground(new Color(65, 105, 225));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tag Name");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(75, 355, 156, 38);
		panel_3.add(lblNewLabel_1);
		
		TagName = new JTextField();
		TagName.setBackground(new Color(255, 255, 255));
		TagName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TagName.setBounds(325, 355, 317, 38);
		panel_3.add(TagName);
		TagName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tag Code");
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(75, 415 , 156, 38);
		panel_3.add(lblNewLabel_2);
		
		TagCode = new JTextField();
		TagCode.setBackground(new Color(255, 255, 255));
		TagCode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		TagCode.setBounds(325, 415, 317, 38);
		panel_3.add(TagCode);
		TagCode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Related Tag");
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(75, 475, 156, 33);
		panel_3.add(lblNewLabel_3);
		
		JComboBox RelatedTag = new JComboBox();
		RelatedTag.setFont(new Font("Times New Roman", Font.BOLD, 20));
		RelatedTag.setBackground(new Color(255, 255, 255));
		RelatedTag.setModel(new DefaultComboBoxModel(new String[] {"", "Lecture", "Tutorial", "Lab"}));
		RelatedTag.setBounds(325, 475, 317, 33);
		panel_3.add(RelatedTag);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


				

				

				try {
					if(TagName.getText().equals("")||RelatedTag.getSelectedItem().equals("") ||TagCode.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
					}else{
					Connection con = DBConnection.connect();
					
					String query="Update Tag set TagName='"+TagName.getText()+"',TagCode='"+TagCode.getText()+"',RelatedTag='"+RelatedTag.getSelectedItem()+"'where TagCode='"+TagCode.getText()+"' ";//spinner_1
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
		btnNewButton_13.setBackground(new Color(0, 0, 128));
		btnNewButton_13.setBounds(820, 13, 143, 50);
		panel_3.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TagName.setText(null);
				TagCode.setText(null);
				RelatedTag.setSelectedItem(null);
				
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
					if(TagCode.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A TAG");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Tag where TagCode='"+TagCode.getText()+"'";
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 800, 230);
		panel_3.add(scrollPane);
		
		tagTable = new JTable();
		tagTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int selectedRow=tagTable.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                TagName.setText(tagTable.getValueAt(selectedRow, 0).toString());
                TagCode.setText(tagTable.getValueAt(selectedRow,1).toString());
                                
                String relatedTag=tagTable.getValueAt(selectedRow, 2).toString();
                	String getTag=(String) RelatedTag.getSelectedItem();
                	RelatedTag.setSelectedItem(relatedTag);
                	
                 	
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			}
		});
		tagTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Tag Name", "Tag Code", "Related Tag"}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tagTable);
		
		JButton btnNewButton_11 = new JButton("Add Tags");
		btnNewButton_11.setBounds(259, 107, 220, 56);
		frame.getContentPane().add(btnNewButton_11);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTags addtags=new AddTags();
				addtags.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_11.setBackground(new Color(0, 0, 128));
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBounds(1006, 106, 220, 58);
		frame.getContentPane().add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from Tag ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					tagTable.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			}
		});
		
				btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
				btnNewButton_12.setBackground(new Color(128, 0, 128));
				
				JButton TimetableBtn = new JButton("TIMETABLE GENERATOR");
				TimetableBtn.setForeground(Color.BLACK);
				TimetableBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
				TimetableBtn.setBackground(new Color(255, 122, 72));
				TimetableBtn.setBounds(10, 6, 233, 72);
				frame.getContentPane().add(TimetableBtn);
				
				txtManageTags = new JTextField();
				txtManageTags.setText("MANAGE TAGS");
				txtManageTags.setHorizontalAlignment(SwingConstants.CENTER);
				txtManageTags.setForeground(Color.WHITE);
				txtManageTags.setFont(new Font("Tahoma", Font.BOLD, 65));
				txtManageTags.setColumns(10);
				txtManageTags.setBorder(BorderFactory.createLineBorder(Color.decode("#4660BD")));
				txtManageTags.setBackground(new Color(70, 96, 189));
				txtManageTags.setBounds(308, 25, 725, 72);
				frame.getContentPane().add(txtManageTags);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTags managetags=new ManageTags();
				managetags.main(null);
				frame.setVisible(false);
			}
		});


	}

}
