package com.airline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.airline.dao.PlaneDao;
import com.airline.models.Plane;

public class PlaneService {

    private static final String CHAMP_PLANE_MODEL    = "model";
    private static final String CHAMP_PLANE_CAPACITY = "capacity";

    private String              resultat;
    private Map<String, String> erreurs              = new HashMap<String, String>();
    private PlaneDao            planeDao;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public PlaneService( PlaneDao planeDao ) {
        this.planeDao = planeDao;
    }

    public List<Plane> getAllPlanes() {
        List<Plane> planes = (List<Plane>) planeDao.getAllPlanes();
        return planes;
    }

    public Plane getPlaneById( String planeId ) {

        Plane plane = planeDao.getPlaneById( planeId );
        return plane;

    }

    public Plane createPlane( HttpServletRequest request ) {

        String model = request.getParameter( CHAMP_PLANE_MODEL );
        String capacity = request.getParameter( CHAMP_PLANE_CAPACITY );

        Plane plane = new Plane();

        try {
            validationModel( model );
        } catch ( Exception e ) {
            setErreur( CHAMP_PLANE_MODEL, e.getMessage() );
        }
        plane.setModel( model );

        try {
            validationCapacity( capacity );
        } catch ( Exception e ) {
            setErreur( CHAMP_PLANE_CAPACITY, e.getMessage() );
        }
        plane.setCapacity( capacity );

        if ( erreurs.isEmpty() ) {
            planeDao.createPlane( plane );
            resultat = "Creation succeded.";
        } else {
            resultat = "Creation failed";
        }

        return plane;
    }

    private void validationModel( String model ) throws Exception {
        if ( model != null ) {
            if ( model.length() < 2 ) {
                throw new Exception( "The model must contain more than three caracteres." );
            }
        } else {
            throw new Exception( "The model cannot be empty." );
        }
    }

    private void validationCapacity( String capacity ) throws Exception {
        try {
            Integer cap = Integer.parseInt( capacity );
            if ( cap != null ) {
                if ( cap < 100 ) {
                    throw new Exception( "The capacity must be greater than 100." );
                }
            } else {
                throw new Exception( "The capacity cannot be empty." );
            }
        } catch ( NumberFormatException e ) {
            throw new Exception( "The value is not a number" );
        }

    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

}
