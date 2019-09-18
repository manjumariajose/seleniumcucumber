# new feature
# Tags: optional
    
Feature: Verify the search result page

Background: Flow till search result page
            Given open "firefox" browser and launch the application
             Then open the "https://www.amazon.com"
             Then home page of the application should be displayed
             Then enter a product name "Mobile Phone" and naviagte to search result page
    
#Scenario:Search for a product in search bar
             #Then verify the search result page


#Scenario:To verify the sort in search result page
 #            Then click on sort by dropdown and select price low to high
  #          Then click on sort by dropdown and select Avg customer review
   #        Then click on sort by dropdown and select New arrivals


Scenario: To verify the LHS flter
          Then select checkbox of any filter and verify the filterd page
          Then clear the filter and verify whether the applied filter removed from SRP






