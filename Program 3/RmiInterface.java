import java.rmi.*;

public interface RmiInterface extends Remote
{
	public double area(double r) throws RemoteException;
	public double area(double l, double b) throws RemoteException;
}