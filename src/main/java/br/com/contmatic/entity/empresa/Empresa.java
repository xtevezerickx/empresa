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
	private static final int TAMANHO_CNPJ = 14;
	private static final int TAMANHO_MIN_NOME_FANTASIA=8;
	private static final int TAMANHO_MAX_NOME_FANTASIA=30;
	private static final int TAMANHO_MIN_NOME_PROPRIETARIO=8;
	private static final int TAMANHO_MAX_NOME_PROPRIETARIO=30;
	private static final int TAMANHO_MIN_EMAIL=9;
	private static final int TAMANHO_MAX_EMAIL=30;
	

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
		this.validateNomeFantasiaAll(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.validateNomeProprietarioAll(nomeProprietario);
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
		this.validateEmailAll(email);
		this.email = email;
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
		this.validateCNPJAll(cnpj);
		this.cnpj = cnpj;
	}

	private void validateCNPJNotNull(String cnpj) {

		if (cnpj == null) {
			throw new IllegalArgumentException("CNPJ não pode ser nulo");
		}
	}

	private void validateTamanhoCNPJ(String cnpj) {
		if (cnpj.length() != TAMANHO_CNPJ) {
			throw new IllegalArgumentException("Tamanho do CNPJ incorreto");
		}
	}

	private void validateCNPJVazio(String cnpj) {
		if (cnpj.isEmpty()) {
			throw new IllegalArgumentException("CNPJ não pode estar vazio");
		}
	}

	private void validateCNPJContemLetra(String cnpj) {
		for (int i = 0; i < cnpj.length(); i++) {
			char c = cnpj.charAt(i);
			if (Character.isLetter(c)) {
				throw new IllegalArgumentException("CNPJ não pode conter letras");
			}
		}

	}

	private void validateCNPJAll(String cnpj) {
		this.validateCNPJNotNull(cnpj);
		this.validateCNPJVazio(cnpj);
		this.validateCNPJContemLetra(cnpj);
		this.validateTamanhoCNPJ(cnpj);

	}

	private void validateNomeFantasiaNotNull(String nomeFantasia){
		if (nomeFantasia==null){
			throw new IllegalArgumentException("Nome Fantasia não pode ser nulo");
		}
	}

	private void validateNomeFantasiaVazio(String nomeFantasia){
		if (nomeFantasia.isEmpty()){
			throw new IllegalArgumentException("Nome Fantasia não pode estar vazio");
		}
	}
	
	private void validateNomeFantasiaTamanhoMinimo(String nomeFantasia){
		if(nomeFantasia.length()<TAMANHO_MIN_NOME_FANTASIA){
			throw new IllegalArgumentException("O Tamanho do nome fantasia esta menor que: "+TAMANHO_MIN_NOME_FANTASIA);
		}
	}
	
	private void validateNomeFantasiaTamanhoMaximo(String nomeFantasia){
		if(nomeFantasia.length()>TAMANHO_MAX_NOME_FANTASIA){
			throw new IllegalArgumentException("O Tamanho do nome fantasia esta maior que: "+ TAMANHO_MAX_NOME_FANTASIA);
		}
	}
	
	private void validateNomeFantasiaAll(String nomeFantasia){
		this.validateNomeFantasiaNotNull(nomeFantasia);
		this.validateNomeFantasiaVazio(nomeFantasia);
		this.validateNomeFantasiaTamanhoMinimo(nomeFantasia);
		this.validateNomeFantasiaTamanhoMaximo(nomeFantasia);
		
	}
	
	private void validateNomeProprietarioNotNull(String nomeProprietario){
		if(nomeProprietario==null){
			throw new IllegalArgumentException("Nome do proprietário não pode ser nulo");
		}
	}
	
	private void validateNomeProprietarioVazio(String nomeProprietario){
		if(nomeProprietario.isEmpty()){
			throw new IllegalArgumentException("Nome do proprietário não pode estar vazio");
		}
	}
	
	private void validateNomeProprietarioTamanhoMinimo(String nomeProprietario){
		if (nomeProprietario.length()<TAMANHO_MIN_NOME_PROPRIETARIO){
			throw new IllegalArgumentException("O Tamanho do nome proprietario esta menor que: "+TAMANHO_MIN_NOME_PROPRIETARIO);
		}
	}
	
	private void validateNomeProprietarioTamanhoMaximo(String nomeProprietario){
		if (nomeProprietario.length()>TAMANHO_MAX_NOME_PROPRIETARIO){
			throw new IllegalArgumentException("O Tamanho do nome fantasia esta maior que: "+TAMANHO_MAX_NOME_PROPRIETARIO);
		}
	}
	
	private void validateNomeProprietarioComNumeros(String nomeProprietario){
		for (int i=0;i<nomeProprietario.length();i++){
			char nome=nomeProprietario.charAt(i);
			if(Character.isDigit(nome)){
				throw new IllegalArgumentException("Nome do proprietario não pode conter numeros");
			}
		}
	}
	
	private void validateNomeProprietarioAll(String nomeProprietario){
		this.validateNomeProprietarioNotNull(nomeProprietario);
		this.validateNomeProprietarioVazio(nomeProprietario);
		this.validateNomeProprietarioTamanhoMinimo(nomeProprietario);
		this.validateNomeProprietarioTamanhoMaximo(nomeProprietario);
		this.validateNomeProprietarioComNumeros(nomeProprietario);
	}
	
	private void validateEmailNotNull(String email){
		if(email==null){
			throw new IllegalArgumentException("Email não pode ser nulo");
		}
	}
	
	private void validateEmailVazio(String email){
		if(email.isEmpty()){
			throw new IllegalArgumentException("Email não pode ser vazio");
		}
	}
	
	private void validateEmailTamanhoMinimo(String email){
		if(email.length()<TAMANHO_MIN_EMAIL){
			throw new IllegalArgumentException("O Tamanho do email esta menor que: "+TAMANHO_MIN_EMAIL);
		}
	}
	
	private void validateEmailTamanhoMaximo(String email){
		if (email.length()>TAMANHO_MAX_EMAIL){
			throw new IllegalArgumentException("O Tamanho do email esta maior que: "+TAMANHO_MAX_EMAIL);
		}
	}
	
	private void validateEmailAll(String email){
		this.validateEmailNotNull(email);
		this.validateEmailVazio(email);
		this.validateEmailTamanhoMinimo(email);
		this.validateEmailTamanhoMaximo(email);
		
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
