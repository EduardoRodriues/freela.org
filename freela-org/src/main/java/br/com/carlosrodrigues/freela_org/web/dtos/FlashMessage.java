package br.com.carlosrodrigues.freela_org.web.dtos;

import lombok.Data;

@Data
public class FlashMessage {
    
    private String classeCss;

    public FlashMessage(String classeCss, String mensagem) {
        this.classeCss = classeCss;
        this.mensagem = mensagem;
    }

    private String mensagem;

	public FlashMessage() {
    }

    public String getClasseCss() {
		return classeCss;
	}

	public void setClasseCss(String classeCss) {
		this.classeCss = classeCss;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
