Feature: Google Search 

Background:
	Given i lunch chrome browser 

@smoke @regression 
Scenario: I Want to search cucumber feature file in google 
	When i type the "cucumber feature file" in search box 
	And click on search button 
	Then i will see the result related search 
	And enter messages 
		|Hello        |
		|How are you  |
	
@smoke @regression 
Scenario: I Want to search selenium in google 
	When i type the "selenium" in search box 
	And click on search button 
	