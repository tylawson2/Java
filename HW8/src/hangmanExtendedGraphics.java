import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class hangmanExtendedGraphics extends Applet implements ActionListener{
	
	int wrong, numMatch,cgc;
	TextField [] theLetters;
	TextField aBox, wordGuess;
	Button guessButton;
	String code=generateRandomWord(), stringTwo;
	char guessChar;
	boolean[] tester;
	boolean master, guess=true, repeat=false;
	Label title, commentary, letLab, wordLab;
	TextArea toodles;
	char[] guesses;
	Canvas c1;
	Graphics myG;
	
	public void init(){
		
		guesses= new char[27];
		guessButton= new Button("Guess");
		c1= new Canvas();
		aBox= new TextField("");
		wordGuess= new TextField("");
		toodles= new TextArea("");
		theLetters=new TextField[code.length()];
		title= new Label("Tyler's Hangman");
		letLab=new Label("Letter");
		wordLab=new Label("Word");
		commentary= new Label("This is how you are doing: ");
		int x=0;
		while(x<theLetters.length){
			theLetters[x]=new TextField("");
			add(theLetters[x]);
			x++;
		}
		myG= c1.getGraphics();
		
		
		
		add(guessButton);
		add(aBox);
		add(toodles);
		add(title);
		add(commentary);
		add(letLab);
		add(wordGuess);
		add(wordLab);
		add(c1);
		
		guessButton.addActionListener(this);
		aBox.addActionListener(this);
		wordGuess.addActionListener(this);
		
		
		this.setSize(950,600);
		aBox.requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==guessButton||e.getSource()==aBox){
			repeat=false;
			if(cgc>0){
				checkAlready();
			}
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
		
	}
	
	public void paint(Graphics g) {
	
		
		int x=0;
		c1.setBackground(Color.cyan);
		c1.setLocation(50,150);
		c1.setSize(200,375);
		setBackground(Color.WHITE);
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
	guessButton.setLocation(325, 300);
	aBox.setSize(30,30);
	aBox.setLocation(420,300);
	wordGuess.setSize(100,30);
	wordGuess.setLocation(475, 300);
	toodles.setSize(400,175);
	toodles.setLocation(330, 380);
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.getAllFonts();
    Font fontA = new Font("Superclarendon-Bold", Font.BOLD, 35);
	title.setFont(fontA);
	title.setLocation(300,30);
	title.setSize(500, 50);
	Font fontB= new Font("DiwanMishafiGold", Font.BOLD, 13);
	commentary.setFont(fontB);
	commentary.setLocation(330, 340);
	commentary.setSize(200, 50);
	letLab.setFont(fontB);
	letLab.setLocation(416, 275);
	letLab.setSize(40, 30);
	wordLab.setFont(fontB);
	wordLab.setLocation(475, 280);
	wordLab.setSize(100,20);

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
		if(cgc==1){
			bucket=stringTwo;
		}
		else{
			bucket=stringTwo+toodles.getText();
		}
		x=0;
		while(x<code.length()){
			if(tester[x]){
				theLetters[x].setText(code.substring(x, (x+1)));
			}
			x++;
		}
		
		if(cgc>0){
			toodles.setText(bucket);
			
		}
		if(numMatch==code.length()){
			toodles.setText("You Win");
		
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
			toodles.setText("You Win!");
			
			while(x<code.length()){
				
				theLetters[x].setText(code.substring(x, (x+1)));
				
				x++;
			}
			
		}
		else{
			toodles.setText("Nope! Keep guessing.\n"+toodles.getText());
		}
		wordGuess.setText("");
	}
	
 	public void checkAlready(){
		guessChar = aBox.getText().charAt(0);
		if(cgc>0){
		
		int x=0;
		while(x<27){
		if(guessChar==guesses[x]){
			stringTwo=("You already guessed that! Try a new letter. \n");
			repeat=true;
			
		}
		x++;
	}
	}
	}
	
}

