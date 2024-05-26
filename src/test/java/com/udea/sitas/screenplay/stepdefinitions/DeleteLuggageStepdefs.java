package com.udea.sitas.screenplay.stepdefinitions;

import com.udea.sitas.screenplay.questions.ValidateMessage;
import com.udea.sitas.screenplay.questions.ValidateTableItem;
import com.udea.sitas.screenplay.tasks.ClickTheButton;
import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
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

public class DeleteLuggageStepdefs {

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

    @And("The user click the delete luggage button")
    public void theUserClickTheDeleteLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.DELETE_LUGGAGE_BUTTON)
        );
    }

    @Then("The user sees the confirmation message")
    public void theUserSeesTheConfirmationMessage() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateMessage.with(Constants.SUCCESS_DELETE_LUGGAGE_MESSAGE))
        );
    }

    @Then("The luggage list shows no luggage")
    public void theLuggageListShowsNoLuggage() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateTableItem.with(Constants.EMPTY_LUGGAGE_MESSAGE, LuggageManagementPage.LUGGAGE_LIST_EMPTY))
        );
    }
}
