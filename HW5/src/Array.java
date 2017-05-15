

import java.util.Scanner;
	
public class Array {

public static void main(String[] args) {
			
			Scanner theInput;
			
			theInput = new Scanner(System.in);
			
			int[]grades;
			
			int num;
			
			System.out.println("How many grades will you enter?");
			
			num = Integer.parseInt(theInput.nextLine());
			
			grades = new int[num];
			
			int x = 0;
			
			while(x<grades.length) {
			
				System.out.println("Grade?");
				
				int newGrade = 0;
				
				newGrade = Integer.parseInt(theInput.nextLine());
				
				grades[x] = newGrade;
				
				x=x+1;
			
			}
			
			System.out.println("Here are all of those grades again:");
			
			int y = 0;
			
			while(y<grades.length) {
		
				System.out.println(grades[y]);
			
				y=y+1;
			
			}
			
			int changer;
			
			int changer1;
			
			System.out.println("Which grade should we change?");
			
			changer = Integer.parseInt(theInput.nextLine());
			
			System.out.println("That grade is " +grades[changer-1]+ ". What should it be now?");
			
			changer1 = Integer.parseInt(theInput.nextLine());
			
			grades[changer-1] = changer1;
			
 			
			System.out.println("Here is the average of those "+grades.length+" grades:");

			int w = 0;
			
			int theSum = 0; 
			
			int theAverage = 0;
			
			while(w<grades.length) {
					
				theSum = theSum + grades[w];
				
				w = w + 1;
			
			}
			
			
			
			theAverage = theSum/grades.length;
			
			System.out.println(theAverage);
			
			
			
			System.out.println("Here is a randomly selected grade from that collection:");
			
			int rando;
			
			rando = (int)(Math.random()*grades.length)+0;
			
			System.out.println(grades[rando]);
			
		}
}

