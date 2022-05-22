package com.letscode.moviesbattleapi.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long usuarioLogadoId;
    private int pontos;
    private int erros;
    private boolean encerrada;

    public Partida() {
        //Construtor padrão
    }
    
    public Partida(Partida p){
        this.id = p.id;
        this.usuarioLogadoId = p.usuarioLogadoId;
        this.pontos = p.pontos;
        this.erros = p.erros;
        this.encerrada = p.encerrada;
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuarioLogadoId(Long usuarioLogadoId) {
        this.usuarioLogadoId = usuarioLogadoId;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public void setEncerrada(boolean encerrada) {
        this.encerrada = encerrada;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioLogadoId() {
        return usuarioLogadoId;
    }

    public int getPontos() {
        return pontos;
    }

    public int getErros() {
        return erros;
    }

    public boolean isEncerrada() {
        return encerrada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.usuarioLogadoId);
        hash = 97 * hash + this.pontos;
        hash = 97 * hash + this.erros;
        hash = 97 * hash + (this.encerrada ? 1 : 0);
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
        if (this.encerrada != other.encerrada) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.usuarioLogadoId, other.usuarioLogadoId);
    }

    @Override
    public String toString() {
        return "Partida{" + "id=" + id + ", usuarioLogadoId=" + usuarioLogadoId + ", pontos=" + pontos + ", erros=" 
                + erros + ", encerrada=" + encerrada + '}';
    }
}