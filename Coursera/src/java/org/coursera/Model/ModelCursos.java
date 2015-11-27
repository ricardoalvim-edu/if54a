/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Classe que manipula inserção e obtenção de dados em relação aos cursos.
*/

package org.coursera.Model;

import java.util.ArrayList;
import java.util.List;
import org.coursera.Entity.Curso;
import org.coursera.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ModelCursos {

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
        try {
            s.getTransaction().begin();
            Query query = s.getNamedQuery("Curso.todos");
            cursos = query.list();
            s.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        finally{
            s.close();
        }
        return cursos;
    } 
    
    public static Curso cursoPorId(String id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Curso curso = new Curso();
        try{
            s.getTransaction().begin();
            Query query = s.getNamedQuery("Curso.cursoById");
            query.setParameter("idCurso", Integer.parseInt(id));
            curso = (Curso) query.uniqueResult();
            s.getTransaction().commit();
        }catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        finally{
            s.close();
        }
        return curso;
    }
    
    public static List<Curso> cursoPorNome(String nome){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<Curso> cursos = new ArrayList<>();
        try{
            s.getTransaction().begin();
            Query query = s.getNamedQuery("Curso.cursoByNome");
            query.setParameter("nome", nome);
            cursos = query.list();
            s.getTransaction().commit();
        }catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        finally{
            s.close();
        }
        return cursos;
    }
    
    public static int tamanhoCurso(){
        List<Curso> cs = cursos();
        int tamanhoCursos = 0;
        if (cs != null && cs.size() > 0) {
            tamanhoCursos = cs.size();
        }
        return tamanhoCursos;
    }
}
