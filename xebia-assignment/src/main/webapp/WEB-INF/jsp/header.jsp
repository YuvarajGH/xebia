<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<style>
	.navbar{
		background: #08b1a1;
	}
	
	.nav-item.active{
		border-bottom: 2px solid white;
	}
	
	.nav-item{
		font-weight: bold;
		color:white;
		padding: 10px;
	}
	
	.nav-item:hover{
		background: #07ab9b;
	    color:white;
		font-weight: 600;
	}
</style>
<header>	
	<nav class="navbar navbar-expand-sm ">
	  <div class="container justify-content-end" id="navbarNavAltMarkup">
	    <div class="navbar-nav navbar-right">
	      <a class="nav-item nav-link ${registration}" href="${pageContext.request.contextPath}/employee/page/register">Register</a>
	      <a class="nav-item nav-link ${view}" href="${pageContext.request.contextPath}/employee/page/list">View All</a>
	    </div>
	  </div>
	</nav>
</header>