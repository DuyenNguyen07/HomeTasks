package com.DuyenNguyen.experimenting.selenium4;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class SeleniumBaseTest extends BaseTest {
    @AfterMethod
    public void postCondition() {
        System.out.println("After method");
        DriverWrapper.getDriver().quit();
    }
}
