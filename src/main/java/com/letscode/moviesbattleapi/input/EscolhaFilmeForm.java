package com.letscode.moviesbattleapi.input;

/**
 *
 * @author Marcus
 */
public class EscolhaFilmeForm {
    private Long partidaId;
    private Long filme1Id;
    private Long filme2Id;
    private Long filmeEscolhidoId;

    public void setPartidaId(Long partidaId) {
        this.partidaId = partidaId;
    }

    public void setFilme1Id(Long filme1Id) {
        this.filme1Id = filme1Id;
    }

    public void setFilme2Id(Long filme2Id) {
        this.filme2Id = filme2Id;
    }

    public void setFilmeEscolhidoId(Long filmeEscolhidoId) {
        this.filmeEscolhidoId = filmeEscolhidoId;
    }

    public Long getPartidaId() {
        return partidaId;
    }

    public Long getFilme1Id() {
        return filme1Id;
    }

    public Long getFilme2Id() {
        return filme2Id;
    }

    public Long getFilmeEscolhidoId() {
        return filmeEscolhidoId;
    }
}