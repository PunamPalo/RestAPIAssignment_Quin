Feature: Validating Bins APIs
@AddBin
Scenario: Verify if Bin is being sucessfully added using createBinsAPI
	Given User makes a request to CreateBinAPI with "<name>"  "<address>"
	When user calls "CreteBinAPI" with "POST" http request
	Then the API call request gets success with status code 200
	
Examples:
		|name 	 |  address		   	   | 
		|Punamn	 |  World cross center changed | 
		

@ReadBin	
Scenario: Verify if Get Bin functionality is working
	Given User makes a request to ReadBinAPI with "<Id>" 
	When user calls "ReadBinAPI" with "GET" http request
	Then the API call request gets success with status code 200
	
@UpdateBin	
Scenario: Verify if Update Bin functionality is working
	Given User makes a request to UpdateBinAPI with "<name>"  "<address>"
	When user calls "UpdateBinAPI" with "PUT" http request
	Then the API call request gets success with status code 200
	
Examples:
		|name 	 |  address		   	   		   | 
		|Poonam	 |  Sea cross center changed   | 

@DeleteBin		
Scenario: Verify if Delete Bin functionality is working
	Given User makes a request to DeleteBinAPI
	When user calls "DeleteBinAPI" with "DELETE" http request
	Then the API call request gets success with status code 200		
	


    