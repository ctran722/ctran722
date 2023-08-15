package edu.brandeis.rseg102.collection;

import java.util.ArrayList; // program uses class Scanner
import java.util.List; // program uses class Scanner
import java.util.Scanner; // program uses class Scanner
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class GradeMapping
{
   public static void main(String[] args) {
	  //system input 
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> grades = new ArrayList<>();
      //output directions
      System.out.print("Enter grade or -1 to quit: "); 
      int grade = input.nextInt(); 
      //while loop to print grades
      while (grade != -1) {
         grades.add(grade);
         System.out.print("Enter grade or -1 to quit: "); 
         grade = input.nextInt(); 
      }
      //letter grade list of list
      List<String> lettergrades = grades.stream()
         .map(x -> {
                if (x >= 90) {return "A";}
                else if (x >= 80) {return "B";}
                else if (x >= 70) {return "C";}
                else if (x >= 60) {return "D";}
                else {return "F";}
             })
         .collect(Collectors.toList());
      //print out grades
      System.out.printf("Letter grades are: %s%n", lettergrades);
   }
} 

