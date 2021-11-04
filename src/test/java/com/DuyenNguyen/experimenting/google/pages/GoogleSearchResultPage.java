package com.DuyenNguyen.experimenting.google.pages;

import com.DuyenNguyen.experimenting.core.DriverWrapper;

import java.sql.Driver;

public class GoogleSearchResultPage extends BaseGooglePage {
    public String getTitle() {
        return DriverWrapper.getDriver().getTitle();
    }
}
