package com.manju.stepdefinitions;

import com.manju.seleniumutils.DriverInitializer;
import com.manju.seleniumutils.PageUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage extends StepDefBase {

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
    public void open_url(final String url) {
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
    }

    @Then("^clear the filter and verify whether the applied filter removed from SRP$")
    public void clear_the_filter_and_verify_whether_the_applied_filter_removed_from_SRP() throws Throwable {
        pageUtils.waitForPageLoaded();
        pageUtils.clearFilter(DriverInitializer.getProperty("clearFilter"));
        Assert.assertFalse(pageUtils.isElementPresent(By.linkText(DriverInitializer.getProperty("clearFilter"))));
    }

    @After
    public void closebrowser() throws Throwable {
        pageUtils.getWebDriver().quit();
    }

}
