import java.util.Scanner;

public class partB {
	public static void main (String[] args) {
		Scanner theInput;
		theInput = new Scanner(System.in);
		int numClass;
		int timHw;
		int numDays;
		String response;
		int week;
		int total;
		int free;
		int numClassb;
		int timHwb;
		int numDaysb;
		String responseb;
		int weekb;
		int totalB;
		int freeb;
		
		System.out.println("How many classes are you taking?");
		numClass = theInput.nextInt();
		
		if(numClass>10){
			System.out.println("That can't be right. How many classes are you taking?");
			numClass = theInput.nextInt();
		}
		if(numClass<4){
			System.out.println("That can't be right. How many classes are you taking?");
			numClass = theInput.nextInt();
		}
		System.out.println("How much HW per class, on average?(in minutes)");
		timHw = theInput.nextInt();
		
		if(timHw>300){
			System.out.println("Liar! How much homework do you actually have per class?");
			timHw = theInput.nextInt();
		}
		if(timHw<5){
			System.out.println("Liar! How much homework do you actually have per class?");
			timHw = theInput.nextInt();
		}
		
		System.out.println("How many days in your school year?");
		numDays = theInput.nextInt();
		if(numDays>200){
			System.out.println("That's Absurd! How many school days do you actually have?");
			numDays = theInput.nextInt();
		}
		if(numDays<100){
			System.out.println("That's Absurd! How many school days do you actually have?");
			numDays = theInput.nextInt();
		}
		System.out.println("Week, Total, or Free?");
		response = theInput.next();
		week = numClass*timHw*5;
		if(response.equals("Week")){
		
			System.out.println("You have " +week+ " minutes of homework in a week");		
		}
		total = numClass*numDays*timHw/60;
		if(response.equals("Total")){
			System.out.println("You have " +total+ " hours of homework in a given school year.");	
		
		}
		free = 480-(numClass*timHw);
		if(response.equals("Free")){
			System.out.println("You have " +free+ " minutes of free time on a school night.");
		}
		if(response.equals("Reset")){
			System.out.println("How many classes are you taking?");
			numClassb = theInput.nextInt();
			if(numClassb>10){
				System.out.println("That can't be right. How many classes are you taking?");
			numClassb = theInput.nextInt();
			}
			if(numClassb<4){
				System.out.println("That can't be right. How many classes are you taking?");
			numClassb = theInput.nextInt();
		
			System.out.println("How much HW per class, on average?(in minutes)");
			timHwb = theInput.nextInt();
			
			if(timHwb>300){
				System.out.println("Liar! How much homework do you actually have per class?");
				timHwb = theInput.nextInt();
			}
			if(timHwb<5){
				System.out.println("Liar! How much homework do you actually have per class?");
				timHwb = theInput.nextInt();
			}
			
			
			System.out.println("How many days in your school year?");
			numDaysb = theInput.nextInt();
			if(numDaysb>200){
				System.out.println("That's Absurd! How many school days do you actually have?");
				numDaysb = theInput.nextInt();
			}
			if(numDaysb<100){
				System.out.println("That's Absurd! How many school days do you actually have?");
				numDaysb = theInput.nextInt();
			}
			
			System.out.println("Week, Total, or Free?");
			responseb = theInput.next();
			weekb = numClassb*timHwb*5;
			if(responseb.equals("Week")){
			
				System.out.println("You have " +weekb+ " minutes of homework in a week");		
			}
			totalB = numClassb*numDaysb*timHwb/60;
			if(responseb.equals("Total")){
				System.out.println("You have " +totalB+ " hours of homework in a given school year.");	
			
			}
			freeb = 480-(numClassb*timHwb);
			if(responseb.equals("Free")){
				System.out.println("You have " +freeb+ " minutes of free time on a school night.");
			}
			else{
				System.out.println("Week, Total, or Free?");
				responseb = theInput.next();
				weekb = numClassb*timHwb*5;
				if(responseb.equals("Week")){
				
					System.out.println("You have " +weekb+ " minutes of homework in a week");		
				}
				totalB = numClassb*numDaysb*timHwb/60;
				if(responseb.equals("Total")){
					System.out.println("You have " +totalB+ " hours of homework in a given school year.");	
				
				}
				freeb = 480-(numClassb*timHwb);
				if(responseb.equals("Free")){
					System.out.println("You have " +freeb+ " minutes of free time on a school night.");
				}
				
			}
		}
	
	}
}
}	