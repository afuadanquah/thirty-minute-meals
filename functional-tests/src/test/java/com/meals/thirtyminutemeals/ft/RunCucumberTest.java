package com.meals.thirtyminutemeals.ft;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/",
    glue = "com.meals.thirtyminutemeals.ft")
public class RunCucumberTest {
}
