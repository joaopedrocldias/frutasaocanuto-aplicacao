package br.com.frutasaocanuto.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fornecedor;

    @Column(unique = true)
    @NotBlank(message = "Nome não pode ser vazia")
    private String nome;

    @Column
    private String telefone;

    @Column
    private String endereco;

    public Fornecedor(int id_fornecedor, String endereco, String telefone, String nome) {
        this.id_fornecedor = id_fornecedor;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Fornecedor(String endereco, String telefone, String nome){
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Nome não pode ser vazia") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome não pode ser vazia") String nome) {
        this.nome = nome;
    }
}
