package br.com.contmatic.entity.empresa.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.entity.empresa.Empresa;
import br.com.contmatic.entity.empresa.Endereco;
import br.com.contmatic.entity.empresa.Telefone;

@FixMethodOrder(NAME_ASCENDING)

public class EmpresaTeste {
	private Empresa empresa;
	private Endereco[] endereco;
	private Telefone[] telefone;
	private Endereco[] enderecoInvalido;
	private Telefone[] telefoneInvalido;
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Metodos sendo utilizados antes de iniciar a classe");
		
	}
	
	@After
	public void tearDown(){
		empresa = null;
		endereco= null;
		telefone =null;
		//System.out.println("Depois de cada teste");
	}
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Metodos executados depois da classe");
	}
	
	@Before
	public void setUp() {
		empresa = new Empresa();
		endereco = new Endereco[2];
		endereco[0]= new Endereco();
		endereco[1]= new Endereco();
		telefone = new Telefone[2];
		telefone[0]= new Telefone();
		telefone[1] = new Telefone();
		enderecoInvalido = new Endereco[2];
		enderecoInvalido[1] = new Endereco();
		telefoneInvalido = new Telefone[2]; 
		telefoneInvalido[0] = new Telefone();
		
		endereco[0].setNomeLogradouro("rua tal tal tal");
		endereco[0].setCep("03378010");
		endereco[0].setCidade("Sao paulo");
		endereco[0].setEstado("sao paulo");
		endereco[0].setTipoLogradouro("rua");
		endereco[0].setNumero("142");
		endereco[0].setBairro("bairro x");
				
		telefone[0].setDdd("011");
		telefone[0].setNumeroTelefone("634570287");
		telefone[0].setTipoTelefone("celular");
				
		endereco[1].setNomeLogradouro("rua 2");
		endereco[1].setCep("03378010");
		endereco[1].setCidade("Poços de Caldas");
		endereco[1].setEstado("Minas Gerais");
		endereco[1].setTipoLogradouro("avenida");
		endereco[1].setNumero("153");
		endereco[1].setBairro("bairro Z");
		
		telefone[1].setDdd("035");
		telefone[1].setNumeroTelefone("123456789");
		telefone[1].setTipoTelefone("comercial");
						
		enderecoInvalido[1].setNomeLogradouro("rua 3");
		enderecoInvalido[1].setCep("03378015");
		enderecoInvalido[1].setCidade("Rio de Janeiro");
		enderecoInvalido[1].setEstado("Rio");
		enderecoInvalido[1].setTipoLogradouro("avenida");
		enderecoInvalido[1].setNumero("1223");
		enderecoInvalido[1].setBairro("bairro da tijuca");
		
		telefoneInvalido[0].setDdd("011");
		telefoneInvalido[0].setNumeroTelefone("123456889");
		telefoneInvalido[0].setTipoTelefone("comercial");
					
		empresa.setCnpj("11123121111111");
		empresa.setEmail("ssssssss@sss.com.br");
		empresa.setEndereco(endereco);
		empresa.setNomeFantasia("nome da empresa");
		empresa.setNomeProprietario("proprietario");
		empresa.setTelefone(telefone);
		empresa.setDataCriacao(new Date());
		
	}

	@Test (timeout=1000)
	public void deve_aceitar_nome_fantasia_valido(){
		empresa.getNomeFantasia();
	}
	@Test (timeout=1000)
	public void deve_aceitar_nome_proprietario_valido(){
		empresa.getNomeProprietario();
	}
	@Test (timeout=1000)
	public void deve_aceitar_cnpj_valido(){
		empresa.getCnpj();
	}
	
	@Test (timeout=1000)
	public void deve_aceitar_email_valido(){
		empresa.getEmail();
	}
	
	@Test
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		assertNotNull(empresa.getNomeFantasia());
	}
	
	@Test
	public void nao_deve_aceitar_nome_fantasia_vazio(){
		assertFalse(empresa.getNomeFantasia().isEmpty());
	}
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_fantasia_com_minimo_de_caracteres(){
		empresa.setNomeFantasia("aaaa");
	}
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_fantasia_com_maximo_de_caracteres(){
		empresa.setNomeFantasia("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void nao_deve_aceitar_nome_proprietario_nulo(){
		assertNotNull(empresa.getNomeProprietario());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_proprietario_com_numeros(){
		empresa.setNomeProprietario("er111");
	}
	
	@Test
	public void nao_deve_aceitar_nome_proprietario_vazio(){
		assertFalse(empresa.getNomeProprietario().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_maximo(){
		empresa.setNomeProprietario("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_proprietario_com_tamanho_minimo(){
		empresa.setNomeProprietario("ffff");
	}
	
	
	@Test
	public void nao_deve_aceitar_cnpj_nulo() {
		assertNotNull(empresa.getCnpj());
	}

	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cnpj_com_letras(){
		empresa.setCnpj("asdfas");
	}
	@Test
	public void nao_deve_aceitar_cnpj_vazio(){
		assertFalse(empresa.getCnpj().isEmpty());
	}
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_cnpj_com_tamanho_incorreto(){
		empresa.setCnpj("1111111111111111");
	}
	
	@Test
	public void nao_deve_aceitar_cnpj_com_tamanho_menor(){
		thrown.expect(IllegalArgumentException.class);
		empresa.setCnpj("1");
	}
	
	@Test
	public void nao_deve_aceitar_cnpj_com_tamanho_maior(){
		thrown.expect(IllegalArgumentException.class);
		empresa.setCnpj("5555555555555555555555");
	}
	
	
	
	@Test
	public void nao_deve_aceitar_email_nulo() {
		assertNotNull(empresa.getEmail());
	}
	
	@Test
	public void nao_deve_aceitar_email_vazio(){
		assertFalse(empresa.getEmail().isEmpty());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_email_tamanho_maximo(){
		empresa.setEmail("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void nao_deve_aceitar_email_tamanho_minimo(){
		empresa.setEmail("fff");
	}

	
	@Test 
	public void nao_deve_aceitar_endereco_nulo() {
		assertNotNull(empresa.getEndereco());
	}
		
	
	@Test
	public void nao_deve_aceitar_data_criacao_nulo(){
		assertNotNull(empresa.getDataCriacao());
	}
		
	
	@Test (expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_maior_que_atual(){
		empresa.setDataCriacao(new Date(2050, 1, 10));
		
	}
	
	@Test 
	public void nao_deve_aceitar_data_criacao_menor_que_atual(){
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("A data da alteração não pode ser antes que a data de criação");
		empresa.setDataAlteracao(new Date(100,0,25));
		
	}
	
	@Test
	public void deve_aceitar_data_alteracao_maior_que_data_criacao(){
		empresa.setDataAlteracao(new Date(116,4,18));
		assertTrue(empresa.getDataAlteracao().after(empresa.getDataCriacao()));
	}
	
	
	@Test
	public void deve_aceitar_data_criacao_valida(){
		empresa.getDataCriacao();
	}
	
	@Test 
	public void nao_deve_aceitar_endereco_invalido(){
		thrown.expect(IllegalStateException.class);
		empresa.setEndereco(enderecoInvalido);
	}
	@Test
	public void deve_aceitar_endereco_valido(){
		empresa.setEndereco(endereco);
	}
	
	@Test
	public void nao_deve_aceitar_telefone_invalido(){
		thrown.expect(IllegalStateException.class);
		empresa.setTelefone(telefoneInvalido);
	}
	
	@Test
	public void deve_aceitar_telefone_valido(){
		empresa.setTelefone(telefone);
	}
	
//	@Ignore
	@Test
	public void teste_to_string(){
		System.out.println(empresa);
	}
}
