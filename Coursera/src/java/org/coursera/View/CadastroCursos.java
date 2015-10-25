package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Controller.ControllerCursos;
import org.coursera.Model.Curso;
import org.coursera.Util.HTML;

@WebServlet(name = "CadastroCursos", urlPatterns = {"/CadastroCursos"})
public class CadastroCursos extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        String description = request.getParameter("desc");
        String url = request.getParameter("urlImage");
        String universidade = request.getParameter("uni");
        String youtube = request.getParameter("youtube");
        Curso curso = new Curso (nome, description, url, universidade, youtube);
        boolean resultado = ControllerCursos.salvar(curso);
        PrintWriter pw = response.getWriter();
        if (resultado) {
            pw.println(HTML.aviso("Cadastro feito com sucesso! <a href='index'>Volte para a página principal.</a>", request));
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
