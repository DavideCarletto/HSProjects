package Testare;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import liceocuneo.Studente;
import liceocuneo.TestArrays;

class Tests {
	static final Logger logger = Logger.getLogger(Tests.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCreaArrays() {
		TestArrays t = new TestArrays();
		ArrayList<Studente> elenco = t.creaArrays();
		assertEquals(1000001, elenco.size());
		logger.info("creazione arrays completata");
		
	}

}
