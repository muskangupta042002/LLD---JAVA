package com.muskan.scenarios;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class Case1 extends BaseTest{

    @BeforeEach
    void setUp(){
        setupControllers(10,0);
    }

    @Test
    void testCase1(){
        String user1 = "User1";
        String user2 = "User2";

        final String movie = movieController.createMovie("DeadPool!!!");
        final String screen = setupScreen();
        final List<String> screen1SeatIds = createSeats(theatreController, screen, 2, 10);

        final String show = showController.createShow(movie, screen, new Date(), 2*60*60);
        List<String> u1AvailableSeats = showController.getAvailableSeats(show);

        validatedSeatsList(u1AvailableSeats, screen1SeatIds, ImmutableList.of());

        ImmutableList<String> u1SelectedSeats = ImmutableList.of(screen1SeatIds.get(0),
                screen1SeatIds.get(2),
                screen1SeatIds.get(5),
                screen1SeatIds.get(10));

        final String bookingId = bookingController.createBooking(user1, show, u1SelectedSeats);
        paymentsController.paymentSuccess(bookingId, user1);

        final List<String> u2AvailableSeats = showController.getAvailableSeats(show);
        validatedSeatsList(u2AvailableSeats, screen1SeatIds, u1AvailableSeats);
    }
}
