import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VisibleOpponentGUI extends JFrame implements MouseListener{

	JFrame myFrame = new JFrame();
	JLabel myPanels[];

	public VisibleOpponentGUI(){

		super("Opponent Grid");
		setSize(800, 400);
		setResizable(false);
		setLayout(new GridLayout(10, 10));
		addMouseListener(this);
 		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		myPanels = new JLabel[100];

		for(int x = 0; x < myPanels.length; x++){

			myPanels[x] = new JLabel("");
			myPanels[x].setOpaque(true);
			myPanels[x].setBackground(Color.BLUE);
			myPanels[x].setBorder(BorderFactory.createLineBorder(Color.black));
			myPanels[x].addMouseListener(this);
		}
		for(int x = 0; x < myPanels.length; x++)
			add(myPanels[x]);
	}
	@Override
	/**
	 * blue = nothing
	 * green = ship location
	 * red = hit
	 * yellow = miss
	*/
	public void mouseClicked(MouseEvent e){

		JLabel clickedPanel = (JLabel) e.getSource();

		if(clickedPanel.getBackground() == Color.green)
			clickedPanel.setBackground(Color.red);
		else
			clickedPanel.setBackground(Color.yellow);
	}
	@Override
	public void mouseExited(MouseEvent e){

	}
	@Override
	public void mouseEntered(MouseEvent e){

	}
	@Override
	public void mouseReleased(MouseEvent e){

	}
	@Override
	public void mousePressed(MouseEvent e){

	}
	public boolean getShot(char[][] opponentBoard){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.YELLOW){

				counter = i;
				break;
			}
		}

		if(opponentBoard[counter/10][counter%10] == 'S'){

			myPanels[counter].setBackground(Color.ORANGE);
		}
	
		return false;
	}
	public boolean gameOver(){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.ORANGE){

				counter++;
			}
		}
		if(counter == 14)
			return true;
		return false;
	}
}
