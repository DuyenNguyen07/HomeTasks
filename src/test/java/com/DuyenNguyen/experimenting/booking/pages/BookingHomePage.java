package com.DuyenNguyen.experimenting.booking.pages;

import com.DuyenNguyen.experimenting.core.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingHomePage extends CommonPage {

    By languageButton = By.xpath("//img[@class='bui-avatar__image']");
    By englishButton = By.xpath("//a[@data-lang='en-gb']");

    By destinationInputField = By.id("ss");

    By checkInOut = By.xpath("//div[@class='xp__dates-inner']");
    By checkIn = By.xpath("//div[@class='xp__dates-inner xp__dates__checkin']");
    By checkOut = By.xpath("//div[@class='xp__dates-inner xp__dates__checkout']");
    By calendarMonth = By.xpath("//div[contains(@class, 'bui-calendar__month')]");
    By nextMonthButton = By.xpath("//div[@data-bui-ref='calendar-next']");

    By personNumber = By.xpath("//input[@id='group_adults']");
    By guestsCountField = By.xpath("//span[@class='xp__guests__count']");
    By decreasePersonNumber = By.xpath("//button[@aria-label='Decrease number of Adults']");
    By increasePersonNumber = By.xpath("//button[@aria-label='Increase number of Adults']");

    By searchButton = By.xpath("//button[@data-sb-id='main']");

    public BookingHomePage chooseEnglish() {
        WebElement languageButtonElement = search_element_by_By(languageButton);
        languageButtonElement.click();

        WebElement englishButtonElement = search_element_by_By(englishButton);
        englishButtonElement.click();
        return this;
    }

    public BookingHomePage setDestination(String text) {
        WebElement destinationInputFieldElement = search_element_by_By(destinationInputField);
        destinationInputFieldElement.sendKeys(text);
        return this;
    }


    public BookingHomePage chooseArrivalDates(String checkinDate, String checkoutDate) throws InterruptedException {
        WebElement checkInOutElement = search_element_by_By(checkInOut);
        checkInOutElement.click();
        Thread.sleep(1000);

        //// TODO: 11/9/2021 check calendar month and logic to choose dates
        WebElement calendarMonthElement = search_element_by_By(calendarMonth);
        String currentMonth = calendarMonthElement.getText();
        System.out.println("currentMonth " + currentMonth);

        WebElement nextMonthButtonElement = search_element_by_By(nextMonthButton);

        while (!currentMonth.contains("February")){
            nextMonthButtonElement.click();
            System.out.println("Click");
            WebElement newNextMonthButtonElement = search_element_by_By(calendarMonth);
            currentMonth = newNextMonthButtonElement.getText();
            System.out.println("currentMonth " + currentMonth);
        }

        // Set check in date
        By checkInDate = By.xpath("//span[@aria-label='" + checkinDate + "']");
        WebElement checkInDateElement = search_element_by_By(checkInDate);
        checkInDateElement.click();

        // Set check out date
        By checkOutDate = By.xpath("//span[@aria-label='" + checkoutDate + "']");
        WebElement checkOutDateElement = search_element_by_By(checkOutDate);
        checkOutDateElement.click();

        return this;
    }

    public BookingHomePage setPersonNumber(int personNumber) {
        WebElement guestsCountFieldElement = search_element_by_By(guestsCountField);
        guestsCountFieldElement.click();

        WebElement personNumberElement = search_element_by_By(this.personNumber);
        int currentPersonNumber = Integer.parseInt(personNumberElement.getAttribute("value"));

        WebElement increasePersonNumberElement = search_element_by_By(increasePersonNumber);
        WebElement decreasePersonNumberElement = search_element_by_By(decreasePersonNumber);
        if (currentPersonNumber == personNumber) {
            return this;
        } else if (currentPersonNumber < personNumber) {
            int delta = personNumber - currentPersonNumber;
            for (int i = 0; i < delta; i++) {
                System.out.println("Click increase " + i);
                increasePersonNumberElement.click();
            }
        } else {
            int delta = currentPersonNumber - personNumber;
            for (int i = 0; i < delta; i++) {
                System.out.println("Click decrease " + i);
                decreasePersonNumberElement.click();
            }
        }
        return this;
    }

    public ParisPage clickSearchButton() {
        WebElement searchButtonElement = search_element_by_By(searchButton);
        searchButtonElement.click();
        return new ParisPage();
    }
}

