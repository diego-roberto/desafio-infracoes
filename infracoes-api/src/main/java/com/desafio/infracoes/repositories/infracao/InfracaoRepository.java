package com.desafio.infracoes.repositories.infracao;

import com.desafio.infracoes.models.infracao.Infracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Long> {

    Optional<Infracao> findById(Long id);

}
