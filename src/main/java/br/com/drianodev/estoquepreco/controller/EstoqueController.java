package br.com.drianodev.estoquepreco.controller;

import constants.RabbitMQConstants;
import dto.EstoqueDTO;
import br.com.drianodev.estoquepreco.service.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alterarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        System.out.println("Codigo Produto = " + estoqueDTO.codigoProduto);

        this.rabbitMQService.enviarMensagem(RabbitMQConstants.FILA_ESTOQUE, estoqueDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
