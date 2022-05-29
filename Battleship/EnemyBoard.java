import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

public class EnemyBoard{

	private final int rows;
	private final int cols;

	private char[][] board;

	public EnemyBoard(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		board = new char[rows][cols];
	}
	public void place(Ship[] ships){

		Arrays.sort(ships, new Comparator<Ship>(){

			@Override
			public int compare(Ship s1, Ship s2){
				return Integer.valueOf(s1.size).compareTo(Integer.valueOf(s2.size));
			}
		});
		for(int j = 0; j < rows; j++)
			for(int k = 0; k < cols; k++)
				board[j][k] = '-';		//empy posistion
			
		
		char[][] checked = new char[rows][cols];
		Random rand = new Random();
		for(int i = ships.length - 1; i >= 0; i--){

			for(int j = 0; j < rows; j++)

				for(int k = 0; k < cols; k++)

					checked[j][k] = 'U';
			boolean placed = false;
			while(!placed){

				int r = rand.nextInt(rows);
				int c = rand.nextInt(cols);

				if(checked[r][c] == 'U'){
					checked[r][c] = 'C';
					if(board[r][c] == '-'){

						int direction = rand.nextInt(4);

						if(canPlace(ships[i], r, c, direction)){

							place(ships[i], r, c, direction);
							placed = true;
						}
					}
				}
			}
			
		}
	}
	private void place(Ship ship, int row, int col, int direction){

		int size = ship.getSize();

		switch(direction){

		case 0:	//north
			for(int i = row; i >= row - (size - 1); i--)
				board[i][col] = 'S';
			break;

		case 1:	//east
			for(int i = col; i <= col + (size - 1); i++)
				board[row][i] = 'S';
			break;

		case 2:	//south
			for(int i = row; i <= row + (size - 1); i++)
				board[i][col] = 'S';
			break;

		default: //west
			for(int i = col; i >= col - (size - 1); i--)
				board[row][i] = 'S';
			break;
		}
	}
	private boolean canPlace(Ship ship, int row, int col, int direction) {
        int size = ship.getSize();
        boolean thereIsRoom = true;
        switch (direction) {
        case 0: // North
            if (row - (size - 1) < 0)
                thereIsRoom = false;
            else 
                for (int  i = row; i >= row - (size - 1) && thereIsRoom; i--)
                    thereIsRoom = thereIsRoom & (board[i][col] == '-');
            break;

        case 1: // East
            if (col + (size - 1) >= cols)
                thereIsRoom = false;
            else
                for (int i = col; i <= col + (size - 1) && thereIsRoom; i++)
                    thereIsRoom = thereIsRoom & (board[row][i] == '-');
            break;

        case 2: // South
            if (row + (size - 1) >= rows)
                thereIsRoom = false;
            else
                for (int i = row; i <= row + (size - 1) && thereIsRoom; i++)
                    thereIsRoom  = thereIsRoom & (board[i][col] == '-');
            break;

        default: // West
            if (col - (size - 1) < 0) 
                thereIsRoom = false;
            else
                for (int i = col; i >= col - (size - 1) && thereIsRoom; i--) 
                    thereIsRoom = thereIsRoom & (board[row][i] == '-');
            break;
        }
        return thereIsRoom;
    }
    public void printBoard() {

    	OpponentGUI oGUI = new OpponentGUI();
    	int counter = 0;

    	for (int i = 0; i < rows; i++){
            System.out.println(Arrays.toString(board[i]));
    	}
    	for(int i = 0; i < rows; i++){

    		for(int j = 0; j < cols; j++){

    			counter++;
    			if(board[i][j] == 'S'){

    				oGUI.addToGrid(counter);
    			}

    		}
    	}
		oGUI.setVisible(true);
    }
}