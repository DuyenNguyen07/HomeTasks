package com.DuyenNguyen.experimenting.booking.testCases;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.booking.pages.BookingHomePage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ParisBookingTest extends BookingSeleniumBaseTest {
    private String checkinDate = "13 February 2022";
    private String checkoutDate = "15 February 2022";
    private int personNumber = 2;

    @Test
    public void testParisBooking() throws InterruptedException {
        String destination = "Paris";
        log.info("Test booking to " + destination + " from " + checkinDate + " to " + checkoutDate + " for " + personNumber + " adult(s)");
        String destinationOnParisPage = new BookingHomePage()
                .chooseEnglish()
                .setDestination(destination)
                .chooseArrivalDates(checkinDate, checkoutDate)
                .setPersonNumber(personNumber)
                .clickSearchButton()
                .getDestinationPropertyName();
        assertEquals(destination, destinationOnParisPage);
        log.info("Finish testing");
    }
}
