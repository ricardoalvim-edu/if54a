<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - Coursera</title>
        <jsp:include page="head.jsp"/>
        <script src="js/busca.js"></script>
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
                <span>ou <a href="cursos.jsp" class="viewMoreLink">ver lista de cursos.</a></span>
                <div class="controlInfo" ng-controller='HomeController'>
                    <ul>
                        <li class="textInfo">
                            <b> {{ dadoshome.numero_usuarios}} </b> Alunos
                        </li>
                        <li class="textInfo">
                            <b> {{ dadoshome.numero_cursos}} </b> Cursos 
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class='areaEspecializacao' id="searchArea">
        </div>
        <script src="js/app.js"></script>
        <script src="js/MainController.js"></script>
        <script src="js/dadoshome.js"></script>
        <script src="js/loading-bar.js"></script>
    </body>
</html>
