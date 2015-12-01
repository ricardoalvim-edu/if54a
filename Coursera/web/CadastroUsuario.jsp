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
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
        <script type="text/javascript">
            function getEndereco() {
                // Se o campo CEP não estiver vazio
                if ($.trim($("#cep").val()) != "") {
                    /*
                     Para conectar no serviço e executar o json, precisamos usar a função
                     getScript do jQuery, o getScript e o dataType:"jsonp" conseguem fazer o cross-domain, os outros
                     dataTypes não possibilitam esta interação entre domínios diferentes
                     Estou chamando a url do serviço passando o parâmetro "formato=javascript" e o CEP digitado no formulário
                     http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#cep").val()
                     */
                    $.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep=" + $("#cep").val(), function () {
                        // o getScript dá um eval no script, então é só ler!
                        //Se o resultado for igual a 1

                        if (resultadoCEP["tipo_logradouro"] != '') {
                            if (resultadoCEP["resultado"]) {
                                // troca o valor dos elementos
                                $("#logradouro").val(unescape(resultadoCEP["tipo_logradouro"]) + " " + unescape(resultadoCEP["logradouro"]));
                                $("#bairro").val(unescape(resultadoCEP["bairro"]));
                                $("#cidade").val(unescape(resultadoCEP["cidade"]));
                                $("#estado").val(unescape(resultadoCEP["uf"]));
                                $("#numero").focus();
                            }
                        }
                    });
                }
            }
        </script>
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
                <input type="text" name="cep" placeholder='CEP' id="cep" class="inputs" onblur="getEndereco()"/>
                <br/>
                <input type="text" id="logradouro" placeholder="Logradouro"/>
                <br/>
                <input type="text" id="bairro" placeholder='Bairro'/>
                <br/>
                <input type="text" id="cidade" placeholder="Cidade"/>
                <br/>
                <input type="text" id="estado" placeholder="Unidade Federativa"/>
                <br/>
                <button type='submit'>Cadastre-se</button>
            </form>
        </div>
    </body>
</html>
