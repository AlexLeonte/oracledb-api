package api_core;

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
	public InputDevice id;
	JTextArea textAreaMain;
	
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
		id = new InputDevice();
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOracledpapi = new JFrame();
		frmOracledpapi.setTitle("Oracle Database API (client)");
		frmOracledpapi.setBounds(2000, 100, 1200, 566);
		frmOracledpapi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOracledpapi.getContentPane().setLayout(null);
		
		JButton btnStatus = new JButton("Connect to a database specific schema");
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAreaMain.setText(id.getDbConnectionStatus());
			}
		});
		btnStatus.setBounds(12, 77, 330, 25);
		frmOracledpapi.getContentPane().add(btnStatus);
		
		textAreaMain = new JTextArea();
		textAreaMain.setBounds(483, 0, 678, 479);
		frmOracledpapi.getContentPane().add(textAreaMain);
		
		JButton buttonStatus = new JButton("List DB schema structure:");
		buttonStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonStatus.setBounds(12, 114, 330, 25);
		frmOracledpapi.getContentPane().add(buttonStatus);
		
		JButton btnNewButton_2 = new JButton("List table structure:");
		btnNewButton_2.setBounds(12, 182, 238, 25);
		frmOracledpapi.getContentPane().add(btnNewButton_2);
		
		TextField textField = new TextField();
		textField.setBounds(87, 11, 163, 27);
		frmOracledpapi.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Database:");
		lblNewLabel.setBounds(12, 23, 163, 15);
		frmOracledpapi.getContentPane().add(lblNewLabel);
		
		JLabel lblSchema = new JLabel("Schema:");
		lblSchema.setBounds(12, 50, 70, 15);
		frmOracledpapi.getContentPane().add(lblSchema);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(87, 44, 163, 25);
		frmOracledpapi.getContentPane().add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(87, 145, 155, 25);
		frmOracledpapi.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("Table:");
		lblNewLabel_1.setBounds(22, 151, 70, 15);
		frmOracledpapi.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("List table data");
		btnNewButton.setBounds(258, 182, 213, 25);
		frmOracledpapi.getContentPane().add(btnNewButton);
		
		JLabel lblQuery = new JLabel("Query:");
		lblQuery.setBounds(22, 219, 47, 15);
		frmOracledpapi.getContentPane().add(lblQuery);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(75, 219, 402, 27);
		frmOracledpapi.getContentPane().add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Execute");
		btnNewButton_1.setBounds(12, 255, 117, 25);
		frmOracledpapi.getContentPane().add(btnNewButton_1);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(22, 233, 70, 15);
		frmOracledpapi.getContentPane().add(lblFile);
		
	}
}
