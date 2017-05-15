import java.util.Scanner;

public class quiz1 {
	public static void main (String[] args){
		Scanner theInput;
		theInput = new Scanner(System.in);
		
		String theName;
		int numPlay;
		int x;
		x=1;
		String response;
		int y;
		int z;
		z=0;
		boolean keepGoing;
		keepGoing=true;
		
		System.out.println("What's the name of the player we are looking for?");
		theName = theInput.next();
		System.out.println("And how many players are there?");
		numPlay = theInput.nextInt();
		
		while(keepGoing){
			System.out.println("Player " +x+", what's you name?");
			response = theInput.next();
			y=numPlay-x;
			if(response.equals(theName)){
				z++;
			}
			x++;
			if(x>numPlay){
				keepGoing=false;
			}
		}
		if(z==1){
			System.out.println(theName+" was the name. There was "+z+" player with the name "+theName+".");
		}
		else{
			System.out.println(theName+" was the name. There were "+z+" players with the name "+theName+".");
		}
	}	
}
