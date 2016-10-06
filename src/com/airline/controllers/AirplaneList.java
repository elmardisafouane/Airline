package com.airline.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.dao.PlaneDao;
import com.airline.models.Plane;
import com.airline.service.PlaneService;

/**
 * Servlet implementation class PassengerList
 */
@WebServlet( "/admin/AirplaneList" )
public class AirplaneList extends HttpServlet {
    private static final String VUE              = "/WEB-INF/views/AirplaneList.jsp";
    private static final long   serialVersionUID = 1L;

    @EJB
    PlaneDao                    planeDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirplaneList() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
            IOException {
        PlaneService planeService = new PlaneService( planeDao );
        List<Plane> planes = planeService.getAllPlanes();
        request.setAttribute( "planes", planes );
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
