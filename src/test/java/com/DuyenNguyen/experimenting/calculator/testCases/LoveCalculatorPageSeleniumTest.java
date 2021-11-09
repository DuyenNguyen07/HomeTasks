package com.DuyenNguyen.experimenting.calculator.testCases;

import com.DuyenNguyen.experimenting.calculator.pages.LoveCalculatorPage;
import org.testng.annotations.Test;

public class LoveCalculatorPageSeleniumTest extends LoveCalculatorSeleniumBaseTest {
    @Test
    public void testDisplayedResultOnLoveCalculator() {
          LoveCalculatorPage result = new LoveCalculatorPage()
                .setYourName("Duyen")
                .setPartnerName("Duyen")
                .clickCalculateButton();







    }
}
