import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class firstApplet extends Applet implements ActionListener{
	Button b1, b2, b3, b4, b5;
	TextField t1, t2, t3; 
	Label l1;
	int globalCount, hb2, wb2, changeCount;
	int toggleCount=1;
	
public void init(){
	b1= new Button("Copy");
	b2= new Button("Add");
	b3= new Button("Change");
	b4= new Button("Toggle");
	b5= new Button("Animate");
	
	t1= new TextField();
	t2= new TextField();
	t3=new TextField();
	
	l1= new Label("First Applet");
	
	add(b1); 
	add(b2);
	add(b3);
	add(b4);
	add(b5);
	add(t1);
	add(t2);
	add(t3);
	add(l1);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	b5.addActionListener(this);
	t1.addActionListener(this);
	t2.addActionListener(this);
	t3.addActionListener(this);
	
	this.setSize(500,700);
	
	
	
}
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1){
		t2.setText(t1.getText());
		t1.setText("");
		globalCount++;
		if(globalCount%2==0){
			b2.show();
		}
		else{
			b2.hide();
		}
	}
	if(e.getSource()==t1){
		t2.setText(t1.getText());
		t1.setText("");
	}
	if(e.getSource()==b2){
		t3.setText(String.valueOf((Integer.parseInt(t2.getText()))+(Integer.parseInt(t1.getText()))));
	}
	if(e.getSource()==b3){
		wb2=(Integer.parseInt(t1.getText()));
		hb2=(Integer.parseInt(t2.getText()));
		changeCount++;
		validate();
		repaint();
	}
	if(e.getSource()==b4){
		toggleCount++;
		validate();
		repaint();
	}
	
}
public void paint(Graphics g) {
	b1.setLocation(10,600);
	b2.setSize(50,150);
	b3.setLocation(250,670);
	b4.setLocation(350,670);
	b5.setLocation(150,670);
	g.setColor(Color.black);
	g.drawLine(50, 250, 400, 500);
	g.drawLine(400, 250, 50, 500);
	t1.setSize(100,20);
	t2.setSize(100,20);
	t3.setSize(100,20);
	t1.setLocation(280, 20);
	t2.setLocation(280, 50);
	t3.setLocation(280, 80);
	l1.setLocation(15,15);
	g.drawOval(0,160, 440, 440);
	g.drawOval(0, 350, 440, 50);
	if(changeCount>0){
		b1.setSize(wb2, hb2);
	}
	
	 if(toggleCount%2==0){
		 setBackground(Color.red);
		}
	else{
		 setBackground(Color.blue);
	 }
	 
}
	
	
	
	
}
