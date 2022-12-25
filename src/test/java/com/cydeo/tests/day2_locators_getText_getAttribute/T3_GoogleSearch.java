package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {

        //TC#3: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");

        //!!!- Click to "Zaakceptuj wszystko"
        WebElement agreeButton=driver.findElement(By.id("L2AGLb"));
        agreeButton.click();

        //3- Write “apple” in search box + 4- click google search bottom
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);

        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedTitle = "apple - Szukaj w Google";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title is the same!");
        }else {
            System.out.println("Title is NOT the same!");
        }

        driver.close();




    }
}
