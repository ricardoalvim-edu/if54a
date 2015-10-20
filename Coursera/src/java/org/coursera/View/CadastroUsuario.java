package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Controller.ControllerUsuario;
import org.coursera.Model.Usuario;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usr = request.getParameter("usr");
        String mail = request.getParameter("mail");
        String senha = request.getParameter("senha");
        Usuario usuario = new Usuario(usr, senha, mail);
        ControllerUsuario ru = new ControllerUsuario();
        boolean resultado = ru.registrar(usuario);
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
