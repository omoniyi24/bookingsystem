package com.uwl.project.bookingsystem.helper;

public class SeatAllocator {
    private final boolean[][] seats; // True if seat is occupied, false if available
    private final int rows;
    private final int cols;

    // Constructor to initialize the seating chart
    public SeatAllocator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.seats = new boolean[rows][cols];
    }

    // Method to allocate seats
    public boolean allocateSeats(int numSeats, boolean acceptFireExitResponsibility, int aircraftType) {
        int[] fireExitRows = getFireExitRows(aircraftType);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= cols - numSeats; col++) {
                if (canAllocate(row, col, numSeats, fireExitRows, acceptFireExitResponsibility)) {
                    markSeatsAsOccupied(row, col, numSeats);
                    return true; // Return true if seats have been successfully allocated
                }
            }
        }
        return false; // Return false if no suitable seats were found
    }

    // Check if seats can be allocated without causing isolation
    private boolean canAllocate(int row, int col, int numSeats, int[] fireExitRows, boolean acceptFireExitResponsibility) {
        // Check for proximity to fire exit rows
        if (contains(fireExitRows, row) && !acceptFireExitResponsibility) {
            return false;
        }

        // Check if adjacent seats would be isolated
        if ((col > 0 && seats[row][col - 1] == false) || (col + numSeats < cols && seats[row][col + numSeats] == false)) {
            return false;
        }

        // Check if the block of seats is available
        for (int i = 0; i < numSeats; i++) {
            if (seats[row][col + i]) { // If any seat in the range is occupied
                return false;
            }
        }
        return true;
    }

    // Mark seats as occupied
    public void markSeatsAsOccupied(int row, int col, int numSeats) {
        for (int i = 0; i < numSeats; i++) {
            seats[row][col + i] = true;
        }
    }

    // Utility method to determine if a row is a fire exit row
    private boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // Get fire exit rows based on aircraft type
    private int[] getFireExitRows(int aircraftType) {
        if (aircraftType == 1) {
            return new int[]{10}; // Aircraft 1 fire exit rows
        } else if (aircraftType == 2) {
            return new int[]{16}; // Aircraft 2 fire exit rows
        }
        return new int[]{}; // No fire exit rows if type not recognized
    }
}