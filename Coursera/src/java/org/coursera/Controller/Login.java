/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet efetua o login, com as regras de negócio. Neste caso, apenas são tratados
se o usuario e senha estão certos. Como padrão de mercado, não é dito qual campo está errado
em especifico.
*/

package org.coursera.Controller;

import org.coursera.Model.HTML;
import java.io.IOException;
import java.io.PrintWriter;;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.coursera.Model.ModelUsuario;
import org.coursera.Entity.Usuario;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mail = request.getParameter("mail");        
        String senha = request.getParameter("senha");
        PrintWriter pw = response.getWriter();
        Usuario user = ModelUsuario.getUsuario(mail);
        if (user != null) {
            if (BCrypt.checkpw(senha, user.getSenha())) {
                HttpSession session = request.getSession();
                session.setAttribute("mail", user.getEmail());
                session.setAttribute("tipo_usr", user.getTipo_usr());
                session.setAttribute("usr", user.getUsuario());
                session.setAttribute("logado", 1);
                response.sendRedirect("home.jsp");
            } else {
                pw.println(HTML.aviso("E-mail ou senha invalidos.", request));
            }
        } else {
            pw.println(HTML.aviso("E-mail ou senha invalidos!", request));
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
