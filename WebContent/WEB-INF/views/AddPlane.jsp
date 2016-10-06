<%@include file="/WEB-INF//views/template/header.jsp"%>


	<div class="container">
  		<h2>Adding Plane</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/admin/AddPlane" />">
    		<div class="form-group">
      			 <label for="model">Plane Model  <span class="requis">*</span></label>
     			 <input type="text" name="model" class="form-control" id="model" placeholder="Enter the plane model" value="<c:out value="${plane.model}"/>" >
     			 <span class="erreur">${planeService.erreurs['model']}</span>
   			 </div>
   			 
   			 <div class="form-group">
      			 <label for="capacity">Plane Capacity  <span class="requis">*</span></label>
     			 <input type="text" name="capacity" class="form-control" id="capacity" placeholder="Enter the number of seats" value="<c:out value="${plane.capacity}"/>">
     			 <span class="erreur">${planeService.erreurs['capacity']}</span>
   			 </div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>

</body>
</html>