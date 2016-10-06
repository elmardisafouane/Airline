<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              <a class="navbar-brand" href="<c:url value="/admin/Home"/>">Airline</a>
            </div>
            
          </div>
        </nav>

      </div>
    </div>


	<div class="container">
  		<h2>Sign up</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/AddUser" />">
    		<div class="form-group">
      			 <label for="model">Username <span class="requis">*</span></label>
     			 <input type="text" name="username" class="form-control" id="username" placeholder="Enter username" value="<c:out value="${user.username}"/>" >
   			 </div>
   			 
   			 <div class="form-group">
      			 <label for="capacity">Password  <span class="requis">*</span></label>
     			 <input type="password" name="password" class="form-control" id="password" placeholder="Enter password" >
   			 </div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>

</body>
</html>