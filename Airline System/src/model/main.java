package model;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import controller.Calculator.AgeCalculator;
import controller.validator.ArrivalAndOriginSameException;
import controller.validator.InvalidNumberException;
import controller.validator.MaximumDateException;
import controller.validator.MaximumNumberException;
import controller.validator.MinimumDateException;
import controller.validator.MinimumNumberException;
import controller.validator.RequiredFieldException;
import controller.validator.Validator;
import java.awt.Color;

public class main extends JFrame {

	public int ID=1;
	public int row = 0;
	public int column = 0; 
	
	public String userName = "layla0";
	public String password = "123456";
	
	public float walletBalance = (float) 200.00;
	public float total;
	
	public String boarding="";
	public String arrival="";
	public String type="";
	public String boardingDate="";
	public String boardingTime="";
	
	public String fullName="";
	public String gender="";
	public String DoB="";
	
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JTextField textFullName;
	private JLabel lblGender;
	private JTable table;
	private JTextField textTopupField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		contentPane.add(login, "login");
		
		JLabel lblAirlineTicketingSystem = new JLabel("Airline Ticketing System");
		lblAirlineTicketingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.grabFocus();
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		
		passwordField = new JPasswordField();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(102, 102, 255));
		btnLogin.setForeground(new Color(255, 255, 255));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(255, 204, 0));

		ImageIcon image = new ImageIcon(new ImageIcon("C:\\\\Users\\\\anist\\\\Desktop\\\\Umie\\\\Airline System\\\\icon.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
 
		JLabel lblLogo = new JLabel(image);

		GroupLayout gl_login = new GroupLayout(login);
		gl_login.setHorizontalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGap(175)
					.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_login.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_login.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_login.createSequentialGroup()
									.addComponent(btnLogin)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnClear))
								.addComponent(textUsername)
								.addComponent(passwordField, 420, 420, Short.MAX_VALUE))))
					.addContainerGap(174, Short.MAX_VALUE))
				.addGroup(gl_login.createSequentialGroup()
					.addGap(332)
					.addComponent(lblAirlineTicketingSystem, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addGap(332))
				.addGroup(gl_login.createSequentialGroup()
					.addGap(324)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(324, Short.MAX_VALUE))
		);
		gl_login.setVerticalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGap(69)
					.addComponent(lblAirlineTicketingSystem)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnClear))
					.addGap(82))
		);
		login.setLayout(gl_login);
		
		JSplitPane homepage = new JSplitPane();
		contentPane.add(homepage, "homepage");
		
		JPanel ControlPanel = new JPanel();
		homepage.setLeftComponent(ControlPanel);
		GridBagLayout gbl_ControlPanel = new GridBagLayout();
		gbl_ControlPanel.columnWidths = new int[]{45, 0};
		gbl_ControlPanel.rowHeights = new int[]{14, 23, 23, 23, 0};
		gbl_ControlPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_ControlPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ControlPanel.setLayout(gbl_ControlPanel);
		
		JLabel lblMenu = new JLabel("Menu Bar");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMenu.anchor = GridBagConstraints.NORTH;
		gbc_lblMenu.insets = new Insets(0, 0, 5, 0);
		gbc_lblMenu.gridx = 0;
		gbc_lblMenu.gridy = 0;
		ControlPanel.add(lblMenu, gbc_lblMenu);
		
		JButton btnHome = new JButton("Home");
		GridBagConstraints gbc_btnHome = new GridBagConstraints();
		gbc_btnHome.anchor = GridBagConstraints.NORTH;
		gbc_btnHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnHome.insets = new Insets(0, 0, 5, 0);
		gbc_btnHome.gridx = 0;
		gbc_btnHome.gridy = 1;
		ControlPanel.add(btnHome, gbc_btnHome);
		
		JButton btnBookTicket = new JButton("Book Ticket");
		GridBagConstraints gbc_btnBookTicket = new GridBagConstraints();
		gbc_btnBookTicket.anchor = GridBagConstraints.NORTH;
		gbc_btnBookTicket.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBookTicket.insets = new Insets(0, 0, 5, 0);
		gbc_btnBookTicket.gridx = 0;
		gbc_btnBookTicket.gridy = 2;
		ControlPanel.add(btnBookTicket, gbc_btnBookTicket);
		
		JButton btnViewBookHistory = new JButton("View Book History");
		GridBagConstraints gbc_btnViewBookHistory = new GridBagConstraints();
		gbc_btnViewBookHistory.anchor = GridBagConstraints.NORTH;
		gbc_btnViewBookHistory.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnViewBookHistory.gridx = 0;
		gbc_btnViewBookHistory.gridy = 3;
		ControlPanel.add(btnViewBookHistory, gbc_btnViewBookHistory);
		
		JPanel displayPanel = new JPanel();
		homepage.setRightComponent(displayPanel);
		displayPanel.setLayout(new CardLayout(0, 0));
		
		JPanel home = new JPanel();
		displayPanel.add(home, "home");
		home.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		home.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textTopupField = new JTextField();
		panel.add(textTopupField);
		textTopupField.setColumns(10);
		
		JButton btnTopup = new JButton("Topup");

		panel.add(btnTopup);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		
		JLabel lblEwallet = new JLabel("E-wallet");
		
		JLabel lblBalancerm = new JLabel("Balance (RM)");
		lblBalancerm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JTextArea textBalanceHome = new JTextArea();
		textBalanceHome.setEditable(false);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
		textBalanceHome.setText(decimalFormat.format(walletBalance));
		textBalanceHome.setOpaque(false);
		
		textBalanceHome.setFont(new Font("Monospaced", Font.PLAIN, 30));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(333)
							.addComponent(lblEwallet))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(161)
							.addComponent(lblBalancerm)
							.addGap(18)
							.addComponent(textBalanceHome, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEwallet)
					.addGap(95)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBalancerm)
						.addComponent(textBalanceHome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel bookTicket = new JPanel();
		displayPanel.add(bookTicket, "bookTicket");
		bookTicket.setLayout(new CardLayout(0, 0));
		

		
		JPanel searchFlight = new JPanel();
		bookTicket.add(searchFlight, "searchFlight");
		
		JLabel lblBookFlight = new JLabel("Book Flight");
		lblBookFlight.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JComboBox originComboBox = new JComboBox();

		originComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Kuala Lumpur (KUL)", "Penang (PEN)", "Langkawi (LGK)", "Johor Bahru (JHB)"}));
		
		JLabel lblArrival = new JLabel("Arival");
		lblArrival.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JComboBox ArrivalComboBox = new JComboBox();

		ArrivalComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Kuala Lumpur (KUL)", "Penang (PEN)", "Langkawi (LGK)", "Johor Bahru (JHB)"}));
		
		JCalendar calendar = new JCalendar();
		calendar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JButton btnNext_1 = new JButton("Continue");
		
		JLabel lblNewLabel = new JLabel("Total (RM)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textTotal = new JTextArea();
		textTotal.setEditable(false);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult");

		
		JRadioButton rdbtnChildren = new JRadioButton("Children");

		
		JRadioButton rdbtnOku = new JRadioButton("OKU");

				GroupLayout gl_searchFlight = new GroupLayout(searchFlight);
				gl_searchFlight.setHorizontalGroup(
					gl_searchFlight.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchFlight.createSequentialGroup()
							.addGroup(gl_searchFlight.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_searchFlight.createSequentialGroup()
									.addGap(320)
									.addComponent(lblBookFlight, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_searchFlight.createSequentialGroup()
									.addGap(326)
									.addComponent(btnNext_1))
								.addGroup(gl_searchFlight.createSequentialGroup()
									.addGap(75)
									.addComponent(lblOrigin, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_searchFlight.createSequentialGroup()
									.addGap(137)
									.addGroup(gl_searchFlight.createParallelGroup(Alignment.TRAILING)
										.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
										.addComponent(originComboBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_searchFlight.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_searchFlight.createSequentialGroup()
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textTotal))
										.addComponent(rdbtnChildren)
										.addComponent(rdbtnAdult)
										.addComponent(rdbtnOku)
										.addComponent(ArrivalComboBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(67, Short.MAX_VALUE))
				);
				gl_searchFlight.setVerticalGroup(
					gl_searchFlight.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchFlight.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBookFlight)
							.addGap(29)
							.addGroup(gl_searchFlight.createParallelGroup(Alignment.BASELINE)
								.addComponent(originComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOrigin)
								.addComponent(lblArrival)
								.addComponent(ArrivalComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_searchFlight.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_searchFlight.createSequentialGroup()
									.addComponent(rdbtnAdult)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnChildren)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnOku)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_searchFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel)
										.addComponent(textTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(calendar, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
							.addComponent(btnNext_1)
							.addGap(28))
				);
				searchFlight.setLayout(gl_searchFlight);
				
								

		
		JPanel selectFlight = new JPanel();
		bookTicket.add(selectFlight, "selectFlight");
		
		JLabel lblDepart = new JLabel("From");
		
		JTextArea textOrigin = new JTextArea();
		textOrigin.setEditable(false);
		textOrigin.setOpaque(false);
		
		JLabel lblTo = new JLabel("To");
		
		JTextArea textArrival = new JTextArea();
		textArrival.setEditable(false);
		textArrival.setOpaque(false);
		
		JLabel lbl1000 = new JLabel("10.00");
		
		JLabel lbl1200 = new JLabel("12:00");
		
		JLabel lbl1400 = new JLabel("14:00");
		
		JLabel lbl1600 = new JLabel("16:00");
		
		JLabel lbl1800 = new JLabel("18:00");
		
		JLabel lblBoardTime = new JLabel("Boarding Time");
		lblBoardTime.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSelect1000 = new JButton("Select this Flight");

		
		JButton btnSelect1200 = new JButton("Select this Flight");

		
		JButton btnSelect1400 = new JButton("Select this Flight");

		
		JButton btnSelect1600 = new JButton("Select this Flight");

		
		JButton btnSelect1800 = new JButton("Select this Flight");

		
		JTextArea textTotal_2 = new JTextArea();
		textTotal_2.setEditable(false);
		
		JLabel label = new JLabel("Total (RM)");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		
				
				JButton btnPrevious_2 = new JButton("Previous");

				
				JLabel lblSelectBoardingTime = new JLabel("Select Boarding Time");
				GroupLayout gl_selectFlight = new GroupLayout(selectFlight);
				gl_selectFlight.setHorizontalGroup(
					gl_selectFlight.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_selectFlight.createSequentialGroup()
							.addGap(136)
							.addComponent(lblBoardTime, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(480, Short.MAX_VALUE))
						.addGroup(gl_selectFlight.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPrevious_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(202)
							.addComponent(lblSelectBoardingTime)
							.addContainerGap(303, Short.MAX_VALUE))
						.addGroup(gl_selectFlight.createSequentialGroup()
							.addGap(119)
							.addGroup(gl_selectFlight.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_selectFlight.createSequentialGroup()
									.addComponent(lblDepart, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textOrigin, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblTo)
									.addGap(18)
									.addComponent(textArrival, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_selectFlight.createSequentialGroup()
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lbl1000, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl1200, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl1600, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
										.addComponent(lbl1400, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
										.addComponent(lbl1800, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnSelect1000, GroupLayout.PREFERRED_SIZE, 395, Short.MAX_VALUE)
										.addComponent(btnSelect1200, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
										.addComponent(btnSelect1600, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
										.addComponent(btnSelect1400, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
										.addComponent(btnSelect1800, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
									.addGap(360))))
						.addGroup(gl_selectFlight.createSequentialGroup()
							.addGap(264)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textTotal_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(488, Short.MAX_VALUE))
				);
				gl_selectFlight.setVerticalGroup(
					gl_selectFlight.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_selectFlight.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_selectFlight.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPrevious_2)
								.addGroup(gl_selectFlight.createSequentialGroup()
									.addComponent(lblSelectBoardingTime)
									.addGap(21)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDepart)
										.addComponent(textOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTo)
										.addComponent(textArrival, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(32)
									.addComponent(lblBoardTime)
									.addGap(29)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSelect1000)
										.addComponent(lbl1000))
									.addGap(18)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSelect1200)
										.addComponent(lbl1200))
									.addGap(18)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSelect1400)
										.addComponent(lbl1400))
									.addGap(18)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSelect1600)
										.addComponent(lbl1600))
									.addGap(18)
									.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnSelect1800)
										.addComponent(lbl1800))))
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
							.addGroup(gl_selectFlight.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(textTotal_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39))
				);
				selectFlight.setLayout(gl_selectFlight);
		
		JPanel guestDetail = new JPanel();
		bookTicket.add(guestDetail, "guestDetail");
		
		JLabel lblFullName = new JLabel("Full name :");
		lblFullName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JCalendar dobCalendar = new JCalendar();
		dobCalendar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		textFullName = new JTextField();
		textFullName.setColumns(10);
		
		lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");

		
		JRadioButton rdbtnFemale = new JRadioButton("Female");

		
		JLabel lblGuestDetails = new JLabel("Guest Details");
		lblGuestDetails.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("Total (RM)");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textTotal_3 = new JTextArea();
		textTotal_3.setEditable(false);
		
		JLabel lblDob = new JLabel("DoB :");
		lblDob.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JButton btnPrevious_3 = new JButton("Previous");

		
		JButton btnProceedtoPayment = new JButton("Proceed to Payment");

		GroupLayout gl_guestDetail = new GroupLayout(guestDetail);
		gl_guestDetail.setHorizontalGroup(
			gl_guestDetail.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_guestDetail.createSequentialGroup()
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_guestDetail.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnPrevious_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(204)
							.addComponent(lblGuestDetails, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_guestDetail.createSequentialGroup()
							.addGap(264)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textTotal_3, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(263, Short.MAX_VALUE))
				.addGroup(gl_guestDetail.createSequentialGroup()
					.addContainerGap(289, Short.MAX_VALUE)
					.addComponent(btnProceedtoPayment)
					.addGap(288))
				.addGroup(gl_guestDetail.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_guestDetail.createSequentialGroup()
							.addGroup(gl_guestDetail.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_guestDetail.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_guestDetail.createSequentialGroup()
									.addComponent(rdbtnMale)
									.addGap(18)
									.addComponent(rdbtnFemale))
								.addComponent(dobCalendar, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_guestDetail.createSequentialGroup()
							.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFullName, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)))
					.addGap(159))
		);
		gl_guestDetail.setVerticalGroup(
			gl_guestDetail.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_guestDetail.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGuestDetails)
						.addComponent(btnPrevious_3))
					.addGap(9)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFullName)
						.addComponent(textFullName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale))
					.addGap(18)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDob)
						.addComponent(dobCalendar, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_guestDetail.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textTotal_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnProceedtoPayment)
					.addGap(27))
		);
		guestDetail.setLayout(gl_guestDetail);
		
		ButtonGroup G = new ButtonGroup();
		
		G.add(rdbtnFemale);
		G.add(rdbtnMale);
		
		ButtonGroup A = new ButtonGroup();
		
		A.add(rdbtnAdult);
		A.add(rdbtnChildren);
		A.add(rdbtnOku);
		
		JPanel payment = new JPanel();
		bookTicket.add(payment, "payment");
		
		JLabel lblPayment = new JLabel("Payment");
		
		JLabel lblFlight = new JLabel("Flight :");
		lblFlight.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textFlight_4 = new JTextArea();
		textFlight_4.setEditable(false);
		textFlight_4.setOpaque(false);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblBoardingTime = new JLabel("Boarding Time :");
		lblBoardingTime.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textDate_4 = new JTextArea();
		textDate_4.setEditable(false);
		textDate_4.setOpaque(false);
		
		JTextArea textBoardingTime_4 = new JTextArea();
		textBoardingTime_4.setEditable(false);
		textBoardingTime_4.setOpaque(false);
		
		JLabel lblTotal = new JLabel("TOTAL (RM)");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JTextArea textTotal_4 = new JTextArea();
		textTotal_4.setEditable(false);
		textTotal_4.setFont(new Font("Monospaced", Font.PLAIN, 40));
		
		JButton btnPayNow = new JButton("Pay Now");

		JLabel label_2 = new JLabel("");
		
		JLabel lblWalletBalance = new JLabel("Wallet Balance : ");
		
		JTextArea textWalletBalancePayment = new JTextArea();
		textWalletBalancePayment.setEditable(false);
		
		JButton btnPrevious_4 = new JButton("Previous");

		GroupLayout gl_payment = new GroupLayout(payment);
		gl_payment.setHorizontalGroup(
			gl_payment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_payment.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_payment.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblFlight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBoardingTime, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_payment.createParallelGroup(Alignment.LEADING)
						.addComponent(textBoardingTime_4, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDate_4, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFlight_4, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(126, Short.MAX_VALUE))
				.addGroup(gl_payment.createSequentialGroup()
					.addGap(50)
					.addComponent(label_2)
					.addContainerGap(656, Short.MAX_VALUE))
				.addGroup(gl_payment.createSequentialGroup()
					.addContainerGap(188, Short.MAX_VALUE)
					.addGroup(gl_payment.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblWalletBalance)
						.addComponent(lblTotal))
					.addGap(18)
					.addGroup(gl_payment.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textWalletBalancePayment)
						.addComponent(textTotal_4, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
					.addGap(186))
				.addGroup(gl_payment.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPrevious_4, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(230)
					.addComponent(lblPayment)
					.addContainerGap(332, Short.MAX_VALUE))
				.addGroup(gl_payment.createSequentialGroup()
					.addGap(316)
					.addComponent(btnPayNow)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		gl_payment.setVerticalGroup(
			gl_payment.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_payment.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_payment.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPrevious_4)
						.addComponent(lblPayment))
					.addGap(33)
					.addGroup(gl_payment.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFlight_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFlight))
					.addGap(18)
					.addGroup(gl_payment.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDate_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate))
					.addGap(18)
					.addGroup(gl_payment.createParallelGroup(Alignment.BASELINE)
						.addComponent(textBoardingTime_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBoardingTime))
					.addGap(18)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_payment.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWalletBalance)
						.addComponent(textWalletBalancePayment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_payment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_payment.createSequentialGroup()
							.addGap(23)
							.addComponent(lblTotal))
						.addComponent(textTotal_4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnPayNow)
					.addGap(53))
		);
		payment.setLayout(gl_payment);
		
		JPanel receipt = new JPanel();
		bookTicket.add(receipt, "receipt");
		
		JLabel lblAwanAirline = new JLabel("Awan Airline");
		
		JLabel lblName = new JLabel("Name :");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textNameReceipt = new JTextArea();
		textNameReceipt.setOpaque(false);
		
		JLabel lblGenderReceipt = new JLabel("Gender :\r\n");
		lblGenderReceipt.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDobReceipt = new JLabel("DoB :");
		lblDobReceipt.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JTextArea textDobReceipt = new JTextArea();
		textDobReceipt.setOpaque(false);
		
		JLabel lblFlightReceipt = new JLabel("Flight Details");
		lblFlightReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFlightReceipt.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JLabel lblDepartFrom = new JLabel("Depart From");
		lblDepartFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textDepartReceipt = new JTextArea();
		textDepartReceipt.setOpaque(false);
		
		JLabel lblArrivalReceipt = new JLabel("Arrival");
		lblArrivalReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textArrivalReceipt = new JTextArea();
		textArrivalReceipt.setOpaque(false);
		
		JLabel lblBoardingTimeReceipt = new JLabel("Boarding Time");
		lblBoardingTimeReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textBoardingTimeReceipt = new JTextArea();
		textBoardingTimeReceipt.setOpaque(false);
		
		JLabel lblTotalReceipt = new JLabel("Total (RM)");
		lblTotalReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textTotalReceipt = new JTextArea();
		textTotalReceipt.setOpaque(false);
		
		JButton btnPrint = new JButton("Print");
		
		JLabel lblBoardingDate = new JLabel("Boarding Date");
		lblBoardingDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JTextArea textBoardingDateReceipt = new JTextArea();
		textBoardingDateReceipt.setOpaque(false);
		
		JTextArea textTypeReceipt = new JTextArea();
		textTypeReceipt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTypeReceipt.setOpaque(false);
		
		JTextArea textGenderReceipt = new JTextArea();
		textGenderReceipt.setOpaque(false);

		GroupLayout gl_receipt = new GroupLayout(receipt);
		gl_receipt.setHorizontalGroup(
			gl_receipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_receipt.createSequentialGroup()
					.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_receipt.createSequentialGroup()
							.addGap(320)
							.addComponent(lblAwanAirline))
						.addGroup(gl_receipt.createSequentialGroup()
							.addGap(326)
							.addComponent(btnPrint))
						.addGroup(gl_receipt.createSequentialGroup()
							.addGap(160)
							.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_receipt.createSequentialGroup()
									.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblDobReceipt, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
										.addComponent(lblGenderReceipt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
										.addComponent(textGenderReceipt, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNameReceipt, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDobReceipt, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_receipt.createSequentialGroup()
									.addGroup(gl_receipt.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
											.addComponent(lblArrivalReceipt, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblDepartFrom)
											.addComponent(lblBoardingDate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblBoardingTimeReceipt)
										.addComponent(lblTotalReceipt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
										.addComponent(textTotalReceipt, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(textBoardingDateReceipt, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(textDepartReceipt, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(textArrivalReceipt, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
										.addComponent(textBoardingTimeReceipt, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))))
					.addGap(138))
				.addGroup(gl_receipt.createSequentialGroup()
					.addGap(200)
					.addComponent(lblFlightReceipt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textTypeReceipt, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
					.addGap(200))
		);
		gl_receipt.setVerticalGroup(
			gl_receipt.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_receipt.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAwanAirline)
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textNameReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenderReceipt)
						.addComponent(textGenderReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDobReceipt)
						.addComponent(textDobReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_receipt.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_receipt.createSequentialGroup()
							.addGap(1)
							.addComponent(textTypeReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFlightReceipt))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartFrom)
						.addComponent(textDepartReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblArrivalReceipt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArrivalReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBoardingDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textBoardingDateReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBoardingTimeReceipt)
						.addComponent(textBoardingTimeReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_receipt.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalReceipt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTotalReceipt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnPrint)
					.addContainerGap())
		);
		receipt.setLayout(gl_receipt);
		
		JPanel viewBookHistory = new JPanel();
		displayPanel.add(viewBookHistory, "viewBookHistory");
		viewBookHistory.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		viewBookHistory.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Aisyah Izzati binti Rohaizad", "Children ", "Kuala Lumpur (KUL)", "Langkawi (LGK)", "16:00", "12-12-2012 Wednesday"},
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
				"Id", "Name", "Ticket Type", "Departure", "Arrival", "Boarding Time", "Boarding Date"
			}
		));
		
		
		scrollPane.setViewportView(table);
		
		arrival = (String) ArrivalComboBox.getSelectedItem();
		System.out.println("Arrival: "+arrival);
		
		boarding = (String) originComboBox.getSelectedItem();
		System.out.println("Origin: "+boarding);
		
		textTotal.setText("0");
		
		//************************************************************************//
		//*******************item listener****************************************//
		//************************************************************************//
		
		originComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {				
				boarding = (String) originComboBox.getSelectedItem();
				System.out.println("Origin: "+boarding);
				
				if(boarding.equals(arrival)||arrival.isEmpty())
				{
					total = 0;
					textTotal.setText("0");
				}
				else
				{
					if(rdbtnAdult.isSelected())
					{
						total = (float) 112.00;
						textTotal.setText("112.00");
					}	
					else if(rdbtnChildren.isSelected())
					{
						total = (float) 94.00;
						textTotal.setText("94.00");
					}	
					else if(rdbtnOku.isSelected())
					{
						total = (float) 80.00;
						textTotal.setText("80.00");
					}	
				}
			}
		});
		
		ArrivalComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				arrival = (String) ArrivalComboBox.getSelectedItem();
				System.out.println("Arrival: "+arrival);
				
				if(boarding.equals(arrival)||arrival.isEmpty())
				{
					total = 0;
					textTotal.setText("0");
				}
				else
				{
					if(rdbtnAdult.isSelected())
					{	
						total = (float) 112.00;
						textTotal.setText("112.00");
					}	
					else if(rdbtnChildren.isSelected())
					{						
						total = (float) 94.00;
						textTotal.setText("94.00");
					}	
					else if(rdbtnOku.isSelected())
					{
						
						total = (float) 80.00;
						textTotal.setText("80.00");
					}	
				}
			}
		});
		
		rdbtnAdult.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnAdult.isSelected())
				{
					type = rdbtnAdult.getText();
					System.out.println("Type: "+type);
					
					if(boarding.equals(arrival)||arrival.isEmpty())
					{
						total = 0;
						textTotal.setText("0");
					}
					else
					{
						total = (float) 112.00;
						textTotal.setText("112.00");
					}
				}	
			}
		});
		
		rdbtnChildren.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnChildren.isSelected())
				{
					type = rdbtnChildren.getText();
					System.out.println("Type: "+type);
					
					if(boarding.equals(arrival)||arrival.isEmpty())
					{
						total = 0;
						textTotal.setText("0");
					}
					else
					{
						total = (float) 94.00;
						textTotal.setText("94.00");
					}
				}
			}
		});
		
		rdbtnOku.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnOku.isSelected())
				{
					type = rdbtnOku.getText();
					System.out.println("Type: "+type);
					
					if(boarding.equals(arrival)||arrival.isEmpty())
					{
						total = 0;
						textTotal.setText("0");
					}
					else
					{
						total = (float) 80.00;
						textTotal.setText("80.00");
					}
				}
			}
		});
		
		rdbtnMale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnMale.isSelected())
				{
					gender = "Male";
				}
			}
		});
		
		rdbtnFemale.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(rdbtnFemale.isSelected())
				{
					gender = "Female";
				}
			}
		});
		
		//************************************************************************//
		//*******************action listener**************************************//
		//************************************************************************//
		
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText("");
				passwordField.setText("");
				textUsername.grabFocus();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Vector<Exception> exceptions = new Vector<>();
				
				try {

					Validator.validate("Username",textUsername.getText(),true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				try {

					Validator.validate("Password",passwordField.getText(),true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				int size = exceptions.size();
				if(size == 0) {
					
					if(userName.equals(textUsername.getText()))
					{
						if(password.equals(passwordField.getText()))
						{
							JOptionPane.showMessageDialog(bookTicket, "Welcome.","",JOptionPane.INFORMATION_MESSAGE);
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "homepage");
						}
						else 
						{
							JOptionPane.showMessageDialog(contentPane, "Wrong password combination.","Validation error",JOptionPane.WARNING_MESSAGE);
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(contentPane, "The username does not exist in the database.","Validation error",JOptionPane.WARNING_MESSAGE);
					}
					
				}
				else
				{
					String message = null;

					if(size ==1)
					{
						message = exceptions.firstElement().getMessage();
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}

					else {
						message = "Please fix the following errors:";
						for (int i = 0; i < size; i++) {
							message += "\n"+ (i+1) + "." +exceptions.get(i).getMessage();
						}
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
			}
		});
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(boarding.isEmpty() && type.isEmpty() && arrival.isEmpty())
				{
					Date date = new Date();
					calendar.setDate(date);
					
					CardLayout card2 = (CardLayout) displayPanel.getLayout();
					card2.show(displayPanel, "bookTicket");
					
					CardLayout card3 = (CardLayout) displayPanel.getLayout();
					card3.show(displayPanel, "home");
				}
				else if(boarding.isEmpty()==false || type.isEmpty()==false || arrival.isEmpty()==false)
				{
					int reply = JOptionPane.showConfirmDialog(displayPanel,"Are you sure you want to leave this page? You will lost your progress if you leave." ,"", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) 
					{
						total = 0;
						boarding = "";
						arrival = "";
						type = "";
						boardingDate = "";
						boardingTime = "";
						fullName = "";
						gender = "";
						DoB = "";
						
						A.clearSelection();
						G.clearSelection();
						textTotal.setText("");
						textFullName.setText("");
						
						CardLayout card2 = (CardLayout) displayPanel.getLayout();
						card2.show(displayPanel, "bookTicket");
						
						CardLayout card3 = (CardLayout) displayPanel.getLayout();
						card3.show(displayPanel, "home");
						
						originComboBox.setSelectedIndex(0);
						ArrivalComboBox.setSelectedIndex(0);
						
						Date date = new Date();
						calendar.setDate(date);
						dobCalendar.setDate(date);
					}
				}
				

			}
		});
		
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(boarding.isEmpty() && type.isEmpty() && arrival.isEmpty())
				{
					Date date = new Date();
					calendar.setDate(date);
					
					CardLayout card2 = (CardLayout) displayPanel.getLayout();
					card2.show(displayPanel, "bookTicket");
					
					CardLayout card3 = (CardLayout) bookTicket.getLayout();
					card3.show(bookTicket, "searchFlight");
				}
				else if(boarding.isEmpty()==false || type.isEmpty()==false || arrival.isEmpty()==false)
				{
					int reply = JOptionPane.showConfirmDialog(displayPanel,"Are you sure you want to leave this page? You will lost your progress if you leave." ,"", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) 
					{
						total = 0;
						boarding = "";
						arrival = "";
						type = "";
						boardingDate = "";
						boardingTime = "";
						fullName = "";
						gender = "";
						DoB = "";
						
						A.clearSelection();
						G.clearSelection();
						textTotal.setText("");
						textFullName.setText("");
						
						CardLayout card2 = (CardLayout) displayPanel.getLayout();
						card2.show(displayPanel, "bookTicket");
						
						CardLayout card3 = (CardLayout) bookTicket.getLayout();
						card3.show(bookTicket, "searchFlight");
						
						originComboBox.setSelectedIndex(0);
						ArrivalComboBox.setSelectedIndex(0);
						
						Date date = new Date();
						calendar.setDate(date);
						dobCalendar.setDate(date);
					}
				}

			}
		});
		
		btnViewBookHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(boarding.isEmpty() && type.isEmpty() && arrival.isEmpty())
				{
					Date date = new Date();
					calendar.setDate(date);
					
					CardLayout card2 = (CardLayout) displayPanel.getLayout();
					card2.show(displayPanel, "bookTicket");
					
					CardLayout card3 = (CardLayout) displayPanel.getLayout();
					card3.show(displayPanel, "viewBookHistory");
				}
				else if(boarding.isEmpty()==false || type.isEmpty()==false || arrival.isEmpty()==false)
				{
					int reply = JOptionPane.showConfirmDialog(displayPanel,"Are you sure you want to leave this page? You will lost your progress if you leave." ,"", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) 
					{
						total = 0;
						boarding = "";
						arrival = "";
						type = "";
						boardingDate = "";
						boardingTime = "";
						fullName = "";
						gender = "";
						DoB = "";
						
						A.clearSelection();
						G.clearSelection();
						textTotal.setText("");
						textFullName.setText("");
						
						CardLayout card2 = (CardLayout) displayPanel.getLayout();
						card2.show(displayPanel, "bookTicket");
						
						CardLayout card3 = (CardLayout) displayPanel.getLayout();
						card3.show(displayPanel, "viewBookHistory");
						
						originComboBox.setSelectedIndex(0);
						ArrivalComboBox.setSelectedIndex(0);
						
						Date date = new Date();
						calendar.setDate(date);
						dobCalendar.setDate(date);
					}
				}
				

			}
		});
		
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy EEEE");

				boardingDate = sdf.format(calendar.getDate());

				System.out.println(boardingDate);
				
				Vector<Exception> exceptions = new Vector<>();
				
				try {

					Validator.validate("Origin",boarding,true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
							
				try {

					Validator.validate("Arrival",arrival,true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				try {

					Validator.validateLocation("Boarding","Arrival",boarding,arrival,true);

				} catch (ArrivalAndOriginSameException e1) {
					exceptions.add(e1);
				}
				
				try {

					Validator.validate("Ticket type",type,true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				try {

					try {
						Validator.validateDate("Boarding date", calendar.getDate(), true);
					} catch (MinimumDateException e1) {
						exceptions.add(e1);		
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				int size = exceptions.size();
				if(size == 0) {
					CardLayout card3 = (CardLayout) bookTicket.getLayout();
					card3.show(bookTicket, "selectFlight");
					
					textOrigin.setText(boarding);
					textArrival.setText(arrival);
					
			        DecimalFormat decimalFormat = new DecimalFormat("#.00");
					textTotal_2.setText(decimalFormat.format(total));
					
					try {
						
						
					} catch (Exception e1) {
					
					}

				}
				else 
				{
					String message = null;

					if(size ==1)
					{
						message = exceptions.firstElement().getMessage();
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}

					else {
						message = "Please fix the following errors:";
						for (int i = 0; i < size; i++) {
							message += "\n"+ (i+1) + "." +exceptions.get(i).getMessage();
						}
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
				
			}
		});
		
		btnSelect1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardingTime = "10:00";
				
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
				
		        DecimalFormat decimalFormat = new DecimalFormat("#.00");
				textTotal_3.setText(decimalFormat.format(total));
			}
		});
		
		btnSelect1200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardingTime = "12:00";
				
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
				
		        DecimalFormat decimalFormat = new DecimalFormat("#.00");
				textTotal_3.setText(decimalFormat.format(total));
			}
		});
		
		btnSelect1400.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardingTime = "14:00";
				
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
				
		        DecimalFormat decimalFormat = new DecimalFormat("#.00");
				textTotal_3.setText(decimalFormat.format(total));
			}
		});
		
		btnSelect1600.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardingTime = "16:00";
				
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
				
		        DecimalFormat decimalFormat = new DecimalFormat("#.00");
				textTotal_3.setText(decimalFormat.format(total));
			}
		});
		
		btnSelect1800.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boardingTime = "18:00";
				
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
				
		        DecimalFormat decimalFormat = new DecimalFormat("#.00");
				textTotal_3.setText(decimalFormat.format(total));
			}
		});
		
		btnProceedtoPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				
				textFlight_4.setText("From "+boarding+" to "+arrival);
				
				textDate_4.setText(boardingDate);
				
				textBoardingTime_4.setText(boardingTime);
				
				DecimalFormat decimalFormat2 = new DecimalFormat("#.00");
				textWalletBalancePayment.setText(decimalFormat2.format(walletBalance));

				DoB = sdf2.format(dobCalendar.getDate());

				System.out.println(DoB);
				
				Vector<Exception> exceptions = new Vector<>();
				
				try {

					Validator.validate("Full Name",textFullName.getText(),true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				try {

					Validator.validate("Gender",gender,true);

				} catch (RequiredFieldException e1) {
					exceptions.add(e1);
				}
				
				try {

					Validator.validateDoB("Date of birthday",dobCalendar.getDate(),true);

				} catch (MaximumDateException e1) {
					exceptions.add(e1);
				}
				
				
				int size = exceptions.size();
				if(size == 0) {
					
			        DecimalFormat decimalFormat = new DecimalFormat("#.00");
					textTotal_4.setText(decimalFormat.format(total));
					
					fullName = textFullName.getText();
					
					LocalDate localDob = LocalDate.parse(DoB);

					int actualAge = AgeCalculator.calculateAge(localDob);

					System.out.println(actualAge);

					if(type == "Children")
					{
						
						if(actualAge>=12)
						{
							JOptionPane.showMessageDialog(bookTicket, "Passenger above 12 years old is not a child.","Please fix this problem",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(actualAge<=2)
						{
							JOptionPane.showMessageDialog(bookTicket, "Kid under the age of 2 doesn't need a plane ticket.","Attention",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							CardLayout card3 = (CardLayout) bookTicket.getLayout();
							card3.show(bookTicket, "payment");
						}
					}
					else
					{
						if(actualAge<=2)
						{
							JOptionPane.showMessageDialog(bookTicket, "Kid under the age of 2 doesn't need a plane ticket.","Attention",JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							CardLayout card3 = (CardLayout) bookTicket.getLayout();
							card3.show(bookTicket, "payment");
						}
					}

				}
				else 
				{
					String message = null;

					if(size ==1)
					{
						message = exceptions.firstElement().getMessage();
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}

					else {
						message = "Please fix the following errors:";
						for (int i = 0; i < size; i++) {
							message += "\n"+ (i+1) + "." +exceptions.get(i).getMessage();
						}
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		btnPayNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(walletBalance>total)
				{
					int reply = JOptionPane.showConfirmDialog(displayPanel,"After you have made the payment you won't be able to change the flight details." ,"Are you sure?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) 
					{
						walletBalance = walletBalance-total;
						
				        DecimalFormat decimalFormat = new DecimalFormat("#.00");
						textTotalReceipt.setText(decimalFormat.format(total));
						
						textDobReceipt.setText(DoB);
						
						textNameReceipt.setText(capitalizeWord(fullName));
						
						textArrivalReceipt.setText(arrival);
						
						textDepartReceipt.setText(boarding);
						
						textBoardingDateReceipt.setText(boardingDate);
						
						textBoardingTimeReceipt.setText(boardingTime);
						
						textTypeReceipt.setText("("+type+" ticket)");
						
						textGenderReceipt.setText(gender);
						
						Date date = new Date();
						calendar.setDate(date);
						dobCalendar.setDate(date);
						
						
				        DecimalFormat decimalFormat3 = new DecimalFormat("#.00");
						textBalanceHome.setText(decimalFormat3.format(walletBalance));
						
						row++;
						ID++;
						
						table.setValueAt(ID, row, column);
						table.setValueAt(fullName, row, ++column);
						table.setValueAt(type, row, ++column);
						table.setValueAt(boarding, row, ++column);
						table.setValueAt(arrival, row, ++column);
						table.setValueAt(boardingTime, row, ++column);
						table.setValueAt(boardingDate, row, ++column);
						
						column = 0;
						
						total = 0;
						arrival = "";
						type = "";
						boardingDate = "";
						boardingTime = "";
						fullName = "";
						gender = "";
						DoB = "";
						
						originComboBox.setSelectedIndex(0);
						ArrivalComboBox.setSelectedIndex(0);
						
						A.clearSelection();
						G.clearSelection();
						textTotal.setText("");
						textFullName.setText("");
						
						CardLayout card3 = (CardLayout) bookTicket.getLayout();
						card3.show(bookTicket, "receipt");
						
					}
				}
				else
				{
					JOptionPane.showMessageDialog(displayPanel," Please Top up your e-wallet." ,"Insufficent balance",JOptionPane.WARNING_MESSAGE);
				}
				
				
				


			}
		});
		
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printRecord(receipt);
			}
		});
		
		btnPrevious_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "searchFlight");
			}
		});
		
		btnPrevious_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "selectFlight");
			}
		});
		
		btnPrevious_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card3 = (CardLayout) bookTicket.getLayout();
				card3.show(bookTicket, "guestDetail");
			}
		});
		
		btnTopup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Vector<Exception> exceptions = new Vector<>();
				
				try {

					Validator.validate("Topup amount", textTopupField.getText(), true, true, 0.01, true, 2000.00) ;

				} catch (RequiredFieldException | InvalidNumberException | MinimumNumberException | MaximumNumberException e1) {
					exceptions.add(e1);
				}
				
				int size = exceptions.size();
				if(size == 0) {
					
					float amount = Float.valueOf(textTopupField.getText().toString());
					
					walletBalance = walletBalance + amount;
					
			        DecimalFormat decimalFormat3 = new DecimalFormat("#.00");
					textBalanceHome.setText(decimalFormat3.format(walletBalance));
					
					textTopupField.setText("");
					
					JOptionPane.showMessageDialog(home, "Topup Sucessful","",JOptionPane.INFORMATION_MESSAGE);
					
					
				}
				else
				{
					String message = null;

					if(size ==1)
					{
						message = exceptions.firstElement().getMessage();
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}

					else {
						message = "Please fix the following errors:";
						for (int i = 0; i < size; i++) {
							message += "\n"+ (i+1) + "." +exceptions.get(i).getMessage();
						}
						JOptionPane.showMessageDialog(displayPanel, message,"Validation error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		
	}
	
	
	//************************************************************************//
	//************************************************************************//
	//************************************************************************//
	
	
    // Method For To Print Panel Contents
    private void printRecord(JPanel panel){
        // Create PrinterJob Here
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        // Set Printer Job Name
        printerJob.setJobName("Print Record");
        // Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D)graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.8, 0.8);
                
                // Now paint panel as graphics2D
                panel.paint(graphics2D);
                
                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if(returningResult){
            // Use try catch exeption for failure
            try{
                // Now call print method inside printerJob to print
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
    
    public static String capitalizeWord(String str){  
        String words[]=str.split("\\s");  
        String capitalizeWord="";  
        for(String w:words){  
            String first=w.substring(0,1);  
            String afterfirst=w.substring(1);  
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
        }  
        return capitalizeWord.trim();  
    }
}