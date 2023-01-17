package com.cydeo.tests.day7_webtabies_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {

    public WebDriver driver;
    //1. Create new test and make setups
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void crm_login_test(){


        //2. Go to : https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("Helpdesk1@cybertekschool.com");

        /*
         USERNAME                     PASSWORD
         helpdesk1@cybertekschool.com UserUser
         Helpdesk2@cybertekschool.com UserUser
         */

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        //6. Verify title is as expected:
        //Expected: My tasks
        BrowserUtils.verifyTitle(driver,"My tasks");




    }


}
