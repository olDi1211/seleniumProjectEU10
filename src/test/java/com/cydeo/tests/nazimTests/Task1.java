package com.cydeo.tests.nazimTests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Driver go to "https://www.flipkart.com/"
        driver.navigate().to("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Driver click to "cookie"
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        //                _2sVfI7                                        _2KpZ6l _2doB4z
        // Driver click to "Electronics"
        driver.findElement(By.xpath("//div[@class='_1psGvi SLyWEo']")).click();

    }
}
