<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="curso" class="org.coursera.Model.ModelCursos"/>
<!DOCTYPE html>
<html>
    <body>
    <c:forEach var="cursos" items="${curso.cursos()}">
        <div class='boxConteudo'>
            <div class='imgBox' style="background-image: url('${cursos.urlImagem}')"> </div>
            <a href="VerCurso?id=${cursos.idCursos}" class="titleCourse">${cursos.nome}</a>
            <p class='universityText'>${cursos.uni}</p>
        </div>
    </c:forEach>
</body>
</html>