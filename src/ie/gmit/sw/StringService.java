package ie.gmit.sw;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringService extends Remote, Serializable
{
	
	//  ==========  The compare method is here  ==========
	
	//public Resultator compare(String s, String t, String algo) throws RemoteException;
	
	//  ==========  getMessage is here to show that RMI does work  ==========
	
	public String getMessage() throws RemoteException;
	
}// End StringService
