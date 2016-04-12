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
		tel.setDdd(11);
		tel.setTelefone("123456789");
		tel.setTipo("celular");
		
		p1.setCnpj("11123121");
		p1.setEmail("email@email.com.br");
		p1.setEndereco(endereco);
		p1.setNomeFantasia("nome da empresa");
		p1.setNomeProprietario("proprietario");
		p1.setTelefone(tel);

	}

	@Test
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		assertNotNull(p1.getNomeFantasia());
	}

	@Test
	public void nao_deve_aceitar_email_nulo() {
		assertNotNull(p1.getEmail());
	}

	@Test
	public void nao_deve_aceitar_nome_fantasia_vazio() {
		p1.setNomeFantasia(" ");
		assertFalse(p1.getNomeFantasia().isEmpty());
	}

	@Test
	public void nao_deve_aceitar_telefone_nulo() {
		assertTrue(tel.validateTelefoneNotNull(tel));
	}

	@Test
	public void nao_deve_aceitar_cnpj_nulo() {
		assertNotNull(p1.getCnpj());
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
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(p1.getEndereco());
	}
}
