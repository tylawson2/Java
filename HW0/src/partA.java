/*qwertyuiop
asdfghjkl;
zxcvbnm,.
The quick fox jumped over the lazy dogs.

public class partA {
	
	public static void main (String[] args) {
			String aWord = "hello world!";
			String wThree;
			String wordTwo;
			
			aWord = "something totally different";
			wordTwo = aWord;
			wThree = "some message";
			
			System.out.println(aWord);
			System.out.println("some stuff");
			System.out.println(wThree);
	}
}
*/
import java.util.Scanner;

public class partA {
	
	public static void main (String[] args) {
		Scanner theInput;
		theInput = new Scanner(System.in);
		int theAge;
		String theName;
		String response;
		String isis;
		
		System.out.println("What is your name?");
		theName = theInput.next();
		System.out.println("hello " +theName);
		System.out.println("How old are you?");
		theAge = theInput.nextInt();
		if(theAge>=21){
			
			System.out.println("You can go to a bar");
			if(theAge<42){
				System.out.println("and drink responsibly");
			}
		}
		else{
			System.out.println("dont drink kid");
		}
		System.out.println("do you like to drink?");
		response = theInput.next();
		if(response.equals("yes")){
			System.out.println("same");
		}
		else{
			System.out.println("I'll buy you a beer");
		}
	System.out.println("have you heard of any progress with the isis boat yet?");	
	isis = theInput.next();
	if(isis.equals("yes i have")){	
		System.out.println("please tell me more");
	}
	else{
		System.out.println("well it actually is quite good despite its origins in the barren middle east");
	}

	}}
	
	
	
	
	
	
	
	
	



