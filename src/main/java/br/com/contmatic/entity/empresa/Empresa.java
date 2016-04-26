package br.com.contmatic.entity.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import javax.validation.constraints.Future;
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
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.caelum.stella.bean.validation.CNPJ;




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
	@Length(min=TAMANHO_MIN_NOME_FANTASIA,max=TAMANHO_MAX_NOME_FANTASIA,message="Nome Fantasia tamanho incorreto")
	@Pattern(regexp = "\\D{8,30}")
	private String nomeFantasia;
	
	/**
	 * Recebe o nome do proprietario
	 */
	
	@NotNull(message="É necessário preencher o nome do proprietário")
	@NotBlank(message="Nome do proprietário não pode estar vazio")
	@Max(value = TAMANHO_MAX_NOME_PROPRIETARIO,message="campo nome proprietário contem mais que 30 caracteres")
	@Min(value = TAMANHO_MIN_NOME_PROPRIETARIO,message="campo nome proprietário contem menos que 8 caracteres")
	@Pattern(regexp="\\D{8,30}",message="Nome proprietário não deve conter números")
	private String nomeProprietario;
	
	/**Recebe o cnpj da empresa*/
	@CNPJ(message="CNPJ nao deve conter letras")
	@NotNull(message= "CNPJ deve ser preenchido")
	@NotBlank(message="CNPJ não pode estar vazio")
	@Length(max=TAMANHO_CNPJ,min=TAMANHO_CNPJ ,message="Tamanho do CNPJ incorrreto")
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
	@NotNull
	private Set<Telefone> telefones;
	/**
	 * Recebe os enderecos da empresa
	 */

	
	@NotNull(message="Endereço não pode ser vazio")
	private Set<Endereco> endereco;
	
    /**
	 * Recebe a data de criação da empresa
	 */
	
	@NotNull (message="Data de criacao deve ser preenchida")
	private DateTime dataCriacao;
	
	/**
	 * Recebe a data de alteração da empresa
	 */
	
	@Future
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
	 
	 * 
	 */
	
	public void setNomeFantasia(String nomeFantasia) {
		//this.validateNomeFantasiaAll(nomeFantasia);
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
		
		this.nomeProprietario = nomeProprietario;
	}

	/**
	 * Retorna um array de telefones do objeto
	 * @return Telefone[]
	 */

	/**
	 * Recebe um array do tipo Telefone como parametro e insere esta array na variavel telefone
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param telefone
	 * @throws NullArgumentException , caso um dos telefones da empresa seja nulo
	 * 
	 */
	public void setTelefone(Telefone telefone) {
		this.validateTelefoneIgual(telefone);
		this.validateEmpresaPrecisaDeDoisTelefones();
		this.telefones.add(telefone);
	}
	
	public Set<Telefone> getTelefone() {
        return telefones;
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
	
	public void setEndereco(Endereco endereco) {
		this.validateEmpresaPrecisaDeDoisEnderecos();
		this.endereco.add(endereco);
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
	 * Valida se o parametro recebido endereco esta nulo
	 * @param endereco
	 * @throws NullPointerException
	 */
	
	private void validateEmpresaPrecisaDeDoisEnderecos() {
	     checkArgument(!(endereco.size()!=2),"A empresa precisa de pelo menos dois enderecos");
  	}

	private void validateTelefoneIgual(Telefone telefone){
	    if(this.telefones.contains(telefone)){
	        throw new IllegalArgumentException("Empresa não pode ter dois telefones iguais cadastrados");
	    }
	}
	
	
	
	/**
	 * Valida se o parametro recebido endereco está nulo
	 * @param endereco
	 * @throws NullPointerException
	 */
	
	/**
	 * Valida se o parametro recebido telefone está nulo
	 * @param nomeProprietario
	 * @throws IllegalArgumentException
	 */
	
	
	private void validateEmpresaPrecisaDeDoisTelefones() {
	      checkArgument(!(telefones.size()!=2),"A empresa precisa de pelo menos dois telefones");
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
              .append(telefones)
              .append(endereco)
              .build();

  }



}
