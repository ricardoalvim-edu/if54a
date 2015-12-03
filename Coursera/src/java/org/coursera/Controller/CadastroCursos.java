/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet efetua o cadastro do curso de fato, com as regras de negócio.
Não são tratadas restrições neste caso.
*/

package org.coursera.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.coursera.Entity.Curso;
import org.coursera.Model.HTML;
import org.coursera.Model.ModelCursos;

@WebServlet(name = "CadastroCursosServlet", urlPatterns = {"/CadastroCursosServlet"})
public class CadastroCursos extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String nome = request.getParameter("nome");
        String description = request.getParameter("desc");
        String url = request.getParameter("urlImage");
        String universidade = request.getParameter("uni");
        String youtube = request.getParameter("youtube");
        Curso curso = new Curso (nome, description, url, universidade, youtube);
        boolean resultado = ModelCursos.salvar(curso);
        
        if (resultado) {
            HttpSession session = request.getSession();
            session.setAttribute("obj_up", curso);
            session.setAttribute("obj_tipo", Curso.class.getSimpleName());
            response.sendRedirect("Upload.jsp");
        } else {
            pw.println(HTML.aviso("Algo de errado aconteceu com o cadastro do curso! Contate um administrador. <p></p> <a href='index'>Volte para a página principal.</a>", request));
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
