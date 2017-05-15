import java.util.Scanner;
public class whileChallenge {
	
	public static void main (String[] args) {
			Scanner theInput;
			theInput = new Scanner(System.in);
		
		String response;
		int answer;
		int x;
		int perfSq;
		int y;
		int num1;
		int num2;
	
		
		System.out.println("Sum, Product, Root, or Power?");
		response = theInput.next();

		
		{
			int total;
			
		if(response.equals("Sum")){
			total=0;
			answer=21;
		while(answer!=0){	
			
			System.out.println("Enter a number");
			answer = theInput.nextInt();
			total= total +answer;
			
		
		}
		System.out.println("The final "+response+" is "+ total);
	}
		{
	
			if(response.equals("Product")){
				total=1;
				answer=1;
			while(answer!=0){
				
				System.out.println("Enter a number");
				answer = theInput.nextInt();
					if(answer!=0){
						total= total*answer;
					}
				
			}
			System.out.println("The final "+response+" is "+ total);
		
		}
		
		}
		
		
		
		int base;
		int expnt;
		
		
		if(response.equals("Power")){
	
			x=0;
			base=1;
			total=1;
			System.out.println("Enter a base number");
			base = theInput.nextInt();
			System.out.println("Enter an exponent");
			expnt = theInput.nextInt();
			while(x<expnt){
				total=base*total;
			
				x++;
			}
			
			System.out.println("The final "+response+" is "+ total);
			
		}
		if(response.equals("Root")){
			
			y=0;
			System.out.println("What is your perfect square number?");
			perfSq= theInput.nextInt();
			
		
			num1=0;
			while(perfSq!=num1){
				
				num1= (y*y);
				
				if(perfSq!=num1){
					y++;
				}
			}
			System.out.println("The square root of " +perfSq+ " is "+ y);
		}
		
		if(response.equals("Prime")){
			
			System.out.println("Enter a number");
			num1= theInput.nextInt();
		
				
					
				
					
				}
		}
		
		}
		}
	
		
