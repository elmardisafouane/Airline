package com.airline.service;

import javax.servlet.http.HttpServletRequest;

public interface FlightPassengerService {

    void AddPassengerToFlight( HttpServletRequest request );

    void removeTicket( HttpServletRequest request );

    void removeTicketPassenger( HttpServletRequest request );

}
