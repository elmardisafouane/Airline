package com.airline.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.airline.dao.FlightDao;
import com.airline.dao.PassengerDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Flight;
import com.airline.models.Passenger;

/**
 * Session Bean implementation class FlightPassengerServiceImpl
 */
@Stateless
public class FlightPassengerServiceImpl implements FlightPassengerService {

    private static final String CHAMP_FLIGHT_ID    = "flightId";
    private static final String CHAMP_PASSENGER_ID = "passengerId";
    private static final String CHAMP_ID_PASSENGER = "idPassenger";
    private static final String CHAMP_ID_FLIGHT    = "idFlight";
    private static final String CHAMP_Id_Flight    = "Id_Flight";
    private static final String CHAMP_Id_Passenger = "Id_Passenger";

    @EJB
    PassengerDao                passengerDao;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    /**
     * Default constructor.
     */
    public FlightPassengerServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void AddPassengerToFlight( HttpServletRequest request ) {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );
        String passengerId = request.getParameter( CHAMP_PASSENGER_ID );
        String flightId = request.getParameter( CHAMP_FLIGHT_ID );

        Passenger passenger = passengerService.getPassengerById( passengerId );
        Flight flight = flightService.getFlightById( flightId );

        List<Passenger> pList = flight.getPassengers();
        pList.add( passenger );
        flight.setPassengers( pList );

        List<Flight> fList = passenger.getFlights();
        fList.add( flight );
        passenger.setFlights( fList );

    }

    @Override
    public void removeTicket( HttpServletRequest request ) {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );

        String idFlight = request.getParameter( CHAMP_ID_FLIGHT );

        Flight flight = flightService.getFlightById( idFlight );
        List<Passenger> passengers = flight.getPassengers();

        String idPassenger = request.getParameter( CHAMP_ID_PASSENGER );
        Passenger passenger = passengerService.getPassengerById( idPassenger );

        passengers.remove( passenger );
        flight.setPassengers( passengers );

    }

    @Override
    public void removeTicketPassenger( HttpServletRequest request ) {

        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );

        String idFlight = request.getParameter( CHAMP_Id_Flight );
        String idPassenger = request.getParameter( CHAMP_Id_Passenger );

        Flight flight = flightService.getFlightById( idFlight );
        Passenger passenger = passengerService.getPassengerById( idPassenger );

        List<Flight> flights = passenger.getFlights();

        flights.remove( flight );
        passenger.setFlights( flights );

    }

}
