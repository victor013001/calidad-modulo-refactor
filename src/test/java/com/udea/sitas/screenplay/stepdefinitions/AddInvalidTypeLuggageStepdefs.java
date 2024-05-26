package com.udea.sitas.screenplay.stepdefinitions;

import com.udea.sitas.screenplay.questions.ValidateMessage;
import com.udea.sitas.screenplay.tasks.FillTheLuggageForm;
import com.udea.sitas.screenplay.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AddInvalidTypeLuggageStepdefs {

    private final Actor userId1 = Actor.named("UserId1");

    @Managed(
            driver = "chrome",
            uniqueSession = true
    )
    public WebDriver chromeDriver;

    @Before
    public void setup() {
        userId1.can(BrowseTheWeb.with(chromeDriver));
        OnStage.setTheStage(new OnlineCast());
    }

    @And("The user fill the invalid luggage information")
    public void theUserFillTheInvalidLuggageInformation() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.PERSONAL_LUGGAGE_WIDTH,
                        Constants.PERSONAL_LUGGAGE_HEIGHT,
                        Constants.PERSONAL_LUGGAGE_LENGTH,
                        Constants.PERSONAL_LUGGAGE_WEIGHT,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.PERSONAL_LUGGAGE_TYPE,
                        Constants.INVALID_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @Then("The luggage management page show an error with the invalid type")
    public void theLuggageManagementPageShowAnErrorWithTheInvalidType() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.INVALID_LUGGAGE_MESSAGE))
        );
    }
}
