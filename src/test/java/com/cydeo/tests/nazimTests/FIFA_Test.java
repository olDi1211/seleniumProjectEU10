package com.cydeo.tests.nazimTests;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FIFA_Test {

    @Test
    public void FIFA_Test() throws InterruptedException {

        // 1.Go to "https://www.fifa.com/"
        Driver.getDriver().navigate().to("https://www.fifa.com/");

        //1.1 Accept cookies
        WebElement acceptCoockies = Driver.getDriver().findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        acceptCoockies.click();

        // 2.Open the: "Store"
        WebElement store = Driver.getDriver().findElement(By.xpath("//div[.='Store']"));
        store.click();

        // 3.Search for: "Footballs"
        WebElement searchInput = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Search']"));
        searchInput.sendKeys("Footballs"+ Keys.ENTER);
        Thread.sleep(1000);

        // 4.Check if results are listed
        List<WebElement> listOfResults = Driver.getDriver().findElements(By.cssSelector("div[class='relative border border-accent-2']"));
        String lookingProduct = "Ball";
        int amountOfProducts = 0;

        for (int i = 0; i < listOfResults.size(); i++) {
            if(listOfResults.get(i).getText().contains(lookingProduct)){
                amountOfProducts++;}
            if (amountOfProducts == 0){
                System.out.println("There is no products, which you are looking for! You need to check again!");
                System.exit(1);
            }
        }

        // 5.Sort the result by: "Price: Low to high"
        WebElement dropdownButton = Driver.getDriver().findElement(By.id("dropdownMenuButton1"));
        dropdownButton.click();

        WebElement sortByPriceLowToHigh = Driver.getDriver().findElement(By.xpath("//div[.='Price: Low to high']"));
        sortByPriceLowToHigh.click();
        Thread.sleep(1000);

        // 6.Add to your bag/cart two footballs, one with price $15.00 and one with price $20.00
        WebElement showMoreResultsButton1 = Driver.getDriver().findElement(By.xpath("//button[.='Show More Products']"));
        showMoreResultsButton1.click();

        // 6.1 locate first ball and add to the cart
        WebElement ballFor$15 = Driver.getDriver().findElement(By.xpath("//p[.='adidas Al Rihla Mini Football']"));
        ballFor$15.click();

        WebElement addToTheCartButton1 = Driver.getDriver().findElement(By.xpath("//button[.='Add to Cart']"));
        addToTheCartButton1.click();
        Thread.sleep(2000);

        WebElement closeCartButton = Driver.getDriver().findElement(By.xpath("//button[@aria-label='Close']"));
        closeCartButton.click();

        // 6.2 locate second ball and add to the cart
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);

        WebElement showMoreResultsButton2 = Driver.getDriver().findElement(By.xpath("//button[.='Show More Products']"));
        showMoreResultsButton2.click();

        WebElement ballFor$20 = Driver.getDriver().findElement(By.xpath("//p[.='World Cup 2022 Tunisia Licensed Ball Size 2']"));
        ballFor$20.click();

        WebElement addToTheCartButton2 = Driver.getDriver().findElement(By.xpath("//button[.='Add to Cart']"));
        addToTheCartButton2.click();

        // 7.Check if the total price is: $35.00
        String expectedTotalPrice = "$35.00";
        String actualTotalPrice ="";

        WebElement totalPrice = Driver.getDriver().findElement(By.xpath("//div[@style='border-bottom: 2px solid rgb(0, 0, 0);']"));
        actualTotalPrice = totalPrice.getText();

        Assert.assertTrue(actualTotalPrice.contains(expectedTotalPrice));

        // 8.Remove ball with price $15.00 from your bag/cart
        WebElement removeBallButton = Driver.getDriver().findElement(By.xpath("(//button[.='Remove'])[2]"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        js.executeScript("arguments[0].scrollIntoView(true);",removeBallButton);
        removeBallButton.click();
        Thread.sleep(2000);

       // 9.Check if the total price is $20.00
        String expectedNewTotalPrice = "$20.00";
        String actualNewTotalPrice="";

        WebElement newTotalPrice = Driver.getDriver().findElement(By.xpath("//div[@style='border-bottom: 2px solid rgb(0, 0, 0);']"));
        actualNewTotalPrice = newTotalPrice.getText();

        Assert.assertTrue(actualNewTotalPrice.contains(expectedNewTotalPrice));

        Driver.closeDriver();
        //**Try to locate the total price not on the "text price", which allow you to check the different price with out changing your locator

    }

}
