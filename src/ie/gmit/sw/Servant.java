package ie.gmit.sw;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servant {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		//Create an instance of a MessageService. As MessageServiceImpl implements the MessageService
		//interface, it can be referred to as a MessageService type.
		int temp;
		
		/*LocateRegistry.createRegistry(1099);
		
		//Bind remote object to the registry with the human-readable name "compareStrings"
		Naming.rebind("compareStrings", temp);
		*/
	}// End main

}// End Servant
