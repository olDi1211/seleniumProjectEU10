package com.cydeo.tests.day03_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        //driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        WebElement inputUsername = driver.findElement(By.name("USER_LOGIN"));
        inputUsername.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        //driver.findElement(By.name("USER_PASSWORD")).sendKeys("incorrect");
        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");

        //5- Click to login button.
        driver.findElement(By.className("login-btn")).click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        String actualText = driver.findElement(By.className("errortext")).getText();
        String expectedText = "Incorrect login or password";

        if (actualText.equals(expectedText)){
            System.out.println("Verification PASSED!");
        }else {
            throw new RuntimeException("Verification FAILED! The text are NOT the same");

        }

        driver.close();



    }

}
