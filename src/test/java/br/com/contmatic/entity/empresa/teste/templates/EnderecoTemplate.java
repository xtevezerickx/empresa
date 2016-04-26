package br.com.contmatic.entity.empresa.teste.templates;

import br.com.contmatic.entity.empresa.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplate implements TemplateLoader {
    
    
    public void load() {
        Fixture.of(Endereco.class).addTemplate("valido", new Rule(){{
            add("bairro",random("bairro um","bairro dois","bairro tres"));
            add("cep",random("01154874","03378050","03315487"));
            add("cidade",random("Sao paulo","Acre","Rio de janeiro"));
            add("estado",random("Minas Gerais","Sao paulo","Rio"));
            add("nomeLogradouro",random("rua x","rua y","rua z"));
            add("numero",random("1","2","3"));
            add("tipoLogradouro",random("rua","av","cond"));
         }});
        Fixture.of(Endereco.class).addTemplate("invalido", new Rule(){{
            add("bairro",random("bairro um","bairro dois","bairro tres"));
            add("cep",random("01154874","03378050","03315487"));
            add("cidade",random("Sao paulo","Acre","Rio de janeiro"));
            add("estado",random("Minas Gerais","Sao paulo","Rio"));
            add("nomeLogradouro",random("rua x","rua y","rua z"));
            add("numero",random("1","2","3"));
            add("tipoLogradouro",random("rua","av","cond"));
         }});
    }

}
