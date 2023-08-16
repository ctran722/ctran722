package edu.brandeis.rseg102.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegularCopy {
	
	public static void main(String[] args) throws IOException {
	   FileWriter fw = null; 
	   FileReader fr = null;
       try {
          fr = new FileReader("./fileSource/testFile.txt");
          fw = new FileWriter("./fileDest/copyResult.txt");
          int b;
          while ((b =fr.read()) != -1)
        	  {
                  fw.write(b);
        	  }
              fw.flush();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (fr != null) {
               fr.close();
               System.out.println("File has been copied");
           }
       }
   }
}

