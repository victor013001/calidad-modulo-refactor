package com.udea.sitas.screenplay.tasks;

import com.udea.sitas.screenplay.interactions.*;
import com.udea.sitas.screenplay.userinterfaces.LuggageManagementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FillTheLuggageForm implements Task {

    private final String width;
    private final String height;
    private final String length;
    private final String weight;
    private final String description;
    private final String luggageType;
    private final String placementAreaId;

    public FillTheLuggageForm(String width, String height, String length, String weight, String description, String luggageType, String placementAreaId) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.luggageType = luggageType;
        this.placementAreaId = placementAreaId;
    }

    public static FillTheLuggageForm withValues(String width, String height, String length, String weight, String description, String luggageType, String placementAreaId) {
        return Tasks.instrumented(FillTheLuggageForm.class,
                width, height, length, weight, description, luggageType, placementAreaId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                TextInputToFill.with(width, LuggageManagementPage.TEXT_INPUT_WIDTH)
                        .then(TextInputToFill.with(height, LuggageManagementPage.TEXT_INPUT_HEIGHT))
                        .then(TextInputToFill.with(length, LuggageManagementPage.TEXT_INPUT_LENGTH))
                        .then(TextInputToFill.with(weight, LuggageManagementPage.TEXT_INPUT_WEIGHT))
                        .then(TextInputToFill.with(description, LuggageManagementPage.TEXT_INPUT_DESCRIPTION))
                        .then(TextInputToFill.with(luggageType, LuggageManagementPage.TEXT_INPUT_LUGGAGE_TYPE))
                        .then(TextInputToFill.with(placementAreaId, LuggageManagementPage.TEXT_INPUT_PLACEMENT_AREA_ID))
        );
    }
}
