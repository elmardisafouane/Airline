package com.airline.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.FlightDao;
import com.airline.dao.PassengerDao;
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Flight;
import com.airline.models.Passenger;
import com.airline.service.FlightPassengerService;
import com.airline.service.FlightService;
import com.airline.service.PassengerService;

/**
 * Servlet implementation class AddPassengerToFlight
 */
@WebServlet( "/admin/AddPassengerToFlight" )
public class AddPassengerToFlight extends HttpServlet {

    private static final String VUE              = "/WEB-INF/views/AddPassengerToFlight.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/PassengerList";

    private static final long   serialVersionUID = 1L;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    @EJB
    PassengerDao                passengerDao;

    @EJB
    FlightPassengerService      flightPassengerService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassengerToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );

        List<Flight> flights = flightService.getAllFlights();
        List<Passenger> passengers = passengerService.getAllPassengers();
        request.setAttribute( "flights", flights );
        request.setAttribute( "passengers", passengers );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        try {
            flightPassengerService.AddPassengerToFlight( request );
        } catch ( javax.ejb.EJBException e ) {

            FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
            PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );

            List<Flight> flights = flightService.getAllFlights();
            List<Passenger> passengers = passengerService.getAllPassengers();
            String erreur = "This Passenger is already in this Flight !";
            request.setAttribute( "flights", flights );
            request.setAttribute( "passengers", passengers );
            request.setAttribute( "erreur", erreur );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }

        response.sendRedirect( VUE_REDIRECT );

    }
}
