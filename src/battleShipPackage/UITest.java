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
	public void testStartExitButtons() {
		/*
		 * Checks if the start and exit buttons are enabled.
		 */
		UI inter = new UI();
		
		assertEquals(true, UI.getNewGame().isEnabled());
		//Exit button
		assertEquals(true, inter.getExitGame().isEnabled());
	}


	@Test
	public void testInitialMatrixValues() {
		/*
		 * Checks if initial button matrix is created correctly with the constructor.
		 */
		UI inter = new UI();
		
		//Board columns limits
		assertEquals(false, UI.getBattleship()[9][1].isEnabled());
		assertEquals(false, UI.getBattleship()[0][1].isEnabled());
		assertEquals(false, UI.getBattleship()[9][8].isEnabled());
		assertEquals(false, UI.getBattleship()[0][8].isEnabled());
		
		//Board rows limits
		assertEquals(false, UI.getBattleship()[1][9].isEnabled());
		assertEquals(false, UI.getBattleship()[1][0].isEnabled());
		assertEquals(false, UI.getBattleship()[8][9].isEnabled());
		assertEquals(false, UI.getBattleship()[8][0].isEnabled());
		
		//Board corner limits
		assertEquals(false, UI.getBattleship()[0][0].isEnabled());
		assertEquals(false, UI.getBattleship()[9][9].isEnabled());
		assertEquals(false, UI.getBattleship()[0][9].isEnabled());
		assertEquals(false, UI.getBattleship()[9][0].isEnabled());
		
		//Board central values
		assertEquals(false, UI.getBattleship()[4][4].isEnabled());
		assertEquals(false, UI.getBattleship()[4][5].isEnabled());
		assertEquals(false, UI.getBattleship()[5][4].isEnabled());
		assertEquals(false, UI.getBattleship()[5][5].isEnabled());
		
	}
	
	@Test
	public void testInitialGameStartedValues() {
		/*
		 * Checks if the grid has the buttons enabled and the color set to blue
		 */
		UI inter = new UI();
		inter.setInitialMatrix();
		
		//Board columns limits
		assertEquals(true, UI.getBattleship()[9][1].isEnabled());
		assertEquals(true, UI.getBattleship()[0][1].isEnabled());
		assertEquals(true, UI.getBattleship()[9][8].isEnabled());
		assertEquals(true, UI.getBattleship()[0][8].isEnabled());
		
		assertEquals(Color.BLUE, UI.getBattleship()[9][1].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][1].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][8].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][8].getBackground());
		
		//Board rows limits
		assertEquals(true, UI.getBattleship()[1][9].isEnabled());
		assertEquals(true, UI.getBattleship()[1][0].isEnabled());
		assertEquals(true, UI.getBattleship()[8][9].isEnabled());
		assertEquals(true, UI.getBattleship()[8][0].isEnabled());
		
		assertEquals(Color.BLUE, UI.getBattleship()[1][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[1][0].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[8][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[8][0].getBackground());
		
		//Board corner limits
		assertEquals(true, UI.getBattleship()[0][0].isEnabled());
		assertEquals(true, UI.getBattleship()[9][9].isEnabled());
		assertEquals(true, UI.getBattleship()[0][9].isEnabled());
		assertEquals(true, UI.getBattleship()[9][0].isEnabled());
		
		assertEquals(Color.BLUE, UI.getBattleship()[0][0].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][0].getBackground());
		
		//Board central values
		assertEquals(true, UI.getBattleship()[4][4].isEnabled());
		assertEquals(true, UI.getBattleship()[4][5].isEnabled());
		assertEquals(true, UI.getBattleship()[5][4].isEnabled());
		assertEquals(true, UI.getBattleship()[5][5].isEnabled());
	
		assertEquals(Color.BLUE, UI.getBattleship()[4][4].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[4][5].getBackground());	
		assertEquals(Color.BLUE, UI.getBattleship()[5][4].getBackground());	
		assertEquals(Color.BLUE, UI.getBattleship()[5][5].getBackground());	
			
	}
	
	@Test
	public void testStartButton() {
		/*
		 * Checks if the button start renews the game when clicked
		 */
		
		UI inter = new UI();
		inter.setInitialMatrix();
		//inter.emptyShips();
		
		//Places some ships
		inter.setShip(0, 0);
		inter.setShip(4, 5);
		inter.setShip(0, 1);
		inter.setShip(0, 9);
		inter.setShip(9, 0);
		inter.setShip(9, 1);
		//inter.setShip(9, 9);
		//Clicks the ships
		UI.getBattleship()[0][0].doClick();
		UI.getBattleship()[4][5].doClick();
		UI.getBattleship()[0][1].doClick();
		UI.getBattleship()[0][9].doClick();
		UI.getBattleship()[9][0].doClick();
		UI.getBattleship()[9][1].doClick();
		UI.getBattleship()[1][1].doClick();
		
		//Clicks outside the ships
		UI.getBattleship()[4][4].doClick();
		UI.getBattleship()[5][5].doClick();
		UI.getBattleship()[8][9].doClick();
		
		//Checks that in two positions there is the color needed,
		//RED
		assertEquals(Color.RED, UI.getBattleship()[0][0].getBackground());
		assertEquals(Color.RED, UI.getBattleship()[4][5].getBackground());
		assertEquals(Color.RED, UI.getBattleship()[0][1].getBackground());
		assertEquals(Color.RED, UI.getBattleship()[0][9].getBackground());
		assertEquals(Color.RED, UI.getBattleship()[9][0].getBackground());
		assertEquals(Color.RED, UI.getBattleship()[9][1].getBackground());
		//Yellow
		assertEquals(Color.YELLOW, UI.getBattleship()[4][4].getBackground());
		assertEquals(Color.YELLOW, UI.getBattleship()[5][5].getBackground());
		assertEquals(Color.YELLOW, UI.getBattleship()[8][9].getBackground());


		//Checks if, when start is clicked, everything turns blue again
		UI.getNewGame().doClick();
		//Board columns limits

		assertEquals(Color.BLUE, UI.getBattleship()[9][1].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][1].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][8].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][8].getBackground());
		
		//Board rows limits
		assertEquals(Color.BLUE, UI.getBattleship()[1][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[1][0].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[8][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[8][0].getBackground());
		
		//Board corner limits
		assertEquals(Color.BLUE, UI.getBattleship()[0][0].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[0][9].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[9][0].getBackground());
		
		//Board central values
		assertEquals(Color.BLUE, UI.getBattleship()[4][4].getBackground());
		assertEquals(Color.BLUE, UI.getBattleship()[4][5].getBackground());	
		assertEquals(Color.BLUE, UI.getBattleship()[5][4].getBackground());	
		assertEquals(Color.BLUE, UI.getBattleship()[5][5].getBackground());	

	}
	
	@Test
	public void testCounter() {
		UI inter = new UI();
		inter.setInitialMatrix();
		//inter.emptyShips();
		
		//Places some ships
		inter.setShip(0, 0);
		inter.setShip(4, 5);
		inter.setShip(0, 1);
		inter.setShip(0, 9);
		inter.setShip(9, 0);
		inter.setShip(9, 1);
		
		//Sets 10 bullets available
		UI.setBullets(10);
		
		//The initial bullets should be 10
		assertEquals(UI.bullets, 10);
		
		//If user makes 5 clicks, bullets should be 5
		UI.getBattleship()[0][0].doClick();
		UI.getBattleship()[4][5].doClick();
		UI.getBattleship()[0][1].doClick();
		UI.getBattleship()[0][9].doClick();
		UI.getBattleship()[9][0].doClick();

		assertEquals(UI.bullets, 5);
		
		//If user clicks again the same button, 
		//it shouldn't lower the bullets
		
		UI.getBattleship()[0][0].doClick();
		UI.getBattleship()[4][5].doClick();
		UI.getBattleship()[0][1].doClick();
		UI.getBattleship()[0][9].doClick();
		UI.getBattleship()[9][0].doClick();

		assertEquals(UI.bullets, 5);
		
		//If user makes 5 more clicks, should be 0
		UI.getBattleship()[3][3].doClick();
		UI.getBattleship()[1][0].doClick();
		UI.getBattleship()[5][4].doClick();
		UI.getBattleship()[1][1].doClick();
		UI.getBattleship()[9][9].doClick();

		assertEquals(UI.bullets, 0);
		
		//User should not be able to make more clicks
		//and bullets should continue to be 0
		//To do this, all the buttons gets
		//disabled when bullets reach to 0.
		UI.getBattleship()[4][4].doClick();
		UI.getBattleship()[8][8].doClick();

		
		//Checks again if buttons are disabled
		//Board columns limits
		assertEquals(false, UI.getBattleship()[9][1].isEnabled());
		assertEquals(false, UI.getBattleship()[0][1].isEnabled());
		assertEquals(false, UI.getBattleship()[9][8].isEnabled());
		assertEquals(false, UI.getBattleship()[0][8].isEnabled());
				
		//Board rows limits
		assertEquals(false, UI.getBattleship()[1][9].isEnabled());
		assertEquals(false, UI.getBattleship()[1][0].isEnabled());
		assertEquals(false, UI.getBattleship()[8][9].isEnabled());
		assertEquals(false, UI.getBattleship()[8][0].isEnabled());
		
		//Board corner limits
		assertEquals(false, UI.getBattleship()[0][0].isEnabled());
		assertEquals(false, UI.getBattleship()[9][9].isEnabled());
		assertEquals(false, UI.getBattleship()[0][9].isEnabled());
		assertEquals(false, UI.getBattleship()[9][0].isEnabled());
		
		//Board central values
		assertEquals(false, UI.getBattleship()[4][4].isEnabled());
		assertEquals(false, UI.getBattleship()[4][5].isEnabled());
		assertEquals(false, UI.getBattleship()[5][4].isEnabled());
		assertEquals(false, UI.getBattleship()[5][5].isEnabled());
		
		//And checks that bullets equal 0
		assertEquals(UI.bullets, 0);
		
		
		
	}
	
	@Test
	public void testInsertTextBox() {
		/*
		 * Checks if the text box is enabled before starting the game
		 * and disabled when the game has started
		 */
		
		UI inter = new UI();
		inter.setInitialMatrix();
		//inter.emptyShips();
		
		//Before starting the game, it is editable
		assertEquals(true, UI.getInsertTextBox().isEditable());
		
		//After starting the game, it is not editable
		UI.getNewGame().doClick();
		assertEquals(false, UI.getInsertTextBox().isEditable());
		
	}
	
	@Test
	public void testShowBulletsTextBox() {
		/*
		 * Checks if the bullets text box is always not editable
		 */
		
		UI inter = new UI();
		inter.setInitialMatrix();
		//inter.emptyShips();
		
		//Before starting the game, it is not editable nor enabled
		assertEquals(false, UI.getShowBulletsTextBox().isEditable());
		assertEquals(false, UI.getShowBulletsTextBox().isEnabled());
		
		//After starting the game, it is still not editable nor enabled
		UI.getNewGame().doClick();
		assertEquals(false, UI.getShowBulletsTextBox().isEditable());
		assertEquals(false, UI.getShowBulletsTextBox().isEnabled());
		
	}
	
	@Test
	public void testShipsCounter() {
		/*
		 * Checks if the ships counter counts everything
		 */
		UI inter = new UI();
		inter.setInitialMatrix();
		//inter.emptyShips();
		
		//Places 6 ships
		inter.setShip(0, 0);
		inter.setShip(4, 5);
		inter.setShip(0, 1);
		inter.setShip(0, 9);
		inter.setShip(9, 0);
		inter.setShip(9, 1);
		
		//Hits the 6 ships
		UI.getBattleship()[0][0].doClick();
		UI.getBattleship()[4][5].doClick();
		UI.getBattleship()[0][1].doClick();
		UI.getBattleship()[0][9].doClick();
		UI.getBattleship()[9][0].doClick();
		UI.getBattleship()[9][1].doClick();

		//The same amount of hits shout be returned
		assertEquals(6, inter.getHits());
		
		//If I place a ship in the same place, 
		//it shouldn't increase ship count
		//nor the hits counter
		inter.setShip(0, 0);
		inter.setShip(0, 0);
		inter.setShip(0, 0);
		assertEquals(6, inter.getHits());
		
		
	}
	
	@Test
	public void testHitsCounter() {
		/*
		 * Checks the hits counter
		 */
		UI inter = new UI();
		inter.setInitialMatrix();
		
		//Places 6 ships
		inter.setShip(0, 0);
		inter.setShip(4, 5);
		inter.setShip(0, 1);
		inter.setShip(0, 9);
		inter.setShip(9, 0);
		inter.setShip(9, 1);
				
		assertEquals(6, UI.getShipsCount());
		
		//If I place a ship in the same place, 
		//it shouldn't increase ship count
		inter.setShip(0, 0);
		inter.setShip(0, 0);
		inter.setShip(0, 0);
		assertEquals(6, UI.getShipsCount());
		
	}
	
	@Test
	public void checkWin() {
		/*
		 * Checks that a user can win
		 */
		UI inter = new UI();
		inter.setInitialMatrix();
		
		//Places 7 ships
		inter.setShip(0, 0);
		inter.setShip(4, 5);
		inter.setShip(0, 1);
		inter.setShip(0, 9);
		inter.setShip(9, 0);
		inter.setShip(9, 1);
		inter.setShip(5, 5);
		
		//Hits the 7 ships
		UI.getBattleship()[0][0].doClick();
		UI.getBattleship()[4][5].doClick();
		UI.getBattleship()[0][1].doClick();
		UI.getBattleship()[0][9].doClick();
		UI.getBattleship()[9][0].doClick();
		UI.getBattleship()[9][1].doClick();
		UI.getBattleship()[5][5].doClick();

		
		//As player hits all the ships, wins
		assertEquals(7, UI.getShipsCount());
		assertEquals(true, inter.checkWin());
		
		
	}
	
	@Test
	public void testActionPerformed() {
		/*
		 * Checks if the actions are performed correctly
		 */
		
	}
		
		

}











