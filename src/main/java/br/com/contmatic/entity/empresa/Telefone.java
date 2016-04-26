package br.com.contmatic.entity.empresa;

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
