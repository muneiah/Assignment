package com.itbt.assignment.framework;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;

public class Interactions {
    public static void enterText(String labelName, String textToEnter) {
        Element.findTextElement(labelName).sendKeys(textToEnter);
    }

    public static void enterTextInTextArea(String labelName, String textToEnter) {
        Element.findTextAreaElement(labelName).sendKeys(textToEnter);
    }

    public static void selectRadioButton(String labelName, String valueToSelect) {
        List<WebElement> radioElements = Element.findAllRadioElements(labelName);
        Optional<WebElement> radioButtonToSelect =
                radioElements.stream().filter(e -> e.getAttribute("value").equalsIgnoreCase(valueToSelect)).findFirst();
        Assert.assertTrue("ERROR - ENV : element not present!!", radioButtonToSelect.isPresent());
        radioButtonToSelect.get().click();
    }

    public static void selectDropDownValue(String labelName, String valueToSelect) {
        Select select = new Select(Element.findSelectElement(labelName));
        Assert.assertTrue("ERROR - ENV : value not present in dropdown!!",
                select.getOptions().stream().anyMatch(e -> e.getText().equalsIgnoreCase(valueToSelect)));
        select.selectByVisibleText(valueToSelect);
    }

    public static void clickOnButton(String buttonText) {
        Element.findButtonElement(buttonText).click();
    }
}
