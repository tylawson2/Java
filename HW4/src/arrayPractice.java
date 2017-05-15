import java.util.Scanner;

public class arrayPractice {
	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		boolean go=true;
		int[] num;
		
		num= new int[3];
		int x=0;
		
		while(go){
			num[x]=input.nextInt();
			x++;
			if(x==3){
				go=false;
			}
		}
		go=true;
		x=0;
		while(go){
			System.out.println(num[x]);
			x++;
			if(x==2){
				go=false;
			}
		}
	}
}
	
	
	
	
	
	
	