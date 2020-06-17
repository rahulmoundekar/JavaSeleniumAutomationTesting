Feature: To Search New & old cars in Car guide website

Scenario: New & Used Car Search - carsguide
	Given User Navigate to "https://www.carsguide.com.au/"
	When user click on buy sell
	And user navigate to search cars menu
	Then user redirect to search cars page
	Then user select any make
	And user select any model
	And user select any location
	And user select any price
	Then use redirect to Selected search car page 
	
