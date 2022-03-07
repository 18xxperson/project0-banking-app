package project0;

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
}
