package battleShipPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JTextPane;



public class UI extends JFrame implements ActionListener {


	private static final long serialVersionUID = -7929093104965802853L;

	private JPanel contentPane;

	public static int hitsCounter = 0;
	public static JButton newGame;
	public static JButton exitGame;

	private static boolean win = false;
	private static int x = 10;
	private static int y = 10;
	private static int availableBullets = 20;
	private static boolean testMode = true;

	public static JButton[][] battleship;
	public static boolean[][] ships;
	public static int bullets;
	public static int shipsCount = 0;
	public static int knownShipsNumber = 2;

	public static JTextField insertTextBox;
	public static JTextField insertNameTextBox;
	private static JTextField bulletTextBoxValue;
	
	


	/**
	 * Create the frame.
	 */
	public UI() {
		
		//Sets the "Metal" look and feel to enable background same UI in every OS. 
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Metal is not available, you can set the GUI to another look and feel.
		}
		
		
		//General panel behavior and default size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Sets the number of bullets available
		setBullets(availableBullets);

		//Exit button
		setExitButton(new JButton("Exit"));
		getExitGame().addActionListener(this);
		getExitGame().setBounds(619, 6, 175, 29);
		contentPane.add(getExitGame());		
		
		//Start button
		setNewGame(new JButton("Start"));
		getNewGame().addActionListener(this);
		getNewGame().setBounds(6, 6, 227, 29);
		contentPane.add(getNewGame());

		//Panel that will contain all the grid buttons
		JPanel panel = new JPanel();
		panel.setBounds(6, 36, 788, 736);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 10, 1, 1));
		
		//Name text box
		setInsertTextBox(new JTextField("Name"));
		getInsertTextBox().setBounds(234, 8, 130, 26);
		contentPane.add(getInsertTextBox());
		//getInsertTextBox().setEditable(true);
		
		//Text output showing the available bullets
		setShowBulletsTextBox(new JTextField("Bullets: " + getBullets()));
		getShowBulletsTextBox().setBounds(376, 18, 184, 16);
		getShowBulletsTextBox().setEditable(false);
		getShowBulletsTextBox().setEnabled(false);
		contentPane.add(getShowBulletsTextBox());
		
		//Creates the X · Y button grid
		setBattleship(new JButton[getX()][getY()]);
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getBattleship()[i][j] = new JButton();
				getBattleship()[i][j].addActionListener(this);
				getBattleship()[i][j].setName(i + "" + j);
				//Button properties
				getBattleship()[i][j].setOpaque(true);
				getBattleship()[i][j].setEnabled(false);
				//Text color
				//getBattleship()[i][j].setForeground(Color.WHITE);
				
				panel.add(getBattleship()[i][j]);
			}
		}
	}


	private void newGame() {
		//setWin(0):
		setWin(false);
		setInitialMatrix();
	}
	
	private void exitGame() {
		System.exit(0);
	}
	
	//Constructor
	public void setInitialMatrix() {
		shipsCount=0;
		hitsCounter=0;
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getBattleship()[i][j].setBackground(Color.BLUE);
				getBattleship()[i][j].setEnabled(true);
				emptyShips();
				//The initial set of ships are turned off for tests
				//if testmode is enabled
				if (testMode == false) {
					setShips();
				}
				
	
			}
		}
	}
	
	//Sets all the ships to false
	public void emptyShips() {
		setShips(new boolean[getX()][getY()]);
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getShips()[i][j] = false;
			}
		}
		
	}

	//Places some ships
	private void setShips() {
		
		setShip(0, 0);
		setShip(0, 1);
		//setShip(0, 2);
		
		//setShip(5, 5);
		//setShip(6, 5);
		//setShip(7, 5);	
		//setShip(8, 7);
	}
	
	//Counts how many ships are initialized
	/*private void shipsCounter(){
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				if (getShips()[i][j] = true) {
					incrementShipCount();
				}
			}
		}
	}
	*/
	
	public static void incrementShipCount() {
		shipsCount++; 
	}
	
	public static void incrementHitsCount() {
		hitsCounter++; 
	}




	//Setters & getters
	private void setBattleship(JButton[][] battleship) {
		UI.battleship = battleship;
	}
	
	public void setNewGame(JButton newGame) {
		UI.newGame = newGame;
	}
	
	private void setExitButton(JButton exitGame) {
		UI.exitGame = exitGame;
		
	}

	public void setInsertTextBox(JTextField insertText) {
		UI.insertTextBox = insertText;
		
	}
	
	public void setShowBulletsTextBox(JTextField bulletsAvailable) {
		UI.bulletTextBoxValue = bulletsAvailable;
		
	}

	
	public static void setShips(boolean[][] ships) {
		UI.ships = ships;
	}
	
	public void setShip(int i, int j) {
		if (getShips()[i][j] == false) {
			getShips()[i][j] = true;
			incrementShipCount();
		}
	}
	
	public boolean checkWin() {
		if (getShipsCount() == getHits()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getHits() {
		return hitsCounter ;
	}


	public static void setX(int i) {
		x = i;
		
	}
	
	public static void setY(int j) {
		y = j;
		
	}
	
	public static JButton[][] getBattleship() {
		return battleship;
	}
	
	public static JTextField getInsertTextBox() {
		return insertTextBox;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public JButton getExitGame() {
		return exitGame;
	}
	
	public static JButton getNewGame() {
		return newGame;
	}

	public static boolean[][] getShips() {
		return ships;
	}
	
	public static void setWin(boolean b) {
		UI.win = b;
		
	}
	
	public static boolean getWin() {
		return win;
		
	}
	
	public static int getBullets() {
		return bullets;
	}
	
	public static void setBullets(int bullets){
		UI.bullets = bullets;
	}
	
	public static JTextField getShowBulletsTextBox() {
		return bulletTextBoxValue;
	}
	
	public static int getShipsCount() {
		return shipsCount;
	}

	


	
	//Action performer
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedLine;
		
		if(e.getSource() == getNewGame()){
			newGame();
			getInsertTextBox().setEditable(false);

		}
		
		if(e.getSource() == getExitGame()){
			exitGame();
		}

		if ((knownShipsNumber) == getHits()) {
			for (int x=0; x<getX(); x++) {
				for (int y=0; y<getY(); y++) {
					getBattleship()[x][y].setEnabled(false);
				}
			}
			getShowBulletsTextBox().setText("You WIN!!");
		}
		
		//System.out.println((getShipsCount()/100) + " " + getHits());
		

		
		//Checks if game is out of bullets, in that
		//case, the buttons are disabled
		if (getBullets() == 1) {
			for (int x=0; x<getX(); x++) {
				for (int y=0; y<getY(); y++) {
					getBattleship()[x][y].setEnabled(false);
				}
			}
		}
		
		//Lowers the bullets available
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				if(e.getSource() == getBattleship()[i][j] 
						&& getBattleship()[i][j].getBackground().equals(Color.BLUE)) {
					
					setBullets((getBullets()) - 1);
					
					if ((knownShipsNumber) == getHits()) {
						for (int x=0; x<getX(); x++) {
							for (int y=0; y<getY(); y++) {
								getBattleship()[x][y].setEnabled(false);
							}
						}
						getShowBulletsTextBox().setText("You WIN!!");
					} else {
					getShowBulletsTextBox().setText("Bullets: " + getBullets());
					}
					
				}
			}
		}
		
		
	
		
		JButton selectedBtn = (JButton) e.getSource(); 
		
		
		
		
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				selectedLine = i + "" + j;
				if (getShips()[i][j] == true) {
					if (selectedLine.equals(selectedBtn.getName())) {
						getBattleship()[i][j].setBackground(Color.RED);
						incrementHitsCount();
						checkWin();
					} 
				} else if (getShips()[i][j] == false){ 
					if (selectedLine.equals(selectedBtn.getName())) {
						getBattleship()[i][j].setBackground(Color.YELLOW);
					}
				}	
			}
		}
		
				
		
	

	}
}
