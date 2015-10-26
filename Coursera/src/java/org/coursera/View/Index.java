/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet é a página inicial do programa. Ela verifica se já tem pessoas
cadastradas, se não, ele redireciona para o cadastro do administrador.
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
import org.coursera.Model.ModelUsuario;

@WebServlet(name = "Index", urlPatterns = {"/index"})
public class Index extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        if (ModelUsuario.primeiroUsuario()) {
            response.sendRedirect("CadastroUsuario");
        } else {
            pw.println(HTML.head("Inicio - Coursera"));
            pw.println(HTML.bodyInicio(request));
            pw.println(HTML.bodyMeio());
            pw.println(HTML.bodyMeio2());
            pw.println(HTML.bodyFinal());
        }
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
