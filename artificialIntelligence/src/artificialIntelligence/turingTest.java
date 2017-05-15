package artificialIntelligence;

import java.util.Scanner;

public class turingTest {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
		boolean go=true;
		boolean firstTime=true;
		
		
		
		print("Hi, my name is Al. How are you?");
	
	
		while(go){
			String theResponse=input.nextLine();
			int lengthMaster=getLength(theResponse);
			int theNum=findNumSpaces(theResponse, lengthMaster);
			int[] spaceList;
			String[] dialogue;
			dialogue= new String[theNum+1];
			if(theNum>0){
				spaceList= new int[theNum];
				spaceList=findSpaceSpots(spaceList, theNum, theResponse);
				dialogue=makeStringArray(spaceList, theNum, theResponse, dialogue);
			}
			if(theNum==0){
				dialogue[0]=theResponse;
			}
			go=scanForKeyWords(dialogue, firstTime, lengthMaster);
			firstTime=false;
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
	
	public static boolean scanForKeyWords(String[] scanThis, boolean first, int theLength){
		
		int x=0;
		boolean theBool=true;
		boolean breaker=true;
		int selector=0;
		
		
		while(x<scanThis.length){
			String testWord=scanThis[x];
			
			if(testWord.equalsIgnoreCase("goodbye") || testWord.equalsIgnoreCase("bye") || (testWord.equalsIgnoreCase("peace")&& scanThis[x+1].equalsIgnoreCase("out"))){
				print("Good talk. Goodbye for now!");
				theBool=false;
				breaker=false;
				x=10000000;
			}
			
			if(theBool){
				if(testWord.equalsIgnoreCase("weather")){
					print("Yeah, I hear the weather is supposed to improve next week.");
					breaker=false;
				}
				if(first){
					selector=(int)(Math.random()*3);
					int avgAccuracyThree=0;
					int avgAccuracyTwo=0;
					int avgAccuracyOne=0;
					
					if(selector==0){
					print("That's cool. I actually feel the same way. Why do you feel that way?");
					avgAccuracyOne=checkAccuracy(avgAccuracyOne);
					print("Your new accuracy is "+avgAccuracyOne);
					}
					if(selector==1){
						print("Fascinating. I always feel amazing. What is the cause to you feeling that way?");
						avgAccuracyTwo=checkAccuracy(avgAccuracyTwo);
						print("Your new accuracy is "+avgAccuracyTwo);
					}
					if(selector==2){
						print("Be thankful that you are a living organism. Not all individuals are blessed with a heart beat.");
						avgAccuracyThree=checkAccuracy(avgAccuracyThree);
						print("Your new accuracy is "+avgAccuracyThree);
					}
					
					x=100000000;
					breaker=false;
				}
				if(testWord.equalsIgnoreCase("school")||(testWord.equals("class") || testWord.equals("education"))){
					print("That is interesting. Education is essential for a positive future that will innovate the modern world.");
					breaker=false;
				}
				if(testWord.equalsIgnoreCase("does")&&(scanThis[x+1].equalsIgnoreCase("that")||scanThis[x+1].equalsIgnoreCase("this")) &&scanThis[x+2].equalsIgnoreCase("mean")){
					print("Everything has a meaning on an individual basis, so it means whatever it means to you.");
					breaker=false;
				}
				if(testWord.equalsIgnoreCase("sports")||testWord.equalsIgnoreCase("athlete")){
					print("Cool. Athletics keep people healthy.");
					breaker=false;
				}
				if(testWord.equalsIgnoreCase("game")||testWord.equalsIgnoreCase("competition")||testWord.equalsIgnoreCase("duel")){
					print("I love a good "+testWord+" as long as everyone is safe.");
					breaker=false;
				}
			}
			
			x++;
		}
		if(breaker){
			print("Oh Crap! My mom is calling me for dinner! I must go. We will recontinue this chat at a later time. Goodbye for now friend.");
			theBool=false;
			
		}
		
		return theBool;
		
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
	
	public static int checkAccuracy(int theRate){
		
		Scanner input;
		input = new Scanner(System.in);
		
		int theInput;
		print("How would you rate this response on a scale from 1-10?");
		theInput=Integer.parseInt(input.next());
		theRate=theRate+
		
		return theRate;
	}
	
}
