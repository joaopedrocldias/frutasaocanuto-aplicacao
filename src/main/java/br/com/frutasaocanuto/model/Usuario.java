package br.com.frutasaocanuto.model;

import br.com.frutasaocanuto.model.enums.usuario.Permissao;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(unique = true)
    @NotBlank(message = "O valor de login não pode ser vazio")
    private String login;

    @Column()
    @NotBlank(message = "O valor de senha não pode ser vazio")
    private String senha;

    @Column()
    @Enumerated(EnumType.STRING)
    private Permissao permissoes = Permissao.user;

    public Usuario(Permissao permissoes, String senha, String login, int id_usuario) {
        this.permissoes = permissoes;
        this.senha = senha;
        this.login = login;
        this.id_usuario = id_usuario;
    }

    public Usuario(Permissao permissoes, String senha, String login) {
        this.permissoes = permissoes;
        this.senha = senha;
        this.login = login;
    }

    public Usuario() {

    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public @NotBlank(message = "O valor de login não pode ser vazio") String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank(message = "O valor de login não pode ser vazio") String login) {
        this.login = login;
    }

    public @NotBlank(message = "O valor de senha não pode ser vazio") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O valor de senha não pode ser vazio") String senha) {
        this.senha = senha;
    }

    public @NotBlank(message = "O valor de senha não pode ser vazio") Permissao getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(@NotBlank(message = "O valor de senha não pode ser vazio") Permissao permissoes) {
        this.permissoes = permissoes;
    }
}

