package com.letscode.moviesbattleapi.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Marcus
 */
@Entity
@Table(name = "tb_ranking")
public class Ranking implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long id;
    private int posicao;
    @ManyToOne
    @JoinColumn(name = "tb_usuario_id")
    private Usuario usuario;
    private int pontos;

    public Ranking() {
        //Construtor padrão
    }

    public Ranking(Ranking r) {
        this.id = r.id;
        this.posicao = r.posicao;
        this.usuario = r.usuario;
        this.pontos = r.pontos;
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getPontos() {
        return pontos;
    }

    public int getPosicao() {
        return posicao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + this.posicao;
        hash = 53 * hash + Objects.hashCode(this.usuario);
        hash = 53 * hash + this.pontos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ranking other = (Ranking) obj;
        if (this.posicao != other.posicao) {
            return false;
        }
        if (this.pontos != other.pontos) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Ranking{" + "id=" + id + ", posicao=" + posicao + ", usuario=" + usuario + ", pontos=" + pontos + '}';
    }
}