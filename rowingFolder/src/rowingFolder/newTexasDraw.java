package rowingFolder;

import java.util.Scanner;

public class newTexasDraw {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
	
		long startTime = System.nanoTime();
		String[] nameList;
		nameList= new String[50];
		
		boolean[] nameBool;
		nameBool= new boolean[50];
		
		String[] reUse;
		reUse= new String [10];
		
		System.out.println("BCHIGH Texas Draw 2015");
		System.out.println("");
		
		nameBool= setBool(nameBool);
		
		nameList=getNames(nameList);
		
		int theCount=1;
		
		while(theCount<6){
			nameBool=sayABoat(nameBool, nameList, reUse, theCount);
			theCount++;
			
		}
		
		long endTime = System.nanoTime();

		long duration = ((endTime - startTime)/1000000);
		
		System.out.println("Efficiency test: "+duration+" milliseconds");
		
	}
	


	public static String[] getNames(String [] theNameList){
		int x=0;
		
		theNameList[x]="Tedeschi";
		x++;
		theNameList[x]="Defao";
		x++;
		theNameList[x]="Nagle";
		x++;
		theNameList[x]="Abraziejus";
		x++;
		theNameList[x]="J. Green";
		x++;
		theNameList[x]="Bonarrigo";
		x++;
		theNameList[x]="Tobin";
		x++;
		theNameList[x]="McGregor";
		x++;
		theNameList[x]="Forde";
		x++;
		theNameList[x]="Gonzalez";
		x++;
		theNameList[x]="Larsen";
		x++;
		theNameList[x]="Bleckley";
		x++;
		theNameList[x]="Mahoney";
		x++;
		theNameList[x]="Robinson";
		x++;
		theNameList[x]="Fee";
		x++;
		theNameList[x]="May";
		x++;
		theNameList[x]="Wilson";
		x++;
		theNameList[x]="M. Greene";
		x++;
		theNameList[x]="Hart";
		x++;
		theNameList[x]="Sheehan";
		x++;
		theNameList[x]="Walsh";
		x++;
		theNameList[x]="DeSimone";
		x++;
		theNameList[x]="McGowan";
		x++;
		theNameList[x]="Swinford";
		x++;
		theNameList[x]="Carolan";
		x++;
		theNameList[x]="Cosentino";
		x++;
		theNameList[x]="Beeler";
		x++;
		theNameList[x]="Bradley";
		x++;
		theNameList[x]="Curry";
		x++;
		theNameList[x]="Chua";
		x++;
		theNameList[x]="Cooper";
		x++;
		theNameList[x]="Dudziak";
		x++;
		theNameList[x]="Lil' Lawson";
		x++;
		theNameList[x]="Lil' Bleckley";
		x++;
		theNameList[x]="Lil' Bradley";
		x++;
		theNameList[x]="Kuranda";
		x++;
		theNameList[x]="Rothaar";
		x++;
		theNameList[x]="Lorenzo";
		x++;
		theNameList[x]="Agba";
		x++;
		theNameList[x]="Kraunellis";
		x++;
		theNameList[x]="Lawson";
		x++;
		theNameList[x]="Ames";
		x++;
		theNameList[x]="Kouroriez";
		x++;
		theNameList[x]="Sheahan";
		x++;
		theNameList[x]="Amrhein";
		x++;
		theNameList[x]="McTigue";
		x++;
		theNameList[x]="D Hull";
		x++;
		theNameList[x]="Spirit";
		x++;
		theNameList[x]="Arrupe";
		x++;
		theNameList[x]="Connors";
		
		
		
		
		return theNameList;
	}

	public static boolean[] setBool(boolean[] theNamesBool){
		int x=0;
		boolean go=true;
		
		while(go){
			theNamesBool[x]=true;
			x++;
			if(x==50){
				go=false;
			}
		}
		return theNamesBool;
	}
	
	public static boolean[] sayABoat(boolean[] theBools, String[] theNameList, String[] theBoat, int counter){
		
		int x=0;
		boolean go=true;
		int theSpot;
		
		while(go){
			theSpot=(int)(Math.random()*40);
			if(theBools[theSpot]){
				theBoat[x]=theNameList[theSpot];
				theBools[theSpot]=false;
				x++;
			}
			
			if(x==8){
				while(go){
					int theCoxswainSpot=(int)((Math.random()*5)+40);
					if(theBools[theCoxswainSpot]){	
						theBools[theCoxswainSpot]=false;
						theBoat[x]=theNameList[theCoxswainSpot];
						go=false;
						x++;
					}
				}
			}
			go=true;
			if(x==9){
				while(go){
					int theBoatSpot=(int)((Math.random()*5)+45);
					if(theBools[theBoatSpot]){	
						theBools[theBoatSpot]=false;
						theBoat[x]=theNameList[theBoatSpot];
						go=false;
					}
				}
			}
		}
		
		x=0;
		go=true;

		  
		
		while(go){
			System.out.println((x+1)+": "+theBoat[x]);
			x++;
			if(x==8){
				System.out.println("Coxswain: "+theBoat[x]);
				go=false;
				x++;
			}
			if(x==9){
				System.out.println("Boat " +counter+": "+theBoat[x]);
			}
		}
		
		
		System.out.println("");
		
		return theBools;
		
	}
	
}
