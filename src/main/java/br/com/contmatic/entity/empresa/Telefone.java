package br.com.contmatic.entity.empresa;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class Telefone {
	
	/**
	 * Recebe o numero de telefone
	 */
	private String numeroTelefone;
	/**
	 * Recebe o numero de DDD
	 */
	private String ddd;
	/**
	 * Recebe o tipo de telefone,
	 * exemplo: Comercial, celular, casa, etc
	 */
	private String tipoTelefone;
	/**
	 * Constante para o tamanho do numero de telefone
	 */
	private static final int TAMANHO_TELEFONE = 9;
	/**
	 * Contante para o tamanho do tipo de telefone
	 */
	private static final int TAMANHO_TIPO_TELEFONE = 15;
	/**
	 * Constante para o tamanho do DDD
	 */
	private static final int TAMANHO_DDD = 3;
	/**
	 * Constante para o tamanho minimo do tipo de telefone
	 */
	private static final int TAMANHO_MIN_TIPO_TELEFONE = 4;

	/**
	 * Retorna o numero de telefone do objeto
	 * @return String numeroTelefone
	 */
	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel numeroTelefone
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param numeroTelefone
	 * @throws IllegalArgumentException , caso o numero de telefone contenha caracter, seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o numero de telefone seja nulo
	 * 
	 */
	public void setNumeroTelefone(String numeroTelefone) {
		this.validateNumeroTelefoneAll(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	/**
	 * Retorna o numero do DDD do objeto
	 * @return String ddd
	 */
	public String getDdd() {
		return ddd;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel DDD
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro
	 * e o parametro não é inserido na variavel.
	 * @param ddd
	 * @throws IllegalArgumentException , caso o DDD contenha caracter, seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o DDD seja nulo
	 */
	public void setDdd(String ddd) {
		this.validateDddAll(ddd);
		this.ddd = ddd;
	}

	/**
	 * Retorna o tipo de telefone do objeto
	 * @return String
	 */
	public String getTipoTelefone() {
		return tipoTelefone;
	}

	/**
	 * Recebe uma String como parametro e insere esta String na variavel tipoTelefone
	 * É feito a validação do parametro antes de inserir na variavel do objeto,
	 * caso aconteça alguma excessão, é lançado uma mensagem correpondente ao erro 
	 * e o parametro não é inserido na variavel.
	 * @param tipoTelefone
	 * @throws IllegalArgumentException , caso o tipo de telefone contenha numeros,seja vazio ou tamanho incorreto
	 * @throws NullArgumentException , caso o tipo de telefone seja nulo
	 */
	public void setTipoTelefone(String tipoTelefone) {
		this.validateTipoTelefoneAll(tipoTelefone);
		this.tipoTelefone = tipoTelefone;
	}

	/**
	 * Valida se o parametro recebido numeroTelefone está nulo
	 * @param numeroTelefone
	 * @throws NullPointerException
	 */
	private void validateNumeroTelefoneNotNull(String numeroTelefone) {
		checkNotNull(numeroTelefone, "O Numero do telefone nao pode ser nulo");
	}

	/**Valida se o parametro recebido numeroTelefone esta com o tamanho incorreto
	 * @param numeroTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateNumeroTelefoneTamanho(String numeroTelefone) {
		checkArgument(!(numeroTelefone.length() != TAMANHO_TELEFONE), "O Tamanho do telefone esta incorreto");
	}

	/**
	 * Valida se o parametro recebido numeroTelefone está vazio
	 * @param numeroTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateNumeroTelefoneVazio(String numeroTelefone) {
		checkArgument(!numeroTelefone.isEmpty(), "O telefone não pode esta vazio");
	}

	/**
	 * Valida se o parametro recebido numeroTelefone contem letras
	 * @param numeroTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateNumeroTelefoneCaracter(String numeroTelefone) {
		for (int i = 0; i < numeroTelefone.length(); i++) {
			char telchar = numeroTelefone.charAt(i);
			checkArgument(!isLetter(telchar), "O telefone não pode conter letras");
		}
	}

	/**
	 * Recebe o parametro numeroTelefone e faz a validação de todos os casos
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
	 * @param ddd
	 * @throws NullPointerException
	 */
	private void validateDddNotNull(String ddd) {
		checkNotNull(ddd, "DDD não pode ser nulo");
	}

	/**
	 * Valida se o parametro recebido DDD está vazio
	 * @param ddd
	 * @throws IllegalArgumentException
	 */
	private void validateDddVazio(String ddd) {
		checkArgument(!ddd.isEmpty(), "DDD não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido DDD está com tamanho incorreto
	 * @param ddd
	 * @throws IllegalArgumentException
	 */
	private void validateDddTamanho(String ddd) {
		checkArgument(ddd.length() == TAMANHO_DDD, "DDD com tamanho incorreto");
	}

	/**
	 * Valida se o parametro recebido DDD contem letras
	 * @param ddd
	 * @throws IllegalArgumentException
	 */
	private void validateDddCaracter(String ddd) {
		for (int i = 0; i < ddd.length(); i++) {
			char dddchar = ddd.charAt(i);
			checkArgument(!Character.isLetter(dddchar), "DDD não pode conter caracteres");
		}

	}

	/**
	 * Recebe o parametro DDD e faz a validação de todos os casos
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
	 * @param tipoTelefone
	 * @throws NullPointerException
	 */
	private void validateTipoTelefoneNotNull(String tipoTelefone) {
		checkNotNull(tipoTelefone,"Tipo de telefone não pode ser nulo");
	}

	/**
	 * Valida se o parametro recebido tipoTelefone está vazio
	 * @param tipoTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateTipoTelefoneVazio(String tipoTelefone) {
		checkArgument(!tipoTelefone.isEmpty(),"Tipo de telefone não pode ser vazio");
	}

	/**
	 * Valida se o parametro recebido tipoTelefone contem mais caracteres que o aceitavel
	 * @param tipoTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateTipoTelefoneTamanhoMaximo(String tipoTelefone) {
		checkArgument(!(tipoTelefone.length() > TAMANHO_TIPO_TELEFONE),"O tamanho do tipo de telefone não pode ser maior que o tamanho aceitavel");
	}
	/**
	 * Valida se o parametro recebido tipoTelefone contem menos caracteres que o aceitavel
	 * @param tipoTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateTipoTelefoneTamanhoMinimo(String tipoTelefone) {
		checkArgument(!(tipoTelefone.length() < TAMANHO_MIN_TIPO_TELEFONE),"O tamanho do tipo de telefone não pode ser menor que o tamanho aceitavel");
	}

	/**
	 * Valida se o parametro recebido tipoTelefone não pode conter números
	 * @param tipoTelefone
	 * @throws IllegalArgumentException
	 */
	private void validateTipoTelefoneCaracter(String tipoTelefone) {
		for (int i = 0; i < tipoTelefone.length(); i++) {
			char tipotelchar = tipoTelefone.charAt(i);
			checkArgument(!isDigit(tipotelchar),"O tipo de telefone não pode conter números");
		}
	}

	/**
	 * Recebe o parametro tipoTelefone e faz a validação de todos os casos
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
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		result = prime * result + ((tipoTelefone == null) ? 0 : tipoTelefone.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		if (tipoTelefone == null) {
			if (other.tipoTelefone != null)
				return false;
		} else if (!tipoTelefone.equals(other.tipoTelefone))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n [numeroTelefone= " + numeroTelefone + ", ddd= " + ddd + ", tipoTelefone= " + tipoTelefone + "]";
	}


}
