package br.com.contmatic.entity.empresa.teste.templates;

import br.com.contmatic.entity.empresa.Empresa;
import br.com.contmatic.entity.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplate implements TemplateLoader{

    public void load() {
        Fixture.of(Empresa.class).addTemplate("valido", new Rule(){{
            add("ddd",random("011","015","056","018"));
            add("numeroTelefone",random("123456789","987654321","654789123"));
            add("tipoTelefone",random("ceular","comercial","filial"));
        }});

        
    }

}
