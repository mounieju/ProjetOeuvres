<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nejko
  Date: 12-Mar-18
  Time: 12:58 PM
  To change this template use File | Settings | File Templates.
  TODO : ajouter sécurité pour la connexion (renvoyer à seConnecter.jsp si non connecté)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/myCSS.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Ajouter oeuvre</title>
</head>
<body>
<h2 class="text-center">Gestion des oeuvres</h2>
<br/>
<jsp:include page="menu.jsp"/>
<br/>
<H3 class="text-center"> Ajout d'une oeuvre </H3>
<DIV>
    <FORM class="form-horizontal" name='identification' method="post" action="Controleur?action=insererOeuvre">
        <div class="form-group">
            <label class="control-label col-sm-2" for="titre"> Titre de l'oeuvre : </label>
            <div class="col-sm-10">
                <INPUT type="text" class="form-control" name="txttitre" id="titre">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="prix">Prix : </label>
            <div class="col-sm-10">
                <INPUT type="number" step="0.01" min="0" class="form-control" name="txtprix" id="prix">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="propietaire">Propriétaire :</label>
            <div class="col-sm-10">
                <select class="form-control" name="txtpropietaire" id="propietaire">
                    <option selected disabled hidden>Nom propriétaire</option>
                    <c:forEach items="${proprietaires}" var="item">
                        <option id="${item.idProprietaire}">${item.nomProprietaire}</option>
                    </c:forEach>
                </select>

            </div>
        </div>
        <button type="submit" name="bt" class="btn btn-default">Ajouter</button>
        <button type="reset" name="bt" class="btn btn-default">RAZ</button>
    </FORM>
</DIV>
</body>
</html>
