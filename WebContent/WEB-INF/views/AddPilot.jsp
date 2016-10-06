<%@include file="/WEB-INF//views/template/header.jsp"%>

	<div class="container">
  		<h2>Adding Pilot</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/admin/AddPilot" />">
    		<div class="form-group">
      			 <label for="firstName">First Name <span class="requis">*</span></label>
     			 <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter the first name" value="<c:out value="${pilot.prenom}"/>" />
     			 <span class="erreur">${pilotService.erreurs['firstName']}</span>

   			 </div>
   			 
   			 <div class="form-group">
      			 <label for="lastName">Last Name  <span class="requis">*</span></label>
     			 <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter the last name"  value="<c:out value="${pilot.nom}"/>" />
				 <span class="erreur">${pilotService.erreurs['lastName']}</span>
				 
   			 </div>
   			 
   			 <div class="form-group">
      			 <label for="license">License  <span class="requis">*</span></label>
     			 <input type="text" name="license" class="form-control" id="license" placeholder="Enter the license" value="<c:out value="${pilot.license}"/>" />
     			 <span class="erreur">${pilotService.erreurs['license']}</span>

   			 </div>
   			 
   			 <div class="form-group">
       			<h4>The Pilot Rank :</h4> 
          		<select name="pilotRank" class="selectpicker" data-live-search="true" data-width="100%">
              		<option value="Captain">Captain</option>
              		<option value="Officier">Officier</option>
          		</select>
    		</div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>

</body>
</html>