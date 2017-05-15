import java.util.Scanner;

public class char1 {
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
		
		char someLetter;
		String word;
		int num;
		boolean keepOn;
		keepOn=true;
		int x;
		boolean keepGoing;
		keepGoing=true;
		int y;
		y=0;
		
		System.out.println("Please enter a word");
		word= theInput.next();
		
		num= word.length();
		x=num-1;
		
		System.out.println("That word is "+num+" letters long.");
		
		someLetter=word.charAt(0);
		System.out.println("The first letter is "+someLetter);
		
		someLetter=word.charAt(num-1);
		System.out.println("The last letter is "+someLetter);
		
		System.out.println("Here are those letters backward:");
		while(keepOn){
			someLetter=word.charAt(x);
			System.out.println(someLetter);
			if(x==0){
				keepOn=false;
			}
			x--;
		}
		while(keepGoing){
			someLetter=word.charAt(y);
			System.out.println(someLetter);
			if(y==(num-1)){
				keepGoing=false;
			}
			y++;
		}
	}
}	
