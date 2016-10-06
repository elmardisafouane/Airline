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
import com.airline.models.Pilot;
import com.airline.models.Plane;
import com.airline.service.FlightService;
import com.airline.service.PilotService;
import com.airline.service.PlaneService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet( "/admin/AddFlight" )
public class AddFlight extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/AddFlight.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/FlightList";
    private static final long   serialVersionUID = 1L;

    @EJB
    FlightDao                   flightDao;

    @EJB
    PilotDao                    pilotDao;

    @EJB
    PlaneDao                    planeDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
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
        PilotService pilotService = new PilotService( pilotDao );
        PlaneService planeService = new PlaneService( planeDao );

        List<Pilot> pilots = pilotService.getAllPilots();
        List<Plane> planes = planeService.getAllPlanes();
        request.setAttribute( "pilots", pilots );
        request.setAttribute( "planes", planes );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        FlightService flightService = new FlightService( flightDao, planeDao, pilotDao );
        Flight flight = flightService.createFlight( request );

        request.setAttribute( "flight", flight );
        request.setAttribute( "flightService", flightService );

        if ( flightService.getErreurs().isEmpty() ) {
            response.sendRedirect( VUE_REDIRECT );
        } else {
            PilotService pilotService = new PilotService( pilotDao );
            PlaneService planeService = new PlaneService( planeDao );

            List<Pilot> pilots = pilotService.getAllPilots();
            List<Plane> planes = planeService.getAllPlanes();
            request.setAttribute( "pilots", pilots );
            request.setAttribute( "planes", planes );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }

}
