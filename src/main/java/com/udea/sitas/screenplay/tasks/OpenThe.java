package com.udea.sitas.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.pages.PageObject;

public class OpenThe implements Task {

    private final PageObject page;

    public OpenThe(PageObject page) {
        this.page = page;
    }

    public static OpenThe browser(PageObject page) {
        return Tasks.instrumented(OpenThe.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(this.page));
    }
}
