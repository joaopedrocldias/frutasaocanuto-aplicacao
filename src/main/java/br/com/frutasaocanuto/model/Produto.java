package br.com.frutasaocanuto.model;

import br.com.frutasaocanuto.model.enums.produto.Categoria;
import br.com.frutasaocanuto.model.enums.produto.Unidade;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;

    @Column()
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Categoria não pode ser vazia")
    private Categoria categoria;

    @Column(unique = true)
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @Column
    private double estoque = 0.00;

    @Column
    @NotBlank(message = "Unidade não pode ser vazia")
    private Unidade unidade;

    public Produto(int id_produto, Unidade unidade, double estoque, String nome, Categoria categoria) {
        this.id_produto = id_produto;
        this.unidade = unidade;
        this.estoque = estoque;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Produto(int id_produto, Unidade unidade, String nome, Categoria categoria) {
        this.id_produto = id_produto;
        this.unidade = unidade;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Produto(Unidade unidade, String nome, Categoria categoria) {
        this.unidade = unidade;
        this.nome = nome;
        this.categoria = categoria;
    }

    public Produto() {

    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public @NotBlank(message = "Unidade não pode ser vazia") Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(@NotBlank(message = "Unidade não pode ser vazia") Unidade unidade) {
        this.unidade = unidade;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public @NotBlank(message = "Nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Categoria não pode ser vazia") Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank(message = "Categoria não pode ser vazia") Categoria categoria) {
        this.categoria = categoria;
    }
}
