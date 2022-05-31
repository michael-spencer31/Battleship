import java.util.Random;

public class EnemyTurn{

	int[] shotLocations = new int[100];

	public boolean checkLocation(int shot){

		boolean validShot = false;

		for(int i = 0; i < shotLocations.length; i++){

			if(shotLocations[i] == shot){

				return false;
			}
		}
		return true;
	}

	public void takeShot(){

		Random rand = new Random();
		int shot = rand.nextInt(100 - 0) + 0;

		while(!checkLocation(shot)){

			shot = rand.nextInt(100 - 0) + 0;
		}
	}
}

//		int direction = rand.nextInt(100 - 0) + 0;