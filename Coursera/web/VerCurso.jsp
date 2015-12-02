<%@page import="org.coursera.Model.ModelCursos"%>
<%@page import="org.coursera.Entity.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="app" lang="pt-br">
    <% String id = request.getParameter("id");
        Curso c = ModelCursos.cursoPorId(id);%>
    <head>
        <title>Todos os cursos - Coursera</title>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body ng-controller="VerCursoController">
        <h1 class='courseName'><%=c.getNome()%></h1>
        <h2 class='courseUni'><%=c.getUni()%></h2>
        <p class='descCourse' style="width: 40%;"><%=c.getDescricao()%></p>
        <iframe style='margin-top: -10%; margin-left: 51%;' 
                width='420' 
                height='315' src='https://www.youtube.com/embed/<%=c.getYoutubeLink()%>'>
        </iframe>
        <script src="js/app.js"></script>
        <script src="js/MainController.js"></script>
        <script src="js/ngprogress.min.js"></script>
    </body>
</html>