package com.uwl.project.bookingsystem.helper;

import java.util.*;

public class SeatAllocator {
    private static final int ROWS = 30; // Assuming 30 rows for simplicity
    private static final int SEATS_PER_ROW = 6;
    private final Set<String> reservedSeats;
    private static final char[] SEAT_LABELS = {'A', 'B', 'C', 'D', 'E', 'F'};

    public SeatAllocator(Set<String> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public boolean bookSeats(int numSeats, boolean acceptFireExitResponsibility, int aircraftType) {
        if (numSeats < 1 || numSeats > 6) {
            throw new IllegalArgumentException("Number of seats to book must be between 1 and 6.");
        }

        for (int row = 1; row <= ROWS; row++) {
            for (int startSeat = 0; startSeat <= SEATS_PER_ROW - numSeats; startSeat++) {
                List<String> seatsToBook = new ArrayList<>();
                boolean validBooking = true;

                for (int offset = 0; offset < numSeats; offset++) {
                    String seat = row + "" + SEAT_LABELS[startSeat + offset];
                    if (reservedSeats.contains(seat) || (isFireExitSeat(row, SEAT_LABELS[startSeat + offset], aircraftType) && !acceptFireExitResponsibility)) {
                        validBooking = false;
                        break;
                    }
                    seatsToBook.add(seat);
                }

                if (validBooking && !createsSingleScatteredSeats(seatsToBook, row)) {
                    reservedSeats.addAll(seatsToBook);
                    return true;
                }
            }
        }

        return false; // No suitable seats found
    }

    private boolean isFireExitSeat(int row, char seatLabel, int aircraftType) {
        if (aircraftType == 1 && row == 10) {
            return seatLabel == 'A' || seatLabel == 'F';
        } else if (aircraftType == 2 && row == 16) {
            return seatLabel == 'A' || seatLabel == 'F';
        }
        return false;
    }

    private boolean createsSingleScatteredSeats(List<String> seatsToBook, int row) {
        // Check the seat before the first in the booking
        if (seatsToBook.get(0).charAt(1) != 'A') {
            char prevSeatLabel = (char) (seatsToBook.get(0).charAt(1) - 1);
            String prevSeat = row + "" + prevSeatLabel;
            if (!reservedSeats.contains(prevSeat) && !seatsToBook.contains(prevSeat)) {
                return true;
            }
        }

        // Check the seat after the last in the booking
        if (seatsToBook.get(seatsToBook.size() - 1).charAt(1) != 'F') {
            char nextSeatLabel = (char) (seatsToBook.get(seatsToBook.size() - 1).charAt(1) + 1);
            String nextSeat = row + "" + nextSeatLabel;
            if (!reservedSeats.contains(nextSeat) && !seatsToBook.contains(nextSeat)) {
                return true;
            }
        }

        return false;
    }
}