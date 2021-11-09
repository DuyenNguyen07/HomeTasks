package com.DuyenNguyen.experimenting.selenium4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestCalculator_com {
    static ChromeDriverService service = ChromeDriverService.createDefaultService();
    static WebDriver driver = new ChromeDriver(service);

    /*
    Calculator.com
     */
    // Navigate to calculator.com
    public WebDriver navigateCalculator() {
        driver.navigate().to("https://www.calculator.com/");
        return driver;
    }

    // [UI] Verify navigate calculator link
    @Test
    public void testCalculatorLink() {
        navigateCalculator();
        String currentURL = driver.getCurrentUrl();
        System.out.println("The current url is " + currentURL);
        Assert.assertEquals(currentURL, "https://www.calculator.com/");
        driver.quit();
    }

    // [UI] Verify page src contains sth
    @Test
    public void testCalculatorPageSourceContains() {
        navigateCalculator();
        Assert.assertTrue(driver.getPageSource().contains("<meta name=\"description\" content=\"calculate anything, anytime," +
                " anywhere... Free online calculators for everything. Some solve problems, some satisfy curiosity and some simply" +
                " for fun.\">\n"));
    }

    // [UI] Verify Calculator title
    @Test
    public void testCalculatorTitle() throws InterruptedException {
        navigateCalculator();
        System.out.println("The title is " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("calculator.com"));
        driver.quit();
    }

    public void calculatorNavigation(String url, String xpath) {
        navigateCalculator();
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.isEnabled());
        element.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void calculatorNavigationBy(String url, By elementBy) {
        navigateCalculator();
        WebElement element = driver.findElement(elementBy);
        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.isEnabled());
        element.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    // [UI] Verify standard calculator navigation
    @Test
    public void testStandardCalculatorNavigation() throws InterruptedException {
        calculatorNavigation("https://www.calculator.com/tape-calculator/", "/html/body/div[2]/div[1]/div[1]/div[1]");
    }

    // [UI] Verify fractions calculator navigation
    @Test
    public void testFractionsCalculatorNavigation() throws InterruptedException {
        calculatorNavigation("https://www.calculator.com/fractions/", "/html/body/div[2]/div[1]/div[1]/div[2]");
    }

    // [UI] Verify scientific calculator navigation
    @Test
    public void testScientificCalculatorNavigation() throws InterruptedException {
        calculatorNavigation("https://www.calculator.com/scientific/", "/html/body/div[2]/div[1]/div[1]/div[3]");
    }

    // [UI] Verify percent calculator navigation

    @Test
    public void testPercentCalculatorNavigation() throws InterruptedException {
        By xpathBy = By.xpath("/html/body/div[2]/div[1]/div[1]/div[4]");
        calculatorNavigationBy("https://www.calculator.com/calculate/percentage/", xpathBy);
    }

    /*
    Love Calculator
     */
    public WebDriver navigateLoveCalculator() {
        driver.get("https://calculator.com/calculate/love/");
        return driver;
    }

    // [UI] Verify love calculator title
    @Test
    public void testLoveCalculatorTitle() throws InterruptedException {
    navigateLoveCalculator();
        Assert.assertEquals(driver.getTitle(), "The Love Calculator");
        driver.quit();
    }

    // [UI] Verify the love calculator name
    public void testLoveCalculatorName() throws  InterruptedException {
        navigateLoveCalculator();
        driver.findElement(By.cssSelector("body > div:nth-child(4) > div.col-lg-8.col-sm-12 > div:nth-child(2) > div:nth-child(1) > div > div")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#calc_title > h2")).getText(),  "The Love Calculator");
    }

    // [UI] Verify explanation is displayed
    @Test
    public void testLoveCalculatorExplanations() throws InterruptedException {
        navigateLoveCalculator();
        Assert.assertTrue(driver.findElement(By.id("aexplain")).isDisplayed());
    }

    // [UI] Verify love calculator explanation content is displayed after click
    @Test
    public void testLoveCalculatorExplanationContent() throws InterruptedException {
        navigateLoveCalculator();

        // Scroll down
        WebElement element = driver.findElement(By.id("aexplain"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Assert.assertFalse(driver.findElement(By.id("explain")).isDisplayed()); // not show content at beginning
        Assert.assertFalse(driver.findElement(By.id("aexplain")).isEnabled());
        driver.findElement(By.xpath("//*[@id=\"aexplain\"]")).click();
        Assert.assertTrue(driver.findElement(By.id("explain")).isDisplayed()); // show content after click
    }

    // [UI] Verify love calculator about content is displayed after click
    @Test
    public void testLoveCalculatorAboutContent() throws InterruptedException {
        navigateLoveCalculator();

        // Scroll down
        WebElement element = driver.findElement(By.id("acredits"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"credits\"]/div")).isDisplayed()); // not show content at beginning
        Assert.assertTrue(driver.findElement(By.id("acredits")).isEnabled());
        driver.findElement(By.id("acredits")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"credits\"]/div")).isDisplayed()); // show content after click
    }

    // [UI] Verify love calculator instruction is displayed after click
    @Test
    public void testLoveCalculatorInstruction() throws InterruptedException {
        navigateLoveCalculator();
        Assert.assertTrue(driver.findElement(By.id("ainstructions-tip")).isEnabled());
        driver.findElement(By.id("ainstructions-tip")).click();
        Assert.assertTrue(driver.findElement(By.id("instructions-tip")).isDisplayed()); // Show content after click
    }

    // [FT] Verify love calculator input value
    @Test
    public void testLoveCalculatorInputValue() throws InterruptedException {
        navigateLoveCalculator();
        String name1 = "duyen";
        String name2 = "nguyen";
        testAddName(driver, name1, "name1");
        testAddName(driver, name2, "name2");
        driver.quit();
    }


    // [FT] Verify love calculator result
    @Test
    public void testLoveCalculatorResult() throws InterruptedException {
        navigateLoveCalculator();
        String name1 = "duyen";
        String name2 = "nguyen";
        testAddName(driver, name1, "name1");
        testAddName(driver, name2, "name2");
        driver.findElement(By.className("mlfield_submit")).click();
        System.out.println("Result is " + driver.findElement(By.id("calc_calc")).getText());
        String result = "The chances of a successful relationship between " + name1 + " and " + name2 + " are ";
        System.out.println("String result: " + result);
        Assert.assertTrue(driver.findElement(By.id("calc_calc")).getText().contains(result));
    }
    public void testAddName(WebDriver driver, String name, String id) {
        Assert.assertTrue(driver.findElement(By.id(id)).isEnabled());
        driver.findElement(By.id(id)).sendKeys(name);
        Assert.assertEquals(driver.findElement(By.id(id)).getAttribute("value"), name);
    }

    // [FT] Verify love calculator clear button
    @Test
    public void testLoveCalculatorClearButton() throws InterruptedException {
        navigateLoveCalculator();
        String name1 = "duyen";
        String name2 = "nguyen";
        testAddName(driver, name1, "name1");
        testAddName(driver, name2, "name2");
        driver.findElement(By.name("clear")).click();
        testAddName(driver, "", "name1"); // name1 cleared ==> name=""
        testAddName(driver, "", "name2"); // name2 cleared ==> name=""
        driver.quit();
    }



    // [UI] Verify love calculator explanations content is displayed properly
    @Test
    public void testLoveCalculatorExplanationsContent() {
        navigateLoveCalculator();
        Assert.assertEquals(driver.findElement(By.id("explain")).getText(),""); // not show content at beginning

        // Scroll down
        WebElement element = driver.findElement(By.id("aexplain"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        System.out.println("Click");
        driver.findElement(By.xpath("//*[@id=\"aexplain\"]")).click();
        System.out.println("Explain: " + driver.findElement(By.id("explain")).getText());
        Assert.assertTrue(driver.findElement(By.id("explain")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"explain\"]/div/p/span/text()")).getText(),
                "Welcome to the Love Calculator. Knowing that names are not randomly chosen and they all have a meaning we created " +
                        "the Love Calculator to help you find out what the chances for you and your dream partner or crush are, " +
                        "just fill your name and your crushes name in the two text boxes, and press the Calculate Love. "); // show content after click
    }


    @Test
    public void testCalculator_com() throws InterruptedException {
        testCalculatorLink();
        testCalculatorTitle();
        testCalculatorPageSourceContains();
        testFractionsCalculatorNavigation();

        driver.quit();
    }

    @Test //(invocationCount = 1)
    public void switchTab() {
        ChromeDriverService service = ChromeDriverService.createDefaultService();
        WebDriver driver = new ChromeDriver(service);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((2)));
        driver.findElement(By.name("q")).sendKeys("calculator");
        driver.findElement(By.name("btnK")).click();
        String window1 = driver.getWindowHandle();
        System.out.println("Window 1 is " + window1);

        Set windowHandles = driver.getWindowHandles(); // Get all window handles
        System.out.println("Windows is " + windowHandles);
        Iterator<String> iterator = windowHandles.iterator();

        String window2 = null;
        while(iterator.hasNext()){
            String tmp = iterator.next();
            if(!window1.equalsIgnoreCase(tmp)){
                window2 = tmp;
                System.out.println("window2 is " + window2);
            }
        }
        driver.switchTo().window(window2);
    }


    @Test
    public void openNewTab() {
        driver.get("http://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");

        //Switch to new tab
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://www.yahoo.com/");
    }




}
