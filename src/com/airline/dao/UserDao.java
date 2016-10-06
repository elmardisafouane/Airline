package com.airline.dao;

import com.airline.models.User;

public interface UserDao {

    User getUser( String username, String password );

    void createUser( User user );

}
