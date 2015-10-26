package org.coursera.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.coursera.Entity.Usuario;
import org.coursera.Model.HTML;
import org.coursera.Model.ModelUsuario;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuarioServlet"})
public class CadastroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usr = request.getParameter("usr");
        String mail = request.getParameter("mail");
        String senha = request.getParameter("senha");
        PrintWriter pw = response.getWriter();
        if (ModelUsuario.usuarioExiste(usr)) {
            pw.println(HTML.aviso("Já registraram este usuario. Escolha outro!", request));
        } else if (ModelUsuario.getUsuario(mail) != null && ModelUsuario.getUsuario(mail).getEmail().equals(mail)) {
            pw.println(HTML.aviso("Já registraram com este email. Escolha outro!", request));
        } else {
            String tipo_usr = "";
            String hashed = BCrypt.hashpw(senha, BCrypt.gensalt());
            if (ModelUsuario.primeiroUsuario()) {
                tipo_usr = "administrativo";
            } else {
                tipo_usr = "normal";
            }    
            Usuario usuario = new Usuario(usr, hashed, mail, tipo_usr);
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
