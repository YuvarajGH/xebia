<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700,900&display=swap" rel="stylesheet">
<title>Register Employee</title>


<style type="text/css">
	
	body{
		font-family: Roboto;
	}
	
	.form-center{
		max-width: 500px;
		margin: auto;
	}
	
	.form-header{
		margin-top: 30px;
	}
</style>

</head>


<body>
	<header>	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div class="container collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
		    <div class="navbar-nav navbar-right">
		      <a class="nav-item nav-link active" href="#">Register</a>
		      <a class="nav-item nav-link" href="#">View All</a>
		    </div>
		  </div>
		</nav>
	</header>
	<section class="container">
	
		<div class="form-center">
			<h2 class="form-header">Register Employee</h2>
			<br>
			<form action="${pageContext.request.contextPath}/employee/register" method="POST" >
			  <div class="form-group">
			    <label for="firstName">First Name</label>
			    <input name="firstName" type="text" class="form-control" required >
			  </div>
			  <div class="form-group">
			    <label for="lastName">Last Name</label>
			    <input name="lastName" type="text" class="form-control" required >
			  </div>
			  <div class="form-group">
			    <label for="dob">Date of Birth</label>
			    <input name="dob" pattern="dd/MM/yyyy" type="date" class="form-control" required >
			  </div>
   		      <div class="form-group">
			    <label for="gender">Gender</label>
			    <select name="gender" class="form-control" required >
			      <option disabled selected value="" >Select Gender</option>
			      <option value="MALE" >MALE</option>
			      <option value="FEMALE" >FEMALE</option>
			      <option value="TRANSGENDER" >TRANSGENDER</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlSelect2">Gender</label>
			    <select name=department class="form-control" required >
			      <option disabled selected value="" >Select Department</option>
			      <option value="IT">OPERATIONS</option>
			      <option value="BUSINESS" >BUSINESS</option>
			      <option value="HR" >HR</option>
			      <option value="SALES" >SALES</option>
			      <option value="MARKETING" >MARKETING</option>
			      
			    </select>	
			  </div>
			  <span class="float-left" >${message}</span>
			  <button type="submit" class="btn btn-primary float-right">Submit</button>
			</form>
		</div>
	</section>
</body>
</html>