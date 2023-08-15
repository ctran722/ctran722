package edu.brandeis.MultiEchoServerClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
class Novel{  
    // class member variable  
    private int isbn;  
    private String title;  
    private double price;  
  
    //getter and setter
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

public class SerializationClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Novel emp = new Novel();
        socket = new Socket(host.getHostName(), 9876);
        //setting values
        emp.setisbn(0-321-35668-4);  
        emp.setTitle("Effective Java");  
        emp.setPrice(38.99);
        //recieve 
        System.out.println("Sending Book"+emp.toString()+" to Server");
        oos = new ObjectOutputStream(socket.getOutputStream());
        
        oos.writeObject("Server recieved book:"+ emp.toString()+" from client");
        System.out.println("Sending the book,  waiting for return value");

        //read the server response message
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Message: " + message);

        //close resources
        ois.close();
        oos.close();

    }
}
