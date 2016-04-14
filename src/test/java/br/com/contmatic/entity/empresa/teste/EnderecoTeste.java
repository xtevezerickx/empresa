package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import br.com.contmatic.entity.empresa.Endereco;

@FixMethodOrder(NAME_ASCENDING)
public class EnderecoTeste {
	private Endereco endereco;
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Metodos sendo utilizados antes de iniciar a classe");
		
	}
	
	@After
	public void tearDown(){
		endereco=null;
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Metodos executados depois da classe");
	}
	@Before
	public void setUp(){
		endereco =new Endereco();
		endereco.setBairro("bairro de teste");
		endereco.setCep("03378010");
		endereco.setCidade("Sao paulo");
		endereco.setEstado("Sao Paulo");
		endereco.setNomeLogradouro("rua tal tal tal ");
		endereco.setNumero("1124");
		endereco.setTipoLogradouro("rua");
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_nome_logradouro_valido(){
		endereco.getNomeLogradouro();
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_tipo_logradouro_valido(){
		endereco.getTipoLogradouro();
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_numero_valido(){
		endereco.getNumero();
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_cep_valido(){
		endereco.getCep();
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_cidade_valido(){
		endereco.getCidade();
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_estado_valido(){
		endereco.getEstado();
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_bairro_valido(){
		endereco.getBairro();
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_nulo(){
		assertNotNull(endereco.getNomeLogradouro());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_logradouro_tamanho_maximo(){
		endereco.setNomeLogradouro("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_logradouro_tamanho_minimo(){
		endereco.setNomeLogradouro("d");
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_vazio(){
		assertFalse(endereco.getNomeLogradouro().isEmpty());
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_nulo(){
		assertNotNull(endereco.getTipoLogradouro());
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_vazio(){
		assertFalse(endereco.getTipoLogradouro().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_tipo_logradouro_tamanho_maximo(){
		endereco.setTipoLogradouro("lklklllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_tipo_logradouro_tamanho_minimo(){
		endereco.setTipoLogradouro("f");
	}
	
	@Test
	public void nao_deve_aceitar_numero_nulo(){
		assertNotNull(endereco.getNumero());
	}
	
	@Test
	public void nao_deve_aceitar_numero_vazio(){
		assertFalse(endereco.getNumero().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_numero_tamanho_incorreto(){
		endereco.setNumero("11111111111");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_com_letras(){
		endereco.setCep("1234567k");
	}
	
	@Test 
	public void nao_deve_aceitar_cep_nulo(){
		assertNotNull(endereco.getCep());
	}
	
	@Test
	public void nao_deve_aceitar_cep_vazio(){
		assertFalse(endereco.getCep().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_tamanho_maior(){
		endereco.setCep("123456789");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_tamanho_menor(){
		endereco.setCep("1234567");
	}
	
	
	
	@Test
	public void nao_deve_aceitar_cidade_nulo(){
		assertNotNull(endereco.getCidade());
	}
	
	@Test
	public void nao_deve_aceitar_cidade_vazio(){
		assertFalse(endereco.getCidade().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cidade_com_numero(){
		endereco.setCidade("fdf33");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cidade_tamanho_incorreto(){
		endereco.setCidade("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_estado_nulo(){
		assertNotNull(endereco.getCidade());
	}
	
	@Test
	public void nao_deve_aceitar_estado_vazio(){
		assertFalse(endereco.getCidade().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_estado_com_numero(){
		endereco.setCidade("k666");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_estado_com_tamanho_incorreto(){
		endereco.setEstado("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_bairro_nulo(){
		assertNotNull(endereco.getBairro());
	}
	
	@Test
	public void nao_deve_aceitar_bairro_vazio(){
		assertFalse(endereco.getBairro().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_bairro_tamanho_incorreto(){
		endereco.setBairro("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	

}
