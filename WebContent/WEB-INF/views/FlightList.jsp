<%@include file="/WEB-INF//views/template/header.jsp"%>


	<div class="container">
  		<h2>Fliht List</h2>

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
      			    <th>Action</th>
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
		        			<td>
		                        <a href="<c:url value="/admin/RemoveFlight"><c:param name="idFlight" value="${ flight.id }" /></c:url>">
		                            <i class="fa fa-times" aria-hidden="true" id="removeicon"></i>
		                        </a>
                    		</td>
		      			</tr>
		      			
		      			<tr>
		      				<td colspan="9">
		      					<h5><strong>Passengers for this flight:</strong></h5>
		        				<c:forEach items="${flight.passengers}" var="passengers">
				       		 			<c:out value="${passengers.nom}" /> <c:out value="${passengers.prenom}" />   <a href="<c:url value="/admin/RemoveTicket"><c:param name="idPassenger" value="${passengers.id }" /><c:param name="idFlight" value="${flight.id }" /></c:url>"> <i class="fa fa-times" aria-hidden="true" id="removeicon"> </i> </a> <br/>
				       		 	</c:forEach>
		        			</td>
		        				
		      			</tr>
	      		</c:forEach>
    		</tbody>
  		</table>
	</div>
	
	<a href="<c:url value="/admin/AddFlight"/>" class="btn btn-default pull-right">Add Flight</a>

</body>
</html>