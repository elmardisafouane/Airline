package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.FlightPassengerService;

/**
 * Servlet implementation class RemoveFlight
 */
@WebServlet( "/admin/RemoveTicket" )
public class RemoveTicket extends HttpServlet {
    public static final String VUE_REDIRECT     = "/admin/FlightList";
    private static final long  serialVersionUID = 1L;

    @EJB
    FlightPassengerService     flightPassengerService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        flightPassengerService.removeTicket( request );
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
