package com.letscode.moviesbattleapi.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
@Table(name = "tb_filme")
public class Filme implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title")
    private String titulo;
    @Column(name = "ReleaseYear")
    private int ano;
    @Column(name = "Rated")
    private String classificacao;
    @Column(name = "Released")
    private String lancamento;
    @Column(name = "Runtime")
    private String duracao;
    @Column(name = "Genre")
    private String genero;
    @Column(name = "Director")
    private String diretor;
    @Column(name = "Writer")
    private String escritor;
    @Column(name = "Actors")
    private String atores;
    @Column(name = "Plot")
    private String enredo;
    @Column(name = "Language")
    private String linguagem;
    @Column(name = "Country")
    private String pais;
    @Column(name = "Awards")
    private String premiacoes;
    @Column(name = "Poster")
    private String posterUrl;
    @Column(name = "Ratings0Source")
    private String fonteAvaliacao0;
    @Column(name = "Ratings0Value")
    private String valorAvaliacao0;
    @Column(name = "Ratings1Source")
    private String fonteAvaliacao1;
    @Column(name = "Ratings1Value")
    private String valorAvaliacao1;
    @Column(name = "Ratings2Source")
    private String fonteAvaliacao2;
    @Column(name = "Ratings2Value")
    private String valorAvaliacao2;
    @Column(name = "Metascore")
    private int metascore;
    @Column(name = "imdbID")
    private String imdbId;
    @Column(name = "imdbRating")
    private double avaliacaoImdb;
    @Column(name = "imdbVotes")
    private long votosImdb;
    @Column(name = "Type")
    private String tipo;
    @Column(name = "DVD")
    private String dvd;
    @Column(name = "BoxOffice")
    private String boxOffice;
    @Column(name = "Production")
    private String producao;
    @Column(name = "Website")
    private String website;
    @Column(name = "Response")
    private boolean response;
    
    //Construtores

    public Filme() {
        //Construtor padrão
    }
    
    public Filme(Filme f){
        this.id = f.id;
        this.ano = f.ano;
        this.atores = f.atores;
        this.avaliacaoImdb = f.avaliacaoImdb;
        this.boxOffice = f.boxOffice;
        this.classificacao = f.classificacao;
        this.diretor = f.diretor;
        this.duracao = f.duracao;
        this.dvd = f.dvd;
        this.enredo = f.enredo;
        this.escritor = f.escritor;
        this.fonteAvaliacao0 = f.fonteAvaliacao0;
        this.fonteAvaliacao1 = f.fonteAvaliacao1;
        this.fonteAvaliacao2 = f.fonteAvaliacao2;
        this.genero = f.genero;
        this.imdbId = f.imdbId;
        this.lancamento = f.lancamento;
        this.linguagem = f.linguagem;
        this.metascore = f.metascore;
        this.pais = f.pais;
        this.posterUrl = f.posterUrl;
        this.premiacoes = f.premiacoes;
        this.producao = f.producao;
        this.response = f.response;
        this.tipo = f.tipo;
        this.titulo = f.titulo;
        this.valorAvaliacao0 = f.valorAvaliacao0;
        this.valorAvaliacao1 = f.valorAvaliacao1;
        this.valorAvaliacao2 = f.valorAvaliacao2;
        this.votosImdb = f.votosImdb;
        this.website = f.website;
    }
    
    //Getters & setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public void setEnredo(String enredo) {
        this.enredo = enredo;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPremiacoes(String premiacoes) {
        this.premiacoes = premiacoes;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public void setFonteAvaliacao0(String fonteAvaliacao0) {
        this.fonteAvaliacao0 = fonteAvaliacao0;
    }

    public void setValorAvaliacao0(String valorAvaliacao0) {
        this.valorAvaliacao0 = valorAvaliacao0;
    }

    public void setFonteAvaliacao1(String fonteAvaliacao1) {
        this.fonteAvaliacao1 = fonteAvaliacao1;
    }

    public void setValorAvaliacao1(String valorAvaliacao1) {
        this.valorAvaliacao1 = valorAvaliacao1;
    }

    public void setFonteAvaliacao2(String fonteAvaliacao2) {
        this.fonteAvaliacao2 = fonteAvaliacao2;
    }

    public void setValorAvaliacao2(String valorAvaliacao2) {
        this.valorAvaliacao2 = valorAvaliacao2;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public void setAvaliacaoImdb(double avaliacaoImdb) {
        this.avaliacaoImdb = avaliacaoImdb;
    }

    public void setVotosImdb(long votosImdb) {
        this.votosImdb = votosImdb;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public String getLancamento() {
        return lancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public String getEscritor() {
        return escritor;
    }

    public String getAtores() {
        return atores;
    }

    public String getEnredo() {
        return enredo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public String getPais() {
        return pais;
    }

    public String getPremiacoes() {
        return premiacoes;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getFonteAvaliacao0() {
        return fonteAvaliacao0;
    }

    public String getValorAvaliacao0() {
        return valorAvaliacao0;
    }

    public String getFonteAvaliacao1() {
        return fonteAvaliacao1;
    }

    public String getValorAvaliacao1() {
        return valorAvaliacao1;
    }

    public String getFonteAvaliacao2() {
        return fonteAvaliacao2;
    }

    public String getValorAvaliacao2() {
        return valorAvaliacao2;
    }

    public int getMetascore() {
        return metascore;
    }

    public double getAvaliacaoImdb() {
        return avaliacaoImdb;
    }

    public long getVotosImdb() {
        return votosImdb;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDvd() {
        return dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProducao() {
        return producao;
    }

    public String getWebsite() {
        return website;
    }

    public boolean isResponse() {
        return response;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.titulo);
        hash = 13 * hash + this.ano;
        hash = 13 * hash + Objects.hashCode(this.classificacao);
        hash = 13 * hash + Objects.hashCode(this.lancamento);
        hash = 13 * hash + Objects.hashCode(this.duracao);
        hash = 13 * hash + Objects.hashCode(this.genero);
        hash = 13 * hash + Objects.hashCode(this.diretor);
        hash = 13 * hash + Objects.hashCode(this.escritor);
        hash = 13 * hash + Objects.hashCode(this.atores);
        hash = 13 * hash + Objects.hashCode(this.enredo);
        hash = 13 * hash + Objects.hashCode(this.linguagem);
        hash = 13 * hash + Objects.hashCode(this.pais);
        hash = 13 * hash + Objects.hashCode(this.premiacoes);
        hash = 13 * hash + Objects.hashCode(this.posterUrl);
        hash = 13 * hash + Objects.hashCode(this.fonteAvaliacao0);
        hash = 13 * hash + Objects.hashCode(this.valorAvaliacao0);
        hash = 13 * hash + Objects.hashCode(this.fonteAvaliacao1);
        hash = 13 * hash + Objects.hashCode(this.valorAvaliacao1);
        hash = 13 * hash + Objects.hashCode(this.fonteAvaliacao2);
        hash = 13 * hash + Objects.hashCode(this.valorAvaliacao2);
        hash = 13 * hash + this.metascore;
        hash = 13 * hash + Objects.hashCode(this.imdbId);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.avaliacaoImdb) ^ (Double.doubleToLongBits(this.avaliacaoImdb) >>> 32));
        hash = 13 * hash + (int) (this.votosImdb ^ (this.votosImdb >>> 32));
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + Objects.hashCode(this.dvd);
        hash = 13 * hash + Objects.hashCode(this.boxOffice);
        hash = 13 * hash + Objects.hashCode(this.producao);
        hash = 13 * hash + Objects.hashCode(this.website);
        hash = 13 * hash + (this.response ? 1 : 0);
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
        final Filme other = (Filme) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.metascore != other.metascore) {
            return false;
        }
        if (Double.doubleToLongBits(this.avaliacaoImdb) != Double.doubleToLongBits(other.avaliacaoImdb)) {
            return false;
        }
        if (this.votosImdb != other.votosImdb) {
            return false;
        }
        if (this.response != other.response) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.classificacao, other.classificacao)) {
            return false;
        }
        if (!Objects.equals(this.lancamento, other.lancamento)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.diretor, other.diretor)) {
            return false;
        }
        if (!Objects.equals(this.escritor, other.escritor)) {
            return false;
        }
        if (!Objects.equals(this.atores, other.atores)) {
            return false;
        }
        if (!Objects.equals(this.enredo, other.enredo)) {
            return false;
        }
        if (!Objects.equals(this.linguagem, other.linguagem)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.premiacoes, other.premiacoes)) {
            return false;
        }
        if (!Objects.equals(this.posterUrl, other.posterUrl)) {
            return false;
        }
        if (!Objects.equals(this.fonteAvaliacao0, other.fonteAvaliacao0)) {
            return false;
        }
        if (!Objects.equals(this.valorAvaliacao0, other.valorAvaliacao0)) {
            return false;
        }
        if (!Objects.equals(this.fonteAvaliacao1, other.fonteAvaliacao1)) {
            return false;
        }
        if (!Objects.equals(this.valorAvaliacao1, other.valorAvaliacao1)) {
            return false;
        }
        if (!Objects.equals(this.fonteAvaliacao2, other.fonteAvaliacao2)) {
            return false;
        }
        if (!Objects.equals(this.valorAvaliacao2, other.valorAvaliacao2)) {
            return false;
        }
        if (!Objects.equals(this.imdbId, other.imdbId)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.dvd, other.dvd)) {
            return false;
        }
        if (!Objects.equals(this.boxOffice, other.boxOffice)) {
            return false;
        }
        if (!Objects.equals(this.producao, other.producao)) {
            return false;
        }
        if (!Objects.equals(this.website, other.website)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Filme{" + "id=" + id + ", titulo=" + titulo + ", ano=" + ano + ", classificacao=" + classificacao 
                + ", lancamento=" + lancamento + ", duracao=" + duracao + ", genero=" + genero + ", diretor=" + diretor 
                + ", escritor=" + escritor + ", atores=" + atores + ", enredo=" + enredo + ", linguagem=" + linguagem 
                + ", pais=" + pais + ", premiacoes=" + premiacoes + ", posterUrl=" + posterUrl + ", fonteAvaliacao0=" 
                + fonteAvaliacao0 + ", valorAvaliacao0=" + valorAvaliacao0 + ", fonteAvaliacao1=" + fonteAvaliacao1 
                + ", valorAvaliacao1=" + valorAvaliacao1 + ", fonteAvaliacao2=" + fonteAvaliacao2 + ", valorAvaliacao2=" 
                + valorAvaliacao2 + ", metascore=" + metascore + ", imdbId=" + imdbId + ", avaliacaoImdb=" + avaliacaoImdb 
                + ", votosImdb=" + votosImdb + ", tipo=" + tipo + ", dvd=" + dvd + ", boxOffice=" + boxOffice + ", producao=" 
                + producao + ", website=" + website + ", response=" + response + '}';
    }
}