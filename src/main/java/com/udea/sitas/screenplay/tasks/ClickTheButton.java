package com.udea.sitas.screenplay.tasks;

import com.udea.sitas.screenplay.interactions.ButtonTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class ClickTheButton implements Task {

    private final Target target;

    public ClickTheButton(Target target) {
        this.target = target;
    }

    public static ClickTheButton target(Target target) {
        return Tasks.instrumented(ClickTheButton.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ButtonTo.click(target));
    }

}