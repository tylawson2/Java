import java.util.Scanner;

public class whileChallenge {
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
	
		int x;
		x=0;
		boolean keepOn;
		keepOn=true;
		int num;
		int num1;
		int num2;
		int num3;
		num=0;
		num1=0;
		num2=0;
		num3=0;
		int y;
		y=0;
		int z;
		z=0;
		
		System.out.println("Enter a number");
		x=theInput.nextInt();
		System.out.println("Enter a number");
		y=theInput.nextInt();
		if(x<=y){
			num1=x;
			num2=y;
		}
		else{
			num1=y;
			num2=x;	
		}
		System.out.println("Enter a number");
		z= theInput.nextInt();
		if(z<=num1){
			num3=num2;
			num2=num1;
			num1=z;	
		}
		else{
			if(z<=num2){
				num3=num2;
				num2=z;
			}
			if(z>num2){
				num3=z;
			}
		}
		System.out.println("Those numbers, sorted from least to greatest, are:");
		System.out.println("");
		System.out.println(num1+", "+num2+", "+num3);
		System.out.println("Goodbye");
		
	}
	
}
