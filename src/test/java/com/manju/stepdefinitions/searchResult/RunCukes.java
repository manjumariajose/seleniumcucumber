package com.manju.stepdefinitions.searchResult;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/sumith/Workspace/manju/seleniumcucumber/src/test/resources/features/search.feature" ,
        glue ={"com/manju/stepdefinitions/SearchResultPage"})

public class RunCukes {
}
