package project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Request implements Serializable{
   int id=0;
   String name="";
   String type="";
   public static boolean test_inputs(String user,String password,Customer c)
   {
   	if(user.equals(c.username)&&password.equals(c.password))
   	{
   		return true;
   	}
   	return false;
   }
   public static void add_to_file(Request r)
	{
		try
		{
			FileOutputStream fileOut=new FileOutputStream("./src/project0/requests.ser");
			ObjectOutputStream out=new ObjectOutputStream(fileOut);
			out.writeObject(r);
			out.close();
			fileOut.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
   public static void add_account(Request r)
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
		Iterator<Customer> itr=list.iterator();
		while(itr.hasNext())
		{
			if(itr.next().username.equals(r.name))
			{
				Account a=new Account();
				a.amount=0;
				a.type=r.type;
				itr.next().accounts.put(itr.next().numaccounts, a);
				itr.next().numaccounts++;
				Account.add_customerto_file(itr.next());
				return;
			}
		}
   }
}
