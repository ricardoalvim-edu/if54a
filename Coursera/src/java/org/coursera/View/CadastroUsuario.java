package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Controller.ControllerUsuario;
import javax.servlet.http.HttpSession;
import org.coursera.Model.Usuario;
import sun.misc.BASE64Encoder;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
public class CadastroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usr = request.getParameter("usr");
        String mail = request.getParameter("mail");
        
        String senha = request.getParameter("senha");
        try {
            senha = ControllerUsuario.criptografa(senha);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tipo_usr = "normal";
        Usuario usuario = new Usuario(usr, senha , mail, tipo_usr);
        ControllerUsuario ru = new ControllerUsuario();
        boolean resultado = ru.registrar(usuario);
        HttpSession session = request.getSession();
        
        if (resultado) {
            session.setAttribute("mail", mail);
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
