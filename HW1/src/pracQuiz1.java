import java.util.Scanner;

public class pracQuiz1 {
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
		int magNum;
		int numTries;
		int x;
		int guess;
		int y;
		x=0;
		
		System.out.println("What is the magic number?");
		magNum = theInput.nextInt();
		System.out.println("How many tries will the user get?");
		numTries = theInput.nextInt();
		
		while(x<numTries){
			System.out.println("Try to guess the magic number");
			guess = theInput.nextInt();
			if(guess==magNum){
				System.out.println("YES!");
				y=numTries-x-1;
				System.out.println("You had "+y+" guesses remaining");
				x=numTries+1;
			}
			else{
				System.out.println("No.");
				x++;
				if(x>=numTries){
					System.out.println("You ran out of guesses. The magic number was "+magNum+".");
				}
			}
		}
	}
}