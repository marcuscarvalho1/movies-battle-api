package com.letscode.moviesbattleapi.output;

/**
 *
 * @author Marcus
 */
public class FilmeOutput {
    private Long id;
    private String titulo;
    private int ano;
    private String genero;
    private String diretor;
    private String atores;
    private String posterUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getAtores() {
        return atores;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}