package com.airline.dao;

import java.util.List;

import com.airline.models.Plane;

public interface PlaneDao {

    void createPlane( Plane plane );

    List<Plane> getAllPlanes();

    Plane getPlaneById( String planeId );

}
