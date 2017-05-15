import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class hangmanGraphics extends Applet implements ActionListener{
	
	int wrong, numMatch,cgc;
	TextField [] theLetters;
	TextField aBox, winOrLose;
	Button guessButton;
	String code=generateRandomWord();
	boolean[] tester;
	boolean master;
	
	
	public void init(){
		checkGuess();
		guessButton= new Button("Guess");
		aBox= new TextField("");
		winOrLose= new TextField("");
		theLetters=new TextField[code.length()];
		int x=0;
		while(x<theLetters.length){
			theLetters[x]=new TextField("");
			add(theLetters[x]);
			x++;
		}
		add(guessButton);
		add(aBox);
		add(winOrLose);
		
		guessButton.addActionListener(this);
		aBox.addActionListener(this);
		
		this.setSize(800,600);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guessButton||e.getSource()==aBox){
			checkGuess();
			validate();
			repaint();
			
		}
	}

	public void paint(Graphics g) {
		int x=0;
		setBackground(Color.white);
		g.setColor(Color.black);
		g.drawLine(50, 500, 250, 500);//big stand thingy
		g.drawLine(150, 500, 150, 250);
		g.drawLine(150, 250, 225, 250);
		g.drawLine(225, 250, 225, 275);
		
		if(wrong>0){
			g.drawOval(200, 275, 50, 50);//head
		}
		if(wrong>1){
			g.drawLine(225, 325, 225, 400);//body
		}
		if(wrong>2){
			g.drawLine(225, 400, 200, 450);//legs
		}
		if(wrong>3){
			g.drawLine(225, 400, 250, 450);
		}
		if(wrong>4){
			g.drawLine(225, 350, 265, 325);//arms
		}
		if(wrong>5){
			g.drawLine(225, 350, 185, 325);
			winOrLose.setText("You Lose");
			while(x<code.length()){
				
				theLetters[x].setText(code.substring(x, (x+1)));
				
				x++;
			}
		}
		
	x=0;
	while(x<theLetters.length){
		theLetters[x].setSize(30,30);
		theLetters[x].setLocation((300+(x*45)), 200);
		x++;
	}
	guessButton.setLocation(325, 300);
	aBox.setSize(30,30);
	aBox.setLocation(420,300);
	winOrLose.setSize(150,30);
	winOrLose.setLocation(325, 380);	
	x=0;
	while(x<code.length()){
		if(tester[x]){
			theLetters[x].setText(code.substring(x, (x+1)));
		}
		x++;
	}
	if(numMatch==code.length()){
		winOrLose.setText("You Win");
	}
	aBox.setText("");
	
	}
	
	public String generateRandomWord(){
		
		String theWord="word";
		
		int randomInt=(int)(Math.random()*41);
		
		if(randomInt==0){
			theWord="abruptly";
		}
		if(randomInt==1){
			theWord="bandwagon";		
		}
		if(randomInt==2){
			theWord="bookworm";	
		}
		if(randomInt==3){
			theWord="education";	
		}
		if(randomInt==4){
			theWord="glowworm";	
		}
		if(randomInt==5){
			theWord="jawbreaker";	
		}
		if(randomInt==6){
			theWord="pneumonia";	
		}
		if(randomInt==7){
			theWord="schizophrenia";	
		}
		if(randomInt==8){
			theWord="vaporize";	
		}
		if(randomInt==9){
			theWord="jazz";	
		}
		if(randomInt==10){
			theWord="xylophone";	
		}
		if(randomInt==11){
			theWord="wizard";	
		}
		if(randomInt==12){
			theWord="phlegm";	
		}
		if(randomInt==13){
			theWord="athletics";	
		}
		if(randomInt==14){
			theWord="redskin";	
		}
		if(randomInt==15){
			theWord="ball";	
		}
		if(randomInt==16){
			theWord="jesus";	
		}
		if(randomInt==17){
			theWord="aardvark";
		}
		if(randomInt==18){
			theWord="green";
		}
		if(randomInt==19){
			theWord="hazard";
		}	
		if(randomInt==20){
			theWord="computer";
		}
		if(randomInt==21){
			theWord="intelligence";
		}
		if(randomInt==22){
			theWord="artificial";
		}
		if(randomInt==23){
			theWord="dictionary";
		}
		if(randomInt==24){
			theWord="mouse";
		}
		if(randomInt==25){
			theWord="handler";
		}
		if(randomInt==26){
			theWord="sneaker";
		}
		if(randomInt==27){
			theWord="basketball";
		}
		if(randomInt==28){
			theWord="baseball";
		}
		if(randomInt==29){
			theWord="football";
		}
		if(randomInt==30){
			theWord="bible";
		}
		if(randomInt==31){
			theWord="chicken";
		}
		if(randomInt==32){
			theWord="integrate";
		}
		if(randomInt==33){
			theWord="superman";
		}
		if(randomInt==34){
			theWord="bottle";
		}
		if(randomInt==35){
			theWord="blackboard";
		}
		if(randomInt==36){
			theWord="yellow";
		}
		if(randomInt==37){
			theWord="black";
		}
		if(randomInt==38){
			theWord="impossible";
		}
		if(randomInt==39){
			theWord="pencil";
		}
		if(randomInt==40){
			theWord="lugubrious";
		}
		
		return theWord;
	}

	public static boolean[] setBool(boolean[] theBool){
		int x=0;
		boolean go=true;
		
		while(go){
			theBool[x]=false;
			x++;
			if(x==theBool.length){
				go=false;
			}
		}
		return theBool;
	}

	public void checkGuess(){
		if(cgc==0){
			
			tester= new boolean[code.length()];
			tester=setBool(tester);
			
		}
		if(cgc>0){
		
		char theGuess = aBox.getText().charAt(0);
		tester=setTester(tester, theGuess, code);
		}
		cgc++;
		validate();
		repaint();
		
	}
	
	public boolean [] setTester(boolean [] tester, char theLetter, String theWord){
		int count=0;
		int other=0;
		while(count<theWord.length()){
			if(theLetter==theWord.charAt(count)){
				tester[count]=true;
				other++;
				
				
			}
			count++;
		}
		if(other==0){
			wrong++;
		}
		numMatch=numMatch+other;
		
		return tester;
	}
	
}
