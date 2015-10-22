package org.coursera.Controller;

import java.util.ArrayList;
import java.util.List;
import org.coursera.Model.Usuario;
import org.coursera.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ControllerUsuario {
    
    public boolean registrar (Usuario usr) {
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
    
    public boolean usuarioExiste (Usuario usr) {
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
    
    public static Usuario getSenha(String mail, String senha) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction tx = null;
        Usuario user = new Usuario();
        try {
            session = sf.openSession();
            tx = session.getTransaction();
            tx.begin();
            Query query = session.getNamedQuery("Usuario.userLogin");
            query.setParameter("mail", mail);
            query.setParameter("senha", senha);
            user = (Usuario) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
            
        }
        return user;
    }
    
}
