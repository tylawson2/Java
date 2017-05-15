import java.util.Scanner;

public class theStuff {

	public static int [] collectGrades(int [] theGrades, int numGrades){
		Scanner input;
		input = new Scanner(System.in);
		boolean go=true;
		int x=0;
		
		while(go){
			System.out.println("Number?");
			theGrades[x]=Integer.parseInt(input.nextLine());
			x++;
			if(x==numGrades){
				go=false;
			}
		}
		return theGrades;
	}
	
}
