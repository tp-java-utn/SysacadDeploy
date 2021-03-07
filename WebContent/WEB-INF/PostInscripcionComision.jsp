<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registro completado - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

	<!-- Session -->
	<script src="JavaScripts/SessionTimeOut.js"></script>
	
    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">


    <style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        -ms-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	</style>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
	$(function(){
	  $("#header").load("Header.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>
	
	<link href="Styles/floating-labels.css" rel="stylesheet">
	
	<% 
		Alumno A= (Alumno)session.getAttribute("usuario");
		Comision C= (Comision)session.getAttribute("Comision");
		Materia M = (Materia)session.getAttribute("Materia");
		
		DataDocente DD = new DataDocente();
		Docente D = DD.getOne(C.getIdDocente());
		DataInscripcion DI =  new DataInscripcion();
		Inscripcion I = DI.getOne(A.getLegajo(),M.getIdMateria(),C.getIdComision());
		
    %>
</head>
	


<body>	
	
	<form class = "form-signin" id="myForm" name="myForm" method="post">
	<div id="header"></div>
			
		<div class="form-signin text-center mb-4">
			<div class="card">
						<div class="card-body">
					<img class="mb-4" src="pngs/login.png" height="150" width="150">
					<h1 class="h3 mb-3 font-weight-normal text-primary">FELICITACIONES</h1>
					
					<ul class="list-unstyled mt-3 mb-4">
		              <li><%=A.getNombre()%> te has logrado inscribir en la comision</li>
		              <li><strong><%=C.getIdComision()%> - <%=M.getNombre()%></strong></li>
		            </ul>
		            
		            <ul class="list-unstyled mt-3 mb-4 text-left">
		              <li><strong>Turno: </strong>  <%=C.getTurno()%></li>
		              <li><strong>Docente: </strong> <%=D.getNombre()%> <%=D.getApellido()%></li>
		            </ul>
		            
					<p class="text-left"><strong>Numero Inscripcion: </strong> <%=I.getIdInscripcion()%></p>
					<a class="btn btn-primary btn-lg btn-block" href="InscripcionMateria?action=volver">Volver</a>
				</div>
			</div>
		</div>
	 
		<div id="footer"></div>
	</form>
</body>
</html>