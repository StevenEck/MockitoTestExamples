package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class Test02DefaultRetunValues {

    private BookingService bookingService;

    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;


    @BeforeEach
    void setup() {
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

        System.out.println("List Returned: " + roomServiceMock.getAvailableRooms());
        System.out.println("Object returned: " + roomServiceMock.findAvailableRoomId(null));
        System.out.println("Primitive returned Room count: " + roomServiceMock.getRoomCount());
    }

    @Test
    void testShouldCountAvailablePlaces(){
        //given
        int expected = 0;

        //when
        int actual = bookingService.getAvailablePlaceCount();

        //then
        assertEquals(expected, actual);

    }

}
