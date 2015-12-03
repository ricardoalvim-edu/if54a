<%-- 
    Document   : ViewTodosCursos
    Created on : 03/12/2015, 00:29:43
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html ng-app="app" lang="pt-br">
<script src="${pageContext.request.contextPath}/js/angular.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/style/loading-bar.css' type='text/css' media='all' />
<script type='text/javascript' src='${pageContext.request.contextPath}/js/loading-bar.js'></script>

<h1>Todos os cursos</h1>
<div class="box">
    <div ng-repeat='curso in cursos.listaCursos'>
        <div class='boxConteudo'>
            <div class='imgBox' style="background-image: url('${pageContext.request.contextPath}/img/{{ curso.img}}')"> </div>
            <a href="VerCurso.jsp?id={{ curso.id}}" class="titleCourse">{{ curso.nome}}</a>
            <p class='universityText'>{{ curso.uni}}</p>
        </div>
    </div>
</div>
<script src="js/app.js"></script>
<script src="js/MainController.js"></script>
<script src="js/cursos.js"></script>
</html>