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

public class AddStorageLuggageStepdefs {

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


    @When("The user click the add storage luggage button")
    public void theUserClickTheAddStorageLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.ADD_STORAGE_LUGGAGE_BUTTON)
        );
    }

    @And("The user fill the storage luggage information")
    public void theUserFillTheStorageLuggageInformation() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.STORAGE_LUGGAGE_WIDTH,
                        Constants.STORAGE_LUGGAGE_HEIGHT,
                        Constants.STORAGE_LUGGAGE_LENGTH,
                        Constants.STORAGE_LUGGAGE_WEIGHT,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.STORAGE_LUGGAGE_TYPE,
                        Constants.STORAGE_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @And("The user fill the storage luggage information with values greater than the max valid")
    public void theUserFillTheStorageLuggageInformationWithValuesGreaterThanTheMaxValid() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.STORAGE_LUGGAGE_WIDTH_GREATER_THAN_MAX,
                        Constants.STORAGE_LUGGAGE_HEIGHT_GREATER_THAN_MAX,
                        Constants.STORAGE_LUGGAGE_LENGTH_GREATER_THAN_MAX,
                        Constants.STORAGE_LUGGAGE_WEIGHT_GREATER_THAN_MAX,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.STORAGE_LUGGAGE_TYPE,
                        Constants.STORAGE_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @Then("The luggage management page show an error with the storage luggage valid max values")
    public void theLuggageManagementPageShowAnErrorWithTheStorageLuggageValidMaxValues() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.MAX_VALUES_STORAGE_LUGGAGE_MESSAGE))
        );
    }
}
