package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.assertNotNull;
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
	private Empresa empresa1;
	private Endereco endereco;
	private Telefone tel;

	@Before
	public void setUp() {
		empresa1 = new Empresa();
		endereco = new Endereco();
		
		
		empresa1.setCnpj("11123121111111");
		empresa1.setEmail("ssssssss@sss.com.br");
		empresa1.setEndereco(endereco);
		empresa1.setNomeFantasia("nome da empresa");
		empresa1.setNomeProprietario("proprietario");
		empresa1.setTelefone(tel);

	}

	@Test
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		empresa1.setNomeFantasia(null);
	}
	
	@Test
	public void nao_deve_aceitar_nome_fantasia_vazio(){
		empresa1.setNomeFantasia("");
	}
	@Test
	public void nao_deve_aceitar_nome_fantasia_com_minimo_de_caracteres(){
		empresa1.setNomeFantasia("aaaa");
	}
	@Test
	public void nao_deve_aceitar_nome_fantasia_com_maximo_de_caracteres(){
		empresa1.setNomeFantasia("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void nao_deve_aceitar_nome_proprietario_nulo(){
		empresa1.setNomeProprietario(null);
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_numeros(){
		empresa1.setNomeProprietario("er111");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_vazio(){
		empresa1.setNomeProprietario("");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_maior(){
		empresa1.setNomeProprietario("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_menor(){
		empresa1.setNomeProprietario("ffff");
	}
	
	
	@Test
	public void nao_deve_aceitar_cnpj_nulo() {
		empresa1.setCnpj(null);
	}

	@Test
	public void nao_deve_aceitar_cnpj_com_letras(){
		empresa1.setCnpj("asdfas");
	}
	@Test
	public void nao_deve_aceitar_cnpj_vazio(){
		empresa1.setCnpj("");
	}
	@Test
	public void nao_deve_aceitar_cnpj_com_tamanho_incorreto(){
		empresa1.setCnpj("1111");
	}
	@Test
	public void nao_deve_aceitar_nomeproprietario_nulo() {
		assertNotNull(empresa1.getNomeProprietario());
	}
	@Ignore
	@Test
	public void nao_deve_aceitar_data_de_criacao_nulo() {
		assertNotNull(empresa1.getCriacao());
	}

	@Test
	public void nao_deve_aceitar_email_nulo() {
		empresa1.setEmail(null);
	}
	
	@Test
	public void nao_deve_aceitar_email_vazio(){
		empresa1.setEmail("");
	}
	
	@Test
	public void nao_deve_aceitar_email_tamanho_maximo(){
		empresa1.setEmail("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_email_tamanho_minimo(){
		empresa1.setEmail("fff");
	}

	
	@Test
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(empresa1.getEndereco());
	}
			
}
