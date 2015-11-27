/*
Trabalho de Programação Web
Alunos: Athos e Ricardo
Tema: coursera.org

Classe de entidade para os cursos.
*/

package org.coursera.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name="Curso.todos", query = "SELECT c FROM Curso c"),
    @NamedQuery(name="Curso.cursoById", query = "SELECT c FROM Curso c WHERE c.idCursos = :idCurso"),
    @NamedQuery(name="Curso.cursoByNome", query = "SELECT c FROM Curso c WHERE c.nome = :nome")
})
@Entity(name = "Curso")
public class Curso {
    @Id @GeneratedValue
    private int idCursos;
    private String nome;
    private String descricao;
    private String urlImagem;
    private String uni;
    private String youtubeLink;
    
    public Curso(String nome, String descricao, String urlImagem, String uni, String youtubeLink){
        this.nome = nome;
        this.descricao = descricao;
        this.urlImagem = urlImagem;
        this.uni = uni;
        this.youtubeLink = youtubeLink;
    }

    public Curso(){
        this.nome = null;
        this.nome = null;
        this.urlImagem = null;
    }
    public int getIdCursos() {
        return idCursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }
    
    
}
