

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class typer extends Applet implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	
	Canvas c1;
	
	Graphics myG;
	int theCode, counter=1, y=30, length;
	String myType="", saveIt;
	Boolean go;
	
	public void init() {
	
		
		c1= new Canvas();
		
		
		c1.setBackground(Color.white);
		c1.addMouseListener(this);
		c1.addMouseMotionListener(this);
		c1.setSize(500,500);
		
		c1.addKeyListener(this);
	
		
		add(c1);
		
		
		this.setSize(1100, 750);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {	
	
	}

	public void mousePressed(MouseEvent e) {
		
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		
	}
	
	

	public void paint(Graphics g) {	
		myG= c1.getGraphics();
		
		c1.setLocation(250, 100);
		
		c1.requestFocus();
}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		go=true;
		theCode=e.getKeyCode();
		if(e.getKeyCode()==10){
			counter=1;
			y=y+25;
			myType="";
			go=false;
		}
		if(e.getKeyCode()==8){
			length=myType.length();
			int z=0;
			myType=saveIt;
			myType="";
			while(z<length-2){
				myType=myType+saveIt.charAt(z);
				z++;
			}
			myG.drawString(myType, 10, y);
			go=false;
		}
		
		if(go){
		myType=myType+String.valueOf(e.getKeyChar());
		myG.drawString(myType, 10, y);
		counter++;
		if(counter==48){
			counter=1;
			y=y+25;
			myType="";
		}
		}
		System.out.println(e.getKeyCode());
		
	}


	public void keyReleased(KeyEvent e) {
		
		
	}

	
	
}