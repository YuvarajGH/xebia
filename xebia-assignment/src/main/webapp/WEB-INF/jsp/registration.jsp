<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900&display=swap" rel="stylesheet">

<title>Register Employee</title>


<style type="text/css">
body {
	font-family: Muli;
	font-size: 14px;
}

header {
	height: 200px;
	background: #08b1a1;
}

.form-center {
	max-width: 500px;
	margin: auto;
	margin-top: -100px;
	background: white;
	padding: 20px;
	border: 1px solid #eaeaea;
	border-radius: 5px;
	overflow: auto;
}

.form-header {
	font-size: 25px;
}

.form-center label {
	font-weight: 600;
	color: #696868;
}

.message {
	font-size: 13px;
	font-weight: 600;
	line-height: 30px;
}

.success {
	color: green;
}

.error {
	color: red;
}
</style>

</head>


<body>
	<%@include file="header.jsp"%>
	<section class="container">

	<div class="form-center">
		<h2 class="form-header">Register Employee</h2>
		<br>
		<form:form
			action="${pageContext.request.contextPath}/employee/register"
			method="POST" id="registration-form" modelAttribute="employee">
			<div class="form-group">
				<label for="firstName">First Name</label> <input maxlength="50"
					minlength="3" name="firstName" type="text" class="form-control"
					required> <span><form:errors path="firstName"
						cssClass="error" /></span>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name</label> <input maxlength="50"
					minlength="3" name="lastName" type="text" class="form-control"
					required> <span><form:errors path="lastName"
						cssClass="error" /></span>
			</div>
			<div class="form-group">
				<label for="dob">Date of Birth </label> <input name="dob"
					pattern="dd/MM/yyyy" type="date" class="form-control" required>
				<span><form:errors path="dob" cssClass="error" /></span>
			</div>
			<div class="form-group">
				<label for="gender">Gender</label> <select name="gender"
					class="form-control" required>
					<option disabled selected value="">Select Gender</option>
					<option value="MALE">MALE</option>
					<option value="FEMALE">FEMALE</option>
					<option value="TRANSGENDER">TRANSGENDER</option>
				</select> <span><form:errors path="gender" cssClass="error" /></span>
			</div>
			<div class="form-group">
				<label for="department">Department</label> <select name=department
					class="form-control" required>
					<option disabled selected value="">Select Department</option>
					<option value="IT">OPERATIONS</option>
					<option value="BUSINESS">BUSINESS</option>
					<option value="HR">HR</option>
					<option value="SALES">SALES</option>
					<option value="MARKETING">MARKETING</option>
				</select> <span><form:errors path="department" cssClass="error" /></span>
			</div>
			<span class="float-left message success">${success}</span>
			<span class="float-left message error">${error}</span>
			<button type="submit" class="btn btn-primary float-right"
				style="margin-left: 10px;">Submit</button>
			<button type="button" class="btn btn-primary float-right"
				onclick="resetForm()">Reset</button>
		</form:form>
	</div>
	</section>

	<script type="text/javascript">
	
	function resetForm(){
		document.getElementById('registration-form').reset();
	}
	
	document.querySelectorAll("input, select").forEach(function(input){
		input.onfocus = function(){
			var messages = document.getElementsByClassName('message'); 
			messages[0].innerHTML = '';
			messages[1].innerHTML = '';
		}
	});
	
	</script>
</body>


</html>