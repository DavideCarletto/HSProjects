package esercizio1.frontend;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import esercizio1.backend.ElencoInformazioni;
import esercizio1.backend.PopolazioneFactory;
import esercizio1.backend.PopolazioneService;

public class MainFrame extends JFrame{

	private ElencoInformazioni elencoInfo;
	private JTable tab;
	private DefaultTableModel tabMod;
	
	
	public MainFrame() {
		elencoInfo = new ElencoInformazioni();
		
		setLayout(new FlowLayout());
		setExtendedState(MAXIMIZED_BOTH);
		initComponent();
	}
	public void initComponent() {
		DefaultTableModel tabMod = new DefaultTableModel(new String[]{"Stato", "Popolazione","Anno"},0);
		tab = new JTable(tabMod);
		PopolazioneService serv = PopolazioneFactory.PopolazioneFactory();
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("file");
		JMenuItem itemImporta = new  JMenuItem("importa");
		JMenuItem itemVisualizzaTab = new  JMenuItem("visualizzaTabella");
		itemImporta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			elencoInfo = serv.leggiDati(new File("C:\\Users\\Davide Carletto\\Documents\\Popolazione.csv"));
			serv.caricaSuDb(elencoInfo);
			}
		});
		itemVisualizzaTab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ElencoInformazioni elenco = serv.leggiDatiOrdinati(false);
				for(int i=0; i<elenco.size(); i++) {
					tabMod.addRow(elenco.get(i).toArrayString());
				}
			}
		});
		menu.add(itemVisualizzaTab);
		menu.add(itemImporta);
		barra.add(menu);
		setJMenuBar(barra);
	}
	
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main .setVisible(true);
	}
}

