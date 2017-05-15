import java.util.Scanner;

public class mastermindHW4 {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		boolean go;
		int x=1;
		boolean masterBool=true;
		String guess;
		int length;
		int codeLength;
		boolean [] booleanArray;
		int theClose=0;

		String master=randomizer();
		codeLength=getLength(master);
		char [] theArray=new char[codeLength];
		theArray=arrayCreator(master);
		
		print("Let's play Mastermind!");
		
		print("Enter a slew of letters from the following: abcdef");
		
		while(masterBool){
			
			guess=input.next();
			length= getLength(guess);
			go=checkLength(length, codeLength);
			char [] guessArray=new char[length];
			guessArray =arrayCreator(guess);
			
			if(go){
				
				go=megaCheck(guess, master, x);
				
				if(go){
					booleanArray=checkPerfect(guessArray, length, theArray);
					checkClose(guessArray,length, theArray, booleanArray);
					
				}
				
				if(x==10){
					go=false;
					masterBool=false;
					print("That was "+x+" tries. GAME OVER.");
					print(master+" was the code.");
				}
				x++;
				masterBool=go;
			}
			
		}
	}

public static String randomizer(){
	String theCode="";
	boolean hifive=true;
	
	int randomNum;
	randomNum=(int)(Math.random()*2)+3;
	int x=0;
	char y=' ';

	
	while(hifive){
		y=(char)((int)(Math.random()*randomNum)+97);
		theCode=theCode+y;
		x++;
		
		if(x==randomNum){
			hifive=false;
		}	
	}
	print(theCode);
	return theCode;
}


public static char[] arrayCreator(String master){
	
	char anArray[];
	boolean start=true;
	int z=0;
	int num=master.length();
	anArray=new char[num];
	while(start){
		anArray[z]=master.charAt(z);
		z++;
		if(z==num){
			start=false;
		}
	}
	return anArray;
}

public static int getLength(String theGuess){
		int theLength=theGuess.length();
		return theLength;
	}

public static boolean checkLength (int meLength, int theCodeLength){
	if(meLength==theCodeLength){
		print("This is the length.");
		return true;
	}
	else{
		print("Wrong length. Try again.");
		return false;
	}
}

public static void print(String whatever){
	System.out.println(whatever);
}

public static boolean megaCheck(String guessWord, String masterCode, int tries){
	if(guessWord.equals(masterCode)){
		print("This is perfect! You won the game!");
		if(tries==1){
			print("It took you "+tries+" guess to get the right answer");
			print("It was indeed "+masterCode);
		}
		else{
			print("It took you "+tries+" guesses to get the right answer");
			print("It was indeed "+masterCode);
		}
		return false;
	}
	else{
		print("This is not completely correct. Keep trying");
		return true;
	}
	
}

public static boolean [] checkPerfect (char guess[], int perfLength, char perfmaster[]){

	boolean go=true;
	int perfCount=0;
	int x=0;
	boolean [] theArrayBoolean;
	theArrayBoolean= new boolean[perfLength];
	
	
	while(go){
		char let=guess[x];
		char letCode=perfmaster[x];
	
		if(let==letCode){
			perfCount++;
			theArrayBoolean[x]=false;
			System.out.println(theArrayBoolean[x]);
		}
		else{
			theArrayBoolean[x]=true;
			System.out.println(theArrayBoolean[x]);
		}
		x++;	
		if(x==perfLength){
			go=false;
		}
	}
	print(perfCount+" letters are perfect!");
	return theArrayBoolean;
	}

public static void checkClose (char[] theGuess, int closeLength, char[] theCode, boolean[] mahBoolean){
	int count;
	char a;
	count=0;
	int numClose=0;
	boolean go=true;
	char b;
	char check;
	boolean keepOn=true;
	
	while(go){
		a=theGuess[count];
		b=theCode[count];
		keepOn=mahBoolean[count];
		int y=0;
		
		while(keepOn){
			check=theCode[y];
			if(a==check && mahBoolean[y]==true){
				numClose++;
			}
			y++;
			if(y==closeLength){
				keepOn=false;
			}
			
		}
		
		count++;
		if(count==closeLength){
			go=false;
		}
	}

	print(numClose+" letters are close");;
	
	}

}