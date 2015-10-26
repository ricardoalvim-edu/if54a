package org.coursera.Model;

import javax.servlet.http.HttpServletRequest;
import org.coursera.Entity.Curso;

public class HTML {
    public static String head(String titulo) {
        return "<html>\n" +
               "  <head>\n" +
               "    <meta charset=\"utf-8\"/>\n" +
               "    <title> " + titulo + " </title>\n" +
               "    <link rel=\"stylesheet\" href=\"style/estilo.css\"/>\n" +
               "    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>\n" +
               "    <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1, maximum-scale=1\"/>\n" +
               "    <link rel=\"icon\" type=\"image/png\" href=\"img/icon.png\">\n" +
               "  </head>";
    }
    public static String bodyFinal() {
        return "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";            
    }
    
    public static String bodyInicio(HttpServletRequest request) {
        String logadoHeader = "";
        if (request.getSession().getAttribute("logado") == null) {
            logadoHeader = "<a href=\"CadastroUsuario\" class=\"menuItem cadastrar\">Cadastre-se</a>\n" +
"      <a href=\"Login\" class=\"menuItem\">Entrar</a> <a href='index' class='menuItem'>Página Inicial</a>\n";        
        } else {
            String tipo_usr = (String) request.getSession().getAttribute("tipo_usr");
            String usuario = (String) request.getSession().getAttribute("usr");
            if (tipo_usr.equals("normal")) {
                logadoHeader = "<p class='menuItem user'>Olá " + usuario + ".</p> <a href=\"Logout\" class=\"menuItem cadastrar\">Sair</a> <a href='index' class='menuItem'>Página Inicial</a> ";
            } else if (tipo_usr.equals("administrativo")){
                logadoHeader = "<p class='menuItem user'>Olá " + usuario + ".</p> <a href=\"Logout\" class=\"menuItem cadastrar\">Sair</a> <a href=\"CadastroCursos\" class=\"menuItem\">Cadastrar Cursos</a> <a href='index' class='menuItem'>Página Inicial</a> ";
            }       
        }
        String header = "<header>\n" +
                        "    <h1 class=\"logo\">\n" +
                        "    </h1>\n" +
                        "    <input type=\"checkbox\" id=\"control-nav\" style=\"display: none;\"/>\n" +
                        "    <label for=\"control-nav\" class=\"control-nav\"></label>\n" +
                        "    <label for=\"control-nav\" class=\"control-nav-close\"></label>\n" +
                        "    <nav class=\"fR\">\n" +
                        "    <ul class=\"l2\">\n" + logadoHeader +                   
                        "    </ul>\n" +
                        "  </nav>\n" +
                        "  </header>";
        return header;
    }
    
    public static String bodyMeio(){
        String body1 = "<body>\n" +
               "    <div class=\"searchCourses\">\n" +
               "      <p class=\"textSearch\">Faça os melhores cursos online!</p>\n" +
               "      <div class=\"controlInfo\">\n" +
               "        <ul>\n" +
               "          <li class=\"textInfo\"><b> " + ModelUsuario.tamanhoUsuario() + "</b> Alunos</li>\n" +
               "          <li class=\"textInfo\">- <b>" + ModelCursos.tamanhoCurso() +"</b> Cursos </li>\n" +
               "        </ul>\n" +
               "      </div>\n" +
               "    </div>" +
               "<div class='areaEspecializacao'>\n" +
               "<h1>Novas especializações</h1>\n" +
               "<div class='box'>\n";
        return body1;
    }
    
    public static StringBuilder bodyMeio2() {
        String body3 = "";
        StringBuilder buf = new StringBuilder();
        StringBuilder body = new StringBuilder();
        if (ModelCursos.tamanhoCurso() != 0){
            for (Curso c : ModelCursos.cursos()){
                body3 = "\n<div class='boxConteudo'>\n" +
                                "<div class='imgBox' style=\"background-image: "
                        + "url('"+ c.getUrlImagem() +"') \"> </div>\n" +
                        "<a href=VerCurso?id=" + c.getIdCursos() +" class=\"titleCourse\">"+ c.getNome() +"</a>\n" +
                        "<p class='universityText'>"+ c.getUni() + "</p>" +
                        "</div>";
                buf.append(body3);
            }
            body = buf;
        } else {
            body3 = "<h2 style='text-align: center'>Não há cursos cadastrados ainda :(</h2>";
            body = body.append(body3);
        }
        return body;
    }
    
    public static String bodyCurso(String id){
        Curso c = ModelCursos.cursoPorId(id);
        String body = "<h1 class='courseName' >" + c.getNome() + "</h1>\n" +
                      "<h2 class='courseUni'>" + c.getUni() + "</h2>\n" +
                      "<p class='descCourse'>" + c.getDescricao() + "</h2>\n" +
                      "<iframe style='margin-top: -10%; margin-left: 51%;' width=\"420\" height=\"315\"\n" +
                "src=\'"+ c.getYoutubeLink()+"'>\n" +
        "</iframe>";
        return body;
    }
    
    public static StringBuilder aviso(String mensagem, HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        String erro = "<p><center>" + mensagem + "</p></center>"; 
        builder.append(head("Erro - Coursera")).append(bodyInicio(request)).append(erro).append(bodyFinal());
        return builder;
    }
    
    public static String bodyCadastroCurso() {
        return "<body>\n" +
               "<h1 class='logo logoCadastro'></h1>\n" +
               "<p class='textCadastro'>Acesso global à melhor educação do mundo!</p>\n" +
               "<div class='formCadastro'>\n" +
               "<form action='./CadastroCursosServlet' method='post' accept-charset='utf-8'>\n" +
               "<br>\n" +
               "<input type='text' placeholder='Nome do curso' name='nome'/>\n" +
               "<br>\n" +
               "<input type='text' placeholder='Descrição' name='desc'/>\n" +
               "<br>\n" +
               "<input type='text' placeholder='Imagem' name='urlImage'/>\n" +
               "<br>\n" +
               "<input type='text' placeholder='Universidade' name='uni'/>\n" +
               "<br>\n" +
               "<input type='text' placeholder='YouTube' name='youtube'/>\n" +
               "<br>\n" +
               "<button type='submit'>Salvar</button>\n" +
               "</form>\n" +
               "</div>\n" +
               "</body>\n" +
               "</html>";
    }
    
    public static String bodyCadastroUsuario() {
        String msg2 = "";
        if (ModelUsuario.primeiroUsuario()) {
            msg2 = "Bem vindo! Cadastre o primeiro usuario administrativo para inicar o Coursera.";
        } else {
            msg2 = "Acesso global à melhor educação do mundo!";
        }
        String msg = "<body>\n" +
               "<h1 class='logo logoCadastro'></h1>\n" +
               "<p class='textCadastro'>" + msg2 + "</p>\n" +
               "<div class='formCadastro'>\n" +
               "<form action='./CadastroUsuarioServlet' method='post' accept-charset='utf-8'>\n" +
               "<br>\n" +
               "<input type='text' placeholder='Usuario' name='usr'/>\n" +
               "<br>\n" +
               "<input type='email' placeholder='Email' name='mail'/>\n" +
               "<br>\n" +
               "<input type='password' placeholder='Senha' name='senha'/>" +
               "<br>\n" +
               "<button type='submit'>Cadastre-se</button>\n" +
               "</form>\n" +
               "</div>\n" +
               "</body>\n" +
               "</html>";
        return msg;
    }
    
    public static String bodyLogin(){
        return "<body>\n" +
               "<h1 class='logo logoCadastro'></h1>\n" +
               "<p class='textCadastro'>Acesso global à melhor educação do mundo!</p>\n" +
               "<div class='formCadastro formLogin'>\n" +
               "<form action='LoginServlet' method='post'>\n" +
               "<br>\n" +
               "<input type='email' placeholder='Email' name='mail'/>\n" +
               "<br>\n" +
               "<input type='password' placeholder='Senha' name='senha'/>\n" +
               "<br>\n" +
               "<button type='submit'>Entre</button>\n" +
               "</form>\n" +
               "</div>\n" +
               "</body>\n" +
               "</html>";
    }
    
    public static String aviso(String mensagem) {
        return "<p><center>" + mensagem + "</p></center>";
    }
    
    public static String avisoJS(String mensagem) {
        return "<html>\n" +
               "<body>\n" +
               "<script>\n" +
               "alert('Você é o primeiro usuario! Iremos cadastrar você como administrador. Pressione OK para continuar.')\n" +
               "</script>\n" +
               "</body>" +
               "<html>";
    }
}