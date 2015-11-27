<%-- 
    Document   : header
    Created on : 24/11/2015, 19:14:42
    Author     : ricar
--%>
<%@page contentType="text/html"  pageEncoding="UTF-8" %>

<h1 class="logo">
</h1>
<input type="checkbox"  id="control-nav"  style="display: none;"/>
<label for="control-nav" class="control-nav"></label>
<label for="control-nav"   class="control-nav-close"></label>
<nav class="fR">
    <span class="l2">
        <% if (request.getSession().getAttribute("logado") == null) { %>
        <a href="${pageContext.request.contextPath}/CadastroUsuario.jsp" class="menuItem cadastrar">Cadastre-se</a>
        <a href="${pageContext.request.contextPath}/Login.jsp" class="menuItem">Entrar</a> <a href='home.jsp' class='menuItem'>Página Inicial</a>
        <% } else {
            String tipo_usr = (String) request.getSession().getAttribute("tipo_usr");
            String usuario = (String) request.getSession().getAttribute("usr");
            if (tipo_usr.equals("normal")) {
        %>
            <span class='menuItem user'>Olá <%=usuario%>.</span> 
            <a href="${pageContext.request.contextPath}/Logout" class="menuItem cadastrar">Sair</a> 
            <a href='${pageContext.request.contextPath}/home.jsp' class='menuItem'>Página Inicial</a>
        <% } else if (tipo_usr.equals("administrativo")) {%>
        <span class='menuItem user'>Olá <%=usuario%>.</span>
        <a href="${pageContext.request.contextPath}/Logout" class="menuItem cadastrar">Sair</a> 
        <a href="${pageContext.request.contextPath}/Administrativo/cadastroCurso.jsp" class="menuItem">Cadastrar Cursos</a> 
        <a href="${pageContext.request.contextPath}/Administrativo/todosUsuarios.jsp" class="menuItem">Lista de usuarios</a>
        <a href='${pageContext.request.contextPath}/home.jsp' class='menuItem'>Página Inicial</a>
        <% }
            }%>
    </span>
</nav>
