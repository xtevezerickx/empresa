package br.com.contmatic.entity.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Empresa {
	/**
	 * Constante padrão para CNPJ
	 */
	private static final int TAMANHO_CNPJ = 14;
	/**
	 * Constante para tamanho minimo do nome fantasia
	 */
	private static final int TAMANHO_MIN_NOME_FANTASIA = 8;
	/**
	 * Constante para tamanho maximo do nome fantasia
	 */
	private static final int TAMANHO_MAX_NOME_FANTASIA = 30;
	/**
	 * Constante para tamanho minimo do nome proprietario
	 */
	private static final int TAMANHO_MIN_NOME_PROPRIETARIO = 8;
	/**
	 * Constante para tamanho maximo do nome proprietario
	 */
	private static final int TAMANHO_MAX_NOME_PROPRIETARIO = 30;
	/**
	 * Constante para tamanho minimo do email
	 */
	private static final int TAMANHO_MIN_EMAIL = 9;
	/**
	 * Constante para tamanho maximo do email
	 */
	private static final int TAMANHO_MAX_EMAIL = 30;
	
	/**
	 * Recebe o nome fantasia
	 */
	
	@NotNull(message="É necessário preencher o nome fantasia")
	@NotBlank(message="Nome Fantasia não pode estar vazio" )	
	@Max(value=TAMANHO_MAX_NOME_FANTASIA,message="O Tamanho do nome fantasia esta maior que o aceitavel")
	@Min(value=TAMANHO_MIN_NOME_FANTASIA,message="O Tamanho do nome fantasia esta menor que o aceitavel")
	@Pattern(regexp = "\\D{8-30}")  
	private String nomeFantasia;
	
	/**
	 * Recebe o nome do proprietario
	 */
	
	@NotNull(message="É necessário preencher o nome do proprietário")
	private String nomeProprietario;
	/**
	 * Recebe o cnpj da empresa
	 */
	@CNPJ
	@NotNull(message= "CNPJ deve ser preenchido")
	@NotBlank(message="CNPJ não pode estar vazio")
	@Length(max=TAMANHO_CNPJ,message="Tamanho do CNPJ incorrreto")
    private String cnpj;
		
	@Email
	@NotNull(message="É necessário preencher o campo Email")
	@NotBlank(message="Email não pode ser vazio")
    @Size(min=TAMANHO_MIN_EMAIL,max=TAMANHO_MAX_EMAIL,message="Tamanho do email incorreto")
	private String email;
	/**
	 * Recebe os numeros de telefone da empresa
	 */
	
	@NotEmpty
	private Set<Telefone> telefone;
	/**
	 * Recebe os enderecos da empresa
	 */
	@NotEmpty
	private Set<Endereco> endereco;
	/**
	 * Recebe a data de criação da empresa
	 */
	@NotNull(message="Data de criacao deve ser preenchida")
	private DateTime dataCriacao;
	/**
	 * Recebe a data de alteração da empresa
	 */
	private DateTime dataAlteracao;

	/**
	 * Retorna o nome fantasia do objeto
	 * @return String
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel nomeFantasia
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param nomeFantasia
	 * @throws IllegalArgumentException , caso o nome fantasia seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o nome fantasia seja nulo
	 * 
	 */
	
	public void setNomeFantasia(String nomeFantasia) {
		this.validateNomeFantasiaAll(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * Retorna o nome do proprietario do objeto
	 * @return String
	 */
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	/**
	 * Recebe uma String como parametro e insere esta String na variavel nomeProprietario
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param nomeProprietario
	 * @throws IllegalArgumentException , caso o nome proprietario contenha numeros,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o nome fantasia seja nulo
	 * 
	 */
	public void setNomeProprietario(String nomeProprietario) {
		this.validateNomeProprietarioAll(nomeProprietario);
		this.nomeProprietario = nomeProprietario;
	}

	/**
	 * Retorna um array de telefones do objeto
	 * @return Telefone[]
	 */
	public Set<Telefone> getTelefone() {
		return telefone;
	}

	/**
	 * Recebe um array do tipo Telefone como parametro e insere esta array na variavel telefone
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param telefone
	 * @throws NullArgumentException , caso um dos telefones da empresa seja nulo
	 * 
	 */
	public void setTelefone(Set<Telefone> telefone) {
		//this.validateEmpresaPrecisaDeDoisTelefones(telefone);
		this.telefone = telefone;
	}

	/**
	 * Retorna um array de endereços do objeto
	 * @return Endereco[]
	 */
	public Set<Endereco> getEndereco() {
		return endereco;
	}

	/**
	 * Recebe um array do tipo Endereco como parametro e insere esta array na variavel telefone
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param endereco
	 * @throws NullArgumentException , caso um dos enderecos da empresa seja nulo
	 * 
	 */
	@NotNull(message="É necessário preencher o endereço")
	public void setEndereco(Set<Endereco> endereco) {
		this.validateEnderecoNotNull(endereco);
		this.validateEmpresaPrecisaDeDoisEnderecos(endereco);
		this.endereco = endereco;
	}

	/**
	 * Retorna o email do objeto
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel email
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param email
	 * @throws IllegalArgumentException , caso o email seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o email seja nulo
	 * 
	 */
	
	
	
	public void setEmail(String email) {
		this.validateEmailAll(email);
		this.email = email;
	}

	/**
	 * Retorna o CNPJ do objeto
	 * @return String
	 */
	
	
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel cnpj
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param cnpj
	 * @throws IllegalArgumentException , caso o CNPJ contenha letras,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o CNPJ seja nulo
	 * 
	 */
	
	public void setCnpj(String cnpj) {
		this.validateCNPJAll(cnpj);
		this.cnpj = cnpj;
	}

	/**
	 * Retorna a data de criação  do objeto (empresa)
	 * @return Date
	 */
	public DateTime getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * Recebe uma Data como parametro e insere esta data na variavel dataCriacao
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param dataCriacao
	 * @throws IllegalArgumentException , caso a data de criacao esteja com tamanho incorreto
	 * @throws NullArgumentException , caso a data de criacao seja nulo
	 * 
	 */
	public void setDataCriacao(DateTime dataCriacao) {
		this.validateDataCriacaoNotNull(dataCriacao);
		this.validateDataCriacaoMaiorQueAtual(dataCriacao);
		this.validateDataCriacaoMenorQueAtual(dataCriacao);
		this.dataCriacao = dataCriacao;
	}

	/**
	 * Retorna a data de alteração do objeto(empresa)
	 * @return
	 */
	public DateTime getDataAlteracao() {
		return dataAlteracao;
	}

	/** 
	 * Recebe uma data como parametro e insere esta data na variavel dataAlteracao
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param dataCriacao
	 * @throws IllegalArgumentException , caso a data de alteração seja menor que a data de criacao
	 * 
	 */
	
	public void setDataAlteracao(DateTime dataAlteracao) {
		this.validateDataAlteracaoMaiorQueDataCriacao(dataAlteracao);
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * Valida se o CNPJ está nulo
	 * @param cnpj
	 * @throws NullPointerException
	 */
	private void validateCNPJNotNull(String cnpj) {
		checkNotNull(cnpj,"CNPJ não pode ser nulo");	
	}

	/**
	 * Valida se o CNPJ esta com o tamanho correto
	 * @param cnpj
	 * @throws IllegalArgumentException
	 */
	private void validateCNPJTamanho(String cnpj) {
		checkArgument(cnpj.length()==TAMANHO_CNPJ,"Tamanho do CNPJ incorreto");		
	}

	/**
	 * Valida se o CNPJ está vazio
	 * @param cnpj
	 * @throws IllegalArgumentException
	 */
	private void validateCNPJVazio(String cnpj) {
		checkArgument(!cnpj.isEmpty(),"CNPJ não pode estar vazio");
	}

	/**
	 * Valida se o CNPJ contém letras
	 * @param cnpj
	 * @throws IllegalArgumentException
	 */
	private void validateCNPJContemLetra(String cnpj) {
		for (int i = 0; i < cnpj.length(); i++) {
			char c = cnpj.charAt(i);
			checkArgument(!isLetter(c),"CNPJ não pode conter letras");
		}

	}

	/**
	 * Recebe o parametro CNPJ e faz a validação de todos os casos
	 * @param cnpj
	 * @throws IllegalArgumentException , caso o CNPJ contenha letras,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o CPNJ seja nulo
	 */
	private void validateCNPJAll(String cnpj) {
		this.validateCNPJNotNull(cnpj);
		this.validateCNPJVazio(cnpj);
		this.validateCNPJContemLetra(cnpj);
		this.validateCNPJTamanho(cnpj);

	}

	/**
	 * Valida se o parametro recebido nome fantasia está nulo
	 * @param nomeFantasia
	 * @throws NullPointerException
	 */
	private void validateNomeFantasiaNotNull(String nomeFantasia) {
		checkNotNull(nomeFantasia,"Nome Fantasia não pode ser nulo");	
	}
	/**
	 * Valida se o parametro recebido nome fantasia está vazio
	 * @param nomeFantasia
	 * @throws IllegalArgumentException
	 */
	private void validateNomeFantasiaVazio(String nomeFantasia) {
		checkArgument(!nomeFantasia.isEmpty(),"Nome Fantasia não pode estar vazio");
	}
	/**
	 * Valida se o parametro recebido nome fantasia esta com tamanho menor que o aceitavel
	 * @param nomeFantasia
	 * @throws IllegalArgumentException
	 */
	private void validateNomeFantasiaTamanhoMinimo(String nomeFantasia) {
		checkArgument(!(nomeFantasia.length()<TAMANHO_MIN_NOME_FANTASIA),"O Tamanho do nome fantasia esta menor que o aceitavel");	
	}
	/**
	 * Valida se o parametro recebido nome fantasia esta com tamanho maior que o aceitavel
	 * @param nomeFantasia
	 * @throws IllegalArgumentException
	 */
	private void validateNomeFantasiaTamanhoMaximo(String nomeFantasia) {
		checkArgument(!(nomeFantasia.length()>TAMANHO_MAX_NOME_FANTASIA),"O Tamanho do nome fantasia esta maior que o aceitavel");
	}

	/**
	 * Recebe o parametro nomeFantasia e faz a validação de todos os casos
	 * @param nomeFantasia
	 * @throws IllegalArgumentException , caso o nome fantasia seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o nome fantasia seja nulo
	 */
	private void validateNomeFantasiaAll(String nomeFantasia) {
		this.validateNomeFantasiaNotNull(nomeFantasia);
		this.validateNomeFantasiaVazio(nomeFantasia);
		this.validateNomeFantasiaTamanhoMinimo(nomeFantasia);
		this.validateNomeFantasiaTamanhoMaximo(nomeFantasia);

	}
	/**
	 * Valida se o parametro recebido nome proprietario está nulo
	 * @param nomeProprietario
	 * @throws NullPointerException
	 */
	private void validateNomeProprietarioNotNull(String nomeProprietario) {
		checkNotNull(nomeProprietario,"Nome do proprietário não pode ser nulo");
	}
	/**
	 * Valida se o parametro recebido nome proprietário está vazio
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateNomeProprietarioVazio(String nomeProprietario) {
		checkArgument(!nomeProprietario.isEmpty(),"Nome do proprietário não pode estar vazio");
	}

	/**
	 * Valida se o parametro recebido nome proprietario esta com tamanho menor que o aceitavel
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateNomeProprietarioTamanhoMinimo(String nomeProprietario) {
		checkArgument(!(nomeProprietario.length() < TAMANHO_MIN_NOME_PROPRIETARIO),"O Tamanho do nome proprietario esta menor que o tamanho aceitavel");
	}
	/**
	 * Valida se o parametro recebido nome proprietario esta com tamanho maior que o aceitavel
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateNomeProprietarioTamanhoMaximo(String nomeProprietario) {
		checkArgument(!(nomeProprietario.length() > TAMANHO_MAX_NOME_PROPRIETARIO),"O Tamanho do nome proprietario esta maior que o tamanho aceitavel");
	}
	/**
	 * Valida se o parametro recebido nome proprietario contem numeros
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateNomeProprietarioComNumeros(String nomeProprietario) {
		for (int i = 0; i < nomeProprietario.length(); i++) {
			char nome = nomeProprietario.charAt(i);
			checkArgument(!isDigit(nome),"Nome do proprietario não pode conter numeros");
		}
	}

	/**
	 * Recebe o parametro nome proprietario e faz a validação de todos os casos
	 * @param nomeProprietario
	 * @throws IllegalArgumentException , caso o nome proprietario contenha numeros,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o nome proprietario seja nulo
	 */
	private void validateNomeProprietarioAll(String nomeProprietario) {
		this.validateNomeProprietarioNotNull(nomeProprietario);
		this.validateNomeProprietarioVazio(nomeProprietario);
		this.validateNomeProprietarioComNumeros(nomeProprietario);
		this.validateNomeProprietarioTamanhoMinimo(nomeProprietario);
		this.validateNomeProprietarioTamanhoMaximo(nomeProprietario);
		
	}

	/**
	 * Valida se o parametro recebido email está nulo
	 * @param email
	 * @throws NullPointerException
	 */
	private void validateEmailNotNull(String email) {
		checkNotNull(email,"Email não pode ser nulo");
	}
	/**
	 * Valida se o parametro recebido email está vazio
	 * @param email
	 * @throws IllegalArgumentException
	 */
	private void validateEmailVazio(String email) {
		checkArgument(!email.isEmpty(),"Email não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido email esta com tamanho menor que o aceitavel
	 * @param email
	 * @throws IllegalArgumentException
	 */
	private void validateEmailTamanhoMinimo(String email) {
		checkArgument(!(email.length() < TAMANHO_MIN_EMAIL),"O Tamanho do email esta menor que o aceitavel");
	}
	/**
	 * Valida se o parametro recebido email esta com tamanho maior que o aceitavel
	 * @param email
	 * @throws IllegalArgumentException
	 */
	private void validateEmailTamanhoMaximo(String email) {
		checkArgument(!(email.length() > TAMANHO_MAX_EMAIL),"O Tamanho do email esta maior que o aceitavel");
	}
	/**
	 * Recebe o parametro email e faz a validação de todos os casos
	 * @param email
	 * @throws IllegalArgumentException , caso o email contenha seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o email seja nulo
	 */
	private void validateEmailAll(String email) {
		this.validateEmailNotNull(email);
		this.validateEmailVazio(email);
		this.validateEmailTamanhoMinimo(email);
		this.validateEmailTamanhoMaximo(email);

	}
	/**
	 * Valida se o parametro recebido endereco esta nulo
	 * @param endereco
	 * @throws NullPointerException
	 */
	//TODO
	private void validateEmpresaPrecisaDeDoisEnderecos(Set<Endereco> endereco) {
	    checkNotNull(endereco,"É Necessário preecher todos os enderecos da empresa");
  	}

	/**
	 * Valida se o parametro recebido endereco está nulo
	 * @param endereco
	 * @throws NullPointerException
	 */
	private void validateEnderecoNotNull(Set<Endereco> endereco) {
		checkNotNull(endereco,"Endereco não pode ser nulo");
	}
	/**
	 * Valida se o parametro recebido telefone está nulo
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	
	//TODO
	private void validateEmpresaPrecisaDeDoisTelefones(Telefone[] telefone) {
		for (int i = 0; i < telefone.length; i++) {
			checkNotNull(telefone[i],"É Necessário preecher todos os telefones da empresa");
		}
	}
	/**
	 * Valida se o parametro recebido data de criação está nulo
	 * @param dataCriação
	 * @throws NullPointerException
	 */
	private void validateDataCriacaoNotNull(DateTime dataCriacao) {
		checkNotNull(dataCriacao,"A data de criação não pode ser nula");
	}
	/**
	 * Valida se o parametro recebido data de criacao é maior que a data atual 
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateDataCriacaoMaiorQueAtual(DateTime dataCriacao) {
		checkArgument(!dataCriacao.isAfterNow(),"A data de criação não pode ser maior que a atual");
	}
	/**
	 * Valida se o parametro recebido data de criação é menor que a data atual
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateDataCriacaoMenorQueAtual(DateTime dataCriacao) {
		checkArgument(dataCriacao.isBeforeNow(),"A data de criação não pode ser menor que a atual");
	}
	/**
	 * Valida se o parametro recebido data de alteração é maior que a data de criação
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	private void validateDataAlteracaoMaiorQueDataCriacao(DateTime dataAlteracao) {
		checkArgument(!dataAlteracao.isBefore(this.getDataCriacao()),"A data da alteração não pode ser antes que a data de criação");
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cnpj).build();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Empresa other = (Empresa) obj;
		return new EqualsBuilder().append(this.cnpj,other.cnpj).build();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	 @Override
  public String toString() {
      this.validateDataCriacaoNotNull(dataCriacao);
      DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/YYYY");
      dataCriacao = new DateTime();
      String dataCriacaoString = dtf.print(dataCriacao);
      dataAlteracao = new DateTime();
      String dataAlteracaoString = dtf.print(dataAlteracao);
      return new ToStringBuilder(this, StandardToStringStyle.MULTI_LINE_STYLE)
              .append(this.nomeFantasia != null ? "Nome Fantasia: " + this.nomeFantasia : null)
              .append(this.nomeProprietario != null ? "Nome do Propietário: " + this.nomeProprietario : null)
              .append(this.cnpj != null ? "CNPJ: " + this.cnpj : null)
              .append(this.email != null ? "Email: " + this.email : null)
              .append(this.dataCriacao != null ? "Data de criação: " +  dataCriacaoString : null)
              .append(this.dataAlteracao != null ? "Data da alteração: " + dataAlteracaoString : null)
              .append(telefone)
              .append(endereco)
              .build();

  }



}
