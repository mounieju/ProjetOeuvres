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
            <label class="control-label col-sm-2" for="user"> Username : </label>
            <div class="col-sm-10">
                <INPUT type="text" class="form-control" name="username" required placeholder="Type your LAST NAME" id="user">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password : </label>
            <div class="col-sm-10">
                <INPUT type="password" class="form-control" name="password" required placeholder="Type your FIRST NAME" id="pwd">
            </div>
        </div>
        <button type="submit" name="bt" class="btn btn-default text-center">Login</button>
        <button type="reset" name="bt" class="btn btn-default text-center">RAZ</button>
    </form>
</body>
</html>
