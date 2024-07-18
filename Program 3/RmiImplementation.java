import java.rmi.*;
import java.rmi.server.*;

public class RmiImplementation extends UnicastRemoteObject implements RmiInterface
{
	public RmiImplementation() throws RemoteException{}
	
	public double area(double r) throws RemoteException
	{
		double pi = 3.141592;
		return pi * r * r;
	}
	
	public double area(double l, double b) throws RemoteException
	{
    		return l * b;
	}
}
