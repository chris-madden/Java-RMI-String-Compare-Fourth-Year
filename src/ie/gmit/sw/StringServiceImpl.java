package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServiceImpl extends UnicastRemoteObject implements StringService{


	private static final long serialVersionUID = 1L;

	protected StringServiceImpl() throws RemoteException
	{
		super();
	}

	
	public Resultator compare(String s, String t, String algo) throws RemoteException 
	{
		
		// ==========  Compare the strings here ==========
		
		s = s + "TestString1";
		t = t + "TestString2";
		algo = algo + "TestString3";
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

}// End StringServiceImpl
