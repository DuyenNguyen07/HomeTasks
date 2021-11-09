package com.DuyenNguyen.experimenting.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.DuyenNguyen.experimenting.core.DriverWrapper.getDriver;

public abstract class CommonPage {
    public WebElement search_element_by_By(By by) {
        return getDriver().findElement(by);
    }

    public WebElement search_element_by_xpath(String xpath){
        return getDriver().findElement(By.xpath(xpath));
    }
    public WebElement search_element_by_id(String id){
        return getDriver().findElement(By.id(id));
    }
    public WebElement search_element_by_name(String name){
        return getDriver().findElement(By.name(name));
    }
    public WebElement search_element_by_className (String className) {return getDriver().findElement(By.className(className));}
    public WebElement search_element_by_linkText (String linkText){ return getDriver().findElement(By.linkText(linkText));}

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getLink() { return  getDriver().getCurrentUrl();}

    public String getPageSource() {
        return getDriver().getPageSource();
    }

    public String getWindowHandle() {
        return getDriver().getWindowHandle();
    }

    public void scrollDown_by_id(String id) {
        WebElement element = search_element_by_id(id);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
