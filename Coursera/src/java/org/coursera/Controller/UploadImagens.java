package org.coursera.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.coursera.Entity.Curso;
import org.coursera.Entity.Usuario;
import org.coursera.Model.ModelCursos;

/**
 *
 * @author ricar
 */
@WebServlet(name = "UploadImagens", urlPatterns = {"/UploadImagens"})
@MultipartConfig
public class UploadImagens extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String contentType = filePart.getContentType();
        if (session.getAttribute("obj_up") != null) {
            Object obj = session.getAttribute("obj_up");
            if (contentType.equals("image/png") || contentType.equals("image/jpeg")) {
                File uploads = new File("C:\\Users\\ricar\\Documents\\GitHub\\programacao-web\\Coursera\\web\\img");
                String arquivo = Integer.toString(ThreadLocalRandom.current().nextInt(1, 100000 + 1)) + "-" + fileName;
                File file = new File(uploads, arquivo);

                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath());
                } catch (Exception e) {
                    //request.setAttribute("titulo", "Ops!");
                    //request.setAttribute("sucesso", "Algo de errado aconteceu! Mensagem pro administrador: \n" + e);
                    System.out.println(e);
                    //request.getRequestDispatcher("WEB-INF/sucesso.jsp").forward(request, response);
                }
                String tipo = session.getAttribute("obj_tipo").toString();
                System.out.println(tipo);
                switch (tipo) {
                    case "Curso":
                        Curso c = (Curso) obj;
                        c.setUrlImagem(arquivo);
                        ModelCursos.atualizar(c);
                        response.sendRedirect("index");
                        break;
                }
            }
        }
    }
}
