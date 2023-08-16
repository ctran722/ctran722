package edu.brandeis.rseg102.io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FastCopy {

   public static void main(String[] args) throws IOException
   {
	   BufferedWriter bw = null; 
	   BufferedReader br = null;
      try {
    	 br = new BufferedReader(new FileReader("./FileSource/testFile.txt"));
    	 bw = new BufferedWriter(new FileWriter("./FileDest/copyResult.txt"));
    	 int b;
    	 while ((b =br.read()) != -1)
    	 {
             bw.write(b);
   	  }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (bw != null) {
              bw.close();
              System.out.println("File has been copied");
          }
      
      }
   }
}

