package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

import org.testng.annotations.Test;

public class SingeltonPractice {

    @Test(priority = 2)
    public void singelton_understand_test1(){

        String str1 = Singelton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singelton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singelton.getWord();
        System.out.println("str3 = " + str3);

    }

    @Test(priority = 1)
    public void singelton_understand_test2(){

        String str4 = Singelton.getWord();
        System.out.println("str4 = " + str4);

    }

}
