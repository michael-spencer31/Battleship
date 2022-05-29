import java.util.Random;

public class GenerateEnemy{

	public void placeShips(){

		OpponentGUI oGUI = new OpponentGUI();

		Random rand = new Random();
		int location = rand.nextInt(100 - 0) + 0;
		int direction = rand.nextInt(100 - 0) + 0;
		int increase = 0;

		if(direction > 50){
			increase = 1;
		}else{
			increase = 10;
		}

		int[] frigate = new int[3];
		int[] battleship = new int[5];
		int[] patrol = new int[2];
		int[] sub = new int[4];
		int[] allLocations = new int[14];

		for(int i = 0; i < frigate.length; i++){

			frigate[i] = location;
			allLocations[i] = location;
			location = location + increase;
		}
		location = rand.nextInt(100 - 0) + 0;
		direction = rand.nextInt(100 - 0) + 0;

		if(direction > 50){
			increase = 1;
		}else{
			increase = 10;
		}

		boolean validLocations = false;

		System.out.println("New location: " + location);

		oGUI.addToGrid2(frigate);

		for(int i = 0; i < battleship.length; i++){

			battleship[i] = location;
			allLocations[i] = location;
			location = location + increase;
		}
		for(int i = 0; i < battleship.length; i++){
			System.out.println(battleship[i]);
		}
	}
}