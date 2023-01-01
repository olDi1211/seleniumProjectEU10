package com.cydeo.tests.day04_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.navigate().to("https://practice.cydeo.com/forgot_password");
        driver.manage().window().maximize();

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //b. “Forgot password” header: locate parent element and move down to h2
        WebElement forgotPassword_ex1 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPassword_ex2 = driver.findElement(By.cssSelector("div.example > h2"));
        //Locate header using xpath, and using web elements text "Forgot Password"
        WebElement forgotPassword_ex3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPassword_ex4 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));

        //d. E-mail input box
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));
        //using xpath contains method
        //tagname[contains(@attribute, 'value')]
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z0-9')]"));

        //e. “Retrieve password” button
        WebElement retrievePassword_ex1 = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeo_ex1 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1 = " + homeLink_ex1.isDisplayed());
        System.out.println("forgotPassword_ex1 = " + forgotPassword_ex1.isDisplayed());
        System.out.println("emailLabel = " + emailLabel.isDisplayed());
        System.out.println("inputBox_ex1 = " + inputBox_ex1.isDisplayed());
        System.out.println("retrievePassword_ex1 = " + retrievePassword_ex1.isDisplayed());
        System.out.println("poweredByCydeo_ex1 = " + poweredByCydeo_ex1.isDisplayed());

        driver.close();

    }


}
