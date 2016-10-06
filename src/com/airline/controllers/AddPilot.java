package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.PilotDao;
import com.airline.models.Pilot;
import com.airline.service.PilotService;

/**
 * Servlet implementation class AddPilot
 */
@WebServlet( "/admin/AddPilot" )
public class AddPilot extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/AddPilot.jsp";
    private static final String VUE_REDIRECT     = "/jaxrs/admin/PilotList";
    private static final long   serialVersionUID = 1L;

    @EJB
    PilotDao                    pilotDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPilot() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        PilotService pilotService = new PilotService( pilotDao );

        Pilot pilot = pilotService.createPilot( request );

        request.setAttribute( "pilot", pilot );
        request.setAttribute( "pilotService", pilotService );

        if ( pilotService.getErreurs().isEmpty() ) {
            response.sendRedirect( VUE_REDIRECT );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }

}
