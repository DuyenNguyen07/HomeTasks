package com.DuyenNguyen.experimenting.calculator.pages;

import com.DuyenNguyen.experimenting.core.CommonPage;
import org.openqa.selenium.WebElement;

public class LoveCalculatorPage extends CommonPage {
    private WebElement yourNameTextBox = search_element_by_id("name1");
    private WebElement partnerNameTextBox = search_element_by_id("name2");
    private WebElement calculateButton = search_element_by_xpath("//*[@value='Calculate']");
    private WebElement resultArea = search_element_by_xpath("//*[@id='calc_calc']");

    public LoveCalculatorPage setYourName(String yourName) {
        yourNameTextBox.sendKeys(yourName);
        return this;
    }

    public LoveCalculatorPage setPartnerName(String partnerName) {
        partnerNameTextBox.sendKeys(partnerName);
        return this;
    }

    public LoveCalculatorPage clickCalculateButton() {
        calculateButton.click();
        return this;
    }

}
