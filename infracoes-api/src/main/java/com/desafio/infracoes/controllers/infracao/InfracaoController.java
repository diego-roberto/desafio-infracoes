package com.desafio.infracoes.controllers.infracao;

import com.desafio.infracoes.models.infracao.Infracao;
import com.desafio.infracoes.responses.ErrorResponse;
import com.desafio.infracoes.responses.SuccessResponse;
import com.desafio.infracoes.service.infracao.InfracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/infracoes")
public class InfracaoController {

    @Autowired
    private InfracaoService infracaoService;

    private final static String NOT_FOUND = "Infração não encontrada.";
    private final static String EMPTY = "Nenhuma Infração encontrada.";
    private final static String INVALID = "Atributo obrigatório faltando ou tipo de veículo inválido.";

    @GetMapping("/id/{id}")
    public ResponseEntity<?> index(@PathVariable("id") Long id) {
        Infracao infracao = infracaoService.findById(id);
        if (infracao != null) {
            return new SuccessResponse<Infracao>().handle(infracao, HttpStatus.OK);
        }
        return ErrorResponse.handle(new String[] {NOT_FOUND}, Infracao.class, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<Infracao> infracoes = infracaoService.findAll();
        if (!infracoes.isEmpty()) {
            return new SuccessResponse<List<Infracao>>().handle(infracoes, HttpStatus.OK);
        }
        return ErrorResponse.handle(new String[] {EMPTY}, Infracao.class, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Validated final Infracao cParams) {
        Infracao infracao = infracaoService.create(cParams);
        if (infracao != null) {
            return new SuccessResponse<Infracao>().handle(infracao, HttpStatus.CREATED);
        }
        return ErrorResponse.handle(new String[] {INVALID}, Infracao.class, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infracao> update(@RequestBody @Validated Infracao cParams) {
        Infracao infracao = infracaoService.update(cParams);
        return new SuccessResponse<Infracao>().handle(infracao, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable("id") long id) {
        Infracao infracao = infracaoService.findById(id);
        if (infracao != null) {
            infracaoService.delete(infracao);
            return new SuccessResponse<Infracao>().handle(infracao, HttpStatus.OK);
        }
        return ErrorResponse.handle(new String[] {NOT_FOUND}, Infracao.class, HttpStatus.NOT_FOUND);
    }

}
