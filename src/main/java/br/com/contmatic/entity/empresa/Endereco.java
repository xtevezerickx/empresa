package br.com.contmatic.entity.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Endereco {
	/**
	 * Constante para tamanho maximo nome do logradouro
	 */
	private static final int TAMANHO_MAX_NOME_LOGRADOURO = 30;
	/**
	 * Constante para tamanho minimo nome do logradouro
	 */
	private static final int TAMANHO_MIN_NOME_LOGRADOURO = 4;
	/**
	 * Constante para tamanho maximo tipo do logradouro
	 */
	private static final int TAMANHO_MAX_TIPO_LOGRADOURO = 15;
	/**
	 * Constante para tamanho minimo para tipo de logradouro
	 */
	private static final int TAMANHO_MIN_TIPO_LOGRADOURO = 2;
	/**
	 * Constante para tamanho do cep
	 */
	private static final int TAMANHO_CEP = 8;
	/**
	 * Constante para tamanho maximo do campo cidade
	 */
	private static final int TAMANHO_MAX_CIDADE = 30;
	/**
	 * Constante para tamanho maximo do campo estado
	 */
	private static final int TAMANHO_MAX_ESTADO = 15;
	/**
	 * Constante para o tamanho maximo do campo bairro
	 */
	private static final int TAMANHO_MAX_BAIRRO = 25;
	/**
	 * Constante para o tamanho do numero
	 */
	private static final int TAMANHO_NUMERO = 10;
	/**
	 * Contante para o tamanho minimo do bairro
	 */
	private static final int TAMANHO_MIN_BAIRRO = 4;
	/**
	 * Contante para o tamanho minimo da cidade
	 */
	private static final int TAMANHO_MIN_CIDADE = 3;
	/**
	 * Recebe o nome do logradouro
	 */
	@NotNull(message=" É necessário preencher o campo nome logradouro")
	@NotBlank(message="Nome Logradouro não pode estar vazio")
	@Max(value=TAMANHO_MAX_NOME_LOGRADOURO,message="O campo nome logradouro esta maior que o aceitavel")
	@Min(value=TAMANHO_MIN_NOME_LOGRADOURO,message="O campo nome logradouro esta menor que o aceitavel")
	@Pattern(regexp = "\\D{4-30}")
	private String nomeLogradouro;
	/**
	 * Recebe o tipo de logradouro
	 */
	@NotNull(message="É necessário preencher o campo tipo logradouro")
	@NotBlank(message="Tipo do logradouro não pode ser vazio")
	@Max(value=TAMANHO_MAX_TIPO_LOGRADOURO,message="O tipo de logradouro esta maior que o aceitavel")
	@Min(value=TAMANHO_MIN_TIPO_LOGRADOURO,message="O tipo de logradouro esta menor que o aceitavel")
	@Pattern(regexp = "\\D{2-15}")
	
	private String tipoLogradouro;
	/**
	 * Recebe o numero
	 */
	@NotNull(message="É necessário preencher o campo numero")
	@Size(max=TAMANHO_NUMERO,message="O campo numero está com tamanha incorreto")
	@NotBlank(message="O numero não pode ser vazio")
	@Pattern(regexp = "\\d{1-10}")
	private String numero;
	/**
	 * Recebe o cep
	 */
	@NotNull(message="É necessário preencher o campo CEP")
	@Length(max=TAMANHO_CEP,message="O campo CEP está com o tamanho incorreto")
	@NotBlank(message="O campo CEP não deve ser vazio")
	@Pattern(regexp = "\\d{8}")
	private String cep;
	/**
	 * Recebe a cidade
	 */
	@NotNull(message="É necessário preencher o campo cidade")
	@NotBlank(message="O campo cidade não pode ser vazio")
	@Min(value = TAMANHO_MIN_CIDADE,message="O campo cidade contem menos caracteres que o aceitavel")
	@Max(value=TAMANHO_MAX_CIDADE,message="O campo cidade contem mais caracteres que o aceitavel")
	@Pattern(regexp = "\\D{3-30}")
	private String cidade;
	/**
	 * Recebe o estado
	 */
	@NotNull(message="É necessário preencher o campo estado")
	@Size(max=TAMANHO_MAX_ESTADO,message="O campo estado está com tamanho incorreto")
	@NotEmpty(message="O campo estado não pode ser vazio")
	@Pattern(regexp = "\\D{3-15}")
	private String estado;
	/**
	 * Recebe o bairro
	 */
	@NotNull(message="É necessário preencher o campo bairro")
	@Size(min=TAMANHO_MIN_BAIRRO,max=TAMANHO_MAX_BAIRRO,message="O campo bairro está com tamanho incorreto")
	@NotBlank(message="O campo bairro não pode ser vazio")
	@Pattern(regexp="\\D{4-25}")
	private String bairro;

	/**
	 * Retorna o nome do logradouro
	 * 
	 * @return String nomeLogradouro
	 */
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	/**
	 * Recebe uma String nome logradouro como parametro e insere esta String na
	 * variavel nomeLogradouro É feito a validação do parametro antes de inserir
	 * na variavel do objeto, caso aconteça alguma excessão, é lançado uma
	 * mensagem correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 *             , caso o nome do logradouro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o nome do logradouro seja nulo
	 * 
	 */
	public void setNomeLogradouro(String nomeLogradouro) {
		this.validateNomeLogradouroAll(nomeLogradouro);
		this.nomeLogradouro = nomeLogradouro;
	}

	/**
	 * Retorna o tipoLogradouro do objeto(endereco)
	 * 
	 * @return String tipoLogradouro
	 */
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	/**
	 * Recebe uma String tipo logradouro como parametro e insere esta String na
	 * variavel tipoLogradouro É feito a validação do parametro antes de inserir
	 * na variavel do objeto, caso aconteça alguma excessão, é lançado uma
	 * mensagem correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param tipoLogradouro
	 * @throws IllegalArgumentException
	 *             , caso o nome do logradouro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o nome do logradouro seja nulo
	 * 
	 */
	public void setTipoLogradouro(String tipoLogradouro) {
		this.validateTipoLogradouroAll(tipoLogradouro);
		this.tipoLogradouro = tipoLogradouro;
	}

	/**
	 * Retorna o numero do objeto(endereco)
	 * 
	 * @return String numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Recebe uma String numero como parametro e insere esta String na variavel
	 * numero É feito a validação do parametro antes de inserir na variavel do
	 * objeto, caso aconteça alguma excessão, é lançado uma mensagem
	 * correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 *             , caso o numero contenha letras,seja vazio ou tamanho
	 *             incorreto
	 * @throws NullArgumentException
	 *             , caso o numero seja nulo
	 * 
	 */
	public void setNumero(String numero) {
		this.validateNumeroAll(numero);
		this.numero = numero;
	}

	/**
	 * Retorna o CEP do objeto(endereço)
	 * 
	 * @return String cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Recebe uma String cep como parametro e insere esta String na variavel cep
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao
	 * erro e o parametro não é inserido na variavel.
	 * 
	 * @param cep
	 * @throws IllegalArgumentException
	 *             , caso o cep contenha letras,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o cep seja nulo
	 * 
	 */
	public void setCep(String cep) {
		this.validateCepAll(cep);
		this.cep = cep;
	}

	/**
	 * Retorna a cidade do objeto(endereço)
	 * 
	 * @return String cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Recebe uma String cidade como parametro e insere esta String na variavel
	 * cidade É feito a validação do parametro antes de inserir na variavel do
	 * objeto, caso aconteça alguma excessão, é lançado uma mensagem
	 * correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param cidade
	 * @throws IllegalArgumentException
	 *             , caso a cidade contenha numeros,seja vazio ou tamanho
	 *             incorreto
	 * @throws NullArgumentException
	 *             , caso o nome do logradouro seja nulo
	 * 
	 */
	public void setCidade(String cidade) {
		this.validateCidadeAll(cidade);
		this.cidade = cidade;
	}

	/**
	 * Retorna o estado do objeto(endereço)
	 * 
	 * @return String estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Recebe uma String estado como parametro e insere esta String na variavel
	 * estado É feito a validação do parametro antes de inserir na variavel do
	 * objeto, caso aconteça alguma excessão, é lançado uma mensagem
	 * correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 *             , caso o estado contenha numeros,seja vazio ou tamanho
	 *             incorreto
	 * @throws NullArgumentException
	 *             , caso o nome do logradouro seja nulo
	 * 
	 */
	public void setEstado(String estado) {
		this.validateEstadoAll(estado);
		this.estado = estado;
	}

	/**
	 * Retorna o bairro do objeto(endereço)
	 * 
	 * @return String objeto
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Recebe uma String bairro como parametro e insere esta String na variavel
	 * bairro É feito a validação do parametro antes de inserir na variavel do
	 * objeto, caso aconteça alguma excessão, é lançado uma mensagem
	 * correpondente ao erro e o parametro não é inserido na variavel.
	 * 
	 * @param bairro
	 * @throws IllegalArgumentException
	 *             , caso o bairro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o bairro seja nulo
	 * 
	 */
	public void setBairro(String bairro) {
		this.validateBairroAll(bairro);
		this.bairro = bairro;
	}

	/**
	 * Valida se o parametro recebido nome logradouro está nulo
	 * 
	 * @param nomeLogradouro
	 * @throws NullPointerException
	 */
	private void validateNomeLogradouroNotNull(String nomeLogradouro) {
		checkNotNull(nomeLogradouro, "Nome Logradouro deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido nomeLogradouro está vazio
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateNomeLogradouroVazio(String nomeLogradouro) {
		checkArgument(!nomeLogradouro.isEmpty(), "Nome Logradouro não pode estar vazio");
	}

	/**
	 * Valida se o parametro recebido nome logradouro está com tamanho maior que
	 * o aceitavel
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateNomeLogradouroTamanhoMaximo(String nomeLogradouro) {
		checkArgument(!(nomeLogradouro.length() > TAMANHO_MAX_NOME_LOGRADOURO),
				"O campo nome logradouro esta maior que o aceitavel");
	}

	/**
	 * Valida se o parametro recebido nome logradouro está com tamanho menor que
	 * o aceitavel
	 * 
	 * @param nomeLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateNomeLogradouroTamanhoMinimo(String nomeLogradrouro) {
		checkArgument(!(nomeLogradrouro.length() < TAMANHO_MIN_NOME_LOGRADOURO),
				"O campo nome logradouro esta menor que o aceitavel");
	}

	/**
	 * Recebe o parametro nome logradouro e faz a validação de todos os casos
	 * 
	 * @param nomeLogradouro
	 ** @throws IllegalArgumentException
	 *             , caso o nome do logradouro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o nome do logradouro seja nulo
	 */
	private void validateNomeLogradouroAll(String nomeLogradouro) {
		this.validateNomeLogradouroNotNull(nomeLogradouro);
		this.validateNomeLogradouroVazio(nomeLogradouro);
		this.validateNomeLogradouroTamanhoMinimo(nomeLogradouro);
		this.validateNomeLogradouroTamanhoMaximo(nomeLogradouro);
	}

	/**
	 * Valida se o parametro recebido tipoLogradouro está nulo
	 * 
	 * @param tipoLogradouro
	 * @throws NullPointerException
	 */
	private void validateTipoLogradouroNotNull(String tipoLogradouro) {
		checkNotNull(tipoLogradouro, "Tipo do logradouro deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido tipo logradouro está vazio
	 * 
	 * @param tipoLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateTipoLogradouroVazio(String tipoLogradouro) {
		checkArgument(!(tipoLogradouro.isEmpty()), "Tipo do logradouro não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido tipo logradouro está com tamanho maior que
	 * o aceitavel
	 * 
	 * @param tipoLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateTipoLogradouroTamanhoMaximo(String tipoLogradouro) {
		checkArgument(!(tipoLogradouro.length() > TAMANHO_MAX_TIPO_LOGRADOURO),
				"O tipo de logradouro esta maior que o aceitavel");
	}

	/**
	 * Valida se o parametro recebido tipo logradouro está com tamanho menor que
	 * o aceitavel
	 * 
	 * @param tipoLogradouro
	 * @throws IllegalArgumentException
	 */
	private void validateTipoLogradouroTamanhoMinimo(String tipoLogradouro) {
		checkArgument(!(tipoLogradouro.length() < TAMANHO_MIN_TIPO_LOGRADOURO),
				"O tipo de logradouro esta menor que o aceitavel");
	}

	/**
	 * Recebe o parametro tipo logradouro e faz a validação de todos os casos
	 * 
	 * @param tipoLogradouro
	 ** @throws IllegalArgumentException
	 *             , caso o tipo de logradouro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o tipo de logradouro seja nulo
	 */
	private void validateTipoLogradouroAll(String tipoLogradouro) {
		this.validateTipoLogradouroNotNull(tipoLogradouro);
		this.validateTipoLogradouroVazio(tipoLogradouro);
		this.validateTipoLogradouroTamanhoMinimo(tipoLogradouro);
		this.validateTipoLogradouroTamanhoMaximo(tipoLogradouro);
	}

	/**
	 * Valida se o parametro recebido numero está nulo
	 * 
	 * @param numero
	 * @throws NullPointerException
	 */
	private void validateNumeroNotNull(String numero) {
		checkNotNull(numero, "O campo numero deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido numero está vazio
	 * 
	 * @param numero
	 * @throws IllegalArgumentException
	 */
	private void validateNumeroVazio(String numero) {
		checkArgument(!numero.isEmpty(), "O numero não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido numero está com tamanho correto
	 * 
	 * @param numero
	 * @throws IllegalArgumentException
	 */
	private void validateNumeroTamanhoIncorreto(String numero) {
		checkArgument(!(numero.length() > TAMANHO_NUMERO), "O campo numero esta com tamanho incorreto");
	}

	/**
	 * Recebe o parametro numero e faz a validação de todos os casos
	 * 
	 * @param numero
	 ** @throws IllegalArgumentException
	 *             , caso o numero seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o numero seja nulo
	 */
	private void validateNumeroAll(String numero) {
		this.validateNumeroNotNull(numero);
		this.validateNumeroVazio(numero);
		this.validateNumeroTamanhoIncorreto(numero);
	}
	/**
	 * Valida se o parametro recebido cep contem letras
	 * @param cep
	 * @throws IllegalArgumentException
	 */
	private void validateCepComLetras(String cep) {
		for (int i = 0; i < cep.length(); i++) {
			char cepchar = cep.charAt(i);
			checkArgument(!isLetter(cepchar), "O CEP não pode conter letras");
		}

	}

	/**
	 * Valida se o parametro recebido cep está nulo
	 * 
	 * @param cep
	 * @throws NullPointerException
	 */
	private void validateCepNotNull(String cep) {
		checkNotNull(cep, "O CEP deve ser preenchido ");
	}

	/**
	 * Valida se o parametro recebido CEP está vazio
	 * 
	 * @param cep
	 * @throws IllegalArgumentException
	 */
	private void validateCepVazio(String cep) {
		checkArgument(!cep.isEmpty(), "O CEP não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido cep está com tamanho correto
	 * 
	 * @param cep
	 * @throws IllegalArgumentException
	 */
	private void validateCepTamanhoIncorreto(String cep) {
		checkArgument(!(cep.length() != TAMANHO_CEP), "O tamanho do CEP esta incorreto");
	}

	/**
	 * Recebe o parametro cep e faz a validação de todos os casos
	 * 
	 * @param cep
	 ** @throws IllegalArgumentException
	 *             , caso o cep seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o cep seja nulo
	 */
	private void validateCepAll(String cep) {
		this.validateCepNotNull(cep);
		this.validateCepVazio(cep);
		this.validateCepComLetras(cep);
		this.validateCepTamanhoIncorreto(cep);
	}

	/**
	 * Valida se o parametro recebido cidade está nulo
	 * 
	 * @param cidade
	 * @throws NullPointerException
	 */
	private void validateCidadeNotNull(String cidade) {
		checkNotNull(cidade, "O campo cidade deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido cidade está vazio
	 * 
	 * @param cidade
	 * @throws IllegalArgumentException
	 */
	private void validateCidadeVazio(String cidade) {
		checkArgument(!cidade.isEmpty(), "O campo cidade não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido cidade contem letras
	 * @param cidade
	 * @throws IllegalArgumentException
	 */
	private void validateCidadeComNumero(String cidade) {
		for (int i = 0; i < cidade.length(); i++) {
			char cidadechar = cidade.charAt(i);
			checkArgument(!isDigit(cidadechar), "O campo cidade não pode conter numeros");
		}
	}
	/**
	 * Valida se o parametro recebido estado contem letras
	 * @param estado
	 * @throws IllegalArgumentException
	 */
	private void validateEstadoComNumero(String estado) {
		for (int i = 0; i < estado.length(); i++) {
			char estadochar = estado.charAt(i);
			checkArgument(!isDigit(estadochar), "O campo estado não pode conter numeros");
		}
	}

	/**
	 * Valida se o parametro recebido cidade está com tamanho maior que o
	 * aceitavel
	 * 
	 * @param cidade
	 * @throws IllegalArgumentException
	 */
	private void validateCidadeTamanhoMaximo(String cidade) {
		checkArgument(!(cidade.length() > TAMANHO_MAX_CIDADE), "O campo cidade contem mais caracteres que o aceitavel");
	}

	/**
	 * Valida se o parametro recebido cidade está com tamanho menor que o
	 * aceitavel
	 * 
	 * @param cidade
	 * @throws IllegalArgumentException
	 */
	private void validateCidadeTamanhoMinimo(String cidade) {
		checkArgument(!(cidade.length() < TAMANHO_MIN_CIDADE),"O campo cidade contem menos caracteres que o aceitavel");
	}

	/**
	 * Recebe o parametro cidade e faz a validação de todos os casos
	 * 
	 * @param cidade
	 ** @throws IllegalArgumentException
	 *             , caso a cidade contenha numeros,seja vazio ou tamanho
	 *             incorreto
	 * @throws NullArgumentException
	 *             , caso a cidade seja nulo
	 */
	private void validateCidadeAll(String cidade) {
		this.validateCidadeNotNull(cidade);
		this.validateCidadeVazio(cidade);
		this.validateCidadeComNumero(cidade);
		this.validateCidadeTamanhoMinimo(cidade);
		this.validateCidadeTamanhoMaximo(cidade);
	}

	/**
	 * Valida se o parametro recebido estado está nulo
	 * 
	 * @param estado
	 * @throws NullPointerException
	 */
	private void validateEstadoNotNull(String estado) {
		checkNotNull(estado, "O campo estado deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido estado está vazio
	 * 
	 * @param estado
	 * @throws IllegalArgumentException
	 */
	private void validateEstadoVazio(String estado) {
		checkArgument(!estado.isEmpty(), "O campo estado não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido estado está com tamanho maior que o
	 * aceitavel
	 * 
	 * @param estado
	 * @throws IllegalArgumentException
	 */
	private void validateEstadoTamanhoCorreto(String estado) {
		checkArgument(!(estado.length() > TAMANHO_MAX_ESTADO), "O campo estado contem mais caracteres que o aceitavel");
	}

	/**
	 * Recebe o parametro estado e faz a validação de todos os casos
	 * 
	 * @param estado
	 ** @throws IllegalArgumentException
	 *             , caso o estado contenha numero,seja vazio ou tamanho
	 *             incorreto
	 * @throws NullArgumentException
	 *             , caso o estado seja nulo
	 */
	private void validateEstadoAll(String estado) {
		this.validateEstadoNotNull(estado);
		this.validateEstadoVazio(estado);
		this.validateEstadoComNumero(estado);
		this.validateEstadoTamanhoCorreto(estado);
	}

	/**
	 * Valida se o parametro recebido bairro está nulo
	 * 
	 * @param bairro
	 * @throws NullPointerException
	 */
	private void validateBairroNotNull(String bairro) {
		checkNotNull(bairro, "O campo bairro deve ser preenchido");
	}

	/**
	 * Valida se o parametro recebido bairro está vazio
	 * 
	 * @param bairro
	 * @throws IllegalArgumentException
	 */
	private void validateBairroVazio(String bairro) {
		checkArgument(!bairro.isEmpty(), "O campo bairro não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido bairro está com tamanho maior que o aceitavel
	 * @param bairro
	 * @throws IllegalArgumentException
	 */
	private void validateBairroTamanhoIncorreto(String bairro) {
		checkArgument(!(bairro.length() > TAMANHO_MAX_BAIRRO), "O campo bairro contem mais caracteres que o aceitavel");
	}
	/**
	 * Valida se o parametro recebido bairro está com tamanho menor que o aceitavel
	 * @param bairro
	 * @throws IllegalArgumentException
	 */
	private void validateBairroTamanhoMinimo(String bairro) {
		checkArgument(!(bairro.length() < TAMANHO_MIN_BAIRRO),
				"O campo bairro contem menos caracteres que o aceitavel");
	}

	/**
	 * Recebe o parametro bairro e faz a validação de todos os casos
	 * 
	 * @param bairro
	 * @throws IllegalArgumentException
	 *             , caso o bairro seja vazio ou tamanho incorreto
	 * @throws NullArgumentException
	 *             , caso o bairro seja nulo
	 */
	private void validateBairroAll(String bairro) {
		this.validateBairroNotNull(bairro);
		this.validateBairroVazio(bairro);
		this.validateBairroTamanhoIncorreto(bairro);
		this.validateBairroTamanhoMinimo(bairro);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    return new HashCodeBuilder().append(this.cep).append(this.numero).build();	    		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Endereco other = (Endereco) obj;
		return new EqualsBuilder().append(this.cep, other.cep).append(this.numero, other.numero).build();
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this,StandardToStringStyle.MULTI_LINE_STYLE)
	            .append(this.nomeLogradouro!=null?"Nome Logradouro "+this.nomeLogradouro:null)
	            .append(this.tipoLogradouro!=null?"Tipo Logradouro "+this.tipoLogradouro:null)
	            .append(this.numero!=null?"Numero "+this.numero:null)
	            .append(this.cep!=null?"CEP "+this.cep:null)
	            .append(this.cidade!=null?"Cidade "+this.cidade:null)
	            .append(this.estado!=null?"Estado "+this.estado:null)
	            .append(this.bairro!=null?"Bairro "+this.bairro:null)
	            .toString();
	}
	
	
	
}


