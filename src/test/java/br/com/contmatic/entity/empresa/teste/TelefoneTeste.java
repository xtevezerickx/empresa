package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.entity.empresa.Telefone;

@FixMethodOrder(NAME_ASCENDING)
public class TelefoneTeste {
	private Telefone telefone;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Metodos sendo utilizados antes de iniciar a classe");
		
		
	}
	
	@Before
	public void setUp() {
		telefone = new Telefone();
		telefone.setDdd("011");
		telefone.setNumeroTelefone("123456789");
		telefone.setTipoTelefone("celular");
		//System.out.println("Antes de cada teste");
	}
	
	@After
	public void tearDown(){
		//System.out.println("Depois de cada teste");
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Metodos executados depois da classe");
	}


	@Test (timeout=1000)
	public void deve_aceitar_numero_telefone_valido() {
		telefone.getNumeroTelefone();
	}

	@Test(timeout=1000)
	public void deve_aceitar_ddd_valido() {
		telefone.getDdd();
	}

	@Test(timeout=1000)
	public void deve_aceitar_tipo_telefone_valido() {
		telefone.getTipoTelefone();
	}

	@Test
	public void nao_deve_aceitar_numero_telefone_nulo() {
		assertNotNull(telefone.getNumeroTelefone());
	}
	
	@Test 
	public void nao_deve_aceitar_numero_telefone_vazio() {
		assertFalse(telefone.getNumeroTelefone().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_numero_telefone_tamanho_incorreto() {
		telefone.setNumeroTelefone("11111");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_numero_telefone_com_letras() {
		telefone.setNumeroTelefone("fff");
	}

	@Test
	public void nao_deve_aceitar_ddd_nulo() {
		assertNotNull(telefone.getDdd());
	}

	@Test
	public void nao_deve_aceitar_ddd_vazio() {
		assertFalse(telefone.getDdd().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_com_tamanho_errado() {
		telefone.setDdd("44444");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_com_letras() {
		telefone.setDdd("ddd");
	}

	@Test
	public void nao_deve_aceitar_tipo_telefone_vazio() {
		assertFalse(telefone.getTipoTelefone().isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tipo_telefone_com_numeros() {
		telefone.setTipoTelefone("2344");
	}

	@Test (expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tipo_telefone_tamanho_maximo() {
		telefone.setTipoTelefone("ffffffffffffffffffffffffffffffffffffff");
	}

	@Test (expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_tipo_telefone_tamanho_minimo() {
		telefone.setTipoTelefone("fff");
	}

	@Test
	public void nao_deve_aceitar_tipo_telefone_nulo() {
		assertNotNull(telefone.getTipoTelefone());
	}

}
