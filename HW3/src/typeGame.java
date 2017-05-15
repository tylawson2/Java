

import java.awt.*;
import java.awt.event.*;
import java.util.Timer; 
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.applet.Applet;
import java.util.Timer; 
import java.util.TimerTask;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.applet.Applet;

public class typeGame extends Applet implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
	
	Canvas c1;
	TextField wpm;
	Graphics myG;
	int theCode, counter=1, y, length, tw, tt, count, space,lets,z;
	double rate;
	String myType="", gameWord, last="", wrongLet, wrongWord;
	Boolean go=true, type=false, clear=false;
	Timer timer;
	long t, sec;
	
	public void init() {
	
		
		c1= new Canvas();
		wpm= new TextField();
		timer= new Timer();
		t=System.currentTimeMillis();
		
		c1.setBackground(Color.white);
		c1.addMouseListener(this);
		c1.addMouseMotionListener(this);
		c1.setSize(500,500);
		
		c1.addKeyListener(this);
	
		
		add(c1);
		add(wpm);
		
		this.setSize(1100, 750);
		repaint();
		
	}

	public void actionPerformed(ActionEvent e) {	
	
	}

	public void mousePressed(MouseEvent e) {
		
		if(go){
			go=false;
			type=true;
			gameWord=getWord();
			myG.setColor(Color.black);
			count=0;
			while(count<gameWord.length()){
				myG.drawString(String.valueOf(gameWord.charAt(count)), 10+(10*count), 25);
				count++;
			}
		}
		
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
		wpm.setSize(110,40);
		wpm.setLocation(40,300);
		g.drawString("Words per minute", 40, 290);
		c1.setLocation(250, 100);
		
		c1.requestFocus();
		
}
	

	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
	
		theCode=e.getKeyCode();
		if(clear){
			myG.clearRect(0,0,c1.getWidth(),c1.getHeight());
			myG.setColor(Color.black);
			count=0;
			while(count<gameWord.length()){
				myG.drawString(String.valueOf(gameWord.charAt(count)), 10+(10*count), 25);
				count++;
			}
			clear=false;
		}
		if(type){
			
			myType=myType+String.valueOf(e.getKeyChar());
			
			if(myType.charAt(y)==gameWord.charAt(y)){
				myG.setColor(Color.green);
				myG.drawString(String.valueOf(e.getKeyChar()), 10+(10*lets), 25);
				y++;
				lets++;
			}
			else{
			
				
				myG.setColor(Color.red);
				myG.drawString(String.valueOf(gameWord.charAt(lets)), 10+(10*lets), 25);
				last=myType;
				myType="";
				y=0;
				lets=0;
				clear=true;
			}
			if(myType.equals(gameWord)){
				
				gameWord=getWord();
				type=true;
				myType="";
				y=0;
				myG.clearRect(0,0,c1.getWidth(),c1.getHeight());
				myG.setColor(Color.black);
				count=0;
				while(count<gameWord.length()){
					myG.drawString(String.valueOf(gameWord.charAt(count)), 10+(10*count), 25);
					count++;
				}
				t=(System.currentTimeMillis()-t)/1000;
				tt=tt+(int)t;
				tw++;
				rate= (double)((60*tw)/tt);
				wpm.setText(String.valueOf(rate));
				
				t=System.currentTimeMillis();
				lets=0;
				
			}
			
		}
		           
		//System.out.println(e.getKeyCode());
		
	}


	public void keyReleased(KeyEvent e) {
		
		
	}

	public String getWord(){
		int it=(int)(Math.random()*10);
		String[] words;
		words= new String[10];
		words[0]="hello";
		words[1]="this";
		words[2]="tyler";
		words[3]="elephant";
		words[4]="ubiquitous";
		words[5]="airplane";
		words[6]="computer";
		words[7]="hacking";
		words[8]="kalamazoo";
		words[9]="schizophrenia";
		
		String theWord=words[it];
		return theWord;
	}
	
	
}