package com.uwl.project.bookingsystem.helper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SeatAllocatorTest {
    private static Set<String> reservedSeats;

    @Before
    public void setUp() {
        reservedSeats = new HashSet<>();
        reservedSeats.add("3A");
        reservedSeats.add("3B");
        reservedSeats.add("3C");
    }

    @Test
    public void testBookSeats_SuccessfulBooking() {
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(3, true, 1);
        assertTrue("Booking should be successful", success);
        assertEquals(6, reservedSeats.size());
    }

    @Test
    public void testBookSeats_MaxSeatsLimit() {
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(6, true, 1);
        assertTrue("Booking should be successful for 6 seats", success);
        assertEquals(9, reservedSeats.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBookSeats_ExceedMaxSeatsLimit() {
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        reservationSystem.bookSeats(7, true, 1);
    }

    @Test
    public void testBookSeats_FireExitResponsibility() {
        reservedSeats = new HashSet<>();
        reservedSeats.add("10A");
        reservedSeats.add("10F");
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(2, false, 1);
        assertFalse("Booking should fail for non-acceptance of fire exit responsibility", success);
    }

    @Test
    public void testBookSeats_FireExitResponsibility_Accepted() {
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(3, true, 1);
        assertTrue("Booking should succeed with acceptance of fire exit responsibility", success);
        assertEquals(6, reservedSeats.size());
    }

    @Test
    public void testBookSeats_AvoidSingleScatteredSeats() {
        reservedSeats = new HashSet<>();
        reservedSeats.add("3A");
        reservedSeats.add("5C");
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(2, true, 1);
        assertTrue("Booking should fail if it causes single scattered seats", success);
    }

    @Test
    public void testBookSeats_ValidScatteredSeats() {
        reservedSeats.add("5A");
        reservedSeats.add("5B");
        reservedSeats.add("5D");
        reservedSeats.add("5E");
        SeatAllocator reservationSystem = new SeatAllocator(reservedSeats);
        boolean success = reservationSystem.bookSeats(1, true, 1);
        assertTrue("Booking should succeed if no single scattered seats are created", success);
    }
}
