package edu.brandeis.rseg102.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateRemoval {

	    public static void main(String[] args) {
	        System.out.println("Add a name to set, use end to terminate input:");
	        String line = "";
	        Set<String> names = new HashSet<>();
	        Scanner scan = new Scanner(System.in);
	            while (line !="end") {

	            	line=new Scanner(System.in).next();
	            	if(line.equals("end")) {
		                	System.out.println("Name addition for set has been terminated");
		                	//line=scan.next();
		                	break;
		                }
	            	else if (names.add(line)) {
	                	System.out.println(line+" is inserted to the set");
	                }
	                else if (!names.add(line)) {
	                    System.out.println(line+" exists in the set");
	                }
	            	
	            }
	            System.out.println("Seach a name, use end to terminate search:");
	            while (line !="end") {
	    	        //while (scan != "end") {    
	    	                
	    	                // Adding elements to the Set
	    	                
	    	            	// using add() method
	    	            	line=new Scanner(System.in).next();
	    	            	if(line.equals("end")) {
	    		                	System.out.println("Search has been terminated");
	    		                	//line=scan.next();
	    		                	break;
	    		                }
	    	            	else if (names.contains(line)) {
	    	                	System.out.println(line +" found in set" );
	    	                }
	    	                else if (!names.contains(line)) {
	    	                    System.out.println(line +" not found in set");
	    	                }
	        }
	       //System.out.println(names);{
	       }
	//System.out.println("Goodbye!");
	}

   