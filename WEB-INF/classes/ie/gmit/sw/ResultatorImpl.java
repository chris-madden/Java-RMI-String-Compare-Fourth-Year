package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//Implementation of Interfaces are "Server side" (Do the real work)

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{

	// Class will return result of the string comparison
	
	private static final long serialVersionUID = 1L;
	
	private String result;
	private boolean isProcessed = false;

	public ResultatorImpl() throws RemoteException {}

	public String getResult()
	{

		return result;
	}

	public void setResult(String result)
	{
		
		this.result = result;
	}

	public boolean isProcessed()
	{
		
		return isProcessed;
	}

	public void setProcessed() 
	{
		
		this.isProcessed = true;
		
	}

}// End ResultatorImpl
