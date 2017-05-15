package randomFun;

import java.util.Scanner;

public class hangman {
	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		boolean go=true;
		int x=0;
		print("Shall we play hangman?");
		String startResponse=input.nextLine();
		
		int lengthMaster=getLength(startResponse);
		int theNum=findNumSpaces(startResponse, lengthMaster);
		int[] spaceList;
		String[] dialogue;
		dialogue= new String[theNum+1];
		if(theNum>0){
			spaceList= new int[theNum];
			spaceList=findSpaceSpots(spaceList, theNum, startResponse);
			dialogue=makeStringArray(spaceList, theNum, startResponse, dialogue);
			go=scanForKeyWords(dialogue, lengthMaster);
		}
		else{
			go=true;
			if(startResponse.equalsIgnoreCase("No")){
				go=false;
			}
		}
		
		if(go){
			print("Will there be one or two players?");
			String numPlayers=input.next();
			if(numPlayers.equalsIgnoreCase("one")||numPlayers.equalsIgnoreCase("1")){
				String theCode=generateRandomWord();
				playGame(theCode);
			}
			if(numPlayers.equalsIgnoreCase("two")||numPlayers.equalsIgnoreCase("2")){
				print("Okay, what will the code be?");
				String theCode=input.next();
				while(x<100){
					print("");
					x++;
				}
				playGame(theCode);
			}
		}
		
		else{
			print("Okay, Goodbye!");
		}
	
	}
	
	public static void print(String whatever){
		System.out.println(whatever);
	}
	
	public static int findNumSpaces(String theLongString, int theLength){
		
		boolean go =true;
		int spaceNum=0;
		int startSearch=0;
	
		
		while (go){
			
			String theChunk=theLongString.substring(startSearch);
			int spot=theChunk.indexOf(' ');
			if(spot>=0 && spot<theLength){
				spaceNum++;
				startSearch=startSearch+spot+1;
			}
			else{
				go=false;
			}
		}
		return spaceNum;
	}
	
	public static int[] findSpaceSpots(int[]theSpaces, int spaces, String thePhrase){
		int count=0;
		int startSearch=0;
		while(count<spaces){
			String theChunk=thePhrase.substring(startSearch);
			theSpaces[count]=theChunk.indexOf(' ')+startSearch;
			startSearch=theSpaces[count]+1;
			
			count++;
		}		
		
		return theSpaces;		
	}
	
	public static int getLength(String theGuess){
		int theLength=theGuess.length();
		return theLength;
	}
	
	public static String[] makeStringArray(int[] theSpaceSpots, int numOfSpaces, String fullPhrase, String[] masterArray){
		
		
		int x=0;
		int startSpot=0;
		
		while(x<numOfSpaces){
			masterArray[x]=fullPhrase.substring(startSpot,theSpaceSpots[x]);
			startSpot=theSpaceSpots[x]+1;
			x++;
			if(x==numOfSpaces){
				masterArray[x]=fullPhrase.substring(startSpot);
			}
		}
		
		return masterArray;
		
	}
	
	public static boolean scanForKeyWords(String[] scanThis, int theLength){
		
		int x=0;
		boolean theBool=true;
	
		while(x<scanThis.length){
			String testWord=scanThis[x];
			
			if(testWord.equalsIgnoreCase("no")||(testWord.equals("nope") || testWord.equals("nah"))){
				
				theBool=false;
			}
			
			
		x++;
		}

		
		return theBool;
		
	}
	
	public static String generateRandomWord(){
		
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
			theWord="bachan";
		}
		
		return theWord;
	}
	
	public static void playGame(String theCode){
	
		Scanner input;
		input = new Scanner(System.in);
		
		int numWrong=0;
		char theGuess;
		String theGuessWord;
		int tip;
		boolean [] tester;
		tester= new boolean[theCode.length()];
		tester=setBool(tester);
		boolean master=true;
		String guessBucket="";
		int numGuess=0;
		int x=0;
		
		while(x<=theCode.length()){
			if(x==0){
				System.out.print("The word is: ");
			}
			System.out.print("_");
			x++;
		}
		print("");
		while(numWrong<6 && master){
			if(numGuess>0){
				print("Your guess bucket is: "+guessBucket);
			}
			print("Guess a letter or the full word.");
			
			theGuessWord=input.next();
			boolean backup=true;
			tip=0;
			theGuess=' ';
			if(theGuessWord.equals(theCode)){
				master=false;
				backup=false;
				tip=-1;
			}
			if(theGuessWord.length()==1){
				theGuess=theGuessWord.charAt(0);
				tip=checkTheGuess(theGuess, theCode);
			}		
	
			if(tip>0){
				tester=setTester(tester, theGuess, theCode);
				if(tip>1){
					System.out.println("There were "+tip+" matches for that letter");
				}
				
				if(tip==1){
					System.out.println("There was "+tip+" match for that letter");
				}
				
				master=sayProgressReport(tester, theCode);
				backup=false;
			}
			if(backup){
				numWrong++;
				System.out.println("That was wrong. Number of wrong (6) is "+numWrong);
				master=sayProgressReport(tester, theCode);
			}
			guessBucket=guessBucket+theGuess;
			numGuess++;
		}
		
		theCode=capFirstLetter(theCode);
		
		if(numWrong==6){
			print("You lose. Better luck next time. The word was: "+theCode);
		}
		else{
			print("You won! "+theCode+" was the word.");
		}
		
		
	}
	
	public static int checkTheGuess(char theLetter, String theWord){
		int x=0;
		int theResult=0;
		while(x<theWord.length()){
			if(theLetter==theWord.charAt(x)){
				theResult++;
			}
			x++;
		}
		return theResult;
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
	
	public static boolean [] setTester(boolean [] tester, char theLetter, String theWord){
		int count=0;
		while(count<theWord.length()){
			if(theLetter==theWord.charAt(count)){
				tester[count]=true;
			}
			count++;
		}
		return tester;
	}
	
	public static boolean sayProgressReport(boolean [] tester, String theWord){
		int x=0;
		boolean master=true;
		int numMatch=0;
		
		while(x<theWord.length()){
			if(x==0){
				System.out.print("The word is: ");
			}
			if(tester[x]){
				System.out.print(theWord.charAt(x));
				numMatch++;
			}
			else{
				System.out.print("_");
			}
			x++;
		}
		if(numMatch==theWord.length()){
			master=false;
		}
		print("");
		return master;
	}
	
	public static String capFirstLetter(String theWord){
		
		int x=0;
		char firstLet;
		String newWord="";
		while(x<theWord.length()){
			
			if(x==0){
				firstLet= shift(theWord.charAt(x));
				newWord=newWord+firstLet;
			}
			else{
				newWord=newWord+theWord.charAt(x);
			}
			x++;
		}
		
		return newWord;
	}
	
	public static char shift(char letter){
		
		int capOfLetter=(int)letter;
		
		if(capOfLetter>96 && capOfLetter<123){
			letter=(char)((int)letter-32);
		}
		if(capOfLetter>64&&capOfLetter<91){
			letter=(char)((int)letter+32);
		}
		return letter;
	}
	
}
