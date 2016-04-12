package br.com.contmatic.entity.empresa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Telefone {
	private String numeroTelefone;
	private int ddd;
	private String tipo;
	private static final int TAMANHO_TELEFONE = 9;

	public String getTelefone() {
		return numeroTelefone;
	}

	public void setTelefone(String telefone) {
		this.numeroTelefone = telefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean validateTelefoneNotNull(Telefone tel) {

		if (tel.getTelefone() == null) {
			return false;
		}
		return true;

	}

	public boolean validaTelefoneTamanho(Telefone tel) {
		if (tel.getTelefone().length() != TAMANHO_TELEFONE) {
			return false;
		}
		return true;
	}

	public boolean validaTelefoneVazio(Telefone tel) {
		if (tel.getTelefone().isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean validaTelefoneCaracter(Telefone tel) {
		for (int i = 0; i < tel.getTelefone().length(); i++) {
			char telchar = tel.getTelefone().charAt(i);
			if (Character.isLetter(telchar)) {
				return false;
			}
		}
		return true;

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
		return new StringBuilder().append("Telefone: " + this.numeroTelefone).append("DDD: " + this.ddd)
				.append("Tipo: " + this.tipo).toString();
	}

}
