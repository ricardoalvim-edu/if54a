/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Classe de entidade para os usuarios.
*/

package org.coursera.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name="Usuario.todos", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name="Usuario.usuariobyUsr", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name="Usuario.userLogin", query = "FROM Usuario u WHERE u.email = :mail")
})
@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String senha;
    private String email;
    private String tipo_usr;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String siglaEstado;

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
    
    public Usuario(String usuario, String senha, String email, String tipo_usr, String log, String bairro, String cep, String cidade, String sigla) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.tipo_usr = tipo_usr;
        this.logradouro = log;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.siglaEstado = sigla;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }
}