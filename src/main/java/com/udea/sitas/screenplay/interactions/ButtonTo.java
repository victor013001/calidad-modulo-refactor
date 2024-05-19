package com.udea.sitas.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ButtonTo implements Interaction {

    private final Target buttonTarget;

    public ButtonTo(Target buttonTarget) {
        this.buttonTarget = buttonTarget;
    }

    public static ButtonTo click(Target button) {
        return Tasks.instrumented(ButtonTo.class, button);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(buttonTarget));
    }
}
