package battleShipPackage;

public class MockUITest implements ManageUI {

	@Override
	public void partidaGuanyaX() {
		
		UI.getBattleship()[3][1].setText("X");
		UI.getBattleship()[3][1].setEnabled(false);
		UI.getBattleship()[3][2].setText("X");
		UI.getBattleship()[3][2].setEnabled(false);
		UI.getBattleship()[3][3].setText("X");
		UI.getBattleship()[3][3].setEnabled(false);
		UI.getBattleship()[3][4].setText("X");
		UI.getBattleship()[3][4].setEnabled(false);
		UI.getBattleship()[3][5].setText("X");
		UI.getBattleship()[3][5].setEnabled(false);
		UI.getBattleship()[3][6].setText("X");
		UI.getBattleship()[3][6].setEnabled(false);
		UI.getBattleship()[3][7].setText("X");
		UI.getBattleship()[3][7].setEnabled(false);
		UI.getBattleship()[1][5].setText("X");
		UI.getBattleship()[1][5].setEnabled(false);
		UI.getBattleship()[2][5].setText("X");
		UI.getBattleship()[2][5].setEnabled(false);
		UI.getBattleship()[2][6].setText("X");
		UI.getBattleship()[2][6].setEnabled(false);
		UI.getBattleship()[4][3].setText("X");
		UI.getBattleship()[4][3].setEnabled(false);
		UI.getBattleship()[4][4].setText("X");
		UI.getBattleship()[4][4].setEnabled(false);
		UI.getBattleship()[4][5].setText("X");
		UI.getBattleship()[4][5].setEnabled(false);
		UI.getBattleship()[4][6].setText("X");
		UI.getBattleship()[4][6].setEnabled(false);
		UI.getBattleship()[5][3].setText("X");
		UI.getBattleship()[5][3].setEnabled(false);
		UI.getBattleship()[5][4].setText("X");
		UI.getBattleship()[5][4].setEnabled(false);
		UI.getBattleship()[5][5].setText("X");
		UI.getBattleship()[5][5].setEnabled(false);
		UI.getBattleship()[3][8].setText("O");
		UI.getBattleship()[3][8].setEnabled(false);
		UI.getBattleship()[4][8].setText("O");
		UI.getBattleship()[4][8].setEnabled(false);
		UI.getBattleship()[5][8].setText("O");
		UI.getBattleship()[5][8].setEnabled(false);
	}

	@Override
	public void partidaEmpat() {
		//Test empat amb tauler complert!
		for(int i=1; i<9; i++ ){
			for(int j=1; j<5; j++){
				UI.getBattleship()[i][j].setText("O");
				UI.getBattleship()[i
				                      ][j].setEnabled(false);
			}
			for(int j=5; j<9; j++){
				UI.getBattleship()[i][j].setText("X");
				UI.getBattleship()[i][j].setEnabled(false);
			}
		}
	}
	@Override
	public void setMatriuMock() {
		//setMatriuInicial Inicialitzant a ENABLED tot el taulell
		//x=filas, y=columnas
		UI inter = new UI();
		
		UI.setX(10);
		UI.setY(10);
		for(int i=1; i<UI.getX()-1; i++){
			for(int j=1; j<UI.getY()-1; j++){
				UI.getBattleship()[i][j].setEnabled(true);
				UI.getBattleship()[i][j].setText("");
			}
		}
	}
	@Override
	public void initWin() {
		UI.setWin(63);
	}

	@Override
	public void initLose() {
		// TODO Auto-generated method stub
		
	}

}
