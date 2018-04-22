package com.itbt.assignment.framework;

public class FormPage {

    public FormPage(){
        Browser.getDriver();
        Browser.getDriver().navigate().to(Config.getUrl());
    }

    public FormPage fillAllTextBoxes(String... values) {
        for(String element : values) {
            String labelName = element.split(", ")[0];
            String valueToType = element.split(", ")[1];
            Interactions.enterText(labelName, valueToType);
        }
        return this;
    }

    public FormPage fillAllTextAreaBoxes(String... values) {
        for(String element : values) {
            String labelName = element.split(", ")[0];
            String valueToType = element.split(", ")[1];
            Interactions.enterTextInTextArea(labelName, valueToType);
        }
        return this;
    }

    public FormPage selectDropDownValues(String... values) {
        for(String element : values) {
            String labelName = element.split(", ")[0];
            String valueToSelect = element.split(", ")[1];
            Interactions.selectDropDownValue(labelName, valueToSelect);
        }
        return this;
    }

    public FormPage selectMultipleValuesInDropDown(String... values) {
        for(String element : values) {
            String labelName = element.split(", ")[0];
            String[] valuesToSelect = element.split(", ")[1].split("\\|");
            for(String value : valuesToSelect) {
                Interactions.selectDropDownValue(labelName, value);
            }
        }
        return this;
    }

    public FormPage selectRadioButtons(String... values) {
        for(String element : values) {
            String labelName = element.split(", ")[0];
            String valueToType = element.split(", ")[1];
            Interactions.selectRadioButton(labelName, valueToType);
        }
        return this;
    }

    public FormPage clickOnButton(String buttonText) {
        Interactions.clickOnButton(buttonText);
        return this;
    }
}
