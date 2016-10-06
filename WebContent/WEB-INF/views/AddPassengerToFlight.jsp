<%@include file="/WEB-INF//views/template/header.jsp"%>

	<div class="container">
  		<h2>Adding Passenger</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/admin/AddPassengerToFlight"/>">
			<div class="form-group">
    			<h4>Flight :</h4>
	    		<select name="flightId" class="selectpicker" data-live-search="true" data-width="100%">
	   			 	<c:forEach items="${flights}" var="flight">
	       		 		<option value="${flight.id}">
	       		 			FROM <c:out value="${flight.depart}" /> TO <c:out value="${flight.destination}" /> AT <c:out value="${flight.date}" />
	       		 		</option>
	    			</c:forEach>
				</select>
    		</div>
    		
    		
    		<div class="form-group">
    			<h4>Passenger :</h4>
	    		<select name="passengerId" class="selectpicker" data-live-search="true" data-width="100%">
	   			 	<c:forEach items="${passengers}" var="passenger">
	       		 		<option value="${passenger.id}"><c:out value="${passenger.nom}" /></option>
	    			</c:forEach>
				</select>
    		</div>
    		
    		<div>
    			${erreur}
    		</div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    		
    	</form>
	</div>

</body>
</html>