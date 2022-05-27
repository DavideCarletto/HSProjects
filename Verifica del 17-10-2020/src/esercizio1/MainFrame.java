package esercizio1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MainFrame extends JFrame {

	public static final Logger logger = Logger.getLogger(MainFrame.class);
	private JButton buttonLogin;
	private JTextField fieldUtente;
	private JLabel labelUtente;
	private JTextField fieldPassword;
	private JLabel labelPassword;
	
	public MainFrame() {
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		initComponent();
	}
	
	public void initComponent() {
		buttonLogin = new  JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				labelUtente.setVisible(true);
				fieldUtente.setVisible(true);
				labelPassword.setVisible(true);
				fieldPassword.setVisible(true);
				buttonLogin.setVisible(false);
				
				JButton okBtn = new JButton("ok");
				MainFrame.this.add(okBtn);
				okBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String utente = fieldUtente.getText();
						String password = fieldPassword.getText();
						
						logger.info("utente:"+utente+", password:"+password);
					}
				});
			}
		});
		labelUtente = new JLabel("Utente:");
		fieldUtente = new  JTextField(30);
		labelPassword = new JLabel("Password:");
		fieldPassword = new JTextField(30);
	
		labelUtente.setVisible(false);
		fieldUtente.setVisible(false);
		labelPassword.setVisible(false);
		fieldPassword.setVisible(false);
		
		add(buttonLogin);
		add(labelUtente);
		add(fieldUtente);
		add(labelPassword);
		add(fieldPassword);
	}
	public static void main(String[] args) {
		MainFrame main =new MainFrame();
		main.setVisible(true);
	}

}
