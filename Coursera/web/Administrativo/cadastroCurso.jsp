<%-- 
    Document   : cadastroCurso
    Created on : 24/11/2015, 21:23:06
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app" lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de curso - Coursera</title>
        <jsp:include page="../head.jsp"/>
    </head>
    <header>
        <script src="https://raw.github.com/enyo/dropzone/master/dist/dropzone.js"></script>
        <jsp:include page="../header.jsp"/>
    </header>
    <body>
        <h1 class='logo logoCadastro'></h1>
        <p class='textCadastro'>Acesso global à melhor educação do mundo!</p>\
        <div class='formCadastro'>
            <form action='${pageContext.request.contextPath}/CadastroCursosServlet' method='post' accept-charset='utf-8' class="dropzone"
      id="my-awesome-dropzone">
                <br>
                <input type='text' placeholder='Nome do curso' name='nome'/>
                <br>
                <input type='text' placeholder='Descrição' name='desc'/>
                <br>
                <input type='text' placeholder='Imagem (use um link direto! exemplo: http://i.imgur.com/rAooG7D.jpg)' name='urlImage'/>
                <br>
                <input type='text' placeholder='Universidade' name='uni'/>
                <br>
                <input type='text' placeholder='YouTube (insira apenas o ID. exemplo: cH8Vl62qEjE)' name='youtube'/>
                <br>
                <input type="file" name="file" />
                <br>
                <button type='submit'>Salvar</button>
                <p style="text-align: center;">Exemplos: http://i.imgur.com/rAooG7D.jpg - cH8Vl62qEjE</p>
            </form>
    </body>    
</html>
