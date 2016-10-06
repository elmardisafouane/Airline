<%@include file="/WEB-INF//views/template/header.jsp"%>


<body>

	<div class="container">
  		<h2>Pilots List</h2>

  		<table class="table">
    		<thead>
     			 <tr>
      			    <th>First Name</th>
      			    <th>Last Name</th>
      			    <th>License</th>
      			    <th>Pilot Rank</th>
    			 </tr>
   			</thead>
   			
    		<tbody>
	    		<c:forEach items="${pilots}" var="pilot">
		      			<tr>
		      				<td>
				       		 	<c:out value="${pilot.prenom}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${pilot.nom}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${pilot.license}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${pilot.pilotRank}" />
		        			</td>
		      			</tr>
		      			
	      		</c:forEach>
    		</tbody>
  		</table>
	</div>
	
	
  	<a href="<c:url value="/admin/AddPilot"/>" class="btn btn-default pull-right">Add Pilot</a>

</body>
</html>