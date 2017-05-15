import java.util.Scanner;

public class masterMindNoRepeats {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		
		String master=randomizer();
		
		boolean go;
		int x=1;
		boolean masterBool=true;
		boolean check=true;
		String guess;
		int length;
		int numPerf;
		int numClose;
		int codeLength;
		
		print("Let's play Mastermind!");
		
		print("Enter a slew of letters from the following: abcdef");
		
		while(masterBool){
			
			guess=input.next();
			length= getLength(guess);
			codeLength=getLength(master);
			go=checkLength(length, codeLength);
			
			if(go){
				
				go=megaCheck(guess, master, x);
				
				if(go){
					checkPerfect(guess, length, master);
					checkClose(guess,length,master);
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
	char a;
	
	while(hifive){
		y=(char)((int)(Math.random()*randomNum)+97);
		int z=0;
		boolean keepOn=true;
		boolean go=false;
		if(x!=0){
			go=true;
		}
		while(go){
			a=theCode.charAt(z);
			if(y==a){
				keepOn=false;
				go=false;
			}
			z++;
			if(z==theCode.length()){
				go=false;
			}
		}
		if(keepOn){
			theCode=theCode+y;
			x++;
		}
		if(x==randomNum){
			hifive=false;
		}	
	}
	return theCode;
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

public static void checkPerfect (String word, int perfLength, String masterPerf){

	boolean go=true;
	int perfCount=0;
	int x=0;

	while(go){
		char let=word.charAt(x);
		char letCode=masterPerf.charAt(x);
	
		if(let==letCode){
			perfCount++;
		}
		
		x++;
			
		if(x==perfLength){
			go=false;
		}
	}
	print(perfCount+" letters are perfect!");
	
	}

public static void checkClose (String theGuess, int closeLength, String theCode){
	int count;
	char a;
	count=0;
	int numClose=0;
	boolean go=true;
	char b;
	char check;

	
	while(go){
		a=theGuess.charAt(count);
		b=theCode.charAt(count);
		boolean keepOn=true;
		int y=0;
		
		while(keepOn){
			check=theCode.charAt(y);
			if(a!=b && a==check){
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
	print(numClose+" letters are close!");
	
	}

}
