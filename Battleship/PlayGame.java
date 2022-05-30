import java.util.Arrays;

public class PlayGame{

	public boolean subArray(int[] shotLocations, int[] shipLocations){

		int i = 0, j = 0;

		while(i < shotLocations.length && j < shipLocations.length){

			if(shotLocations[i] == shipLocations[j]){

				i++;
				j++;

				if(j == shipLocations.length)
					return true;
			}else{

				i = i - j + 1;
				j = 0;
			}
		}
		return false;
	}
	public boolean gameOver(int[] frigateLocations, int[] subLocations, int[] patrolLocations, 
							int[] battleshipLocations, int[] shotLocations){

		if(frigateSunk(frigateLocations, shotLocations) && patrolSunk(patrolLocations, shotLocations) &&
					   subSunk(subLocations, shotLocations))
			return true;

		return false;
	}
	public boolean frigateSunk(int[] frigateLocations, int[] shotLocations){

		Arrays.sort(frigateLocations);

		if(subArray(shotLocations, frigateLocations))
			return true;
		return false;
	}
	public boolean patrolSunk(int[] patrolLocations, int[] shotLocations){

		Arrays.sort(patrolLocations);

		if(subArray(shotLocations, patrolLocations))
			return true;
		return false;
	}
	public boolean subSunk(int[] subLocations, int[] shotLocations){

		Arrays.sort(subLocations);

		if(subArray(shotLocations, subLocations))
			return true;
		return false;
	}
}
