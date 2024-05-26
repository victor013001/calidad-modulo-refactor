package com.udea.sitas.screenplay.stepdefinitions;

import com.udea.sitas.screenplay.questions.ValidateTableItem;
import com.udea.sitas.screenplay.tasks.ClickTheButton;
import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import com.udea.sitas.screenplay.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class FindLuggageStepdefs {

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

    @When("The user click the see my luggage button")
    public void theUserClickTheSeeMyLuggageButton() {
        userId1.attemptsTo(
                ClickTheButton.target(LuggageManagementPage.GET_LUGGAGE_BUTTON)
        );
    }

    @Then("The user sees all his luggage")
    public void theUserSeesAllHisLuggage() {
        GivenWhenThen.then(userId1).should(
                GivenWhenThen.seeThat(ValidateTableItem.with(Constants.LUGGAGE_DESCRIPTION, LuggageManagementPage.TABLE_ITEM_DESCRIPTION)),
                GivenWhenThen.seeThat(ValidateTableItem.with(Constants.PERSONAL_LUGGAGE_TYPE, LuggageManagementPage.TABLE_ITEM_LUGGAGE_TYPE))
        );
    }
}
