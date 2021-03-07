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
    	Comision C = (Comision)session.getAttribute("Comision");
    	Alumno A   = (Alumno)session.getAttribute("Alumno");
    %>

</head>
	


<body>
	<div id="header"></div>
	
	<form name="myForm" action="MainPageDocenteUploadExamen" method="get">
		<div role="main" class="container">
			
			<h2 style="color: #6c757d;padding: 25px;"><strong>Subiendo Nota de <%=A.getNombre()%></strong></h1>
			
			<div class="row">
  						          		  	          		
	          		<div class="col-md-4 mb-3">
		          		<div class="mb-4">
				        <label for="Tipo">Tipo</label>
				        <select name="Tipo" id="Tipo" class="custom-select d-block w-100" required>
				        <option value="">Elige...</option>
				        <option value="Final">Final</option>
				        <option value="Parcial">Parcial</option>
				        <option value="Recuperatorio">Recuperatorio</option>
				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione un Tipo.
					        </div>
				        </div>
			        </div>
	          		
	          		<div class="col-md-4 mb-3">
		          		<div class="mb-4">
				        <label for="Modalidad">Modalidad</label>
				        <select name="Modalidad" id="Modalidad" class="custom-select d-block w-100" required>
				        <option value="">Elige...</option>
				        <option value="Oral">Oral</option>
				        <option value="Multiplechoice">Multiplechoice</option>
				        <option value="Desarrollo">Desarrollo</option>
				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione una Modalidad.
					        </div>
				        </div>
			        </div>
			        
			        <div class="col-md- mb-3">
		          	<label for="Nota">Nota</label>
			        <input name= "Nota" type="Nota" class="form-control" id="Numero" min="1" max="10" value="1" required
			        	title = "El Tamaño minimo es de 1 y el maximo de 2 digitos">
				    </div>	
			        
          		</div>
          		
          		<div class="row">
         			<div class="col-md-12 mb-3">
			      		<label for="observacion">Observacion <span class="text-muted">(Opcional)</span></label>
				        <textarea  name="observacion" class="form-control" id="observacion" rows="3" maxlength="1024"></textarea>
			        </div>
          		</div>
          			
          		<div class="row justify-content-center">
					<div class="col-3">
				    	<button class="btn btn-info btn-lg btn-block" type="submit" style="color:white"><i class="fas fa-save" aria-hidden="true"></i> Guardar</button> 
				    </div>
		    	</div>
			
		</div>	
	</form>
	
	<div id="footer"></div>
</body>
</html>