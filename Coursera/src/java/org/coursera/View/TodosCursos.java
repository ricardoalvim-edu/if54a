package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Controller.CursosController;
import org.coursera.Model.Curso;

/**
 *
 * @autor ricar
 */
@WebServlet(name = "TodosCursos", urlPatterns = {"/index"})
public class TodosCursos extends HttpServlet{
    private String head = "<!doctype HTML>\n" +
"<script language=\"javascript\" type=\"text/javascript\">\n" +
"function popitup(url) {\n" +
"	newwindow=window.open(url,'name',\"resizable=0,height=390,width=780\");\n" +
"	if (window.focus) {newwindow.focus()}\n" +
"	return false;\n" +
"}\n" +
"</script>\n" +
"<html>\n" +
"  <head>\n" +
"    <meta charset=\"utf-8\"/>\n" +
"    <title>Inicial - Coursera</title>\n" +
"    <link rel=\"stylesheet\" href=\"style/estilo.css\"/>\n" +
"    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>\n" +
"    <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1, maximum-scale=1\"/>\n" +
"    <link rel=\"icon\" type=\"image/png\" href=\"img/icon.png\">\n" +
"  </head>";
    
    private String bodyP2 = "</div>\n" +
"  </body>\n" +
"  <footer>\n" +
"\n" +
"  </footer>\n" +
"</html>\n" +
"";
    String user = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        List<Curso> cursos = CursosController.cursos();
        pw.println(head);
        user = (String) request.getSession().getAttribute("user");

        String logado = "";
                
        if (user == null){
            logado = "<a href=\"cadastro.html\" onclick=\"return popitup('cadastro.html')\" class=\"menuItem cadastrar\">Cadastre-se</a>\n" +
"      <a href=\"login.html\" onclick=\"return popitup('login.html')\" class=\"menuItem\">Entrar</a>\n" +
"      <a href=\"#\" class=\"menuItem\">Instituições</a>\n";;         
        }else{
            logado = "<span class='menuItem'>Olá " +user + "</span>";   
        }
        String header = "<header>\n" +
"    <h1 class=\"logo\">\n" +
"    </h1>\n" +
"    <input type=\"checkbox\" id=\"control-nav\" style=\"display: none;\"/>\n" +
"    <label for=\"control-nav\" class=\"control-nav\"></label>\n" +
"    <label for=\"control-nav\" class=\"control-nav-close\"></label>\n" +
"    <nav class=\"fR\">\n" +
"    <ul class=\"l2\">\n" + logado +                   
"    </ul>\n" +
"  </nav>\n" +
"  </header>";
        pw.println(header);
        String bodyP1 = "<body>\n" +
"    <div class=\"searchCourses\">\n" +
"      <p class=\"textSearch\">Faça os melhores cursos online!</p>\n" +
"      <input type=\"text\" placeholder=\"O que você gostaria de aprender?\" class=\"searcherCourses\"/>\n" +
"      <br>\n" +
"      <div class=\"textViewMore\">\n" +
"        <span>ou <a href=\"#\" class=\"viewMoreLink\">ver lista de cursos.</a></span>\n" +
"      </div>\n" +
"      <div class=\"controlInfo\">\n" +
"        <ul>\n" +
"          <li class=\"textInfo\"><b>14.969.909</b> Alunos</li>\n" +
"          <li class=\"textInfo\">· <b>" + cursos.size() +"</b> Cursos </li>\n" +
"        </ul>\n" +
"      </div>\n" +
"    </div>";
        pw.println(bodyP1);
        pw.println("<div class='areaEspecializacao'>");
        pw.println("<h1>Novas especializações</h1>");
        pw.println("<div class='box'>");
        
        if (cursos.size() > 0){
            for (Curso c : cursos){
                pw.println("<div class='boxConteudo'>");
                    pw.println("<div class='imgBox' style=\"background-image: url('"+ c.getUrlImagem()+"') \"> </div>");
                    pw.println("<a href=VerCurso?id=" +c.getIdCursos() +" class=\"titleCourse\">"+ c.getNome() +"</a>");
                    pw.println("<p class='universityText'>"+ c.getUni() + "</p>");
                pw.println("</div>");
            } 
        }else{
            pw.println("<h2 style='text-align: center'>Não há vídeos ainda :(</h2>");
        }
        
        pw.println("</div>");
        pw.println("</div>");
        pw.println(bodyP2);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
