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
import java.util.Map;

public class Account implements Serializable{
   double amount=0;
   String type="";
   
   public static void add_customerto_file(Customer c)
	{
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
	   if(list==null)
	   {
		   list=new ArrayList<Customer>();
	   }
    	list.add(c);
		try
		{
			FileOutputStream fileOut=new FileOutputStream("./src/project0/serialization.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			out.writeObject(list);
			out.close();
			fileOut.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
   public static void displayRequests()
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
		 
		 Iterator<Request> itr=c.iterator();
	    	while(itr.hasNext())
	    	{
	    		Request a1=itr.next();
	    		System.out.println(a1.id);
	    		System.out.println(a1.name);
	    		System.out.println(a1.type);
	    		
	    	}
   }
   public static void displayCustomers()
   {
	   FileInputStream fileInput;
   	ArrayList<Customer> c=null;
		try {
			fileInput = new FileInputStream("./src/project0/serialization.ser");
			ObjectInputStream in=new ObjectInputStream(fileInput);
			c=(ArrayList<Customer>)in.readObject();
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
	 
	 Iterator<Customer> itr=c.iterator();
   	while(itr.hasNext())
   	{
   		Customer c1=itr.next();
   		System.out.println(c1.username);
   		System.out.println(c1.numaccounts);
   		for(Map.Entry<Integer,Account> m:c1.accounts.entrySet())
		{
			System.out.println(m.getValue().amount);
			System.out.println(m.getValue().type);
		}
   	}
   }
   
}
