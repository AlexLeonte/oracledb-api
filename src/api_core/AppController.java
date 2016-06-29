package api_core;
import api_support.AppEngine;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.TextField;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AppController {

	private JFrame frmOracledpapi;
	private AppEngine  engine;
	
	private JTextArea textAreaMain;
	InputDevice id; 
	
	private TextField inputDatabaseName;
	private TextField inputUserName;
	private JTextField inputPassword;
	private JTextField inputPort;
	private JTextField inputHostName;
	
	private TextField inputQueryFile;
	TextField inputTableName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppController window = new AppController();
					window.frmOracledpapi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public AppController() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOracledpapi = new JFrame();
		frmOracledpapi.setTitle("Oracle Database API (client)");
		frmOracledpapi.setBounds(2000, 100, 1000, 566);
		frmOracledpapi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOracledpapi.getContentPane().setLayout(null);
		frmOracledpapi.setLocationRelativeTo(null);
		JButton startConnection = new JButton("Connect to a database specific schema");
		startConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//create connection
				id = new InputDevice(inputHostName.getText(), inputPort.getText(), inputDatabaseName.getText(),  inputUserName.getText(), inputPassword.getText());
				
				textAreaMain.append("\n" + id.toString() + "\n++++++++\n+");
				
				if(id.connectedSucces() == true){
					 engine = new AppEngine(id.getDBStatement());
				}else{
					
				}
				
				
			}
		});
		startConnection.setBounds(12, 108, 330, 25);
		frmOracledpapi.getContentPane().add(startConnection);
		

		textAreaMain = new JTextArea("WELCOME TO ORACLEDB-API ! \n");
		textAreaMain.setBounds(483, 0, 678, 479);
		textAreaMain.setEditable(false);
		
		frmOracledpapi.getContentPane().add(textAreaMain);
		
		
		JButton buttonStatus = new JButton("List DB schema structure:");
		buttonStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonStatus.setBounds(12, 145, 330, 25);
		frmOracledpapi.getContentPane().add(buttonStatus);
		
		JButton btnNewButton_2 = new JButton("List table structure:");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textAreaMain.append("\n" + engine.listTableStructure(inputTableName.getText() )+ "+\n++++++++\n+");
			}
		});
		btnNewButton_2.setBounds(22, 207, 238, 25);
		frmOracledpapi.getContentPane().add(btnNewButton_2);
		
		inputDatabaseName = new TextField();
		inputDatabaseName.setBounds(95, 77, 155, 25);
		frmOracledpapi.getContentPane().add(inputDatabaseName);
		
		JLabel lblNewLabel = new JLabel("Database:");
		lblNewLabel.setBounds(12, 87, 163, 15);
		frmOracledpapi.getContentPane().add(lblNewLabel);
		
		JLabel lblSchema = new JLabel("User:");
		lblSchema.setBounds(12, 50, 70, 15);
		frmOracledpapi.getContentPane().add(lblSchema);
		
		inputUserName = new TextField();
		inputUserName.setBounds(87, 44, 163, 25);
		frmOracledpapi.getContentPane().add(inputUserName);
		
		inputTableName = new TextField();
		inputTableName.setBounds(65, 176, 155, 25);
		frmOracledpapi.getContentPane().add(inputTableName);
		
		JLabel lblNewLabel_1 = new JLabel("Table:");
		lblNewLabel_1.setBounds(12, 182, 70, 15);
		frmOracledpapi.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("List table data");
		btnNewButton.setBounds(262, 207, 213, 25);
		frmOracledpapi.getContentPane().add(btnNewButton);
		
		JLabel lblQuery = new JLabel("Query:");
		lblQuery.setBounds(12, 244, 47, 15);
		frmOracledpapi.getContentPane().add(lblQuery);
		
		inputQueryFile = new TextField();
		inputQueryFile.setBounds(54, 259, 402, 27);
		frmOracledpapi.getContentPane().add(inputQueryFile);
		
		JButton btnNewButton_1 = new JButton("Execute");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
				textAreaMain.append("\n" + engine.executeQueryFile(inputQueryFile.getText()) + "+\n++++++++\n+");
				}catch(Exception e){
					textAreaMain.append("lol");
				}
			}
		});
		btnNewButton_1.setBounds(12, 292, 117, 25);
		frmOracledpapi.getContentPane().add(btnNewButton_1);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(12, 271, 70, 15);
		frmOracledpapi.getContentPane().add(lblFile);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(262, 45, 88, 25);
		frmOracledpapi.getContentPane().add(lblNewLabel_2);
		
		inputPassword = new JTextField();
		inputPassword.setBounds(349, 47, 126, 21);
		frmOracledpapi.getContentPane().add(inputPassword);
		inputPassword.setColumns(10);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(283, 22, 70, 15);
		frmOracledpapi.getContentPane().add(lblPort);
		
		inputPort = new JTextField();
		inputPort.setBounds(349, 18, 126, 23);
		frmOracledpapi.getContentPane().add(inputPort);
		inputPort.setColumns(10);
		
		JLabel lblIp = new JLabel("Hostname:");
		lblIp.setBounds(12, 14, 107, 24);
		frmOracledpapi.getContentPane().add(lblIp);
		
		inputHostName = new JTextField();
		inputHostName.setBounds(91, 12, 159, 26);
		frmOracledpapi.getContentPane().add(inputHostName);
		inputHostName.setColumns(10);
		
	}
}
