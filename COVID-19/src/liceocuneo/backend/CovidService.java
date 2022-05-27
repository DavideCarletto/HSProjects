package liceocuneo.backend;

import java.io.File;

import org.jfree.chart.JFreeChart;

public interface CovidService {

	public ElencoInfo leggiCsv(File f);
	public void caricaDatiDb(ElencoInfo elencoInfo); 
	public JFreeChart getChart();
}
