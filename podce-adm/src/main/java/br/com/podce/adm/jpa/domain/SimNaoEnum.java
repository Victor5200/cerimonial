package br.com.podce.adm.jpa.domain;

/**
 * 
 * @author Victor Alexsander
 *
 */
public enum SimNaoEnum {

	S("Sim", Boolean.TRUE), N("Não", Boolean.FALSE);

	private final String texto;
	private final Boolean valor;

	private SimNaoEnum(String texto, Boolean valor) {
		this.texto = texto;
		this.valor = valor;
	}

	public String getTexto() {
		return texto;
	}
	
	public Boolean getValor() {
		return valor;
	}

}
