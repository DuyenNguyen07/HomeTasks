package com.DuyenNguyen.experimenting.calculator.testCases;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.BeforeTest;

public class LoveCalculatorSeleniumBaseTest extends BaseTest {
    @BeforeTest
    public void preCondition() {
        System.out.println("Before Test");
        DriverWrapper.getDriver().navigate().to("https://www.calculator.com/calculate/love/");
    }
}
