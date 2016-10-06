package com.airline.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.airline.dao.PilotDao;
import com.airline.models.Pilot;
import com.airline.models.PilotRank;

public class PilotService {

    private static final String CHAMP_FIRST_NAME = "firstName";
    private static final String CHAMP_LAST_NAME  = "lastName";
    private static final String CHAMP_LICENSE    = "license";
    private static final String CHAMP_PILOT_RANK = "pilotRank";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();
    private PilotDao            pilotDao;

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    /**
     * Default constructor.
     */
    public PilotService( PilotDao pilotDao ) {
        this.pilotDao = pilotDao;
    }

    public List<Pilot> getAllPilots() {
        List<Pilot> pilots = (List<Pilot>) pilotDao.getAllPilots();
        return pilots;
    }

    public Pilot getPilotById( String pilotId ) {
        Pilot pilot = pilotDao.getPilotById( pilotId );
        return pilot;
    }

    public Pilot createPilot( HttpServletRequest request ) {

        String firstName = request.getParameter( CHAMP_FIRST_NAME );
        String lastName = request.getParameter( CHAMP_LAST_NAME );
        String license = request.getParameter( CHAMP_LICENSE );
        String pilotRank = request.getParameter( CHAMP_PILOT_RANK );

        Pilot pilot = new Pilot();

        try {
            validationNom( lastName );
        } catch ( Exception e ) {
            setErreur( CHAMP_LAST_NAME, e.getMessage() );
        }
        pilot.setNom( lastName );

        try {
            validationPrenom( firstName );
        } catch ( Exception e ) {
            setErreur( CHAMP_FIRST_NAME, e.getMessage() );
        }
        pilot.setPrenom( firstName );

        try {
            validationLicense( license );
        } catch ( Exception e ) {
            setErreur( CHAMP_LICENSE, e.getMessage() );
        }
        pilot.setLicense( license );

        pilot.setPilotRank( PilotRank.valueOf( pilotRank ) );

        if ( erreurs.isEmpty() ) {
            pilotDao.createPilot( pilot );
            resultat = "Creation succeded.";
        } else {
            resultat = "Creation failed";
        }

        return pilot;
    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "The last name must contain more than three caracteres." );
            }
        } else {
            throw new Exception( "The last name cannot be empty." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "The first name must contain more than three caracteres." );
        }
    }

    private void validationLicense( String license ) throws Exception {
        if ( license != null && license.length() < 2 ) {
            throw new Exception( "The license must contain more than three caracteres." );
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

}
