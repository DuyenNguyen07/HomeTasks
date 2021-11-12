package com.DuyenNguyen.experimenting.calculator.testCases;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import com.DuyenNguyen.experimenting.selenium4.SeleniumBaseTest;
import org.testng.annotations.BeforeTest;


public class CalculatorSeleniumBaseTest extends SeleniumBaseTest {
    @BeforeTest
    public void preCondition() {
        System.out.println("Before method");
        DriverWrapper.getDriver().navigate().to("https://www.calculator.com/");
    }
}


