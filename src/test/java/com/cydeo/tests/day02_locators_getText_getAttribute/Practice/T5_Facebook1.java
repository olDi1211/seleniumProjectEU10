package com.cydeo.tests.day02_locators_getText_getAttribute.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_Facebook1 {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: Facebook title verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.facebook.com
        driver.navigate().to("https://www.facebook.com");

        //!!!- Click to "Zaakceptuj wszystko"
        WebElement agreeButton = driver.findElement(By.xpath("//button[.='Allow essential and optional cookies']"));
        agreeButton.click();

        //3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”

       String expectedTitle = "Log In or Sign Up";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("The title verification is PASSED!");
        }else {
            System.out.println("The title verification is FAILED!");
        }

        driver.close();



    }
}
