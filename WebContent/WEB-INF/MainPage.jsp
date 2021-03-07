<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<%@page import="Data.*"%>
<%@page import="Entidades.EstadoAcademico.*"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Inicio - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

	<!-- Session -->
	<script src="JavaScripts/SessionTimeOut.js"></script>
	
    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">
	
	<!-- Icons -->
	<script src="https://kit.fontawesome.com/1baa4ceec0.js"></script>
	
	<!-- JS -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="JavaScripts/bootstrap.min.js"></script>
	
	<!-- Customs CSS -->
	<link href="Styles/NewAlumno.css" rel="stylesheet">
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
      	
	<!-- Script para el Header -->
	<script> 
	$(function(){
	  $("#header").load("Header.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>

	<!-- Entidades -->
    <% 
    	Alumno A= (Alumno)session.getAttribute("usuario");
    
    	DataMateria DM = new DataMateria();
    	DataComision DC = new DataComision();
    	DataDocente DD = new DataDocente();
    	
    	DataExamen DE = new DataExamen();
    	ArrayList<Examen> Examenes = DE.getAll();
    %>

</head>
	


<body>
	<div id="header"></div>

	  	<div  class="jumbotron">
		  	<div class="py-5 text-center">
	        	<img class="d-block mx-auto mb-4" src="pngs/utn.png" alt="" width="200" height="200">
	        	<h1>UTN FRRO</h1>
		  	</div>
		  	
		  	<div class="container">
		  		<p class="lead"> 	Bienvenido <Strong><%=A.getNombre()+" "+A.getApellido()%></Strong>, aqui podras realizar todas las acciones basicas relacionadas con la facunltad 
				como lo pueden ser la inscripcion a materias, ver tu estado acadamico, notas de parciales/finales, entrar a una comision y mucho mas.</p>
		  	</div>
		</div>
		
		
		
		<form class="needs-validation" action="MainPage" method="get" >	
			<div class="container marketing" style="text-align: center;">
	
			    <div class="row">
			      <div class="col-lg-4">
			        <img class="d-block mx-auto mb-4" src="pngs/newExam.png" alt="" width="140" height="140">
			        <h2>Incribirte a un Examen</h2>
			        <p>Consideraciones a tener en cuenta, para poder
			          anotarte en un examen deberas cumplir con las correlatividades necesarias, poseer el 
			          estado de regularidad en la misma e incribirte 24hs habiles antes del examen.</p>
			        <button type = "submit" name="BtnExamen" value = "Examen" class="btn btn-primary my-2" style="width:200px">Ingresar</button>
			      </div>
			      
			      <div class="col-lg-4">
			        <img class="d-block mx-auto mb-4" src="pngs/newMateria.png" alt="" width="140" height="140">
			        <h2>Incribirte a una Materia</h2>
			        <p>Consideraciones a tener en cuenta, para poder
			          anotarte en una materia deberas cumplir con sus correlativas (regulares y aprobadas) y hacerlo
			          en el periodo de inscripcion de las mismas.</p>
			        <button type = "submit" name="BtnMateria" value = "Materia" class="btn btn-primary my-2" style="width:200px">Ingresar</button>
			      </div>
			      
			      <div class="col-lg-4">
			        <img class="d-block mx-auto mb-4" src="pngs/estadoAcademico.png" alt="" width="140 " height="140">
			        <h2>Ver Estado Academico</h2>
			        <p>Aqui podras ver tu estado academico, es el espacio donde se subiran las notas finales de cada asignatura, 
			        y el estado de tus materias, ya sea libre/cursando/regular/aprobada.</p>
			        <button type = "submit" name="BtnEstadoAcademico" value = "EstadoAcademico" class="btn btn-primary my-2" style="width:200px">Ingresar</button>
			      </div>		 
			    </div>
		    </div>
    
		 
		</form>
		<hr class="featurette-divider" style="max-width: 50%;">
		
		<div role="main" class="container">
			<h2 class="border-bottom border-gray pb-2 mb-0" style="margin-top: 50px;">Examenes</h2>
			<%if(DE.ExamenExist(A.getLegajo())){%>
				<%for(Examen E:Examenes){%>
					<%if(E.getLegajo().equals(A.getLegajo())){%>
					<div class="my-3 p-3 bg-white rounded shadow-sm">
							    				
					    <div class="media text-muted pt-3">
					    
					    	<%if(E.getNota()>=6 && E.getNota()<10){%>				
					    	<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#5cb85c"></rect><text x="50%" y="50%" fill="white" dy=".3em"><%=E.getNota()%></text></svg>
						    <%}else if(E.getNota()>=10){%>	
						    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#deae34"></rect><text x="50%" y="50%" fill="white" dy=".3em">10</text></svg>
						    <%}else{%>
						    <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#d9534f"></rect><text x="50%" y="50%" fill="white" dy=".3em"><%=E.getNota()%></text></svg>
						    <%}%>
						    
						    <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">				  	
								<div class="d-flex justify-content-between align-items-center w-100">
								    	<strong class="text-gray-dark">Examen <%=E.getTipo()%> - <%=E.getFecha()%> 
								    	<%if(E.getNota()>=6){%>
								    	<i class="fas fa-check"></i>
								    	<%}else{%>
								    	<i class="fas fa-times"></i>
								    	<%}%>
								    	</strong> 						    
								</div>
								
								<div class="d-flex justify-content-between align-items-center w-100">
						          <span class="d-block"><strong>Materia:</strong> <%=DM.getOne(E.getIdMateria()).getNombre()%></span>
						          <span class="d-block"><strong>Nota:</strong> <%=E.getNota()%>/10</span>
						        </div>
						        
								<div class="d-flex justify-content-between align-items-center w-100">
									<span class="d-block"><strong>Comision:</strong> <%=E.getIdComision()%></span>
									<%if(E.getObservacion()==null){%>
									<span class="d-block"><strong>Observacion:</strong> ninguna.</span>
									<%}else{%>
								    <span class="d-block"><strong>Observacion:</strong> <%=E.getObservacion()%></span>
								    <%}%>
								</div>
								
								<span class="d-block"><strong>Turno:</strong> <%=DC.getOne(E.getIdComision(),E.getIdMateria()).getTurno()%></span>
								<span class="d-block"><strong>Docente:</strong> <%=DD.getOne(DC.getOne(E.getIdComision(),E.getIdMateria()).getIdDocente()).getNombre()%> <%=DD.getOne(DC.getOne(E.getIdComision(),E.getIdMateria()).getIdDocente()).getApellido()%></span>
								<span class="d-block"><strong>Modalidad:</strong> <%=E.getModalidad()%></span>
								
								
						    </div>
					    </div>
					</div>
					<%}%>
				<%}%>
			<%}else{%>
			<p>No hay Examenes disponilbes.</p>
			<%}%>
		</div>
    	
		<hr class="mb-4">
		<div id="footer"></div>
</body>



</html>


