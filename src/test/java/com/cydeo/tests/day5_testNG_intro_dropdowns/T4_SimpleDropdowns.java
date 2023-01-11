package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
//TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.navigate().to("https://practice.cydeo.com/dropdown");

    }
    @AfterMethod
    public void endMethod(){
        driver.close();
    }

    @Test
    public void simpleDropdownsTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String currentlySelectedOption = simpleDropdown.getFirstSelectedOption().getText();
        String expectedSelectOption = "Please select an option";

        Assert.assertEquals(currentlySelectedOption, expectedSelectOption);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        String currentlySelectedState = stateDropdown.getFirstSelectedOption().getText();
        String expectedSelectionState = "Select a State";

        Assert.assertEquals(currentlySelectedState,expectedSelectionState);




}






}
