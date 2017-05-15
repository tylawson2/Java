import java.util.Scanner;

public class primeNum {
	
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
	
		boolean keepOn;
		keepOn=true;
		int num1;
		int dividend;
		int x;
		x=2;
		
		while(keepOn){
			System.out.println("Enter a number");
			dividend= theInput.nextInt();
			dividend=dividend/x;
			x++;
			
		}
	}
}
