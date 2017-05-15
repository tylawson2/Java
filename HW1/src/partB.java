import java.util.Scanner;

public class partB {
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
		int numNames;
		String name;
		String lastName;
		
		
		
		System.out.println("How many names will you enter?");
		numNames = theInput.nextInt();
		int x=1;
		while(x<numNames){
		System.out.println("Name " +(x)+"?");
		name = theInput.nextLine();
			System.out.println("Hello " + name);
		x++;
	}
		System.out.println("Last name?");
		lastName = theInput.nextLine();
		System.out.println("Goodbye " + lastName+"!");
		
}
}