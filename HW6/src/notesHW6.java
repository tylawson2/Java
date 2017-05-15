import java.util.Scanner;

public class notesHW6 {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
	
	String word= "morning";
	
	int num=word.length();
	char let= word.charAt(4);
	int spotfound= word.indexOf(let);
	
	if(word.equals("hello")){
		System.out.println("Yes, it IS hello!");
	}
	
	String theChunk =word.substring(4); // the chunk now has "ing" in it
	
	
	String smallerChunk=word.substring(3,5);//"ni"
	
	
	
	
	
	
	}
}
