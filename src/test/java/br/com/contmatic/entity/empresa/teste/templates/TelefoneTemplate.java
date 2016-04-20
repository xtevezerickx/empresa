package br.com.contmatic.entity.empresa.teste.templates;

import org.joda.time.DateTime;

import br.com.contmatic.entity.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplate implements TemplateLoader {
    public void load() {
        Fixture.of(Telefone.class).addTemplate("valido", new Rule(){{
            add("cnpj",random("12345678912314","12345678945687"));
            add("email","${cnpj}@gmail.com");
            add("ddd",random("011","015","056","018"));
            add("numeroTelefone",random("123456789","987654321","654789123"));
            add("tipoTelefone",random("ceular","comercial","filial"));
        }});
//        empresa.setCnpj("11123121111111");
//        empresa.setEmail("ssssssss@sss.com.br");
//        empresa.setEndereco(endereco);
//        empresa.setNomeFantasia("nome da empresa");
//        empresa.setNomeProprietario("proprietario");
//        empresa.setTelefone(telefone);
//        empresa.setDataCriacao(new DateTime(2016,3,19,0,0,0));
    }

    
}
