<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<h1>Connexion</h1>
	
	${ error }
	
	<form method="POST">
		<div>
			<label>Nom d'utilisateur</label>
			<input type="text" name="username" />
		</div>
		
		<div>
			<label>Mot de passe</label>
			<input type="password" name="password" />
		</div>
		
		<input type="submit" value="Envoyer" />
	</form>
</body>
</html>