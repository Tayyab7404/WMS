import java.rmi.*;
import java.net.*;

public class RmiClient
{
	public static void main(String[] args)
	{
		String rmiurl = "rmi://localhost/RmiServer";

		try
		{
			RmiInterface ob = (RmiInterface)Naming.lookup(rmiurl);
			
			System.out.println("Circle area: " + ob.area(10));
			System.out.println("Rectangle area: " + ob.area(10, 6));
		}

		catch(Exception e)
		{
			System.out.println(e);	
		}
	}
}
