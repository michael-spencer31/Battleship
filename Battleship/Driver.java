import java.util.*;

public class Driver{

	public static void main(String[] args){

		PlayerGUI gui = new PlayerGUI();
		gui.setVisible(true);

		String input = "A1";
		int gridValue = 0;

		char letter; // = input.charAt(0);

		char numberChar; //= input.charAt(1);

		//check if the number is 10

		int number = 0; // = Character.getNumericValue(numberChar);

		Scanner scan = new Scanner(System.in);

		InputHandle ih = new InputHandle();

		//gridValue = ih.convertInput('A', 2, 0);

		//System.out.println(gridValue);

		System.out.println("Enter the location of your first ship: ");

		String[] locations = new String[3];
		int[] frigateLocations = new int[3];

		String[] battleship = new String[5];
		int[] battleshipLocations = new int[5];

		String[] patrol = new String[2];
		int[] patrolLocations = new int[2];

		String[] sub = new String[4];
		int[] subLocations = new int[4];

		int[] allLocations = new int[14];
		int locationHolder = 0;

		for(int i = 0; i < locations.length; i++){

			locations[i] = scan.nextLine();
		}
		ih.createShips(locations, frigateLocations);

		/**
		System.out.println("Enter the second ship: ");

		for(int i = 0; i < battleship.length; i++){

			battleship[i] = scan.nextLine();
		}

		ih.createShips(battleship, battleshipLocations);

		System.out.println("Enter the third ship: ");

		for(int i = 0; i < patrol.length; i++){

			patrol[i] = scan.nextLine();
		}
		*/
		//update locations on the grid
		gui.addToGrid(frigateLocations);
		//gui.addToGrid(battleshipLocations);

		GenerateEnemy ge = new GenerateEnemy();

		//ge.placeShips();

		System.out.println("hello");

		Ship[] ships = new Ship[]{
			new Ship(3),
			new Ship(2),
			new Ship(4),
			new Ship(5)
		};
		EnemyBoard enemyBoard = new EnemyBoard(10, 10);
		enemyBoard.place(ships);
		enemyBoard.printBoard();

	}
}