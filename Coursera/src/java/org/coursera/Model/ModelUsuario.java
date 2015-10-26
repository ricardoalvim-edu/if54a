package org.coursera.Model;

import org.coursera.Entity.Usuario;
import org.coursera.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ModelUsuario {
   
    public boolean registrar(Usuario usr) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction tx = null;
        try {
            session = sf.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.save(usr);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        } finally {
            if (session != null) session.close();
        }
        return true;
    }
    
    public boolean usuarioExiste(Usuario usr) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction tx = null;
        boolean resultado = false;
        try {
            session = sf.openSession();
            tx = session.getTransaction();
            tx.begin();
            Query query = session.getNamedQuery("Usuario.usuariobyId");
            Usuario u = (Usuario)query.uniqueResult();
            if(u!=null) resultado = true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return resultado;
    }
    
    public static Usuario getUsuario(String mail) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Usuario user = new Usuario();
        try {
            session.getTransaction().begin();
            user = (Usuario) session.getNamedQuery("Usuario.userLogin").setParameter("mail", mail).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return user;
    }
    
    public static int tamanhoUsuario() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<Usuario> usuario = null;
        try {
            s.getTransaction().begin();
            Query query = s.getNamedQuery("Usuario.todos");
            usuario = query.list();
            s.getTransaction().commit();
        } catch (Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        return usuario.size();
    }
    
    public static boolean primeiroUsuario() {
        return tamanhoUsuario() == 0;
    }
}
