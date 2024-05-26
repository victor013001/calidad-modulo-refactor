package com.udea.sitas.screenplay.stepdefinitions;

import com.udea.sitas.screenplay.questions.ValidateMessage;
import com.udea.sitas.screenplay.tasks.ClickTheButton;
import com.udea.sitas.screenplay.tasks.FillTheLuggageForm;
import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import com.udea.sitas.screenplay.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AddHandLuggageStepdefs {

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

    @When("The user click the add hand luggage button")
    public void theUserClickTheAddHandLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.ADD_HAND_LUGGAGE_BUTTON)
        );
    }

    @And("The user fill the hand luggage information")
    public void theUserFillTheHandLuggageInformation() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.HAND_LUGGAGE_WIDTH,
                        Constants.HAND_LUGGAGE_HEIGHT,
                        Constants.HAND_LUGGAGE_LENGTH,
                        Constants.HAND_LUGGAGE_WEIGHT,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.HAND_LUGGAGE_TYPE,
                        Constants.HAND_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @And("The user fill the hand luggage information with values greater than the max valid")
    public void theUserFillTheHandLuggageInformationWithValuesGreaterThanTheMaxValid() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.HAND_LUGGAGE_WIDTH_GREATER_THAN_MAX,
                        Constants.HAND_LUGGAGE_HEIGHT_GREATER_THAN_MAX,
                        Constants.HAND_LUGGAGE_LENGTH_GREATER_THAN_MAX,
                        Constants.HAND_LUGGAGE_WEIGHT_GREATER_THAN_MAX,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.HAND_LUGGAGE_TYPE,
                        Constants.HAND_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @Then("The luggage management page show an error with the hand luggage valid max values")
    public void theLuggageManagementPageShowAnErrorWithTheHandLuggageValidMaxValues() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.MAX_VALUES_HAND_LUGGAGE_MESSAGE))
        );
    }
}
