package com.udea.sitas.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateTableItem implements Question<Boolean> {

    private final String value;
    private final Target item;

    public ValidateTableItem(String value, Target item) {
        this.value = value;
        this.item = item;
    }

    public static ValidateTableItem with(String value, Target item) {
        return new ValidateTableItem(value, item);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentValue = BrowseTheWeb.as(actor)
                .find(item).getText();
        return currentValue.equals(value);
    }
}
