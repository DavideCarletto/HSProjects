package liceocuneo.esercizio;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{

	
	private DefaultTableModel tabMod;
	private JTable tab;
	private JMenuBar barraMenu;
	
	public MainFrame() {
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}
	
	public void initComponent() {
		tabMod = new DefaultTableModel(new String[] {"codice","descrizione","prezzo"},0);
		tab = new JTable(tabMod);
		JScrollPane pane = new JScrollPane(tab);
		add(pane);
		
		barraMenu = new JMenuBar();
		
		JMenu menu 	= new JMenu("menu");
		JMenuItem itemRicerca = new JMenuItem("cerca ricetta");
		
	}
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);
	}
}
