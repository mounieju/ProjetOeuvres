<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/myCSS.css">
    <script src="../js/bootstrap.min.js"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter un adhérent</title>
</head>
<SCRIPT language="Javascript" type="text/javascript">
    <script type = "text/javascript" src = "js/foncControle.js"></script>


<body>
<P><A href="index.jsp">Retour accueil</A></P>
<H2 class="text-center"> Ajout d'un adhérent </H2>
<br/>
    <FORM name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
        <div class="form-group">
            <label for="nom"> Nom de l'adhérent : </label>
            <INPUT type="text" class="form-control" name="txtnom" value="" id="nom">
        </div>
        <div class="form-group">
            <label for="prenom">Prénom de l'adhérent : </label>
            <INPUT type="text" class="form-control" name="txtprenom" id="prenom">
        </div>
        <div class="form-group">
            <label for="ville">Ville de l'adherent :</label>
            <INPUT type="text" class="form-control" name="txtville" id="ville">
        </div>
        <!-- Boutons Ajouter -->
        <button type="submit" name="bt" class="btn btn-default">Ajouter</button>
    </FORM>
</body>
</html>