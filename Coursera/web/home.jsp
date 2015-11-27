<%-- 
    Document   : home
    Created on : 24/11/2015, 19:33:45
    Author     : ricar
--%>

<%@page import="org.coursera.Model.ModelCursos"%>
<%@page import="org.coursera.Model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Coursera</title>
        <jsp:include page="head.jsp"/>
        <script>
            function showHint(str) {
                
                if (str.length == 0) {                    
                    document.getElementById("searchArea").innerHTML = "";
                    return;
                } else {
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            document.getElementById("searchArea").innerHTML = xmlhttp.responseText;
                        }
                    };
                    xmlhttp.open("GET", "pesquisar.jsp?q=" + str, true);
                    xmlhttp.send();
                }
            }
        </script>
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
        <div id="searchArea" style="width: 90%; text-align: center; height: 300px; margin-top: 2%;">
            <span id="pesquisaArea"></span>
        </div>
        <div class='areaEspecializacao'>
            <h1>Novas especializações</h1>
            <div class='box'>
                <jsp:include page="cursos.jsp"/>
            </div>
        </div>
    </body>
</html>
