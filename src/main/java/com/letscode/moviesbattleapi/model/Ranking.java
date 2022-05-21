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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private double pontos;

    public Ranking() {
        //Construtor padrão
    }

    public Ranking(Long id, Usuario usuario, double pontos) {
        this.id = id;
        this.usuario = usuario;
        this.pontos = pontos;
    }
    
    public Ranking(Ranking r){
        this(r.id, r.usuario, r.pontos);
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getPontos() {
        return pontos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.usuario);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.pontos) ^ (Double.doubleToLongBits(this.pontos) >>> 32));
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
        if (Double.doubleToLongBits(this.pontos) != Double.doubleToLongBits(other.pontos)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Ranking{" + "id=" + id + ", usuario=" + usuario + ", pontos=" + pontos + '}';
    }
}