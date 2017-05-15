import java.util.Scanner;

public class guessWho {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
	print("How many people would you like to enter for the computer to eventually guess from?");
	int num=input.nextInt();
	
	people[] theGroup;
	theGroup= new people [num];

	int x=0;
	while(x<theGroup.length){
		theGroup[x]= new people();
		x++;
	}
	x=0;
	while(x<theGroup.length){
		theGroup=constructPerson(theGroup, x);
		x++;
	}

	
	}
	public static void print(String whatever){
		System.out.println(whatever);
	}
	
	public static people[] constructPerson(people[] thePeeps, int count){
		Scanner input;
		input = new Scanner(System.in);
		count++;
		print("What is the name of person number "+count+" ?");
		thePeeps[count-1].name=input.nextLine();
		print("What is the gender of person number "+count+" ?");
		thePeeps[count-1].gender=input.nextLine();
		print("What is the age of person number "+count+" ?");
		thePeeps[count-1].age=input.nextDouble();
		print("What is the IQ of person number "+count+" ?");
		thePeeps[count-1].IQ=input.nextDouble();
		thePeeps[count-1].calculateAgeIQRatio();
		thePeeps[count-1].sayAllTraits();
		return thePeeps;
	}
	
	
}

class people{
	
	String name;
	double age;
	String gender;
	double IQ;
	double ageVSIQ;
	
	
	public void calculateAgeIQRatio(){
		ageVSIQ=IQ/age;
	}
	public people(){
		print("I just made a person!");
	}
	public void print(String whatever){
		System.out.println(whatever);
	}
	public void sayAllTraits(){
		print("Name: "+name);
		print("Gender: "+gender);
		print("Age: "+age);
		print("IQ: "+IQ);
		print("Ratio: "+ageVSIQ);
	}
}
