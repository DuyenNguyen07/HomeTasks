package com.DuyenNguyen.experimenting.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Selenium4Test extends SeleniumBaseTest {
    @Test
    public void testingChromeAndSeleniumBasic() throws InterruptedException {
        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
        WebDriver driver = new ChromeDriver(service);

        // fullscreen
        //driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); //fullscreen gif bee ddee vl

        driver.navigate().to("https://google.com");

//        // delete cookies on google.com
//        //? How they work and how to check if cookies deleted
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("SID");

//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        //? click button Try free on Notion.so
//        driver.findElement(By.className("jsx-1093639235")).click();
//        driver.findElement(new By.ByXPath("http://html/body/div[1]/div/div[2]/div/main/section[1]/article/div[2]/div[1]/a/button")).click();

//        // Enter 'youtube' into search bar and click search button
//        driver.findElement(By.name("q")).sendKeys("youtube");
//        Thread.sleep(2000);
//        WebElement searchButton = driver.findElement(By.name("btnK"));
//        searchButton.click();
//        Thread.sleep(2000);

//        // Enter 'youtube' into search bar, press enter and verify it navigate to proper website
//        driver.findElement(By.name("q")).sendKeys("youtube" + Keys.ENTER);
//        Thread.sleep(2000);
//        WebElement Youtube = driver.findElement(By.className("LC20lb"));
//        Youtube.click(); //Click on youtube link
//        Thread.sleep(2000);
//        Assert.assertEquals(driver.getCurrentUrl().toString(), "https://www.youtube.com/");



        //driver.quit();
    }
}
