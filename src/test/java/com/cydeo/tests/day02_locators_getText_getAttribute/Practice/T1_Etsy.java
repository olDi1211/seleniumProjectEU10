package com.cydeo.tests.day02_locators_getText_getAttribute.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Etsy {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: Etsy Title Verification
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.navigate().to("http://www.etsy.com");

        //!!!- Click to "Accept"
        WebElement agreeButton=driver.findElement(By.className("wt-overlay__footer__action"));
        agreeButton.click();

        //3. Search for “wooden spoon”
        WebElement searchWoodenSpoon = driver.findElement(By.name("search_query"));
        searchWoodenSpoon.sendKeys("wooden spoon");
        searchWoodenSpoon.click();

        //4. Verify title:
        //Expected: “Wooden spoon | Etsy”
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title are the same!");
        }else {
            System.out.println("Title are NOT the same!");
        }

        driver.close();


    }
}
