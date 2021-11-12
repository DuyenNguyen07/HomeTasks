package com.DuyenNguyen.experimenting.booking.testCases;


import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.core.DriverWrapper;
import com.DuyenNguyen.experimenting.selenium4.SeleniumBaseTest;
import org.testng.annotations.BeforeTest;

public class BookingSeleniumBaseTest extends SeleniumBaseTest {
    @BeforeTest
    public void preCondition() {
        System.out.println("Before Test");
        DriverWrapper.getDriver().navigate().to("https://www.booking.com/");

    }

}
