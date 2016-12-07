package ie.gmit.sw;

import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;

public class CompareWorker implements Runnable
{
	
	private BlockingQueue<ClientStringAlgorithm> queue;
	private ClientStringAlgorithm csa;
	private StringService ss;
	
	public CompareWorker(BlockingQueue<ClientStringAlgorithm> queue, ClientStringAlgorithm csa, StringService ss)
	{
		
		this.queue = queue;
		this.csa = csa;
		this.ss = ss;
		
	}
	
	private ClientStringAlgorithm takeFromQueue()
	{
		
		// Take an object from the head of the queue
		
		try 
		{
			
			csa = queue.take();
			
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return csa;
	
	}
	
	public void run() 
	{
		
		// Asign the object from the head of the queue
		ClientStringAlgorithm newCsa = takeFromQueue();
		
		// ==========  Compare strings with chosen algorithm and return result ==========
		try 
		{
			
			// Get result from the compare method
			Resultator r = ss.compare(newCsa.getString1(), newCsa.getStirng2(), newCsa.getAlgorithmChoice());
			
		} catch (RemoteException e)
		{
			e.printStackTrace();
		}
		
	}// End run 

}// End CompareWorker
