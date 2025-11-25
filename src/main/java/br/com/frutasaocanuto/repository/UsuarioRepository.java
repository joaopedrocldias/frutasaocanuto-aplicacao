package br.com.frutasaocanuto.repository;

import br.com.frutasaocanuto.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Transactional
    void deleteByLogin(String login);

    @Transactional
    Usuario findByLogin(String login);

    List<Usuario> findByLoginContainingIgnoreCase(String login);
}
