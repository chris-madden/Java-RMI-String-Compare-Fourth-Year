package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation of Interfaces are "Server side" (Do the real work)

public class StringServiceImpl extends UnicastRemoteObject implements StringService{

	private static final long serialVersionUID = 1L;

	public StringServiceImpl() throws RemoteException{}

	public String getMessage()
	{
		
		return "RMI is working here";
	}
	
	//  =====================  HERE THE STRINGS ARE COMPARED AGAINST THE CORRECT ALGORITHM  ===================== 
	
	/*public Resultator compare(String s, String t, String algo) throws RemoteException 
	{
		
		// Need to return a type of Resultator
		Resultator result;
		int distance = 0;
		
		// ====================  COMPARE STRINGS HERE  ====================
		
		result = new ResultatorImpl();
		
		if(algo.equals("Damerau-Levenshtein Distance"))
		{
			DamerauLevenshtein d = new DamerauLevenshtein();
			
			distance = d.distance(s, t);
			
		}
		else if(algo.equals("Hamming Distance"))
		{
			HammingDistance h = new HammingDistance();
			
			distance = h.distance(s, t);
			
		}
		else if(algo.equals("Levenshtein Distance"))
		{
			Levenshtein l = new Levenshtein();
			
			distance = l.distance(s, t);
			
		}
		
		// ==================================================================
		
		// Convert dsitance to a string 
		String stringDistance = Integer.toString(distance);
		
		// Set the result of the compared strings here
		result.setResult(stringDistance);
		
		return result;
	}*/
	
	//  ========================================================================================================== 

}// End StringServiceImpl
