import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

	private DefaultTableModel tabMod;
	private JTable tab;
	private ElencoRicette elencoRicette;
	public MainFrame() {
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		elencoRicette = new ElencoRicette();
		initComponent();
	}

	public void initComponent() {

		tabMod = new DefaultTableModel(new String[] { "Nome", "Descrizione", "Ingrediente" }, 0);
		tab = new JTable(tabMod);
		JScrollPane scroll = new JScrollPane(tab);
		add(scroll);
		
		Ingrediente cipolla  = new Ingrediente("cipolla");
		Ingrediente pomodoro  = new Ingrediente("pomodoro");
		Ingrediente farina  = new Ingrediente("farina");
		Ingrediente cacao  = new Ingrediente("cacao");
		Ingrediente curcuma  = new Ingrediente("curcuma");
		
		Ricetta r1 = new Ricetta("ragu","ciao eddy mi puzza il pube", 50);
		r1.aggiungiIngrediente(cipolla, 23f);
		r1.aggiungiIngrediente(pomodoro, 23f);
		r1.aggiungiIngrediente(cacao, 23f);
		
		Ricetta r2 = new Ricetta("pennarello","ciao eddy mi puzza il pube", 70);
		r2.aggiungiIngrediente(farina, 23f);
		
		elencoRicette.aggiungiRicetta(r1);
		elencoRicette.aggiungiRicetta(r2);
		
		ArrayList<Ricetta> ricette = elencoRicette.get(cipolla);
		
		for(int i=0; i<ricette.size();i++) {
			tabMod.addRow(ricette.get(i).toArrayString());
		}
		
	}

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);

	}

}
