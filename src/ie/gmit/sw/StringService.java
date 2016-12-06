package ie.gmit.sw;

import java.rmi.RemoteException;

public interface StringService {
	
	public Resultator compare(String s, String t, String algo) throws RemoteException;

}
