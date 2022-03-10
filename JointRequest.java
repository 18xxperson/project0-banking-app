package project0;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class JointRequest extends Request{
    String name2="";
    String jointtype="";
    public static void add_account(JointRequest r)
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
 			Customer c=itr.next();
 			if(c.username.equals(r.name))
 			{
 				JointAccount a=new JointAccount();
 				a.amount=0;
 				a.secondname=r.name2;
 				a.type=r.type;
 				c.accounts.put(c.numaccounts, a);
 				c.numaccounts++;
 				System.out.println("Account successfully created");
 				Account.add_customerto_file(c);
 				return;
 			}
 		}
    }
}
