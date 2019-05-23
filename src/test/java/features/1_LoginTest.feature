Feature: verify user is able do all the actions on login page

	 @sanity @loginAsRootAdmin 
	Scenario: Login as Root Admin
		Given User navigates to portal user page
		And Validate user name label from the left navigation is successful
		Then click log out to exit  
		

	 @sanity @loginAsGPAdmin 
	Scenario: Login as GP Admin
		Given User navigates to merchants summary page
		Then Validate user name label from the left navigation is successful
		Then click log out to exit
