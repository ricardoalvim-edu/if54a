package org.coursera.Controller;

import java.util.List;
import org.coursera.Model.Curso;
import org.coursera.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @autor ricar
 */
public class CursosController {

    public static boolean salvar(Curso curso){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        
        try{
            s.getTransaction().begin();
            s.save(curso);
            s.getTransaction().commit();
            s.close();
            return true;
        }catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
            s.close();
            return false;
        }
    }
    
    public static List<Curso> cursos(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<Curso> cursos = null;
        
        try{
            s.getTransaction().begin();
            Query query = s.getNamedQuery("Curso.todos");
            cursos = query.list();
            System.out.println("Numero cursos: " + cursos.size());
            s.getTransaction().commit();
        }catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        finally{
            s.close();
        }
        return cursos;
    } 
}
