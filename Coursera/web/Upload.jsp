<%-- 
    Document   : Upload
    Created on : 02/12/2015, 23:32:00
    Author     : ricar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
        <script src="https://raw.github.com/enyo/dropzone/master/dist/dropzone.js"></script>
    </header>
    <body>
        <h1>Faça upload da imagem do seu curso!</h1>
        <div class='formCadastro'>
        <form action="${pageContext.request.contextPath}/UploadImagens" method="post" enctype="multipart/form-data" class="dropzone"
      id="my-awesome-dropzone">
            <input type="file" name="file" />
            <button type='submit'>Salvar</button>
            <br>
        </form>
    </body>
</html>
