package com.mycompany.cardapio;
// atributos de Produto
public class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidade;
    private String descricao;
//metodo de acesso para os atributos
    public Produto(String nome, String categoria, double preco, int quantidade, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
// metodo get
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
