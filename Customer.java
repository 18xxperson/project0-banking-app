package project0.project0git;
import java.util.Scanner;
public class Customer {
    int[] accounts=new int[50];
    int numaccounts=0;
    String username="";
    String password="";
    String name="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Is this a new person or current?");
		String newc=s.nextLine();
		Customer c=new Customer();
		if(newc.equals("new")||newc.equals("New"))
		{
			System.out.println("Create your username");
			c.username=s.nextLine();
			System.out.println("Create a password");
			c.password=s.nextLine();
		}
		System.out.println("Enter username");
		String userName=s.nextLine();
		System.out.println("Enter password");
		String password=s.nextLine();
		if(Employee.test_inputs(userName, password,c)==true)
		{
			System.out.println("Login success");
		}
		else
		{
			System.out.println("Either the username or password is incorrect");
		}
	}

}
