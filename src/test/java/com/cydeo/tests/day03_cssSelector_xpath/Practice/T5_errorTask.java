package com.cydeo.tests.day03_cssSelector_xpath.Practice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_errorTask {
    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.navigate().to("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement userNameBox = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        userNameBox.sendKeys("incorrect name");

        //4- Click to `Reset password` button
        driver.findElement(By.cssSelector("button[class='login-btn'")).click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.cssSelector("div[class='errortext'"));

        String expectedLabel = "Login or E-mail not found";
        String actualLabel = errorLabel.getText();

        if (expectedLabel.equals(actualLabel)){
            System.out.println("Verification PASS!");
        }else {
            System.out.println("Verification FAIL!");
        }

        driver.close();

        //PS: Inspect and decide which locator you should be using to locate web elements.
        //PS2: Pay attention to where to get the text of this button from


    }
}
