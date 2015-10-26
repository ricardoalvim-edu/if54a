package org.coursera.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.coursera.Entity.Usuario;
import org.coursera.Model.HTML;
import org.coursera.Model.ModelUsuario;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuarioServlet"})
public class CadastroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usr = request.getParameter("usr");
        String mail = request.getParameter("mail");
        String senha = request.getParameter("senha");
        PrintWriter pw = response.getWriter();
        String tipo_usr = "";
        try {
            senha = ModelUsuario.criptografa(senha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ModelUsuario.primeiroUsuario()) {
            tipo_usr = "administrativo";
        } else {
            tipo_usr = "normal";
        }    
        Usuario usuario = new Usuario(usr, senha , mail, tipo_usr);
        ModelUsuario ru = new ModelUsuario();
        boolean resultado = ru.registrar(usuario);
        if (resultado) {
            HttpSession session = request.getSession();
            session.setAttribute("mail", mail);
            session.setAttribute("tipo_usr", tipo_usr);
            session.setAttribute("usr", usr);
            session.setAttribute("logado", 1);
            response.sendRedirect("index");
        } else {
            pw.println(HTML.aviso("Algo de errado aconteceu com seu cadastro! Contate um administrador.", request));
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
