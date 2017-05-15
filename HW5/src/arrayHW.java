import java.util.Scanner;

public class arrayHW {
	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
	int numGrades=collectNumGrades();

	int[] num;
	num= new int[numGrades];
	int[] newNum;
	newNum= new int[numGrades];
	int theMin;
	int x=0;
	int theIndex;
	
	num=collectGrades(num, numGrades);

	while(x<numGrades){
		
		theMin=minValue(num);
		theIndex=findIndex(theMin, num);
		newNum[x]=theMin;
		num[theIndex]=1000000000;
		x++;
		
	}
	
	sayGrades(newNum, numGrades);
	
	num=changeGrade(newNum);
	
	averageGrades(newNum, numGrades);	
	
	getRandomGrade(newNum, numGrades);
		
	}
	
	public static void averageGrades(int [] num, int numGrades){
		
		int theAvg=0;
		boolean go=true;
		int x=0;
		int bucket=0;
		
		while(go){
			bucket=num[x]+bucket;
			x++;
			if(x==numGrades){
				theAvg=bucket/numGrades;
				go=false;
			}
		}
		print("Here is the average of those "+numGrades+" grades:");
		System.out.println(theAvg);
	}
	
 	public static int [] changeGrade(int[] num){
		Scanner input;
		input = new Scanner(System.in);
 		
		print("Which grade should we change?");
		int whichGrade=Integer.parseInt(input.nextLine());
		int theGrade=num[whichGrade-1];
		System.out.println("That grade is "+theGrade+". What should it be now?");
		int newGrade=Integer.parseInt(input.nextLine());
		num[whichGrade-1]=newGrade;
		return num;
	}
	
	public static int collectNumGrades(){
		Scanner input;
		input = new Scanner(System.in);
		print("How many grades will be entered?");
		int numGrades=Integer.parseInt(input.nextLine());
		return numGrades;
	}
	
	public static void sayGrades(int [] num, int numGrades){
		print("Here are all of those grades sorted from least to greatest:");
		boolean go=true;
		int x=0;
		
		while(go){
			System.out.print(num[x]+", ");
			x++;
			if(x==numGrades-1){
				go=false;
				System.out.println("and "+num[x]);
			}
		}
	}
	
	public static int [] collectGrades(int [] theGrades, int numGrades){
		Scanner input;
		input = new Scanner(System.in);
		boolean go=true;
		int x=0;
		while(go){
			print("Grade?");
			theGrades[x]=Integer.parseInt(input.nextLine());
			x++;
			if(x==numGrades){
				go=false;
			}
		}
		return theGrades;
	}
	
	public static void print(String whatever){
		System.out.println(whatever);
	}

	public static void getRandomGrade(int [] num, int numGrades){
		int randomGradeSpot=(int)(Math.random()*numGrades);
		int theRandomGrade=num[randomGradeSpot];
		print("Here is a randomly selected grade from that collection:");
		System.out.println(theRandomGrade);
	}

	private static int minValue(int[] nums) {
		int min;
		min=nums[0];
		int x=0;
		while(x<nums.length){
			if (nums[x] <= min ) {
				min = nums[x];
			}
			x++;
		}
		
		return min;
	}
	
	public static int findIndex(int theNum, int[] searchArray){
		int theSpot=0;
		int x=0;
		
		while(x<searchArray.length){
			if(theNum==searchArray[x]){
				theSpot=x;
				x=100000000;
			}
			x++;
		}
		
		return theSpot;
	}
	
}
