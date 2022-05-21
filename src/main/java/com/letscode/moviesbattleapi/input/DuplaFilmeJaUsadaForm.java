package com.letscode.moviesbattleapi.input;

/**
 *
 * @author Marcus
 */
public class DuplaFilmeJaUsadaForm {
    private Long idFilme1;
    private Long idFilme2;
    
    //Construtores
    public DuplaFilmeJaUsadaForm(Long idFilme1, Long idFilme2) {
        this.idFilme1 = idFilme1;
        this.idFilme2 = idFilme2;
    }
    
    //Getter & setters
    public void setIdFilme1(Long idFilme1) {
        this.idFilme1 = idFilme1;
    }

    public void setIdFilme2(Long idFilme2) {
        this.idFilme2 = idFilme2;
    }

    public Long getIdFilme1() {
        return idFilme1;
    }

    public Long getIdFilme2() {
        return idFilme2;
    }
}