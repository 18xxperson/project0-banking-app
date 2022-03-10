package project0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;
public class Customer implements Serializable{
    Map<Integer,Account> accounts=new HashMap<Integer,Account>();  
    int numaccounts=0;
    String username="";
    String password="";
   
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
		Customer c=itr.next();
		if(Request.test_inputs(userName, password,c)==true)
		{
			System.out.println("Login success");
			c.functionality(c);
			Account.add_customerto_file(itr.next());
			return;
		}
	}
		System.out.println("Either the username or password is incorrect");
		counter++;
	
	}while(counter<15);
	}
    	
    public static void create_account()
    {
    	Scanner s=new Scanner(System.in);
    	Customer c=new Customer();
    	System.out.println("Create your username");
    	c.username=s.nextLine();
		System.out.println("Create a password");
		c.password=s.nextLine();
		c.functionality(c);
		Account.add_customerto_file(c);
		
    }
    public void functionality(Customer c)
	 {
		 Scanner s=new Scanner(System.in);
		 String action;
		 do
		 {
		 System.out.println("1: New account,\n2: Deposit into existing account,\n3: Withdraw from existing account\n4: Transfer between accounts\n5: Apply for joint account");
		 action=s.next();
		 
		   switch(action)
		   {
		    case "1":
		    	System.out.println("What type of account would you like?");
		    	String t=s.next();
		    	System.out.println("Your request has been sent");
		    	Employee.add_to_accountrequests(c,t);
		    	break;
		    
		    case "2":
		    
			   if(c.numaccounts==0)
			   {
				   System.out.println("Cannot deposit at this time");
			   }
			   else
			   {
				 
				 System.out.println("Which account are you depositing to?");
				 String ac=s.next();
				 System.out.println("How much would you like to deposit?");
				 double amount=s.nextDouble();
				 for(Map.Entry<Integer,Account> m:c.accounts.entrySet())
					{
						if(m.getValue().type.equals(ac))
						{
							m.getValue().amount+=amount;
							System.out.println(m.getValue().type+"Account now has"+m.getValue().amount);
							break;
						}
					}
				 Account.add_customerto_file(c);
			   }
			   break;
		    
		    case "3":
		    
		    	if(c.numaccounts==0)
		    	{
		    		System.out.println("Cannot withdraw at this time");
		    	}
		    	else
		    	{
		    		System.out.println("How much would you like to withdraw?");
					 double amount=s.nextDouble();
					 System.out.println("Which account are you withdrawing from?");
					 String ac=s.next();
					 for(Map.Entry<Integer,Account> m:c.accounts.entrySet())
						{
							if(m.getValue().type.equals(ac))
							{
								if(m.getValue().amount>=amount)
								{
									m.getValue().amount-=amount;
									System.out.println(m.getValue().type+"Account now has"+m.getValue().amount);
								}
								else
								{
									System.out.println("Not enough balance");
								}
								break;
							}
						}
					 Account.add_customerto_file(c);
		    	}
		    	break;
		    case "4":
		    	if(c.numaccounts<2)
		    	{
		    		System.out.println("Cannot transfer at this time");
		    	}
		    	else
		    	{
		    		System.out.println("Which account are you withdrawing from?");
					 String ac=s.nextLine();
					 System.out.println("Which account are you depositing to?");
					 String ac1=s.nextLine();
					 Account a1=null;
					 System.out.println("How much would you like to transfer?");
					 double amount=s.nextDouble();
					 for(Map.Entry<Integer,Account> m:c.accounts.entrySet())
						{
							if(m.getValue().type.equals(ac))
							{
								if(a1==null)
								{
									a1=m.getValue();
								}
								else
								{
									if(m.getValue().amount>=amount)
									{
										m.getValue().amount-=amount;
										System.out.println(m.getValue().type+"Account now has"+m.getValue().amount);
										a1.amount+=amount;
										
									}
									else
									{
										System.out.println("Not enough balance");
									}
								}
							}
							else if(m.getValue().type.equals(ac1))
							{
								if(a1==null)
								{
									a1=m.getValue();
								}
								else
								{
									if(a1.amount>=amount)
									{
										m.getValue().amount+=amount;
										System.out.println(m.getValue().type+"Account now has"+m.getValue().amount);
										a1.amount-=amount;
									}
									else
									{
										System.out.println("Not enough balance");
									}
								}
							}
						}
					 for(Map.Entry<Integer,Account> m:c.accounts.entrySet())
					 {
						 if(m.getValue().type.equals(a1.type));
						 {
							 m.getValue().amount=a1.amount;
							 System.out.println(m.getValue().type+"Account now has"+m.getValue().amount);
						 }
					 }
					 Account.add_customerto_file(c);
					 
		    	}
		    case "5":
		    	System.out.println("Who is the person joining with?");
		    	String name=s.next();
		    	System.out.println("What type is in the joint account");
		    	String type=s.next();
		    	Employee.add_joint_accountrequests(c, type, name);
		    	break;
		    
		    }
		 }while(action.equals("1")||action.equals("2")||action.equals("3")||action.equals("4")||action.equals("5"));
	 }
}
