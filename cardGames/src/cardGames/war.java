package cardGames;

import java.awt.*; 
import java.awt.event.*; 
import java.applet.*;

public class war extends Applet implements ActionListener { 

	card[] deck;
	card[] p1; card[] p2;
	Boolean[] bools;

	public void init() {

		deck = new card[52];
		p1 = new card[52];
		p2 = new card[52];
		int y=0;
		int x=0;
		while(x<52) {
			deck[x] = new card();
			p1[x] = new card();
			p2[x] = new card();
			x++; 
		}
		x=0;
		while(x<13) {
			deck[x].suit="Heart";
			deck[x].number=y;
			x++; 
			y++;
		}
		y=0;
		while(x<27) {
			deck[x].suit="Diamond";
			deck[x].number=y;
			y++; 
			x++; 
		}
		y=0;
		while(x<41) {
			deck[x].suit="Spade";
			deck[x].number=y;
			y++; 
			x++; 
		}
		y=0;
		while(x<52) {
			deck[x].suit="Club";
			deck[x].number=y;
			y++; 
			x++; 
		}
		
		setPlayers();
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.getAllFonts();
		Font fontA = new Font("Dialog", Font.BOLD, 35);	
	}
	public void mousePressed() {

	}

	public void actionPerformed(ActionEvent e) {	

	}
	
	public void setPlayers(){
		int z;
		int q;
		
		while(z<52){
			
		}
		
	}

} 





class card {


	int number; 

	String suit;

	boolean faceUp = false;
	int x, y; 
	int width, height;

	public void drawMe(Graphics cardG) { 
		if(faceUp) {
			cardG.setColor(Color.red); 
			cardG.fillRect(x, y, width, height);
		} 
		else {

		} 

	}


	public void eraseMe(Graphics cardG) { 

	}
	public void placeMe(int locX, int locY) { 
		x = locX;
		y = locY; 
	}
}
