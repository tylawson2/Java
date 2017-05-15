
public class tester {
	public static void main (String[] args){
	char theLetter = 'a';
	int x = 4;
	int y = 3;
	int count = 2;
	boolean rolling = true;
	String theSource = "morning night";
	
	String theEnd;
	theEnd="one two";
	
	while(rolling) {
	x = theEnd.length()-count;
	theLetter = theSource.charAt(y-1); System.out.println(count+" and "+theLetter);
	theLetter = theEnd.charAt(x); System.out.println(count+" and "+theLetter);
	count=count+1; if(count>y) {
	rolling = false; }
	}

}
}