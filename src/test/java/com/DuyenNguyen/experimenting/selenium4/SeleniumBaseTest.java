package com.DuyenNguyen.experimenting.selenium4;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseTest extends BaseTest {
    @BeforeMethod
    public void preCondition() {
        DriverWrapper.getDriver().navigate().to("https://google.com");
    }

    @AfterMethod
    public void postCondition() {
        DriverWrapper.getDriver().quit();
    }
}
