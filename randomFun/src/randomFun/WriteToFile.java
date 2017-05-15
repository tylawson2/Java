package randomFun;

import java.io.*;
import java.util.*;

public class WriteToFile {
	
	public static void main(String[] args) throws IOException {
		Scanner in;
		in = new Scanner(System.in);
		
		FileWriter fw= new FileWriter("/Users/tylerlawson/Documents/Java/randomFun/theTest.txt");
		PrintWriter pw = new PrintWriter("/Users/tylerlawson/Documents/Java/randomFun/theTest.txt");
		
		System.out.println("enter new stuff");
		String theStuff=in.nextLine();
		
		pw.println(theStuff);
		pw.flush();
		pw.close();
		fw.close(); 
		
	}
}

