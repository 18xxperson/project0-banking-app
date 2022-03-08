package project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends Employee{
	
    
    public static void functionality()
    {
    	Scanner s=new Scanner(System.in);
    	int action=0;
    	do
    	{
    	  System.out.println("1:Display all requests\n2:Look at specific request\n3:Display all customers\n4:Modify a customer's accounts");
    	  action=s.nextInt();
    	  switch(action)
    	  {
    	  case 1:
    		  Account.displayRequests();
  	    	  break;
    	  case 2:
    		 System.out.println("What is the name of the person on the request?");
      		 String name=s.next();
     		 System.out.println("What is the type of the account?");
     		 String type=s.next();
     		 approve_requests(type,name);
     		 break;
     	  case 3:
     		  Account.displayCustomers();
     		  break;
     	  case 4:
     		 System.out.println("What is the name of the person you are accessing?");
     		 name=s.next();
     		FileInputStream fileInput;
        	ArrayList<Customer>list=null;
    		try {
    			fileInput = new FileInputStream("./src/project0/serialization.ser");
    			ObjectInputStream in=new ObjectInputStream(fileInput);
    			list=(ArrayList<Customer>)in.readObject();
    			in.close();
    			fileInput.close();
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	Iterator<Customer> itr=list.iterator();
    	while(itr.hasNext())
    	  {
    		  Customer c=itr.next();
    		  if(c.username.equals(name))
    		  {
    			  c.functionality(c);
    			  break;
    		  }
    	  }
    	break;
    	}
    	}while(action==1||action==2||action==3||action==4);
    }
    
    public static void create_account()
    {
    	Scanner s=new Scanner(System.in);
    	Admin c=new Admin();
    	System.out.println("Create your username");
    	c.username=s.nextLine();
		System.out.println("Create a password");
		c.password=s.nextLine();
		functionality();
		Account.add_customerto_file(c);
    }
    
    public static void login()
    {
    	Scanner s=new Scanner(System.in);
    	FileInputStream fileInput;
    	ArrayList<Customer>list=null;
		try {
			fileInput = new FileInputStream("./src/project0/serialization.ser");
			ObjectInputStream in=new ObjectInputStream(fileInput);
			list=(ArrayList<Customer>)in.readObject();
			in.close();
			fileInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	int counter=0;
	do
	{
	System.out.println("Enter username");
	String userName=s.nextLine();
	System.out.println("Enter password");
	String password=s.nextLine();
	Iterator<Customer> itr=list.iterator();
	while(itr.hasNext())
	{
		if(Request.test_inputs(userName, password,itr.next())==true)
		{
			System.out.println("Login success");
			functionality();
			return;
		}
	}
		System.out.println("Either the username or password is incorrect");
		counter++;
	
	}while(counter<15);
	}
 
}
