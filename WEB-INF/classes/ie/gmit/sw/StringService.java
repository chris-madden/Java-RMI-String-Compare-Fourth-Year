package ie.gmit.sw;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringService extends Remote, Serializable
{
	
	//public Resultator compare(String s, String t, String algo) throws RemoteException;
	
	//public int getResult(String st1, String st2, String alg) throws RemoteException;
	
	public String getMessage() throws RemoteException;
	
}// End StringService
