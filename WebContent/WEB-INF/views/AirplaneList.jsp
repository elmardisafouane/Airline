<%@include file="/WEB-INF//views/template/header.jsp"%>

  
<body>

	<div class="container">
  		<h2>Airplane List</h2>

  		<table class="table">
    		<thead>
     			 <tr>
      			    <th>Model</th>
      			    <th>Capacity</th>
    			 </tr>
   			</thead>
   			
    		<tbody>
	    		<c:forEach items="${planes}" var="plane">
		      			<tr>
		      				<td>
				       		 	<c:out value="${plane.model}" />
		        			</td>
		        			<td>
				       		 	<c:out value="${plane.capacity}" />
		        			</td>
		      			</tr>
		      			
	      		</c:forEach>
    		</tbody>
  		</table>
	</div>
	
	
  	<a href="<c:url value="/admin/AddPlane"/>" class="btn btn-default pull-right">Add Airplane</a>

</body>
</html>