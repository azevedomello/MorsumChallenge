package com.jsonPlaceHolder.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/jsonPlaceHolder/features",
        glue = {"com.jsonPlaceHolder.stepDefinitions", "com.jsonPlaceHolder.dataTable"},
  //      tags = "@Regression",
        plugin = {"pretty","io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        snippets = CucumberOptions.SnippetType.CAMELCASE )

public class TestRunner {
}
