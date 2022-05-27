package com.progetto;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MainFrame extends JFrame {

	private static final String url = "jdbc:mysql://didattica.liceocuneo.it:3306/db5F?serverTimezone=Europe/Rome";
	private static final String user = "quintaf";
	private static final String password = "iwish10";

	private JSplitPane pannello;
	private JTable tab;
	private DefaultTableModel tabMod;
	private JScrollPane scrollPane;
	private Pannello pannelloDx;
	private JMenuBar barraMenu;

	public MainFrame() {
		super("FBI");

		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	public void initComponent() {
		tabMod = new DefaultTableModel(new String[] { "Nome", "Cognome", "DataNascita","Crimini" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tab = new JTable(tabMod);

		// Interfaccia
		scrollPane = new JScrollPane(tab);
		pannelloDx = new Pannello();
		JTableHeader anHeader = tab.getTableHeader();
		anHeader.setForeground(new Color(0).WHITE);
		anHeader.setBackground(new Color(50, 95, 149));

		pannello = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, pannelloDx);

		pannello.setOneTouchExpandable(true);
		pannello.setDividerLocation(950);
		pannello.setContinuousLayout(true);
		add(pannello);

		// Inserimento
		barraMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu menuAggiungi = new JMenu("Aggiungi");
		JMenuItem itemAggiungiCriminale = new JMenuItem("Criminale");
		itemAggiungiCriminale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DialogInserisciCriminale finestra = new DialogInserisciCriminale(MainFrame.this, true);
				finestra.setVisible(true);
				MainFrame.this.salvaCriminale(finestra.getCriminaleInserito());
				MainFrame.this.visualizzaElenco();
			}
		});
		menuAggiungi.add(itemAggiungiCriminale);
		menu.add(menuAggiungi);

		// visualizzazione criminali
		JMenu menuVisualizza = new JMenu("Visualizza");
		JMenuItem itemVisualizzaCriminali = new JMenuItem("Criminali");
		itemVisualizzaCriminali.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				visualizzaElenco();
			}
		});
		menuVisualizza.add(itemVisualizzaCriminali);
		menu.add(menuVisualizza);

		// visualizzazione crimini
		tab.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					int index = table.getSelectedRow();
					ElencoCriminali elenco = getElencoCriminali();

					if (index >= 0) {
						Criminale criminale = elenco.get(index);
						pannelloDx.visualizzaDettagliCriminale(criminale);
					}
				}
			}
		});
		barraMenu.add(menu);

		setJMenuBar(barraMenu);
	}

	public void salvaCriminale(Criminale criminale) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			if (criminale.getId() <= 0) {
				stmt = conn.prepareStatement("INSERT INTO CD_Criminale (Nome, Cognome, DataNascita, Foto) VALUES (?,?,?,?)");
				stmt.setString(1, criminale.getNome());
				stmt.setString(2, criminale.getCognome());
				stmt.setDate(3, criminale.getDataNascita());
				stmt.setString(4, criminale.getFotoByte());
			}

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

	public void setNumCrimini() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement("select id_Criminale,count(*) AS ConteggioCrimini from db5F.CD_Crimine GROUP BY id_Criminale");
			res = stmt.executeQuery();

			int riga =0;
			while (res.next()) {
				tab.setValueAt(res.getInt("ConteggioCrimini"), riga, 3);
				riga++;
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
		
	}

	public void eliminaCriminale(Crimine criminale) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement("DELETE FROM CD_Criminale WHERE Id = ?");
			stmt.setInt(1, criminale.getId());

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

	public void visualizzaElenco() {
		ElencoCriminali elenco = getElencoCriminali();
		tabMod.setNumRows(0);

		for (int i=0; i<elenco.size();i++) {
			tabMod.addRow(elenco.get(i).toArrayString());
		}
		setNumCrimini();
		
	}

	public ElencoCriminali getElencoCriminali() {
		ElencoCriminali elenco = new ElencoCriminali();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.prepareStatement("SELECT * FROM CD_Criminale");
			res = stmt.executeQuery();

			while (res.next()) {
				Criminale criminale = new Criminale();
				criminale.setId(res.getInt("id"));
				criminale.setNome(res.getString("Nome"));
				criminale.setCognome(res.getString("Cognome"));
				criminale.setDataNascita(res.getDate("DataNascita"));
				criminale.setFotoByte(res.getString("Foto"));
				elenco.add(criminale);
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

	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);
		

	}
	
	/*   String dirName="C:\\";
        ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
        BufferedImage img=ImageIO.read(new File(dirName,"rose.jpg"));
        ImageIO.write(img, "jpg", baos);
        baos.flush();

        String base64String=Base64.encode(baos.toByteArray());
        baos.close();

        byte[] bytearray = Base64.decode(base64String);

        BufferedImage imag=ImageIO.read(new ByteArrayInputStream(bytearray));
        ImageIO.write(imag, "jpg", new File(dirName,"snap.jpg"));*/

}
