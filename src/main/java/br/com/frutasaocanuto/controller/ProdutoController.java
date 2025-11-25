package br.com.frutasaocanuto.controller;

import br.com.frutasaocanuto.model.Produto;
import br.com.frutasaocanuto.model.Usuario;
import br.com.frutasaocanuto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarProdutos(@RequestParam(value = "nome", required = false) String nome, Model model){

        List<Produto> listaProdutos;

        if (nome != null && !nome.isEmpty()){
            listaProdutos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        } else {
            listaProdutos = produtoRepository.findAll();
        }

        model.addAttribute("produtos",listaProdutos);
        model.addAttribute("produto", new Produto());

        model.addAttribute("termoPesquisado", nome != null ? nome : "");

        return "tela_produtos/produtos";
    }

    @PostMapping("/salvar")
    public String salvar(Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @PostMapping("/editar")
    public String editar(Produto produto) {

        // Busca o login
        Produto produtoNoBanco = produtoRepository.findByNome(produto.getNome());

        // Verifica se o usuário existe
        if (produtoNoBanco != null) {

            // Passa o ID do usuário que vai ser atualizado
            produto.setId_produto(produtoNoBanco.getId_produto());

            // Salva as alterações
            produtoRepository.save(produto);
        }

        return "redirect:/produtos";
    }

    @PostMapping("/deletar")
    public String deletar(Produto produto) {

        if (produto.getNome() != null || !produto.getNome().trim().isEmpty()) {

            produtoRepository.deleteByNome(produto.getNome());
        }

        return "redirect:/produtos";
    }

}
