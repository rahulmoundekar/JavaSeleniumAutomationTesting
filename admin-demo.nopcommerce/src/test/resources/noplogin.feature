Feature: NOPCommerce is an open source ecommerce software 

Scenario: Login Test for nopcommerce 
	Given Navigate to "https://admin-demo.nopcommerce.com/" 
	When user logged in using username as "admin@yourstore.com" and password as "admin" 
	Then user enter login button