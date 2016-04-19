package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.entity.empresa.Endereco;

@FixMethodOrder(NAME_ASCENDING)
public class EnderecoTeste {
	private Endereco endereco;
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Metodos sendo utilizados antes de iniciar a classe Endereco Teste");
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@After
	public void tearDown(){
		endereco=null;
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Metodos executados depois da classe Endereco Teste");
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
		String nomeLogradouro = "rua alves de almeida";
		endereco.setNomeLogradouro(nomeLogradouro);
		assertEquals(nomeLogradouro,endereco.getNomeLogradouro());
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_tipo_logradouro_valido(){
		String tipoLogradouro = "avenida";
		endereco.setTipoLogradouro(tipoLogradouro);
		assertEquals(tipoLogradouro,endereco.getTipoLogradouro());
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_numero_valido(){
		String numero = "41";
		endereco.setNumero(numero);
		assertEquals(numero,endereco.getNumero());
		
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_cep_valido(){
		String cep = "03378010";
		endereco.setCep(cep);
		assertEquals(cep,endereco.getCep());
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_cidade_valido(){
		String cidade = "Sao paulo";
		endereco.setCidade(cidade);
		assertEquals(cidade, endereco.getCidade());
	}
	
	@Test(timeout=1000)
	public void deve_aceitar_estado_valido(){
		String estado = "Sao Paulo";
		endereco.setEstado(estado);
		assertEquals(estado,endereco.getEstado());
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_bairro_valido(){
		String bairro = "jd vila formosa";
		endereco.setBairro(bairro);
		assertEquals(bairro,endereco.getBairro());
	
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Nome Logradouro deve ser preenchido");
		endereco.setNomeLogradouro(null);
	}
	
	@Test 
	public void nao_deve_aceitar_nome_logradouro_tamanho_maximo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo nome logradouro esta maior que o aceitavel");		
		endereco.setNomeLogradouro("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test 
	public void nao_deve_aceitar_nome_logradouro_tamanho_minimo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo nome logradouro esta menor que o aceitavel");
		endereco.setNomeLogradouro("d");
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Nome Logradouro não pode estar vazio");
		endereco.setNomeLogradouro("");
		
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Tipo do logradouro deve ser preenchido");
		endereco.setTipoLogradouro(null);
		
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Tipo do logradouro não pode ser vazio");
		endereco.setTipoLogradouro("");
				
	}
	
	@Test 
	public void nao_deve_aceitar_tipo_logradouro_tamanho_maximo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro esta maior que o aceitavel");
		endereco.setTipoLogradouro("lklklllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_tamanho_minimo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tipo de logradouro esta menor que o aceitavel");
		endereco.setTipoLogradouro("f");
	}
	
	@Test
	public void nao_deve_aceitar_numero_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O campo numero deve ser preenchido");
		endereco.setNumero(null);
	}
	
	@Test
	public void nao_deve_aceitar_numero_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O numero não pode ser vazio");
		endereco.setNumero("");
	}
	
	@Test 
	public void nao_deve_aceitar_numero_tamanho_incorreto(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo numero esta com tamanho incorreto");
		
		endereco.setNumero("11111111111");
	}
	
	@Test
	public void nao_deve_aceitar_cep_com_letras(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP não pode conter letras");
		
		endereco.setCep("1234567k");
	}
	
	@Test 
	public void nao_deve_aceitar_cep_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O CEP deve ser preenchido");
		endereco.setCep(null);
		
	}
	
	@Test
	public void nao_deve_aceitar_cep_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O CEP não pode ser vazio");
		endereco.setCep("");
		
	}
	
	@Test 
	public void nao_deve_aceitar_cep_tamanho_maior(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tamanho do CEP esta incorreto");
		endereco.setCep("123456789");
	}
	
	@Test 
	public void nao_deve_aceitar_cep_tamanho_menor(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O tamanho do CEP esta incorreto");
		endereco.setCep("1234567");
	}
	
	
	
	@Test
	public void nao_deve_aceitar_cidade_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O campo cidade deve ser preenchido");
		endereco.setCidade(null);
		
	}
	
	@Test
	public void nao_deve_aceitar_cidade_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo cidade não pode ser vazio");
		endereco.setCidade("");
		
	}
	
	@Test 
	public void nao_deve_aceitar_cidade_com_numero(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo cidade não pode conter numeros");
		endereco.setCidade("fdf33");
	}
	
	@Test 
	public void nao_deve_aceitar_cidade_tamanho_maior(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo cidade contem mais caracteres que o aceitavel");
		endereco.setCidade("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_cidade_tamanho_menor(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo cidade contem menos caracteres que o aceitavel");
		endereco.setCidade("oi");
	}
	
	
	@Test
	public void nao_deve_aceitar_estado_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O campo estado deve ser preenchido");
		endereco.setEstado(null);
	}
	
	@Test
	public void nao_deve_aceitar_estado_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo estado não pode ser vazio");
		endereco.setEstado("");
		
	}
	
	@Test 
	public void nao_deve_aceitar_estado_com_numero(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo estado não pode conter numeros");
		endereco.setEstado("Sao Paulo0");
	}
	
	@Test 
	public void nao_deve_aceitar_estado_com_tamanho_incorreto(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo estado contem mais caracteres que o aceitavel");
		endereco.setEstado("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_bairro_nulo(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("O campo bairro deve ser preenchido");
		endereco.setBairro(null);
	
	}
	
	@Test
	public void nao_deve_aceitar_bairro_vazio(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo bairro não pode ser vazio");
		endereco.setBairro("");
	}
		
	@Test
	public void nao_deve_aceitar_bairro_tamanho_minimo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo bairro contem menos caracteres que o aceitavel");
		
		endereco.setBairro("kk");
	}
	@Test
	public void nao_deve_aceitar_bairro_tamanho_maximo(){	
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("O campo bairro contem mais caracteres que o aceitavel");
		
		endereco.setBairro("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	}
	
	
	

}
