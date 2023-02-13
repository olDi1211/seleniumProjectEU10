package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    @Test
    public void dynamic_load7_test(){

        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().navigate().to("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        //use the "wait" to create our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        //3. Assert:
        //Message “Done” is displayed.
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());

        Driver.closeDriver();

    }

    @Test
    public void dynamic_load1_test(){

        //TC#5 : Dynamically Loaded Page Elements 1
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().navigate().to("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();

        //2. Click to start
        dynamicLoad1Page.startButton.click();

        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUserName.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoad1Page.inputUserName.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());

        Driver.closeDriver();

    }


}
