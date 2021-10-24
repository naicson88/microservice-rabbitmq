package com.naicson.consumerestoque.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import constantes.RabbitMQConstantes;
import dto.EstoqueDTO;

@Component
public class EstoqueConsumer {
	
	@RabbitListener(queues = RabbitMQConstantes.FILA_ESTOQUE)
	private void consumidor(EstoqueDTO estoque) {
		System.out.println(estoque.codigoProduto + ", " + estoque.quantidade);
		System.out.println("<----------------------------->");
	}
}
