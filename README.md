# An Asynchronous RMI String Comparison Service

Student Name: Christy Madden <br/>
Student ID: G00214065 <br/>
Module: Distributed Systems <br/>
Lecturer: Dr John Healy <br/>

### Introduction

The project did not get finished and I will explain why below. It can be run with the and will show that the RMI is working. What is lacking is the string comparison functionality. I have code in the project which attempts to perform the string comparison but I was unable to get to all hooked it and working. The non working code is commented out so that the program will run and is commented. Each class is commented and explains what it's purpose is.

### Deployment

1. Downlaod or clone the project from GitHub.
2. Deploy the comparator.war file into tomcat "webapps" folder (I was using linux mint and I had to extract the war file to the webapps folder. Mint is treating war files as archives).
    a. Drag and dropping into the folder should the trick else it may have to be extracted 
    b. The version of tomcat I used was "apache-tomcat-9.0.0.M13".
3. All files needed for the server are in the war file so next step is starting the server.
    a. This can be done by going into tomcats bin folder and running the startup file (On linux this command is "sh startup.sh").
4. After that you can navigate to the directory where you downloaded or cloned my repository.
5. Here you can open up a terminal and run the command "java –cp ./string-service.jar ie.gmit.sw.Servant".
    a. This is starting the RMI registry.
6. Now you can open a browser and go to the url "localhost:8080/comparator" to open the index page of the project
    a. Your version of tomcat may be running on a different port number, if so please use that port.
    b. Also if "localhost" is not working you can try "127.0.0.1"

Following these steps will get the application up and running

### What does the project do?

Sadly not an awful lot. You can enter a string into the two text areas but they won't actually be compared. Clicking the compare button will navigate to the "doProcess" page and at the top of that page there is 
a message which says "RMI is working". This is the RMI working, the StringServiceImpl class has a method which returns this string and it is being called remotely. As mentioned above there is plenty of code in the other 
files but it is commented out due to the fact it isn't fully working and hooked up.

### Why is the project not fully functioning?

There are multiple reasons for this, some are silly mistakes on my part, some were unexpected problems and others were due to using technologies that were new to me. 

1. Learning to use RMI took longer than expected and using a guide from a the book "Heads First Java" ended up causing confusion as they were using an older version of RMI. This meant that I was having very avoidable problems getting started with RMI.

2. I also had issues running the "ServiceHandler.java" file and later found out that I needed the "servlet-api.jar". I then had to figure out how to complile to ServiceHandler while pointing to the servlet-api.jar at the same time. 
Again figuring this all out took more time than I expected.
E.G
```
javac -cp .:/home/christy/Documents/apache-tomcat-9.0.0.M13/webapps/comparator/WEB-INF/lib/servlet-api.jar ServiceHandler.java
```

3. The biggest problem however, came from testing the code that I had written. I could not find a way to debug the code that was running on the server (basically all the string comparision functionality). I tried using the "EE"
version of eclipse to run the server but this continuously gave me errors. The inability to see what the server code was doing and see if it was working meant that the project meant the project was almost impossible 
to complete. I'm sure I missed a simple way of debugging the code but with having to learn so many new things at the one time and trying to get other parts of the project working, I was unable to find a solution to this before
the deadline.

### What I would do differently

In hindsight I would do a lot differently (although there were certain things I learned from the issues I had),

1. Firstly I would have found a way to get tomcat running with eclipse, if I could have got that working earlier then I would have completed the project.    
2. I would of found a more up to date resource for setting up the RMI as far too much time was wasted on it and it put me under pressure for the rest of the project. 
3. I would have dedicated more time to simply understanding tomcat and it's folder structure. There was confusion with certain folders and what they were for, which added unneeded complexity to the project.