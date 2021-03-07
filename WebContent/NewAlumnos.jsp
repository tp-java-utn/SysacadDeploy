<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Alumno"%>
<html>
<head>


<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registro - UTN</title>
	<link rel="shortcut icon" type="image/png" href="pngs/login.png">

    <!-- Bootstrap core CSS -->
	<link href="Styles/bootstrap.min.css" rel="stylesheet">
	
	<!-- Bootstrap core JS -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="JavaScripts/bootstrap.js"></script>
	<script src="JavaScripts/bootstrap.min.js"></script>
	
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
      
      input[type="number"] {
    	-moz-appearance: textfield;
	  }
    </style>
      
	<link href="Styles/NewAlumno.css" rel="stylesheet">
	
	<!-- Script para el Header -->
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script> 
	$(function(){
	  $("#footer").load("Footer.jsp"); 
	});
	</script>
	

</head>
	


<body>
	
	
  	<div class="container">
  		
  		<div class="py-5 text-center">
		    <img class="d-block mx-auto mb-4" src="pngs/newAlumno.png" alt="" width="150" height="150">
		    <h2>Registro de Alumnos</h2>
		    <p class="lead">Los datos cargados en esta pantalla seran verificados por la Universidad
		    con un tiempo de hasta 48 hs habiles. Por favor, verificá que los mismos sean correctos antes de generar el Usuario.</p>
	  	</div>
	  	
	  	
	  	<form class="needs-validation" action="NewAlumno" method="post">
  		<div class="col-md-12 order-md-1">
  			
  			
	  			
  				<div class="row">
  				
		          	<div class="col-md-6 mb-3">
		          	<label for="nombre">Nombre</label>
			        <input name= "nombre" type="text" class="form-control" id="nombre" value="" required pattern="[A-Za-z ]{4,20}" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				        	Tu nombre es necesario.
				        </div>
				    </div>
				    
				    <div class="col-md-6 mb-3">
		      		<label for="apellido">Apellido</label>
		      	  	<input name="apellido" type="text" class="form-control" id="apellido" value="" required pattern="[A-Za-z ]{4,20}" required
		      	  		title = "El Tamaño minimo es de 4 y el maximo de 20">	      	 
			          	<div class="invalid-feedback">
			            	Tu apellido es necesario.
			          	</div>
	          		</div>
	          			
          		</div>
          		
          		<div class="row">
			        <div class="col-md-4 mb-3">
		          		<div class="mb-4">
				        <label for="tipoDocumento">Tipo de Documento</label>
				        <select name="tipoDocumento" id="tipoDocumento" class="custom-select d-block w-100"  required>
				        <option value="">Elige...</option>
				        <option>Documento Nacional de Identidad</option>
				        <option>Pasaporte</option>
				        <option>Libreta de Enrolamiento</option>
				        <option>Libreta Civica</option>
				       	</select>
					        <div class="invalid-feedback">
					              Por favor seleccione un tipo de Documento.
					        </div>
				        </div>
			        </div>
			        
		        	<div class="col-md-6 mb-3">
			      		<label for="legajo">Nuemro de Documento</label>
				        <input  name="documento" type="text" class="form-control" id="documento" required pattern="[0-9 ]{4,20}" required
				        	title = "El Tamaño minimo es de 4 y el maximo de 20 digitos">
					        <div class="invalid-feedback">
					        	Por favor ingrese un Numero de Documento valido.
					        </div>
			        </div>
		        </div>
		        
          		
		        

		        
	      		<div class="mb-3">
	      		<label for="email">Email</label>
		        <input name="email" type="email" class="form-control" id="email" placeholder="you@example.com" maxlength="30" required
		        	title = "El Tamaño minimo es de 10 y el maximo de 30">
			        <div class="invalid-feedback">
			        	Por favor ingrese un email valido.
			        </div>
		        </div>

       			<div class="mb-3">
	      		<label for="telefono">Telefono</label>
		        <input name="telefono" type="tel" class="form-control" id="telefono" required pattern="[0-9 ]{7,20}" required
		        	title = "El Tamaño minimo es de 7 y el maximo de 20 digitos">
			        <div class="invalid-feedback">
			            Por favor ingrese un telefono valido.
			        </div>
		        </div>
		        
		        <div class="mb-4">
		        <label for="carrera">Carrera</label>
		        <select name="Carrera" id="Carrera" class="custom-select d-block w-100" id="carrera" required required>
		        <option value="">Elige...</option>
		        <option>Ingenieria Mecanica</option>
		        <option>Ingenieria Electrica</option>
		        <option>Ingenieria en Sistemas de Informacio</option>
		        <option>Ingenieria Civil</option>
		        <option>Ingenieria Qumica</option>
		       	</select>
			        <div class="invalid-feedback">
			              Por favor seleccione una carrera.
			        </div>
		        </div>
		        
		        <hr class="mb-4">
		        
		        <div class="row">
			        <div class="col-md-6 mb-3">
		      		<label for="direccion">Direccion</label>
			        <input name="direccion" type="text" class="form-control" id="direccion" required pattern="[A-Za-z ]{4,20}" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				            Por favor ingrese una direccion valido.
				        </div>
			        </div>
			        
			        <div class="col-md-3 mb-3">
		      		<label for="numero">Numero</label>
			        <input name="numero" type="number" class="form-control" id="numero" maxlength="5" required
			        	title = "El Tamaño minimo es de 1 y el maximo de 5 digitos">
				        <div class="invalid-feedback">
				            Por favor ingrese un numero valido.
				        </div>
			        </div>
		        </div>
		        
		        <div class="row">
		        	<div class="col-md-3 mb-3"> 
		      		<label for="piso">Piso <span class="text-muted">(Opcional)</span></label>
			        <input name="piso" type="number" class="form-control" id="piso" maxlength="5"
			        	title = "El Tamaño minimo es de 1 y el maximo de 5 digitos">
				        <div class="invalid-feedback">
				            Por favor ingrese un piso valido.
				        </div>
			        </div>
			        
			        <div class="col-md-3 mb-3"> 
		      		<label for="departamento">Depto <span class="text-muted">(Opcional)</span></label>
			        <input name="departamento" type="text" class="form-control" id="departamento" maxlength="3"
			        	title = "El Tamaño minimo es de 1 y el maximo de 5">
				        <div class="invalid-feedback">
				            Por favor ingrese un departamento valido.
				        </div>
			        </div>
		        </div>
		        
	        
				<hr class="mb-4">
		        
		        <div class="form-row">
			        <div class="col-md-6 mb-3">
		      		<label for="contraseña">Contraseña</label>
			        <input name="contraseña" type="password" class="form-control" id="contraseña" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				            Por favor ingrese una contraseña valido.
				        </div>
			        </div>
			        
			        <div class="col-md-6 mb-3">
		      		<label for="contraseña02">Repetir Contraseña</label>
			        <input name="contraseña02" type="password" class="form-control" id="contraseña02" required
			        	title = "El Tamaño minimo es de 4 y el maximo de 20">
				        <div class="invalid-feedback">
				            Por favor ingrese una contraseña valido.
				        </div>
			        </div>
          		</div>
          		
          		
          		
          		 
				  
  			
  		</div>
  		
  		<hr class="mb-4">
  		
  		<div class="row justify-content-center">
    		<div class="col-7">
	        <button class="btn btn-primary btn-lg btn-block" data-target="#Registrar" type="submit" data-toggle="modal">Registrar Alumno</button>  
	        <p class="text-center">¿Ya tienes una cuenta? <a href="Login.jsp">Ingresa aqui</a></p>   
	        </div>
        </div>
		
		</form>
	</div>
	

	

	

	<hr class="mb-4">
	<div id="footer"></div>
</body>
</html>