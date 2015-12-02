<%@page import="java.util.ArrayList"%>
<%@page import="org.coursera.Model.ModelCursos"%>
<%@page import="org.coursera.Entity.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="curso" class="org.coursera.Model.ModelCursos"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h1 style="text-align: center">Pesquisa por ${param.q}</h1>
        <c:forEach var="cursos" items="${curso.cursoPorNome(param.q)}">
            <div class='boxConteudo'>
                <div class='imgBox' style="background-image: url('${cursos.urlImagem}')"> </div>
                <a href="VerCurso.jsp?id=${cursos.idCursos}" class="titleCourse">${cursos.nome}</a>
                <p class='universityText'>${cursos.uni}</p>
            </div> 
        </c:forEach> 
    </body>
</html>
