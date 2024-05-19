package com.udea.sitas.screenplay.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.udea.sitas.screenplay.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AddPersonalLuggageRunner {
}

