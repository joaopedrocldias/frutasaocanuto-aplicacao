package br.com.frutasaocanuto.controller;

import br.com.frutasaocanuto.model.Usuario;
import br.com.frutasaocanuto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public String listarUsuarios(@RequestParam(value = "login", required = false) String login, Model model) {

        List<Usuario> listaUsuarios;

        if (login != null && !login.isEmpty()) {
            // Se digitou algo, busca filtrado
            listaUsuarios = usuarioRepository.findByLoginContainingIgnoreCase(login);
        } else {
            // Se não digitou nada, busca todos
            listaUsuarios = usuarioRepository.findAll();
        }

        model.addAttribute("usuarios", listaUsuarios); // Lista para a tabela
        model.addAttribute("usuario", new Usuario());  // Objeto vazio para o formulário de cadastro

        model.addAttribute("termoPesquisado", login != null ? login : "");

        return "tela_usuario/usuario";
    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/editar")
    public String editar(Usuario usuario) {

        // Busca o login
        Usuario usuarioNoBanco = usuarioRepository.findByLogin(usuario.getLogin());

        // Verifica se o usuário existe
        if (usuarioNoBanco != null) {

            // Passa o ID do usuário que vai ser atualizado
            usuario.setId_usuario(usuarioNoBanco.getId_usuario());

            // Salva as alterações
            usuarioRepository.save(usuario);
        }

        return "redirect:/usuario";
    }

    @PostMapping("/deletar")
    public String deletar(Usuario usuario) {

        if (usuario.getLogin() != null || !usuario.getLogin().trim().isEmpty()) {

            usuarioRepository.deleteByLogin(usuario.getLogin());
        }

        return "redirect:/usuario";
    }

}
