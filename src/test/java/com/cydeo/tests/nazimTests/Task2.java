package com.cydeo.tests.nazimTests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.flipkart.com/");



        WebElement closeWindow = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
        closeWindow.click();

        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//img[@class='_396cs4']")));
        WebElement wiredHeadphonesBtn = driver.findElement(By.xpath("//a[.='Wired Headphones']"));

        System.out.println(wiredHeadphonesBtn.isDisplayed());
        wiredHeadphonesBtn.click();

    }


}

