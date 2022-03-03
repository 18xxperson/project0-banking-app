package project0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable{
    ArrayList<Integer> accounts=new ArrayList<Integer>();  
    int numaccounts=0;
    String username="";
    String password="";
    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Press 1 for new person, Press 2 for current user");
		String newc=s.nextLine();
		Customer c=new Customer();
		if(newc.equals("1"))
		{
			System.out.println("Create your username");
			c.username=s.nextLine();
			System.out.println("Create a password");
			c.password=s.nextLine();
		}
		int counter=0;
		do
		{
		System.out.println("Enter username");
		String userName=s.nextLine();
		System.out.println("Enter password");
		String password=s.nextLine();
		
		if(Request.test_inputs(userName, password,c)==true)
		{
			System.out.println("Login success");
			functionality(c);
			add_to_file(c);
			return;
		}
		else
		{
			System.out.println("Either the username or password is incorrect");
			counter++;
		}
		}while(counter<15);
	}
    public static void functionality(Customer c)
	 {
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
	
	public static void add_to_file(Customer c)
	{
		try
		{
			FileOutputStream fileOut=new FileOutputStream("./src/project0/serialization.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	

}
