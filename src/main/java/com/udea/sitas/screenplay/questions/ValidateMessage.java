package com.udea.sitas.screenplay.questions;

import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.Arrays;

public class ValidateMessage implements Question<Boolean> {

    private final String[] texts;

    public ValidateMessage(String... texts) {
        this.texts = texts;
    }

    public static ValidateMessage with(String... texts) {
        return new ValidateMessage(texts);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentMessageText =  BrowseTheWeb.as(actor).find(LuggageManagementPage.ALERT_MESSAGE).getText();
        return Arrays.stream(texts).allMatch(currentMessageText::contains);
    }
}
