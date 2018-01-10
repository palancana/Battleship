package battleShipPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;

public class GUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7929093104965802853L;

	private JPanel contentPane;
	public JButton button_0_1;
	public JButton button_0_0;
	private static JButton newGame;

	private static int x = 10;
	private static int y = 10;

	private static JButton[][] battleship;


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(519, 6, 275, 29);
		contentPane.add(btnNewButton);
		
		setNewGame(new JButton("Start"));
		getNewGame().addActionListener(this);
		getNewGame().setBounds(6, 6, 227, 29);
		contentPane.add(getNewGame());

		
		JPanel panel = new JPanel();
		panel.setBounds(6, 36, 788, 736);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 10, 1, 1));

		
		
		//10x10 button grid
		setBattleship(new JButton[getX()][getY()]);
		for (int i=0; i<getX(); i++) {
			for (int j=0; j<getY(); j++) {
				getBattleship()[i][j] = new JButton();
				getBattleship()[i][j].addActionListener(this);
				//Button properties
				getBattleship()[i][j].setOpaque(true);
				getBattleship()[i][j].setForeground(Color.WHITE);
				
				panel.add(getBattleship()[i][j]);
			}
		}
	}
	

	
	private void newGame() {
		//setWin(0):
		setInitialMatrix();
		
	}
	
	
	//Constructor
	public void setInitialMatrix() {
		getBattleship()[0][0].setText("HELLO");
		getBattleship()[0][0].setEnabled(false);
	}
	
	


	//Setters & getters
	
	private void setBattleship(JButton[][] battleship) {
		GUI.battleship = battleship;
	}
	
	private void setNewGame(JButton newGame) {
		GUI.newGame = newGame;
	}
	
	private JButton[][] getBattleship() {
		return battleship;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public static JButton getNewGame() {
		return newGame;
	}

	
	//Action performer
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==getNewGame()){
			newGame();
		}
	}

}
