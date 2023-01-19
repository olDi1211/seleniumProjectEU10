package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verification {

    WebDriver driver;
    //TC #1: Web table practice
    //1. Go to: https://practice.cydeo.com/web-tables
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void order_name_verify_test(){
        // 2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”

        WebElement bobMartinCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));

        String actualBobsName = bobMartinCell.getText();
        String expectedBobsName = "Bob Martin";

        Assert.assertEquals(actualBobsName,expectedBobsName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected:

        WebElement orderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        String actualOrderDate = orderDate.getText();
        String expectedOrderDate = "12/31/2021";

        Assert.assertEquals(actualOrderDate,expectedOrderDate);


    }

    //We use the utility method we created.
    @Test
    public void test2(){

        String customerOrderDate = WebTableUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("customerOrderDate = " + customerOrderDate);
        driver.close();
    }

    //Using WebTablesUtils.orderVerify(); method
    @Test
    public void test3(){
        WebTableUtils.orderVerify(driver,"Bart Fisher","01/16/2021");
    }






}
