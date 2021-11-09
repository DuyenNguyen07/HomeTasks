package com.DuyenNguyen.experimenting;

import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static com.DuyenNguyen.experimenting.core.DriverWrapper.getDriver;

public class BaseTest {
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);

//    public void implicitWait(int second) {
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
//    }

    @AfterTest
    public void postCondition() {

        System.out.println("After Test");
        DriverWrapper.getDriver().quit();
    }
}
