package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.navigate().to("http://practice.cydeo.com/javascript_alerts");

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @Test
    public void alert_test1(){
         //3. Click to “Click for JS Alert” button
        WebElement alertButtonAccept = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        alertButtonAccept.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement textAfterAlertButton = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));
        String actualText = textAfterAlertButton.getText();
        String expectedText = "You successfully clicked an alert";

        Assert.assertTrue(textAfterAlertButton.isDisplayed(),"Result text is NOT displayed");
        Assert.assertEquals(actualText,expectedText,"Actual result text is not as expected!!!");




    }





}
