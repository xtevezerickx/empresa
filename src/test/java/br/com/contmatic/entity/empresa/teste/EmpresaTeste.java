package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.entity.empresa.Empresa;
import br.com.contmatic.entity.empresa.Endereco;
import br.com.contmatic.entity.empresa.Telefone;

@FixMethodOrder(NAME_ASCENDING)

public class EmpresaTeste {
	private Empresa p1;
	private Endereco endereco;
	private Telefone tel;

	@Before
	public void setUp() {
		p1 = new Empresa();
		endereco = new Endereco();
		tel = new Telefone();
		tel.setDdd("011");
		tel.setNumeroTelefone("123456789");
		tel.setTipoTelefone("celular");
		
		p1.setCnpj("11123121111111");
		p1.setEmail("ssssssss@sss.com.br");
		p1.setEndereco(endereco);
		p1.setNomeFantasia("nome da empresa");
		p1.setNomeProprietario("proprietario");
		p1.setTelefone(tel);

	}

	@Test
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		p1.setNomeFantasia(null);
	}
	
	@Test
	public void nao_deve_aceitar_nome_fantasia_vazio(){
		p1.setNomeFantasia("");
	}
	@Test
	public void nao_deve_aceitar_nome_fantasia_com_minimo_de_caracteres(){
		p1.setNomeFantasia("aaaa");
	}
	@Test
	public void nao_deve_aceitar_nome_fantasia_com_maximo_de_caracteres(){
		p1.setNomeFantasia("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void nao_deve_aceitar_nome_proprietario_nulo(){
		p1.setNomeProprietario(null);
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_numeros(){
		p1.setNomeProprietario("er111");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_vazio(){
		p1.setNomeProprietario("");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_maior(){
		p1.setNomeProprietario("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_menor(){
		p1.setNomeProprietario("ffff");
	}
	
	@Test
	public void nao_deve_aceitar_telefone_nulo() {
		tel.setNumeroTelefone(null);	
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
	
	@Test
	public void nao_deve_aceitar_cnpj_nulo() {
		p1.setCnpj(null);
	}

	@Test
	public void nao_deve_aceitar_cnpj_com_letras(){
		p1.setCnpj("asdfas");
	}
	@Test
	public void nao_deve_aceitar_cnpj_vazio(){
		p1.setCnpj("");
	}
	@Test
	public void nao_deve_aceitar_cnpj_com_tamanho_incorreto(){
		p1.setCnpj("1111");
	}
	@Test
	public void nao_deve_aceitar_nomeproprietario_nulo() {
		assertNotNull(p1.getNomeProprietario());
	}
	@Ignore
	@Test
	public void nao_deve_aceitar_data_de_criacao_nulo() {
		assertNotNull(p1.getCriacao());
	}

	@Test
	public void nao_deve_aceitar_email_nulo() {
		p1.setEmail(null);
	}
	
	@Test
	public void nao_deve_aceitar_email_vazio(){
		p1.setEmail("");
	}
	
	@Test
	public void nao_deve_aceitar_email_tamanho_maximo(){
		p1.setEmail("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_email_tamanho_minimo(){
		p1.setEmail("fff");
	}

	
	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(p1.getEndereco());
	}
			
}
