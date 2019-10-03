package com.manju.stepdefinitions.productdescription;

import com.manju.seleniumutils.DriverInitializer;
import com.manju.seleniumutils.PageUtils;
import com.manju.stepdefinitions.StepDefBase;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDescriptionStepDef extends StepDefBase {
    @Before()
    public void setUp() {
        pageUtils = new PageUtils();
    }

    @Given("^open \"([^\"]*)\" browser and launch the application$")
    public void open_firefox_browser_and_launch_the_application(final String browserName) {
        pageUtils.launchBrowser(browserName);
        pageUtils.windowMax();
    }

    @Given("^open the \"([^\"]*)\"$")
    public void open_the(final String url) {
        pageUtils.openURL(url);
        pageUtils.timeDelay(30);
        pageUtils.windowMax();
        System.out.println("Homepage launched Successfully");
    }

    @Then("^home page of the application should be displayed$")
    public void home_page_of_the_application_should_be_displayed() throws Throwable {
        final String actualTitle = pageUtils.getTitle();
        String expectedTitle = DriverInitializer.getProperty("homepage.Title");
        Assert.assertEquals("Condition true", actualTitle, expectedTitle);
        System.out.println("Home page verified");
    }

    @Then("^enter a product name \"([^\"]*)\" and naviagte to search result page$")
    public void enter_a_product_name_and_naviagte_to_search_result_page(String searchKeyword) throws Throwable {
        pageUtils.timeDelay(30);
        pageUtils.click(DriverInitializer.getProperty("searchboxname"));
        pageUtils.timeDelay(30);
        pageUtils.sendKeys(DriverInitializer.getProperty("searchboxname"), searchKeyword);
        pageUtils.submit(DriverInitializer.getProperty("searchsubmit"));

    }

    @Then("^verify the search result page$")
    public void verify_the_search_result_page() throws Throwable {
        pageUtils.waitForPageLoaded();
        String searchPageTitle = pageUtils.getTitle();
        pageUtils.waitForPageLoaded();
        String expectedSearchPageTitle = DriverInitializer.getProperty("searchResultpage.title");
        pageUtils.timeDelay(100);
        Assert.assertEquals("Condition true", expectedSearchPageTitle, searchPageTitle);
        System.out.println("Search result page verified");
    }

    @Then("^click on sort by dropdown and select price low to high$")
    public void click_on_sort_by_dropdown_and_select_price_low_to_high() throws Throwable {
        pageUtils.dropDownSelect(DriverInitializer.getProperty("text1"));
        System.out.println("Applied filter Low to High");
    }

    @Then("^click on sort by dropdown and select price high to low$")
    public void click_on_sort_by_dropdown_and_select_price_high_to_low() throws Throwable {
        pageUtils.waitForPageLoaded();
        pageUtils.dropDownSelect(DriverInitializer.getProperty("text2"));
        System.out.println("Applied filter High to Low");

    }

    @Then("^click on sort by dropdown and select Avg customer review$")
    public void click_on_sort_by_dropdown_and_select_Avg_customer_review() throws Throwable {
        pageUtils.waitForPageLoaded();
        pageUtils.dropDownSelect(DriverInitializer.getProperty("text3"));
        System.out.println("Applied filter Avg customer review");
    }

    @Then("^click on sort by dropdown and select New arrivals$")
    public void click_on_sort_by_dropdown_and_select_New_arrivals() throws Throwable {
        pageUtils.waitForPageLoaded();
        pageUtils.dropDownSelect(DriverInitializer.getProperty("text4"));
        System.out.println("Applied filter New arrivals");
    }

    @Then("^select checkbox of any filter and verify the filterd page$")
    public void select_checkbox_of_any_filter_and_verify_the_filterd_page() throws StaleElementReferenceException {
        pageUtils.timeDelay(30);
        pageUtils.checkBoxSelect(DriverInitializer.getProperty("filterName"));
        Assert.assertTrue(pageUtils.isElementPresent(By.xpath(DriverInitializer.getProperty("filterName"))));
        System.out.println("LHS filter applied");
    }

    @Then("^clear the filter and verify whether the applied filter removed from SRP$")
    public void clear_the_filter_and_verify_whether_the_applied_filter_removed_from_SRP() throws Throwable {
        pageUtils.waitForPageLoaded();
        pageUtils.clearFilter(DriverInitializer.getProperty("clearFilter"));
        Assert.assertFalse(pageUtils.isElementPresent(By.linkText(DriverInitializer.getProperty("clearFilter"))));
        System.out.println("LHS filter cleared");
    }


    @Then("^click on a product in search result page$")
    public void click_on_a_product_in_search_result_page() throws Throwable {
        pageUtils.click(DriverInitializer.getProperty("firstProductLink"));
        System.out.println("navigated to prod desc page");

    }

    @Then("^verify the product description page$")
    public void verify_the_product_description_page() throws Throwable {
        pageUtils.isElementVisible(DriverInitializer.getProperty("addToCart"));
        System.out.println("Product description page verified");
    }
    @Then("^click on the Back to Result breadcrumb$")
    public void click_on_the_Back_to_Result_breadcrumb() throws Throwable {
    pageUtils.click(DriverInitializer.getProperty("breadcrumb"));
    }

    @Then("^verify the SRP$")
    public void verify_the_SRP() throws Throwable {
        verify_the_search_result_page();
    }


    @Then("^verify Frequently bought together place holder$")
    public void verify_Frequently_bought_together_place_holder() throws Throwable {
        WebElement element= pageUtils.containsText(DriverInitializer.getProperty("frequentlyBoughtTogether"));
        String text =element.getText();
        if(text.contains("Frequently bought together")){
            System.out.println("Frequently bought together place holder verified");
        }
    }

    @Then("^verify Sponsored products related to this item place holder$")
    public void verify_Sponsored_products_related_to_this_item_place_holder_and_left_and_right_arrow() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("sponsoredProductsRelated"));
        String text = element.getText();
        if (text.contains("Sponsored products related to this item")) {
            System.out.println("Sponsored products related to this item place holder verified");
        }
//        pageUtils.click(DriverInitializer.getProperty("rightArrow"));
//        System.out.println("Right arrow clicked");
//        pageUtils.click(DriverInitializer.getProperty("leftArrow"));
//        System.out.println("Left arrow clicked");
    }

    @Then("^verify What other items do customers buy after viewing this item\\? place holder$")
    public void verify_What_other_items_do_customers_buy_after_viewing_this_item_place_holder() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("otherItems"));
        String text = element.getText();
        if (text.contains("What other items do customers buy after viewing this item?")) {
            System.out.println("What other items do customers buy after viewing this item? place holder verified");
        }
    }

    @Then("^verify Have a question\\? place holder$")
    public void verify_Have_a_question_place_holder() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("haveQuestions"));
        String text = element.getText();
        if (text.contains("Have a question")) {
            System.out.println("Have a question place holder verified");
        }
    }

    @Then("^verify Product Description place holder$")
    public void verify_Product_Description_place_holder() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("productDescription"));
        String text = element.getText();
        if (text.contains("Product ")) {
            System.out.println("Product Description place holder verified");
        }
    }

    @Then("^verify Compare items place holder$")
    public void verify_Compare_items_place_holder() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("compareItems"));
        String text = element.getText();
        if (text.contains("Compare")) {
            System.out.println("Compare items place holder verified");
        }
    }

    @Then("^verify Videos section$")
    public void verify_Videos_section() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("video"));
        String text = element.getText();
        if (text.contains("Videos")) {
            System.out.println("Videos place holder verified");
        }
    }

    @Then("^verify Customer questions & answers section$")
    public void verify_Customer_questions_answers_section() throws Throwable {
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("Q&A"));
        String text = element.getText();
        if (text.contains("Customer questions & answers")) {
            System.out.println("Customer questions & answers place holder verified");
        }
    }

    @Then("^click on the Add to Cart button$")
    public void click_on_the_Add_to_Cart_button() throws Throwable {
        pageUtils.click(DriverInitializer.getProperty("addToCart"));

    }

    @Then("^Click on the add button$")
    public void click_on_the_add_button() throws Throwable {
        pageUtils.timeDelay(20);
        WebElement element = pageUtils.containsText(DriverInitializer.getProperty("popOverHeader"));
        String text = element.getText();
        if (text.contains("Add to your order")) {
            System.out.println("A pop up block displayed");
            pageUtils.timeDelay(30);
            pageUtils.click(DriverInitializer.getProperty("addButton"));
        }
    }

    @Then("^verify the shopping cart$")
    public void verify_the_shopping_cart() throws Throwable {
        pageUtils.timeDelay(30);
        pageUtils.isElementPresent(By.xpath(DriverInitializer.getProperty("proceedToCheckout")));
        System.out.println("Product added to cart");

    }

    @Then("^click on the Buy now button$")
    public void click_on_the_Buy_now_button() throws Throwable {
        pageUtils.click(DriverInitializer.getProperty("buyNow"));
    }

    @Then("^verify user navigates to sign in page$")
    public void verify_user_navigates_to_sign_in_page() throws Throwable {
        //pageUtils.click(DriverInitializer.getProperty("addButton"));
        String actualTitle = pageUtils.getTitle();
        String expectedTitle = DriverInitializer.getProperty("signInTitle");
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("user navigated to sign in page");

    }


    @After
    public void closebrowser() throws Throwable {
        pageUtils.getWebDriver().quit();
    }

}
