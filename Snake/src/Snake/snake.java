package Snake;

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

import javax.imageio.ImageIO;

public class snake extends Applet implements ActionListener, MouseListener, KeyListener {

	stuff theTarget;
	stuff[] theOnes;
	TextField blocks;
	Timer timer;
	boolean flipper=false, theEnd=false, startover=false, itworks=false, jump=true;
	int numLinks=3, blocksEaten, lastx, lasty, ox, oy, t, counter; 
	Canvas c1;	
	Label daScore;

	boolean checkBool=false; boolean start=true;boolean firstPress=true; boolean run=false, snakeBool, tester=false;
	boolean north=false; boolean south=false; boolean east=true; boolean west=false;
	Graphics myG, thingG;
	Image gameOver;



	public void init() {
		Font afont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 25);

		daScore=new Label(String.valueOf(numLinks));
		daScore.setFont(afont);
		daScore.setForeground(Color.green);
		daScore.setBackground(Color.blue);
		timer=new Timer();

		c1 = new Canvas();

		theTarget= new stuff();
		theOnes= new stuff[500];

		int j=0;
		while(j<500){
			theOnes[j]= new stuff();
			j++;
		}






		this.setBackground(Color.blue);
		c1.setBackground(Color.red);
		c1.setSize(945, 445);

		this.setSize(1100, 500);
		c1.addMouseListener(this);
		c1.addKeyListener(this);

		add(c1);
		add(daScore);

		try {
			Thread.sleep(100);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		repaint();
	}

	public void actionPerformed(ActionEvent e) {


	}



	public void Looper(float hundredth) {

		timer.schedule(new RemindTask(), 0, (int)(hundredth*10));

	}
	class RemindTask extends TimerTask {

		public void run() {
			Font fontB = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 100);
			Font ofont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 50);

			int l=0;
			if(l==0){
				theOnes[0].index=0;
				//theOnes[l].erase(myG);
				lastx=theOnes[0].x; lasty=theOnes[0].y;
				if(north){
					theOnes[l].y=theOnes[l].y-25;
				}
				if(south){
					theOnes[l].y=theOnes[l].y+25;
				}
				if(east){
					theOnes[l].x=theOnes[l].x+25;
				}
				if(west){
					theOnes[l].x=theOnes[l].x-25;;
				}

				theOnes[l].draw(myG);
				theEnd=testIfDone();
				if(theEnd){
					myG.setColor(Color.black);
					myG.fillRect(lastx, lasty, 20, 20);
					theOnes[0].drawLast(myG);
					myG.setColor(Color.GREEN);
					myG.setFont(fontB);
					myG.drawString("GAME OVER!",150, 250);
					myG.setFont(ofont);
					myG.drawString("PLAY AGAIN?",295, 315);
					timer.cancel();
				}

			}
			l++;

			while(l<numLinks){
				theOnes[l].index=l;

				if(!theEnd&&l==numLinks-1){
					theOnes[l].erase(myG);
				}
				if(flipper){
					lastx=theOnes[l].x;
					lasty=theOnes[l].y;
					theOnes[l].x=ox;
					theOnes[l].y=oy;
					theOnes[l-1].igo=true;
					flipper=false;
				}
				else{
					ox=theOnes[l].x;
					oy=theOnes[l].y;
					theOnes[l].x=lastx;
					theOnes[l].y=lasty;
					theOnes[l-1].igo=true;
					flipper=true;
				}

				if(!theEnd&&theOnes[l].igo){
					theOnes[l].draw(myG);
					//System.out.println(theOnes[l].x+", "+theOnes[l].y);
				}
				theTarget.drawTarget(thingG);
				//theTarget.eraseCorner(thingG);
				tester=testIfTouching();

				if(tester){
					theTarget.eraseTarget(thingG);
					itworks=false;
					counter=0;
					while(!itworks){
						theTarget.moveTarget();
						t=0;
					//System.out.println("in first");
						while(t<numLinks){
							//System.out.println("in second");
							if(theTarget.x==theOnes[t].x&&theTarget.y==theOnes[t].y){
								counter++;
							}
							t++;
						}
						if(counter==0){
							itworks=true;
						}
						counter=0;
					}
					
					theTarget.drawTarget(thingG);
					tester=false;
					numLinks= numLinks+2;
					if(numLinks<10){
						daScore.setLocation(1025,200);
					}
					if(numLinks<100){
						daScore.setLocation(1005,200);
					}
					if(numLinks>=100){
						daScore.setLocation(985,200);
					}
					daScore.setText(String.valueOf(numLinks));
				}
				l++;	
			}





		} 
	}

	public boolean testIfTouching(){
		boolean theBool;

		if(theTarget.x==theOnes[0].x&&theTarget.y==theOnes[0].y){
			theBool=true;
			blocksEaten++;

		}
		else{
			theBool=false;
		}

		return theBool;
	}

	public boolean testIfDone(){
		boolean aBool;

		if(theOnes[0].x>925||theOnes[0].x<0||theOnes[0].y<0||theOnes[0].y>425){

			aBool=true;
		}
		else{
			aBool=false;
		}
		int p=1;
		while(p<numLinks){
			if(theOnes[0].x==theOnes[p].x&&theOnes[0].y==theOnes[p].y){
				aBool=true;
			}
			p++;
		}

		return aBool;
	}

	public void paint(Graphics g) {	

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.getAllFonts();


		g.setColor(Color.black);

		myG = c1.getGraphics();	
		thingG = c1.getGraphics();	


		Font afont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 25);
		g.setColor(Color.green);
		daScore.setSize(50,40);
		daScore.setLocation(1025,200);
		g.setFont(afont);
		g.drawString("Points:", 985, 190);



		c1.setLocation(25, 25);
		Font ofont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 50);
		if(start){
			myG.setColor(Color.green);
			myG.setFont(ofont);
			myG.drawString("Press the Screen to Start!!", 60, 235);

		}







	}


	public void mouseClicked(MouseEvent e) {}


	public void mousePressed(MouseEvent e) {
		if(firstPress){
			run=true;
			start=false;
			firstPress=false;
			itworks=false;
			counter=0;
			while(!itworks){
				theTarget.moveTarget();
				t=0;
			//System.out.println("in first");
				while(t<numLinks){
					//System.out.println("in second");
					if(theTarget.x==theOnes[t].x&&theTarget.y==theOnes[t].y){
						counter++;
					}
					t++;
				}
				if(counter==0){
					itworks=true;
				}
				counter=0;
			}
			//System.out.println(theTarget.x+", "+theTarget.y);
			theTarget.drawTarget(thingG);

			validate();
			repaint();
			Looper(15);
		}
		Font afont = new Font("8bitOperatorPlus-Bold", Font.ROMAN_BASELINE, 40);
		if(theEnd){
			if((e.getX()>315&&e.getX()<690)&&(e.getY()>270&&e.getY()<325)){

				myG.setColor(Color.red);
				myG.fillRect(280, 250, 400, 90);
				myG.setColor(Color.green);
				myG.setFont(afont);
				startover=true;
				myG.drawString("PLAY AGAIN?",345, 305);
			}
		}

		//System.out.println(e.getX()+", "+e.getY());

	}

	public void mouseReleased(MouseEvent e) {
		if(startover){
			validate();

			repaint();
			run=true;
			start=false;

			int z=0;
			while(z<500){
				theOnes[z].x= 0;
				theOnes[z].y= 0;
				theOnes[z].igo=false;
				z++;
			}

			checkBool=false; tester=false;
			north=false; south=false; east=true; west=false;
			itworks=false;
			counter=0;
			while(!itworks){
				theTarget.moveTarget();
				t=0;
			//System.out.println("in first");
				while(t<numLinks){
					//System.out.println("in second");
					if(theTarget.x==theOnes[t].x&&theTarget.y==theOnes[t].y){
						counter++;
					}
					t++;
				}
				if(counter==0){
					itworks=true;
				}
				counter=0;
			}
			theTarget.drawTarget(thingG);
			flipper=false; theEnd=false; startover=false;
			numLinks=3; 
			blocksEaten=0; 
			daScore.setText(String.valueOf(numLinks));
			timer=new Timer();

			Looper(15);
		}




	}


	public void mouseEntered(MouseEvent e) {}


	public void mouseExited(MouseEvent e) {}





	public void keyTyped(KeyEvent e) {}


	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()==38&&(!south)){
			north=true;
			south=false;
			east=false;
			west=false;
		}
		if(e.getKeyCode()==40&&(!north)){
			north=false;
			south=true;
			east=false;
			west=false;
		}
		if(e.getKeyCode()==39&&(!west)){
			north=false;
			south=false;
			east=true;
			west=false;
		}
		if(e.getKeyCode()==37&&(!east)){
			north=false;
			south=false;
			east=false;
			west=true;
		}

	}


	public void keyReleased(KeyEvent e) {	}

}



class stuff{

	int selector;
	int x;
	int y;
	boolean igo=false;
	int index;
	int width=20;
	int height=20;


	public stuff(){

	}

	public void draw(Graphics aG){



		aG.setColor(Color.green);
		aG.fillRect(x, y, width, height);


	}

	public void erase(Graphics aG){
		aG.setColor(Color.black);
		aG.fillRect(x,y, width, height);

	}

	public void eraseTarget(Graphics aG){
		aG.setColor(Color.black);
		aG.fillRect(x, y, width, height);
	}

	public void eraseCorner(Graphics aG){
		aG.setColor(Color.black);
		aG.fillOval(0, 0, width, height);

	}



	public void moveTarget(){
		
			int aNuke=(int)(Math.random()*34);
			int otherNuke=(int)(Math.random()*14);

			x=(aNuke*25);
			y=(otherNuke*25);
		
	}

	public void drawTarget( Graphics aG){
		aG.setColor(Color.white);
		aG.fillRect(x, y, width, height);

	}
	public void drawLast( Graphics aG){
		aG.setColor(Color.gray);
		aG.fillRect(x, y, width, height);

	}


}



