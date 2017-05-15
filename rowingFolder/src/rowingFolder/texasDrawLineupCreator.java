package rowingFolder;

import java.util.Scanner;

public class texasDrawLineupCreator {

	public static void main (String[] args){
		Scanner input;
		input = new Scanner(System.in);
		
		
		String[] firstBoat;
		firstBoat= new String [10];
		
		String[] secondBoat;
		secondBoat= new String [10];
		
		String[] thirdBoat;
		thirdBoat= new String [10];
		
		String[] fourthBoat;
		fourthBoat= new String [10];
		
		String[] fifthBoat;
		fifthBoat= new String [10];
		
		String[] nameList;
		nameList= new String[50];
		
		boolean[] nameBool;
		nameBool= new boolean[50];
		
		nameBool= setBool(nameBool);
		
		nameList=getNames(nameList);
		
		nameBool=sayFirstBoat(firstBoat, nameList, nameBool);
		nameBool=saySecondBoat(secondBoat, nameList, nameBool);
		nameBool=sayThirdBoat(thirdBoat, nameList, nameBool);
		nameBool=sayFourthBoat(fourthBoat, nameList, nameBool);
		sayFifthBoat(fifthBoat, nameList, nameBool);
	
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
		theNameList[x]="McGee";
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
	
	public static boolean[] sayFirstBoat(String[] theFirstBoat, String[] theNameList,  boolean[] theBools){
		
		int x=0;
		boolean go=true;
		int theSpot;
		
		while(go){
			theSpot=(int)(Math.random()*40);
			if(theBools[theSpot]){
				theFirstBoat[x]=theNameList[theSpot];
				theBools[theSpot]=false;
				x++;
			}
			
			if(x==8){
				while(go){
					int theCoxswainSpot=(int)((Math.random()*5)+40);
					if(theBools[theCoxswainSpot]){	
						theBools[theCoxswainSpot]=false;
						theFirstBoat[x]=theNameList[theCoxswainSpot];
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
						theFirstBoat[x]=theNameList[theBoatSpot];
						go=false;
					}
				}
			}
		}
		
		x=0;
		go=true;
		
		while(go){
			System.out.println((x+1)+": "+theFirstBoat[x]);
			x++;
			if(x==8){
				System.out.println("Coxswain: "+theFirstBoat[x]);
				go=false;
				x++;
			}
			if(x==9){
				System.out.println("First Boat: "+theFirstBoat[x]);
			}
		}
		
		
		System.out.println("");
		
		return theBools;
		
	}

	public static boolean[] saySecondBoat(String[] theSecondBoat, String[] theNameList,  boolean[] theBools){
		
		int x=0;
		boolean go=true;
		int theSpot;
		
		while(go){
			theSpot=(int)(Math.random()*40);
			if(theBools[theSpot]){
				theSecondBoat[x]=theNameList[theSpot];
				theBools[theSpot]=false;
				x++;
			}
			
			if(x==8){
				while(go){
					int theCoxswainSpot=(int)((Math.random()*5)+40);
					if(theBools[theCoxswainSpot]){	
						theBools[theCoxswainSpot]=false;
						theSecondBoat[x]=theNameList[theCoxswainSpot];
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
						theSecondBoat[x]=theNameList[theBoatSpot];
						go=false;
					}
				}
			}
		}
		
		x=0;
		go=true;
		
		while(go){
			System.out.println((x+1)+": "+theSecondBoat[x]);
			x++;
			if(x==8){
				System.out.println("Coxswain: "+theSecondBoat[x]);
				go=false;
				x++;
			}
			if(x==9){
				System.out.println("Second Boat: "+theSecondBoat[x]);
			}
		}
		System.out.println("");
		return theBools;
		
	}

	public static boolean[] sayThirdBoat(String[] theThirdBoat, String[] theNameList,  boolean[] theBools){
	
	int x=0;
	boolean go=true;
	int theSpot;
	
	while(go){
		theSpot=(int)(Math.random()*40);
		if(theBools[theSpot]){
			theThirdBoat[x]=theNameList[theSpot];
			theBools[theSpot]=false;
			x++;
		}
		
		if(x==8){
			while(go){
				int theCoxswainSpot=(int)((Math.random()*5)+40);
				if(theBools[theCoxswainSpot]){	
					theBools[theCoxswainSpot]=false;
					theThirdBoat[x]=theNameList[theCoxswainSpot];
					x++;
					go=false;
				}
			}
		}
		go=true;
		if(x==9){
			while(go){
				int theBoatSpot=(int)((Math.random()*5)+45);
				if(theBools[theBoatSpot]){	
					theBools[theBoatSpot]=false;
					theThirdBoat[x]=theNameList[theBoatSpot];
					go=false;
				}
			}
		}
	}
	
	x=0;
	go=true;
	
	while(go){
		System.out.println((x+1)+": "+theThirdBoat[x]);
		x++;
		if(x==8){
			System.out.println("Coxswain: "+theThirdBoat[x]);
			go=false;
			x++;
		}
		if(x==9){
			System.out.println("Third Boat: "+theThirdBoat[x]);
		}
	}
	
	
	System.out.println("");
	
	return theBools;
	
}
	
	public static boolean[] sayFourthBoat(String[] theFourthBoat, String[] theNameList,  boolean[] theBools){
	
	int x=0;
	boolean go=true;
	int theSpot;
	
	while(go){
		theSpot=(int)(Math.random()*40);
		if(theBools[theSpot]){
			theFourthBoat[x]=theNameList[theSpot];
			theBools[theSpot]=false;
			x++;
		}
		
		if(x==8){
			while(go){
				int theCoxswainSpot=(int)((Math.random()*5)+40);
				if(theBools[theCoxswainSpot]){	
					theBools[theCoxswainSpot]=false;
					theFourthBoat[x]=theNameList[theCoxswainSpot];
					x++;
					go=false;
				}
			}
		}
		go=true;
		if(x==9){
			while(go){
				int theBoatSpot=(int)((Math.random()*5)+45);
				if(theBools[theBoatSpot]){	
					theBools[theBoatSpot]=false;
					theFourthBoat[x]=theNameList[theBoatSpot];
					go=false;
				}
			}
		}
	}
	
	x=0;
	go=true;
	
	while(go){
		System.out.println((x+1)+": "+theFourthBoat[x]);
		x++;
		if(x==8){
			System.out.println("Coxswain: "+theFourthBoat[x]);
			go=false;
			x++;
		}
		if(x==9){
			System.out.println("Fourth Boat: "+theFourthBoat[x]);
		}
	}
	
	
	
	System.out.println("");
	return theBools;
	
}

	public static void sayFifthBoat(String[] theFifthBoat, String[] theNameList,  boolean[] theBools){
	
	int x=0;
	boolean go=true;
	int theSpot;
	
	while(go){
		theSpot=(int)(Math.random()*40);
		if(theBools[theSpot]){
			theFifthBoat[x]=theNameList[theSpot];
			theBools[theSpot]=false;
			x++;
		}
		
		if(x==8){
			while(go){
				int theCoxswainSpot=(int)((Math.random()*5)+40);
				if(theBools[theCoxswainSpot]){	
					theBools[theCoxswainSpot]=false;
					theFifthBoat[x]=theNameList[theCoxswainSpot];
					x++;
					go=false;
				}
			}
		}
		go=true;
		if(x==9){
			while(go){
				int theBoatSpot=(int)((Math.random()*5)+45);
				if(theBools[theBoatSpot]){	
					theBools[theBoatSpot]=false;
					theFifthBoat[x]=theNameList[theBoatSpot];
					go=false;
				}
			}
		}
	}
	
	x=0;
	go=true;
	
	while(go){
		System.out.println((x+1)+": "+theFifthBoat[x]);
		x++;
		if(x==8){
			System.out.println("Coxswain: "+theFifthBoat[x]);
			go=false;
			x++;
		}
		if(x==9){
			System.out.println("Fifth Boat: "+theFifthBoat[x]);
		}
	}
	
	
	
	
}
	
}
