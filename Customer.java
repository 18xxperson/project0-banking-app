package project0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable{
    Map<Integer,Integer> accounts=new HashMap<Integer,Integer>();  
    int numaccounts=0;
    String username="";
    String password="";
    ArrayList<Request> transactions=new ArrayList<Request>();
    public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Press 1 for new person, Press 2 for current user");
		String newc=s.nextLine();
		//System.out.println("Press 1 for Customer, press 2 for employee, press 3 for admin");
		//String access=s.nextLine();
		Customer c=null;
		if(newc.equals("1"))
		{
			c=new Customer();
			System.out.println("Create your username");
			c.username=s.nextLine();
			System.out.println("Create a password");
			c.password=s.nextLine();
			functionality(c);
			Admin.add_to_file(c);
		}
		else
		{
			FileInputStream fileInput;
			try {
				fileInput = new FileInputStream("./src/project0/serialization.ser");
				ObjectInputStream in=new ObjectInputStream(fileInput);
				c=(Customer)in.readObject();
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
		
		if(Request.test_inputs(userName, password,c)==true)
		{
			System.out.println("Login success");
			functionality(c);
			Admin.add_to_file(c);
			return;
		}
		else
		{
			System.out.println("Either the username or password is incorrect");
			counter++;
		}
		}while(counter<15);
		}
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
	
	
	

}
