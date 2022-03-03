package project0;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Customer{
	static int numrequests=0;
    static ArrayList<Request>requests=new ArrayList<Request>();
	
	  public static void add_to_accountrequests(Customer c, int amount)
	  {
		    Request r=new Request();
	    	r.id=c.numaccounts;
	    	r.name=c.username;
	    	r.amount=amount;
	    	requests.add(r);
	  }
	  public static void functionality(Customer c) {
	  Scanner s=new Scanner(System.in);
		 System.out.println("Press 1 for New account,\nPress 2 for Deposit into existing account, Press 3 for Withdraw from existing account");
		 int action=s.nextInt(); 
		 switch(action)
		 {
		    case 1:
		    {
		    	System.out.println("Your request has been sent");
		    	Employee.add_to_accountrequests(c,0);
		    	return;
		    }
		    case 2:
		    {
			   if(c.numaccounts==0)
			   {
				   System.out.println("Cannot deposit at this time");
			   }
			   else
			   {
				 System.out.println("How much would you like to deposit?");
				 int amount=s.nextInt();
				 System.out.println("Your request has been sent");
				 Employee.add_to_accountrequests(c, amount);
			   }
			   return;
		    }
		    case 3:
		    {
		    	if(c.numaccounts==0)
		    	{
		    		System.out.println("Cannot withdraw at this time");
		    	}
		    	else
		    	{
		    		System.out.println("How much would you like to withdraw?");
					 int amount=s.nextInt();
					 System.out.println("Your request has been sent");
					 Employee.add_to_accountrequests(c, -amount);
		    	}
		    	return;
		    }
		 }
	 }
	 
	 public void approve_request()
	 {
		 
	 }
	
	 
}
