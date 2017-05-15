
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

public class daGame extends Applet implements ActionListener, MouseListener, MouseMotionListener {
	Button start;			
	thing theOne;
	thing[] theOnes;
	TextField numBoxes, deadOrAlive, highScore;
	Timer timer;
	int a, b, z, j, t, c, x, p, v, hs;
	Canvas c1;	
	Boolean[] startBool;
	Boolean checkBool=false;
	Graphics myG, thingG;
	Image gameOver;
	
	

	public void init() {
	
		
		
		timer=new Timer();
		start = new Button("Start");
		deadOrAlive = new TextField("Alive");
		highScore = new TextField("");
		c1 = new Canvas();
		theOne= new thing();
		
		theOnes=new thing[500];
		startBool=new Boolean[500];
		try{
			gameOver=ImageIO.read(getClass().getResourceAsStream("lastImage.jpg"));
			System.out.println("got pic");
		}
		catch(IOException e){
			System.out.println(e);
		}
		
		j=0;
		while(j<500){
			theOnes[j]= new thing();
			startBool[j]=false;
			
			j++;
		}
		
		numBoxes= new TextField("0 Boxes");
		
		
		this.setSize(1000, 1000);

	
		
		c1.setSize(650, 640);
		
		
		c1.addMouseListener(this);
		c1.addMouseMotionListener(this);

	
		start.addActionListener(this);
		
	
	
		
		
		add(c1);
		add(numBoxes);
		add(start);
		add(deadOrAlive);
		add(highScore);
		

		repaint();
	}

	public void actionPerformed(ActionEvent e) {	
		

		if(e.getSource()==start){
			deadOrAlive.setText("Alive");
			
			timer=new Timer();
			myG.clearRect(0, 0, c1.getWidth(), c1.getHeight());
			theOnes[z].startPoint(startBool[0]);
			theOnes[z].draw(thingG);
			
			Looper(1);
			start.hide();
		}

		
		
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void Looper(float hundredth) {
		//if(p==2500){
		//	p=0;
		//	v++;
		//}
		timer.schedule(new RemindTask(), 0, (int)(hundredth*10));
		
		}
		class RemindTask extends TimerTask {
		
			public void run() {
				x=0;
				t++;
				//p++;
				if(t==500){
					z++;
					t=0;
				}
				//System.out.println("passed if"+z);
				while(x<=z){
					theOnes[x].erase(thingG);
					theOnes[x].move(startBool[x]);
					theOnes[x].draw(thingG);
					
					if(startBool[x]==false){
						theOnes[x].erase(thingG);
						startBool[x]=theOnes[x].startPoint(startBool[x]);
						theOnes[x].draw(thingG);
						c++;
						//System.out.println(c+"c");
						
					}
					
					if(c==1){
						numBoxes.setText(c+" box");
					}
					else{
						numBoxes.setText(c+" boxes");
						
					}
					if(c>hs){
						hs=c;
						if(hs==1){
							highScore.setText(hs+" box");
						}
						else{
							highScore.setText(hs+" boxes");
							
						}
					}
					
					checkBool=theOnes[x].tester(checkBool, a+10, b+10);
					
					if(checkBool){
						deadOrAlive.setText("Dead");
						z=0;t=0; a=0;  b=0; j=0; c=0; x=0; p=0; v=0;
						timer.cancel();	
						checkBool=false;
						myG.drawImage(gameOver, 100, 250, null);
						j=0;
						while(j<500){
							theOnes[j].reset();
							startBool[j]=false;
							j++;
						}
						
						start.show();
						System.out.println("Ready to restart");
					}
					//System.out.println("x is "+x);
					
					x++;
				}
				//System.out.println("passed while"+z);
				
				
			} 
		
	}
	
	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {
		myG.setColor(Color.white);
		myG.fillRect(a, b,20,20);
		a=e.getX()-10;
		b=e.getY()-10;
		myG.setColor(Color.GREEN);
		myG.fillRect(a, b,20,20);
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		myG.setColor(Color.white);
		myG.fillRect(a, b,20,20);
		a=e.getX()-10;
		b=e.getY()-10;
		myG.setColor(Color.GREEN);
		myG.fillRect(a, b,20,20);
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}

	public void paint(Graphics g) {	
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    ge.getAllFonts();
	    Font fontA = new Font("Superclarendon-Bold", Font.BOLD, 15);
	    g.setFont(fontA);
	    g.setColor(Color.red);
	    g.fillRect(215, 115, 660, 5);
	    g.fillRect(215, 760, 660, 5);
	    g.fillRect(215, 115, 5, 650);
	    g.fillRect(870, 115, 5, 650);
		
		
	   
		Font fontB = new Font("Superclarendon-Bold", Font.CENTER_BASELINE, 35);
		myG = c1.getGraphics();	
		thingG = c1.getGraphics();	
		c1.setBackground(Color.white);
		c1.setLocation(220, 120);
		g.setColor(Color.black);
		g.setFont(fontB);
		g.drawString("Tyler's Game", 400, 63);
		
		g.fillRect(390, 23, 280, 5);
		g.fillRect(390, 78, 280, 5);
		g.fillRect(390, 23, 5, 55);
		g.fillRect(670, 23, 5, 60);

		
		Font fontD = new Font("DiwanMishafiGold", Font.BOLD, 35);
		Font fontC = new Font("DiwanMishafiGold", Font.BOLD, 25);
		start.setFont(fontD);
		numBoxes.setFont(fontC);
		start.setSize(140, 60);
		start.setLocation(40,350);
		numBoxes.setSize(165,40);
		numBoxes.setLocation(30, 450);
		deadOrAlive.setFont(fontC);
		deadOrAlive.setSize(165,40);
		deadOrAlive.setLocation(30, 500);
		highScore.setFont(fontC);
		highScore.setSize(165,40);
		highScore.setLocation(30, 600);
		g.setFont(fontA);
		g.drawString("Your High Score:", 30, 590);
		
		
		
		
	
		
}
	
	
}



class thing{
	
	int x=0;
	int y=0;
	int selector;
	int z=100;
	int width=50;
	int height=50;
	
	public thing(){
		//System.out.println("A thing was made!");
	}
	
	public void draw(Graphics aG){
		aG.setColor(Color.blue);
		aG.fillRect(x, y, width, height);
	}
	
	public void erase(Graphics aG){
		aG.setColor(Color.white);
		aG.fillRect(x, y, width, height);
	
	}
	
	public void move(Boolean start){
		
		if(!start){
			selector=(int)(Math.random()*3);
		}
		if(selector==0){
			x=x+1;
			y=y+1;
			if(x==600){
				selector=1;
			}
			if(y==590){
				selector=2;
			}
			if(x==600&&y==590){
				selector=3;
			}
		}
		if(selector==1){
			x=x-1;
			y=y+1;
			if(x==0){
				selector=0;
			}
			if(y==590){
				selector=3;
			}
			if(x==0&&y==590){
				selector=2;
			}
			
		}
		if(selector==2){
			x=x+1;
			y=y-1;
			if(x==600){
				selector=3;
			}
			if(y==0){
				selector=0;
			}
			if(x==600&&y==0){
				selector=1;
			}
		}
		if(selector==3){
			x=x-1;
			y=y-1;
			if(x==0){
				selector=2;
			}
			if(y==0){
				selector=1;
			}
			if(x==0&&y==590){
				selector=0;
			}
		}
		
	}
	
	public boolean startPoint(Boolean start){
		x=275+((int)(Math.random()*80)+-40);
		y=275+((int)(Math.random()*80)+-40);;
		return start=true;
	}
	
	public boolean tester(Boolean check, int cx, int cy){
		
		
		
		if(cx>=x&&cx<=x+50&&cy>=y&&cy<=y+50){
			check=true;
		}
		
		return check;
	}
	
	public void reset(){
		
		x=-400;
		y=-400;
		
	}
	
}


