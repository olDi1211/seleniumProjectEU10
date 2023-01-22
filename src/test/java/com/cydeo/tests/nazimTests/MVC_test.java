package com.cydeo.tests.nazimTests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MVC_test {
    public WebDriver driver;
    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void mvc_test() throws InterruptedException {

        //1. Load the website.
        driver.navigate().to("https://todomvc.com");

        //2. Click on JavaScript tab.
        WebElement javaScriptTab = driver.findElement(By.xpath("//div[.='JavaScript']"));
        javaScriptTab.click();

        //3. Select the polymer link.
        WebElement polymerLink = driver.findElement(By.linkText("Polymer"));
        polymerLink.click();

        //4. Add two Todo items
        //4.1 Add first item:
        WebElement input = driver.findElement(By.xpath("//input[@id='new-todo']"));
        input.sendKeys("My first item"+Keys.ENTER);

        //4.2 Add second item:
        input.sendKeys("My second item"+Keys.ENTER);

        //5. Edit the content of the second Todo item
        WebElement secondItem = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(secondItem).perform();

        WebElement secondItemText = driver.findElement(By.xpath("//input[@id='edit']"));

        secondItemText.sendKeys(" with additional information.");

    }



}
