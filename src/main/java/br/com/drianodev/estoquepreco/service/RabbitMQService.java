package br.com.drianodev.estoquepreco.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarMensagem(String nomeFila, Object mensagem) {
        try {
            String mensagemJson = this.objectMapper.writeValueAsString(mensagem);
            this.rabbitTemplate.convertAndSend(nomeFila, mensagemJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
