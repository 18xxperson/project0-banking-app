package project0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Admin extends Employee{
	
    public static void implement_account_change(Customer c,Request r)
    {
    	if(r.amount==0)
    	{
    		c.numaccounts++;
    	    c.accounts.put(c.numaccounts, 0);
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
