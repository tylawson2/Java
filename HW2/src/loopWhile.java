import java.util.Scanner;

public class loopWhile {

	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
		
		boolean keepOn;
		keepOn= true;
		int x;
		String response;
		int sum;
		sum=0;
		int max;
		int min;
		int range;
		range=0;
		int total;
		total=0;
		max=0;
		min=0;
		
		while(keepOn){
		
			System.out.println("Enter a number");
			x= theInput.nextInt();
			if(total==0){
				max=x;
				min=x;
			}
			else{
				if(x>max){
					max=x;
				}
				if(x<min){
					min=x;	
			}
			}	
			sum=sum+x;
			range=max-min;
			total++;
			System.out.println("Continue?");
			response= theInput.next();
			if(response.equals("no")||response.equals("No")||response.equals("NO")||response.equals("Nope")||response.equals("nope")||response.equals("Nah")||response.equals("nah")||response.equals("Na")||response.equals("na")){
				keepOn=false;
			}
		}
		System.out.println("The sum of all of those numbers was "+sum);
		System.out.println("The biggest number was "+max);
		System.out.println("The smallest number was "+min);
		System.out.println("The range from smallest to largest was "+range);
		System.out.println("You entered a total of "+total+" numbers");
		System.out.println("Goodbye");
	}
}
