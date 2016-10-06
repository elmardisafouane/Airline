package com.airline.dao;

import java.util.List;

import com.airline.models.Passenger;

public interface PassengerDao {

    Passenger createPassenger( Passenger passenger );

    Passenger getPassengerById( String passengerId );

    List<Passenger> getAllPassengers();

    void removePassenger( Passenger passenger );

    void updatePassenger( Passenger passenger );

}
