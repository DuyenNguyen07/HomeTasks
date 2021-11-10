package com.DuyenNguyen.experimenting.google.pages;

import com.DuyenNguyen.experimenting.core.DriverWrapper;
import com.DuyenNguyen.experimenting.selenium4.UITest.google.pages.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomeSearchPage {
    // Web elements on home search page
    private WebElement googleSearchField = DriverWrapper.getDriver().findElement(By.className("gLFyf"));
    private WebElement getGoogleSearchButton = DriverWrapper.getDriver().findElement(By.name("btnK"));

    public GoogleHomeSearchPage setTextToSearchField(String text) {
        googleSearchField.sendKeys(text);
        return this;
    }

    public GoogleSearchResultPage clickGoogleSearchButton() {
        getGoogleSearchButton.click();
        return new GoogleSearchResultPage();
    }
}
