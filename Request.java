package project0;

import java.io.Serializable;

public class Request implements Serializable{
   int id=0;
   String name="";
   int amount=0;
   boolean approved=false;
   boolean lookedat=false;
   public static boolean test_inputs(String user,String password,Customer c)
   {
   	if(user.equals(c.username)&&password.equals(c.password))
   	{
   		return true;
   	}
   	return false;
   }
}
