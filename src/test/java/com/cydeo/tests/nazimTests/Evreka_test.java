package com.cydeo.tests.nazimTests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Evreka_test {

    @Test
    public void everekaTest(){

        //1. Go to 'https://www.amazon.com.tr/'
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("everekaTestUrl"));

        //1.1 Accept cookies
        WebElement acceptButton = Driver.getDriver().findElement(By.name("accept"));
        acceptButton.click();

        // 2. Search iPhone13 512
        WebElement searchInput = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        searchInput.click();
        searchInput.sendKeys("iPhone 13 512"+ Keys.ENTER);

        // 3. Check that the results are listed
        List<WebElement> listOfResults = Driver.getDriver().findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

        String lookingProduct = "iPhone 13";
        int amountOfProducts = 0;

        //This loop verify if needed product is listed. You can change the "lookingProduct" String and check if another products are listed.
        for (int i = 0; i < listOfResults.size(); i++) {
            if (listOfResults.get(i).getText().contains(lookingProduct)){
                amountOfProducts++;
            }
            if (amountOfProducts ==0){
                System.out.println("There is no products, which you are looking for! You need to check again!");
                System.exit(1);
            }
        }

        //4. This loop click on the first iPhone 13 at the top of the list, even if iPhone is not at the first place of the whole list
        for (int i = 0; i < listOfResults.size(); i++) {
            if (listOfResults.get(i).getText().contains(lookingProduct)) {
                listOfResults.get(0).click();
                break;
            }
        }


        //5. Log the following values for each size. Size information .Price .Color .Stock status
        WebElement size = Driver.getDriver().findElement(By.xpath("//p[.='512 GB']"));
        WebElement price = Driver.getDriver().findElement(By.className("a-price-whole"));
        WebElement color = Driver.getDriver().findElement(By.xpath("(//span[@class='selection'])[2]"));

        WebElement stock = Driver.getDriver().findElement(By.xpath("//input[@name='items[0.base][quantity]']"));
        String amountAtStock = stock.getAttribute("value");
        String firstPartOfStockText = "Stokta sadece";
        String lastPartOfStockText = "adet kaldi";

        System.out.println(lookingProduct+" "+"Size: "+size.getText());
        System.out.println("Color: "+color.getText()+" "+"Price: "+price.getText());
        System.out.println("Stock: "+firstPartOfStockText+" "+amountAtStock+" "+lastPartOfStockText);


      Driver.closeDriver();

    }








}
