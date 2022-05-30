import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerGUI extends JFrame implements MouseListener{

	JFrame myFrame = new JFrame();
	JLabel myPanels[];

	public PlayerGUI(){

		super("Player Grid");
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
	public void mouseClicked(MouseEvent e){

		JLabel clickedPanel = (JLabel) e.getSource();

		if(clickedPanel.getBackground() == Color.blue)
			clickedPanel.setBackground(Color.red);
		else
			clickedPanel.setBackground(Color.blue);
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
	public void addToGrid(int[] locations){

		int location = 0;

		for(int i = 0; i < locations.length; i++){

			location = locations[i];

			myPanels[location - 1].setBackground(Color.GREEN);
		}
	}
	int[] frigateLocations = new int[3];
	int[] patrolLocations = new int[2];
	int[] subLocations = new int[4];
	int[] battleshipLocations = new int[5];

	public boolean addFrigate(){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.RED){

				frigateLocations[counter] = i;
				counter++;
			}
		}
		if(counter == 3)
			return true;
		return false;
	}
	public int[] getFrigate(){
		return frigateLocations;
	}
	public int[] getSub(){
		return subLocations;
	}
	public int[] getBattleship(){
		return battleshipLocations;
	}
	public int[] getPatrol(){
		return patrolLocations;
	}
	public boolean addPatrol(){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.RED)
				counter++;
		}
		if(counter == 5)
			return true;
		return false;
	}
	public boolean addBattleship(){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.RED){
				counter++;
			}
		}
		if(counter == 10)
			return true;
		return false;
	}
	public boolean addSub(){

		int counter = 0;

		for(int i = 0; i < myPanels.length; i++){

			if(myPanels[i].getBackground() == Color.RED){
				counter++;
			}
		}
		if(counter == 14)
			return true;
		return false;
	}
}
