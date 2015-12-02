<%@page import="org.coursera.Model.ModelCursos"%>
<%@page import="org.coursera.Entity.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="curso" class="org.coursera.Model.ModelCursos"/>
<!DOCTYPE html>
<html>
    <% String id = request.getParameter("id");
        Curso c = ModelCursos.cursoPorId(id);%>
    <head>
        <title>Todos os cursos - Coursera</title>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body>
        <h1 class='courseName'><%=c.getNome()%></h1>
        <h2 class='courseUni'><%=c.getUni()%></h2>
        <p class='descCourse'><%=c.getDescricao()%></h2>
        <iframe style='margin-top: -10%; margin-left: 51%;' 
                width='420' 
                height='315' src='https://www.youtube.com/embed/<%=c.getYoutubeLink()%>'>
        </iframe>
</body>
</html>