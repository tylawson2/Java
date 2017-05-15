import java.util.Scanner;

public class palindromeArray {
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
	boolean allClear;
	allClear=true;
	String word;
	int num;
	char[ ] letters;
	int x;
	x=0;
	boolean keepOn;
	boolean keepGoing;
	keepOn=true;
	keepGoing=true;
	int upCaseMin;
	int lowCaseMin;
	int upCaseMax;
	int lowCaseMax;
	upCaseMin=64;
	lowCaseMin=96;
	upCaseMax=91;
	lowCaseMax=123;
	String bazinga;
	bazinga="";
	int y;
	String buckets;
	buckets="";
	
	bazinga="";
	
	System.out.println("Enter a word");
	word=input.nextLine();
	num=word.length();
	y=num-1;
	
	letters= new char[num];

	
	
	while(keepOn){
		
		buckets=buckets+letters[x];
		x++;
		if(x==num){
			keepOn=false;
		}
	}
	
	while(keepGoing){
		bazinga=bazinga+letters[y];
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
	System.out.println("Goodbye");
	}	
}
