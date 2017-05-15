import java.util.Scanner;

public class randomizer {

	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		
		
		int randomNum=0;
		
		randomNum=(int)((Math.random()*2)+5);
		System.out.println(randomNum);
	}
}
