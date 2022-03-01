package project0;

public class Employee extends Customer{
	 public static boolean test_inputs(String user,String password,Customer c)
	    {
	    	if(user.equals(c.username)&&password.equals(c.password))
	    	{
	    		return true;
	    	}
	    	return false;
	    }
}
