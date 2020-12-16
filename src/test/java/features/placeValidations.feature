Feature: Validating Movie API's
@ViewMovie @Regression
Scenario Outline: Verify if movie is succesfully displayed in API
	Given View Movie with "<APIKey>"  "<t>" "<y>" "<type>"
	When user calls "ViewMovie" with "GET" http request
	Then the API call got success with status code 200
	And "Year" in response body is 2018
	
Examples:
	|apikey 	 | t                     |y	   | type | 
	|9c7073c4 |  %E2%80%9CA+star+is+born |2018|movie|
#	any number of parameters can be passed this way





	

	
	
	
	
	
	

	
	
	
