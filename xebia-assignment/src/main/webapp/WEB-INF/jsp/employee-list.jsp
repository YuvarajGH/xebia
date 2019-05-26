<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee List</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900&display=swap" rel="stylesheet">

<style type="text/css">
	
	body{
		font-family: Muli;
		font-size: 14px;
		background: #f7f7f7;
	}
	.table td, .table th{
		text-align:center;
	}
	
	.table td{
		font-weight: bold;
		font-size: 13px;
	}
	.table th{
	    background: #77ada8;
    	text-transform: uppercase;
	}
	
	
	.content-title{
		margin: 30px auto;
	}
	
</style>

</head>
<body>
<%@include file="header.jsp"%>
	<div class="container">
		<h2 class="content-title" >Employee List</h2>
		<div class="table-data">
			<table class="table table-bordered table-striped">
				<thead class="">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Gender</th>
						<th>Date of Birth</th>
						<th>Department</th>
					</tr>
				</thead>
				<tbody id="employee-data" class="employee-data" >
				
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
<script type="text/javascript">
	var context = '${pageContext.request.contextPath}';
	
	$(document).ready(function(){
		var dataContainer = $('#employee-data');
		
		$.get(context + "/employee/list")
		.done(function(employeeList){
			
			var htmlContent = '';
			
			if(employeeList.length == 0){
				htmlContent = '<td colspan="5" >No Employees found</td>'
			}else{
				
				employeeList.forEach(function(employee){
					console.log(employee);
					htmlContent += ' <tr> ' +
									  ' <td>' + employee.firstName + '</td> ' +
									  ' <td>' + employee.lastName + '</td> ' +
									  ' <td>' + employee.gender + '</td> ' +
									  ' <td>' + formatDate(employee.dob) + '</td> ' +
									  ' <td>' + employee.department + '</td> ' +
								  ' </tr> ';
				})
			}
			dataContainer.html(htmlContent);
		})
		.fail(function(error){
			dataContainer.html( '<td colspan="5" >Unable to fetch employee list</td>' );
		})
	})
	
	function formatDate(dateString){
		return new Date(dateString).toLocaleDateString();
	}
	
	
	
</script>

</html>