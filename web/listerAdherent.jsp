<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/myCSS.css">
	<script src="../js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Affichage de tous les adhérents</title>
</head>
<body>
	<P><A href="index.jsp">Retour accueil</A></P>
	<h2 class="text-center"> Listing des Adhérents </h2>

	<TABLE BORDER="1" class="table table-responsive table-hover borderless">
		<thead class="thead-light"><TR>
			<TH scope="col">Numero</TH>
			<TH scope="col">Nom</TH>
			<TH scope="col">Prénom</TH>
			<TH scope="col">Ville</TH>

		</TR></thead>
		<tbody>
		<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td scope="row">${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
			</tr>
		</c:forEach>
		</tbody>
	</TABLE>
</body>
</html>