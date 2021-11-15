package com.DuyenNguyen.experimenting.booking.pages;

import com.DuyenNguyen.experimenting.core.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ParisPage extends CommonPage {
    By destinationPropertyNameTextBox = By.xpath("//input[@id='ss']");

    public String getDestinationPropertyName() {
        String destinationPropertyName = search_element_by_By(destinationPropertyNameTextBox)
                .getAttribute("value");
        return destinationPropertyName;
    }
}
