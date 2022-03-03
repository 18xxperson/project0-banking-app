package project0;

import java.util.Scanner;

public class Admin extends Employee{
	
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
    public static void implement_account_change(Customer c)
    {
    	
    }
}
