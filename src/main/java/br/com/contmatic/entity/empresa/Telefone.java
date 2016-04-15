package br.com.contmatic.entity.empresa;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Telefone {
	private String numeroTelefone;
	private String ddd;
	private String tipoTelefone;
	private static final int TAMANHO_TELEFONE = 9;
	private static final int TAMANHO_TIPO_TELEFONE=15;
	private static final int TAMANHO_DDD=3;
	private static final int TAMANHO_MIN_TIPO_TELEFONE = 4;

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.validateTelefoneAll(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.validateDddAll(ddd);
		this.ddd = ddd;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.validateTipoTelefoneAll(tipoTelefone);
		this.tipoTelefone = tipoTelefone;
	}

	private void validateNumeroTelefoneNotNull(String numeroTelefone) {

		if (numeroTelefone == null) {
			throw new IllegalArgumentException("O Numero do telefone nao pode ser nulo");
		}

	}
	
	private void validateNumeroTelefoneTamanho(String numeroTelefone) {
		if (numeroTelefone.length() != TAMANHO_TELEFONE) {
			throw new IllegalArgumentException("O Tamanho do telefone esta incorreto");
		}
	}

	private void validateNumeroTelefoneVazio(String numeroTelefone) {
		if (numeroTelefone.isEmpty()) {
			throw new IllegalArgumentException("O telefone não pode esta vazio");
		}
	}

	private void validaNumeroTelefoneCaracter(String numeroTelefone) {
		for (int i = 0; i < numeroTelefone.length(); i++) {
			char telchar = numeroTelefone.charAt(i);
			if (Character.isLetter(telchar)) {
				throw new IllegalArgumentException("O telefone não pode conter letras");
			}
		}

	}

	private void validateTelefoneAll(String numeroTelefone){
		this.validateNumeroTelefoneNotNull(numeroTelefone);
		this.validateNumeroTelefoneVazio(numeroTelefone);
		this.validaNumeroTelefoneCaracter(numeroTelefone);
		this.validateNumeroTelefoneTamanho(numeroTelefone);
	}
		
	private void validateDddNotNull(String ddd){
		if(ddd == null){
			throw new IllegalArgumentException("DDD não pode ser nulo");
		}
	}
	
	private void validateDddVazio(String ddd){
		if (ddd.isEmpty()){
			throw new IllegalArgumentException("DDD não pode ser vazio");
		}
	}
	
	private void validateDddTamanho(String ddd){
		if (ddd.length()!=TAMANHO_DDD){
			throw new IllegalArgumentException("DDD com tamanho incorreto");
		}
	}
	
	private void validateDddCaracter(String ddd){
		for (int i = 0; i < ddd.length(); i++) {
			char dddchar=ddd.charAt(i);
			if(Character.isLetter(dddchar)){
				throw new IllegalArgumentException("DDD não pode conter caracteres");
			}
		}
		
	}
	
	private void validateDddAll(String ddd){
		this.validateDddNotNull(ddd);
		this.validateDddVazio(ddd);
		this.validateDddCaracter(ddd);
		this.validateDddTamanho(ddd);
	}
	
	private void validateTipoTelefoneNotNull (String tipoTelefone){
		if(tipoTelefone==null){
			throw new IllegalArgumentException("Tipo de telefone não pode ser nulo");
		}
	}
	
	private void validateTipoTelefoneVazio(String tipoTelefone){
		if(tipoTelefone.isEmpty()){
			throw new IllegalArgumentException("Tipo de telefone não pode ser vazio");
		}
	}
	
	private void validateTipoTelefoneTamanhoMaximo(String tipoTelefone){
		if (tipoTelefone.length()>TAMANHO_TIPO_TELEFONE){
			throw new IllegalArgumentException("O tamanho do tipo de telefone não pode ser maior que: "+TAMANHO_TIPO_TELEFONE);
		}
	}
	
	private void validateTipoTelefoneTamanhoMinimo(String tipoTelefone){
		if(tipoTelefone.length()<TAMANHO_MIN_TIPO_TELEFONE){
			throw new IllegalArgumentException("O tamanho do tipo de telefone não pode ser menor que: "+TAMANHO_MIN_TIPO_TELEFONE);
		}
	}
	
	private void validateTipoTelefoneCaracter(String tipoTelefone){
		for (int i = 0; i < tipoTelefone.length(); i++) {
			char tipotelchar=tipoTelefone.charAt(i);
			if(Character.isDigit(tipotelchar)){
				throw new IllegalArgumentException("O tipo de telefone não pode conter números");
			}
		}
	}
	
	private void validateTipoTelefoneAll(String tipoTelefone){
		this.validateTipoTelefoneNotNull(tipoTelefone);
		this.validateTipoTelefoneVazio(tipoTelefone);
		this.validateTipoTelefoneCaracter(tipoTelefone);
		this.validateTipoTelefoneTamanhoMaximo(tipoTelefone);
		this.validateTipoTelefoneTamanhoMinimo(tipoTelefone);
	}
	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.ddd).append(this.numeroTelefone).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return new EqualsBuilder().append(this.ddd, other.ddd).append(this.numeroTelefone, other.numeroTelefone).isEquals();

	}

	@Override
	public String toString() {
		return new ToStringBuilder(this,MULTI_LINE_STYLE)
				.append("Telefone: " + this.numeroTelefone)
				.append("DDD: " + this.ddd)
				.append("Tipo: " + this.tipoTelefone)
				.build();
	}

}
