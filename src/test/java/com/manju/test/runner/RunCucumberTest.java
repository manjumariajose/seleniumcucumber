package com.manju.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/" ,
        glue ={"com/manju/stepdefinitions"})
public class RunCucumberTest {
}