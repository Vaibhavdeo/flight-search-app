# flight-search-app

This app is developed using spring boot technology.

Steps - Downlod the zip file from Github repository from below link- 
https://github.com/Vaibhavdeo/flight-search-app

Details of the project.
1 - Package Structure - 
com.search.flight.beans
com.search.flight.config
com.search.flight.constants
com.search.flight.endpoint
com.search.flight.search.app
com.search.flight.service
com.search.flight.util.

a.com.search.flight.endpoint
This package contains FlightController which is the controller class has the implementation of interface - http://{localhost}/searchFlights/{Origin}/{Destination}


b.com.search.flight.service - 
This package contains FlightService class which has the buisness logic to get the data from 3 diff sources.

c.com.search.flight.beans-
This package has the POJO class of flight details.

d.com.search.flight.config 
This packege conatains configuration classes. Implementation of swagger
When you run this application - Swagger URL will be-http://localhost:8081/swagger-ui.html

e- com.search.flight.search.app-
This package contains the entry point where the app runs. 

f- com.search.flight.util-
Conatains utility classes and sorting classes.

2 - src/main/resources 
Contains application.properties file
and 3 files provider1.csv, provider2.csv,provider3.csv


3 -src/main/test
This folder has some test cases of endpoint package.


Scope of Improvement- 
Due to time limit following things has scope to improve - 

1 - JUnit Test cases - to test multiple scenarios and find the bugs-
2 - Data can be store in database and fetch it from DB with applying filter on queries.  
3 - code cleanliness
4. Exception Handling(Custom Exception)





