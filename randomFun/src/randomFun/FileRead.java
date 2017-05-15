package randomFun;

import java.io.*;

public class FileRead{
	
    public static void main(String[] args){
        try{
            File file = new File("theTest.txt");
            System.out.println(file.getCanonicalPath());
            FileInputStream ft = new FileInputStream(file.getCanonicalPath());

           DataInputStream in = new DataInputStream(ft); 
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strline;

            while((strline = br.readLine()) != null){
                System.out.println(strline);
            }
            in.close();
            
        }
        catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
