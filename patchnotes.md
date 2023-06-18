    v0.1.0 
    At this stage I am only using restfull http request to GET, POST, 
    PUT and DELETE information. 

    Customers can find doctors and close appointments
    -created Customers , Doctors , Appointments
    -created Users for future authorization plan
    
    -tested CRUD http methods for each, 
    appointments need to implemented in a different way to
    connect doctors and customers.
    
    v0.1.1
    -reimplemented appointments to be mapped through customer and 
    pass doctor in the request body for the appropriate methods. 

    
    v0.2.0
    -created a very basic react frontend project at : https://github.com/NickGiag/react-frontend-hospital

    -created login - register components
    -created appointments list component
    -created appointment creation form

    -Routing configuring 


    v0.2.1
    -fixed an issue with a cross origin error
    -FIRST connection with the backend! I can GET appointments to print 
    for now customer id is provided manually through URL

    -GET method for doctors required in appointment creation
    -formating request data
    -POST method for appointment creation

    v0.2.2
    -DELETE method for appointment deletion
    -PUT method for appointment update
    -New update component form in frontend