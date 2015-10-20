package org.coursera.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Model.Curso;
import org.coursera.Model.RegistrarUsuario;
import org.coursera.Model.Usuario;

/**
 *
 * @autor ricar
 */
@WebServlet(name = "CadastroCursos", urlPatterns = {"/CadastroCursos"})
public class CadastroCursos extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        String description = request.getParameter("desc");
        String url = request.getParameter("urlImage");
        String universidade = request.getParameter("uni");
        
        Curso curso = new Curso (nome, description, url, universidade);
        boolean resultado = CursosController.salvar(curso);
        if (resultado) {
            response.sendRedirect("cadastro-sucesso.html");
        } else {
            response.sendRedirect("cadastro-falha.html");
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
    }// </editor-fold>
}
