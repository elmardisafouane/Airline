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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
              <a class="navbar-brand" href="<c:url value="#"/>">Airline</a>
            </div>

          </div>
        </nav>

      </div>
    </div>

		<div class="container">
  		<h2>Search for a flight</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/Index" />">
  			<div class="form-group">
				<h4>Flight Origin :</h4>
          		<select name="depart" class="selectpicker form-control" data-live-search="true">
          			<option value="London">London</option>
              		<option value="Madrid">Madrid</option>
              		<option value="Meknes">Meknes</option>
              		<option value="Dakhla">Dakhla</option>
              		<option value="Barcelona">Barcelona</option>
              		<option value="Roma">Roma</option>
              		<option value="Munchen">Munchen</option>
              		<option value="Dortmund">Dortmund</option>
              		<option value="Rabat">Rabat</option>
              		<option value="Casablanca">Casablanca</option>
              		<option value="Tanger">Tanger</option>
              		<option value="Agadir">Agadir</option>
              		<option value="Manhatan">Manhatan</option>
              		<option value="Tunis">Tunis</option>
              		<option value="Alger">Alger</option>
              		<option value="Marseille">Marseille</option>
              		<option value="Lyon">Lyon</option>
              		<option value="Benfica">Benfica</option>
              		<option value="Porto">Porto</option>
              		<option value="Valencia">Valencia</option>
              		<option value="Fes">Fes</option>
              		<option value="LasPalmas">LasPalmas</option>
              		<option value="Ghaza">Ghaza</option>
              		<option value="Oujda">Oujda</option>
          		</select>
    		</div>
    		
    		
    		
    		<div class="form-group">
       			<h4>Flight Destination :</h4>
          		<select name="destination" class="selectpicker form-control" data-live-search="true">
          			<option value="Madrid">Madrid</option>
              		<option value="Meknes">Meknes</option>
              		<option value="Dakhla">Dakhla</option>
              		<option value="London">London</option>
              		<option value="Barcelona">Barcelona</option>
              		<option value="Roma">Roma</option>
              		<option value="Munchen">Munchen</option>
              		<option value="Dortmund">Dortmund</option>
              		<option value="Rabat">Rabat</option>
              		<option value="Casablanca">Casablanca</option>
              		<option value="Tanger">Tanger</option>
              		<option value="Agadir">Agadir</option>
              		<option value="Manhatan">Manhatan</option>
              		<option value="Tunis">Tunis</option>
              		<option value="Alger">Alger</option>
              		<option value="Marseille">Marseille</option>
              		<option value="Lyon">Lyon</option>
              		<option value="Benfica">Benfica</option>
              		<option value="Porto">Porto</option>
              		<option value="Valencia">Valencia</option>
              		<option value="Fes">Fes</option>
              		<option value="LasPalmas">LasPalmas</option>
              		<option value="Ghaza">Ghaza</option>
              		<option value="Oujda">Oujda</option>
          		</select>
    		</div>
   			 
   			 <div class="form-group">
   			 		<h4>Flight Time :</h4>
	       			<label for="year">Year :</label> 
	          		<select name="year" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "2016">2016</option>
						<option value = "2017">2017</option>
						<option value = "2018">2018</option>
						<option value = "2019">2019</option>
						<option value = "2020">2020</option>
						<option value = "2021">2021</option>
						<option value = "2022">2022</option>
						<option value = "2023">2023</option>
						<option value = "2024">2024</option>
						<option value = "2025">2025</option>
	          		</select>
	
	       			<label for="month">Month :</label> 
	          		<select name="month" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "1">January</option>
						<option value = "2">February</option>
						<option value = "3">March</option>
						<option value = "4">April</option>
						<option value = "5">May</option>
						<option value = "6">June</option>
						<option value = "7">July</option>
						<option value = "8">August</option>
						<option value = "9">September</option>
						<option value = "10">October</option>
						<option value = "11">November</option>
						<option value = "12">December</option>
	          		</select>
	
	       			<label for="day">Day :</label> 
	          		<select name="day" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
						<option value = "5">5</option>
						<option value = "6">6</option>
						<option value = "7">7</option>
						<option value = "8">8</option>
						<option value = "9">9</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>
						<option value = "13">13</option>
						<option value = "14">14</option>
						<option value = "15">15</option>
						<option value = "16">16</option>
						<option value = "17">17</option>
						<option value = "18">18</option>
						<option value = "19">19</option>
						<option value = "20">20</option>
						<option value = "21">21</option>
						<option value = "22">22</option>
						<option value = "23">23</option>
						<option value = "24">24</option>
						<option value = "25">25</option>
						<option value = "26">26</option>
						<option value = "27">27</option>
						<option value = "28">28</option>
						<option value = "29">29</option>
						<option value = "30">30</option>
						<option value = "31">31</option>
	          		</select>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>
	
	
	<div class="container">
  		<h2>Search Results</h2>
  		

  		<table class="table">
    		<thead>
     			 <tr>
      			    <th>Origin</th>
      			    <th>Destintion</th>
      			    <th>Date</th>
      			    <th>Price</th>
      			    <th>Number of seats</th>
      			    <th>Reserved seats</th>
      			    <th>Plane Model</th>
      			    <th>Pilot Name</th>
    			 </tr>
   			</thead>
   			
    		<tbody>
	    		<c:forEach items="${flights}" var="flight">
		      			<tr>
		      				<td>
				       		 	<c:out value="${flight.depart}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.destination}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.date}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.prix} DH" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.airplane.capacity}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${fn:length(flight.passengers)}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.airplane.model}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${flight.pilot.prenom}" /> <c:out value="${flight.pilot.nom}" />
		        			</td>

		      			</tr>
		      			

	      		</c:forEach>
    		</tbody>
  		</table>
	</div>


</body>
</html>