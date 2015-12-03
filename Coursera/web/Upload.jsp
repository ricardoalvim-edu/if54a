<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <title>Upload</title>
        <jsp:include page="head.jsp"/>
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body>
        <h1>Faça upload da imagem do seu curso!</h1>
        <div class='formCadastro'>
        <form action="${pageContext.request.contextPath}/UploadImagens" method="post" enctype="multipart/form-data">
            <input type="file" name="file" />
            <button type='submit'>Salvar</button>
            <br>
        </form>
    </body>
</html>
