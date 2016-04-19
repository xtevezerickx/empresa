package br.com.contmatic.entity.empresa.teste;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.entity.empresa.Telefone;

@FixMethodOrder(NAME_ASCENDING)
public class TelefoneTeste {
	private Telefone telefone;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Metodos sendo utilizados antes de iniciar a classe Telefone Teste");
		
		
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
		telefone = null;
		//System.out.println("Depois de cada teste");
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Metodos executados depois da classe Telefone Teste");
	}


	@Test (timeout=1000)
	public void deve_aceitar_numero_telefone_valido() {
		String numeroTelefone = "949789055";
		telefone.setNumeroTelefone(numeroTelefone);
		assertThat(numeroTelefone, is(telefone.getNumeroTelefone()));
	}

	@Test(timeout=1000)
	public void deve_aceitar_ddd_valido() {
		String ddd = "011";
		telefone.setDdd(ddd);
		assertEquals(ddd,telefone.getDdd());
	}

	@Test(timeout=1000)
	public void deve_aceitar_tipo_telefone_valido() {
		String tipoTelefone = "comercial";
		telefone.setTipoTelefone(tipoTelefone);
		assertEquals(tipoTelefone,telefone.getTipoTelefone());
	}

	@Test
	public void nao_deve_aceitar_numero_telefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O Numero do telefone nao pode ser nulo");
		telefone.setNumeroTelefone(null);
		}
	
	@Test 
	public void nao_deve_aceitar_numero_telefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O telefone não pode esta vazio");
		telefone.setNumeroTelefone("");
	}

	@Test
	public void nao_deve_aceitar_numero_telefone_tamanho_incorreto() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O Tamanho do telefone esta incorreto");
		telefone.setNumeroTelefone("11111");
	}

	@Test
	public void nao_deve_aceitar_numero_telefone_com_letras() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O telefone não pode conter letras");
		telefone.setNumeroTelefone("fff");
	}

	@Test
	public void nao_deve_aceitar_ddd_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("DDD não pode ser nulo");
		telefone.setDdd(null);
	}

	@Test
	public void nao_deve_aceitar_ddd_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("DDD não pode ser vazio");
		telefone.setDdd("");
	}

	@Test
	public void nao_deve_aceitar_ddd_com_tamanho_errado() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("DDD com tamanho incorreto");
		telefone.setDdd("44444");
	}

	@Test
	public void nao_deve_aceitar_ddd_com_letras() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("DDD não pode conter caracteres");
		telefone.setDdd("01d");
	}

	@Test
	public void nao_deve_aceitar_tipo_telefone_vazio() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Tipo de telefone não pode ser vazio");
		telefone.setTipoTelefone("");
		
	}

	@Test
	public void nao_deve_aceitar_tipo_telefone_com_numeros() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de telefone não pode conter números");
		telefone.setTipoTelefone("celular4");
	}

	@Test 
	public void nao_deve_aceitar_tipo_telefone_tamanho_maximo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tamanho do tipo de telefone não pode ser maior que o tamanho aceitavel");
		telefone.setTipoTelefone("ffffffffffffffffffffffffffffffffffffff");
	}

	@Test 
	public void nao_deve_aceitar_tipo_telefone_tamanho_minimo() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tamanho do tipo de telefone não pode ser menor que o tamanho aceitavel");
		telefone.setTipoTelefone("fff");
	}

	@Test
	public void nao_deve_aceitar_tipo_telefone_nulo() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Tipo de telefone não pode ser nulo");
		telefone.setTipoTelefone(null);
	
	}

}
