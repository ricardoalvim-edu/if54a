<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="curso" class="org.coursera.Model.ModelCursos"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Todos os cursos - Coursera</title>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body style="margin: 0px auto; text-align: center">
        <h1>Todos os cursos</h1>
        <c:forEach var="cursos" items="${curso.cursos()}">
            <div class='boxConteudo'>
                <div class='imgBox' style="background-image: url('${cursos.urlImagem}')"> </div>
                <a href="VerCurso.jsp?id=${cursos.idCursos}" class="titleCourse">${cursos.nome}</a>
                <p class='universityText'>${cursos.uni}</p>
            </div>
        </c:forEach>
    </body>
</html>