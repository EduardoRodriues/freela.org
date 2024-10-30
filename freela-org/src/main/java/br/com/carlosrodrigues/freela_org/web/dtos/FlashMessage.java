package br.com.carlosrodrigues.freela_org.web.dtos;

import lombok.Data;

@Data
public class FlashMessage {
    
    private String classeCss;

    public FlashMessage(String classeCss, String mensagem) {
        this.classeCss = classeCss;
        this.menssagem = mensagem;
    }

    private String menssagem;

	public FlashMessage() {
    }

    public String getClasseCss() {
		return classeCss;
	}

	public void setClasseCss(String classeCss) {
		this.classeCss = classeCss;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String mensagem) {
		this.menssagem = mensagem;
	}
}
