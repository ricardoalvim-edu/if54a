package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.coursera.Controller.ControllerCursos;
import org.coursera.Model.Curso;

@WebServlet(name = "Index", urlPatterns = {"/index"})
public class Index extends HttpServlet{
    private String head = 
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int tamanhoCursos = 0;
        PrintWriter pw = response.getWriter();
        List<Curso> cursos = ControllerCursos.cursos();
        pw.println(head);
        String logadoHeader = "";
        if (request.getSession().getAttribute("logado") == null) {
            logadoHeader = "<a href=\"cadastro.html\" class=\"menuItem cadastrar\">Cadastre-se</a>\n" +
"      <a href=\"login.html\" class=\"menuItem\">Entrar</a>\n";        
            }else{
            String tipo_usr = (String) request.getSession().getAttribute("tipo_usr");
            String usuario = (String) request.getSession().getAttribute("usr");
            if (tipo_usr.equals("normal")) {
                logadoHeader = "<span class='menuItem'>Olá " + usuario + "</span>";
            } else if (tipo_usr.equals("administrativo")){
                logadoHeader = "<span class'menuItem'>Olá " + usuario + ". Você é administrador!</span>";
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
        pw.println(header);
        if (cursos != null && cursos.size() > 0) {
            tamanhoCursos = cursos.size();
        }
        String bodyP1 = "<body>\n" +
"    <div class=\"searchCourses\">\n" +
"      <p class=\"textSearch\">Faça os melhores cursos online!</p>\n" +
"      <div class=\"controlInfo\">\n" +
"        <ul>\n" +
"          <li class=\"textInfo\"><b>14.969.909</b> Alunos</li>\n" +
"          <li class=\"textInfo\">· <b>" + tamanhoCursos +"</b> Cursos </li>\n" +
"        </ul>\n" +
"      </div>\n" +
"    </div>";
        pw.println(bodyP1);
        pw.println("<div class='areaEspecializacao'>");
        pw.println("<h1>Novas especializações</h1>");
        pw.println("<div class='box'>");
        if (tamanhoCursos != 0){
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
