package br.com.carlosrodrigues.freela_org.web.dtos;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.carlosrodrigues.freela_org.core.enums.Icone;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoFreelaForm {

    @Size(min = 3, max = 100)
    @NonNull
    private String nome;
    
    @NonNull
    private String servicoOferecido;

    @NonNull
    @PositiveOrZero
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorMedio;

    @NonNull
    private String formacao;

    @NonNull
    private String principaisHabilidades;

    @NonNull
    @PositiveOrZero
    private BigDecimal tempoDeAtuacao;

    @NonNull
    private String idioma;

    @NonNull
    @Email
    private String email;

    @NonNull
    @PositiveOrZero
    private String numeroTelefone;

    @NonNull
    private String linkedin;
	
    @NonNull
	private Icone icone;

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

	public Icone getIcone() {
		return icone;
	}

	public void setIcone(Icone icone) {
		this.icone = icone;
	}
    
}