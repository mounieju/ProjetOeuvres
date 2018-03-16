<%--
  Created by IntelliJ IDEA.
  User: Nejko
  Date: 11-Mar-18
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li><a href="Controleur?action=home">Accueil</a></li>
            <li><a href="Controleur?action=ajouterOeuvre">Ajouter une oeuvre</a></li>
            <li><a href="Controleur?action=listerOeuvre">Consulter le catalogue</a></li>
            <li><a href="Controleur?action=gererReservations">Confirmer les réservations</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="Controleur?action=seDeconnecter"><span class="glyphicon glyphicon-log-out"></span> Se déconnecter</a></li>
        </ul>
    </div>
</nav>

<script type="application/javascript">
    // TODO: Add active class to the current li (highlight it)
</script>