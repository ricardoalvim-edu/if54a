package org.coursera.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name="Usuario.todos", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name="Usuario.usuarioById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name="Usuario.userLogin", query = "FROM Usuario u WHERE u.email = :mail AND u.senha = :senha")
})
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;
    private String email;
    private String tipo_usr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_usr() {
        return tipo_usr;
    }

    public void setTipo_usr(String tipo_usr) {
        this.tipo_usr = tipo_usr;
    }
    
    public Usuario(String usuario, String senha, String email, String tipo_usr) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.tipo_usr = tipo_usr;
    }
    
    public Usuario() {
        this.usuario = null;
        this.senha = null;
        this.email = null;
        this.tipo_usr = null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}