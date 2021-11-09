package com.DuyenNguyen.experimenting.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverWrapper {
    private static WebDriver driver = null;

    private DriverWrapper() {
        ChromeDriverService service = ChromeDriverService
                .createServiceWithConfig(new ChromeOptions());
        this.driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            new DriverWrapper();
        }
            return driver;
    }

}
