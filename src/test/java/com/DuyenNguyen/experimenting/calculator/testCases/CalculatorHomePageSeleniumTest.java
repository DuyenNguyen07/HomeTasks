package com.DuyenNguyen.experimenting.calculator.testCases;

import com.DuyenNguyen.experimenting.calculator.pages.CalculatorHomePage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class CalculatorHomePageSeleniumTest extends CalculatorSeleniumBaseTest {

    @Test
    public void testTitle() {
        log.info("----------------- Start testing title ------------------");
        String title =
                new CalculatorHomePage()
                        .getTitle();
        assertTrue(title.contains("calculator"));
        log.info("--------------- Finish testing title -------------------");
    }

    @Test
    public void testLink() {
        log.info("----------------- Start testing link ------------------");
        String currentURL = new CalculatorHomePage()
                .getLink();
        System.out.println(currentURL);
        assertTrue(currentURL.matches("https://www.calculator.com/"));
        log.info("--------------- Finish testing link -------------------");
    }


}

