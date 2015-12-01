package org.coursera.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.coursera.Entity.Curso;
import org.coursera.Model.ModelCursos;
import org.json.*;

public class TodosCursos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Curso> c = ModelCursos.cursos();
        JSONObject objFinal = new JSONObject();
        PrintWriter pw = response.getWriter();
        JSONArray arr = new JSONArray();
        for (Curso cursos : c) {
            JSONObject obj = new JSONObject();
            obj.put("nome", cursos.getNome());
            obj.put("uni", cursos.getUni());
            obj.put("desc", cursos.getDescricao());
            obj.put("img", cursos.getUrlImagem());
            obj.put("id", cursos.getIdCursos());
            arr.put(obj);
        }
        objFinal.put("listaCursos", arr);
        pw.println(objFinal.toString());
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
