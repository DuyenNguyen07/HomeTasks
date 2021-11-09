package com.DuyenNguyen.experimenting.calculator.pages;

import com.DuyenNguyen.experimenting.core.CommonPage;
import org.openqa.selenium.WebElement;

public class CalculatorHomePage extends CommonPage {
    // Web elements on calculator home page
    private WebElement standardCalculatorButton = search_element_by_xpath("//*[@class='button red btnsml caps']");
    private WebElement loveCalculatorButton = search_element_by_xpath("//*[@class='fas fa-heart']");

}
