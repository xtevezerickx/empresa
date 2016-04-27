package br.com.contmatic.entity.empresa.constantes;



public enum EnderecoType {
    
    /** Constante para tipo de endereco comercial. */
    COMERCIAL("Comercial"),
    
    /**Constante para tipo de endereco filial. */
    FILIAL("Filial"),
    
    /** Constante para tipo de endereco residencial. */
    RESIDENCIAL("Residencial");
    
    /** Recebe a descricao. */
    String descricao;
    
    /**
     * Construtor privado para um tipo de endereco.
     *
     * @param descricao
     */
    private EnderecoType(String descricao){
        this.descricao = descricao;
    }
    
    /**
     * Retrona a descrição do tipo de endereço
     *
     * @return descricao
     */
    public String getDescricao(){
        return this.descricao;
    }
}
