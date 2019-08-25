package br.com.podce.exceptions;

import br.com.podce.util.Mensagem;

import java.util.List;

/**
 *
 * @author Victor Alexsander
 *
 */
public class PodceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4871650247130218088L;
	private String[] args;
	private List<Mensagem> mensagens;
    
	public PodceException() {
        super();
    }
    
	public PodceException(Throwable excecao) {
        super(excecao.getMessage());
        super.initCause(excecao.getCause());
    }
	
	public PodceException(String msg, Throwable excecao) {
        super(msg, excecao);
        super.initCause(excecao.getCause());
    }
	
    public PodceException(String key) {
        super(key);
    }
    
    public PodceException(String key, String... args) {
    	super(key);
    	setArgs(args);
    }
    
    public PodceException(String key, List<Mensagem> lista) {
        super(key);
        this.mensagens = lista;
    }
    
    public String[] getArgs() {
        return args;
    }
    public void setArgs(String[] args) {
        this.args = args;
    }

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
    
}
