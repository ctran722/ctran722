package edu.brandeis.MultiEchoServerClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


class Book   
{  
    // class member variable  
    private int isbn;  
    private String title;  
    private double price;  
  
    //getters and setters
    public int getIsbn()   
    {  
        return isbn;  
    }  
    public void setisbn( int Isbn)   
    {  
        this.isbn = isbn;  
    }  
    public String getTitle()   
    {  
        return title;  
    }  
    public void setTitle(final String title)   
    {  
 
        this.title = title;  
    }  
    public double getPrice()   
    {  
        return price;  
    }  
    public void setPrice(double  price)   
    {  
        this.price =  price;  
    }  

    // for printing the values  
    @Override  
    public String toString()   
    {  
        String str = "Book - ISBN: 0-321-35668-4" + ", Title = " + getTitle() + ", Price: " + getPrice() ;  
        return str;  
    }  
}  
  
public class SerialzationServer   
{  
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    // main method  
    public static void main(String args[]) throws IOException, ClassNotFoundException{
    	server = new ServerSocket(port);
        // Creating an object of the Employee class  
        Book emp = new Book();
        Book emp2 = new Book();
 
        System.out.println("Waiting for the client request");
           
        //creating socket and waiting for client connection
        Socket socket = server.accept();
        System.out.println("Accepted client"); 
        // the employee details are getting set using the setter methods.  
        emp.setisbn(0-321-35668-4);  
        emp.setTitle("Effective Java");  
        emp.setPrice(29.99);    
        //read from socket to ObjectInputStream object
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            
        //convert ObjectInputStream object to String
        String message = (String) ois.readObject();
        System.out.println("Message Received: " + message);
        emp2.setisbn(0-321-35668-4);  
        emp2.setTitle("Effective Java");  
        emp2.setPrice(29.99);
        //create ObjectOutputStream object
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
        //write object to Socket
        oos.writeObject("Server recieved book:"+ emp.toString()+" from Server");
        System.out.println("Server sending book:"  + emp2.toString()+ " to Client");

        //close resources
        ois.close();
        oos.close();
        socket.close();
 
        System.out.println("Shutting down Socket server");
        //close the ServerSocket object
        server.close();
        }  
}
