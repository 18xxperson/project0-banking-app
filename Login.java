package project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	 public static void main(String[] args) {
	    	Scanner s=new Scanner(System.in);
			System.out.println("Press 1 for new person");
		    String access;
			String newc=s.nextLine();
			do
			{
				System.out.println("Press 1 for Customer, press 2 for employee, press 3 for admin");
				access=s.nextLine();
			}while(!(access.equals("1"))&&!(access.equals("2"))&&!(access.equals("3")));
			switch(access)
			{
			case "1":
				if(newc.equals("1"))
				{
					Customer.create_account();	
					
				}
				else
				{
					Customer.login();
			     }
				break;
			case "2":
				if(newc.equals("1"))
				{
					Employee.create_account();	
				}
				else
				{
					Employee.login();
			     }
				break;
			case "3":
				if(newc.equals("1"))
				{
					Admin.create_account();	
				}
				else
				{
					Admin.login();
			     }
				break;
			}
			
	    }
	 public static void removeAccount(Customer c, String t)
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
		   for(int i=0;i<list.size();i++)
		    {
		    	if(c.username.equals(list.get(i).username))
		    	{
		    		
		    		for(int j=0;j<list.get(i).accounts.size();j++)
		    		{
		    			if(t.equals(list.get(i).accounts.get(j).type))
		    					{
		    				list.get(i).accounts.remove(j, list.get(i).accounts.get(j));
		    				Account.add_customerto_file(list.get(i));
		    					}
		    		}
		    	}
		    }
	 }
}
