package br.com.frutasaocanuto.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Produto_Fornecido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto_fornecido;

    @OneToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column
    private double lucro_estimado;

    @Column
    private double preco_venda;

    @Column
    private double preco_custo;

    @Column()
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_registro = LocalDate.now();

    public Produto_Fornecido(int id_produto_fornecido, LocalDate data_registro, double preco_custo, double preco_venda, double lucro_estimado, Fornecedor fornecedor, Produto produto) {
        this.id_produto_fornecido = id_produto_fornecido;
        this.data_registro = data_registro;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.lucro_estimado = lucro_estimado;
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public Produto_Fornecido(double preco_custo, double preco_venda, double lucro_estimado, Fornecedor fornecedor, Produto produto) {
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.lucro_estimado = lucro_estimado;
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public int getId_produto_fornecido() {
        return id_produto_fornecido;
    }

    public void setId_produto_fornecido(int id_produto_fornecido) {
        this.id_produto_fornecido = id_produto_fornecido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getLucro_estimado() {
        return lucro_estimado;
    }

    public void setLucro_estimado(double lucro_estimado) {
        this.lucro_estimado = lucro_estimado;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public double getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(double preco_custo) {
        this.preco_custo = preco_custo;
    }

    public LocalDate getData_registro() {
        return data_registro;
    }

    public void setData_registro(LocalDate data_registro) {
        this.data_registro = data_registro;
    }
}
