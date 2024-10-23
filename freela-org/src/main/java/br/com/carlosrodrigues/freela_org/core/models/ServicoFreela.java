package br.com.carlosrodrigues.freela_org.core.models;

import java.math.BigDecimal;

import br.com.carlosrodrigues.freela_org.core.enums.Icone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class ServicoFreela {

    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(length = 50, nullable = false)
    private String nome;
    
	@Column(name = "servico_oferecido", nullable = false)
    private String servicoOferecido;

	@Column(name = "valor_medio", nullable = false)
    private BigDecimal valorMedio;

	@Column(name = "formacao", nullable = false)
    private String formacao;

	@Column(name = "principais_habilidades", nullable = false)
    private String principaisHabilidades;

	@Column(name = "tempo_de_atuacao", nullable = false)
    private BigDecimal tempoDeAtuacao;

	@Column(name = "idioma", nullable = false)
    private String idioma;

	@Column(name = "email", nullable = false)
    private String email;

	@Column(name = "numero_telefone", nullable = false)
    private String numeroTelefone;

	@Column(name = "linkedin", nullable = false)
    private String linkedin;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Icone icone;

	public Icone getIcone() {
		return icone;
	}

	public void setIcone(Icone icone) {
		this.icone = icone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getServicoOferecido() {
		return servicoOferecido;
	}

	public void setServicoOferecido(String servicoOferecido) {
		this.servicoOferecido = servicoOferecido;
	}

	public BigDecimal getValorMedio() {
		return valorMedio;
	}

	public void setValorMedio(BigDecimal valorMedio) {
		this.valorMedio = valorMedio;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getPrincipaisHabilidades() {
		return principaisHabilidades;
	}

	public void setPrincipaisHabilidades(String principaisHabilidades) {
		this.principaisHabilidades = principaisHabilidades;
	}

	public BigDecimal getTempoDeAtuacao() {
		return tempoDeAtuacao;
	}

	public void setTempoDeAtuacao(BigDecimal tempoDeAtuacao) {
		this.tempoDeAtuacao = tempoDeAtuacao;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
    
}
