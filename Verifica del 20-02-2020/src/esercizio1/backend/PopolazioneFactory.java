package esercizio1.backend;

public class PopolazioneFactory {

	
	public static PopolazioneService PopolazioneFactory() {
		PopolazioneService serviceImpl = (PopolazioneService)new PopolazioneServiceImpl();
		return serviceImpl;
	}
}
