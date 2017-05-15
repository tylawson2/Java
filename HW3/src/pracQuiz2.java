import java.util.Scanner;

public class pracQuiz2 {
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		String word;
		int num;
		boolean keepOn;
		keepOn=true;
		int x=0;
		
		System.out.println("Enter a word.");
		word=input.next();
		System.out.println("Enter a number");
		num=input.nextInt();
		System.out.println("Ok, so here are the first "+num+" letters of that phrase:");
		while(keepOn){
			System.out.println(word.charAt(x));
			x++;
			if(x==num){
				keepOn=false;
			}
		}
		
	}
}
