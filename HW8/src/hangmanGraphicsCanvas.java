
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class hangmanGraphicsCanvas extends Applet implements ActionListener{
	
	int wrong, numMatch,cgc;
	TextField [] theLetters;
	TextField aBox, wordGuess;
	Button  b1, b2;
	String code, stringTwo;
	char guessChar;
	boolean[] tester;
	boolean master, guess=true, repeat=false, start=true, go=false, third=false;
	Font fontC;
	
	TextArea toodles;
	char[] guesses;
	TextField theCode;
	Canvas c1;
	Graphics myG;
	Image background;
	
	
	public void init(){
		fontC = new Font("Superclarendon-Bold", Font.BOLD, 40);
		if(go){
			
	 		theCode=new TextField();
	 		add(theCode);
	 		theCode.addActionListener(this);
	 		
	 		start=false;
		}
		if(start){
			b2= new Button("Two Players");
			b1= new Button("One Player");
			add(b1);
			add(b2);
			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		if(third){
		try{
			background=ImageIO.read(getClass().getResourceAsStream("snow.jpg"));
		}
		catch(IOException e){
			System.out.println(e);
		}
		guesses= new char[27];
		
		aBox= new TextField("");
		wordGuess= new TextField("");
		toodles= new TextArea("");
		theLetters=new TextField[code.length()];
		
		
		
		c1= new Canvas();
		
		int x=0;
		while(x<theLetters.length){
			theLetters[x]=new TextField("");
			add(theLetters[x]);
			x++;
		}
		myG= c1.getGraphics();
		
		
		add(aBox);
		add(toodles);
		
		
		
		add(wordGuess);
		
		add(c1);
		
	
		aBox.addActionListener(this);
		wordGuess.addActionListener(this);
		aBox.requestFocus();
		}
		
		
		this.setSize(950,600);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aBox){
			repeat=false;
			
			checkAlready();
			System.out.println(repeat);
			if(repeat==false){
				checkGuess();
			}
			texter();
			validate();
			repaint();
		}
		if(e.getSource()==wordGuess){
			checkWord();
			validate();
			repaint();
		}
		if(e.getSource()==b1){
			code=generateRandomWord();
			start=false;
			b1.hide();
			b2.hide();
			third=true;
			validate();
			init();
			repaint();
		}
		if(e.getSource()==b2){
			twoPlayer();
			b1.hide();
			b2.hide();
			
			init();
			validate();
			repaint();
		}
		if(e.getSource()==theCode){
			code=theCode.getText();
			b1.hide();
			b2.hide();
			theCode.hide();
			go=false;
			third=true;
			
			init();
			validate();
			repaint();
			
		}
	}
	
	public void paint(Graphics g) {
		
		if(go){
			setBackground(Color.WHITE);
			theCode.setLocation(450,300);
	 		theCode.setSize(100,30);
	 		g.drawString("Enter the word here:", 440, 285);
		}
		if(start){
			setBackground(Color.WHITE);
			b1.setSize(135,30);
			b2.setSize(135,30);
			b1.setLocation(350 ,300);
			b2.setLocation(550 ,300);
			
		}
		
		
		if(third){
		int x=0;
		g.drawImage(background, 0,0,this.getWidth(), this.getHeight(), this);
		g.setColor(Color.black);
		
		g.fillRect(50, 500, 200, 3);//big stand thingy
		g.fillRect(150, 250, 3, 250);
		g.fillRect(150, 250, 75, 3);
		g.fillRect(225, 250, 3, 25);
		
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
			toodles.setFont(fontC);
			toodles.setText("You Lose");
			while(x<code.length()){
				
				theLetters[x].setText(code.substring(x, (x+1)));
				
				x++;
			}
			
		}
		
	x=0;
	while(x<theLetters.length){
		theLetters[x].setSize(30,30);
		theLetters[x].setLocation((300+(x*40)), 200);
		x++;
	}
	
	aBox.setSize(30,30);
	aBox.setLocation(420-86,300);
	wordGuess.setSize(100,30);
	wordGuess.setLocation(475-86, 300);
	toodles.setSize(400,175);
	toodles.setLocation(330, 380);
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.getAllFonts();
    Font fontA = new Font("Superclarendon-Bold", Font.BOLD, 35);
	g.setFont(fontA);
	g.drawString("Tyler's Hangman",300,70);
	
	Font fontB= new Font("DiwanMishafiGold", Font.BOLD, 13);
	g.setFont(fontB);
	g.drawString("This is how you are doing: ",330, 370);
	
	
	g.drawString("Letter",330, 295);
	
	
	g.drawString("Word",(475-86), 295);
	
	
	c1.setLocation(50,150);
	c1.setSize(200,375);
	c1.hide();
	}
}
	
	public void texter(){
		int x;
		
		if(!guess){
			stringTwo="The letter "+aBox.getText()+" is not in the word \n";
			if(!repeat){
				wrong++;
			}
		}
		if(guess){
			stringTwo="The letter "+aBox.getText()+" is correct \n";
		}
		checkAlready();
		String bucket;
		System.out.println(cgc);
		System.out.println(stringTwo);
		if(cgc==0){
			bucket=stringTwo;
		}
		else{
			bucket=stringTwo+toodles.getText();
		}
		x=0;
		if(!repeat){
		while(x<code.length()){
			if(tester[x]){
				theLetters[x].setText(code.substring(x, (x+1)));
			}
			x++;
		}
		}
		System.out.println(bucket);
		if(cgc>=0){
			toodles.setText(bucket);
			
		}
		if(numMatch==code.length()){
			
			toodles.setFont(fontC);
			toodles.setText("You Win!");
		
		}
		guesses[cgc]=guessChar;
		
		aBox.setText("");
	}
	
	public String generateRandomWord(){
		
		String theWord="word";
		
		int randomInt=(int)(Math.random()*42);
		
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
		if(randomInt==41){
			theWord="zoolander";
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
		cgc++;
		if(cgc>0){
		
		guessChar = aBox.getText().charAt(0);
		
		setTester();
		}
		
		
		
	}
	
	public void setTester(){
		int count=0;
		int other=0;
		while(count<code.length()){
			if(guessChar==code.charAt(count)){
				tester[count]=true;
				other++;
				guess=true;
			}
			count++;
		}
		if(other==0){
			
			guess=false;
			
		}
		numMatch=numMatch+other;
		
		
	}

	public void checkWord(){
		int x=0;
		if(wordGuess.getText().equalsIgnoreCase(code)){
			toodles.setFont(fontC);
			toodles.setText("You Win!");
			
			while(x<code.length()){
				
				theLetters[x].setText(code.substring(x, (x+1)));
				
				x++;
			}
			
		}
		else{
			toodles.setText("Nope! It was not "+wordGuess.getText()+" Keep guessing.\n"+toodles.getText());
			wrong++;
			validate();
			repaint();
		}
		wordGuess.setText("");
	}
	
 	public void checkAlready(){
		guessChar = aBox.getText().charAt(0);
		
		
		int x=0;
		while(x<27){
		if(guessChar==guesses[x]){
			stringTwo=("You already guessed that! Try a new letter. \n");
			repeat=true;
			
		}
		x++;
	}
		if(guessChar==' '){
			stringTwo=("You didn't guess anything! Enter a letter. \n");
			repeat=true;
		}
		if(aBox.getText().length()>1){
			stringTwo=("You entered too many letters! Enter one letter. \n");
			repeat=true;
		}
	
	}
	
 	public void twoPlayer(){
 		
 		go=true;
 		validate();
 		repaint();
 		
 	}
 	
}


