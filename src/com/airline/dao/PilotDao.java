package com.airline.dao;

import java.util.List;

import com.airline.models.Pilot;

public interface PilotDao {

    void createPilot( Pilot pilot );

    List<Pilot> getAllPilots();

    Pilot getPilotById( String pilotId );

}
