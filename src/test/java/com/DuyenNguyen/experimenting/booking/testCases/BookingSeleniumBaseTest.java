package com.DuyenNguyen.experimenting.booking.testCases;


import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.testng.annotations.BeforeTest;

public class BookingSeleniumBaseTest extends BaseTest {
    @BeforeTest
    public void preCondition() {
        System.out.println("Before Test");
        DriverWrapper.getDriver().navigate().to("https://www.booking.com/");

    }

}
