package com.airline.dao;

import java.util.List;

import com.airline.models.Flight;

public interface FlightDao {

    void createFlight( Flight f );

    Flight getFlightById( String flightId );

    List<Flight> getAllFlights();

    void removeFlight( Flight flight );

    void updateFlight( Flight flight );

}
