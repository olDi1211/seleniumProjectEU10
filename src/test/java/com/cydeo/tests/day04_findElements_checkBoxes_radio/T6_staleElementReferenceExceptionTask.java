package com.cydeo.tests.day04_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_staleElementReferenceExceptionTask {
    public static void main(String[] args) {

        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.navigate().to("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //4- Refresh the page.
        driver.navigate().refresh();

        //5- Verify it is displayed, again.
        //We are refreshing the web element reference by re-assing the local element.
        cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());


        //This is a simple StaleElementReferenceException to understand what is this exception and how to handle it.


    }
}
