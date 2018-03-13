<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Liste oeuvre</title></head>
<body class="margin">

<H2 class="text-center"> Gestion des oeuvres </H2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Catalogue des oeuvres </H3>
<div>
    <TABLE BORDER="1" class="table table-responsive table-hover">
       <thead class="thead-light"> <TR>
            <TH scope="col">Titre</TH>
            <TH scope="col">Prix</TH>
            <TH scope="col">Prénom propriétaire</TH>
            <TH scope="col">Nom propriétaire</TH>
            <TH scope="col">Réserver/Modifier</TH>
        </TR></thead>
        <tbody>
        <c:forEach items="${mesOeuvres}" var="item">
            <tr>
                <td scope="row">${item.titreOeuvrevente}</td>
                <td>${item.prixOeuvrevente}</td>
                <td>${item.proprietaire.getNomProprietaire()}</td>
                <td>${item.proprietaire.getPrenomProprietaire()}</td>
                <td>
                    <button type="button" class="btn btn-info ${(item.etatOeuvrevente=="L")? "active":"disabled"}">Réserver</button>
                    <button type="button" class="btn btn-warning">Modifier</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </TABLE>
</div>

</body>
</html>
