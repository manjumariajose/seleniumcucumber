    package com.manju.seleniumutils;

    import com.google.common.base.Verify;
    import org.junit.Assert;import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedCondition;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Select;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.util.concurrent.TimeUnit;

    public class PageUtils {

        private WebDriver webDriver;

        public void launchBrowser(final String browser) {
            webDriver = DriverInitializer.getDriver(browser);
        }

        public void openURL(final String loginUrl) {
            webDriver.get(loginUrl);
        }

        public void windowMax() {
            webDriver.manage().window().maximize();
        }

        public void timeDelay(long time) {
            webDriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        }

        public void click(final String elementName) {
            webDriver.findElement(By.xpath(elementName)).click();
        }

        public void sendKeys(final String elementName, final String keywords) {
            webDriver.findElement(By.xpath(elementName)).sendKeys(keywords);
        }

        public void submit(final String elementName) {
            webDriver.findElement(By.id(elementName)).submit();
        }

        public String getTitle() {
            return webDriver.getTitle();
        }

        public void closeBrowser() {
            try {
                webDriver.close();
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        public void dropDownSelect(String elementName){
            Select oSelect= new Select(webDriver.findElement(By.id("s-result-sort-select")));
            oSelect.selectByVisibleText(elementName);
                    }
        public WebDriver getWebDriver() {
            return webDriver;
        }
        public void waitForPageLoaded() {
            WebDriverWait wait = new WebDriverWait(webDriver, 40);
            wait.until(ExpectedConditions.titleContains(DriverInitializer.getProperty("searchResultpage.title")));
        }
        public void checkBoxSelect(String elementName) {
            WebElement chkbox1 = webDriver.findElement(By.xpath(elementName));
            chkbox1.click();
            timeDelay(30);
        }
        public void clearFilter(String elementName){
            WebElement ckbox =webDriver.findElement(By.linkText(elementName));
            timeDelay(30);
            ckbox.click();
        }

        public boolean isElementPresent(By elementName) {
            try {
                webDriver.findElement(elementName);
                return true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                return false;
            }
        }

        public boolean isElementVisible(String cssLocator){
            return webDriver.findElement(By.cssSelector(cssLocator)).isDisplayed();
        }
        public WebElement containsText(String elementName){
            return webDriver.findElement(By.xpath(elementName));
        }


    }
