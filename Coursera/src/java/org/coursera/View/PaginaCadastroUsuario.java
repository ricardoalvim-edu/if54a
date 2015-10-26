/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Esta servlet é a página de cadastro de usuario. Ele verifica se já existe uma sessão,
se existe, mostra uma mensagem de erro. Se não, envia para uma outra servlet, que faz as
regras de negócio e efetua o cadastro.
*/

package org.coursera.View;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Model.HTML;

@WebServlet(name = "CadastroUsuario", urlPatterns = {"/CadastroUsuario"})
public class PaginaCadastroUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        if (request.getSession().getAttribute("logado") == null) {
            pw.println(HTML.head("Cadastre-se - Coursera"));
            pw.println(HTML.bodyCadastroUsuario());
        } else {
            pw.println(HTML.aviso("Você está logado! Para cadastrar um novo usuario, saia do usuario atual.", request));
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
