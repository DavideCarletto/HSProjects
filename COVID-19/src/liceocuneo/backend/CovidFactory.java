package liceocuneo.backend;

public class CovidFactory {

	public static CovidService covidServiceFactory() {
		CovidService serv = (CovidService) new CovidServiceImpl();

		return serv;
	}
}
