import java.util.Scanner;

public class quizTwo {
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
	/* 2 and r
	 * 2 and w
	 * 3 and r
	 * 3 and t
	*/
	
	String response;
	int num;
	
	System.out.println("Please enter a phrase");
	response=input.nextLine();
	
	System.out.println("Please enter a number");
	num=input.nextInt();
	
	system(response, num);
	
	}

	public static void system (String word, int digit){
		if((int)word.charAt(digit)==32){
			System.out.println("The letter is a space!");
			System.out.println("So here are the letters on the left and right of it:");
			System.out.println(word.charAt(digit-1));
			System.out.println(word.charAt(digit+1));
			}
		else{
			System.out.println("The letter there is not a space. Here it is:");
			System.out.println(word.charAt(digit));
		}
	}
	}

