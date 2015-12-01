<%@page import="org.coursera.Model.ModelCursos"%>
<%@page import="org.coursera.Model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Coursera</title>
        <jsp:include page="head.jsp"/>
        <script src ="js/busca.js"></script>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body>
        <div class="searchCourses">
            <p class="textSearch">Faça os melhores cursos online!</p>
            <input type="text" placeholder="O que você gostaria de aprender?" class="searcherCourses" onKeyUp="showHint(this.value)"/>
            <br>
            <div class="textViewMore">
                <span>ou <a href="#" class="viewMoreLink">ver lista de cursos.</a></span>
                <div class="controlInfo">
                    <ul>
                        <li class="textInfo">
                            <b> <%= ModelUsuario.tamanhoUsuario()%> </b> Alunos
                        </li>
                        <li class="textInfo">
                            <b><%= ModelCursos.tamanhoCurso()%></b> Cursos 
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class='areaEspecializacao' id="searchArea">
            <h1>Novas especializações</h1>
            <div class='box'>
                <jsp:include page="cursos.jsp"/>
            </div>
        </div>
    </body>
</html>
