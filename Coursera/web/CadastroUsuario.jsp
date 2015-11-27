<%-- 
    Document   : CadastroUsuario
    Created on : 24/11/2015, 20:09:21
    Author     : ricar
--%>

<%@page import="org.coursera.Model.ModelUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar-se - Coursera</title>
        <jsp:include page="head.jsp"/>        
    </head>
    <header>
        <jsp:include page="header.jsp"/>
    </header>
    <body>
        <h1 class='logo logoCadastro'></h1>
        <p class='textCadastro'>
            <% if (ModelUsuario.primeiroUsuario()) { %>
            <span>Bem vindo! Cadastre o primeiro usuario administrativo para inicar o Coursera.</span>
            <% } else { %>
            <span>Acesso global à melhor educação do mundo!</span>
            <% }%>
        </p>
        <div class='formCadastro'>
            <form action='./CadastroUsuarioServlet' method='post' accept-charset='utf-8'>
                <br>
                <input type='text' placeholder='Usuario' name='usr'/>
                <br>
                <input type='email' placeholder='Email' name='mail'/>
                <br>
                <input type='password' placeholder='Senha' name='senha'/>
                <br>
                <button type='submit'>Cadastre-se</button>
            </form>
        </div>
    </body>
</html>
