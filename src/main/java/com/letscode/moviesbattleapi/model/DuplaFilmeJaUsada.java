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
@Table(name = "tb_dupla_filme_ja_usada")
public class DuplaFilmeJaUsada implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idFilme1;
    private Long idFilme2;
    
    //Construtores

    public DuplaFilmeJaUsada() {
        //Construtor padrão
    }

    public DuplaFilmeJaUsada(Long id, Long idFilme1, Long idFilme2) {
        this.id = id;
        this.idFilme1 = idFilme1;
        this.idFilme2 = idFilme2;
    }
    
    public DuplaFilmeJaUsada(DuplaFilmeJaUsada dfju){
        this(dfju.id, dfju.idFilme1, dfju.idFilme2);
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setIdFilme1(Long idFilme1) {
        this.idFilme1 = idFilme1;
    }

    public void setIdFilme2(Long idFilme2) {
        this.idFilme2 = idFilme2;
    }

    public Long getId() {
        return id;
    }

    public Long getIdFilme1() {
        return idFilme1;
    }

    public Long getIdFilme2() {
        return idFilme2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.idFilme1);
        hash = 71 * hash + Objects.hashCode(this.idFilme2);
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
        final DuplaFilmeJaUsada other = (DuplaFilmeJaUsada) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idFilme1, other.idFilme1)) {
            return false;
        }
        return Objects.equals(this.idFilme2, other.idFilme2);
    }

    @Override
    public String toString() {
        return "DuplaFilmeJaUsada{" + "id=" + id + ", idFilme1=" + idFilme1 + ", idFilme2=" + idFilme2 + '}';
    }
}