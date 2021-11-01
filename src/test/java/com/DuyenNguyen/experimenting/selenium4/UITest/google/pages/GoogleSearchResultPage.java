package com.DuyenNguyen.experimenting.selenium4.UITest.google.pages;

import com.DuyenNguyen.experimenting.core.DriverWrapper;

public class GoogleSearchResultPage extends BaseGooglePage {

    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }
}
