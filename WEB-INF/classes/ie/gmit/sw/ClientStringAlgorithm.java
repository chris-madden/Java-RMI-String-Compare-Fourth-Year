package ie.gmit.sw;

/*
 * 
 *   This class gets and set the details from the client
 * 
 */

public class ClientStringAlgorithm {
	
	private String string1;
	private String stirng2;
	private String algorithmChoice;
	private String taskNumber;
	
	// =====  CONSTRUCTOR  =====
	
	public ClientStringAlgorithm(String string1, String stirng2, String algorithmChoice, String taskNumber) 
	{
		
		this.string1 = string1;
		this.stirng2 = stirng2;
		this.algorithmChoice = algorithmChoice;
		this.taskNumber = taskNumber;
		
	}

	// =====  GETTERS & SETTERS  =====
	
	public String getString1()
	{
		return string1;
	}
	
	public void setString1(String string1)
	{
		this.string1 = string1;
	}
	
	public String getStirng2() 
	{
		return stirng2;
	}
	
	public void setStirng2(String stirng2)
	{
		this.stirng2 = stirng2;
	}
	
	public String getAlgorithmChoice()
	{
		return algorithmChoice;
	}
	
	public void setAlgorithmChoice(String algorithmChoice) 
	{
		this.algorithmChoice = algorithmChoice;
	}
	
	public String getTaskNumber()
	{
		return taskNumber;
	}
	
	public void setTaskNumber(String taskNumber)
	{
		this.taskNumber = taskNumber;
	}

}// End class ClientStringAlgorithm
