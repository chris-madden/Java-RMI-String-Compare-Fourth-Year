package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{

	// Class will return result of the string comparison
	
	private static final long serialVersionUID = 1L;
	
	private String result;

	protected ResultatorImpl() throws RemoteException 
	{
		super();
		
	}

	public String getResult() throws RemoteException
	{

		return result;
	}

	public void setResult(String result) throws RemoteException
	{
		
		this.result = result;
	}

	public boolean isProcessed() throws RemoteException 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void setProcessed() throws RemoteException 
	{
		// TODO Auto-generated method stub
		
	}

}// End ResultatorImpl
