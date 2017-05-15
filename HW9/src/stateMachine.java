
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class stateMachine extends Applet implements ActionListener, MouseListener, MouseMotionListener {
	Button squares, circles, setSize, dragSize, eraser, spinLines;			
	Button red, blue, green, fill, empty, line, freehand, sprayPaint, black, cyan, magenta, yellow, clear, pink;
	int x1, y1, d, a, b, z, h,w, m;
	TextField width, height;
	Canvas c1, colorBar;	
	Button thin, medium, thick, spinRain;
	Graphics myG, myG2;
	float myC=0, it=0, r;
	int counter;
	boolean circlesBool=true, squareBool=false, fillBool=true, emptyBool=false, lineBool=false, FHBool=false, SPBool=false, dragger, eBool=false;
	boolean spinBool=false, rainBool=false;
	

	public void init() {
	
		circles = new Button("Circles");
		circles.setForeground(Color.red);
		squares = new Button("Squares");
		line = new Button("Line");
		freehand = new Button("Free Hand");
		sprayPaint = new Button("Spray Paint");
		eraser = new Button("Eraser");
		spinLines = new Button("Spin Lines");
		spinRain = new Button("Spin Rainbow");
		
		red = new Button("Red");
		blue = new Button("Blue");
		green = new Button("Green");
		black = new Button("Black");
		cyan = new Button("Cyan");
		magenta = new Button("Magenta");
		yellow = new Button("Yellow");
		pink = new Button("Pink");
		
		fill= new Button("Fill");
		fill.setForeground(Color.red);
		empty = new Button("Empty");
		clear = new Button("Clear");
		setSize = new Button("Set Size");
		dragSize = new Button("Drag Size");
		
		thin= new Button("Thin");
		medium= new Button("Medium");
		thick= new Button("Thick");
		
		black.setForeground(Color.red);
		width= new TextField("50");
		height= new TextField("50");
		setSize.setForeground(Color.red);
		m=1;
		thin.setForeground(Color.red);
		c1 = new Canvas();
		colorBar = new Canvas();
		
		this.setSize(1400, 1000);

		c1.setBackground(Color.white);
		
		c1.setSize(1000, 640);
		colorBar.setSize(100, 30);
		colorBar.addMouseListener(this);
		
		c1.addMouseListener(this);
		c1.addMouseMotionListener(this);

		circles.addActionListener(this);
		squares.addActionListener(this);
		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		fill.addActionListener(this);
		empty.addActionListener(this);
		line.addActionListener(this);
		freehand.addActionListener(this);
		sprayPaint.addActionListener(this);
		yellow.addActionListener(this);
		cyan.addActionListener(this);
		black.addActionListener(this);
		magenta.addActionListener(this);
		clear.addActionListener(this);
		height.addActionListener(this);
		width.addActionListener(this);
		setSize.addActionListener(this);
		dragSize.addActionListener(this);
		pink.addActionListener(this);
		eraser.addActionListener(this);
		thin.addActionListener(this);
		thick.addActionListener(this);
		medium.addActionListener(this);
		spinLines.addActionListener(this);
		spinRain.addActionListener(this);
		
		add(circles);
		add(squares);
		add(red);
		add(blue);
		add(green);
		add(c1);
		add(colorBar);
		add(fill);
		add(empty);
		add(line);
		add(freehand);
		add(sprayPaint);
		add(black);
		add(cyan);
		add(magenta);
		add(yellow);
		add(clear);
		add(width);
		add(height);
		add(setSize);
		add(dragSize);
		add(pink);
		add(eraser);
		add(thin);
		add(medium);
		add(thick);
		add(spinLines);
		add(spinRain);

		
		
		
		
		repaint();
	}

	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==circles) {
			setAllFalse();
			circlesBool=true;
			circles.setForeground(Color.red);
		}
		if(e.getSource()==sprayPaint) {
			setAllFalse();
			SPBool=true;
			sprayPaint.setForeground(Color.red);
		}
		if(e.getSource()==squares) {
			setAllFalse();
			squareBool=true;
			squares.setForeground(Color.red);
		}
		if(e.getSource()==line) {
			setAllFalse();
			lineBool=true;
			line.setForeground(Color.red);
		}
		if(e.getSource()==spinLines) {
			setAllFalse();
			spinBool=true;
			spinLines.setForeground(Color.red);
		}
		if(e.getSource()==spinRain) {
			setAllFalse();
			resetColorText();
			rainBool=true;
			spinRain.setForeground(Color.red);
		}
		if(e.getSource()==freehand) {
			setAllFalse();
			FHBool=true;
			freehand.setForeground(Color.red);
		}

		if(e.getSource() == red) {
			myG.setColor(Color.red);
			resetColorText();
			red.setForeground(Color.red);
		}
		if(e.getSource() == pink) {
			myG.setColor(Color.pink);
			resetColorText();
			pink.setForeground(Color.red);
		}
		if(e.getSource() == blue) {
			myG.setColor(Color.blue);
			resetColorText();
			blue.setForeground(Color.red);
		}
		if(e.getSource() == green) {
			myG.setColor(Color.green);
			resetColorText();
			green.setForeground(Color.red);
		}
		if(e.getSource() == black) {
			myG.setColor(Color.black);
			resetColorText();
			black.setForeground(Color.red);
		}
		if(e.getSource() == yellow) {
			myG.setColor(Color.yellow);
			resetColorText();
			yellow.setForeground(Color.red);
		}
		if(e.getSource() == cyan) {
			myG.setColor(Color.cyan);
			resetColorText();
			cyan.setForeground(Color.red);
		}
		if(e.getSource() == magenta) {
			myG.setColor(Color.magenta);
			resetColorText();
			magenta.setForeground(Color.red);
		}
		if(e.getSource()==fill) {
			emptyBool=false;
			fillBool=true;
			fill.setForeground(Color.red);
			empty.setForeground(Color.black);
		}
		if(e.getSource()==empty) {
			emptyBool=true;
			fillBool=false;
			fill.setForeground(Color.black);
			empty.setForeground(Color.red);
		}
		if(e.getSource()==clear){
			myG.clearRect(0, 0, 1000, 640);
		}
		if(e.getSource()==setSize) {
			dragger=false;
			setSize.setForeground(Color.red);
			dragSize.setForeground(Color.black);
		}
		if(e.getSource()==dragSize) {
			dragger=true;
			setSize.setForeground(Color.black);
			dragSize.setForeground(Color.red);
		}
		if(e.getSource()==eraser){
			setAllFalse();
			resetColorText();
			fill.setForeground(Color.black);
			empty.setForeground(Color.black);
			setSize.setForeground(Color.black);
			dragSize.setForeground(Color.black);
			eBool=true;
			eraser.setForeground(Color.red);
		}
		if(e.getSource()==dragSize) {
			dragger=true;
			setSize.setForeground(Color.black);
			dragSize.setForeground(Color.red);
		}
		if(e.getSource()==thin) {
			m=1;
			medium.setForeground(Color.black);
			thick.setForeground(Color.black);
			thin.setForeground(Color.red);
		}
		if(e.getSource()==medium) {
			m=3;
			medium.setForeground(Color.red);
			thick.setForeground(Color.black);
			thin.setForeground(Color.black);
		}
		if(e.getSource()==thick) {
			m=5;
			medium.setForeground(Color.black);
			thick.setForeground(Color.red);
			thin.setForeground(Color.black);
		}
		
	}

	public void mousePressed(MouseEvent e) {
		if(e.getSource()==c1){
		if(squareBool) {
			h=Integer.parseInt(height.getText());
			w=Integer.parseInt(width.getText());
			if(dragger){
				a=e.getX();
				b=e.getY();
			}
			else{
				if(emptyBool){
					myG.drawRect(e.getX()-(w/2), e.getY()-(h/2), w, h);	
				}
				if(fillBool){
					myG.fillRect(e.getX()-(w/2), e.getY()-(h/2), w, h);	
				}
			}
		}

		if(circlesBool) {
			h=Integer.parseInt(height.getText());
			w=Integer.parseInt(width.getText());
			if(dragger){
				a=e.getX();
				b=e.getY();
			}
			else{
				if(emptyBool){
					myG.drawOval(e.getX()-(w/2), e.getY()-(h/2), w, h);	
				}
				if(fillBool){
					myG.fillOval(e.getX()-(w/2), e.getY()-(h/2), w, h);
				}
			}
		}
		if(lineBool||spinBool||rainBool){
			x1=e.getX();
			y1=e.getY();
		}
		if(FHBool){
			a=e.getX();
			b=e.getY();
		}
		if(SPBool){
			x1=e.getX();
			y1=e.getY();	
			z=0;
			while(z<10){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*5)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 3,3);
					z++;
				}
			}
			z=0;
			while(z<7){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*13)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 4,4);
					z++;
				}
			}
			z=0;
			while(z<15){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*5)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 2,2);
					z++;
				}
			}
			z=0;
			while(z<40){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*5)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 1,1);
					z++;
				}
			}
			z=0;
		}
		if(eBool){
			myG.setColor(Color.white);
			myG.fillOval(e.getX()-10, e.getY()-10, 50, 50);
		}
		}
	}

	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==c1){
		if(lineBool||spinBool){
			myG.drawLine(x1, y1, e.getX(), e.getY());
		}
		if(squareBool&&dragger){
			x1=e.getX();
			y1=e.getY();
			if(x1>a&&y1>b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawRect(a, b, w, h);	
				}
				if(fillBool){
					myG.fillRect(a, b, w, h);	
				}
			}
			if(x1<a&&y1>b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawRect(x1, b, w, h);	
				}
				if(fillBool){
					myG.fillRect(x1, b, w, h);	
				}
			}
			if(x1<a&&y1<b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawRect(x1, y1, w, h);	
				}
				if(fillBool){
					myG.fillRect(x1, y1, w, h);	
				}
			}
			if(x1>a&&y1<b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawRect(a, y1, w, h);	
				}
				if(fillBool){
					myG.fillRect(a, y1, w, h);	
				}
			}
		}
		if(circlesBool&&dragger){
			x1=e.getX();
			y1=e.getY();
			if(x1>a&&y1>b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawOval(a, b, w, h);	
				}
				if(fillBool){
					myG.fillOval(a, b, w, h);	
				}
			}
			if(x1<a&&y1>b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawOval(x1, b, w, h);	
				}
				if(fillBool){
					myG.fillOval(x1, b, w, h);	
				}
			
			}
			if(x1<a&&y1<b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawOval(x1, y1, w, h);	
				}
				if(fillBool){
					myG.fillOval(x1, y1, w, h);	
				}
			}
			if(x1>a&&y1<b){
				w=Math.abs(x1-a);
				h=Math.abs(y1-b);
				if(emptyBool){
					myG.drawOval(a, y1, w, h);	
				}
				if(fillBool){
					myG.fillOval(a, y1, w, h);	
				}
			}
		}
		}
	}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		if(e.getSource()==c1){
		if(FHBool){
			z=0;
			while(z<m){
				myG.drawLine(a+z, b+z, e.getX()+z, e.getY()+z);
			z++;
			}
			a=e.getX();
			b=e.getY();
		}	
		if(SPBool){
			x1=e.getX();
			y1=e.getY();	
			z=0;
			while(z<10){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z)/10, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 3,3);
					z++;
				}
			}
			z=0;
			while(z<7){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*5)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 4,4);
					z++;
				}
			}
			z=0;
			while(z<15){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				if(d<20){
					myG.setColor(Color.getHSBColor((float)(z*5)/100, (float)1.0, (float)1.0));
					myG.fillOval(a,b, 2,2);
					z++;
				}
			}
			z=0;
		while(z<40){
				
				a=(int)(Math.random()*40)+(-20);
				a=a+x1;
				b=(int)(Math.random()*40)+(-20);
				b=b+y1;
				d=(int)Math.sqrt(((a-x1)*(a-x1))+((b-y1)*(b-y1)));
				if(d<20){
					myG.fillOval(a,b, 1,1);
					z++;
				}
			}
			z=0;
		}
		if(lineBool){
			myG.setColor(Color.white);
			myG.drawLine(x1, y1, a, b);
			a=e.getX();b=e.getY();
			myG.setColor(Color.gray);
			myG.drawLine(x1, y1, a, b);
		}
		if(eBool){
			myG.setColor(Color.white);
			myG.fillOval(e.getX()-25, e.getY()-25, 50, 50);
		}
		if(spinBool){
			myG.drawLine(x1, y1, e.getX(), e.getY());
		}
		if(rainBool){
			myC=myC+(float)0.015;
			myG.setColor(Color.getHSBColor(myC, (float)1.0, (float)1.0));
			myG.drawLine(x1, y1, e.getX(), e.getY());
		}
		}
	}

	public void paint(Graphics g) {	
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    ge.getAllFonts();
	    Font fontA = new Font("Superclarendon-Bold", Font.BOLD, 15);
	    g.setFont(fontA);
	    g.fillRect(215, 115, 1010, 5);
	    g.fillRect(215, 760, 1010, 5);
	    g.fillRect(215, 115, 5, 650);
	    g.fillRect(1220, 115, 5, 650);
		g.drawString("Colors:", 150, 45);
		g.drawString("Action:", 20,130);
		g.drawString("Filler:", 20,405);
		Font fontC = new Font("Superclarendon-Bold", Font.BOLD, 13);
		colorBar.setLocation(1260,600);
		Font fontB = new Font("Superclarendon-Bold", Font.CENTER_BASELINE, 35);
		myG = c1.getGraphics();	
		myG2=colorBar.getGraphics();
		c1.setLocation(220, 120);
		
	
		circles.setLocation(10, 140);
		squares.setLocation(10, 170);
		line.setLocation(10, 200);
		freehand.setLocation(10, 230);
		sprayPaint.setLocation(10, 260);
		spinLines.setLocation(10,290);
		spinRain.setLocation(10,320);
		fill.setLocation(90, 380);
		empty.setLocation(90, 410);
		
		thin.setLocation(120, 170);
		medium.setLocation(120,220);
		thick.setLocation(120, 270);
		
		g.setFont(fontB);
		g.drawString("Tyler's Paint", 1000, 63);
		g.fillRect(990, 23, 280, 5);
		g.fillRect(990, 78, 280, 5);
		g.fillRect(990, 23, 5, 55);
		g.fillRect(1270, 23, 5, 60);
		red.setLocation(220, 25);
		blue.setLocation(300, 25);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		red.setBackground(Color.red);
		black.setBackground(Color.black);
		yellow.setBackground(Color.yellow);
		cyan.setBackground(Color.cyan);
		magenta.setBackground(Color.magenta);
		pink.setBackground(Color.pink);
		green.setLocation(380, 25);
		black.setLocation(460, 25);
		cyan.setLocation(540, 25);
		yellow.setLocation(620, 25);
		magenta.setLocation(710, 25);
		pink.setLocation(810, 25);
		
		Font fontD = new Font("DiwanMishafiGold", Font.BOLD, 35);
		clear.setFont(fontD);
		clear.setSize(140, 60);
		clear.setLocation(1245,350);
		g.setFont(fontC);
		width.setSize(50,30);
		height.setSize(50,30);
		width.setLocation(50, 585);
		height.setLocation(110, 585);
		g.drawString("Height", 109, 578);
		g.drawString("Width", 50, 578);
		setSize.setLocation(13,498);
		dragSize.setLocation(105, 498);
		
		eraser.setFont(fontD);
		eraser.setLocation(1245,250);
		
		eraser.setSize(140, 60);
		
		it=0;
		counter=0;
		
		while((int)it<1){
			//System.out.println("I am in"+it);
			myG2.setColor(Color.getHSBColor(it, (float)1.0, (float)1.0));
			myG2.drawLine(counter, 0, counter, 30);
			it=it+(float).01;
			counter++;
		}
		r++;
		System.out.println(r);
		
}
	

	public void setAllFalse(){
		circlesBool=false;
		squareBool=false;
		lineBool=false;
		FHBool=false;
		SPBool=false;
		spinBool=false;
		rainBool=false;
		circles.setForeground(Color.black);
		squares.setForeground(Color.black);
		line.setForeground(Color.black);
		freehand.setForeground(Color.black);
		sprayPaint.setForeground(Color.black);
		spinLines.setForeground(Color.black);
		spinRain.setForeground(Color.black);
		
		eBool=false;
		eraser.setForeground(Color.black);
	}
	
	public void resetColorText(){
		red.setForeground(Color.black);
		black.setForeground(Color.black);
		blue.setForeground(Color.black);
		cyan.setForeground(Color.black);
		magenta.setForeground(Color.black);
		pink.setForeground(Color.black);
		yellow.setForeground(Color.black);
		green.setForeground(Color.black);
		
	}
	
}
