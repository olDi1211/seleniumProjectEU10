package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Config_Practice {



    @Test
    public void googleSearchTest(){
        //Driver.getDriver() --> driver

        Driver.getDriver().navigate().to("https://google.com");

        //2- Accept cookies
        Driver.getDriver().findElement(By.xpath("//div[.='Avvis alle']")).click();

        //3- Write "apple" in search box
        WebElement googleSearchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));

        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Google-søk";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

}
