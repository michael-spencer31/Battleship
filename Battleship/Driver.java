import java.util.*;

public class Driver{

	public static void main(String[] args){

		PlayerGUI gui = new PlayerGUI();
		gui.setVisible(true);

		int gridValue = 0;

		char letter; // = input.charAt(0);

		char numberChar; //= input.charAt(1);

		int number = 0; // = Character.getNumericValue(numberChar);

		Scanner scan = new Scanner(System.in);

		String[] frigate = new String[3];
		int[] frigateLocations = new int[3];

		String[] battleship = new String[5];
		int[] battleshipLocations = new int[5];

		String[] patrol = new String[2];
		int[] patrolLocations = new int[2];

		String[] sub = new String[4];
		int[] subLocations = new int[4];

		int[] allLocations = new int[14];
		int locationHolder = 0;

		while(!gui.addFrigate()){}

		frigateLocations = gui.getFrigate();

		while(!gui.validateInput(frigateLocations)){

			gui.reset();
			while(!gui.addFrigate()){}
		}
		gui.setValidShips();

		while(!gui.addPatrol()){}

		patrolLocations = gui.getPatrol();

		while(!gui.validateInput(patrolLocations)){

			gui.reset();
			while(!gui.addPatrol()){}
		}
		gui.setValidShips();

		/**
		while(!gui.addBattleship()){}

		battleshipLocations = gui.getBattleship();

		while(!gui.validateInput(battleshipLocations)){

			gui.reset();
			while(!gui.addBattleship()){}
		}
		gui.setValidShips();

		while(!gui.addSub()){}

		subLocations = gui.getSub();

		while(!gui.validateInput(subLocations)){

			gui.reset();
			while(!gui.addSub()){}
		}s
		gui.setValidShips();
		*/
		Ship[] ships = new Ship[]{
			new Ship(3),
			new Ship(2),
			new Ship(4),
			new Ship(5)
		};
		EnemyBoard enemyBoard = new EnemyBoard(10, 10);
		enemyBoard.place(ships);
		enemyBoard.printBoard();

		//create the ai gui the player will actually see 
		VisibleOpponentGUI visibleGUI = new VisibleOpponentGUI();
		visibleGUI.setVisible(true);

		//System.out.println(visibleGUI.getShot(gui));

		char[][] opponentBoard = new char[10][10];

		opponentBoard = enemyBoard.getBoard();

		while(!visibleGUI.gameOver()){
			visibleGUI.getShot(opponentBoard);
	
		}
		System.out.println("Game Over!");
	}
}
