<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un produit</title>
</head>
<body>
	<h1>Ajouter un produit</h1>
	
	<form method="POST">
		<div>
			<label for="nom">Nom</label>
			<input type="text" id="nom" name="nom" value="${ produit.nom }" />
			<div>${ erreurs.getFieldError("nom").defaultMessage }</div>
		</div>
		
		<div>
			<label>Prix</label>
			<input type="number" step="0.1" name="prix" value="${ produit.prix }" required />
			<div>${ erreurs.getFieldError("prix").defaultMessage }</div>
		</div>
		
		<div>
			<input type="submit" value="OK" />
		</div>
	</form>
</body>
</html>