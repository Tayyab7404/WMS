import java.rmi.*;
import java.net.*;

public class RmiServer
{
	public static void main(String[] args)
	{
		try
		{
			RmiImplementation ob = new RmiImplementation();
			Naming.rebind("RmiServer", ob);
		}

		catch(RemoteException e)
		{
			System.out.println(e);	
		}

		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}