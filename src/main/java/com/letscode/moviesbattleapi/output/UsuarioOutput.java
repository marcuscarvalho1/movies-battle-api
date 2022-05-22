package com.letscode.moviesbattleapi.output;

/**
 *
 * @author Marcus
 */
public class UsuarioOutput {
    
    private Long id;
    private String nomeUsuario;

    public UsuarioOutput(Long id, String nomeUsuario) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Long getId() {
        return id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}