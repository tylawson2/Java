import java.util.Scanner;

public class arrayChallenge {
	
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
		int numGrades=collectNumGrades();

		int[] num;
		num= new int[numGrades];
		
		int[] newNum;
		newNum= new int[numGrades];
		
		
		int x=0;
		int theMin;
		int theIndex;
		
		int minPossible=askForMinPossible();
		int maxPossible=askForMaxPossible();
		int range=(maxPossible-minPossible);

		num=createRandomNumberList(num, numGrades, minPossible, range);
		
		
		while(x<numGrades){
			
			theMin=minValue(num);
			theIndex=findIndex(theMin, num);
			newNum[x]=theMin;
			num[theIndex]=1000000000;
			x++;
			
		}
		
		sayGrades(newNum, numGrades);
		
		
	}
	
	public static void print(String whatever){
		System.out.println(whatever);
	}
	
	public static void sayGrades(int [] num, int numGrades){
		print("Here are all of those numbers sorted from lowest to highest:");
		boolean go=true;
		int x=0;
		
		
		while(go){
			System.out.print(num[x]+", ");
			x++;
			if(x==numGrades-1){
				go=false;
				System.out.print("and "+num[x]);
			}
		}
	}
	
	public static int collectNumGrades(){
		Scanner input;
		input = new Scanner(System.in);
		print("How many numbers would you like me to generate?");
		int numGrades=Integer.parseInt(input.nextLine());
		return numGrades;
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
	
	public static int [] createRandomNumberList(int [] theGrades, int numGrades, int theMin, int range){
		
		boolean go=true;
		int x=0;
		
		while(go){
			
			theGrades[x]=(int)(Math.random()*range)+theMin;
			x++;
			if(x==numGrades){
				go=false;
			}
		}

		return theGrades;
	}
	
	public static int askForMinPossible(){
		Scanner input;
		input = new Scanner(System.in);
		
		print("What would you like the minimum possible number to be?");
		int theMin=Integer.parseInt(input.nextLine());
		
		return theMin;
	}
	
	public static int askForMaxPossible(){
		Scanner input;
		input = new Scanner(System.in);
		
		print("What would you like the maximum possible number to be?");
		int theMax=Integer.parseInt(input.nextLine());
		
		return theMax;
	}
	
}
