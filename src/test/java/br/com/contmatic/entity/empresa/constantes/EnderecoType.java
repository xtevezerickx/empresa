package br.com.contmatic.entity.empresa.constantes;

public enum EnderecoType {
    COMERCIAL("Comercial"),
    FILIAL("Filial"),
    RESIDENCIAL("Residencial");
    
    String descricao;
    private EnderecoType(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
}
