package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //Creating Faker object to reach methods
        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //numerify() method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        System.out.println("faker.numerify(\"38098-###-###\") = " + faker.numerify("38098-###-###"));

        //letterify() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"?????????\") = " + faker.letterify("???-?????"));

        //bothify() method will return random letters where we pass "?" and random numbers where we pass "#"
        System.out.println("faker.bothify(\"???#-##??\") = " + faker.bothify("???#-#12aa?"));

        System.out.println("faker.finance().creditCard(\"-\",\"\") = " + faker.finance().creditCard());

    }

}
