<%-- 
    Document   : Login
    Created on : 24/11/2015, 20:02:46
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Coursera</title>
        <jsp:include page="head.jsp"/>
        <script src= "http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>  
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body>
        <h1 class='logo logoCadastro'></h1>
        <p class='textCadastro'>Acesso global à melhor educação do mundo!</p>
        <div class='formCadastro formLogin'>
            <form action='LoginServlet' method='post' ng-app="myApp" ng-controller="validateCtrl" novalidate>
                <br>
                <input type='email' placeholder='Email' name='mail'/>
                <br>
                <input type='password' placeholder='Senha' name='senha'/>
                <br>
                <button type='submit'>Entre</button>
            </form>
        </div>
    </body>
</html>
</body>
</html>
