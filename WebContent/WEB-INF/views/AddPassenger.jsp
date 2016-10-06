<%@include file="/WEB-INF//views/template/header.jsp"%>


	<div class="container">
  		<h2>Adding Passenger</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/admin/AddPassenger" />">
    		<div class="form-group">
      			 <label for="firstName">First Name <span class="requis">*</span></label>
     			 <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter the first name" value="<c:out value="${passenger.prenom}"/>">
     			 <span class="erreur">${passengerService.erreurs['firstName']}</span>  
   			 </div>
   			 
   			 <div class="form-group">
    			  <label for="lastName">Last Name <span class="requis">*</span></label>
  			      <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter the last name" value="<c:out value="${passenger.nom}"/>">
  			      <span class="erreur">${passengerService.erreurs['lastName']}</span>  
  			 </div>
  			 
             <div class="form-group">
            	 <label for="address">Address <span class="requis">*</span></label>
     			 <input type="text" name="address" class="form-control" id="address" placeholder="Enter the address" value="<c:out value="${passenger.adresse}"/>">
     			 <span class="erreur">${passengerService.erreurs['address']}</span>  
   			 </div>
   			 
   			 <div class="form-group">
    			  <label for="telephone">Phone Nunber <span class="requis">*</span></label>
     			  <input type="text" name="telephone" class="form-control" id="telephone" placeholder="Enter the phone number" value="<c:out value="${passenger.telephone}"/>">
     			  <span class="erreur">${passengerService.erreurs['telephone']}</span>  
    		</div>
    		
    		<div class="form-group">
      			<label for="email">E-mail <span class="requis">*</span></label>
      			<input type="text" name="email" class="form-control" id="email" placeholder="Enter the e-mail" value="<c:out value="${passenger.email}"/>">
      			<span class="erreur">${passengerService.erreurs['email']}</span>   
    		</div>
    		
    		<div class="form-group">
       			<h4>The Flight Class :</h4> 
          		<select name="flightClass" class="selectpicker" data-live-search="true" data-width="100%">
              		<option value="First">First</option>
              		<option value="Business">Business</option>
              		<option value="Vip">Vip</option>
          		</select>
    		</div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>

</body>
</html>