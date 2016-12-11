package ie.gmit.sw;

import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import javax.servlet.*;
import javax.servlet.http.*;

/*
 *   This class gets the input from the user.
 *   It looks up the RMI registry and finds  the method getMessage.
 *   The message retrieved is stored in a variable which is displayed at the top of the "doProcess" page
 *   
 *   Other work going on includes the user details being initialised in a class called ClientStringAlgorithm and then the object is put in a BlockingQueue.
 *   This is the end of the pojects functionality, the reason for this is explained in the README.txt
 */

public class ServiceHandler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// Blocking queue to take  a type ClientStringAlgorithm which containClientStringAlgorithm
	public static BlockingQueue<ClientStringAlgorithm> queue = new LinkedBlockingQueue<ClientStringAlgorithm>();
	
	// Out queue which will take the task number and result of the string comparison
	private static Map<String, Resultator> outQueueMap = new ConcurrentHashMap<String,Resultator>();
	
	ClientStringAlgorithm csa;
	private StringService ss;
	private String remoteHost = null;
	private static long jobNumber = 0;
		
	public void init() throws ServletException 
	{
		
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
	
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Declare variables
		//ClientStringAlgorithm csa = null;
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// ======================================  WORKING  ======================================
		
		// RMI only returns an object so cast it to type needed
		// Get the result of the compared strings back from the servlet
		try {
			ss = (StringService) Naming.lookup("rmi://localhost:1099/compareStrings");
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
			
		//  =======================================================================================
		
		// Get simple message
		String RMI_Message = ss.getMessage();
		
		// ======================================  GET VARIABLES FROM CLIENT  ======================================
		
		//  Initialise some request varuables with the submitted form info. 
		//  These are local to this method and thread safe...
		String algorithm = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");
		
		// ==========================================================================================================

		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		if (taskNumber == null)
		{
			
			//  ========================  CREATE OBJECT WITH DETAILS PASS OVER FROM CLIENT  ========================
			
			// Create a task number
			taskNumber = new String("T" + jobNumber);
			
			jobNumber++;
			
			// Pass detaills from client
			csa = new ClientStringAlgorithm(s, t, algorithm, taskNumber);
			
			//  =====================================================================================================
			
			
			//  =================================  ADD DETAILS INTO A MESSAGE QUEUE  ================================
			
			queue.add(csa);
			
			//  =====================================================================================================
			
			// Pass to thread
			//CompareWorker cw = new CompareWorker(queue, csa, ss, outQueueMap);
						
			/*	// Get the result for this tasknumber
			Resultator result = outQueueMap.get(taskNumber);
			
			// Retrieve the string with the score
			algorithmScore = result.getResult();
			*/
			
			
		}else{
			//Check out-queue for finished job
		}
		
		//out.print("A New Message has arrived!!!!!!! "   +  csa.getString1());
		/*out.print("A New Message has arrived!!!!!!! SCORE = " + algorithmScore);*/
		out.print("==============================<br>");
		out.print("RMI Message says " + RMI_Message);
		out.print("<br>=========================<br>");
		
		
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		
		out.print("<font color=\"#993333\"><b>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<br>Algorithm: " + algorithm);		
		out.print("<br>String <i>s</i> : " + s);
		out.print("<br>String <i>t</i> : " + t);
		out.print("<br>This servlet should only be responsible for handling client request and returning responses. Everything else should be handled by different objects.");
		out.print("Note that any variables declared inside this doGet() method are thread safe. Anything defined at a class level is shared between HTTP requests.");				
		out.print("</b></font>");

		out.print("<P> Next Steps:");	
		out.print("<OL>");
		out.print("<LI>Generate a big random number to use a a job number, or just increment a static long variable declared at a class level, e.g. jobNumber.");	
		out.print("<LI>Create some type of an object from the request variables and jobNumber.");	
		out.print("<LI>Add the message request object to a LinkedList or BlockingQueue (the IN-queue)");			
		out.print("<LI>Return the jobNumber to the client web browser with a wait interval using <meta http-equiv=\"refresh\" content=\"10\">. The content=\"10\" will wait for 10s.");	
		out.print("<LI>Have some process check the LinkedList or BlockingQueue for message requests.");	
		out.print("<LI>Poll a message request from the front of the queue and make an RMI call to the String Comparison Service.");			
		out.print("<LI>Get the <i>Resultator</i> (a stub that is returned IMMEDIATELY by the remote method) and add it to a Map (the OUT-queue) using the jobNumber as the key and the <i>Resultator</i> as a value.");	
		out.print("<LI>Return the result of the string comparison to the client next time a request for the jobNumber is received and the <i>Resultator</i> returns true for the method <i>isComplete().</i>");	
		out.print("</OL>");	
		
		out.print("<form name=\"frmRequestDetails\">");
		out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algorithm + "\">");
		out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
		out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
		out.print("</script>");
				
		//You can use this method to implement the functionality of an RMI client
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}