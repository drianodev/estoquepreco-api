package br.com.drianodev.estoquepreco.controller;

import br.com.drianodev.estoquepreco.constants.RabbitMQConstants;
import br.com.drianodev.estoquepreco.dto.PrecoDTO;
import br.com.drianodev.estoquepreco.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("preco")
public class PrecoController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alterarPreco(@RequestBody PrecoDTO precoDTO) {
        System.out.println("Codigo Preco = " + precoDTO.codigoPreco);

        this.rabbitMQService.enviarMensagem(RabbitMQConstants.FILA_ESTOQUE, precoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
