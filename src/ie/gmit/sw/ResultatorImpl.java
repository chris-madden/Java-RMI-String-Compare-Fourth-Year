package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 *   This class implements Resultator interface.
 *   It gets and sets the result of string commparison and whether the process has been finished yet
 */

public class ResultatorImpl extends UnicastRemoteObject implements Resultator
{
	
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
