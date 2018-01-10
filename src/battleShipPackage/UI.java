package battleShipPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;


public class UI extends JFrame implements ActionListener {


	private static final long serialVersionUID = -7929093104965802853L;

	private JPanel contentPane;
	public static JButton newGame;
	public static JButton exitGame;

	private static int x = 10;
	private static int y = 10;

	private static JButton[][] battleship;
	private static boolean[][] ships;
	


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
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		
		//General panel behavior and default size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		//Exit button
		setExitButton(new JButton("Exit"));
		getExitGame().addActionListener(this);
		getExitGame().setBounds(519, 6, 275, 29);
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
		setInitialMatrix();
		
	}
	
	private void exitGame() {
		System.exit(0);
		
	}
	
	
	//Constructor
	public void setInitialMatrix() {
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getBattleship()[i][j].setBackground(Color.BLUE);
				getBattleship()[i][j].setEnabled(true);
				setShips();
	
			}
		}
	}
	
	

	//Places two ships
	private void setShips() {
		setShips(new boolean[getX()][getY()]);
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getShips()[i][j] = false;
			}
		}
		
		getShips()[0][0] = true;
		getShips()[0][1] = true;
		getShips()[0][2] = true;
		
		getShips()[5][5] = true;
		getShips()[6][5] = true;
		getShips()[7][5] = true;
		
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
	
	public JButton[][] getBattleship() {
		return battleship;
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
	
	public JButton getNewGame() {
		return newGame;
	}

	public static boolean[][] getShips() {
		return ships;
	}

	public static void setShips(boolean[][] ships) {
		UI.ships = ships;
	}
	
	//Action performer
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedLine;
		
		if(e.getSource()==getNewGame()){
			newGame();
		}
		
		if(e.getSource()==getExitGame()){
			exitGame();
		}
		
		 JButton selectedBtn = (JButton) e.getSource(); 
		
		//System.out.println(getShips()[0][0]);
		
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				if (getShips()[i][j] == true) {
					selectedLine = i + "" + j;
					if (selectedLine.equals(selectedBtn.getName())) {
						getBattleship()[i][j].setBackground(Color.RED);
					}
				}
			}
		}
		
				
		
	

	}








}
