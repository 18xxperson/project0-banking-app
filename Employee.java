package project0;

import java.util.Scanner;

public class Employee extends Customer{
	 
	 public static boolean test_inputs(String user,String password,Customer c)
	    {
	    	if(user.equals(c.username)&&password.equals(c.password))
	    	{
	    		return true;
	    	}
	    	return false;
	    }
	 
	 public static void functionality(Customer c)
	 {
		 Scanner s=new Scanner(System.in);
		 System.out.println("Would you like to set up a new account, deposit into existing account or withdraw from existing account?");
		 String action=s.nextLine(); 
		 switch(action)
		 {
		    case "Deposit":
		    {
			   if(c.numaccounts==0)
			   {
				   System.out.println("Cannot deposit at this time");
			   }
			   else
			   {
				  
			   }
		    }
		 }
	 }
	 
	 public void approve_request(Request r)
	 {
		 
	 }
	
	 
}
