package ie.gmit.sw;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/*
 *   This class retrieves the client details from a queue and calls the compare method in a thread
 *   It passes over the details and will recieve the result of the comparison
 */

public class CompareWorker implements Runnable
{
	// These are the objects passed over from the client
	private BlockingQueue<ClientStringAlgorithm> queue;
	private ClientStringAlgorithm csa;
	private StringService ss;
	private Map<String, Resultator> outQueueMap;
	
	public CompareWorker(BlockingQueue<ClientStringAlgorithm> queue, ClientStringAlgorithm csa, StringService ss, Map<String, Resultator> outQueueMap)
	{
		
		this.queue = queue;
		this.csa = csa;
		this.ss = ss;
		this.outQueueMap = outQueueMap;
		
	}
	
	// This method takes the client details from the head of the queue (The next in line)
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
	
	}// End takeFromQueue
	
	public void run() 
	{
		/*
		// ==========  Get client details from queue  =========
		
		ClientStringAlgorithm newCsa = takeFromQueue();
		
		// ====================================================
		
		//  ====================  Pass details into compare method where they will be run through an algorithm  ====================
		
		try 
		{
			// Get result from the compare method
			Resultator r = ss.compare(newCsa.getString1(), newCsa.getStirng2(), newCsa.getAlgorithmChoice());
			
			// Put task number and result of string comparison into the map
			outQueueMap.put(newCsa.getTaskNumber(), r);
			
			// ====================  PUT RESULT AND TASK NUMBER INTO A MAP  ====================
			
		} catch (RemoteException e){

			e.printStackTrace();
			
		}// End try catch
		
		Thread thread = new Thread(new CompareWorker(queue, csa, ss, outQueueMap));
		thread.start();*/
		
		//  ========================================================================================================================
		
	}// End run 
	
	public Map<String, Resultator> retrieveMap()
	{
	
		return outQueueMap;
		
	}

}// End CompareWorker
