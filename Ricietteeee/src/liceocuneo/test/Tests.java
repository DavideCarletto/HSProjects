/**
 * 
 */
package liceocuneo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import liceocuneo.Ricettario.Ingrediente;
import liceocuneo.Ricettario.MainFrame;
import liceocuneo.Ricettario.Ricetta;

/**
 * @author DavidePC
 *
 */
class Tests {

	/**
	 * Test method for {@link liceocuneo.Ricettario.ElencoRicette#ricercaRicette(liceocuneo.Ricettario.Ingrediente)}.
	 */
	@Test
	void testRicercaRicette() {
		MainFrame main = new MainFrame();
		Ingrediente cipolla  = main.getCipolla();
		ArrayList<Ricetta> ricetteConCipolla = main.getElencoRicette().ricercaRicette(cipolla);

		assertEquals(2, ricetteConCipolla.size());
	}

}
