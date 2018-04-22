package com.itbt.assignment.framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Element {

    public static WebElement findTextElement(String labelName) {
        WebElement labelElement = findLabelElement(labelName);
        Assert.assertTrue("ERROR - ENV : input element is not found for "+labelElement.getText(),
                labelElement.findElement(By.xpath("..")).findElements(By.cssSelector("input[type='text']")).size() > 0);
        return labelElement.findElement(By.xpath("..")).findElement(By.cssSelector("input[type='text']"));
    }

    public static List<WebElement> findAllRadioElements(String labelName) {
        WebElement labelElement = findLabelElement(labelName);
        WebElement parentElement = labelElement.findElement(By.xpath(".."));
        Assert.assertTrue("ERROR - ENV : input element is not found for "+labelElement.getText(),
                parentElement.findElements(By.cssSelector("input[type='radio']")).size() > 0);
        return parentElement.findElements(By.cssSelector("input[type='radio']"));
    }

    public static WebElement findTextAreaElement(String labelName) {
        WebElement labelElement = findLabelElement(labelName);
        Assert.assertTrue("ERROR - ENV : text area element is not found for "+labelElement.getText(),
                labelElement.findElement(By.xpath("..")).findElements(By.tagName("textarea")).size() > 0);
        return labelElement.findElement(By.xpath("..")).findElement(By.tagName("textarea"));
    }

    public static WebElement findSelectElement(String labelName) {
        WebElement labelElement = findLabelElement(labelName);
        Assert.assertTrue("ERROR - ENV : select element is not found for "+labelElement.getText(),
                labelElement.findElement(By.xpath("..")).findElements(By.tagName("select")).size() > 0);
        return labelElement.findElement(By.xpath("..")).findElement(By.tagName("select"));
    }

    public static WebElement findButtonElement(String buttonText) {
        List<WebElement> allButtonElements = Browser.getDriver().findElements(By.cssSelector(".btn-default"))
                .stream().filter(e -> e.getText().equalsIgnoreCase(buttonText)).collect(Collectors.toList());
        Assert.assertTrue("ERROR - ENV : button element is not found for " + buttonText,
                allButtonElements.size() > 0);
        return allButtonElements.get(0);
    }

    private static WebElement findLabelElement(String labelName) {
        List<WebElement> allElements = Browser.getDriver().findElements(By.cssSelector(".control-label"))
                .stream().filter(e -> e.getText().equalsIgnoreCase(labelName)).collect(Collectors.toList());
        Assert.assertTrue("ERROR - ENV : element not found with label name as "+labelName,
                allElements.size() > 0);
        Assert.assertFalse("ERROR - ENV : duplicate elements found on page with label name as "+labelName,
                allElements.size() > 1);
        return allElements.get(0);
    }
}
