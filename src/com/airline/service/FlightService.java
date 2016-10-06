package com.airline.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.airline.dao.FlightDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Cities;
import com.airline.models.Flight;
import com.airline.models.Pilot;
import com.airline.models.Plane;

public class FlightService {

    private static final String CHAMP_FLIGHT_ORIGIN      = "depart";
    private static final String CHAMP_FLIGHT_DESTINATION = "destination";
    private static final String CHAMP_FLIGHT_YEAR        = "year";
    private static final String CHAMP_FLIGHT_MONTH       = "month";
    private static final String CHAMP_FLIGHT_DAY         = "day";
    private static final String CHAMP_FLIGHT_PILOT       = "pilot";
    private static final String CHAMP_FLIGHT_PLANE       = "plane";
    private static final String CHAMP_FLIGHT_PRICE       = "prix";

    private String              resultat;
    private Map<String, String> erreurs                  = new HashMap<String, String>();
    private FlightDao           flightDao;
    private PlaneDao            planeDao;
    private PilotDao            pilotDao;

    public FlightService() {

    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public FlightService( FlightDao flightDao, PlaneDao planeDao, PilotDao pilotDao ) {
        this.flightDao = flightDao;
        this.pilotDao = pilotDao;
        this.planeDao = planeDao;
    }

    public Flight createFlight( HttpServletRequest request ) {
        PlaneService planeService = new PlaneService( planeDao );
        PilotService pilotService = new PilotService( pilotDao );

        String depart = request.getParameter( CHAMP_FLIGHT_ORIGIN );
        String destination = request.getParameter( CHAMP_FLIGHT_DESTINATION );

        Integer year = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_YEAR ) );
        Integer month = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_MONTH ) );
        Integer day = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_DAY ) );
        Integer hour = Integer.parseInt( request.getParameter( "hour" ) );
        Integer minute = Integer.parseInt( request.getParameter( "minute" ) );
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.YEAR, year );
        cal.set( Calendar.MONTH, month - 1 );
        cal.set( Calendar.DAY_OF_MONTH, day );
        cal.set( Calendar.HOUR_OF_DAY, hour );
        cal.set( Calendar.MINUTE, minute );
        Date date = cal.getTime();

        String planeId = request.getParameter( CHAMP_FLIGHT_PLANE );
        Plane plane = planeService.getPlaneById( planeId );

        String pilotId = request.getParameter( CHAMP_FLIGHT_PILOT );
        Pilot pilot = pilotService.getPilotById( pilotId );

        String price = request.getParameter( CHAMP_FLIGHT_PRICE );

        Flight flight = new Flight();

        try {
            validationAirplane( plane );
        } catch ( Exception e ) {
            setErreur( CHAMP_FLIGHT_PLANE, e.getMessage() );
        }
        flight.setAirplane( plane );
        try {
            validationPilot( pilot );
        } catch ( Exception e ) {
            setErreur( CHAMP_FLIGHT_PILOT, e.getMessage() );
        }
        flight.setPilot( pilot );
        try {
            validationPrice( price );
        } catch ( Exception e ) {
            setErreur( CHAMP_FLIGHT_PRICE, e.getMessage() );
        }
        flight.setPrix( price );

        flight.setDate( date );
        flight.setDepart( Cities.valueOf( depart ) );
        flight.setDestination( Cities.valueOf( destination ) );

        if ( erreurs.isEmpty() ) {
            flightDao.createFlight( flight );
            resultat = "Creation succeded.";
        } else {
            resultat = "Creation failed";
        }

        return flight;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = (List<Flight>) flightDao.getAllFlights();
        return flights;
    }

    public Flight getFlightById( String flightId ) {
        Flight flight = flightDao.getFlightById( flightId );
        return flight;
    }

    public void removeFlight( Flight flight ) {
        flightDao.removeFlight( flight );

    }

    public List<Flight> searchFlights( HttpServletRequest request ) {
        String dep = request.getParameter( CHAMP_FLIGHT_ORIGIN );
        String dest = request.getParameter( CHAMP_FLIGHT_DESTINATION );

        Cities depart = Cities.valueOf( dep );
        Cities destination = Cities.valueOf( dest );

        int year = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_YEAR ) );
        int month = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_MONTH ) );
        int day = Integer.parseInt( request.getParameter( CHAMP_FLIGHT_DAY ) );

        List<Flight> flights = getAllFlights();

        List<Flight> flightsToRemove = new ArrayList<Flight>();

        for ( int i = 0; i < flights.size(); i++ ) {

            Flight flight = flights.get( i );

            Date date = flight.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime( date );

            int flightDay = cal.get( Calendar.DAY_OF_MONTH );
            int flightMonth = cal.get( Calendar.MONTH ) + 1;
            int flightYear = cal.get( Calendar.YEAR );

            Cities departFlight = flight.getDepart();
            Cities destinationFlight = flight.getDestination();

            if ( departFlight != depart || destinationFlight != destination || flightDay != day || flightMonth != month
                    || flightYear != year ) {

                flightsToRemove.add( flight );

            }

        }

        for ( int j = 0; j < flightsToRemove.size(); j++ ) {
            Flight f = flightsToRemove.get( j );
            flights.remove( f );
        }

        if ( flights.isEmpty() ) {
            return null;
        }

        return flights;

    }

    /*
     * Methodes Utilitaires
     */

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    private void validationAirplane( Plane plane ) throws Exception {
        if ( plane == null ) {
            throw new Exception( "The Airplane cannot be empty." );
        }
    }

    private void validationPilot( Pilot pilot ) throws Exception {
        if ( pilot == null ) {
            throw new Exception( "The pilot cannot be empty." );
        }
    }

    private void validationPrice( String price ) throws Exception {
        try {
            Integer prix = Integer.parseInt( price );
            if ( prix != null ) {
                if ( prix < 40 ) {
                    throw new Exception( "The price must be greater than 40." );
                }
            } else {
                throw new Exception( "The price cannot be empty." );
            }
        } catch ( NumberFormatException e ) {
            throw new Exception( "The value is not a number" );
        }
    }

}
