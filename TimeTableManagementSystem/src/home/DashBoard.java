package home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class DashBoard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard window = new DashBoard();
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
	public DashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#4660BD"));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#FF7A48"));
		panel.setBounds(10, 10, 1216, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("TIMETABLE MANAGEMENT");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBackground(Color.decode("#FF7A48"));
		lblNewLabel.setBounds(430, 0, 329, 68);
		panel.add(lblNewLabel);
		
		Image user = new ImageIcon(getClass().getResource("/User Account.png")).getImage();
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(Color.decode("#B4B4B4"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(user));
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setText("LECTURERS MANAGEMENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lecturerManagement.AddingLecturers addinglectures=new lecturerManagement.AddingLecturers();
				addinglectures.main(null);
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(489, 145, 329, 79);
		frame.getContentPane().add(btnNewButton_1);
		
		Image Student=new ImageIcon(this.getClass().getResource("/Student Registration.png")).getImage();
		
		JButton btnNewButton_2 = new JButton("STUDENT MANAGEMENT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setBackground(Color.decode("#B4B4B4"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(Color.WHITE);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Student));
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(43, 145, 405, 79);
		frame.getContentPane().add(btnNewButton_2);
		
		Image Subject=new ImageIcon(this.getClass().getResource("/Literature.png")).getImage();
		JButton btnNewButton_3 = new JButton("SUBJECT MANAGEMENT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Subject));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setBackground(Color.decode("#B4B4B4"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setBackground(Color.WHITE);
			}
		});
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(855, 145, 371, 79);
		frame.getContentPane().add(btnNewButton_3);
		
		Image WorkingDay=new ImageIcon(this.getClass().getResource("/Planner.png")).getImage();
		JButton btnNewButton_4 = new JButton("WORKING DAYS MANAGEMENT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(WorkingDay));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(Color.decode("#B4B4B4"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(Color.WHITE);
			}
		});
		btnNewButton_4.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(43, 277, 405, 79);
		frame.getContentPane().add(btnNewButton_4);
		
		Image SessionMgt = new ImageIcon(getClass().getResource("/Logout.png")).getImage();
		JButton btnNewButton_5 = new JButton("SESSION MANAGEMENT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		btnNewButton_5.setIcon(new ImageIcon(SessionMgt));
		btnNewButton_5.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(489, 282, 329, 68);
		frame.getContentPane().add(btnNewButton_5);
		
		Image Location = new ImageIcon(getClass().getResource("/Map Pin.png")).getImage();
		JButton btnNewButton_6 = new JButton("LOCATION MANAGEMENT");
		btnNewButton_6.setIcon(new ImageIcon(Location));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_6.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(855, 282, 371, 68);
		frame.getContentPane().add(btnNewButton_6);
		
		Image Tag = new ImageIcon(getClass().getResource("/Tags.png")).getImage();
		JButton btnNewButton_7 = new JButton("TAG MANAGEMENT");
		btnNewButton_7.setIcon(new ImageIcon(Tag));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_7.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(43, 412, 405, 79);
		frame.getContentPane().add(btnNewButton_7);
		
		Image Room = new ImageIcon(getClass().getResource("/Open Door.png")).getImage();
		JButton btnNewButton_8 = new JButton("ROOM MANAGEMENT");
		btnNewButton_8.setIcon(new ImageIcon(Room));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			

				
			}
		});
		btnNewButton_8.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(489, 412, 329, 79);
		frame.getContentPane().add(btnNewButton_8);
		
		
		Image FIlterTImetable = new ImageIcon(getClass().getResource("/Timetable.png")).getImage();
		JButton btnNewButton_9 = new JButton("FILTER TIMETABLE");
		btnNewButton_9.setIcon(new ImageIcon(FIlterTImetable));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			
				
			
			}
		});
		btnNewButton_9.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.setBounds(43, 538, 405, 79);
		frame.getContentPane().add(btnNewButton_9);
		
		Image Stat = new ImageIcon(getClass().getResource("/Statistics.png")).getImage();
		JButton btnNewButton_10 = new JButton("STATISTICS");
		btnNewButton_10.setIcon(new ImageIcon(Stat));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
			}
		});
		btnNewButton_10.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.setBounds(491, 538, 327, 79);
		frame.getContentPane().add(btnNewButton_10);
		
		Image SessType = new ImageIcon(getClass().getResource("/Type.png")).getImage();
		JButton btnNewButton_10_1 = new JButton("SESSION TYPE MANAGEMENT");
		btnNewButton_10_1.setIcon(new ImageIcon(SessType));
		btnNewButton_10_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_10_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton_10_1.setBackground(Color.WHITE);
		btnNewButton_10_1.setBounds(855, 412, 371, 79);
		frame.getContentPane().add(btnNewButton_10_1);
		
		JLabel lblNewLabel_1 = new JLabel("    ");
		lblNewLabel_1.setBounds(20, 88, 1201, 620);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
