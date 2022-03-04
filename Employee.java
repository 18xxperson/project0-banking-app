package project0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Employee extends Customer implements Serializable{
    static ArrayList<Request>requests=new ArrayList<Request>();
	
	  public static void add_to_accountrequests(Customer c, int amount)
	  {
		    Request r=new Request();
	    	r.id=c.numaccounts;
	    	r.name=c.username;
	    	r.amount=amount;
	    	requests.add(r);
	    	try
			{
				FileOutputStream fileOut=new FileOutputStream("./src/project0/serialization.ser");
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
	 
	 
	 public void approve_requests()
	 {
		 Scanner s=new Scanner(System.in);
		 Iterator<Request> itr=requests.iterator();
	    	while(itr.hasNext())
	    	{
	    		System.out.println("Would you like to approve this request?\n Type y for yes, Type n for no");
	    		String a=s.nextLine();
	    		if(a.equals("y"))
	    		   itr.next().approved=true;
	    		itr.next().lookedat=true;
	    	}
	 }
	
	 
}
