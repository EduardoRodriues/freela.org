package br.com.carlosrodrigues.freela_org.core.enums;

public enum Icone {
    
    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private String nome;

    private Icone(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
}
    
