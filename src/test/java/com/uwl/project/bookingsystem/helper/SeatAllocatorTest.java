package com.uwl.project.bookingsystem.helper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SeatAllocatorTest {
    private SeatAllocator allocator;

    @Before
    public void setUp() {
        // Assuming aircraft type 1, with 20 rows and 6 columns
        allocator = new SeatAllocator(20, 6);
    }

    @Test
//  Checks if the allocator can successfully allocate seats when there are no constraints violated.
    public void testAllocateSeats_successfullyAllocates() {
        // Test successful allocation
        assertTrue("Seats should be allocated", allocator.allocateSeats(6, true, 1));
    }

    @Test
//  Ensures that the allocator does not allocate seats in the fire exit row to a user who does not accept responsibility.
    public void testAllocateSeats_failsDueToFireExitRestrictions() {
        // Allocate near fire exit without accepting responsibility
        assertFalse("Seats should not be allocated due to fire exit restrictions", allocator.allocateSeats(3, false, 1));
    }

    @Test
//  Verifies that the allocator does not allocate a seat that would isolate another unoccupied seat.
    public void testAllocateSeats_preventsIsolation() {
        // Manually mark some seats as occupied
        allocator.markSeatsAsOccupied(0, 0, 1); // Occupy 0A
        allocator.markSeatsAsOccupied(0, 3, 3); // Occupy 0D, 0E, 0F

        // Attempt to allocate seats that would isolate 0B
        assertFalse("Seats should not be allocated to prevent isolation", allocator.allocateSeats(1, true, 1));
    }

    @Test
//  Tests that seats can be allocated in fire exit rows if the user accepts the associated responsibilities.
    public void testAllocateSeats_acceptsFireExitResponsibility() {
        // Allocate near fire exit with accepting responsibility
        assertTrue("Seats should be allocated when accepting fire exit responsibility", allocator.allocateSeats(6, true, 1));
    }

    @Test
//  Confirms that the seat allocator does not allocate seats that would inadvertently span across multiple rows, which is not logically possible in a real seating scenario.
    public void testAllocateSeats_acrossMultipleRows() {
        // Tests to ensure the allocator does not falsely allocate across rows
        allocator.markSeatsAsOccupied(1, 4, 2); // Occupy 1E and 1F
        assertFalse("Seats should not span across rows", allocator.allocateSeats(3, true, 1));
    }

    @Test
//  Tests the allocator's response when no seats are available in the designated area.
    public void testNoAvailableSeats_returnsFalse() {
        // Fill all seats in a row
        allocator.markSeatsAsOccupied(2, 0, 6);

        // Try to allocate in a fully occupied row
        assertFalse("Allocation should fail for fully occupied row", allocator.allocateSeats(1, true, 1));
    }
}
