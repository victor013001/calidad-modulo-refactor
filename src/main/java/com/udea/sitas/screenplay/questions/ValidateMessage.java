package com.udea.sitas.screenplay.questions;

import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateMessage implements Question<Boolean> {

    private final String text;

    public ValidateMessage(String text) {
        this.text = text;
    }

    public static ValidateMessage with(String text) {
        return new ValidateMessage(text);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentMessageText =  BrowseTheWeb.as(actor).find(LuggageManagementPage.ERROR_ALERT_MESSAGE).getText();
        return currentMessageText.equals(text);
    }
}
