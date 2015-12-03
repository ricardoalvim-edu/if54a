<%@page import="org.coursera.Entity.Usuario"%>
<%@page import="org.coursera.Model.ModelUsuario"%>
<%@page import="org.coursera.Model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="app">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos usuários - Coursera</title>
        <jsp:include page="../head.jsp"/>
    </head>
    <header>
        <jsp:include page="../header.jsp"/>
    </header>
    <body>
        <div class='boxConteudoUsuarios'>
        <% for (Usuario u : ModelUsuario.todosUsuarios()) { %>
            <div class='boxConteudo'>
                <p>Usuario: <%= u.getUsuario()%></p>
                <p>E-mail: <%=u.getEmail() %></p>
                <p>Tipo de acesso: <%=u.getTipo_usr() %></p>
            </div>
         <% } %>
        </div>
    </body>
</html>
