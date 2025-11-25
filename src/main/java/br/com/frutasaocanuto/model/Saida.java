package br.com.frutasaocanuto.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_saida;

    @OneToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    @Column
    @NotBlank(message = "Quantidade não pode ser vazia")
    private double quantidade;

    @Column()
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_entrada = LocalDate.now();

    public Saida(int id_saida, LocalDate data_entrada, double quantidade, Fornecedor fornecedor, Usuario usuario, Produto produto) {
        this.id_saida = id_saida;
        this.data_entrada = data_entrada;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
        this.produto = produto;
    }

    public Saida(double quantidade, Fornecedor fornecedor, Usuario usuario, Produto produto) {
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.usuario = usuario;
        this.produto = produto;
    }

    public Saida(int id_saida, double quantidade) {
        this.id_saida = id_saida;
        this.quantidade = quantidade;
    }

    public int getId_saida() {
        return id_saida;
    }

    public void setId_saida(int id_entrada) {
        this.id_saida = id_entrada;
    }

    public LocalDate getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDate data_entrada) {
        this.data_entrada = data_entrada;
    }

    @NotBlank(message = "Quantidade não pode ser vazia")
    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotBlank(message = "Quantidade não pode ser vazia") double quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
