package liceocuneo.frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import liceocuneo.backend.CovidFactory;
import liceocuneo.backend.CovidService;
import liceocuneo.backend.ElencoInfo;
import liceocuneo.backend.Info;

public class MainFrame extends JFrame {

	private JMenuItem caricaFile;
	private JMenuItem visualizzaGrafico;
	private CovidService serv;
	private ElencoInfo elencoInfo;
	
	public MainFrame() {
		setTitle("COVID-19");

		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}

	public void initComponent() {
		this.getContentPane().setBackground(Color.white);
		setMenu();
		serv = CovidFactory.covidServiceFactory();
		caricaFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser("C:\\Users\\Davide Carletto\\Desktop\\Info5F\\CarlettoDavide\\Workspace 5F\\COVID-19\\COVID-19-master");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("File Csv", "csv");
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.addChoosableFileFilter(filter);
				
				int returnVal = chooser.showSaveDialog(MainFrame.this);
				
				if (returnVal == chooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					elencoInfo = serv.leggiCsv(file);
					serv.caricaDatiDb(elencoInfo);
				}
			}
		});
		
		visualizzaGrafico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFreeChart chart = serv.getChart();
				ChartPanel panel = new ChartPanel(chart);
				panel.setSize(500,500);
				add(panel);
				SwingUtilities.updateComponentTreeUI(MainFrame.this);
			}
		});
	}

	public void setMenu() {
		JMenuBar barra = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenu menuFile = new JMenu("File");
		JMenu menuVisualizza = new JMenu("Visualizza");
		caricaFile = new JMenuItem("Carica file csv");
		visualizzaGrafico = new JMenuItem("Grafico");
		
		menuFile.add(caricaFile);
		menuVisualizza.add(visualizzaGrafico);
		menu.add(menuFile);
		menu.add(menuVisualizza);
		barra.add(menu);
		setJMenuBar(barra);
	}

	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setVisible(true);

	}
}
