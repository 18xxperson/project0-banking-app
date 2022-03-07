package project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Employee extends Customer implements Serializable{
    static ArrayList<Request>requests=new ArrayList<Request>();
    static ArrayList<Customer>list=new ArrayList<Customer>();
    public static void functionality()
    {
    	Scanner s=new Scanner(System.in);
    	int action;
    	do
    	{
    	  System.out.println("1:Display all requests\n2:Look at specific request\n3:Display accounts");
    	  action=s.nextInt();
    	  
    	  switch(action)
    	  {
    	  case 1:
    		  Account.displayRequests();
  	    	break;
    	  case 2:
    		 String name="";
    		 String type="";
    		 System.out.println("What is the name of the person on the request?");
    		 name=s.nextLine();
    		 System.out.println("What is the type of the account?");
    		 type=s.nextLine();
    		 System.out.println("What is the id of the account?");
    		 int id=s.nextInt();
    		 approve_requests(type,id,name);
    		 break;
    	  case 3:
    		  Account.displayCustomers();
    		  break;
    	  }
    	}while(action==1||action==2||action==3);
    }
    
	  public static void add_to_accountrequests(Customer c,String t)
	  {
		    Request r=new Request();
	    	r.id=c.numaccounts;
	    	r.name=c.username;
	    	r.id=c.numaccounts;
	    	r.type=t;
	    	requests.add(r);
	    	try
			{
				FileOutputStream fileOut=new FileOutputStream("./src/project0/requests.ser");
				ObjectOutputStream out=new ObjectOutputStream(fileOut);
				out.writeObject(requests);
				out.close();
				fileOut.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
	  }
	 
	  public static void create_account()
	    {
	    	Scanner s=new Scanner(System.in);
	    	Employee c=new Employee();
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
				Employee.functionality();
				Account.add_customerto_file(itr.next());
				return;
			}
		}
			System.out.println("Either the username or password is incorrect");
			counter++;
		
		}while(counter<15);
		}
	 public static void approve_requests(String t, int id,String name)
	 {
		 FileInputStream fileInput;
	    	ArrayList<Request> c=null;
			try {
				fileInput = new FileInputStream("./src/project0/requests.ser");
				ObjectInputStream in=new ObjectInputStream(fileInput);
				c=(ArrayList<Request>)in.readObject();
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
		 Scanner s=new Scanner(System.in);
		 
		 Iterator<Request> itr=c.iterator();
	    	while(itr.hasNext())
	    	{
	    		Request request=itr.next();
	    		if(request.type.equals(t)&&request.id==id&&request.name.equals(name))
	    		{
	    		System.out.println("Would you like to approve this request?\n Type y for yes, Type n for no");
	    		String a=s.nextLine();
	    		if(a.equals("y"))
	    		   Request.add_account(request);
	    		itr.remove();
	    		}
	    	}
	 }
	
	 
}
