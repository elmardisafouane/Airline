package com.airline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.airline.dao.FlightDao;
import com.airline.dao.PassengerDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Flight;
import com.airline.models.FlightClass;
import com.airline.models.Passenger;

public class PassengerService {

    private static final String CHAMP_FIRST_NAME   = "firstName";
    private static final String CHAMP_LAST_NAME    = "lastName";
    private static final String CHAMP_ADDRESS      = "address";
    private static final String CHAMP_TELEPHONE    = "telephone";
    private static final String CHAMP_EMAIL        = "email";
    private static final String CHAMP_FLIGHT_CLASS = "flightClass";

    private static final String CHAMP_FLIGHT_ID    = "flightId";
    private static final String CHAMP_PASSENGER_ID = "passengerId";

    private String              resultat;
    private Map<String, String> erreurs            = new HashMap<String, String>();
    private PassengerDao        passengerDao;
    private FlightDao           flightDao;
    private PilotDao            pilotDao;
    private PlaneDao            planeDao;

    public PassengerService() {

    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public PassengerService( PassengerDao passengerDao, FlightDao flightDao, PilotDao pilotDao, PlaneDao planeDao ) {
        this.passengerDao = passengerDao;
        this.flightDao = flightDao;
        this.pilotDao = pilotDao;
        this.planeDao = planeDao;
    }

    public Passenger createPassenger( HttpServletRequest request ) {

        String firstName = request.getParameter( CHAMP_FIRST_NAME );
        String lastName = request.getParameter( CHAMP_LAST_NAME );
        String address = request.getParameter( CHAMP_ADDRESS );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );
        String flightClasss = request.getParameter( CHAMP_FLIGHT_CLASS );

        Passenger passenger = new Passenger();

        try {
            validationAdresse( address );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADDRESS, e.getMessage() );
        }
        passenger.setAdresse( address );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        passenger.setEmail( email );

        try {
            validationPrenom( firstName );
        } catch ( Exception e ) {
            setErreur( CHAMP_FIRST_NAME, e.getMessage() );
        }
        passenger.setPrenom( firstName );

        try {
            validationNom( lastName );
        } catch ( Exception e ) {
            setErreur( CHAMP_LAST_NAME, e.getMessage() );
        }
        passenger.setNom( lastName );

        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( CHAMP_TELEPHONE, e.getMessage() );
        }
        passenger.setTelephone( telephone );

        passenger.setFlightClass( FlightClass.valueOf( flightClasss ) );

        List<Flight> flights = null;
        passenger.setFlights( flights );

        if ( erreurs.isEmpty() ) {
            passengerDao.createPassenger( passenger );
            resultat = "Creation succeded.";
        } else {
            resultat = "Creation failed";
        }

        return passenger;

    }

    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = passengerDao.getAllPassengers();
        return passengers;
    }

    public void AddPassengerToFlight( HttpServletRequest request ) {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );

        String passengerId = request.getParameter( CHAMP_PASSENGER_ID );
        String flightId = request.getParameter( CHAMP_FLIGHT_ID );

        Passenger passenger = getPassengerById( passengerId );
        Flight flight = flightService.getFlightById( flightId );

        List<Passenger> pList = flight.getPassengers();
        pList.add( passenger );
        flight.setPassengers( pList );

        List<Flight> fList = passenger.getFlights();
        fList.add( flight );
        passenger.setFlights( fList );

    }

    public Passenger getPassengerById( String passengerId ) {
        Passenger passenger = passengerDao.getPassengerById( passengerId );
        return passenger;
    }

    public void removePassenger( Passenger passenger ) {
        passengerDao.removePassenger( passenger );

    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "The last name must contain more than three caracteres." );
            }
        } else {
            throw new Exception( "The last name cannot be empty." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "The first name must contain more than three caracteres." );
        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new Exception( "The address must contain more than ten caracteres." );
            }
        } else {
            throw new Exception( "The address cannot be empty." );
        }
    }

    private void validationTelephone( String telephone ) throws Exception {
        if ( telephone != null ) {
            if ( telephone.length() != 10 ) {
                throw new Exception( "The phone number must contain ten caracteres formatted as follow : 06XXXXXXXX." );
            }
        } else {
            throw new Exception( "The phone number cannot be empty." );
        }
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "The Email is invalid" );
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

}
