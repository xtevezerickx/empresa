package br.com.contmatic.entity.empresa;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Empresa {
	private String nomeFantasia;
	private String nomeProprietario;
	private String cnpj;
	private String email;
	private Telefone telefone;
	private Endereco endereco;
	private Date criacao;

	public Date getIniciodaempresa() {
		return criacao;
	}

	public void setIniciodaempresa(Date iniciodaempresa) {
		this.criacao = iniciodaempresa;
	}

	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomefantasia() {
		return nomeFantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomeFantasia = nomefantasia;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.cnpj).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Nome Fantasia" + this.nomeFantasia)
				.append("Nome do Propietário: " + this.nomeProprietario).append("CNPJ: " + this.cnpj)
				.append("Email:" + this.email).append("Telefone" + this.telefone)
				.append("Data de criação" + this.criacao).toString();

	}

}
