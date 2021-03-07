<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <title>Login - UTN</title>
	    <link rel="shortcut icon" type="image/png" href="pngs/login.png">
	    
	    
		<!-- Bootstrap core CSS -->
		<link href="Styles/bootstrap.min.css" rel="stylesheet">
		
		<!-- Icons -->
		<script src="https://kit.fontawesome.com/1baa4ceec0.js"></script>
		
		<!-- JS -->
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="JavaScripts/bootstrap.min.js"></script>
		
		<!-- Customs CSS -->
		<link href="Styles/floating-labels.css" rel="stylesheet">
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
	   
		
	</head>
	
	<body >
		<form class = "form-signin" id="myForm" name="myForm" action="Login" method="post">
			<div class="text-center mb-4">
				<img class="mb-4" src="pngs/login.png" height="150" width="150">
				<h1 class="h3 mb-3 font-weight-normal">Login UTN</h1>
				<p> Sistema de autogestión de la Universidad Tecnológica Nacional - Facultad Regional Rosario</p>
			</div>
			
			<div class="form-label-group">
				<input name="user"  type = "text" class="form-control" placeholder = "Legajo" required pattern="[0-9 ]{4,10}" required
				        	title = "El Tamaño minimo es de 4 y el maximo de 10 digitos" autofocus autocomplete="on"/>
				<label for="user">Legajo</label>
			</div>

			
			
			<div class="form-label-group">
				<input name="password" type="password" class="form-control" placeholder = "Contraseña" maxlength="20" required
				        	title = "El Tamaño minimo es de 4 y el maximo de 20"/>
				<label for="password">Contraseña</label>
			</div>

		
		    
			<input type = "submit" value = "Login" class="btn btn-lg btn-primary btn-block">
			<div class="text-center mb-4">
			<p>¿No tienes cuenta? <a href="NewAlumnos.jsp">Registrate aqui</a>
			</div>
		</form>
	</body>
</html>