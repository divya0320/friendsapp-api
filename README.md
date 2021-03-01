# friendsapp-api


## Command used to run application 

1. mvn spring-boot:run -> Application will run at http://localhost:8080
2. H2 database can be viewed at http://localhost:8080/h2-console


## Rest API 
App can make requests to the following REST endpoints.


#Action

	Get /userList
    --> Get list of users 
	
	Get /usersFriendList/{id}
    --> Get list of friends a user have 
   
  Get /usersSuggestedFriendList/{id}
      --> Get list of suggested friends a user have 
	
	Get /usersSuggestedFriendListGeographically/{id}
    --> Get list of suggested friends a user have geographically ( in alphabetical order )

