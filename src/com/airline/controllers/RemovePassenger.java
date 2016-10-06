package com.airline.controllers;

import java.io.IOException;

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
import com.airline.models.Passenger;
import com.airline.service.PassengerService;

/**
 * Servlet implementation class RemoveFlight
 */
@WebServlet( "/admin/RemovePassenger" )
public class RemovePassenger extends HttpServlet {
    private static final String CHAMP_ID_PASSENGER = "idPassenger";
    public static final String  VUE_REDIRECT       = "/admin/PassengerList";
    private static final long   serialVersionUID   = 1L;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    @EJB
    PassengerDao                passengerDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        PassengerService passengerService = new PassengerService( passengerDao, flightDao, pilotDao, planeDao );
        String idPassenger = request.getParameter( CHAMP_ID_PASSENGER );
        Passenger passenger = passengerService.getPassengerById( idPassenger );
        passengerService.removePassenger( passenger );
        response.sendRedirect( request.getContextPath() + VUE_REDIRECT );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
    }

}
