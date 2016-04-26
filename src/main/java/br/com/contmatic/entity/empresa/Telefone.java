package br.com.contmatic.entity.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

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
import org.hibernate.validator.constraints.Range;

import br.com.contmatic.entity.empresa.constantes.TelefoneType;

public class Telefone {

    private static final int TAMANHO_MAX_TIPO_TELEFONE=15;
    private static final int TAMANHO_DDD=3;
    private static final int TAMANHO_MIN_TIPO_TELEFONE=4;
    /**
     * Recebe o numero de telefone
     */
    
    @NotNull(message="É necessário preencher o campo numero de telefone")
    @NotBlank(message="Campo numero telefone não deve ser vazio")
    @Range(min=8,max=9,message="numero de telefone com tamanho incorreto")
    @Pattern(regexp="\\d{8,9}",message="O numero de telefone apenas deve contem números")
    private String numeroTelefone;
    /**
     * Recebe o numero de DDD
     */
    
    @NotNull(message="É necessário preencher o campo DDD")
    @Length(max=TAMANHO_DDD,message="DDD com tamanho incorreto")
    @NotEmpty(message="Campo DDD não pode ser vazio")
    @Pattern(regexp="\\d{3}",message="DDD não pode conter letras")
    private String ddd;
    
    /**
     * Recebe o tipo de telefone, exemplo: Comercial, celular, casa, etc
     */
    
    
    @NotNull(message="É necessário preencher o campo tipo de telefone")
    @NotBlank(message="Tipo de telefone não pode ser vazio")
    @Size(min=TAMANHO_MIN_TIPO_TELEFONE,max=TAMANHO_MAX_TIPO_TELEFONE,message="O campo tipo de telefone está com tamanho incorreto")
    @Pattern(regexp="\\D{4,15}",message="Tipo telefone não pode conter numeros")
    private String tipoTelefone;
    
    /**
     * Retorna o numero de telefone do objeto
     * 
     * @return String numeroTelefone
     */
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    /**
     * Recebe uma String como parametro e insere esta String na variavel numeroTelefone É feito a validação do parametro antes de inserir na variavel do objeto, caso aconteça alguma excessão, é
     * lançado uma mensagem correpondente ao erro e o parametro não é inserido na variavel.
     * 
     * @param numeroTelefone
     * @throws IllegalArgumentException  caso o numero de telefone contenha caracter, seja vazio ou tamanho incorreto
     * @throws NullArgumentException  caso o numero de telefone seja nulo
     * 
     */
    public void setNumeroTelefone(String numeroTelefone) {
       this.numeroTelefone = numeroTelefone;
    }

    /**
     * Retorna o numero do DDD do objeto
     * 
     * @return String ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * Recebe uma String como parametro e insere esta String na variavel DDD É feito a validação do parametro antes de inserir na variavel do objeto, caso aconteça alguma excessão, é lançado uma
     * mensagem correpondente ao erro e o parametro não é inserido na variavel.
     * 
     * @param ddd
     * @throws IllegalArgumentException , caso o DDD contenha caracter, seja vazio ou tamanho incorreto
     * @throws NullArgumentException , caso o DDD seja nulo
     */
    public void setDdd(String ddd) {
       this.ddd = ddd;
    }

    /**
     * Retorna o tipo de telefone do objeto
     * 
     * @return String
     */
    public String getTipoTelefone() {
        return tipoTelefone;
    }

    /**
     * Recebe uma String como parametro e insere esta String na variavel tipoTelefone É feito a validação do parametro antes de inserir na variavel do objeto, caso aconteça alguma excessão, é lançado
     * uma mensagem correpondente ao erro e o parametro não é inserido na variavel.
     * 
     * @param tipoTelefone
     * @throws IllegalArgumentException , caso o tipo de telefone contenha numeros,seja vazio ou tamanho incorreto
     * @throws NullArgumentException , caso o tipo de telefone seja nulo
     */
     
    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    /**
     * Valida se o parametro recebido numeroTelefone está nulo
     * 
     * @param numeroTelefone
     * @throws NullPointerException
     */
    private void validateNumeroTelefoneNotNull(String numeroTelefone) {
        checkNotNull(numeroTelefone, "O Numero do telefone nao pode ser nulo");
    }

    /**
     * Valida se o parametro recebido numeroTelefone esta com o tamanho incorreto
     * 
     * @param numeroTelefone
     * @throws IllegalArgumentException
     */
    private void validateNumeroTelefoneTamanho(String numeroTelefone) {
        checkArgument(!(numeroTelefone.length() != TelefoneType.FIXO.getTamanho()) || !(numeroTelefone.length()!=TelefoneType.CELULAR.getTamanho()), "O Tamanho do telefone esta incorreto");
    }
    
    private void validateTipoTelefoneIguais(String tipoTelefone){
        if(this.tipoTelefone.equals(tipoTelefone)){
            throw new IllegalArgumentException("Não é possivel cadastrar dois numeros do mesmo tipo");
        }
    }

    /**
     * Valida se o parametro recebido numeroTelefone está vazio
     * 
     * @param numeroTelefone
     * @throws IllegalArgumentException
     */
    private void validateNumeroTelefoneVazio(String numeroTelefone) {
        checkArgument(!numeroTelefone.isEmpty(), "O telefone não pode esta vazio");
    }

    /**
     * Valida se o parametro recebido numeroTelefone contem letras
     * 
     * @param numeroTelefone
     * @throws IllegalArgumentException
     */
    private void validateNumeroTelefoneCaracter(String numeroTelefone) {
        for(int i = 0 ; i < numeroTelefone.length() ; i++) {
            char telchar = numeroTelefone.charAt(i);
            checkArgument(!isLetter(telchar), "O telefone não pode conter letras");
        }
    }

    /**
     * Recebe o parametro numeroTelefone e faz a validação de todos os casos
     * 
     * @param numeroTelefone
     ** @throws IllegalArgumentException , caso o numero de telefone contenha numeros,seja vazio ou tamanho incorreto
     * @throws NullArgumentException , caso o numero de telefone seja nulo
     */
    private void validateNumeroTelefoneAll(String numeroTelefone) {
        this.validateNumeroTelefoneNotNull(numeroTelefone);
        this.validateNumeroTelefoneVazio(numeroTelefone);
        this.validateNumeroTelefoneCaracter(numeroTelefone);
        this.validateNumeroTelefoneTamanho(numeroTelefone);
    }

    /**
     * Valida se o parametro recebido DDD está nulo
     * 
     * @param ddd
     * @throws NullPointerException
     */
    private void validateDddNotNull(String ddd) {
        checkNotNull(ddd, "DDD não pode ser nulo");
    }

    /**
     * Valida se o parametro recebido DDD está vazio
     * 
     * @param ddd
     * @throws IllegalArgumentException
     */
    private void validateDddVazio(String ddd) {
        checkArgument(!ddd.isEmpty(), "DDD não pode ser vazio");
    }

    /**
     * Valida se o parametro recebido DDD está com tamanho incorreto
     * 
     * @param ddd
     * @throws IllegalArgumentException
     */
    private void validateDddTamanho(String ddd) {
        checkArgument(ddd.length() == TAMANHO_DDD, "DDD com tamanho incorreto");
    }

    /**
     * Valida se o parametro recebido DDD contem letras
     * 
     * @param ddd
     * @throws IllegalArgumentException
     */
    private void validateDddCaracter(String ddd) {
        for(int i = 0 ; i < ddd.length() ; i++) {
            char dddchar = ddd.charAt(i);
            checkArgument(!Character.isLetter(dddchar), "DDD não pode conter caracteres");
        }

    }

    /**
     * Recebe o parametro DDD e faz a validação de todos os casos
     * 
     * @param ddd
     ** @throws IllegalArgumentException , caso o DDD contenha numeros,seja vazio ou tamanho incorreto
     * @throws NullArgumentException , caso o DDD seja nulo
     */
    private void validateDddAll(String ddd) {
        this.validateDddNotNull(ddd);
        this.validateDddVazio(ddd);
        this.validateDddCaracter(ddd);
        this.validateDddTamanho(ddd);
    }

    /**
     * Valida se o parametro recebido tipoTelefone está nulo
     * 
     * @param tipoTelefone
     * @throws NullPointerException
     */
    private void validateTipoTelefoneNotNull(String tipoTelefone) {
        checkNotNull(tipoTelefone, "Tipo de telefone não pode ser nulo");
    }

    /**
     * Valida se o parametro recebido tipoTelefone está vazio
     * 
     * @param tipoTelefone
     * @throws IllegalArgumentException
     */
    private void validateTipoTelefoneVazio(String tipoTelefone) {
        checkArgument(!tipoTelefone.isEmpty(), "Tipo de telefone não pode ser vazio");
    }

    /**
     * Valida se o parametro recebido tipoTelefone contem mais caracteres que o aceitavel
     * 
     * @param tipoTelefone
     * @throws IllegalArgumentException
     */
    private void validateTipoTelefoneTamanhoMaximo(String tipoTelefone) {
        checkArgument(!(tipoTelefone.length() > TAMANHO_MAX_TIPO_TELEFONE), "O tamanho do tipo de telefone não pode ser maior que o tamanho aceitavel");
    }

    /**
     * Valida se o parametro recebido tipoTelefone contem menos caracteres que o aceitavel
     * 
     * @param tipoTelefone
     * @throws IllegalArgumentException
     */
    private void validateTipoTelefoneTamanhoMinimo(String tipoTelefone) {
        checkArgument(!(tipoTelefone.length() < TAMANHO_MIN_TIPO_TELEFONE), "O tamanho do tipo de telefone não pode ser menor que o tamanho aceitavel");
    }

    /**
     * Valida se o parametro recebido tipoTelefone não pode conter números
     * 
     * @param tipoTelefone
     * @throws IllegalArgumentException
     */
    private void validateTipoTelefoneCaracter(String tipoTelefone) {
        for(int i = 0 ; i < tipoTelefone.length() ; i++) {
            char tipotelchar = tipoTelefone.charAt(i);
            checkArgument(!isDigit(tipotelchar), "O tipo de telefone não pode conter números");
        }
    }
    /**
     * Recebe o parametro tipoTelefone e faz a validação de todos os casos
     * 
     * @param tipoTelefone
     ** @throws IllegalArgumentException , caso o tipoTelefone contenha numeros,seja vazio ou tamanho incorreto
     * @throws NullArgumentException , caso o tipoTelefone seja nulo
     */
    private void validateTipoTelefoneAll(String tipoTelefone) {
        this.validateTipoTelefoneNotNull(tipoTelefone);
        this.validateTipoTelefoneVazio(tipoTelefone);
        this.validateTipoTelefoneCaracter(tipoTelefone);
        this.validateTipoTelefoneTamanhoMaximo(tipoTelefone);
        this.validateTipoTelefoneTamanhoMinimo(tipoTelefone);
        this.validateTipoTelefoneIguais(tipoTelefone);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.ddd).append(this.numeroTelefone).append(this.tipoTelefone).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        
        Telefone other = (Telefone) obj;
        return new EqualsBuilder().append(this.ddd, other.ddd).append(this.numeroTelefone, other.numeroTelefone).append(this.tipoTelefone, other.tipoTelefone).build();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString() {
	    return new ToStringBuilder(this,StandardToStringStyle.MULTI_LINE_STYLE)
	            .append(this.numeroTelefone!=null ? "Numero de telefone = "+this.numeroTelefone:null)
	            .append(this.ddd!=null ? "DDD = "+this.ddd:null)
	            .append(this.tipoTelefone!=null? "Tipo de telefone = "+ this.tipoTelefone:null)
	            .toString();
	}

}
