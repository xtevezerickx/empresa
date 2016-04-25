package br.com.contmatic.entity.empresa.teste;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.hamcrest.core.IsNull;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.contmatic.entity.empresa.Empresa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import junit.framework.Assert;

@FixMethodOrder(NAME_ASCENDING)

public class EmpresaTeste {
    

    private Empresa empresa;
//    private Set<Endereco> enderecos;
//    private Set<Telefone> telefones;
//    private Set<Endereco> enderecoInvalido;
//    private Set<Telefone> telefoneInvalido;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Metodos sendo utilizados antes de iniciar a classe Empresa Teste");

    }

    @After
    public void tearDown() {
        empresa = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Metodos executados depois da classe Empresa Teste");
    }

    @Before
    public void setUp() {

        
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.entity.empresa.teste.templates");
        empresa =  Fixture.from(Empresa.class).gimme("valido");
      

    }

    @Test(timeout = 1000)
    public void deve_aceitar_nome_fantasia_valido() {
        String nomeFantasia = "nome empresa";
        empresa.setNomeFantasia(nomeFantasia);
        assertEquals(nomeFantasia, empresa.getNomeFantasia());
    }

    @Test(timeout = 1000)
    public void deve_aceitar_nome_proprietario_valido() {
        String nomeProprietario = "Erick Maia";
        empresa.setNomeProprietario(nomeProprietario);
        assertEquals(nomeProprietario, empresa.getNomeProprietario());
    }

    @Test(timeout = 1000)
    public void deve_aceitar_cnpj_valido() {
        String cnpj = "11123121111111";
        empresa.setCnpj(cnpj);
        assertEquals(cnpj, empresa.getCnpj());
    }

    @Test(timeout = 1000)
    public void deve_aceitar_email_valido() {
        String email = "erick@mail.com.br";
        empresa.setEmail(email);
        assertEquals(email, empresa.getEmail());
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Nome Fantasia não pode ser nulo");
        empresa.setNomeFantasia(null);

    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome Fantasia não pode estar vazio");
        empresa.setNomeFantasia("");
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_com_minimo_de_caracteres() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do nome fantasia esta menor que o aceitavel");
        empresa.setNomeFantasia("aaaa");
    }

    @Test
    public void nao_deve_aceitar_nome_fantasia_com_maximo_de_caracteres() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do nome fantasia esta maior que o aceitavel");
        empresa.setNomeFantasia("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void nao_deve_aceitar_nome_proprietario_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Nome do proprietário não pode ser nulo");
        empresa.setNomeProprietario(null);
    }

    @Test
    public void nao_deve_aceitar_nome_proprietario_com_numeros() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome do proprietario não pode conter numeros");
        empresa.setNomeProprietario("er111");
    }

    @Test
    public void nao_deve_aceitar_nome_proprietario_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome do proprietário não pode estar vazio");
        empresa.setNomeProprietario("");

    }

    @Test
    public void nao_deve_aceitar_nome_proprietario_com_tamanho_maximo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do nome proprietario esta maior que o tamanho aceitavel");
        empresa.setNomeProprietario("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
    }

    @Test
    public void nao_deve_aceitar_nome_proprietario_com_tamanho_minimo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do nome proprietario esta menor que o tamanho aceitavel");
        empresa.setNomeProprietario("ffff");
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("CNPJ não pode ser nulo");
        empresa.setCnpj(null);       
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_letras() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CNPJ não pode conter letras");
        empresa.setCnpj("1111111ff");
    }

    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CNPJ não pode estar vazio");
        empresa.setCnpj("");

    }

    @Test
    public void nao_deve_aceitar_cnpj_com_tamanho_menor() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Tamanho do CNPJ incorreto");
        empresa.setCnpj("1");
    }

    @Test
    public void nao_deve_aceitar_cnpj_com_tamanho_maior() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Tamanho do CNPJ incorreto");
        empresa.setCnpj("5555555555555555555555");
    }

    @Test
    public void nao_deve_aceitar_email_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Email não pode ser nulo");
        empresa.setEmail(null);
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email não pode ser vazio");
        empresa.setEmail("");
    }

    @Test
    public void nao_deve_aceitar_email_tamanho_maximo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do email esta maior que o aceitavel");
        empresa.setEmail("fffffffffffffffffffffffffffffffffffffff");
    }

    @Test
    public void nao_deve_aceitar_email_tamanho_minimo() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("O Tamanho do email esta menor que o aceitavel");
        empresa.setEmail("fff");
        // assertEquals(3,empresa.getEmail().length());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Endereco não pode ser nulo");
        empresa.setEndereco(null);
    }

    @Test
    public void nao_deve_aceitar_data_criacao_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("A data de criação não pode ser nula");
        empresa.setDataCriacao(null);
    }

    @Test
    public void nao_deve_aceitar_data_criacao_maior_que_atual() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("A data de criação não pode ser maior que a atual");
        empresa.setDataCriacao(new DateTime(2016, 8, 20, 0, 0, 0));

    }

    @Test
    public void nao_deve_aceitar_data_criacao_menor_que_atual() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("A data da alteração não pode ser antes que a data de criação");
        empresa.setDataAlteracao(new DateTime(100, 2, 25, 0, 0, 0));

    }

    @Test
    public void deve_aceitar_data_alteracao_maior_que_data_criacao() {
        DateTime dataAlteracao = new DateTime().plusDays(2);
        empresa.setDataAlteracao(dataAlteracao);
        assertTrue(empresa.getDataAlteracao().isAfter(empresa.getDataCriacao()));
    }

 
    @Test
    public void deve_aceitar_data_criacao_valida() {
        assertThat(new DateTime(2016,04,25,0,0,0), is(empresa.getDataCriacao()));
    }

   

  
    @Test
   
    public void deve_aceitar_endereco_valido() {
        assertThat(empresa.getEndereco().size(),greaterThan(1));
    }

      @Test
    public void deve_aceitar_telefone_valido() {
       assertThat(empresa.getTelefone().size(),greaterThan(1));
    }

    @Test
    public void teste_to_string() {
        System.out.println(empresa);
    }
}
