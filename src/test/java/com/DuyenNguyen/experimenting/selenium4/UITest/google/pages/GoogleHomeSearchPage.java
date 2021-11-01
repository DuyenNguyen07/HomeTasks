package com.DuyenNguyen.experimenting.selenium4.UITest.google.pages;

import com.DuyenNguyen.experimenting.core.DriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoogleHomeSearchPage extends BaseGooglePage{
    private WebElement googleSearchBar = DriverWrapper.getDriver().findElement(By.className("gLFyf"));
    private WebElement googleSearchButton = DriverWrapper.getDriver().findElement(By.name("btnK"));

    // initial WebDriver as DriverWrapper in core package
//    public void launchGooglePage(String url) {
//        ChromeDriverService service = ChromeDriverService.createServiceWithConfig(new ChromeOptions());
//        WebDriver driver = new ChromeDriver(service);
//        driver.navigate().to(url);
//        //return driver;
//    }

    public GoogleHomeSearchPage setTextToSearchBar(String text) {
        googleSearchBar.sendKeys(text);
        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchButton() {
        googleSearchButton.click();
        return new GoogleSearchResultPage();
    }



    @Test
    public void testGoogleSearch() throws InterruptedException {
//        String url = "https://google.com";
//        launchGooglePage(url);
        setTextToSearchBar("youtube");
        clickGoogleSearchButton();




    }
}
