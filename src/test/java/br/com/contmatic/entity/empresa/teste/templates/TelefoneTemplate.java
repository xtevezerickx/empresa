package br.com.contmatic.entity.empresa.teste.templates;

import br.com.contmatic.entity.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplate implements TemplateLoader {
    public void load() {
        Fixture.of(Telefone.class).addTemplate("valido", new Rule(){{
            add("ddd",random("011","015","056","018"));
            add("numeroTelefone",random("123456789","987654321","654789123"));
            add("tipoTelefone",random("celular","comercial","filial"));
        }});
        Fixture.of(Telefone.class).addTemplate("invalido", new Rule(){{
            add("ddd",random("01","05","06","08"));
            add("numeroTelefone",random("123456","987654324441","654789l23"));
            add("tipoTelefone",random("oo","c54778",""));
        }});
    }

    
}
