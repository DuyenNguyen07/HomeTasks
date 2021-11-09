package com.DuyenNguyen.experimenting.calculator.testCases;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.BeforeTest;


public class CalculatorSeleniumBaseTest extends BaseTest {
    @BeforeTest
    public void preCondition() {
        System.out.println("Before method");
        DriverWrapper.getDriver().navigate().to("https://www.calculator.com/");
    }
}


