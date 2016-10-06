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
import com.airline.dao.PilotDao;
import com.airline.dao.PlaneDao;
import com.airline.models.Flight;
import com.airline.service.FlightService;

/**
 * Servlet implementation class FlightList
 */
@WebServlet( "/admin/FlightList" )
public class FlightList extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/FlightList.jsp";
    private static final long   serialVersionUID = 1L;

    @EJB
    FlightDao                   flightDao;
    @EJB
    PlaneDao                    planeDao;
    @EJB
    PilotDao                    pilotDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightList() {
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

        List<Flight> flights = flightService.getAllFlights();
        request.setAttribute( "flights", flights );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
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
