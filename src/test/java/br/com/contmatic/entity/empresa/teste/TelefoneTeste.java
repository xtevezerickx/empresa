package br.com.contmatic.entity.empresa.teste;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.entity.empresa.Telefone;

@FixMethodOrder(NAME_ASCENDING)
public class TelefoneTeste {
	private Telefone tel;
	@Before
	public void setUp(){
		
		tel = new Telefone();
		tel.setDdd("011");
		tel.setNumeroTelefone("123456789");
		tel.setTipoTelefone("celular");
		
	}
	@Test
	public void nao_deve_aceitar_telefone_nulo() {
		tel.setNumeroTelefone(null);	
	}
	
	@Test
	public void deve_aceitar_telefone_valido(){
		tel.getNumeroTelefone();
	}
	
	@Test
	public void deve_aceitar_ddd_valido(){
		tel.getDdd();
	}
	
	@Test
	public void deve_aceitar_tipo_telefone_valido(){
		tel.getTipoTelefone();
	}
	
	@Test
	public void nao_deve_aceitar_telefone_vazio(){
		tel.setNumeroTelefone("");
	}
	
	@Test
	public void nao_deve_aceitar_telefone_tamanho_incorreto(){
		tel.setNumeroTelefone("11");
	}
	
	@Test
	public void nao_deve_aceitar_telefone_com_letras(){
		tel.setNumeroTelefone("fff");
	}
	
	@Test
	public void nao_deve_aceitar_ddd_nulo(){
		tel.setDdd(null);
	}
	
	@Test
	public void nao_deve_aceitar_ddd_vazio(){
		tel.setDdd("");
	}
	
	@Test
	public void nao_deve_aceitar_ddd_com_tamanho_errado(){
		tel.setDdd("44444");
	}
	
	@Test
	public void nao_deve_aceitar_ddd_com_letras(){
		tel.setDdd("ddd");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_telefone_vazio(){
		tel.setTipoTelefone("");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_telefone_com_numeros(){
		tel.setTipoTelefone("2344");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_telefone_tamanho_maximo(){
		tel.setTipoTelefone("ffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_telefone_tamanho_minimo(){
		tel.setTipoTelefone("fff");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_telefone_nulo(){
		tel.setTipoTelefone(null);
	}
	
}
