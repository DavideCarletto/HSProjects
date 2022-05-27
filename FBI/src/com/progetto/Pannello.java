package com.progetto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Pannello extends JPanel {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it:3306/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";

	private JTextField fieldId;
	private JTextField fieldNome;
	private JTextField fieldCognome;
	private JTextField fieldDataNascita;
	private JTable tab;
	private DefaultTableModel tabMod;
	private JButton addBtn;
	private JButton salvaBtn;
	private JButton eliminaBtn;
	private JLabel labelFoto;
	private ElencoCrimini elencoCrimini;

	public Pannello() {
		setBackground(Color.white);
	}

	public void visualizzaDettagliCriminale(Criminale criminale) {
		this.removeAll();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);

		JLabel labelId = new JLabel("id:");
		labelId.setFont(new Font(labelId.getFont().getName(), labelId.getFont().getStyle(), 20));
		layout.putConstraint(SpringLayout.NORTH, labelId, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, labelId, 65, SpringLayout.WEST, this);
		fieldId = new JTextField(10);
		fieldId.setEditable(false);
		fieldId.setText(String.valueOf(criminale.getId()));
		layout.putConstraint(SpringLayout.NORTH, fieldId, 5, SpringLayout.NORTH, labelId);
		layout.putConstraint(SpringLayout.WEST, fieldId, 200, SpringLayout.EAST, labelId);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font(labelNome.getFont().getName(), labelNome.getFont().getStyle(), 20));
		layout.putConstraint(SpringLayout.NORTH, labelNome, 20, SpringLayout.SOUTH, labelId);
		layout.putConstraint(SpringLayout.WEST, labelNome, 0, SpringLayout.WEST, labelId);
		fieldNome = new JTextField(10);
		fieldNome.setText(criminale.getNome());
		layout.putConstraint(SpringLayout.NORTH, fieldNome, 5, SpringLayout.NORTH, labelNome);
		layout.putConstraint(SpringLayout.WEST, fieldNome, 0, SpringLayout.WEST, fieldId);

		JLabel labelCognome = new JLabel("Cognome:");
		labelCognome.setFont(new Font(labelCognome.getFont().getName(), labelCognome.getFont().getStyle(), 20));
		layout.putConstraint(SpringLayout.NORTH, labelCognome, 20, SpringLayout.SOUTH, labelNome);
		layout.putConstraint(SpringLayout.WEST, labelCognome, 0, SpringLayout.WEST, labelNome);
		fieldCognome = new JTextField(10);
		fieldCognome.setText(criminale.getCognome());
		layout.putConstraint(SpringLayout.NORTH, fieldCognome, 5, SpringLayout.NORTH, labelCognome);
		layout.putConstraint(SpringLayout.WEST, fieldCognome, 0, SpringLayout.WEST, fieldNome);

		JLabel labelDataNascita = new JLabel("Data di Nascita:");
		labelDataNascita
				.setFont(new Font(labelDataNascita.getFont().getName(), labelDataNascita.getFont().getStyle(), 20));
		layout.putConstraint(SpringLayout.NORTH, labelDataNascita, 20, SpringLayout.SOUTH, labelCognome);
		layout.putConstraint(SpringLayout.WEST, labelDataNascita, 0, SpringLayout.WEST, labelCognome);
		fieldDataNascita = new JTextField(10);
		fieldDataNascita.setText(criminale.getDataNascita().toString());
		layout.putConstraint(SpringLayout.NORTH, fieldDataNascita, 5, SpringLayout.NORTH, labelDataNascita);
		layout.putConstraint(SpringLayout.WEST, fieldDataNascita, 0, SpringLayout.WEST, fieldCognome);

		tabMod = new DefaultTableModel(new String[] { "Nome", "Descrizione", "Data Crimine" }, 0);
		tab = new JTable(tabMod);
		JScrollPane scroll = new JScrollPane(tab);
		scroll.setPreferredSize(new Dimension(840, 400));
		layout.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.SOUTH, labelDataNascita);
		layout.putConstraint(SpringLayout.WEST, scroll, 0, SpringLayout.WEST, labelDataNascita);
		JTableHeader anHeader = tab.getTableHeader();
		anHeader.setForeground(Color.WHITE);
		anHeader.setBackground(new Color(50, 95, 149));

		labelFoto = new JLabel();
		byte[]bytearray  = Base64.getDecoder().decode(criminale.getFotoByte());
		ImageIcon icon = new ImageIcon(bytearray);
		Image image = icon.getImage();

		labelFoto.setIcon(new ImageIcon(image.getScaledInstance(165, 165, 0)));
		layout.putConstraint(SpringLayout.NORTH, labelFoto, 0, SpringLayout.NORTH, fieldId);
		layout.putConstraint(SpringLayout.WEST, labelFoto, 275, SpringLayout.EAST, fieldId);
		add(labelFoto);

		salvaBtn = new JButton("Salva");
		salvaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				elencoCrimini = getElencoCrimini(criminale.getId());
				for (int i = 0; i < tabMod.getRowCount(); i++) {
					Crimine crimine = null;

					if (i < elencoCrimini.size()) {
						crimine = elencoCrimini.get(i);
						crimine.setNome((String) tab.getValueAt(i, 0));
						crimine.setDescrizione((String) tab.getValueAt(i, 1));
						String dataS = (String) tab.getValueAt(i, 2);
						Date data = Date.valueOf(dataS);
						crimine.setDataCrimine(data);
						salvaCrimine(crimine, criminale.getId());
					} else {
						int valore = 1;

						if (elencoCrimini.size() <= 0) {
							valore = 0;
						}
						crimine = new Crimine();
						crimine.setNome((String) tab.getValueAt((elencoCrimini.size() - valore) + i, 0));
						crimine.setDescrizione((String) tab.getValueAt((elencoCrimini.size() - valore) + i, 1));
						String dataS = (String) tab.getValueAt((elencoCrimini.size() - valore) + i, 2);
						Date data = Date.valueOf(dataS);
						crimine.setDataCrimine(data);
						salvaCrimine(crimine, criminale.getId());
						elencoCrimini.add(crimine);
					}
					aggiornaDatiCriminale(criminale);
				}

			}
		});
		layout.putConstraint(SpringLayout.NORTH, salvaBtn, 15, SpringLayout.SOUTH, scroll);
		layout.putConstraint(SpringLayout.EAST, salvaBtn, 0, SpringLayout.EAST, scroll);

		addBtn = new JButton("Aggiungi");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabMod.setRowCount(tabMod.getRowCount() + 1);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, addBtn, 15, SpringLayout.SOUTH, scroll);
		layout.putConstraint(SpringLayout.EAST, addBtn, -20, SpringLayout.WEST, salvaBtn);

		if (getElencoCrimini(criminale.getId()) != null) {
			visualizzaElenco(criminale.getId());
		}

		tab.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					eliminaDaTabella(criminale);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		eliminaBtn = new JButton("Elimina");
		eliminaBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminaDaTabella(criminale);
			}
		});
		layout.putConstraint(SpringLayout.NORTH, eliminaBtn, 15, SpringLayout.SOUTH, scroll);
		layout.putConstraint(SpringLayout.WEST, eliminaBtn, 0, SpringLayout.WEST, scroll);

		add(labelId);
		add(fieldId);
		add(labelNome);
		add(fieldNome);
		add(labelCognome);
		add(fieldCognome);
		add(labelDataNascita);
		add(fieldDataNascita);
		add(scroll);
		add(salvaBtn);
		add(addBtn);
		add(eliminaBtn);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void visualizzaElenco(int idCriminale) {
		elencoCrimini = getElencoCrimini(idCriminale);
		tabMod.setNumRows(0);

		for (Crimine crimine : elencoCrimini) {

			tabMod.addRow(crimine.toArrayString());
		}
	}

	public void eliminaDaTabella(Criminale criminale) {
		elencoCrimini = getElencoCrimini(criminale.getId());
		Crimine crimine = elencoCrimini.get(tab.getSelectedRow());
		eliminaCrimine(crimine);
		elencoCrimini.remove(crimine);
		tabMod.setRowCount(0);
		for (int i = 0; i < elencoCrimini.size(); i++) {
			tabMod.addRow(elencoCrimini.get(i).toArrayString());
		}
	}

	public ElencoCrimini getElencoCrimini(int idCriminale) {
		ElencoCrimini elenco = new ElencoCrimini();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement("SELECT * FROM CD_Crimine WHERE id_Criminale = ?");
			stmt.setInt(1, idCriminale);
			res = stmt.executeQuery();

			while (res.next()) {
				Crimine crimine = new Crimine();
				crimine.setId(res.getInt("id"));
				crimine.setNome(res.getString("Nome"));
				crimine.setDescrizione(res.getString("Descrizione"));
				crimine.setDataCrimine(res.getDate("DataCrimine"));

				elenco.add(crimine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException exc) {
			}
		}
		return elenco;
	}

	public void aggiornaDatiCriminale(Criminale criminale) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			if (criminale.getId() > 0) {
				stmt = conn.prepareStatement("UPDATE CD_Criminale SET Nome =?, Cognome =?, DataNascita =? WHERE id =?");

			}
			stmt.setString(1, fieldNome.getText());
			stmt.setString(2, fieldCognome.getText());
			stmt.setDate(3, Date.valueOf(fieldDataNascita.getText()));
			stmt.setInt(4, criminale.getId());

			stmt.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void salvaCrimine(Crimine crimine, int idCriminale) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			if (crimine.getId() <= 0) {
				stmt = conn.prepareStatement(
						"INSERT INTO CD_Crimine (Nome, Descrizione, DataCrimine, id_Criminale ) VALUES (?,?,?,?)");

			} else {
				stmt = conn.prepareStatement(
						"UPDATE CD_Crimine SET Nome =?, Descrizione =?, DataCrimine=?, id_Criminale=? WHERE id = ?");
				stmt.setInt(5, crimine.getId());
			}
			stmt.setString(1, crimine.getNome());
			stmt.setString(2, crimine.getDescrizione());
			stmt.setDate(3, crimine.getDataCrimine());
			stmt.setInt(4, idCriminale);
			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException exc) {
			}
		}
	}

	public void eliminaCrimine(Crimine crimine) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement("DELETE FROM CD_Crimine WHERE Id = ?");
			stmt.setInt(1, crimine.getId());

			stmt.executeUpdate();

		} catch (Exception e) {
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException exc) {
			}
		}
	}

}
