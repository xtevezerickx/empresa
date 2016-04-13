package br.com.contmatic.entity.empresa.teste;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import br.com.contmatic.entity.empresa.Endereco;

@FixMethodOrder(NAME_ASCENDING)
public class EnderecoTeste {
	private Endereco endereco;
	
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
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_nulo(){
		endereco.setNomeLogradouro(null);
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_tamanho_maximo(){
		endereco.setNomeLogradouro("fffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_tamanho_minimo(){
		endereco.setNomeLogradouro("d");
	}
	
	@Test
	public void nao_deve_aceitar_nome_logradouro_vazio(){
		endereco.setNomeLogradouro("");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_nulo(){
		endereco.setTipoLogradouro(null);
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_vazio(){
		endereco.setTipoLogradouro("");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_tamanho_maximo(){
		endereco.setTipoLogradouro("lklklllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	}
	
	@Test
	public void nao_deve_aceitar_tipo_logradouro_tamanho_minimo(){
		endereco.setTipoLogradouro("f");
	}
	
	@Test
	public void nao_deve_aceitar_numero_nulo(){
		endereco.setNumero(null);
	}
	
	@Test
	public void nao_deve_aceitar_numero_vazio(){
		endereco.setNumero("");
	}
	
	@Test
	public void nao_deve_aceitar_numero_tamanho_incorreto(){
		endereco.setNumero("1111111111");
	}
	
	@Test
	public void nao_deve_aceitar_cep_com_letras(){
		endereco.setCep("kkkk");
	}
	
	@Test
	public void nao_deve_aceitar_cep_nulo(){
		endereco.setCep(null);
	}
	
	@Test
	public void nao_deve_aceitar_cep_vazio(){
		endereco.setCep("");
	}
	
	@Test
	public void nao_deve_aceitar_cep_tamanho_incorreto(){
		endereco.setCep("1425415");
	}
	
	@Test
	public void nao_deve_aceitar_cidade_nulo(){
		endereco.setCidade(null);
	}
	
	@Test
	public void nao_deve_aceitar_cidade_vazio(){
		endereco.setCidade("");
	}
	
	@Test
	public void nao_deve_aceitar_cidade_com_numero(){
		endereco.setCidade("fdf33");
	}
	
	@Test
	public void nao_deve_aceitar_cidade_tamanho_incorreto(){
		endereco.setCidade("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_estado_nulo(){
		endereco.setCidade(null);
	}
	
	@Test
	public void nao_deve_aceitar_estado_vazio(){
		endereco.setCidade("");
	}
	
	@Test
	public void nao_deve_aceitar_estado_com_numero(){
		endereco.setCidade("k666");
	}
	
	@Test
	public void nao_deve_aceitar_estado_com_tamanho_incorreto(){
		endereco.setEstado("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	
	@Test
	public void nao_deve_aceitar_bairro_nulo(){
		endereco.setBairro(null);
	}
	
	@Test
	public void nao_deve_aceitar_bairro_vazio(){
		endereco.setBairro("");
	}
	
	@Test
	public void nao_deve_aceitar_bairro_tamanho_incorreto(){
		endereco.setBairro("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
	}
	

}
