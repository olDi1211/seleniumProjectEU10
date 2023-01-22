package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test(){

        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        //Driver.getDriver --> driver.get(url)
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("registration.form.url"));

        //3. Enter first name
        WebElement firstNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        firstNameInput.sendKeys(firstName);

        //4. Enter last name
        WebElement lastNameInput = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        String lastName = faker.name().lastName();
        lastNameInput.sendKeys(lastName);

        //5. Enter username
        WebElement userNameInput = Driver.getDriver().findElement(By.name("username"));
        String userName = firstName+lastName;
        userNameInput.sendKeys(userName);

        //6. Enter email address
        WebElement emailPasswordInput = Driver.getDriver().findElement(By.name("email"));
        String emailAddress = firstName.toLowerCase()+lastName.toLowerCase()+"@cydeo.com";
        emailPasswordInput.sendKeys(emailAddress);

        //7. Enter password
        WebElement passwordInput = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        String password = "WoodenSpoon";
        passwordInput.sendKeys(password);

        //8. Enter phone number
        WebElement phoneNumberInput = Driver.getDriver().findElement(By.xpath("//input[@type='tel']"));
        String phoneNumber = faker.numerify("###-###-####");
        phoneNumberInput.sendKeys(phoneNumber);

        //9. Select a gender from radio buttons
        WebElement genderInput = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderInput.click();

        //10. Enter date of birth
        WebElement dateOfBirthInput = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        String dateOfBirth = "12/11/1993";
        dateOfBirthInput.sendKeys(dateOfBirth);

        //11. Select Department/Office
        WebElement selectDepartmentTable = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));
        selectDepartmentTable.click();

        WebElement selectOffice = Driver.getDriver().findElement(By.xpath("//option[@value='TRO']"));
        selectOffice.click();

        //12. Select Job Title
        WebElement jobTitleTable = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        jobTitleTable.click();

        WebElement selectJobTitle = Driver.getDriver().findElement(By.xpath("//option[.='QA']"));
        selectJobTitle.click();

        //13. Select programming language from checkboxes
        WebElement programingLanguage = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programingLanguage.click();

        //14. Click to sign up button
        WebElement signButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signButton.click();

        //15. Verify success message “You've successfully completed registration!” is displayed.
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//p"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "You've successfully completed registration!";

        Assert.assertEquals(actualMessage, expectedMessage);

        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense
    }

    @AfterMethod
    public void driverOff(){
        Driver.getDriver().quit();
    }

}
