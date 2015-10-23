package org.coursera.Controller;

import org.coursera.Model.Usuario;
import org.coursera.Util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ControllerUsuario {
    
    public static String criptografa(String senha) throws NoSuchAlgorithmException{  
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return String.format("%32x", hash);
    }  
    
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
            System.out.println("oi: " + user.getTipo_usr());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        } finally {
            session.close();
        }
        return user;
    }  
}
