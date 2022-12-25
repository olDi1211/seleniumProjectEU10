package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        //1- Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        //This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the browser size
        driver.manage().window().maximize();
        // driver.manage().window().fullscreen();

        //3- Gp to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of te page
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //Get current URL using Selenium
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //Stop code execution for 3 second
        Thread.sleep(3000);

        //use navigate().to():
        driver.navigate().to("https://google.com");

        //get the title of te page
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //String title = driver.getTitle();

        //Get current URL using Selenium
        System.out.println("currentUrl = " + currentUrl);

        //this will close the currently opened window
        driver.close();

        //this will close ALL the opened windows
        driver.quit();




    }


}
