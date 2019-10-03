# new feature
# Tags: optional
    


Feature: Verify the Prod desc page

Background: Flow till search result page
            Given open "chrome" browser and launch the application
             Then open the "https://www.amazon.com"
             Then home page of the application should be displayed
             Then enter a product name "Mobile Phone" and naviagte to search result page
             Then click on a product in search result page

#Scenario: Navigate to product description page
 #            Then verify the product description page

#Scenario: verify the breadcrumb navigation to SRP from PDP
#            Then click on the Back to Result breadcrumb
 #           Then verify the SRP

#Scenario:   Verify the different placeholders in PDP
 #            Then verify Frequently bought together place holder
  #           Then verify Sponsored products related to this item place holder
   #         Then verify What other items do customers buy after viewing this item? place holder
    #       Then verify Have a question? place holder
     #       Then verify Product Description place holder
      #      Then verify Compare items place holder
       #     Then verify Videos section
        #    Then verify Customer questions & answers section

#Scenario: To verify the add to cart button
 #           Then click on the Add to Cart button
  #          Then Click on the add button
   #         Then verify the shopping cart

Scenario: To varify the buy now Button
          Then click on the Buy now button
         Then verify user navigates to sign in page







