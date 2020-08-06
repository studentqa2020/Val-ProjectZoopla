Feature: Zoopla Automation Feature 
	
Scenario: As a Automation practice user , i can login successfully with valid user name and password 
Given open a browser 
And Put URL 
And click accept all cookies button
When Click Signin 
And put valid user name 
And put valid password
And click sign in button 
When Validate login was success
And select property
And get Agent Info
Then Signout