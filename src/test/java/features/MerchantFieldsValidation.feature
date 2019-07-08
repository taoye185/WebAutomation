Feature: New Merchant Fields Validation

# @NewMerchant @loginAsGPAdmin
# Scenario: To Verify that an error message should be displayed when the Merchant ID is missing
#	Given User successfully navigated to New Merchant Page
#	When User leave the merchant ID empty
#	Then An error message shall be displayed under the merchant ID field
#	And Create Merchant button is not active
  	
 @NewMerchant @loginAsGPAdmin
 Scenario Outline: To Verify that an error message should be displayed when the "<FieldName>" is missing
	Given User successfully navigated to New Merchant Page
	When User leave the "<FieldName>" empty
	Then An "<ExpectedErrorMessage>" shall be displayed under the "<FieldName>" field
	And Create Merchant button is not active
Examples:
	|FieldName					|ExpectedErrorMessage			|ErrorMessageInCaseNotMatch| 
	|businessName				|Please enter a business name	|Business Name is not added|
	|MerchantIDTextbox			|Please enter the merchant ID	|Merchant ID is not added| 
 	|MerchantTimeZoneDropdown	|Please enter a name			|The mpos administrator is not added| 
	|userEmailTextbox			| Please enter an email			|The mpos Email is not added|
	|userEmailTextbox			|Invalid email address			|The mpos email is not valid|