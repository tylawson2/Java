
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class recursion extends Applet implements ActionListener, MouseListener, MouseMotionListener {
	Button clear, circInCirc, weirdCirc, square, circFun, triSquare, triangle, sun, bumps, triSwirl;
	Canvas c1;
	TextField start, end;
	Graphics myG;
	double x,y, theStart;
	Boolean circBool, weirdBool, squareBool, funBool,tsqbool, triBool, sunBool, north, east, south, west,bumpBool, firstPoints, triSwirlBool;
	Point p1, p2, p3;
	Point[] bp;
	int bpc, dc;
	
	
	
	public void init() {
	
		clear= new Button("Clear");
		weirdCirc= new Button("Weird Circles");
		circInCirc= new Button ("Circles Inside of Circles");
		square= new Button ("Squares");
		circFun= new Button ("Ridiculous Circles");
		triSquare= new Button ("Triangular Squares");
		triangle= new Button ("Triangles");
		sun= new Button("Sun");
		bumps= new Button("Bumps");
		bumps= new Button("Triangular Swirl");
		c1= new Canvas();
		start= new TextField("400");
		end= new TextField("50");
		p1= new Point();
		p2= new Point();
		p3= new Point();
		bp= new Point[10000];
		bpc=0;
		while(bpc<10000){
			bp[bpc]=new Point();
			bpc++;
		}
		bpc=0;
		
		clear.addActionListener(this);
		c1.setBackground(Color.white);
		c1.addMouseListener(this);
		c1.addMouseMotionListener(this);
		c1.setSize(500,500);
		
		circInCirc.addActionListener(this);
		weirdCirc.addActionListener(this);
		square.addActionListener(this);
		circFun.addActionListener(this);
		triSquare.addActionListener(this);
		triangle.addActionListener(this);
		sun.addActionListener(this);
		bumps.addActionListener(this);
		triSwirl.addActionListener(this);
		
		add(clear);
		add(circInCirc);
		add(c1);
		add(start);
		add(end);
		add(weirdCirc);
		add(square);
		add(circFun);
		add(triSquare);
		add(triangle);
		add(sun);
		add(bumps);
		add(triSwirl);
		
		this.setSize(1100, 750);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==clear){
			myG.clearRect(0, 0, c1.getWidth(), c1.getHeight());
		}
		if(e.getSource()==circInCirc){
		
			setAllFalse();
			circBool=true;
		}
		if(e.getSource()==weirdCirc){
		
			setAllFalse();
			weirdBool=true;
		}
		if(e.getSource()==square){
		
			setAllFalse();
			squareBool=true;
		}
		if(e.getSource()==circFun){
		
			setAllFalse();
			funBool=true;
		}
		if(e.getSource()==triSquare){
		
			setAllFalse();
			tsqbool=true;
		}
		if(e.getSource()==triangle){
		
			setAllFalse();
			triBool=true;
		}
		if(e.getSource()==sun){
			
			setAllFalse();
			sunBool=true;
		}
		if(e.getSource()==bumps){
			
			setAllFalse();
			bumpBool=true;
			firstPoints=true;
		}
	}

	public void mousePressed(MouseEvent e) {
		theStart=Integer.parseInt(start.getText());
		if(circBool){
			drawCircs(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart);
		}
		if(weirdBool){
			drawWeird(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart);
		}
		if(squareBool){
			drawSquares(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart);
		}
		if(funBool){
			drawFunCirc(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart);
		}
		if(tsqbool){
			drawTriSquare(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart);
		}
		if(triBool){
			drawTriangles(e.getX(),e.getY(), theStart);
		}
		if(sunBool){
			north=true;
			south=true;
			east=true;
			west=true;
			drawSun(e.getX()-(theStart/2),e.getY()-(theStart/2), theStart, north, south, east, west);	
		}
		if(bumpBool){
			north=true;
			south=true;
			east=true;
			west=true;
			drawBumps(e.getX(),e.getY(), theStart, true, south, east, west);	
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
		
		c1.setLocation(250, 100);
		clear.setLocation(300,50);
		circInCirc.setLocation(50, 200);
		weirdCirc.setLocation(50, 240);
		square.setLocation(50, 280);
		circFun.setLocation(50, 320);
		triSquare.setLocation(50,360);
		triangle.setLocation(50,400);
		sun.setLocation(50,440);
		
		start.setLocation(500,50);
		end.setLocation(570,50);
		start.setSize(50, 30);
		end.setSize(50,30);
		g.drawString("Start", 500, 45);
		g.drawString("End", 570, 45);
}
	

	public void setAllFalse(){
		weirdBool=false;
		circBool=false;
		squareBool=false;
		funBool=false;
		tsqbool=false;
		triBool=false;
		sunBool=false;
		bumpBool=false;
	}
	
	
		
		
	

	public void drawCircs(double x, double y, double starting){
		myG.drawOval((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			drawCircs(x+5, y+5, starting-10);
		}
	}
	
	public void drawWeird(double x, double y, double starting){
		myG.drawOval((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			drawWeird(x, y, starting/2);
			drawWeird(x, y+(starting/2),starting/2);
		}
	}
	
	public void drawSquares(double x, double y, double starting){
		myG.drawRect((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			drawSquares(x, y+(starting/2), starting/2);
			drawSquares(x+(starting/2), y+(starting/3),starting/2);
		}
	}
	
	public void drawFunCirc(double x, double y, double starting){
		myG.drawOval((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			drawFunCirc(x, y+(starting/4), starting/2);
			drawFunCirc(x+(starting/2), y+(starting/4),starting/2);
			drawFunCirc(x+(starting/3), y,starting/3);
			drawFunCirc(x+(starting/3), y+((starting*2)/3),starting/3);
		}
	}
	
	public void drawTriSquare(double x, double y, double starting){
		myG.drawRect((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			drawTriSquare(x+(starting/4), y, starting/2);
			drawTriSquare(x, y+(starting/2),starting/2);
			drawTriSquare(x+(starting/2), y+(starting/2),starting/2);
		}
	}
	
	public void drawTriangles(double x, double y, double starting){
		
		System.out.println("x");
		int x1, y1, size1;
		x1=(int)x;
		y1=(int)y;
		size1=(int)starting;
		
		p1.setLocation(x1, y1-(size1/2));
		p2.setLocation(x1+(size1/2), y1+(size1/2));
		p3.setLocation(x1-(size1/2), y1+(size1/2));
		
		myG.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
		myG.drawLine((int)p1.getX(), (int)p1.getY(), (int)p3.getX(), (int)p3.getY());
		myG.drawLine((int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
		
		if(starting>Integer.parseInt(end.getText())){
			drawTriangles(x, y-(starting/4), starting/2);
			drawTriangles(x+(starting/4), y+(starting/4),starting/2);
			drawTriangles(x-(starting/4), y+(starting/4),starting/2);
		}
	}
	
	public void drawSun(double x, double y, double starting, boolean north, boolean south, boolean east, boolean west){
		myG.drawOval((int)x, (int)y, (int)starting, (int)starting);
		if(starting>Integer.parseInt(end.getText())){
			if(north){
				drawSun(x+(starting/4), y-(starting/2),(starting/2),true, false,  true,  true);
			}
			if(south){
				drawSun(x+(starting/4), y+starting, (starting/2),false, true,  true,  true);
			}
			if(west){
				drawSun(x-starting/2, y+(starting/4),(starting/2),true, true,  false,  true);
			}
			if(east){
				drawSun(x+starting, y+(starting/4),(starting/2),true, true,  true,  false);
			}
		}
	}

	public void drawBumps(double x, double y, double starting, boolean north, boolean south, boolean east, boolean west){
		
		if(firstPoints){
			bp[bpc].setLocation((int)x, (int)y);
			bpc++;
			bp[bpc].setLocation((int)x, (int)(y+starting));
			bpc++;
			firstPoints=false;
		}
		
		
		
		
	}
	
	
	public double getDistance(Point a, Point b){
		double d= Math.sqrt(((int)(b.getX()+a.getX())^2)+((int)(b.getY()+a.getY())^2));
		return d;
	}
	
public void triSwirl(double x, double y, double starting){
		
	
		int x1, y1, size1;
		x1=(int)x;
		y1=(int)y;
		size1=(int)starting;
		
		p1.setLocation(x1, y1-(size1/2));
		p2.setLocation(x1+(size1/2), y1+(size1/2));
		p3.setLocation(x1-(size1/2), y1+(size1/2));
		
		myG.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
		myG.drawLine((int)p1.getX(), (int)p1.getY(), (int)p3.getX(), (int)p3.getY());
		myG.drawLine((int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
		
		if(starting>Integer.parseInt(end.getText())){
			drawTriangles(x+(starting/20), y-(starting/4), starting-(starting/20));
			
		}
	}
	
}