import java.util.Scanner;

public class secondParsingChallenge {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
	boolean go=true;
	
	String theResponse;
	int theAmountSigns;
	int longness;
	
	
	
	
	print("Please enter an expression:");
	theResponse=input.nextLine();
	
	while(!(theResponse.equals("done"))){
		longness=getLength(theResponse);
		theAmountSigns=numSigns(theResponse, longness);
		doMath(theResponse, longness, theAmountSigns);
		
		
		print("Please enter an expression:");
		theResponse=input.nextLine();
	}
	
	print("Goodbye");
	
	
	
	}
	
	public static void print(String whatever){
		System.out.println(whatever);
	}
	
	public static int getLength(String theGuess){
		int theLength=theGuess.length();
		return theLength;
	}
	
	public static int numSigns(String theResponse, int theLength){
		
		int howMany=0;
		int x=0;
		
		while(x<theLength){
			if(theResponse.charAt(x)=='/'||theResponse.charAt(x)=='+'||theResponse.charAt(x)=='*'||theResponse.charAt(x)=='-'){
				howMany++;
				
			}
			x++;
		}
		return howMany;
	}
	
	public static void doMath(String response, int length, int numSigns){	
		
		int x=0;
		
		int numOne;
		int numTwo;
		int result=0;
		int multCount=1;
		
		
		while(x<length){
			if(response.charAt(x)=='*'){
				numOne=Character.getNumericValue(response.charAt(x-1));
				numTwo=Character.getNumericValue(response.charAt(x+1));
				
				if(multCount==1){
					result=result+(numOne*numTwo);
				}
				else{
					result=result*numTwo;
				}
				multCount++;
			}
			
			if(response.charAt(x)=='/'){
				numOne=Character.getNumericValue(response.charAt(x-1));
				numTwo=Character.getNumericValue(response.charAt(x+1));
				
				if(multCount==1){
					result=result+(numOne/numTwo);
				}
				else{
					result=result/numTwo;
				}
				multCount++;
			}
			x++;
		}
		
		
		
		
		
		
		x=0;
		while(x<length){
			
			if(response.charAt(x)=='+'){
				
				numOne=Character.getNumericValue(response.charAt(x-1));
				numTwo=Character.getNumericValue(response.charAt(x+1));
				
				if(x==1){
					result=numOne+numTwo;
				}
				//if(x==1 && multCount>1){
					//result=result+
				//}
				else{
					result=result+numTwo;
				}
			}
			
			if(response.charAt(x)=='-'){
				numOne=Character.getNumericValue(response.charAt(x-1));
				numTwo=Character.getNumericValue(response.charAt(x+1));
				if(x==1){
					result=numOne-numTwo;
				}
				else{
					result=result-numTwo;
				}
				
			}
			x++;
		}
		
		
		System.out.println("The result is " +result);
		
		
	}
	
	
}
