package br.com.podce.util;

/**
 * @author Victor Alexsander
 */
public class Mensagem {

    private String mensagem;
    private TipoMensagem tipoMensagem;

    public Mensagem(TipoMensagem tipo, String message) {
        mensagem = message;
        tipoMensagem = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(TipoMensagem tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public enum TipoMensagem {INFO, AVISO, ERRO}
}
