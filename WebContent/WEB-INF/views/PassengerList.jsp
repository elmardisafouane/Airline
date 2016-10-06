<%@include file="/WEB-INF//views/template/header.jsp"%>


<body>

	<div class="container">
  		<h2>Passengers List</h2>

  		<table class="table">
    		<thead>
     			 <tr>
      			    <th>First Name</th>
      			    <th>Last Name</th>
      			    <th>Address</th>
      			    <th>Phone Number</th>
      			    <th>Email</th>
      			    <th>Flight Class</th>
      			    <th>Action</th>
    			 </tr>
   			</thead>
   			
    		<tbody>
	    		<c:forEach items="${passengers}" var="passenger">
		      			<tr>
		      				<td>
				       		 	<c:out value="${passenger.prenom}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${passenger.nom}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${passenger.adresse}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${passenger.telephone}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${passenger.email}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${passenger.flightClass}" />
		        			</td>
		        			<td>
		                        <a href="<c:url value="/admin/RemovePassenger"><c:param name="idPassenger" value="${ passenger.id }" /></c:url>">
		                            <i class="fa fa-times" aria-hidden="true" id="removeicon"></i>
		                        </a>
                    		</td>
		      			</tr>
		      			
		      			<tr>
		      				<td colspan="9">
		      					<h5><strong>Flights for <c:out value="${passenger.prenom}" /> <c:out value="${passenger.nom}" /> :</strong></h5>
		        				<c:forEach items="${passenger.flights}" var="flights">
				       		 			 From <c:out value="${flights.depart}" /> To <c:out value="${flights.destination}" /> AT <c:out value="${flights.date}" /> <a href="<c:url value="/admin/RemoveTicketPassenger"><c:param name="Id_Flight" value="${flights.id }" /><c:param name="Id_Passenger" value="${passenger.id }" /></c:url>"> <i class="fa fa-times" aria-hidden="true" id="removeicon"> </i> </a>  <br/>
				       		 	</c:forEach>
		        			</td>
		      			</tr>
	      		</c:forEach>
    		</tbody>
  		</table>
	</div>
	
	
  	<div class="btn-group btn-group-justified">
	  <a href="<c:url value="/admin/AddPassenger"/>" class="btn btn-default">Add Passenger</a>
	  <a href="<c:url value="/admin/AddPassengerToFlight"/>" class="btn btn-default">Add Passenger To Flight</a>
	</div>

</body>
</html>