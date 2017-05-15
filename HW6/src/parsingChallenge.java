import java.util.Scanner;

public class parsingChallenge {
	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		print("Enter a phrase");
		String thePhrase=input.nextLine();
		int lengthMaster=getLength(thePhrase);
		int theNum=findNumSpaces(thePhrase, lengthMaster);
		
		
		int[] spaceList;
		spaceList= new int[theNum];
		
		spaceList=findSpaceSpots(spaceList, theNum, thePhrase);
		String[] master;
		master= new String[theNum+1];
		
		if(theNum==0){
			oneWord(thePhrase);
		}
		else{
			master=makeStringArray(spaceList, theNum, thePhrase, master);
			multiWords(master, theNum);
		}	
	
	}
	
	public static void print(String whatever){
		System.out.println(whatever);
	}
	
	public static int getLength(String theGuess){
		int theLength=theGuess.length();
		return theLength;
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
	
	public static void oneWord(String theWord){
		Scanner input;
		input = new Scanner(System.in);
		boolean go=true;
		
		while(go){
			print("Which word do you want?");
			String response=input.nextLine();
			if(response.equals("first")|| response.equals("last")||response.equals("done")){
				if(response.equals("done")){
					go=false;
					print("Goodbye");
				}
				if(response.equals("first")){
					System.out.println("That word is: "+theWord);
				}
				if(response.equals("last")){
					System.out.println("That word is: "+theWord);
				}
			}
			else{
				int numResponse=Integer.parseInt(response);
				if(numResponse==1){
					System.out.println("That word is: "+theWord);
				}
				else{
					print("There aren't that many words in the phrase you entered.");
				}
			}
		}
	}
	
	public static void multiWords(String[] master, int theNum){
		Scanner input;
		input = new Scanner(System.in);
		
		boolean go=true;
		String[] newMaster;
		newMaster= new String[master.length];
		
		while(go){
			print("Which word do you want?");
			String response=input.nextLine();
	
			if(response.equals("first")|| response.equals("last")||response.equals("done")|| response.equals("randomize")){
				if(response.equals("done")){
					go=false;
					print("Goodbye");
				}
				if(response.equals("first")){
					System.out.println("That word is: "+master[0]);
				}
				if(response.equals("last")){
					System.out.println("That word is: "+master[theNum]);
				}
				if(response.equals("randomize")){
					master=randomizer(master, newMaster);
					System.out.print("The new randomized phrase is: ");
					printArray(master);
				}
			}
			
			else{
				int numResponse=Integer.parseInt(response);
				if(numResponse<=theNum+1 && numResponse>0){
					System.out.println("That word is: "+master[numResponse-1]);
				}
				if(numResponse>theNum+1|| numResponse<=0){
					print("There aren't that many words in the phrase you entered.");
				}
			}
		}
	}

	public static String[] randomizer(String[] master, String[] newmaster){
		
		
		boolean[] bools;
		bools= new boolean[master.length];
		bools=setBool(bools);
		int x=0;
		int randomSpot;
		boolean go=true;
		
		while(go){
			randomSpot=(int)(Math.random()*master.length);
			if(bools[randomSpot]){
				newmaster[x]=master[randomSpot];
				bools[randomSpot]=false;
				x++;
			}
			if(x==master.length){
				go=false;
			}
		}
		return newmaster;
	}

	public static boolean[] setBool(boolean[] theBool){
		int x=0;
		boolean go=true;
		
		while(go){
			theBool[x]=true;
			x++;
			if(x==theBool.length){
				go=false;
			}
		}
		return theBool;
	}

	public static void printArray(String[] theArray){
		
		int x=0;
		
		while(x<theArray.length){
			System.out.print(theArray[x]+" ");
			x++;
		}
		print(" ");
	
	}


}
