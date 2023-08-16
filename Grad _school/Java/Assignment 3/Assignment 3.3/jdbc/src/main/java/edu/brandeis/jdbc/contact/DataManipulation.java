
package edu.brandeis.jdbc.contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DataManipulation {
	   private static final String URL = "jdbc:mysql://localhost:3306/books_db";
	   private static final String USERNAME = "ctran";
	   private static final String PASSWORD = "canonsd750";
   
   private static Connection connection; 
   private static Statement statement; 
   private static Scanner scanner; 

   public static void main(String args[]) {
      try {
         // connection to database
         connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         // create statement for querying database
         statement = connection.createStatement();
      }
      catch (SQLException sqlex) {
         System.err.println("Unable to connect");
         sqlex.printStackTrace();
         System.exit(1);  
      }

      // create scanner for user input
      scanner = new Scanner(System.in);
      int choice = getChoice();
      // process user request
      while (choice != 5) {
         switch(choice) {
            case 1: 
               addAuthor();
               break;
            case 2: 
               editAuthor();
               break;
            case 3: 
               addTitle();
               break;
            case 4: 
               addTitleAuthor();
               break;
            default:
               System.out.println("invalid input");
         }
         choice = getChoice();
      }
   }

   // get user choice
   private static int getChoice() {        
      System.out.println("Please choose one action:");
      System.out.println("1 -- Add a new author");
      System.out.println(
         "2 -- Edit the existing information for an author");
      System.out.println("3 -- Add a new title for an author");
      System.out.println("4 -- Associate new title with an author");
      System.out.println("5 -- Exit");
      return scanner.nextInt(); // get user choice
   }
   // add new author to database
   private static void addAuthor() {
      // get first name and last name of the author
      System.out.println("Please enter author's first name");
      String firstName = scanner.next();
      System.out.println("Please enter author's last name");
      String lastName = scanner.next();

      // insert author into SQL author table
      String insertSQL = "INSERT INTO authors (firstName, lastName) " +
         "VALUES ('" + firstName + "', '" + lastName + "')";
      executeSQL(insertSQL);
   }

   // edit existing author
   private static void editAuthor() {
      // get author id, first name and last name
      System.out.println("Please enter author id");
      int id = scanner.nextInt();
      System.out.println("Please enter new first name");
      String firstName = scanner.next();
      System.out.println("Please enter new last name");
      String lastName = scanner.next();

      // update author
      String updateSQL = "UPDATE authors SET firstName = '" + firstName +
         "', lastName = '" + lastName + "' WHERE authorID = " + id;
      executeSQL(updateSQL); // execute SQL
   }

   // add new title to database
   private static void addTitle() {
      // get ISBN, title, editionNumber, copyright, publisherID, 
      System.out.println("Please enter ISBN");
      String isbn = scanner.next();
      System.out.println("Please enter title");
      scanner.nextLine(); // read remaining characters from last input
      String title = scanner.nextLine();
      System.out.println("Please enter edition number");
      int editionNumber = scanner.nextInt();
      System.out.println("Please enter copyright year");
      String copyright = scanner.next();

      // insert title into titles table
      String insertSQL = "INSERT INTO titles (isbn, title, " + 
         "editionNumber, copyright) " +  "VALUES ('" + isbn +
         "', '" + title + "', '" + editionNumber +
         "', " + copyright + ")";
      executeSQL(insertSQL); 
   }

   // associate title with author
   private static void addTitleAuthor() {
      // get author ID
      System.out.println(
         "Please choose an author ID from the list below:");
      displayAuthors();
      int authorID = scanner.nextInt();

      // get title isbn
      System.out.println(
         "Please choose a book isbn from the list below:");
      displayISBNs();
      String isbn = scanner.next();

      // update authorISBN table
      String insertSQL = "INSERT INTO authorISBN VALUES (" +
         authorID + ", '" + isbn + "')";
      executeSQL(insertSQL); 
   }

   // execute SQL
   private static void executeSQL(String sqlStatement) {
      try {
         System.out.printf("Sending SQL: %s\n", sqlStatement);
         int result = statement.executeUpdate(sqlStatement); 
         if (result == 1) {
            System.out.println("Update successful\n");
         }
         else {
            System.out.println("Update failed\n");
         }
      }
      catch (SQLException exception) {
         exception.printStackTrace();
      }
   }

   // display authors table
   private static void displayAuthors() {
      String query = "SELECT authorID, firstName, lastName FROM authors";
      executeQuery(query);
   }

   // display book title and isbn
   private static void displayISBNs() {
      String query = "SELECT isbn, editionNumber, title FROM titles";
      executeQuery(query);
   }

//execute query
   private static void executeQuery(String query) {
      try {

         ResultSet resultSet = statement.executeQuery(query);
       
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();

         for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-8s\t", metaData.getColumnName(i));
         }
         System.out.println();
         
         while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
               System.out.printf("%-8s\t", resultSet.getObject(i));
            }
            System.out.println();
         }
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      }
   }
}



 