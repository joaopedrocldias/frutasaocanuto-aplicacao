package br.com.frutasaocanuto.repository;

import br.com.frutasaocanuto.model.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Transactional
    void deleteByNome(String nome);

    @Transactional
    Produto findByNome(String nome);

    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
