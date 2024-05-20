package com.uwl.project.bookingsystem.dto;

import java.time.Instant;

public class FlightDTO {

    private Long id;
    private String airline;
    private String origin;
    private String destination;
    private Instant departureTime;
    private Instant arrivalTime;
    private Integer aircraftType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Instant getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(Integer aircraftType) {
        this.aircraftType = aircraftType;
    }
}
