package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Controller.ControllerCursos;
import org.coursera.Model.Curso;


@WebServlet(name = "VerCurso", urlPatterns = {"/VerCurso"})
public class VerCurso extends HttpServlet{
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
    
    private String header = "<header>\n" +
"    <h1 class=\"logo\">\n" +
"    </h1>\n" +
"    <input type=\"checkbox\" id=\"control-nav\" style=\"display: none;\"/>\n" +
"    <label for=\"control-nav\" class=\"control-nav\"></label>\n" +
"    <label for=\"control-nav\" class=\"control-nav-close\"></label>\n" +
"    <nav class=\"fR\">\n" +
"    <ul class=\"l2\">\n" +
"      <a href=\"cadastro.html\" onclick=\"return popitup('cadastro.html')\" class=\"menuItem cadastrar\">Cadastre-se</a>\n" +
"      <a href=\"login.html\" onclick=\"return popitup('login.html')\" class=\"menuItem\">Entrar</a>\n" +
"      <a href=\"#\" class=\"menuItem\">Instituições</a>\n" +
"    </ul>\n" +
"  </nav>\n" +
"  </header>";
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
        PrintWriter pw = response.getWriter();
        String id = request.getParameter("id");
        Curso c = ControllerCursos.cursoPorId(id);
        String title = "<h1 class='courseName' >"+c.getNome()+"</h1>";
        String university = "<h2 class='courseUni'>"+c.getUni()+"</h2>";
        String desc = "<p class='descCourse'>" + c.getDescricao() + "</h2>";
        String youtube = "<iframe style='margin-top: -10%; margin-left: 51%;' width=\"420\" height=\"315\"\n" +
                "src=\'"+ c.getYoutubeLink()+"'>\n" +
        "</iframe>";
        pw.println(head);
        pw.println(header);
        pw.println(title);
        pw.println(university);
        pw.println(desc);
        pw.println(youtube);
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
