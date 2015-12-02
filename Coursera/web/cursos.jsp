<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="app">
    <head>
        <title>Todos os cursos - Coursera</title>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body style="margin: 0px auto; text-align: center" ng-controller='CursosController'>
        <h1>Todos os cursos</h1>
            <div class="box">
                <div ng-repeat='curso in cursos.listaCursos'>
                    <div class='boxConteudo'>
                        <div class='imgBox' style="background-image: url({{ curso.img }})"> </div>
                        <a href="VerCurso.jsp?id={{ curso.id }}" class="titleCourse">{{ curso.nome }}</a>
                        <p class='universityText'>{{ curso.uni }}</p>
                    </div>
                </div>
            </div>
        <script src="js/app.js"></script>
        <script src="js/MainController.js"></script>
        <script src="js/cursos.js"></script>
    </body>
</html>