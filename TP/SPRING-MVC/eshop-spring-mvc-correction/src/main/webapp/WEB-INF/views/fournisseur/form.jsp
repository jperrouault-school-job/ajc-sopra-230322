<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un fournisseur</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Ajouter un fournisseur</h1>
		
		<c:if test="${ erreurs.hasErrors() }">
			<div class="alert alert-danger">
				<ul>
					<c:forEach var="err" items="${ erreurs.allErrors }">
						<li>${ err.defaultMessage }</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		
		<form method="POST">
			<div>
				<label>Nom</label>
				<input type="text" class="form-control" name="nom" value="${ fournisseur.nom }" />
			</div>
			
			<div>
				<label>Responsable</label>
				<input type="text" class="form-control" name="responsable" value="${ fournisseur.responsable }" />
			</div>
			
			<div>
				<input type="submit" value="OK" class="btn btn-success" />
			</div>
		</form>
	</div>
</body>
</html>