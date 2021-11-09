package com.DuyenNguyen.experimenting.booking.testCases;

import com.DuyenNguyen.experimenting.BaseTest;
import com.DuyenNguyen.experimenting.booking.pages.BookingHomePage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ParisBookingTest extends BookingSeleniumBaseTest {
    @Test
    public void testParisBooking() throws InterruptedException {
        String destination = "Paris";
        String checkinDate = "13 February 2022";
        String checkoutDate = "15 February 2022";

        String destinationOnParisPage = new BookingHomePage()
                .chooseEnglish()
                .setDestination(destination)
                .chooseArrivalDates(checkinDate, checkoutDate)
                .setPersonNumber(2)
                .clickSearchButton()
                .getDestinationPropertyName();
        assertEquals(destination, destinationOnParisPage);
    }
}
