import java.util.Scanner;

	public class palindromeStupidness {
		public static void main (String[] args){
			Scanner input;
			input = new Scanner(System.in);
		
			String slew;
			int num;
			char y;
			char x;
			char letterX;
			char letterY;
			char newLetterX;
			char newLetterY;
			String wordX;
			String wordY;
			wordX="";
			wordY="";
			boolean keepOn;
			keepOn=true;
			char lowCaseMin;
			char lowCaseMax;
			char upCaseMin;
			char upCaseMax;
			upCaseMin=64;
			lowCaseMin=96;
			upCaseMax=91;
			lowCaseMax=123;
			String wordZ;
			
		System.out.println("Enter an obnoxcious slew of letters that you expect me to sort and check,");
		System.out.println("you obnoxcious piece of scum.");
		
		slew=input.nextLine();
		
		num=slew.length();
		
		x=0;
		y=(char)(((int)num)-1);
		while(keepOn){
		
		if(slew.charAt(x)==slew.charAt(y)){
			letterX=slew.charAt(x);
			letterY=slew.charAt(y);
			if((int)letterX>upCaseMin && (int)letterX<upCaseMax){
				newLetterX=(char)((int)letterX+32);
				wordX=wordX+newLetterX;
				}
			if((int)letterY>upCaseMin && (int)letterY<upCaseMax){
				newLetterY=(char)((int)letterY+32);
				wordY=wordY+newLetterY;
				}
			y--;
			if(y==x){
				keepOn=false;
			}
		}
		}
		keepOn=true;
		x=1;
		while(keepOn){
			if(slew.charAt(x)==slew.charAt(y)){
				letterX=slew.charAt(x);
				letterY=slew.charAt(y);
				if((int)letterX>upCaseMin && (int)letterX<upCaseMax){
					newLetterX=(char)((int)letterX+32);
					wordX=wordX+newLetterX;
					}
				if((int)letterY>upCaseMin && (int)letterY<upCaseMax){
					newLetterY=(char)((int)letterY+32);
					wordY=wordY+newLetterY;
					}
				x++;
				if(y==x){
					keepOn=false;
				}
			}
		}
		if(wordX.equals(wordY)){
			System.out.println("HOLY COW"+wordX+" is a palindrome");
		}
		else{
			System.out.println("There is no palindrome in "+slew);
			}
	}
}
		
		