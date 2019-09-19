package com.manju.stepdefinitions;

import com.manju.seleniumutils.DriverInitializer;
import com.manju.seleniumutils.PageUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public abstract class StepDefBase {

    protected PageUtils pageUtils = null;
    protected WebDriver webDriver = null;

    public StepDefBase() {
        pageUtils = new PageUtils();
    }
}

