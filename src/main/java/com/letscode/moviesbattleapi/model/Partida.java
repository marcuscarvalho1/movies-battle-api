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
@Table(name = "tb_partida")
public class Partida implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioLogado;
    private int pontos;
    private int erros;

    public Partida() {
        //Construtor padrão
    }
    
    public Partida(Partida p){
        this.id = p.id;
        this.usuarioLogado = p.usuarioLogado;
        this.pontos = p.pontos;
        this.erros = p.erros;
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public int getPontos() {
        return pontos;
    }

    public int getErros() {
        return erros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.usuarioLogado);
        hash = 31 * hash + this.pontos;
        hash = 31 * hash + this.erros;
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
        final Partida other = (Partida) obj;
        if (this.pontos != other.pontos) {
            return false;
        }
        if (this.erros != other.erros) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.usuarioLogado, other.usuarioLogado);
    }

    @Override
    public String toString() {
        return "Partida{" + "id=" + id + ", usuarioLogado=" + usuarioLogado + ", pontos=" + pontos + ", erros=" 
                + erros + '}';
    }
}