package br.com.contato.app.repository;

import br.com.contato.app.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    Optional<ContatoEntity> findByCelular(String celular);
}
