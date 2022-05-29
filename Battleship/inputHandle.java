import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class InputHandle{

	private int[] allLocations = new int[14];

	public int convertInput(char letter, int gridValue, int number){

		if(letter == 'A'){

			gridValue = gridValue + number;
		}else if(letter == 'B'){

			gridValue = gridValue + number + 10;
		}else if(letter == 'C'){

			gridValue = gridValue + number + 20;
		}else if(letter == 'D'){

			gridValue = gridValue + number + 30;
		}else if(letter == 'E'){

			gridValue = gridValue + number + 40;
		}else if(letter == 'F'){

			gridValue = gridValue + number + 50;
		}else if(letter == 'G'){

			gridValue = gridValue + number + 60;
		}else if(letter == 'H'){

			gridValue = gridValue + number + 70;
		}else if(letter == 'I'){

			gridValue = gridValue + number + 80;
		}else if(letter == 'J'){

			gridValue = gridValue + number + 90;
		}else{
			System.out.println("Error - value out of range");
		}
		return gridValue;
	}
	/**
	 * this function ensures the input entered by the user is valid
	 * returns true/false
	*/
	public boolean validateInput(int[] values){

		return validateVertical(values) || validateHorizontal(values);
	}
	public boolean validateVertical(int[] values){

		Arrays.sort(values);

		for(int i = 1; i < values.length; i++){

			if(values[i] - values[i - 1] != 10){

				return false;
			}
		}
		return true;
	}
	public boolean validateHorizontal(int[] values){

		Arrays.sort(values);

		for(int i = 1; i < values.length; i++){

			if(values[i] - values[i - 1] != 1){

				return false;
			}
		}
		return true;
	}
	public void createShips(String[] locations, int[] intLocations){

		for(int i = 0; i < locations.length; i++){

			int gridValue = 0;
			char letter = locations[i].charAt(0);
			char numberChar = locations[i].charAt(1);
			int number = Character.getNumericValue(numberChar);

			int numDigits = String.valueOf(locations[i]).length();
		
			if(numDigits == 3){
				gridValue = 0;
				gridValue = gridValue + 9;
			}
			gridValue = this.convertInput(letter, number, gridValue);

			//have to check here


			intLocations[i] = gridValue;

			gridValue = 0;
		}
		for(int i = 0; i < locations.length; i++){
			System.out.println(intLocations[i]);
		}
	}
	public boolean validSpot(int[] locations){

		Set<Integer> lump = new HashSet<Integer>();

		for(int i: locations){

			if(lump.contains(i)) return true;
			lump.add(i);
		}
		return false;
	}
}
