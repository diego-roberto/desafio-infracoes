package com.desafio.infracoes.service.infracao;

import com.desafio.infracoes.models.infracao.Infracao;
import com.desafio.infracoes.repositories.infracao.InfracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class InfracaoService {

    @Autowired
    private InfracaoRepository infracaoRepository;

    public List<Infracao> findAll() {
        return infracaoRepository.findAll();
    }

    public Infracao findById(Long id) {
        Optional<Infracao> infracao = infracaoRepository.findById(id);
        return infracao.orElse(null);
    }

    public Infracao create(Infracao infracao) {
        if (!isValidTipoVeiculo(infracao.getVeiculo())) {
            return null;
        }
        if (infracao.getDatahora() == null || infracao.getVelocidade() == null) {
            return null;
        }
        return infracaoRepository.save(infracao);
    }

    private boolean isValidTipoVeiculo(Infracao.TipoVeiculo tipoVeiculo) {
        try {
            Infracao.TipoVeiculo.valueOf(String.valueOf(tipoVeiculo));
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Infracao update(Infracao infracao) {
        return infracaoRepository.save(infracao);
    }

    public void delete(Infracao infracao) {
        infracaoRepository.delete(infracao);
    }

}
