package com.airline.controllers;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class PassengerList
 */
@WebServlet( "/admin/PilotList" )
public class PilotList extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/PilotList.jsp";
    private static final long   serialVersionUID = 1L;

    @EJB
    PilotDao                    pilotDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PilotList() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        PilotService pilotService = new PilotService( pilotDao );

        List<Pilot> pilots = pilotService.getAllPilots();
        request.setAttribute( "pilots", pilots );
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
