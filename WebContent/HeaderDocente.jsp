<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

	<%@page import="Entidades.*"%>
	<% 
		Docente D= (Docente)session.getAttribute("Docente");

		if(D ==null)
		{
			System.out.println("Session Invalida");
		}
    %>
    
    
    
    <link href="Styles/navbar-top-fixed.css" rel="stylesheet">
    <form class = "form-signin" action="HeaderDocente" method="get" style="margin-bottom: 0px;">	
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" >
		
		<a class="navbar-brand" href="#" >
			<img class="d-inline-block align-top" src="pngs/loginDocente.png" height="30" width="30" alt="">
			UTN sysacad
		</a>
		
		<%if(D != null) {%>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse flex-sm-column" id="navbarCollapse" style="line-height: 10%;">
			<ul class="navbar-nav ml-auto">
			    <li class="nav-item active">
			      <a class="nav-item nav-link disabled" href="#"><Strong><%=D.getNombre()+" "+D.getApellido()%></Strong></a>
			    </li>		    
			</ul>
				<div class="input-group">
				<ul class="navbar-nav ml-auto small">
					<li class="nav-item active">
				      <a class="nav-link" href="HeaderDocente?action=Close">Cerrar Sesion</a>
				    </li>
				</ul>
			</div>
		</div>
		<%}else{ %>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse flex-sm-column" id="navbarCollapse" style="line-height: 10%;">
			<div class="input-group">
				<ul class="navbar-nav ml-auto small">
					<li class="nav-item active">
				      <a href="LoginDocente.jsp" class="nav-link" type = "submit"><Strong>Iniciar sesion</Strong></a>
				    </li>
				</ul>
			</div>
		</div>
		<%} %>
	
	</nav>
	</form>



