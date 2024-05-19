package com.udea.sitas.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

public class TextInputToFill implements Interaction {

    private final String value;
    private final Target textInputTarget;

    public TextInputToFill(String value, Target textInputTarget) {
        this.value = value;
        this.textInputTarget = textInputTarget;
    }

    public static TextInputToFill with(String value, Target textInputTarget) {
        return Tasks.instrumented(TextInputToFill.class, value, textInputTarget);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(Keys.CONTROL + "a").into(textInputTarget),
                SendKeys.of(Keys.BACK_SPACE).into(textInputTarget),
                Enter.theValue(value).into(textInputTarget)
        );
    }
}
