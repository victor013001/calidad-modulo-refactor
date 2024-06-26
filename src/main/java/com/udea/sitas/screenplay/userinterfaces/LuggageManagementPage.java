package com.udea.sitas.screenplay.userinterfaces;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LuggageManagementPage extends PageObject {

    public static final Target ADD_PERSONAL_LUGGAGE_BUTTON = Target.the("Personal Luggage Button")
            .located(By.id("Equipaje Personal"));

    public static final Target ADD_HAND_LUGGAGE_BUTTON = Target.the("Hand Luggage Button")
            .located(By.id("Equipaje de Mano"));

    public static final Target ADD_STORAGE_LUGGAGE_BUTTON = Target.the("Storage Luggage Button")
            .located(By.id("Equipaje de Bodega"));

    public static final Target GET_LUGGAGE_BUTTON = Target.the("Get Luggage Button")
            .locatedBy("//*[@id=\"root\"]/div[1]/div/div[2]/button");

    public static final Target DELETE_LUGGAGE_BUTTON = Target.the("Delete Luggage Button")
            .locatedBy("/html/body/div[2]/div[3]/div/div/table/tbody/tr/td[7]/button");

    public static final Target LUGGAGE_LIST_EMPTY = Target.the("Get Luggage list empty")
            .locatedBy("/html/body/div[2]/div[3]/div/p");

    public static final Target TEXT_INPUT_WIDTH = Target.the("Text input Width")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[1]/div/div/input");

    public static final Target TEXT_INPUT_HEIGHT = Target.the("Text input Height")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[2]/div/div/input");

    public static final Target TEXT_INPUT_LENGTH = Target.the("Text input Length")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[3]/div/div/input");

    public static final Target TEXT_INPUT_WEIGHT = Target.the("Text input Weight")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[4]/div/div/input");

    public static final Target TEXT_INPUT_DESCRIPTION = Target.the("Text input Description")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[5]/div/div/input");

    public static final Target TEXT_INPUT_LUGGAGE_TYPE = Target.the("Text input Luggage type")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[6]/div/div/input");

    public static final Target TEXT_INPUT_PLACEMENT_AREA_ID = Target.the("Text input Placement area id")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[10]/div/div/input");

    public static final Target SAVE_LUGGAGE_BUTTON = Target.the("Save Luggage Button")
            .locatedBy("/html/body/div[2]/div[3]/form/div/div[11]/button");

    public static final Target ALERT_MESSAGE = Target.the("Error alert message")
            .located(By.id("snackbar"));

    public static final Target TABLE_ITEM_DESCRIPTION = Target.the("Table item description")
            .locatedBy("/html/body/div[2]/div[3]/div/div/table/tbody/tr/td[5]");

    public static final Target TABLE_ITEM_LUGGAGE_TYPE = Target.the("Table item luggage type")
            .locatedBy("/html/body/div[2]/div[3]/div/div/table/tbody/tr/td[6]");
}
