package battleShipPackage;

import static org.junit.Assert.*;

import java.awt.Color;

/*

How to check colors

Color getter;
getter = getBattleship()[0][0].getBackground();

Color setter = Color.BLUE;

if (getter == setter) {
	...
	}


 */

import org.junit.Test;

public class UITest {

	@Test
	public void testInitialMatrixValues() {
		/*
		 * Checks if initial button matrix is created correctly with the constructor.
		 */
		UI inter = new UI();
		
		//inter.setInitialMatrix();
		
		//Board columns limits
		assertEquals(false, inter.getBattleship()[9][1].isEnabled());
		assertEquals(false, inter.getBattleship()[0][1].isEnabled());
		assertEquals(false, inter.getBattleship()[9][8].isEnabled());
		assertEquals(false, inter.getBattleship()[0][8].isEnabled());
		
		//Board rows limits
		assertEquals(false, inter.getBattleship()[1][9].isEnabled());
		assertEquals(false, inter.getBattleship()[1][0].isEnabled());
		assertEquals(false, inter.getBattleship()[8][9].isEnabled());
		assertEquals(false, inter.getBattleship()[8][0].isEnabled());
		
		//Board corner limits
		assertEquals(false, inter.getBattleship()[0][0].isEnabled());
		assertEquals(false, inter.getBattleship()[9][9].isEnabled());
		assertEquals(false, inter.getBattleship()[0][9].isEnabled());
		assertEquals(false, inter.getBattleship()[9][0].isEnabled());
		
		//Board central values
		assertEquals(false, inter.getBattleship()[4][4].isEnabled());
		assertEquals(false, inter.getBattleship()[4][5].isEnabled());
		assertEquals(false, inter.getBattleship()[5][4].isEnabled());
		assertEquals(false, inter.getBattleship()[5][5].isEnabled());
		
		//Start button
		assertEquals(true, inter.getNewGame().isEnabled());
		//Exit button
		assertEquals(true, inter.getExitGame().isEnabled());
		
	}
		
		

}
