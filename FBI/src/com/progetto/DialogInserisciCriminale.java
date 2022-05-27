package com.progetto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.cj.jdbc.util.BaseBugReport;
import com.mysql.cj.util.Base64Decoder;

public class DialogInserisciCriminale extends JDialog {

	private JTextField fieldNome;
	private JTextField fieldCognome;
	private JTextField fieldDataNascita;
	private JButton foto;
	private JButton salva;
	private String fotoString;
	private Criminale criminaleInserito;

	public DialogInserisciCriminale(MainFrame owner, boolean modale) {
		super(owner, modale);

		setSize(600, 450);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new FlowLayout());

		initComponent();
	}

	public void initComponent() {
		add(new JLabel("Nome"));
		fieldNome = new JTextField(10);
		add(fieldNome);
		add(new JLabel("Cognome"));
		fieldCognome = new JTextField(10);
		add(fieldCognome);
		fieldDataNascita = new JTextField(10);
		add(new JLabel("Data di nascita"));
		add(fieldDataNascita);

		foto = new JButton("foto");
		foto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser("D:\\foto\\Foto Montagna");
				int returnVal = chooser.showSaveDialog(DialogInserisciCriminale.this);

				if (returnVal == chooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					BufferedImage img;
					try {
						img = ImageIO.read(file);
						ImageIO.write(img, "jpg", baos);
						fotoString = Base64.getEncoder().encodeToString(baos.toByteArray());
//						byte[]decodedBytes  = Base64.getDecoder().decode(fotoString);
//						String decode = new String(decodedBytes);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		add(foto);

		salva = new JButton("salva");
		salva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				criminaleInserito = new Criminale();
				criminaleInserito.setNome(fieldNome.getText());
				criminaleInserito.setCognome(fieldCognome.getText());
				String dataNascitaString = fieldDataNascita.getText();
				Date dataNascita = Date.valueOf(dataNascitaString);
				criminaleInserito.setDataNascita(dataNascita);
				criminaleInserito.setFotoByte(fotoString);
				DialogInserisciCriminale.this.dispose();
			}
		});
		add(salva);

	}

	public Criminale getCriminaleInserito() {
		return criminaleInserito;
	}

}
