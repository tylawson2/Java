import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class appletChallenge extends Applet implements ActionListener{
	Button b1, b2;
	int b1C, b2C;
	
	public void init(){
		
		b1= new Button("Left To Right Cross");
		b2= new Button("Bounce");
		
		add(b1); 
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		this.setSize(500,700);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			b1C++;
			validate();
			repaint();
		}
		if(e.getSource()==b2){
			b2C++;
			validate();
			repaint();
		}
	}
	
	
	public void paint(Graphics g) {
		
		setBackground(Color.white);
		b1.setLocation(10,20);
		b2.setLocation(200,20);
		if(b1C>0){
			int x=50;
		
		int y=300;
		int a=50;
		int b= 50;
		while(x<300){
			g.setColor(Color.black);
			g.fillOval(x,y, 50, 50);
			g.fillOval(a,b, 50, 50);
			try{
				Thread.sleep(15);
			}
			catch(Exception e){
				System.out.println("This went wrong: "+e);
			}
			g.setColor(Color.white);
			g.fillOval(x,y, 50, 50);
			g.fillOval(a,b, 50, 50);
			x++;
			y--;
			a++;
			b++;

		}
		
		g.setColor(Color.black);
		g.fillOval(x,y, 50, 50);
		g.fillOval(a,b, 50, 50);
		b1C--;
		}
		int height=(int)this.getHeight();
		if(b2C>0){
			int y=50;
			while(y<(height-250)){
			
			g.setColor(Color.black);
			g.fillOval(50,y, 50, 50);
			try{
				Thread.sleep(15);
			}
			catch(Exception e){
				System.out.println("This went wrong: "+e);
			}
			g.setColor(Color.white);
			g.fillOval(50,y, 50, 50);
			y++;
		}
			g.setColor(Color.black);
			g.fillOval(50,y, 50, 50);
			while(y>50){
				
				g.setColor(Color.black);
				g.fillOval(50,y, 50, 50);
				try{
					Thread.sleep(15);
				}
				catch(Exception e){
					System.out.println("This went wrong: "+e);
				}
				g.setColor(Color.white);
				g.fillOval(50,y, 50, 50);
				y--;
			}
			g.setColor(Color.black);
			g.fillOval(50,y, 50, 50);
			b2C--;
		}		
	}
	
	
	
	
	
}
