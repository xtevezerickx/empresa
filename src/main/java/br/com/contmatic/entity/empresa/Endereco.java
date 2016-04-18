package br.com.contmatic.entity.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Endereco {
	private static final int TAMANHO_MAX_NOME_LOGRADOURO = 30;
	private static final int TAMANHO_MIN_NOME_LOGRADOURO = 4;
	private static final int TAMANHO_MAX_TIPO_LOGRADOURO = 15;
	private static final int TAMANHO_MIN_TIPO_LOGRADOURO = 2;
	private static final int TAMANHO_CEP = 8;
	private static final int TAMANHO_MAX_CIDADE = 30;
	private static final int TAMANHO_MAX_ESTADO = 15;
	private static final int TAMANHO_MAX_BAIRRO = 25;
	private static final int TAMANHO_NUMERO = 10;
	private static final int TAMANHO_MIN_BAIRRO = 4;
	private static final int TAMANHO_MIN_CIDADE = 3;
	private String nomeLogradouro;
	private String tipoLogradouro;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String bairro;


	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.validateNomeLogradouroAll(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.validateTipoLogradouroAll(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.validateNumeroAll(numero);
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.validateCepAll(cep);
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.validateCidadeAll(cidade);
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.validateEstadoAll(estado);
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.validateBairroAll(bairro);
		this.bairro = bairro;
	}
	
	private void validateNomeLogradouroNotNull(String nomeLogradouro){
		if(nomeLogradouro==null){
			throw new IllegalArgumentException("Nome Logradouro não pode ser nulo");
		}
	}
	
	private void validateNomeLogradouroVazio(String nomeLogradouro){
		if(nomeLogradouro.isEmpty()){
			throw new IllegalArgumentException("Nome Logradouro não pode estar vazio");
		}
	}
	
	private void validateNomeLogradouroTamanhoMaximo(String nomeLogradouro){
		if(nomeLogradouro.length()>TAMANHO_MAX_NOME_LOGRADOURO){
			throw new IllegalArgumentException("O tamanho do nome logradouro esta maior que o aceitavel");
		}
	}
	
	private void validateNomeLogradouroTamanhoMinimo(String nomeLogradrouro){
		if(nomeLogradrouro.length()<TAMANHO_MIN_NOME_LOGRADOURO){
			throw new IllegalArgumentException("O tamanho do nome logradouro esta menor que o aceitavel");
		}
	}
	
	private void validateNomeLogradouroAll(String nomeLogradouro){
		this.validateNomeLogradouroNotNull(nomeLogradouro);
		this.validateNomeLogradouroVazio(nomeLogradouro);
		this.validateNomeLogradouroTamanhoMinimo(nomeLogradouro);
		this.validateNomeLogradouroTamanhoMaximo(nomeLogradouro);
	}
	
	private void validateTipoLogradouroNotNull (String tipoLogradouro){
		if (tipoLogradouro==null){
			throw new IllegalArgumentException("Tipo do logradouro nao pode ser nulo");
		}
	}
	
	private void validateTipoLogradouroVazio(String tipoLogradouro){
		if(tipoLogradouro.isEmpty()){
			throw new IllegalArgumentException("Tipo do logradouro não pode ser vazio");
		}
	}
	
	private void validateTipoLogradouroTamanhoMaximo(String tipoLogradouro){
		if(tipoLogradouro.length()>TAMANHO_MAX_TIPO_LOGRADOURO){
			throw new IllegalArgumentException("O tipo de logradouro esta maior que o aceitavel");
		}
	}
	
	private void validateTipoLogradouroTamanhoMinimo(String tipoLogradouro){
		if(tipoLogradouro.length()<TAMANHO_MIN_TIPO_LOGRADOURO){
			throw new IllegalArgumentException("O tipo de logradouro esta menor que o aceitavel");
		}
	}
	
	private void validateTipoLogradouroAll(String tipoLogradouro){
		this.validateTipoLogradouroNotNull(tipoLogradouro);
		this.validateTipoLogradouroVazio(tipoLogradouro);
		this.validateTipoLogradouroTamanhoMinimo(tipoLogradouro);
		this.validateTipoLogradouroTamanhoMaximo(tipoLogradouro);
	}
	
	private void validateNumeroNotNull (String numero){
		if (numero==null){
			throw new IllegalArgumentException("O numero não pode ser nulo");
		}
	}
	
	private void validateNumeroVazio(String numero){
		if(numero.isEmpty()){
			throw new IllegalArgumentException("O numero não pode ser vazio");
		}
	}
	
	private void validateNumeroTamanhoIncorreto(String numero){
		if(numero.length()>TAMANHO_NUMERO){
			throw new IllegalArgumentException("O campo numero esta com tamanho incorreto");
		}
	}
	
	private void validateNumeroAll(String numero){
		this.validateNumeroNotNull(numero);
		this.validateNumeroVazio(numero);
		this.validateNumeroTamanhoIncorreto(numero);
	}
	
	private void validateCepComLetras(String cep){
		for (int i = 0; i < cep.length(); i++) {
			char cepchar=cep.charAt(i);
			if(Character.isLetter(cepchar)){
				throw new IllegalArgumentException("O CEP não pode conter letras");
			}
		}
		
	}
	
	private void validateCepNotNull(String cep){
		if(cep==null){
			throw new IllegalArgumentException("O CEP não pode ser nulo ");
		}
	}
	
	private void validateCepVazio(String cep){
		if(cep.isEmpty()){
			throw new IllegalArgumentException("O CEP não pode ser vazio");
		}
	}
	
	private void validateCepTamanhoIncorreto(String cep){
		if (cep.length()!=TAMANHO_CEP){
			throw new IllegalArgumentException("O tamanho do CEP esta incorreto");
		}
	}
	
	private void validateCepAll(String cep){
		this.validateCepNotNull(cep);
		this.validateCepVazio(cep);
		this.validateCepComLetras(cep);
		this.validateCepTamanhoIncorreto(cep);
	}
	
	private void validateCidadeNotNull(String cidade){
		if(cidade==null){
			throw new IllegalArgumentException("A cidade não pode ser nulo");
		}
	}
	
	private void validateCidadeVazio(String cidade){
		if(cidade.isEmpty()){
			throw new IllegalArgumentException("A cidade não pode ser vazio");
		}
	}
	
	private void validateCidadeComNumero(String cidade){
		for (int i = 0; i < cidade.length(); i++) {
			char cidadechar = cidade.charAt(i);
			if(Character.isDigit(cidadechar)){
				throw new IllegalArgumentException("A cidade não pode conter numeros");
			}
		}
	}
	
	private void validateEstadoComNumero(String estado){
		for (int i = 0; i < estado.length(); i++) {
			char estadochar = estado.charAt(i);
			if(Character.isDigit(estadochar)){
				throw new IllegalArgumentException("O estado não pode conter numeros");
			}
		}
	}
	
	private void validateCidadeTamanhoMaximo(String cidade){
		if (cidade.length()>TAMANHO_MAX_CIDADE){
			throw new IllegalArgumentException("O campo cidade contem mais caracteres que o aceitavel");
		}
	}
	
	private void validateCidadeTamanhoMinimo(String cidade){
		if (cidade.length()<TAMANHO_MIN_CIDADE){
			throw new IllegalArgumentException("O campo cidade contem menos caracteres que o aceitavel");
		}
	}
	
	private void validateCidadeAll(String cidade){
		this.validateCidadeNotNull(cidade);
		this.validateCidadeVazio(cidade);
		this.validateCidadeComNumero(cidade);
		this.validateCidadeTamanhoMinimo(cidade);
		this.validateCidadeTamanhoMaximo(cidade);
	}
	
	private void validateEstadoNotNull(String estado){
		if(estado==null){
			throw new IllegalArgumentException("O estado não pode ser nulo");
		}
	}
	
	private void validateEstadoVazio(String estado){
		if(estado.isEmpty()){
			throw new IllegalArgumentException("O estado não pode ser vazio");
		}
	}
	
	private void validateEstadoTamanhoCorreto(String estado){
		if(estado.length()>TAMANHO_MAX_ESTADO){
			throw new IllegalArgumentException("O tamanho do campo estado esta incorreto");
		}
	}
	
	private void validateEstadoAll(String estado){
		this.validateEstadoNotNull(estado);
		this.validateEstadoVazio(estado);
		this.validateEstadoComNumero(estado);
		this.validateEstadoTamanhoCorreto(estado);
	}
	
	private void validateBairroNotNull(String bairro){
		if (bairro==null){
			throw new IllegalArgumentException("O bairro não pode ser nulo");
		}
	}
	
	private void validateBairroVazio(String bairro){
		if(bairro.isEmpty()){
			throw new IllegalArgumentException("O bairro não pode ser vazio");
		}
	}
	
	private void validateBairroTamanhoIncorreto(String bairro){
		if(bairro.length()>TAMANHO_MAX_BAIRRO){
			throw new IllegalArgumentException("O campo bairro contem mais caracteres que o aceitavel");
		}
	}
	
	private void validateBairroTamanhoMinimo(String bairro){
		if(bairro.length()<TAMANHO_MIN_BAIRRO){
			throw new IllegalArgumentException("O campo bairro contem menos caracteres que o aceitavel");
		}
	}
	
	private void validateBairroAll(String bairro){
		this.validateBairroNotNull(bairro);
		this.validateBairroVazio(bairro);
		this.validateBairroTamanhoIncorreto(bairro);
		this.validateBairroTamanhoMinimo(bairro);
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
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("Nome Logradouro: " + this.nomeLogradouro)
				.append("Tipo do Logradouro: " + this.tipoLogradouro)
				.append("Numero: " + this.numero)
				.append("CEP: " + this.cep)
				.append("Cidade" + this.cidade)
				.append("Estado: " + this.estado)
				.append("Bairro: " + this.bairro)
				.build();

	}

}
