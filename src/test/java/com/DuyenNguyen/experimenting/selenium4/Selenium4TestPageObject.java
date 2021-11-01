package com.DuyenNguyen.experimenting.selenium4;

import com.DuyenNguyen.experimenting.selenium4.UITest.google.pages.GoogleHomeSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium4TestPageObject extends SeleniumBaseTest {
    @Test
    public void testingChromeAndSeleniumBasic(){
        // some logic here
    }

    @Test
    public void testBasingSearchOnGoogleHomePage() {
        String title =
                new GoogleHomeSearchPage()
                        .setTextToSearchBar("Viet Nam")
                        .clickGoogleSearchButton()
                        .getTitle();
        Assert.assertTrue(title.contains("Viet Nam"));
    }
}
