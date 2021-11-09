package com.DuyenNguyen.experimenting.selenium4;

import com.DuyenNguyen.experimenting.core.DriverWrapper;
import com.DuyenNguyen.experimenting.google.pages.GoogleHomeSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4Test extends SeleniumBaseTest {

    @Test
    public void testBasingSearchOnGoogleMainPage() {
        String title = new GoogleHomeSearchPage()
                .setTextToSearchField("VietNam")
                .clickGoogleSearchButton()
                .getTitle();
        Assert.assertTrue(title.contains("VietNam"));
    }
}
