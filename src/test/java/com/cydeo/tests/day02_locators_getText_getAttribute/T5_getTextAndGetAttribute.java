package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getTextAndGetAttribute {
    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.navigate().to("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedHeaderText = "Registration form";
        String actualHeaderText = headerText.getText();

        if (expectedHeaderText.equals(actualHeaderText)) {
            System.out.println("Header text verification Passed!");
        }else {
            System.out.println("Header text verification Failed!");
        }

        //4- Locate “First name” input box
        WebElement inputBox = driver.findElement(By.name("firstname"));

        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String actualAttributeText = inputBox.getAttribute("placeholder");
        String expectAttributeText = "first name";

        if (actualAttributeText.equals(expectAttributeText)){
            System.out.println("Attributes of placeholder are the same!");
        }else {
            System.out.println("Attributes of placeholder are NOT the same!");
        }

        driver.close();


    }


}

