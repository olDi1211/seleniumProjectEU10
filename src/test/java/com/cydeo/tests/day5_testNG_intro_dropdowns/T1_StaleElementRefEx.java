package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_StaleElementRefEx {
    public static void main(String[] args) {

        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.navigate().to("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        boolean isDisplayedDeleteButton = deleteButton.isDisplayed();
        System.out.println("isDisplayedDeleteButton = " + isDisplayedDeleteButton);

        //5. Click to “Delete” button.
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        System.out.println("isDisplayedDeleteButton = " + isDisplayedDeleteButton);

        //driver.close();
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    }
}
