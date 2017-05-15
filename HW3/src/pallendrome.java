import java.util.Scanner;

public class pallendrome {
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		boolean allClear;
		allClear=true;
		
		while(allClear){

			String word;
			boolean keepOn;
			
			int num;
			String buckets;
			buckets="";
			int x;
			x=0;
			char letter;
			boolean keepGoing;
			
			String bazinga;
			bazinga="";
			int y;
			char newletter;
			char shift;
			shift=' ' ;
			char lowCaseMin;
			char lowCaseMax;
			char upCaseMin;
			char upCaseMax;
			upCaseMin=64;
			lowCaseMin=96;
			upCaseMax=91;
			lowCaseMax=123;
			keepOn=true;
			keepGoing=true;
			
		System.out.println("Please enter a word");
		word=input.nextLine();
		
		num=word.length();
		y=num-1;
		
		if(word.equals("stop")){
			keepOn=false;
			keepGoing=false;
			allClear=false;
		}
		
		while(keepOn){
			
			if(word.charAt(x)>upCaseMin && word.charAt(x)<upCaseMax){
				letter=word.charAt(x);
				newletter= (char)((int)letter+32);
				buckets=buckets+newletter;
			}
			if(word.charAt(x)>lowCaseMin && word.charAt(x)<lowCaseMax){
				letter=word.charAt(x);
				buckets=buckets+letter;
			}
			x++;
			if(x==num){
				keepOn=false;
			}
		}
		
		while(keepGoing){
			if(word.charAt(y)>lowCaseMin && word.charAt(y)<lowCaseMax){
				letter=word.charAt(y);
				bazinga=bazinga+letter;
			}
			if(word.charAt(y)>upCaseMin && word.charAt(y)<upCaseMax){
				letter=word.charAt(y);
				newletter=(char)((int)letter+32);
				bazinga=bazinga+newletter;
					}
			if(y==0){
				keepGoing=false;
			}
			y--;
		}
	
		if(!(bazinga.equals(""))){
			if(bazinga.equals(buckets)){
				System.out.println(word+" is a palindrome");
			}
			else{
				System.out.println(word+" is not a palindrome");
			}
		}
	}
	
	System.out.println("Goodbye");
		
	}
	
}
