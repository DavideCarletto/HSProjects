package liceocuneo.backend;

import java.util.ArrayList;

public class ElencoInfo extends ArrayList<Info> {
	
	public void aggiungiInfo(Info info) {
		if(info!= null) {
			add(info);
		}
	}
	
	
}
