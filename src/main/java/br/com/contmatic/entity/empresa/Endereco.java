package br.com.contmatic.entity.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Endereco {
	private String nomeLogradouro;
	private String tipoLogradouro;
	private int numero;
	private String cep;
	private String cidade;
	private String estado;
	private String bairro;

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cep).append(this.numero).toHashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;

		return new EqualsBuilder().append(this.cep, other.cep).append(this.numero, other.numero).isEquals();

	}
	

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("Nome Logradouro: " + this.nomeLogradouro)
				.append("Tipo do Logradouro: " + this.tipoLogradouro).append("Numero: " + this.numero)
				.append("CEP: " + this.cep).append("Cidade" + this.cidade).append("Estado: " + this.estado)
				.append("Bairro" + this.bairro).toString();

	}

}
