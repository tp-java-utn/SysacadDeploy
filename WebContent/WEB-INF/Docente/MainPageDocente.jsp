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
    <title>Docente - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/loginDocente.png">

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
	  $("#header").load("HeaderDocente.jsp");
	  $("#footer").load("Footer.jsp"); 
	});
	</script>

	<!-- Entidades -->
    <% 
    	DataDocente DD = new DataDocente();
    	Docente D= (Docente)session.getAttribute("Docente");
    
    	DataMateria DM = new DataMateria();	
    	ArrayList<Materia> Materias = DM.getAll();
    	
    	DataComision DC = new DataComision();
    	ArrayList<Comision> Comisiones = DC.getAll();
    	
    	boolean docenteTieneMaterias = false;
    %>

</head>
	


<body>
	<div id="header"></div>
	
	<form name="myForm" action="MainPageDocente" method="get">
		<div role="main" class="container">
			<%for(Materia M:Materias){ %>
				<%if(DD.isDocenteInsideMateria(D.getIdDocente(), M.getIdMateria())){ %>
				<%docenteTieneMaterias = true; %>
					<div class="my-3 p-3 bg-white rounded shadow-sm">						    				
					    <div class="media text-muted pt-3">        					
					    	
						    <div class="media-body pb-3 mb-0 small lh-125  border-gray">				  	
								
								<div class="d-flex  align-items-center w-100" >
								    <h2 class="text-center"><strong class="text-gray-dark"> <%=M.getNombre() %> </strong></h2>	    	 						    
								</div>
								
							  <%for(Comision C:Comisiones){ %>
							  	<%if(C.getIdDocente() == D.getIdDocente() && C.getIdMateria() == M.getIdMateria()){ %>
							  	<div class="row" style="padding: 1%;padding-left: 17px;">
							  		<div class="col">
							  			<span class="d-block" style="margin-top: 7px;"><strong>Comision:</strong> <%=C.getIdComision() %> <%=C.getTurno() %> (<%=C.getCantAlumnos() %>/<%=C.getCantAlumnosMax() %>)</span>						  			
							  		</div>
							  		<div class="col">
							  			<a href="MainPageDocente?action=info&idComision=<%=C.getIdComision() %>&idMateria=<%=C.getIdMateria() %>" type="button" class="btn btn-info" style="float: right"><i class="fas fa-info-circle"></i> Alumnos</a>
							  		</div>						  		
							  	</div>	 
							  	
							  	<hr style="margin:0px">         		
					          	<%} %>
					          <%} %>
			
				
				
						    </div>
				
					    </div>
					</div>
				<%} %>
		    <%} %>
		
			<%if(!docenteTieneMaterias){ %>
				<div class="my-3 p-3 bg-white rounded shadow-sm">						    				
				    <div class="media text-muted pt-3">        							    	
					    <div class="media-body pb-3 mb-0 small lh-125  border-gray">
					    	<span class="d-block" style="margin-left: 45%;">No hay Materias Disponibles</span>
					    </div>
					</div>
				</div>
			<%} %>
			
		</div>	
	</form>
	
	<div id="footer"></div>
</body>
</html>