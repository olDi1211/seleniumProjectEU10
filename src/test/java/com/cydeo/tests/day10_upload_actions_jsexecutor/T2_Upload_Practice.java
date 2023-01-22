package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload

        Driver.getDriver().navigate().to("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path ="C:\\Users\\dmuti\\Desktop\\Java Programing E10\\HTML Class\\Screenshot_2.png";

        //3. Upload the file.
        WebElement uploadInput = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        uploadInput.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@class='button']"));
        uploadButton.click();

        //4. Assert: -File uploaded text is displayed on the page
        WebElement uploadedText = Driver.getDriver().findElement(By.xpath("//h3"));

        Assert.assertTrue(uploadedText.isDisplayed());



    }

}
