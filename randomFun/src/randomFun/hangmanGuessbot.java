package randomFun;

import java.util.Scanner;

public class hangmanGuessbot {

	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
			String theCode=generateRandomWord();
			playGame(theCode);
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
			theWord="lugubrious";
		}
		
		return theWord;
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
		
		letter=(char)((int)letter-32);
		
		return letter;
	
}

	public static void playGame(String theCode){
		
		Scanner input;
		input = new Scanner(System.in);

		
		boolean go=true;
		char theGuess;
		boolean [] tester;
		tester= new boolean[theCode.length()];
		tester=setBool(tester);
		int numGuess=0;
		boolean[] alphabet;
		alphabet= new boolean[26];
		alphabet=setBool(alphabet);
		int theGuessInt;
		
		while(go){
			theGuess=' ';
			theGuessInt=((int)((Math.random()*26)));
			
			if(!alphabet[theGuessInt]){
				theGuess=(char)(theGuessInt+97);
				numGuess++;
				alphabet[theGuessInt]=true;
			}
			tester=setTester(tester, theGuess, theCode);
			go=sayProgressReport(tester, theCode);
		}
		
		print("That took "+numGuess+" guesses");
		
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
	
	
}
