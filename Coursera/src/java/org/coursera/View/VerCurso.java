/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet é a página individual do curso. Ela verifica se um parametro é enviado,
para evitar acessos sem parametro, que mostrariam apenas "null".
Uma "falha" é que a pessoa pode alterar o parametro e por outro numero, mostrando null.
Não foi arrumado devido tempo.
*/

package org.coursera.View;

import org.coursera.Model.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VerCurso", urlPatterns = {"/VerCurso"})
public class VerCurso extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String id = request.getParameter("id");
        pw.println(HTML.head("Curso - Coursera"));
        pw.println(HTML.bodyInicio(request));
        if (id != null) {  
            pw.println(HTML.bodyCurso(id));
        } else {
            pw.println(HTML.aviso("Ops! Você fez algo errado Volte para a <a href='index'>página principal</a>."));
        }
        pw.println(HTML.bodyFinal());
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
    }
}
