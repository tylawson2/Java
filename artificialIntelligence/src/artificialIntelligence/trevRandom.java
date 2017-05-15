

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class trevRandom extends Applet implements ActionListener {
	
	TextField theA;	//declare
	TextField theB;
	TextField theC;
	TextField theFeedback;
	Label theX;
	Label theEqual;
	Label divisionOne;
	Label divisionTwo;
	
	
	public void init() {
		theA = new TextField();	//instantiate
		theB = new TextField();
		theC = new TextField();
		theX = new Label("X");
		theEqual = new Label("=");
		divisionOne = new Label("_______");
		divisionTwo = new Label("_______");
		theFeedback = new TextField("Feedback");
		
		add(theA);
		add(theB);
		add(theC);
		add(theX);
		add(theEqual);
		add(divisionOne);
		add(divisionTwo);
		add(theFeedback);
		
		
		
		theA.addActionListener(this);	//make this textfield sensitive
		theB.addActionListener(this);
		theC.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int aNum=0;	//create an integer container
		int bNum=0;
		int cNum=0;
		int answer=0;
		
		
		String aNumWord = theA.getText();  //get the text
		String bNumWord = theB.getText();
		String cNumWord = theC.getText();
		
		
		aNum = Integer.parseInt(aNumWord);	//convert from String to integer	
		bNum = Integer.parseInt(bNumWord);
		cNum = Integer.parseInt(cNumWord);
	
		answer= (aNum*bNum/cNum);
		
		theFeedback.setText("x="+answer);
		
	
	}
	
	public void paint(Graphics g) {
		this.setSize(800, 400);
		theA.setSize(40, 20);
		theA.setLocation(100, 190);
		theB.setSize(40, 20);
		theB.setLocation(190, 150);
		theC.setSize(40, 20);
		theC.setLocation(190, 190);
		theX.setLocation(115, 150);
		theFeedback.setSize(80, 20);
		theFeedback.setLocation(300, 170);
		theEqual.setLocation(155, 165);
		divisionTwo.setLocation(185, 165);
		divisionOne.setLocation(95, 165);
		
		
	}
}