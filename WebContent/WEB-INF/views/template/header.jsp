<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Airline Management</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-select.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
<link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"/>">


<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"/>"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-select.js"/>"></script>


</head>
<body>


<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-default navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="<c:url value="/admin/Home"/>">Airline</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="<c:url value="/admin/Home"/>">Home</a></li>
                <li><a href="<c:url value="/admin/PassengerList"/>">Passengers</a></li>
                <li><a href="<c:url value="/admin/FlightList"/>">Flights</a></li>
                <li><a href="<c:url value="/admin/AirplaneList"/>">Aiplane</a></li>
                <li><a href="<c:url value="/admin/PilotList"/>">Pilots</a></li>
                
              </ul>
              
              <ul class="nav navbar-nav pull-right">          
              	<li><a href="<c:url value="/admin/Deconnexion"/>"> Logout  </a></li>          	
              </ul>
              
            </div>
          </div>
        </nav>

      </div>
    </div>