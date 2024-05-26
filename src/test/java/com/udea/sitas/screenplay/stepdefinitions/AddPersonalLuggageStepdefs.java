package com.udea.sitas.screenplay.stepdefinitions;

import com.udea.sitas.screenplay.questions.ValidateMessage;
import com.udea.sitas.screenplay.tasks.ClickTheButton;
import com.udea.sitas.screenplay.tasks.FillTheLuggageForm;
import com.udea.sitas.screenplay.tasks.OpenThe;
import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import com.udea.sitas.screenplay.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class AddPersonalLuggageStepdefs {

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

    @Given("The user is in the luggage management page")
    public void theUserIsInTheLuggageManagementPage() {
        userId1.attemptsTo(
                OpenThe.browser(new LuggageManagementPage())
        );
    }

    @When("The user click the add personal luggage button")
    public void theUserClickTheAddPersonalLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.ADD_PERSONAL_LUGGAGE_BUTTON)
        );
    }

    @And("The user fill the personal luggage information")
    public void theUserFillThePersonalLuggageInformation() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.PERSONAL_LUGGAGE_WIDTH,
                        Constants.PERSONAL_LUGGAGE_HEIGHT,
                        Constants.PERSONAL_LUGGAGE_LENGTH,
                        Constants.PERSONAL_LUGGAGE_WEIGHT,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.PERSONAL_LUGGAGE_TYPE,
                        Constants.PERSONAL_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @And("The user click the save luggage button")
    public void theUserClickTheSaveLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.SAVE_LUGGAGE_BUTTON)
        );
    }

    @Then("The luggage must be added")
    public void theLuggageMustBeAdded() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.SUCCESS_ADD_LUGGAGE_MESSAGE))
        );
    }

    @Then("The luggage management page show an error")
    public void theLuggageManagementPageShowAnError() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.USER_HAS_LUGGAGE_MESSAGE))
        );
    }

    @And("The user fill the personal luggage information with values greater than the max valid")
    public void theUserFillThePersonalLuggageInformationWithValuesGreaterThanTheMaxValid() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.PERSONAL_LUGGAGE_WIDTH_GREATER_THAN_MAX,
                        Constants.PERSONAL_LUGGAGE_HEIGHT_GREATER_THAN_MAX,
                        Constants.PERSONAL_LUGGAGE_LENGTH_GREATER_THAN_MAX,
                        Constants.PERSONAL_LUGGAGE_WEIGHT_GREATER_THAN_MAX,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.PERSONAL_LUGGAGE_TYPE,
                        Constants.PERSONAL_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @Then("The luggage management page show an error with the personal luggage valid max values")
    public void theLuggageManagementPageShowAnErrorWithTheValidMaxValues() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.MAX_VALUES_PERSONAL_LUGGAGE_MESSAGE))
        );
    }

    @And("The user fill the personal luggage information with values less than the min valid")
    public void theUserFillThePersonalLuggageInformationWithValuesLessThanTheMinValid() {
        userId1.attemptsTo(
                FillTheLuggageForm.withValues(
                        Constants.LUGGAGE_WIDTH_LESS_THAN_MIN,
                        Constants.LUGGAGE_HEIGHT_LESS_THAN_MIN,
                        Constants.LUGGAGE_LENGTH_LESS_THAN_MIN,
                        Constants.LUGGAGE_WEIGHT_LESS_THAN_MIN,
                        Constants.LUGGAGE_DESCRIPTION,
                        Constants.PERSONAL_LUGGAGE_TYPE,
                        Constants.PERSONAL_LUGGAGE_PLACEMENT_AREA_ID
                ));
    }

    @Then("The luggage management page show an error with the invalid values")
    public void theLuggageManagementPageShowAnErrorWithTheInvalidValues() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(
                        Constants.MAX_WIDTH_MESSAGE,
                        Constants.MAX_HEIGHT_MESSAGE,
                        Constants.MAX_LENGTH_MESSAGE,
                        Constants.MAX_WEIGHT_MESSAGE
                ))
        );
    }
}
