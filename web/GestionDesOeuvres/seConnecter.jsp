<%--
  Created by IntelliJ IDEA.
  User: Nejko
  Date: 11-Mar-18
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/myCSS.css"/>
    <script src="../js/bootstrap.min.js"></script>
    <title>Connexion</title>
</head>
<body>
    <H2 class="text-center"> Connexion </H2>
    <br/>
    <form class="form-horizontal" name='connexion' method="post" action="Controleur?action=seConnecter">
        <div class="form-group">
            <label class="control-label col-sm-2" for="user"> Identifiant : </label>
            <div class="col-sm-10">
                <INPUT type="text" class="form-control" name="username" required placeholder="Tapez votre NOM" id="user">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Mot de passe : </label>
            <div class="col-sm-10">
                <INPUT type="password" class="form-control" name="password" required placeholder="Tapez votre PRENOM" id="pwd">
            </div>
        </div>
        <button type="submit" name="bt" class="btn btn-default text-center">Se connecter</button>
        <button type="reset" name="bt" class="btn btn-default text-center">RAZ</button>
    </form>
</body>
</html>
